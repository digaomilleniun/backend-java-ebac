/**
 * 
 */
package br.com.rpires.domain;

import java.math.BigDecimal;

import anotacao.ColunaTabela;
import anotacao.Tabela;

/**
 * @author rodrigo.pires
 *
 */
@Tabela("TB_PRODUTO_QUANTIDADE")
public class ProdutoQuantidade {
	
	@ColunaTabela(dbName = "id", setJavaName = "setId")
	private Long id;

	//@ColunaTabela(dbName = "id", setJavaName = "setId")
	private Produto_4 produto;
	
	@ColunaTabela(dbName = "quantidade", setJavaName = "setQuantidade")
	private Integer quantidade;
	
	@ColunaTabela(dbName = "valor_total", setJavaName = "setValorTotal")
	private BigDecimal valorTotal;
	
	public ProdutoQuantidade() {
		this.quantidade = 0;
		this.valorTotal = BigDecimal.ZERO;
	}

	public Produto_4 getProduto() {
		return produto;
	}

	public void setProduto(Produto_4 produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void adicionar(Integer quantidade) {
		this.quantidade += quantidade;
		BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(quantidade));
		BigDecimal novoTotal = this.valorTotal.add(novoValor);
		this.valorTotal = novoTotal;
	}
	
	public void remover(Integer quantidade) {
		this.quantidade -= quantidade;
		BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(quantidade));
		this.valorTotal = this.valorTotal.subtract(novoValor);
	}
	
	
}
