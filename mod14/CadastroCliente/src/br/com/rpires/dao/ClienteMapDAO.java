package br.com.rpires.dao;

import br.com.rpires.domain.Cliente_2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rodrigo.pires
 */
public class ClienteMapDAO implements IClientDAO<Object> {

    private Map<Long, Cliente_2> map;

    public ClienteMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente_2 cliente) {
        if (this.map.containsKey(cliente.getCpf())) {
            return false;
        }
        this.map.put(cliente.getCpf(), cliente);
        return true;
    }

    public void excluir(Long cpf) {
        Cliente_2 clienteCadastrado = this.map.get(cpf);

        if (clienteCadastrado != null) {
            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
        }
    }

    @Override
    public void alterar(Cliente_2 cliente) {
        Cliente_2 clienteCadastrado = this.map.get(cliente.getCpf());
        if (clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
        }
    }

    public Cliente_2 consultar(Long cpf) {
        return this.map.get(cpf);
    }

    public Collection<Cliente_2> buscarTodos() {
        return this.map.values();
    }

	public Boolean cadastrar(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void excluir(Object valor) {
		// TODO Auto-generated method stub
		
	}

	public void alterar(Object entity) {
		// TODO Auto-generated method stub
		
	}

	public Cliente_2 consultar(Object valor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Class<Object> getTipoClasse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(long parseLong) {
		// TODO Auto-generated method stub
		
	}
}