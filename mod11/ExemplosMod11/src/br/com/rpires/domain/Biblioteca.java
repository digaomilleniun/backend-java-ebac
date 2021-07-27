package br.com.rpires.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rodrigo.pires
 */
public class Biblioteca {

    private Long codigo;

    private String nome;

    private String endereco;

    private Set<Livro> livros;

    public Biblioteca() {
        this.livros = new HashSet<>();
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Set<Livro> getLivros() {
        return livros;
    }

//    public void setLivros(Set<Livro> livros) {
//        this.livros = livros;
//    }

    public boolean addLivro(Livro livro) {
        return this.livros.add(livro);
    }

    public boolean removeLivro(Livro livro) {
        return this.livros.remove(livro);
    }
}
