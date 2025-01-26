package model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class modelo {
    private final Connection connection;

    public modelo(Connection connection) {
        this.connection = connection;
    }

    // Método para adicionar cliente
    public int adicionarCliente(String nome, String cpf, String telefone) {
        String sql = "INSERT INTO clientes (nome, cpf, telefone) VALUES (?, ?, ?)";
        try (PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, nome);
            pst.setString(2, cpf);
            pst.setString(3, telefone);
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

    // Método para excluir todos os dados
    public void excluirTodosDados() {
        String sqlExcluirCotas = "DELETE FROM cotas";
        String sqlExcluirClientes = "DELETE FROM clientes";
        try (PreparedStatement pstExcluirCotas = connection.prepareStatement(sqlExcluirCotas);
             PreparedStatement pstExcluirClientes = connection.prepareStatement(sqlExcluirClientes)) {
            pstExcluirCotas.executeUpdate();
            pstExcluirClientes.executeUpdate();
            System.out.println("Todos os dados foram excluídos com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir os dados: " + e.getMessage());
        }
    }

    // Método para pesquisar clientes por nome
    public List<Object[]> pesquisarClientesPorNome(String nome) {
        List<Object[]> resultados = new ArrayList<>();
        String sql = "SELECT c.nome, c.cpf, co.numero_cota, co.id_cota " +
                     "FROM clientes c " +
                     "JOIN cotas co ON c.id_cliente = co.id_cliente " +
                     "WHERE c.nome LIKE ?";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, "%" + nome + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                resultados.add(new Object[] {
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("numero_cota"),
                    rs.getString("id_cota")
                });
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar clientes: " + e.getMessage());
        }
        return resultados;
    }
}
