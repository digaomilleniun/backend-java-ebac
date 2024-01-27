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

import br.com.rpires.domain.Produto_4;
import br.com.rpires.service.IProdutoService;

/**
 * @author rodrigo.pires
 *
 */
@Named
@ViewScoped
public class ProdutoController implements Serializable {

	private static final long serialVersionUID = 367088063926303823L;
	
	private Produto_4 produto;
	
	private Collection<Produto_4> produtos;
	
	@Inject
	private IProdutoService produtoService;
	
	private Boolean isUpdate;
	
	@PostConstruct
    public void init() {
		try {
			this.isUpdate = false;
			this.produto = new Produto_4();
			this.produtos = produtoService.buscarTodos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar os produtos"));
		}
	}
	
	public void cancel() {
		try {
			this.isUpdate = false;
			this.produto = new Produto_4();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
		}
		
    } 
	
	public void edit(Produto_4 produto) {
		try {
			this.isUpdate = true;
			this.produto = produto;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar editar o produto"));
		}
		
    } 
	
	public void delete(Produto_4 produto) {
		try {
			produtoService.excluir(produto);
			produtos.remove(produto);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar excluir o produto"));
		}
		
    } 
	
	public void add() {
		try {
			produtoService.cadastrar(produto);
			this.produtos = produtoService.buscarTodos();
			this.produto = new Produto_4();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar criar o produto"));
		}
		
        
    }

    public void update() {
    	try {
    		produtoService.alterar(this.produto);
			cancel();
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Produto Atualiado com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar o produto"));
		}
        
    }
    
    public String voltarTelaInicial() {
		return "/index.xhtml"; 
	}

	public Produto_4 getProduto() {
		return produto;
	}

	public void setProduto(Produto_4 produto) {
		this.produto = produto;
	}

	public Collection<Produto_4> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto_4> produtos) {
		this.produtos = produtos;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
    
    

}
