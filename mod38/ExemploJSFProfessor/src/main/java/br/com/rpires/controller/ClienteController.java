/**
 * 
 */
package br.com.rpires.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.graalvm.compiler.lir.asm.FrameContext;

import br.com.rpires.domain.Cliente_2;
import br.com.rpires.service.IClienteService;

/**
 * @author rodrigo.pires
 *
 */
@Named
@ViewScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 8030245985235567808L;
	
	private Cliente_2 cliente;
	
	private Collection<Cliente_2> clientes;
	
	@Inject
	private IClienteService clienteService;
	
	private Boolean isUpdate;
	
	@PostConstruct
    public void init() {
		try {
			this.isUpdate = false;
			this.cliente = new Cliente_2();
			this.clientes = clienteService.buscarTodos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os clientes"));
		}
	}
	
	public void cancel() {
		try {
			this.isUpdate = false;
			this.cliente = new Cliente_2();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
		}
		
    } 
	
	public void edit(Cliente_2 cliente) {
		try {
			this.isUpdate = true;
			this.cliente = cliente;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
		}
		
    } 
	
	public void delete(Cliente_2 cliente) {
		try {
			clienteService.excluir(cliente);
			clientes.remove(cliente);
		} catch (Exception e) {
			FrameContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o cliente"));
		}
		
    } 
	
	public void add() {
		try {
			clienteService.cadastrar(cliente);
			this.clientes = clienteService.buscarTodos();
			this.cliente = new Cliente_2();
		} catch (Exception e) {
			FrameContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o cliente"));
		}
		
        
    }

    public void update() {
    	try {
			clienteService.alterar(this.cliente);
			cancel();
			FrameContext.getCurrentInstance().addMessage("growl", new FacesMessage("Cliente Atualiado com sucesso"));
		} catch (Exception e) {
			FrameContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar o cliente"));
		}
        
    }

	public Collection<Cliente_2> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente_2> clientes) {
		this.clientes = clientes;
	}

	public Cliente_2 getCliente() {
		return cliente;
	}

	public void setCliente(Cliente_2 cliente) {
		this.cliente = cliente;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
}
