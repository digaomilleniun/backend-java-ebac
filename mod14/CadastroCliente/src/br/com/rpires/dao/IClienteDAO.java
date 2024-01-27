package br.com.rpires.dao;

import java.util.Collection;

import br.com.rpires.domain.Cliente_2;

public interface IClienteDAO<T> {

    int cadastrar(Cliente_2 cliente) throws Exception;

    Integer excluir(Cliente_2 clienteBD) throws Exception;

    void alterar(Cliente_2 cliente);

    Cliente_2 consultar(Object valor);

    Collection<Cliente_2> buscarTodos();

    Class<T> getTipoClasse();

	Boolean cadastrar(Object entity);

	void excluir(long parseLong);

	Cliente_2 consultar(Long cpf);

	void alterar(Object entity);
}
