/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rpires.dao;

import br.com.rpires.domain.Cliente_2;

import java.util.*;

/**
 *
 * @author rodrigo.pires
 */
public class ClienteMapDAO1 implements IClientDAO<Object> {
    
    private Map<Long, Cliente_2> map;
    
    public ClienteMapDAO1() {
        map = new TreeMap<>();
    }

    public Boolean cadastrar(Cliente_2 cliente) {
        if (map.containsKey(cliente.getCpf())) {
            return false;
        }
        
        map.put(cliente.getCpf(), cliente);
        return true;
    }

    public void excluir(Long cpf) {
        Cliente_2 clienteCadastrado = map.get(cpf);
        map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
    }

    public void alterar(Cliente_2 cliente) {
        Cliente_2 clienteCadastrado = map.get(cliente.getCpf());
        clienteCadastrado.setNome(cliente.getNome());
        clienteCadastrado.setTel(cliente.getTel());
        clienteCadastrado.setNumero(cliente.getNumero());
        clienteCadastrado.setEnd(cliente.getEnd());
        clienteCadastrado.setCidade(cliente.getCidade());
        clienteCadastrado.setEstado(cliente.getEstado());
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

	public void excluir(long parseLong) {
		// TODO Auto-generated method stub
		
	}

}
