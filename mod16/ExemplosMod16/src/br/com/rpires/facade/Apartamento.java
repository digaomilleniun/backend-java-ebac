package br.com.rpires.facade;

/**
 * @author rodrigo.pires
 */
public class Apartamento {

    private Long codigo;

    private String end;

    public Apartamento(Long codigo, String endereco) {
        this.codigo = codigo;
        this.end = endereco;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
