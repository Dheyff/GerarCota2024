package controller;

import dao.CotaDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CotaController {
    private CotaDAO cotaDAO = new CotaDAO();
    private List<Integer> cotasDisponiveis;

    public CotaController() {
        try {
            // Carrega as cotas existentes ao iniciar o programa
            List<Integer> cotasExistentes = cotaDAO.carregarCotasExistentes();
            cotasDisponiveis = gerarListaCotasDisponiveis(cotasExistentes);
        } catch (SQLException e) {
            e.printStackTrace();
            cotasDisponiveis = new ArrayList<>();
        }
    }

    /**
     * Gera a lista de cotas disponíveis (números de 10 a 99 que não estão no banco).
     *
     * @param cotasExistentes Lista de cotas já existentes no banco.
     * @return Lista de cotas disponíveis.
     */
    private List<Integer> gerarListaCotasDisponiveis(List<Integer> cotasExistentes) {
        List<Integer> cotasDisponiveis = new ArrayList<>();
        for (int i = 10; i <= 99; i++) {
            if (!cotasExistentes.contains(i)) {
                cotasDisponiveis.add(i);
            }
        }
        return cotasDisponiveis;
    }

    /**
     * Gera e associa várias cotas a um cliente de uma vez.
     *
     * @param idCliente ID do cliente.
     * @param quantidade Quantidade de cotas a serem geradas.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     * @throws IllegalArgumentException Se a quantidade for inválida ou não houver cotas disponíveis.
     */
    public void gerarCotasParaCliente(int idCliente, int quantidade) throws SQLException, IllegalArgumentException {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade de cotas deve ser um número positivo.");
        }

        if (quantidade > cotasDisponiveis.size()) {
            throw new IllegalArgumentException("Não há cotas suficientes disponíveis. Cotas disponíveis: " + cotasDisponiveis.size());
        }

        // Sorteia as cotas
        List<Integer> cotasSorteadas = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < quantidade; i++) {
            int index = random.nextInt(cotasDisponiveis.size());
            int numeroCota = cotasDisponiveis.remove(index); // Remove a cota sorteada da lista
            cotasSorteadas.add(numeroCota);
        }

        // Associa as cotas ao cliente no banco de dados
        cotaDAO.associarCotasAoCliente(idCliente, cotasSorteadas);
    }

    /**
     * Exclui todas as cotas associadas a um cliente.
     *
     * @param idCliente ID do cliente.
     * @throws SQLException Se ocorrer um erro ao acessar o banco de dados.
     */
    public void excluirCotasDoCliente(int idCliente) throws SQLException {
        cotaDAO.excluirCotasDoCliente(idCliente);
    }
}