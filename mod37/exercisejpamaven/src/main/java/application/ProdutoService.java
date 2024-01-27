package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import dominio.DepartamentoVendas;
import dominio.Produto;
import java.util.List;

public class ProdutoService {

    private EntityManagerFactory entityManagerFactory;

    public ProdutoService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
    }

    public void cadastrarProduto(Produto produto) {
        EntityManager entityManager = criarEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(produto);
            transaction.commit();
            System.out.println("Produto cadastrado com sucesso.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void cadastrarDepartamento(DepartamentoVendas departamento) {
        EntityManager entityManager = criarEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(departamento);
            transaction.commit();
            System.out.println("Departamento cadastrado com sucesso.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void excluirProdutoPorId(long produtoId) {
        EntityManager entityManager = criarEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Produto produto = entityManager.find(Produto.class, produtoId);
            
            if (produto != null) {
                entityManager.remove(produto);
                transaction.commit();
                System.out.println("Produto excluído com sucesso.");
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void atualizarProduto(Produto produto) {
        EntityManager entityManager = criarEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Produto produtoExistente = entityManager.find(Produto.class, produto.getId());

            if (produtoExistente != null) {
                // Atualiza os campos desejados
                produtoExistente.setNome(produto.getNome());
                produtoExistente.setPreco(produto.getPreco());
                produtoExistente.setDepartamento(produto.getDepartamento());
                
                entityManager.merge(produtoExistente);
                transaction.commit();
                System.out.println("Produto atualizado com sucesso.");
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public List<Produto> buscarProdutosPorDepartamento(long departamentoId) {
        EntityManager entityManager = criarEntityManager();

        try {
            return entityManager
                    .createQuery("SELECT p FROM Produto p WHERE p.departamento.id = :departamentoId", Produto.class)
                    .setParameter("departamentoId", departamentoId)
                    .getResultList();
        } finally {
            entityManager.close();
        }
    }

    public DepartamentoVendas buscarDepartamentoPorId(long id) {
        EntityManager entityManager = criarEntityManager();

        try {
            return entityManager.find(DepartamentoVendas.class, id);
        } finally {
            entityManager.close();
        }
    }

    public void fecharConexao() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

    private EntityManager criarEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}