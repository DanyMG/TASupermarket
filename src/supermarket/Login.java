/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import supermarket.suplier.FormSuplier;

/**
 *
 * @author DanyMG
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    Connection con;
    ResultSet RsUser;
    Statement stm;  
    
    public Login() {
        initComponents();
        open_db();
    }
    private void open_db(){
        try{
            KoneksiMySQL kon= new KoneksiMySQL("localhost", "root", "", "supermarket");
            con=kon.getConnection();
        }
        catch(Exception e){
            System.out.println("Error : "+e);
        }
    }
    //method membuka database server, user, pass, database disesuaikan
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        market = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        tlogin = new javax.swing.JLabel();
        tusername = new javax.swing.JLabel();
        tpass = new javax.swing.JLabel();
        gambar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        market.setIcon(new javax.swing.ImageIcon(getClass().getResource("/supermarket/gambar/iconfinder_thefreeforty_shop_1243706.png"))); // NOI18N
        jPanel1.add(market, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        txtuser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtuser.setOpaque(false);
        jPanel1.add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 200, 200, 25));

        txtpass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        txtpass.setOpaque(false);
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 250, 200, 25));

        tlogin.setBackground(new java.awt.Color(153, 153, 153));
        tlogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tlogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tlogin.setText("Log In");
        tlogin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        tlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tloginMouseClicked(evt);
            }
        });
        jPanel1.add(tlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 330, 30));

        tusername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tusername.setText("Username");
        jPanel1.add(tusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));

        tpass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tpass.setText("Password");
        jPanel1.add(tpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

        gambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/supermarket/gambar/4659.jpg"))); // NOI18N
        jPanel1.add(gambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 600, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -3, 600, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void tloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tloginMouseClicked
        // TODO add your handling code here:
        if(tusername.getText().equals("")||tpass.getText().equals("")) JOptionPane.showMessageDialog(null, "Tolong isi username dan password!");
        else{
            try{
                stm=con.createStatement();
                RsUser=stm.executeQuery("select * from akun where akun.username='"+txtuser.getText()+"'");
                if(RsUser.next()){
                    if(txtpass.getText().equals(RsUser.getString("pass"))){
                        this.setVisible(false);
                        new FormSuplier().setVisible(true);
                    }else JOptionPane.showMessageDialog(null, "Password salah!");
                }else JOptionPane.showMessageDialog(null, "Username tidak tersedia");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, e);
            }           
        }
    }//GEN-LAST:event_tloginMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gambar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel market;
    private javax.swing.JLabel tlogin;
    private javax.swing.JLabel tpass;
    private javax.swing.JLabel tusername;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
