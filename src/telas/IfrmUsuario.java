package telas;

import apoio.Criptografia;
import apoio.Mensagem;
import entidade.Usuario;
import java.util.ArrayList;
import dao.UsuarioDAO;
import javax.swing.event.ChangeEvent;

public class IfrmUsuario extends javax.swing.JInternalFrame {

    private Usuario user = new Usuario();
    private UsuarioDAO udao = new UsuarioDAO();
    private boolean editando = false;

    public IfrmUsuario() {
        initComponents();
        user = udao.consultarId(jfrLogin.getUsuarioLogado().getId());
        tfdNome.setText(user.getNome());
        tfdEmail.setText(user.getEmail());
        tfdCpf.setText(user.getCpf());

    }

    private void focus() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Seta a aba de cadastro como a selecionada
                tabAbas.setSelectedIndex(0);
                tabAbasStateChanged(new ChangeEvent(tabAbas));
                tfdNome.requestFocusInWindow();
            }
        });
    }

    private void setEditando(boolean editando) {
        this.editando = editando;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgPessoa = new javax.swing.ButtonGroup();
        tabAbas = new javax.swing.JTabbedPane();
        pnlCadastro = new javax.swing.JPanel();
        pnlGeral = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        tfdNome = new javax.swing.JTextField();
        lblNome1 = new javax.swing.JLabel();
        tfdCpf = new javax.swing.JTextField();
        tfdSenha = new javax.swing.JPasswordField();
        pnlContato = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        tfdEmail = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnSalvar1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Usuário");
        setToolTipText("");

        tabAbas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabAbasStateChanged(evt);
            }
        });
        tabAbas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tabAbasFocusLost(evt);
            }
        });

        pnlCadastro.setName("pnlCadastro"); // NOI18N

        pnlGeral.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados gerais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblUsuario.setText("Nova senha *");

        lblNome.setText("Nome usuario *");

        lblNome1.setText("CPF *");

        tfdSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUsuario)
                    .addComponent(lblNome)
                    .addComponent(lblNome1))
                .addGap(18, 18, 18)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfdNome)
                    .addComponent(tfdCpf)
                    .addComponent(tfdSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdNome, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(tfdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlContato.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblEmail.setText("E-mail *");

        tfdEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlContatoLayout = new javax.swing.GroupLayout(pnlContato);
        pnlContato.setLayout(pnlContatoLayout);
        pnlContatoLayout.setHorizontalGroup(
            pnlContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContatoLayout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(lblEmail)
                .addGap(18, 18, 18)
                .addComponent(tfdEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        pnlContatoLayout.setVerticalGroup(
            pnlContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContatoLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(pnlContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(tfdEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );

        tfdEmail.getAccessibleContext().setAccessibleDescription("");

        btnSalvar.setText("Salvar");
        btnSalvar.setName("btnSalvar"); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnSalvar1.setText("Sair");
        btnSalvar1.setName("btnSalvar"); // NOI18N
        btnSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCadastroLayout = new javax.swing.GroupLayout(pnlCadastro);
        pnlCadastro.setLayout(pnlCadastroLayout);
        pnlCadastroLayout.setHorizontalGroup(
            pnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlCadastroLayout.setVerticalGroup(
            pnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnSalvar1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabAbas.addTab("Dados sobre o usuário", pnlCadastro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(tabAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabAbas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabAbas.getAccessibleContext().setAccessibleName("Dados do usuário");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabAbasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabAbasFocusLost

    }//GEN-LAST:event_tabAbasFocusLost

    private void tabAbasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabAbasStateChanged

    }//GEN-LAST:event_tabAbasStateChanged


    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        this.udao = new UsuarioDAO();
        user.setNome(tfdNome.getText());
        user.setEmail(tfdEmail.getText());
        user.setCpf(tfdCpf.getText());
        user.setSenha(Criptografia.criptografar(tfdSenha.getText()));

        try {

            if (udao.atualizar(user) != null) {
                throw new Exception("Erro ao salvar colaborador");
            }

            Mensagem.mostraInformacao("Sucesso", "Usuário " + user.getNome() + " atualizado com sucesso");

            btgPessoa.clearSelection();
            
             jfrLogin.getUsuarioLogado().setNome(user.getNome());
            
        } catch (Exception e) {
            Mensagem.mostraErro("Problema", "Problema para inserir usuário");
        }

        focus();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tfdEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdEmailActionPerformed

    private void btnSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalvar1ActionPerformed

    private void tfdSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdSenhaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgPessoa;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSalvar1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlCadastro;
    private javax.swing.JPanel pnlContato;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JTabbedPane tabAbas;
    private javax.swing.JTextField tfdCpf;
    private javax.swing.JTextField tfdEmail;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JPasswordField tfdSenha;
    // End of variables declaration//GEN-END:variables
}
