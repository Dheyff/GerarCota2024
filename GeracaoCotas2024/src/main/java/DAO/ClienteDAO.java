package dao;

import model.ClienteModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public int adicionarCliente(ClienteModel cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nome, cpf, telefone) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, cliente.getTelefone());
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // Retorna o ID gerado
            }
        }
        return -1;
    }

    public void excluirTodosClientes() throws SQLException {
        String sql = "DELETE FROM clientes";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.executeUpdate();
        }
    }

    public List<ClienteModel> buscarClientesPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE nome LIKE ?";
        List<ClienteModel> clientes = new ArrayList<>();
        try (Connection conn = Conexao.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, "%" + nome + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ClienteModel cliente = new ClienteModel();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }
}