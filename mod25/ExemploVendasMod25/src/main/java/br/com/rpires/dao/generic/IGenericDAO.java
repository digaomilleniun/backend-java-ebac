package br.com.rpires.dao.generic;

import br.com.rpires.Cliente;
import br.com.rpires.dao.Persistence;
import br.com.rpires.domain.Cliente_2;
import br.com.rpires.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author rodrigo.pires
 *
 * Interface genérica para métodos de CRUD(Create, Read, Update and Delete)
 */
public interface IGenericDAO <T extends Persistence, E extends Serializable> {

    /**
     * Método para cadastrar novos registro no banco de dados
     *
     * @param cliente a ser cadastrado
     * @return retorna verdadeiro para cadastrado e falso para não cadastrado
     */
    public Boolean cadastrar(Cliente_2 cliente) throws TipoChaveNaoEncontradaException;

    /**
     * Método para excluir um registro do banco de dados
     *
     * @param long1 chave única do dado a ser excluído
     * @return 
     */
    public Integer excluir(Long long1);

    /**
     *Método para alterar um registro no bando de dados.
     *
     * @param entity a ser atualizado
     */
    public void alterar(T entity) throws TipoChaveNaoEncontradaException;

    /**
     * Método para consultar um registro no banco de dados
     *
     * @param valor chave única do dado a ser consultado
     * @return
     */
    public Cliente_2 consultar(E valor);

    /**
     * Método que irá retornar todos os registros do banco de dados de uma determinado dado ou tabela
     *
     * @return Registros encontrados
     */
    public Collection<Cliente> buscarTodos();

	void atualiarDados(Cliente_2 entity, Cliente_2 entityCadastrado);

	void alterar(Object entity);

	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;
}
