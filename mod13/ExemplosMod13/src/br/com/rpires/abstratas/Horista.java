package br.com.rpires.abstratas;

/**
 * @author rodrigo.pires
 */
public class Horista extends Empregado {

    private Double precoHora;

    private Double totalHoraTrabalhada;

    @Override
    public Double vencimento() {
        return precoHora*totalHoraTrabalhada;
    }

    public Double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(Double precoHora) {
        this.precoHora = precoHora;
    }

    public Double getTotalHoraTrabalhada() {
        return totalHoraTrabalhada;
    }

    public void setTotalHoraTrabalhada(Double totalHoraTrabalhada) {
        this.totalHoraTrabalhada = totalHoraTrabalhada;
    }
}
