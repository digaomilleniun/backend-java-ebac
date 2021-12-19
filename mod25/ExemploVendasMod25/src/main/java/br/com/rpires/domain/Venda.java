/**
 * 
 */
package br.com.rpires.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import anotacao.TipoChave;
import br.com.rpires.dao.Persistente;

/**
 * @author rodrigo.pires
 *
 */
public class Venda implements Persistente {
	
	public enum Status {
		CONCLUIDA, CANCELADA;
	}

	@TipoChave("getCodigo")
	private String codigo;
	
	private Cliente cliente;
	
	private Set<ProdutoQuantidade> produtos;
	
	private BigDecimal valorTotal;
	
	private Instant dataVenda;
	
	private Status status;
	
	public Venda() {
		produtos = new HashSet<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<ProdutoQuantidade> getProdutos() {
		return produtos;
	}

	public void adicionarProduto(Produto produto, Integer quantidade) {
		Optional<ProdutoQuantidade> op = 
				produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
		if (op.isPresent()) {
			ProdutoQuantidade produtpQtd = op.get();
			produtpQtd.adicionar(quantidade);
		} else {
			// Criar fabrica para criar ProdutoQuantidade
			ProdutoQuantidade prod = new ProdutoQuantidade();
			prod.setProduto(produto);
			prod.adicionar(quantidade);
			produtos.add(prod);
		}
		recalcularValorTotalVenda();
	}
	
	public void removerProduto(Produto produto, Integer quantidade) {
		Optional<ProdutoQuantidade> op = 
				produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
		
		if (op.isPresent()) {
			ProdutoQuantidade produtpQtd = op.get();
			produtpQtd.remover(quantidade);
			recalcularValorTotalVenda();
		}
	}
	
	private void recalcularValorTotalVenda() {
		//TODO corrigir calculo
		BigDecimal valorTotal = BigDecimal.ZERO;
		for (ProdutoQuantidade prod : this.produtos) {
			valorTotal = valorTotal.add(prod.getValorTotal());
		}
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public Instant getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Instant dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
