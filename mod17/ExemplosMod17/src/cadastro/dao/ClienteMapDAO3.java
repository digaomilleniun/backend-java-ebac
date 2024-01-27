package cadastro.dao;

import cadastro.SingletonMap;
import cadastro.dao.generic.GenericDAO;
import cadastro.domain.Cliente;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rodrigo.pires
 */

public class ClienteMapDAO3 extends GenericDAO<Cliente> implements IClienteDAO {

    public ClienteMapDAO3() {
        super();
        @SuppressWarnings("unchecked")
		Map<Long, Cliente> mapaInterno =
                (Map<Long, Cliente>) SingletonMap.getInstance().getMap().get(getTipoClasse());
        if (mapaInterno == null) {
            mapaInterno = new HashMap<>();
            SingletonMap.getInstance().getMap().put(getTipoClasse(), mapaInterno);
        }
    }
    
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente cliente, Cliente entityCadastrado) {
        entityCadastrado.setNome(cliente.getNome());
        entityCadastrado.setTel(cliente.getTel());
        entityCadastrado.setNumero(cliente.getNumero());
        entityCadastrado.setEnd(cliente.getEnd());
        entityCadastrado.setCidade(cliente.getCidade());
        entityCadastrado.setEstado(cliente.getEstado());
    }

	@Override
	public void alterar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean cadastrar(Cliente persistente) {
		// TODO Auto-generated method stub
		return null;
	}


}
