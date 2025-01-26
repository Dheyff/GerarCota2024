package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/xapp";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void criarBancoDeDados() {
        try (Connection conn = getConnection()) {
            String sqlClientes = "CREATE TABLE IF NOT EXISTS clientes (" 
                               + "id_cliente INT AUTO_INCREMENT PRIMARY KEY, "
                               + "nome VARCHAR(100) NOT NULL, "
                               + "cpf VARCHAR(15) NOT NULL, "
                               + "telefone VARCHAR(20))";
            String sqlCotas = "CREATE TABLE IF NOT EXISTS cotas (" 
                            + "id_cota INT AUTO_INCREMENT PRIMARY KEY, "
                            + "numero_cota INT NOT NULL, "
                            + "id_cliente INT, "
                            + "FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente) "
                            + "ON DELETE CASCADE)";
            conn.createStatement().execute(sqlClientes);
            conn.createStatement().execute(sqlCotas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}