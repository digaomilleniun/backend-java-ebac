package cadastro.dao;

import cadastro.dao.generic.IGenericDAO;
import cadastro.domain.Cliente;
import cadastro.domain.Persistente;

import java.util.Collection;

/**
 * @author rodrigo.pires
 *
 * Interface que representa os dados de Cliente
 */
public interface IClienteDAO extends IGenericDAO<Cliente> {

	Boolean cadastrar(Persistente persistente);

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
