package view;
import controller.ClienteController;

public class CadastroView extends javax.swing.JFrame {

 
    public CadastroView() {
        initComponents();
        
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

        javax.swing.GroupLayout pnlConsultaLayout = new javax.swing.GroupLayout(pnlConsulta);
        pnlConsulta.setLayout(pnlConsultaLayout);
        pnlConsultaLayout.setHorizontalGroup(
            pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
        pnlConsultaLayout.setVerticalGroup(
            pnlConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Consulta", pnlConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCpfCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfCompraActionPerformed

    private void btnLimparCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparCompraActionPerformed

    private void btnSalvarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCompraActionPerformed
        String nome = txtNomeCompra.getText();
        String cpf = txtCpfCompra.getText();
        String telefone = txtTelefoneCompra.getText();
        String quantidadeCotasStr = txtQtdCotaCompra.getText();
        
        ClienteController novoCliente = new ClienteController();
        novoCliente.adicionarCliente(nome, cpf, telefone);
    }//GEN-LAST:event_btnSalvarCompraActionPerformed

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
                new CadastroView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimparCompra;
    private javax.swing.JButton btnSalvarCompra;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCotaDisponivelCompra;
    private javax.swing.JLabel lblCpfCompra;
    private javax.swing.JLabel lblFoneCompra;
    private javax.swing.JLabel lblNomeCompra;
    private javax.swing.JLabel lblQuantidadeCompra;
    private javax.swing.JPanel pnlCompra;
    private javax.swing.JPanel pnlConsulta;
    private javax.swing.JTextField txtCpfCompra;
    private javax.swing.JTextField txtNomeCompra;
    private javax.swing.JTextField txtQtdCotaCompra;
    private javax.swing.JTextField txtTelefoneCompra;
    // End of variables declaration//GEN-END:variables
}
