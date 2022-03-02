/**
 * 
 */
package br.com.rpires.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import br.com.rpires.domain.Cliente;
import br.com.rpires.domain.Produto;
import br.com.rpires.domain.ProdutoQuantidade;
import br.com.rpires.domain.Venda;
import br.com.rpires.service.IClienteService;
import br.com.rpires.service.IProdutoService;
import br.com.rpires.service.IVendaService;

/**
 * @author rodrigo.pires
 *
 */
@Named
@ViewScoped
public class VendaController implements Serializable {

	private static final long serialVersionUID = -3508753726177740824L;
	
	private Venda venda;
	
	private Collection<Venda> vendas;
	
	@Inject
	private IVendaService vendaService;
	
	@Inject
	private IClienteService clienteService;
	
	@Inject
	private IProdutoService produtoService;
	
	private Boolean isUpdate;
	
	private LocalDate dataVenda;
	
	private Integer quantidadeProduto;
	
	private Set<ProdutoQuantidade> produtos;
	
	private Produto produtoSelecionado;
	
	private BigDecimal valorTotal; 
	
	@PostConstruct
    public void init() {
		try {
			this.isUpdate = false;
			this.venda = new Venda();
			this.produtos = new HashSet<>();
			this.vendas = vendaService.buscarTodos();
			this.valorTotal = BigDecimal.ZERO;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar listar as vendas"));
		}
	}
	
	public void cancel() {
		try {
			this.isUpdate = false;
			this.venda = new Venda();
			this.produtos = new HashSet<>();
			this.valorTotal = BigDecimal.ZERO;
			this.dataVenda = null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar ação"));
		}
		
    } 
	
	public void edit(Venda venda) {
		try {
			this.isUpdate = true;
			this.venda = this.vendaService.consultarComCollection(venda.getId());
			this.dataVenda = LocalDate.ofInstant(this.venda.getDataVenda(), ZoneId.systemDefault());
			this.produtos = this.venda.getProdutos();
			this.venda.recalcularValorTotalVenda();
			this.valorTotal = this.venda.getValorTotal();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar editar a venda"));
		}
		
    } 
	
	public void delete(Venda venda) {
		try {
			vendaService.cancelarVenda(venda);
			cancel();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cancelar a venda"));
		}
		
    } 
	
	public void finalizar(Venda venda) {
		try {
			vendaService.finalizarVenda(venda);
			cancel();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar finalizar a venda"));
		}
		
    } 
	
	public void add() {
		try {
			venda.setDataVenda(dataVenda.atStartOfDay(ZoneId.systemDefault()).toInstant());
			vendaService.cadastrar(venda);
			this.vendas = vendaService.buscarTodos();
			cancel();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar cadastrar a venda"));
		}
    }
	
	public void update() {
    	try {
    		vendaService.alterar(this.venda);
    		this.vendas = vendaService.buscarTodos();
			cancel();
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Venda atualiada com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao tentar atualizar a venda"));
		}
        
    }
	
	public void adicionarProduto() {
		Optional<ProdutoQuantidade> prodOp = 
				this.venda.getProdutos().stream().filter(prodF -> prodF.getProduto().getCodigo().equals(this.produtoSelecionado.getCodigo())).findFirst();

		if (prodOp.isPresent()) {
			ProdutoQuantidade prod = prodOp.get();
			prod.adicionar(this.quantidadeProduto);
		} else {
			ProdutoQuantidade prod = new ProdutoQuantidade();
			prod.setProduto(this.produtoSelecionado);
			prod.adicionar(this.quantidadeProduto);
			prod.setVenda(this.venda);
			this.venda.getProdutos().add(prod);
		}
		this.venda.recalcularValorTotalVenda();
		this.produtos = this.venda.getProdutos();
		this.valorTotal = this.venda.getValorTotal();
	}
	
	public void removerProduto() {
		Optional<ProdutoQuantidade> prodOp = 
				this.venda.getProdutos().stream().filter(prodF -> prodF.getProduto().getCodigo().equals(this.produtoSelecionado.getCodigo())).findFirst();

		if (prodOp.isPresent()) {
			ProdutoQuantidade prod = prodOp.get();
			prod.remover(this.quantidadeProduto);
			if (prod.getQuantidade() == 0 || prod.getQuantidade() < 0) {
				this.venda.getProdutos().remove(prod);
			}
			this.venda.recalcularValorTotalVenda();
			this.produtos = this.venda.getProdutos();
			this.valorTotal = this.venda.getValorTotal();
		}
		
	}
	
	public void removerProduto(ProdutoQuantidade produto) {
		
		this.venda.getProdutos().remove(produto);
		this.venda.recalcularValorTotalVenda();
		this.produtos = this.venda.getProdutos();
		this.valorTotal = this.venda.getValorTotal();
	}
	
	public void onRowEdit(RowEditEvent<ProdutoQuantidade> event) {
		ProdutoQuantidade prod = (ProdutoQuantidade) event.getObject();
		adicionarOuRemoverProduto(prod);
    }

    public void onRowCancel(RowEditEvent<ProdutoQuantidade> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject().getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void adicionarOuRemoverProduto(ProdutoQuantidade prod) {
    	if (prod.getQuantidade() != this.quantidadeProduto) {
    		int quantidade =  this.quantidadeProduto - prod.getQuantidade();
    		if (quantidade > 0) {
    			prod.adicionar(quantidade);
    		} else {
    			this.produtos.remove(prod);
    		}
    		this.valorTotal = BigDecimal.ZERO;
    		this.produtos.forEach(pro -> {
    			this.valorTotal = this.valorTotal.add(pro.getValorTotal());
    		});
    	}
    }
	
	public List<Cliente> filtrarClientes(String query) {
		return this.clienteService.filtrarClientes(query);
	}
	
	public List<Produto> filtrarProdutos(String query) {
		return this.produtoService.filtrarProdutos(query);
	}
    
    public String voltarTelaInicial() {
		return "/index.xhtml"; 
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Collection<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(Collection<Venda> vendas) {
		this.vendas = vendas;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Set<ProdutoQuantidade> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<ProdutoQuantidade> produtos) {
		this.produtos = produtos;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
    

}
