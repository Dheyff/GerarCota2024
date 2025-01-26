package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ClienteModel;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/xapp";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection;
    private static List<Integer> cotasExistentes = new ArrayList<>();

    // Conectar ao banco de dados
    public static Connection conectarBancoDeDados() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            carregarCotasExistentes();
            return connection;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }

    // Fechar a conexão com o banco
    public static void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }

    // Carregar todas as cotas existentes no banco
    public static void carregarCotasExistentes() {
        cotasExistentes.clear();
        String sql = "SELECT numero_cota FROM cotas";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                cotasExistentes.add(rs.getInt("numero_cota"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao carregar cotas existentes: " + e.getMessage());
        }
    }

    // Gerar uma cota única
    public static int gerarCotaUnica() {
        int cota;
        do {
            cota = (int) (Math.random() * 90) + 10; // Gera um número de 10 a 99
        } while (cotasExistentes.contains(cota)); // Verifica se a cota já existe
        return cota;
    }

    // Contar quantas cotas estão disponíveis
    public static int contarCotasDisponiveis() {
        return 90 - cotasExistentes.size(); // Total de cotas possíveis (90) menos as cotas já usadas
    }

    // Associar uma cota a um cliente
    public static void associarCotaAoCliente(int idCliente, int numeroCota) {
        String sql = "INSERT INTO cotas (id_cliente, numero_cota) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.setInt(2, numeroCota);
            stmt.executeUpdate();
            cotasExistentes.add(numeroCota); // Atualiza a lista de cotas existentes
        } catch (SQLException e) {
            System.out.println("Erro ao associar cota ao cliente: " + e.getMessage());
        }
    }

    // Adicionar um novo cliente
    public static int adicionarCliente(String nome, String cpf, String telefone) {
        String sql = "INSERT INTO clientes (nome, cpf, telefone) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, telefone);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // Retorna o ID do cliente recém-criado
            }
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());
        }
        return -1; // Retorna -1 se houve erro
    }

    // Excluir todos os dados
    public static void excluirTodosDados() {
        try {
            String sqlCotas = "DELETE FROM cotas";
            String sqlClientes = "DELETE FROM clientes";
            String sqlResetId = "ALTER TABLE clientes AUTO_INCREMENT = 1";
            try (Statement stmt = connection.createStatement()) {
                stmt.executeUpdate(sqlCotas);
                stmt.executeUpdate(sqlClientes);
                stmt.executeUpdate(sqlResetId);
                System.out.println("Todos os dados foram excluídos com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir dados: " + e.getMessage());
        }
    }

    // Pesquisar clientes por nome
    public static List<ClienteModel> pesquisarClientesPorNome(String nome) {
        List<ClienteModel> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes WHERE nome LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ClienteModel cliente = new ClienteModel();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar clientes: " + e.getMessage());
        }
        return clientes;
    }

    // Verificar se o banco e tabelas existem, caso contrário, criar
    public static void verificarEBancoCriado() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            // Verificar se o banco já existe
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet rs = meta.getCatalogs();
            boolean bancoExistente = false;
            while (rs.next()) {
                if (rs.getString(1).equals("xapp")) {
                    bancoExistente = true;
                    break;
                }
            }
            if (!bancoExistente) {
                stmt.executeUpdate("CREATE DATABASE xapp");
                System.out.println("Banco de dados xapp criado.");
            }

            // Criar as tabelas se não existirem
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS clientes (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(100), cpf VARCHAR(11), telefone VARCHAR(15))");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS cotas (id INT AUTO_INCREMENT PRIMARY KEY, id_cliente INT, numero_cota INT, FOREIGN KEY (id_cliente) REFERENCES clientes(id))");

        } catch (SQLException e) {
            System.out.println("Erro ao verificar ou criar banco de dados: " + e.getMessage());
        }
    }

    // Criar as tabelas se não existirem
    public static void criarTabelas(Statement stmt) throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS clientes (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(100), cpf VARCHAR(11), telefone VARCHAR(15))");
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS cotas (id INT AUTO_INCREMENT PRIMARY KEY, id_cliente INT, numero_cota INT, FOREIGN KEY (id_cliente) REFERENCES clientes(id))");
    }

    public void getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
