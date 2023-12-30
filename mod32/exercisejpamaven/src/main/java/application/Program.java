package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

import dominio.Pessoa;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Criação do EntityManagerFactory e do EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        // Cadastro de uma nova pessoa
        System.out.print("Digite o nome da pessoa:");
        String nome = scanner.nextLine();

        System.out.print("Digite o email da pessoa:");
        String email = scanner.nextLine();

        Pessoa novaPessoa = new Pessoa(null, nome, email);

        em.getTransaction().begin();
        em.persist(novaPessoa);
        em.getTransaction().commit();

        System.out.println("\nPessoa cadastrada com sucesso!");

        // Consulta de todas as pessoas
        System.out.println("\nLista de pessoas cadastradas:\n");
        em.createQuery("SELECT p FROM Pessoa p", Pessoa.class)
                .getResultList()
                .forEach(System.out::println);

        // Remoção de uma pessoa pelo ID
        System.out.print("\nDigite o ID da pessoa que deseja remover:");
        int idParaRemover = scanner.nextInt();
        Pessoa pessoaParaRemover = em.find(Pessoa.class, idParaRemover);

        if (pessoaParaRemover != null) {
            em.getTransaction().begin();
            em.remove(pessoaParaRemover);
            em.getTransaction().commit();
            System.out.println("Pessoa removida com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada.");
        }

        // Atualização de uma pessoa pelo ID
        System.out.print("Digite o ID da pessoa que deseja atualizar:");
        int idParaAtualizar = scanner.nextInt();
        Pessoa pessoaParaAtualizar = em.find(Pessoa.class, idParaAtualizar);

        if (pessoaParaAtualizar != null) {
            scanner.nextLine(); // Consumir a quebra de linha pendente

            System.out.print("Digite o novo nome da pessoa:");
            String novoNome = scanner.nextLine();

            System.out.print("Digite o novo email da pessoa:");
            String novoEmail = scanner.nextLine();

            em.getTransaction().begin();
            pessoaParaAtualizar.setNome(novoNome);
            pessoaParaAtualizar.setEmail(novoEmail);
            em.getTransaction().commit();

            System.out.println("Pessoa atualizada com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada.");
        }

        // Fechamento do EntityManager e do EntityManagerFactory
        em.close();
        emf.close();

        scanner.close();
    }
}
