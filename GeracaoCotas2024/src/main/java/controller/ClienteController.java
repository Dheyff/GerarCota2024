
package controller;

import javax.swing.JOptionPane;
import model.ClienteModel;

public class ClienteController {
    public int adicionarCliente(String nome, String cpf, String telefone) {
        
        if ((nome != null &&  nome.length()>0)&& (telefone != null &&  telefone.length()>0) && (cpf != null &&  cpf.length()>0)){
            ClienteModel novoCliente = new ClienteModel(nome, cpf, telefone);
            novoCliente.CadastraClientesDAO(novoCliente);
            JOptionPane.showMessageDialog(null, "Objeto criado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "vazio");
        } 
        return 0;
    }
}
