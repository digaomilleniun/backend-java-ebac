package exercise_mod29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

	private static final String URL = "jdbc:postgresql://localhost:15432/postgres";
    private static final String USER = "rpires@admin.com";
    private static final String PASSWORD = "admin";

    public void cadastrarCliente(Cliente cliente) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO cliente (nome, email, telefone) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, cliente.getNome());
                preparedStatement.setString(2, cliente.getEmail());
                preparedStatement.setString(3, cliente.getTelefone());

                preparedStatement.executeUpdate();
            }
        }
    }

    public void excluirCliente(int clienteId) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM clientes WHERE cliente_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, clienteId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
