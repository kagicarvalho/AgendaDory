/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

/**
 *
 * @author Administrador
 */
public class Configuração extends javax.swing.JFrame {

    /**
     * Creates new form Configuração
     */
    public Configuração() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAlterarConfiguração = new javax.swing.JButton();
        fundoConfiguração = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        btnAlterarConfiguração.setContentAreaFilled(false);
        btnAlterarConfiguração.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarConfiguraçãoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterarConfiguração);
        btnAlterarConfiguração.setBounds(643, 140, 80, 100);

        fundoConfiguração.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/configuração.png"))); // NOI18N
        getContentPane().add(fundoConfiguração);
        fundoConfiguração.setBounds(0, 0, 800, 380);

        setSize(new java.awt.Dimension(815, 414));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarConfiguraçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarConfiguraçãoActionPerformed
        // TODO add your handling code here:
          ConfiguraçãoDados configuracaodados = new ConfiguraçãoDados();
        configuracaodados.setVisible(true);
    }//GEN-LAST:event_btnAlterarConfiguraçãoActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Configuração.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuração.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuração.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuração.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuração().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarConfiguração;
    private javax.swing.JLabel fundoConfiguração;
    // End of variables declaration//GEN-END:variables
}
