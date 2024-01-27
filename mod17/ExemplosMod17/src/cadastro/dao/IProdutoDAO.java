package cadastro.dao;

import cadastro.dao.generic.IGenericDAO;
import cadastro.domain.Produto;

public interface IProdutoDAO extends IGenericDAO<Produto> {

    Boolean cadastrar(Produto persistente);

    // Métodos adicionais conforme necessário
}
