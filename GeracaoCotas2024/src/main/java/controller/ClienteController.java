package controller;

import dao.ClienteDAO;
import model.ClienteModel;

import java.sql.SQLException;
import java.util.List;

public class ClienteController {
    private ClienteDAO clienteDAO = new ClienteDAO();

    public int cadastrarCliente(String nome, String cpf, String telefone) throws SQLException, IllegalArgumentException {
        // Validação de CPF
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+")) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos numéricos.");
        }

        // Validação de Telefone
        if (telefone == null || telefone.length() < 10 || !telefone.matches("\\d+")) {
            throw new IllegalArgumentException("Telefone inválido. Deve conter pelo menos 10 dígitos numéricos.");
        }

        // Cria o objeto ClienteModel
        ClienteModel cliente = new ClienteModel();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setTelefone(telefone);

        // Salva no banco de dados
        return clienteDAO.adicionarCliente(cliente);
    }

    public void excluirTodosClientes() throws SQLException {
        clienteDAO.excluirTodosClientes();
    }

    public List<ClienteModel> buscarClientesPorNome(String nome) throws SQLException {
        return clienteDAO.buscarClientesPorNome(nome);
    }
}