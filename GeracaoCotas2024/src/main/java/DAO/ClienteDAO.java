package DAO;

import java.sql.*;
import model.ClienteModel;


public class ClienteDAO {
    private final Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = Conexao.conectarBancoDeDados();
    }
      
    // Método para adicionar cliente
    public int adicionarCliente(ClienteModel clientes) {
        
       
        
        String sql = "INSERT INTO clientes (nome, cpf, telefone) VALUES (?, ?, ?)";
        
        try (PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, clientes.getNome());
            pst.setString(2, clientes.getCpf());
            pst.setString(3, clientes.getTelefone());
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);    
            }
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());
        }
        
        return -1;
    }
}
