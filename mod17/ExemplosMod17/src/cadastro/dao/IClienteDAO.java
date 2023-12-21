package cadastro.dao;

import cadastro.dao.generic.IGenericDAO;
import cadastro.domain.Cliente;

public interface IClienteDAO extends IGenericDAO<Cliente> {

    Boolean cadastrar(Cliente persistente);

    // Métodos adicionais conforme necessário
}

