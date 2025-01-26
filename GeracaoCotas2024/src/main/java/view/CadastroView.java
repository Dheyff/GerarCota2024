package view;
 
import controller.ClienteController;
import controller.CotaController;
import dao.Conexao;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class CadastroView extends javax.swing.JFrame {
    private ClienteController clienteController;
    private CotaController cotaController;
    private javax.swing.JFormattedTextField txtCpfCompra;
    private javax.swing.JFormattedTextField txtTelefoneCompra;
    
    public CadastroView() {
        initComponents();
        clienteController = new ClienteController();
        cotaController = new CotaController();
        configurarMascaras();
        txtNomeCompra.requestFocus(); // Foco no campo "Nome" ao abrir a tela
        
    }
    
    private void configurarMascaras() {
        try {
            // Máscara para CPF (###.###.###-##)
            MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraCpf.setPlaceholderCharacter('_'); // Caractere de placeholder
            txtCpfCompra = new javax.swing.JFormattedTextField(mascaraCpf);

            // Máscara para Telefone ((##) #####-####)
            MaskFormatter mascaraTelefone = new MaskFormatter("(##) #####-####");
            mascaraTelefone.setPlaceholderCharacter('_'); // Caractere de placeholder
            txtTelefoneCompra = new javax.swing.JFormattedTextField(mascaraTelefone);

            // Adiciona os campos formatados ao painel
            pnlCompra.add(txtCpfCompra);
            pnlCompra.add(txtTelefoneCompra);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Erro ao configurar máscaras: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarConsulta() {
        try {
            // Busca todos os clientes e suas cotas
            List<Object[]> resultados = cotaController.pesquisarClientesPorNome("");

            // Atualiza a tabela de consulta
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Limpa a tabela

            for (Object[] resultado : resultados) {
                model.addRow(resultado);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnExcluirDadosActionPerformed(java.awt.event.ActionEvent evt) {
        int confirmacao = JOptionPane.showConfirmDialog(
            this,
            "Tem certeza de que deseja excluir TODOS os dados? Esta ação é irreversível!",
            "Confirmação",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            try {
                clienteController.excluirTodosClientes();
                cotaController.excluirTodasCotas();
                JOptionPane.showMessageDialog(this, "Todos os dados foram excluídos com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                atualizarConsulta(); // Atualiza a tabela de consulta
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlCompra = new javax.swing.JPanel();
        lblNomeCompra = new javax.swing.JLabel();
        txtNomeCompra = new javax.swing.JTextField();
        lblCpfCompra = new javax.swing.JLabel();
        txtCpfCompra = new javax.swing.JTextField();
        lblFoneCompra = new javax.swing.JLabel();
        txtTelefoneCompra = new javax.swing.JTextField();
        lblCotaDisponivelCompra = new javax.swing.JLabel();
        lblQuantidadeCompra = new javax.swing.JLabel();
        txtQtdCotaCompra = new javax.swing.JTextField();
        btnLimparCompra = new javax.swing.JButton();
        btnSalvarCompra = new javax.swing.JButton();
        pnlConsulta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblNomeConsulta = new javax.swing.JLabel();
        txtNomeConsulta = new javax.swing.JTextField();
        btnPesquisarConsulta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnExculirDados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblNomeCompra.setText("Nome:");

        lblCpfCompra.setText("CPF:");

        txtCpfCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfCompraActionPerformed(evt);
            }
        });

        lblFoneCompra.setText("Telefone:");

        lblCotaDisponivelCompra.setText("Cotas Disponivel:");

        lblQuantidadeCompra.setText("Quantidade:");

        btnLimparCompra.setText("Limpar");
        btnLimparCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCompraActionPerformed(evt);
            }
        });

        btnSalvarCompra.setText("Salvar");
        btnSalvarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCompraLayout = new javax.swing.GroupLayout(pnlCompra);
        pnlCompra.setLayout(pnlCompraLayout);
        pnlCompraLayout.setHorizontalGroup(
            pnlCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCompraLayout.createSequentialGroup()
                .addGroup(pnlCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCompraLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(pnlCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNomeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlCompraLayout.createSequentialGroup()
                                .addGroup(pnlCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCpfCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCpfCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(81, 81, 81)
                                .addGroup(pnlCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefoneCompra)
                                    .addGroup(pnlCompraLayout.createSequentialGroup()
                                        .addComponent(lblFoneCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(pnlCompraLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(pnlCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCotaDisponivelCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlCompraLayout.createSequentialGroup()
                                .addComponent(lblQuantidadeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQtdCotaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(pnlCompraLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnLimparCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvarCompra)
                .addGap(97, 97, 97))
        );
        pnlCompraLayout.setVerticalGroup(
            pnlCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCompraLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblNomeCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpfCompra)
                    .addComponent(lblFoneCompra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpfCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefoneCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblCotaDisponivelCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidadeCompra)
                    .addComponent(txtQtdCotaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCompraLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnLimparCompra)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCompraLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(btnSalvarCompra)
                        .addGap(55, 55, 55))))
        );

        jTabbedPane1.addTab("Compra", pnlCompra);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cotas", "Cotas", "Cotas", "cotas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        lblNomeConsulta.setText("Nome:");

        txtNomeConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeConsultaActionPerformed(evt);
            }
        });

        btnPesquisarConsulta.setText("Pesquisar");
        btnPesquisarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarConsultaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setText("CPF:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("Nº Cotas:");

        javax.swing.GroupLayout pnlConsultaLayout = new javax.swing.GroupLayout(pnlConsulta);
        pnlConsulta.setLayout(pnlConsultaLayout);
        pnlConsultaLayout.setHorizontalGroup(
            pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(pnlConsultaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConsultaLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlConsultaLayout.createSequentialGroup()
                        .addComponent(lblNomeConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomeConsulta)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisarConsulta)
                        .addGap(31, 31, 31))
                    .addGroup(pnlConsultaLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(78, 78, 78))))
        );
        pnlConsultaLayout.setVerticalGroup(
            pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConsultaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeConsulta)
                    .addComponent(txtNomeConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarConsulta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta", pnlConsulta);

        btnExculirDados.setText("Excluir dados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExculirDados)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExculirDados)
                .addGap(10, 10, 10)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCpfCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfCompraActionPerformed

    private void btnLimparCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCompraActionPerformed
        // Limpa todos os campos
        txtNomeCompra.setText("");
        txtCpfCompra.setText("");
        txtTelefoneCompra.setText("");
        txtQtdCotaCompra.setText("");
        txtNomeCompra.requestFocus(); // Foco no campo "Nome"

    }//GEN-LAST:event_btnLimparCompraActionPerformed

    private void btnSalvarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCompraActionPerformed
        String nome = txtNomeCompra.getText();
        String cpf = txtCpfCompra.getText().replaceAll("[^0-9]", ""); // Remove caracteres não numéricos
        String telefone = txtTelefoneCompra.getText().replaceAll("[^0-9]", ""); // Remove caracteres não numéricos
        int quantidadeCotas = Integer.parseInt(txtQtdCotaCompra.getText());

        // Executa a operação em segundo plano
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    // Cadastra o cliente
                    int idCliente = clienteController.cadastrarCliente(nome, cpf, telefone);

                    // Gera e associa as cotas ao cliente
                    cotaController.gerarCotasParaCliente(idCliente, quantidadeCotas);

                    // Exibe mensagem de sucesso
                    JOptionPane.showMessageDialog(CadastroView.this, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                    // Limpa os campos após o cadastro
                    btnLimparCompraActionPerformed(evt);

                    // Atualiza a consulta e muda para a aba de consulta
                    atualizarConsulta();
                    jTabbedPane1.setSelectedIndex(1); // Seleciona a aba de consulta
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(CadastroView.this, "Quantidade de cotas inválida. Insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(CadastroView.this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(CadastroView.this, "Erro ao cadastrar cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
                return null;
            }
        };

        worker.execute(); // Inicia a execução em segundo plano
    }        
  

    }//GEN-LAST:event_btnSalvarCompraActionPerformed

    private void txtNomeConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeConsultaActionPerformed

    private void btnPesquisarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarConsultaActionPerformed
        String nome = txtNomeConsulta.getText();
        try {
            // Busca clientes pelo nome
            List<Object[]> resultados = cotaController.pesquisarClientesPorNome(nome);

            // Atualiza a tabela de consulta
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Limpa a tabela

            for (Object[] resultado : resultados) {
                model.addRow(resultado);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar clientes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarConsultaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExculirDados;
    private javax.swing.JButton btnLimparCompra;
    private javax.swing.JButton btnPesquisarConsulta;
    private javax.swing.JButton btnSalvarCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCotaDisponivelCompra;
    private javax.swing.JLabel lblCpfCompra;
    private javax.swing.JLabel lblFoneCompra;
    private javax.swing.JLabel lblNomeCompra;
    private javax.swing.JLabel lblNomeConsulta;
    private javax.swing.JLabel lblQuantidadeCompra;
    private javax.swing.JPanel pnlCompra;
    private javax.swing.JPanel pnlConsulta;
    private javax.swing.JTextField txtCpfCompra;
    private javax.swing.JTextField txtNomeCompra;
    private javax.swing.JTextField txtNomeConsulta;
    private javax.swing.JTextField txtQtdCotaCompra;
    private javax.swing.JTextField txtTelefoneCompra;
    // End of variables declaration//GEN-END:variables

