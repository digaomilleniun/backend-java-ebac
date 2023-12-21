package exercise_mod29;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.rpires.Cliente;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest_1 {

	private static final String URL = "jdbc:postgresql://localhost:15432/cliente";
	private static final String USER = "rpires@admin.com";
	private static final String PASSWORD = "admin";

    private ClienteDAO_1 clienteDAO;

    @Before
    public void setUp() throws SQLException {
        clienteDAO = new ClienteDAO_1();
        criarTabelaCliente();
    }

    @After
    public void tearDown() throws SQLException {
        droparTabelaCliente();
    }

    @Test
    public void testCadastrarCliente() throws SQLException {
        Cliente cliente = new Cliente("Teste", "steve@gmail.com", "123456789", 4);
        clienteDAO.cadastrarCliente(cliente);

        // Verifica se o cliente foi cadastrado corretamente
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM cliente WHERE nome = 'Teste'";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    assertTrue(resultSet.next());
                    assertEquals("rpires@admin.com", resultSet.getString("email"));
                }
            }
        }
    }

    private void criarTabelaCliente() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "CREATE TABLE IF NOT EXISTS cliente (" +
                    "id SERIAL PRIMARY KEY," +
                    "nome VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "telefone VARCHAR(20)" +
                    ")";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.executeUpdate();
            }
        }
    }

    private void droparTabelaCliente() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DROP TABLE IF EXISTS cliente";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.executeUpdate();
            }
        }
    }
}
