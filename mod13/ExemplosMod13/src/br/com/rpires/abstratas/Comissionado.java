package br.com.rpires.abstratas;

/**
 * @author rodrigo.pires
 */
public class Comissionado extends Empregado {

    private Double totalVenda;

    private Double totalComissao;

    @Override
    public Double vencimento() {
        return totalVenda*totalComissao;
    }

    public Double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(Double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public Double getTotalComissao() {
        return totalComissao;
    }

    public void setTotalComissao(Double totalComissao) {
        this.totalComissao = totalComissao;
    }
}
