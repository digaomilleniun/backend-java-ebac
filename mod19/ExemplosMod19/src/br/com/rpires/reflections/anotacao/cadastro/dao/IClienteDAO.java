package br.com.rpires.reflections.anotacao.cadastro.dao;

import br.com.rpires.reflections.anotacao.cadastro.dao.generic.IGenericDAO;
import br.com.rpires.reflections.anotacao.cadastro.domain.Cliente;
import br.com.rpires.reflections.anotacao.cadastro.domain.Produto;
import br.com.rpires.reflections.anotacao.cadastro.exception.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 * Interface que representa os dados de Cliente
 */
public interface IClienteDAO extends IGenericDAO<Cliente> {

	Class<Produto> getTipoClasse();

	<T> Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;


//    public Boolean cadastrar(Cliente cliente);
//
//    public void excluir(Long cpf);
//
//    public void alterar(Cliente cliente);
//
//    public Cliente consultar(Long cpf);
//
//    public Collection<Cliente> buscarTodos();
}
