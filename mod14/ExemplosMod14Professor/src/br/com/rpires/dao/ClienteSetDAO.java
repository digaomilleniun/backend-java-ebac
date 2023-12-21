/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rpires.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import br.com.rpires.domain.Cliente_2;

/**
 *
 * @author Steve Vaz
 */

public class ClienteSetDAO implements IClienteDAO2 {
    
    private Set<Cliente_2> set;
    
    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Cliente_2 cliente) {
        return this.set.add(cliente);
    }

    @Override
    public void excluir(Long cpf) {
        Cliente_2 clienteEncontrato = null;
        for (Cliente_2 cliente : this.set) {
            if (cliente.getCpf().equals(cpf)) {
                clienteEncontrato = cliente;
                break;
            }
        }
        
        if (clienteEncontrato != null) {
            this.set.remove(clienteEncontrato);
        }
    }

    @Override
    public void alterar(Cliente_2 cliente) {
        if (this.set.contains(cliente)) {
            for (Cliente_2 clienteCadastrado : this.set) {
                if (clienteCadastrado.equals(cliente)) {
                    clienteCadastrado.setNome(cliente.getNome());
                    clienteCadastrado.setTel(cliente.getTel());
                    clienteCadastrado.setNumero(cliente.getNumero());
                    clienteCadastrado.setEnd(cliente.getEnd());
                    clienteCadastrado.setCidade(cliente.getCidade());
                    clienteCadastrado.setEstado(cliente.getEstado());
                    break;
                }
            }
        }
    }

    @Override
    public Cliente_2 consultar(Long cpf) {
        for (Cliente_2 clienteCadastrado : this.set) {
             if (clienteCadastrado.getCpf().equals(cpf)) {
                 return clienteCadastrado;
             }
        }
        return null;
    }

    @Override
    public Collection<Cliente_2> buscarTodos() {
        return this.set;
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

	@Override
	public Class<Cliente_2> getTipoClasse() {
		// TODO Auto-generated method stub
		return null;
	}

}
