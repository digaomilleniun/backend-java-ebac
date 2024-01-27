package br.com.rpires.map;

import br.com.rpires.domain.Aluno1;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Steve.Vaz
 */
public class ExemploTreeMapAluno {

    public static void main(String[] args) {
        mapSimples();
        removendoDoMap();
        addSeNaoExistir();
        verificaSeExiste();
    }

    private static void verificaSeExiste() {
        System.out.println("****** verificaSeExiste ******");
        Map<String, Aluno1> mapa = new TreeMap<String, Aluno1>();

        Aluno1 a = new Aluno1("João da Silva", "Linux básico", 0);
        Aluno1 b = new Aluno1("Antonio Sousa", "OpenOffice", 0);
        Aluno1 c = new Aluno1("Lúcia Ferreira", "Internet", 0);
        Aluno1 d = new Aluno1("Benedito Silva", "OpenOffice", 0);
        mapa.put("João da Silva", a);
        mapa.put("Antonio Sousa", b);
        mapa.put("Lúcia Ferreira", c);
        mapa.put("Benedito Silva", d);
        System.out.println(mapa);

        if (mapa.containsKey("João da Silva")) {
            System.out.println("containsKey João da Silva = " + true);
        }

        if (mapa.containsValue(b)) {
            System.out.println("containsValue Aluno b = " + true);
        }

        Aluno1 e = new Aluno1("Novo Aluno", "OpenOffice", 0);
        System.out.println("containsValue Novo Aluno = " + mapa.containsValue(e));
        System.out.println("");
    }


    private static void addSeNaoExistir() {
        System.out.println("****** addSeNaoExistir ******");
        Map<String, Aluno1> mapa = new TreeMap<String, Aluno1>();

        Aluno1 a = new Aluno1("João da Silva", "Linux básico", 0);
        Aluno1 b = new Aluno1("Antonio Sousa", "OpenOffice", 0);
        Aluno1 c = new Aluno1("Lúcia Ferreira", "Internet", 0);
        Aluno1 d = new Aluno1("Benedito Silva", "OpenOffice", 0);
        mapa.put("João da Silva", a);
        mapa.put("Antonio Sousa", b);
        mapa.put("Lúcia Ferreira", c);
        mapa.put("Benedito Silva", d);
        mapa.put("Benedito Silva", d);
        System.out.println(mapa);
        System.out.println("");
    }

    private static void removendoDoMap() {
        System.out.println("****** removendoDoMap ******");
        Map<String, Aluno1> mapa = new TreeMap<String, Aluno1>();

        Aluno1 a = new Aluno1("João da Silva", "Linux básico", 0);
        Aluno1 b = new Aluno1("Antonio Sousa", "OpenOffice", 0);
        Aluno1 c = new Aluno1("Lúcia Ferreira", "Internet", 0);
        Aluno1 d = new Aluno1("Benedito Silva", "OpenOffice", 0);
        mapa.put("João da Silva", a);
        mapa.put("Antonio Sousa", b);
        mapa.put("Lúcia Ferreira", c);
        mapa.put("Benedito Silva", d);
        System.out.println(mapa);

        mapa.remove("Antonio Sousa");

        System.out.println(mapa);
        System.out.println("");
    }

    private static void mapSimples() {
        System.out.println("****** mapSimples ******");
        Map<String, Aluno1> mapa = new TreeMap<String, Aluno1>();

        Aluno1 a = new Aluno1("João da Silva", "Linux básico", 0);
        Aluno1 b = new Aluno1("Antonio Sousa", "OpenOffice", 0);
        Aluno1 c = new Aluno1("Lúcia Ferreira", "Internet", 0);
        Aluno1 d = new Aluno1("Benedito Silva", "OpenOffice", 0);
        mapa.put("João da Silva", a);
        mapa.put("Antonio Sousa", b);
        mapa.put("Lúcia Ferreira", c);
        mapa.put("Benedito Silva", d);
        System.out.println(mapa);
        System.out.println(mapa.get("Lúcia Ferreira"));

        Collection<Aluno1> alunos = mapa.values();
        for (Aluno1 e : alunos) {
            System.out.println(e);
        }
        System.out.println("");
    }
}
