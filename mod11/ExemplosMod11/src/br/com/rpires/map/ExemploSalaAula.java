package br.com.rpires.map;

import br.com.rpires.domain.Aluno1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Steve.Vaz
 */
public class ExemploSalaAula {

    public static void main(String args[]) {
        Map<Integer, List<Aluno1>> listaSala = new HashMap<>();
        
        List<Aluno1> alunosSala1 = criarTurma("Sala 1",10);
        listaSala.put(1, alunosSala1);

        List<Aluno1> alunosSala2 = criarTurma("Sala 2",30);
        listaSala.put(2, alunosSala2);

        imprimirAlunosSala(listaSala.get(1));
    }

    private static List<Aluno1> criarTurma(String sala, int count) {
        List<Aluno1> alunos = new ArrayList<>();
        for (int i = 0; i< count; i++) {
            Aluno1 aluno = new Aluno1("Nome aluno " + i, "Curso" + i, i, sala);
            alunos.add(aluno);
        }
        return alunos;
    }

    private static void imprimirAlunosSala(List<Aluno1> alunos) {
        //for java 8 API stream
        System.out.println("for java 8 API stream");
        alunos.forEach(aluno->System.out.println("Nome: " + aluno.getNome() + " Sala: " + aluno.getSala()));
        System.out.println("");

        System.out.println("for java");
        for (Aluno1 aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome() + " Sala: " + aluno.getSala());
        }
        System.out.println("");

        System.out.println("for java com contador");
        for (int i = 0; i < alunos.size(); i++) {
            Aluno1 aluno = alunos.get(i);
            System.out.println("Nome: " + aluno.getNome() + " Sala: " + aluno.getSala());
        }
    }
}
