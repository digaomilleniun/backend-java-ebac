package br.com.rpires.set;

import br.com.rpires.domain.Aluno1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Steve.Vaz
 */
public class ExemploHashSetAluno {

    private static Aluno1 e;

	public static void main(String args[]) {
        exemploListaSimples();
        exemploConsultando();
        exemploRemover();
    }

    private static void exemploRemover() {
        System.out.println("**** exemploRemover ****");
        Set<Aluno1> conjunto = new HashSet<Aluno1>();

        Aluno1 a = new Aluno1("João da Silva", "Linux básico", 0);
        Aluno1 b = new Aluno1("Antonio Sousa", "OpenOffice", 0);
        Aluno1 c = new Aluno1("Lúcia Ferreira", "Internet", 0);
        Aluno1 d = new Aluno1("Antonio Sousa", "OpenOffice", 10);
        setE(new Aluno1("Teste", "OpenOffice", 10));
        conjunto.add(a);
        conjunto.add(b);
        conjunto.add(c);
        conjunto.add(d);
        System.out.println(conjunto);

        conjunto.remove(a);
        System.out.println(conjunto);

        for (Aluno1 aluno : conjunto) {
            System.out.println(aluno);
        }
    }

    private static void exemploConsultando() {
        System.out.println("**** exemploConsultando ****");
        Set<Aluno1> conjunto = new HashSet<Aluno1>();

        Aluno1 a = new Aluno1("João da Silva", "Linux básico", 0);
        Aluno1 b = new Aluno1("Antonio Sousa", "OpenOffice", 0);
        Aluno1 c = new Aluno1("Lúcia Ferreira", "Internet", 0);
        Aluno1 d = new Aluno1("Antonio Sousa", "OpenOffice", 10);
        Aluno1 e = new Aluno1("Teste", "OpenOffice", 10);
        conjunto.add(a);
        conjunto.add(b);
        conjunto.add(c);
        conjunto.add(d);

        System.out.println(conjunto.contains(e));
    }

    /**
     * Para não repetir objetos na lista de alunos é necessário que a classe
     * Aluno implemente o equals e hashcode
     */
    private static void exemploListaSimples() {
        Set<Aluno1> conjunto = new HashSet<Aluno1>();

        Aluno1 a = new Aluno1("João da Silva", "Linux básico", 0);
        Aluno1 b = new Aluno1("Antonio Sousa", "OpenOffice", 0);
        Aluno1 c = new Aluno1("Lúcia Ferreira", "Internet", 0);
        Aluno1 d = new Aluno1("Antonio Sousa", "OpenOffice", 10);
        conjunto.add(a);
        conjunto.add(b);
        conjunto.add(c);
        conjunto.add(d);
        System.out.println(conjunto);
    }

	public static Aluno1 getE() {
		return e;
	}

	public static void setE(Aluno1 e) {
		ExemploHashSetAluno.e = e;
	}
}
