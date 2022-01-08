/**
 * 
 */
package br.com.rpires.domain.jpa;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author rodrigo.pires
 *
 */
@Entity
@Table(name = "TB_PRODUTO_QUANTIDADE")
public class ProdutoQuantidadeJpa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prod_qtd_seq")
	@SequenceGenerator(name="prod_qtd_seq", sequenceName="sq_prod_qtd", initialValue = 1, allocationSize = 1)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private ProdutoJpa produto;
	
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name = "valor_total", nullable = false)
	private BigDecimal valorTotal;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_venda_fk", 
		foreignKey = @ForeignKey(name = "fk_prod_qtd_venda"), 
		referencedColumnName = "id", nullable = false
	)
	private VendaJpa venda;
	
	public ProdutoQuantidadeJpa() {
		this.quantidade = 0;
		this.valorTotal = BigDecimal.ZERO;
	}

	public ProdutoJpa getProduto() {
		return produto;
	}

	public void setProduto(ProdutoJpa produto) {
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
	
	public VendaJpa getVenda() {
		return venda;
	}

	public void setVenda(VendaJpa venda) {
		this.venda = venda;
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
