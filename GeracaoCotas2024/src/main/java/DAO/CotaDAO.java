package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CotaDAO {

    /**
     * Carrega as cotas já existentes no banco de dados.
     *
     * @return Lista de números de cotas existentes.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public List<Integer> carregarCotasExistentes() throws SQLException {
        String sql = "SELECT numero_cota FROM cotas";
        List<Integer> cotasExistentes = new ArrayList<>();
        try (Connection conn = Conexao.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                cotasExistentes.add(rs.getInt("numero_cota"));
            }
        }
        return cotasExistentes;
    }

    /**
     * Gera e associa várias cotas a um cliente de uma vez.
     *
     * @param idCliente ID do cliente.
     * @param cotas Lista de cotas a serem associadas.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public void associarCotasAoCliente(int idCliente, List<Integer> cotas) throws SQLException {
        String sql = "INSERT INTO cotas (numero_cota, id_cliente) VALUES (?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            for (int numeroCota : cotas) {
                pst.setInt(1, numeroCota);
                pst.setInt(2, idCliente);
                pst.addBatch(); // Adiciona ao lote
            }
            pst.executeBatch(); // Executa o lote de inserções
        }
    }

    /**
     * Exclui todas as cotas associadas a um cliente.
     *
     * @param idCliente ID do cliente.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public void excluirCotasDoCliente(int idCliente) throws SQLException {
        String sql = "DELETE FROM cotas WHERE id_cliente = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idCliente);
            pst.executeUpdate();
        }
    }
}