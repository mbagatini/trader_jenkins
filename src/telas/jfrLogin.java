/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import apoio.Criptografia;
import apoio.Mensagem;
import dao.UsuarioDAO;
import entidade.Usuario;
import static java.awt.Color.white;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author renan
 */
public class jfrLogin extends javax.swing.JFrame {

    private static Usuario colab;

    public static Usuario getUsuarioLogado() {
        return colab;
    }

    public static void setUsuarioLogado(Usuario c) {
        colab = c;
    }

    public jfrLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(white);
        colab = new Usuario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfLogin = new javax.swing.JTextField();
        jpfSenha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jlbMsgAutenticacao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trader | Acessar");
        setBackground(new java.awt.Color(192, 187, 182));

        jtfLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfLogin.setToolTipText("Digite seu usuário");
        jtfLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfLoginMouseClicked(evt);
            }
        });

        jpfSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jpfSenha.setToolTipText("Digite sua senha");
        jpfSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpfSenhaMouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(70, 54, 54));
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Acessar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jlbMsgAutenticacao.setForeground(java.awt.Color.red);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/profle.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/key.png"))); // NOI18N

        jLabel3.setText("Usuário");

        jLabel4.setText("Senha");

        jButton2.setBackground(new java.awt.Color(144, 127, 127));
        jButton2.setForeground(java.awt.Color.white);
        jButton2.setText("Se cadastrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbMsgAutenticacao, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                        .addComponent(jpfSenha)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbMsgAutenticacao, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UsuarioDAO dao = new UsuarioDAO();
        colab = dao.autenticarUsuario(jtfLogin.getText(), Criptografia.criptografar(jpfSenha.getText()));
        if (colab != null) {
            FrmPrincipal menu = new FrmPrincipal();
            menu.setVisible(true);
            this.setVisible(false);
        } else {
            jlbMsgAutenticacao.setText("Usuário ou senha inválidos.");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtfLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfLoginMouseClicked
        jlbMsgAutenticacao.setText("");
    }//GEN-LAST:event_jtfLoginMouseClicked

    private void jpfSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpfSenhaMouseClicked
        jlbMsgAutenticacao.setText("");
    }//GEN-LAST:event_jpfSenhaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
        
        NovoUsuario cadUsuario = new NovoUsuario();
        cadUsuario.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jlbMsgAutenticacao;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtfLogin;
    // End of variables declaration//GEN-END:variables
}
