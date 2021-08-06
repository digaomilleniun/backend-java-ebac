package br.com.rpires.dao;

import br.com.rpires.domain.Cliente;

import java.util.Collection;

/**
 * @author rodrigo.pires
 */
public interface IClienteDAO {

    public Boolean cadastrar(Cliente cliente);

    public void excluir(Long cpf);

    public void alterar(Cliente cliente);

    public Cliente consultar(Long cpf);

    public Collection<Cliente> buscarTodos();
}
