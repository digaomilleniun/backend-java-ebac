package application;

import dominio.DepartamentoVendas;
import dominio.Produto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProdutoServiceTest {

    private ProdutoService produtoService;
    private Scanner scanner;

    @Before
    public void setUp() {
        produtoService = new ProdutoService();
        scanner = new Scanner(System.in);
    }

    @After
    public void tearDown() {
        produtoService.fecharConexao();
        scanner.close();
    }

    @Test
    public void testCRUDOperations() {
        // Simulando a entrada do usuário para criar um departamento
        System.out.print("Digite o nome do departamento: ");
        String nomeDepartamento = scanner.nextLine();

        DepartamentoVendas departamento = new DepartamentoVendas();
        departamento.setNome(nomeDepartamento);

        produtoService.cadastrarDepartamento(departamento);

        // Simulando a entrada do usuário para criar um produto
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();

        System.out.print("Digite o preço do produto: ");
        double precoProduto = scanner.nextDouble();

        Produto produto = new Produto();
        produto.setNome(nomeProduto);
        produto.setPreco(precoProduto);
        produto.setDepartamento(departamento);

        // Agora está cadastrando o produto, não o departamento
        produtoService.cadastrarProduto(produto);

        // Simule a busca de produtos por departamento
        List<Produto> produtosDoDepartamento = produtoService.buscarProdutosPorDepartamento(departamento.getId());

        // Verificações
        assertNotNull(produtosDoDepartamento);
        assertEquals(1, produtosDoDepartamento.size());
        Produto produtoEncontrado = produtosDoDepartamento.get(0);

        assertEquals(nomeProduto, produtoEncontrado.getNome());
        assertEquals(precoProduto, produtoEncontrado.getPreco(), 0.01);
        assertEquals(departamento.getId(), produtoEncontrado.getDepartamento().getId());
    }
}