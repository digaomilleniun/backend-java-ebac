package br.com.rpires.agregacao;

/**
 * @author rodrigo.pires
 */
public class Comprador {

    private String nome;

    private Double verba;

    public Comprador(String nome, double verba) {
        this.nome = nome;
        this.verba = verba;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getVerba() {
        return verba;
    }

    public void setVerba(Double verba) {
        this.verba = verba;
    }

    public void comprar() {
        System.out.println("Comprar");
    }
}
