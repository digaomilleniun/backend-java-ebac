package br.com.rpires.Composicao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rodrigo.pires
 */
public class Banco {

    private Long codigo;

    private String nome;

    private Set<ContaCorrente> contasCorrentes;

    private Set<ContaPoupanca> contasPoupancas;

    public Banco() {
        this.contasCorrentes = new HashSet<>();
        this.contasPoupancas = new HashSet<>();
    }

    public void add(ContaCorrente cc) {
        this.contasCorrentes.add(cc);
    }

    public void add(ContaPoupanca cp) {
        this.contasPoupancas.add(cp);
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
