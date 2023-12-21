package cadastro.dao.generic;

import java.util.Collection;
import java.util.Map;

import cadastro.SingletonMap;
import cadastro.domain.Cliente;
import cadastro.domain.Persistente;
import cadastro.domain.Produto;

/**
 * @author rodrigo.pires
 *
 * Classe genérica que implementa interface genérica com os métodos de CRUD
 */
public abstract class GenericDAO<T extends Persistente> implements IGenericDAO<T> {

    //protected Map<Class, Map<Long, T>> map = new HashMap<>();

    /**
     * Necessário utilizar Singleton para ter apenas um MAP no sistema
     */
    private SingletonMap singletonMap;

    public Class<Cliente> getTipoClasse() {
		return null;
	}
    
    public abstract void atualiarDados(T entity, T entityCadastrado);

    public GenericDAO() {
        this.singletonMap = SingletonMap.getInstance();
    }

    @Override
    public Boolean cadastrar(T entity) {
        //Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        Map<Long, T> mapaInterno = extracted();
        if (mapaInterno.containsKey(entity.getCodigo())) {
            return false;
        }
        mapaInterno.put(entity.getCodigo(), entity);
        return true;
    }

    @Override
    public void excluir(Long valor) {
        //Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        Map<Long, T> mapaInterno = extracted();
        T objetoCadastrado = mapaInterno.get(valor);
        if (objetoCadastrado != null) {
            mapaInterno.remove(valor, objetoCadastrado);
        }
    }

    @Override
    public void alterar(T entity) {
        //Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        Map<Long, T> mapaInterno = extracted();
        T objetoCadastrado = mapaInterno.get(entity.getCodigo());
        if (objetoCadastrado != null) {
            atualiarDados(entity, objetoCadastrado);
        }
    }

    @Override
    public T consultar(Long valor) {
        //Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        Map<Long, T> mapaInterno = extracted();
        return mapaInterno.get(valor);
    }

    @Override
    public Collection<T> buscarTodos() {
        //Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        Map<Long, T> mapaInterno = extracted();
        return mapaInterno.values();
    }

	@SuppressWarnings("unchecked")
	private Map<Long, T> extracted() {
		return (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
	}

	public abstract Boolean cadastrar(Cliente persistente);

	public void atualizarDados(Produto entity, Produto entityCadastrado) {
		// TODO Auto-generated method stub
		
	}

}
