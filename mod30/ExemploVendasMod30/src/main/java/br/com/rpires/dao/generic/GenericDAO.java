package br.com.rpires.dao.generic;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import anotacao.ColunaTabela;
import anotacao.Tabela;
import anotacao.TipoChave;
import br.com.rpires.dao.Persistente;
import br.com.rpires.dao.generic.jdbc.ConnectionFactory;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;
import br.com.rpires.exceptions.TipoElementoNaoConhecidoException;

/**
 * @author rodrigo.pires
 *
 * Classe genérica que implementa interface genérica com os métodos de CRUD
 */
public abstract class GenericDAO<T extends Persistente, E extends Serializable> implements IGenericDAO<T,E> {


    public abstract Class<T> getTipoClasse();

    public abstract void atualiarDados(T entity, T entityCadastrado);
    
    protected abstract String getQueryInsercao();
    
    protected abstract String getQueryExclusao();
    
    protected abstract String getQueryAtualizacao();
    
    protected abstract void setParametrosQueryInsercao(PreparedStatement stmInsert, T entity) throws SQLException;
    
    protected abstract void setParametrosQueryExclusao(PreparedStatement stmDelete, E valor) throws SQLException;
    
    protected abstract void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, T entity) throws SQLException;
    
    protected abstract void setParametrosQuerySelect(PreparedStatement stmUpdate, E valor) throws SQLException;

    public GenericDAO() {
        
    }

    public E getChave(T entity) throws TipoChaveNaoEncontradaException {
        Field[] fields = entity.getClass().getDeclaredFields();
        E returnValue = null;
        for (Field field : fields) {
            if (field.isAnnotationPresent(TipoChave.class)) {
                TipoChave tipoChave = field.getAnnotation(TipoChave.class);
                String nomeMetodo = tipoChave.value();
                try {
                    Method method = entity.getClass().getMethod(nomeMetodo);
                    returnValue = (E) method.invoke(entity);
                    return returnValue;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    //Criar exception de negócio TipoChaveNaoEncontradaException
                    e.printStackTrace();
                    throw new TipoChaveNaoEncontradaException("Chave principal do objeto " + entity.getClass() + " não encontrada", e);
                }
            }
        }
        if (returnValue == null) {
            String msg = "Chave principal do objeto " + entity.getClass() + " não encontrada";
            System.out.println("**** ERRO ****" + msg);
            throw new TipoChaveNaoEncontradaException(msg);
        }
        return null;
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
    	Connection connection = null;
    	PreparedStatement stm = null;
    	try {
    		connection = getConnection();
			stm = connection.prepareStatement(getQueryInsercao(), Statement.RETURN_GENERATED_KEYS);
			setParametrosQueryInsercao(stm, entity);
			int rowsAffected = stm.executeUpdate();

			if(rowsAffected > 0) {
				try (ResultSet rs = stm.getGeneratedKeys()){
					if (rs.next()) {
						Persistente per = (Persistente) entity;
						per.setId(rs.getLong(1));
					}
				}
				return true;
			}
			
		} catch (SQLException e) {
			throw new DAOException("ERRO CADASTRANDO OBJETO ", e);
		} finally {
			closeConnection(connection, stm, null);
		}
		return false;
    }


    @Override
    public void excluir(E valor) throws DAOException {
    	Connection connection = getConnection();
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(getQueryExclusao());
			setParametrosQueryExclusao(stm, valor);
			int rowsAffected = stm.executeUpdate();
			
		} catch (SQLException e) {
			throw new DAOException("ERRO EXCLUINDO OBJETO ", e);
		} finally {
			closeConnection(connection, stm, null);
		}
		
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {

    	Connection connection = getConnection();
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(getQueryAtualizacao());
			setParametrosQueryAtualizacao(stm, entity);
			int rowsAffected = stm.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("ERRO ALTERANDO OBJETO ", e);
		} finally {
			closeConnection(connection, stm, null);
		}
    	
    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
    	try {
    		validarMaisDeUmRegistro(valor);
    		Connection connection = getConnection();
			PreparedStatement stm = connection.prepareStatement("SELECT * FROM " + getTableName() + " WHERE " + getNomeCampoChave(getTipoClasse()) + " = ?");
			setParametrosQuerySelect(stm, valor);
			ResultSet rs = stm.executeQuery();
		    if (rs.next()) {
		    	T entity = getTipoClasse().getConstructor(null).newInstance(null);
		    	Field[] fields = entity.getClass().getDeclaredFields();
		        for (Field field : fields) {
		        	if (field.isAnnotationPresent(ColunaTabela.class)) {
		        		ColunaTabela coluna = field.getAnnotation(ColunaTabela.class);
		                String dbName = coluna.dbName();
		                String javaSetName = coluna.setJavaName();
		                Class<?> classField = field.getType();
		        		try {
		                    Method method = entity.getClass().getMethod(javaSetName, classField);
		                    setValueByType(entity, method, classField, rs, dbName);
		                    
		                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
		                	throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
		                } catch (TipoElementoNaoConhecidoException e) {
		                	throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
						}
		        	}
		        }
		        return entity;
		    }
		    
		} catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | TipoChaveNaoEncontradaException e) {
			throw new DAOException("ERRO CONSULTANDO OBJETO ", e);
		} 
    	return null;
    }
    
    public String getNomeCampoChave(Class clazz) throws TipoChaveNaoEncontradaException {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
        	 if (field.isAnnotationPresent(TipoChave.class) 
        			 && field.isAnnotationPresent(ColunaTabela.class)) {
        		 ColunaTabela coluna = field.getAnnotation(ColunaTabela.class);
        		 return coluna.dbName();
        	 }
        }
        
        return null;
    }
    
    private void setValueByType(T entity, Method method, Class<?> classField, ResultSet rs, String fieldName) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException, TipoElementoNaoConhecidoException {
    	
    	if (classField.equals(Integer.class)) {
			Integer val = rs.getInt(fieldName);
			method.invoke(entity, val);
		} else if (classField.equals(Long.class)) {
			Long val = rs.getLong(fieldName);
			method.invoke(entity, val);
		} else if (classField.equals(Double.class)) {
			Double val =  rs.getDouble(fieldName);
			method.invoke(entity, val);
		} else if (classField.equals(Short.class)) {
			Short val =  rs.getShort(fieldName);
			method.invoke(entity, val);
		} else if (classField.equals(BigDecimal.class)) {
			BigDecimal val =  rs.getBigDecimal(fieldName);
			method.invoke(entity, val);
		} else if (classField.equals(String.class)) {
			String val =  rs.getString(fieldName);
			method.invoke(entity, val);
		} else {
			throw new TipoElementoNaoConhecidoException("TIPO DE CLASSE NÃO CONHECIDO: " + classField);
		}
    	
	}

	private Object getValueByType(Class<?> typeField, ResultSet rs, String fieldName) throws SQLException, TipoElementoNaoConhecidoException {
		if (typeField.equals(Integer.TYPE)) {
			return rs.getInt(fieldName);
		} else if (typeField.equals(Long.TYPE)) {
			return rs.getLong(fieldName);
		} else if (typeField.equals(Double.TYPE)) {
			return rs.getDouble(fieldName);
		} else if (typeField.equals(Short.TYPE)) {
			return rs.getShort(fieldName);
		} else if (typeField.equals(BigDecimal.class)) {
			return rs.getBigDecimal(fieldName);
		} else if (typeField.equals(String.class)) {
			return rs.getString(fieldName);
		} else {
			throw new TipoElementoNaoConhecidoException("TIPO DE CLASSE NÃO CONHECIDO: " + typeField);
		}
	}

	private Long validarMaisDeUmRegistro(E valor) throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
    	Connection connection = getConnection();
		PreparedStatement stm = null;
		ResultSet rs = null;
		Long count = null;
		try {
			stm = connection.prepareStatement("SELECT count(*) FROM " + getTableName() + " WHERE " + getNomeCampoChave(getTipoClasse()) + " = ?");
			setParametrosQuerySelect(stm, valor);
			rs = stm.executeQuery();
			if (rs.next()) {
				count = rs.getLong(1);
				if (count > 1) {
					throw new MaisDeUmRegistroException("ENCONTRADO MAIS DE UM REGISTRO DE " + getTableName());
				}
			}
			
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection, stm, rs);
		}
		return count;
    }

	protected void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

    private String getTableName() throws TableException {
    	if (getTipoClasse().isAnnotationPresent(Tabela.class)) {
    		Tabela table = getTipoClasse().getAnnotation(Tabela.class);
    		return table.value();
    	}else {
    		throw new TableException("TABELA NO TIPO " + getTipoClasse().getName() + " NÃO FOI ENCONTRADA");
    	}
	}

	@Override
    public Collection<T> buscarTodos() throws DAOException {
		List<T> list = new ArrayList<>();
		Connection connection = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
        try {
		
			connection = getConnection();
			stm = connection.prepareStatement("SELECT * FROM " + getTableName());
			rs = stm.executeQuery();
		    while (rs.next()) {
		    	T entity = getTipoClasse().getConstructor(null).newInstance(null);
		    	Field[] fields = entity.getClass().getDeclaredFields();
		        for (Field field : fields) {
		        	if (field.isAnnotationPresent(ColunaTabela.class)) {
		        		ColunaTabela coluna = field.getAnnotation(ColunaTabela.class);
		                String dbName = coluna.dbName();
		                String javaSetName = coluna.setJavaName();
		                Class<?> classField = field.getType();
		        		try {
		                    Method method = entity.getClass().getMethod(javaSetName, classField);
		                    setValueByType(entity, method, classField, rs, dbName);
		                    
		                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
		                	throw new DAOException("ERRO LISTANDO OBJETOS ", e);
		                } catch (TipoElementoNaoConhecidoException e) {
		                	throw new DAOException("ERRO LISTANDO OBJETOS ", e);
						}
		        	}
		        }
		        list.add(entity);
		        
		    }
	    
		} catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | TableException e) {
			throw new DAOException("ERRO LISTANDO OBJETOS ", e);
		} finally {
			closeConnection(connection, stm, rs);
		}
		return list;
    }
	
	protected Connection getConnection() throws DAOException {
		try {
			return ConnectionFactory.getConnection();
		} catch (SQLException e) {
			throw new DAOException("ERRO ABRINDO CONEXAO COM O BANCO DE DADOS ", e);
		}
	}
}
