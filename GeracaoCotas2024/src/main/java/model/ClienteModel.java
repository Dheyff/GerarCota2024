package model;

import DAO.ClienteDAO;
import java.sql.Connection;

public class ClienteModel {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;

    public ClienteModel() {
    
    }

    public ClienteModel(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public ClienteModel(int id, String nome, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void CadastraClientesDAO(ClienteModel cliente) {
        Connection connection = null;
        ClienteDAO novoCliente = new ClienteDAO(connection);
        novoCliente.adicionarCliente(cliente);
        System.out.println("cadastrado no banco de dados");
    }

}
