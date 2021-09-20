package br.com.rpires.reflections.anotacao.cadastro.dao;

import br.com.rpires.reflections.anotacao.cadastro.SingletonMap;
import br.com.rpires.reflections.anotacao.cadastro.dao.generic.GenericDAO;
import br.com.rpires.reflections.anotacao.cadastro.domain.Cliente;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rodrigo.pires
 */
public class ClienteMapDAO extends GenericDAO<Cliente> implements IClienteDAO {

    public ClienteMapDAO() {
        super();
        Map<Long, Cliente> mapaInterno =
                (Map<Long, Cliente>) SingletonMap.getInstance().getMap().get(getTipoClasse());
        if (mapaInterno == null) {
            mapaInterno = new HashMap<>();
            SingletonMap.getInstance().getMap().put(getTipoClasse(), mapaInterno);
        }
    }

    @Override
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

}
