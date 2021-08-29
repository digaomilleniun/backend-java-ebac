package cadastro.dao.generic;

import cadastro.domain.Persistente;
import cadastro.domain.Produto;

import java.util.Collection;

/**
 * @author rodrigo.pires
 */
public interface IGenericDAO <T extends Persistente> {

    public Boolean cadastrar(T entity);

    public void excluir(Long valor);

    public void alterar(T entity);

    public T consultar(Long valor);

    public Collection<T> buscarTodos();
}
