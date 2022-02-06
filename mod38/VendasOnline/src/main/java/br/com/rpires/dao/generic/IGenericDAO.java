/**
 * 
 */
package br.com.rpires.dao.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.rpires.domain.Persistente;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 * Interface genérica para métodos de CRUD(Create, Read, Update and Delete)
 */
public interface IGenericDAO <T extends Persistente, E extends Serializable> {

	/**
     * Método para cadastrar novos registro no banco de dados
     *
     * @param entity a ser cadastrado
     * @return retorna o objeto salvo
     * @throws TipoChaveNaoEncontradaException
	 * @throws DAOException
     */
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para excluir um registro do banco de dados
     *
     * @param entity a ser cadastrado
	 * @throws DAOException
     */
    public void excluir(T entity) throws DAOException;

    /**
     *Método para alterar um registro no bando de dados.
     *
     * @param entity a ser atualizado
     * @return retorna o objeto salvo
     * @throws TipoChaveNaoEncontradaException
	 * @throws DAOException
     */
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para consultar um registro no banco de dados
     *
     * @param id chave única do dado a ser consultado
     * @return
     * @throws MaisDeUmRegistroException 
     * @throws TableException 
     */
    public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException;

    /**
     * Método que irá retornar todos os registros do banco de dados de uma determinado dado ou tabela
     *
     * @return Registros encontrados
     * @throws DAOException 
     */
    public Collection<T> buscarTodos() throws DAOException;
}
