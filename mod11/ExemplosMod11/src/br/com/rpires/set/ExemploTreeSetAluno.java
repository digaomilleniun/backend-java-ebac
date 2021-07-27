package br.com.rpires.set;

import br.com.rpires.domain.Aluno;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author rodrigo.pires
 */
public class ExemploTreeSetAluno {

    public static void main(String args[]) {
        exemploListaSimples();
    }

    /**
     * Para não repetir objetos na lista de alunos é necessário que a classe
     * Aluno implemente a classe Comparable
     * Tem ordem natural dos objetos
     */
    private static void exemploListaSimples() {
        Set<Aluno> conjunto = new TreeSet<>();

        Aluno a = new Aluno("João da Silva", "Linux básico", 0);
        Aluno b = new Aluno("Antonio Sousa", "OpenOffice", 0);
        Aluno c = new Aluno("Lúcia Ferreira", "Internet", 0);
        Aluno d = new Aluno("Antonio Sousa", "OpenOffice", 0);
        conjunto.add(a);
        conjunto.add(b);
        conjunto.add(c);
        conjunto.add(d);
        System.out.println(conjunto);
    }
}
