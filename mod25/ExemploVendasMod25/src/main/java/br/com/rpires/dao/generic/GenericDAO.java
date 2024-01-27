package br.com.rpires.dao.generic;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import anotacao.TipoChave;
import br.com.rpires.dao.Persistence;
import br.com.rpires.domain.Cliente_2;
import br.com.rpires.domain.Produto;
import br.com.rpires.domain.Produto_4;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 * Classe genérica que implementa interface genérica com os métodos de CRUD
 */
public abstract class GenericDAO<T extends Persistence, E extends Serializable> implements IGenericDAO<T,E> {

    //protected Map<Class, Map<Long, T>> map = new HashMap<>();

    /**
     * Necessário utilizar Singleton para ter apenas um MAP no sistema
     */
    private SingletonMap singletonMap;

    public abstract Class<Produto> getTipoClasse();

    public abstract void atualiarDados(T entity, T entityCadastrado);

    public GenericDAO() {
        this.singletonMap = SingletonMap.getInstance();
    }

    @SuppressWarnings({ "unchecked", "unused" })
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
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
        //Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        Map<E, T> mapaInterno = getMapa();
        E chave = getChave(entity);
        if (mapaInterno.containsKey(chave)) {
            return false;
        }

        mapaInterno.put(chave, entity);
        return true;
    }

	private Map<E, T> getMapa() {
		@SuppressWarnings("unchecked")
		Map<E, T> mapaInterno = (Map<E, T>) this.singletonMap.getMap().get(getTipoClasse());
		if (mapaInterno == null) {
			mapaInterno = new HashMap<>();
			this.singletonMap.getMap().put(getTipoClasse(), mapaInterno);
		}
		return mapaInterno;
	}

    public Integer excluir(E valor) {
        //Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        Map<E, T> mapaInterno = getMapa();
        T objetoCadastrado = mapaInterno.get(valor);
        if (objetoCadastrado != null) {
            mapaInterno.remove(valor, objetoCadastrado);
        }
		return null;
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException {
        Map<E, T> mapaInterno = getMapa();
        E chave = getChave(entity);
        T objetoCadastrado = mapaInterno.get(chave);
        if (objetoCadastrado != null) {
            atualiarDados(entity, objetoCadastrado);
        }
    }

    @Override
    public Cliente_2 consultar(E valor) {
        //Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        Map<E, T> mapaInterno = getMapa();
        return (Cliente_2) mapaInterno.get(valor);
    }

    @Override
    public Collection<T> buscarTodos() {
        Map<E, T> mapaInterno = getMapa();
        return mapaInterno.values();
    }

    protected abstract String getQueryInsercao();

    protected abstract void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto entity) throws SQLException;

    protected abstract void setParametrosQueryInsercao(PreparedStatement stmInsert, Cliente_2 entity) throws SQLException;

    protected abstract String getQueryExclusao();

    protected abstract void setParametrosQueryExclusao(PreparedStatement stmExclusao, String valor) throws SQLException;

    protected abstract void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long valor) throws SQLException;

    protected abstract String getQueryAtualizacao();

    protected abstract void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto_4 entity) throws SQLException;

    protected abstract void setParametrosQuerySelect(PreparedStatement stmExclusao, String valor) throws SQLException;

    protected abstract void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Cliente_2 entity) throws SQLException;

    protected abstract void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException;

	protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
