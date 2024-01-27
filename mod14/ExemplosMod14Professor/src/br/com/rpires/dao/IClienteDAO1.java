/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rpires.dao;

import br.com.rpires.domain.Cliente_2;
import java.util.Collection;

/**
 *
 * @author rodrigo.pires
 */
public interface IClienteDAO1 {
    
    public Boolean cadastrar(Cliente_2 cliente);
    
    public void excluir(Long cpf);
    
    public void alterar(Cliente_2 cliente);
    
    public Cliente_2 consultar(Long cpf);

    public Collection<Cliente_2> buscarTodos();
}
