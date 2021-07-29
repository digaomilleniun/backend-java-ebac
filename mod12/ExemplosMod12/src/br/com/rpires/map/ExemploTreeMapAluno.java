package br.com.rpires.map;

import br.com.rpires.domain.Aluno;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author rodrigo.pires
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
        Map<String, Aluno> mapa = new TreeMap<String, Aluno>();

        Aluno a = new Aluno("João da Silva", "Linux básico", 0);
        Aluno b = new Aluno("Antonio Sousa", "OpenOffice", 0);
        Aluno c = new Aluno("Lúcia Ferreira", "Internet", 0);
        Aluno d = new Aluno("Benedito Silva", "OpenOffice", 0);
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

        Aluno e = new Aluno("Novo Aluno", "OpenOffice", 0);
        System.out.println("containsValue Novo Aluno = " + mapa.containsValue(e));
        System.out.println("");
    }


    private static void addSeNaoExistir() {
        System.out.println("****** addSeNaoExistir ******");
        Map<String, Aluno> mapa = new TreeMap<String, Aluno>();

        Aluno a = new Aluno("João da Silva", "Linux básico", 0);
        Aluno b = new Aluno("Antonio Sousa", "OpenOffice", 0);
        Aluno c = new Aluno("Lúcia Ferreira", "Internet", 0);
        Aluno d = new Aluno("Benedito Silva", "OpenOffice", 0);
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
        Map<String, Aluno> mapa = new TreeMap<String, Aluno>();

        Aluno a = new Aluno("João da Silva", "Linux básico", 0);
        Aluno b = new Aluno("Antonio Sousa", "OpenOffice", 0);
        Aluno c = new Aluno("Lúcia Ferreira", "Internet", 0);
        Aluno d = new Aluno("Benedito Silva", "OpenOffice", 0);
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
        Map<String, Aluno> mapa = new TreeMap<String, Aluno>();

        Aluno a = new Aluno("João da Silva", "Linux básico", 0);
        Aluno b = new Aluno("Antonio Sousa", "OpenOffice", 0);
        Aluno c = new Aluno("Lúcia Ferreira", "Internet", 0);
        Aluno d = new Aluno("Benedito Silva", "OpenOffice", 0);
        mapa.put("João da Silva", a);
        mapa.put("Antonio Sousa", b);
        mapa.put("Lúcia Ferreira", c);
        mapa.put("Benedito Silva", d);
        System.out.println(mapa);
        System.out.println(mapa.get("Lúcia Ferreira"));

        Collection<Aluno> alunos = mapa.values();
        for (Aluno e : alunos) {
            System.out.println(e);
        }
        System.out.println("");
    }
}
