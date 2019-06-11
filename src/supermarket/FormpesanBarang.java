/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;

/**
 *
 * @author DanyMG
 */
public class FormpesanBarang extends javax.swing.JFrame {

    /**
     * Creates new form beranda
     */
    Connection con;
    ResultSet RsPemesanan,RsBarang,RsKaryawan,RsSuplier;
    Statement stm;
    SimpleDateFormat formatTgl= new SimpleDateFormat("yyyy-MM-dd");
    public FormpesanBarang() {
        initComponents();
        open_db();
        setField();
    }
    
    private void setIdPemesanan(){
        try{
            stm=con.createStatement();
            RsPemesanan=stm.executeQuery("select * from pemesanan order by id_pemesanan DESC");
            if(RsPemesanan.next()){               
                txtidpemesanan.setText(Integer.toString(RsPemesanan.getInt("id_pemesanan")+1));                
            }else txtidpemesanan.setText("1");            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void setcbNmBarang(){
        try{    
            stm=con.createStatement();
            RsBarang=stm.executeQuery("select * from barang");
            while(RsBarang.next()){
                cbnmBarang.addItem(RsBarang.getString("nama_barang"));
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR : " +e);
        }
        
    }
    
    private void setcbNmKaryawan(){
        try{    
            stm=con.createStatement();
            RsKaryawan=stm.executeQuery("select * from karyawan");
            while(RsKaryawan.next()){
                cbnmKaryawan.addItem(RsKaryawan.getString("nama_karyawan"));
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR : " +e);
        }        
    }
    
    private void setcbNmSuplier(){
        try{    
            stm=con.createStatement();
            RsSuplier=stm.executeQuery("select * from suplier");
            while(RsSuplier.next()){
                cbnmSuplier.addItem(RsSuplier.getString("nama_suplier"));
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR : " +e);
        }
        
    }
    
    private void setField(){
        setIdPemesanan();
        txtidbarang.setText("");
        setcbNmBarang();
        txtidkaryawan.setText("");
        txtidsuplier.setText("");
        setcbNmKaryawan();
        setcbNmSuplier();        
        datetglpesan.setDate(new Date());
        txtjmlpemesanan.setText("");
    }
    
    private void setIdBarang(){
        if(!cbnmBarang.getSelectedItem().toString().equalsIgnoreCase("pilih barang")){
            try{
                stm=con.createStatement();
                RsBarang=stm.executeQuery("select * from barang where nama_barang= '"+cbnmBarang.getSelectedItem().toString()+"'");
                while (RsBarang.next()){
                   txtidbarang.setText(RsBarang.getString("id_barang"));
                }                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "ERROR : " +e);
            }      
        }
        else txtidbarang.setText("");
    }
    
    private void setIdKaryawan(){
        if(!cbnmKaryawan.getSelectedItem().toString().equalsIgnoreCase("pilih karyawan")){
            try{
                stm=con.createStatement();
                RsKaryawan=stm.executeQuery("select * from karyawan where nama_karyawan= '"+cbnmKaryawan.getSelectedItem().toString()+"'");
                while (RsKaryawan.next()){
                   txtidkaryawan.setText(RsKaryawan.getString("id_karyawan"));
                }                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "ERROR : " +e);
            }      
        }
        else txtidkaryawan.setText("");
    }
    
    private void setIdSuplier(){
        if(!cbnmSuplier.getSelectedItem().toString().equalsIgnoreCase("pilih suplier")){
            try{
                stm=con.createStatement();
                RsSuplier=stm.executeQuery("select * from suplier where nama_suplier= '"+cbnmSuplier.getSelectedItem().toString()+"'");
                while (RsSuplier.next()){
                   txtidsuplier.setText(RsSuplier.getString("id_suplier"));
                }                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "ERROR : " +e);
            }      
        }
        else txtidsuplier.setText("");
    }
    
    private boolean emptyField(){
        if(txtidpemesanan.equals("")|txtidkaryawan.equals("")|txtidpemesanan.equals("")|txtidsuplier.equals("")|txtjmlpemesanan.equals("")) return true;
        else return false;
    }
    private void open_db(){
        try{
            KoneksiMySQL kon= new KoneksiMySQL("localhost", "root", "", "supermarket");
            con=kon.getConnection();
        }catch(Exception e){
            System.out.println("Error : "+e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pMenuSamping = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblBARANG = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtidbarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtidpemesanan = new javax.swing.JTextField();
        txtidkaryawan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtidsuplier = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbnmSuplier = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        btnPesan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtjmlpemesanan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        datetglpesan = new com.toedter.calendar.JDateChooser();
        cbnmKaryawan = new javax.swing.JComboBox<>();
        cbnmBarang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(52, 17, 9));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        pMenuSamping.setBackground(new java.awt.Color(52, 17, 9));

        jPanel2.setBackground(new java.awt.Color(72, 37, 29));

        lblBARANG.setBackground(new java.awt.Color(52, 17, 9));
        lblBARANG.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        lblBARANG.setForeground(new java.awt.Color(254, 151, 114));
        lblBARANG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBARANG.setText("BARANG");
        lblBARANG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBARANGMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBARANG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBARANG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pMenuSampingLayout = new javax.swing.GroupLayout(pMenuSamping);
        pMenuSamping.setLayout(pMenuSampingLayout);
        pMenuSampingLayout.setHorizontalGroup(
            pMenuSampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMenuSampingLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pMenuSampingLayout.setVerticalGroup(
            pMenuSampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMenuSampingLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(567, Short.MAX_VALUE))
        );

        jPanel1.add(pMenuSamping);

        jPanel3.setBackground(new java.awt.Color(255, 232, 220));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(52, 21, 9));
        jLabel3.setText("Nama Karyawan");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(52, 21, 9));
        jLabel4.setText("ID Barang");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(52, 21, 9));
        jLabel5.setText("ID Karyawan");

        txtidbarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtidbarang.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(52, 21, 9));
        jLabel6.setText("Nama Barang");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(52, 21, 9));
        jLabel7.setText("ID Pemesanan");

        txtidpemesanan.setBackground(new java.awt.Color(240, 240, 240));
        txtidpemesanan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtidpemesanan.setEnabled(false);

        txtidkaryawan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtidkaryawan.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(52, 21, 9));
        jLabel8.setText("ID Supplier");

        txtidsuplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtidsuplier.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(52, 21, 9));
        jLabel9.setText("Nama Supplier");

        cbnmSuplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbnmSuplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Suplier" }));
        cbnmSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnmSuplierActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(52, 21, 9));
        jLabel10.setText("Tgl Pemesanan");

        btnPesan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesan.setText("Pesan");

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pemesanan Barang");

        txtjmlpemesanan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(52, 21, 9));
        jLabel12.setText("Jumlah Pemesanan");

        datetglpesan.setDateFormatString("d MMM yyyy");
        datetglpesan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cbnmKaryawan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbnmKaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Karyawan" }));
        cbnmKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnmKaryawanActionPerformed(evt);
            }
        });

        cbnmBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbnmBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Barang" }));
        cbnmBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnmBarangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 141, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12))
                                .addGap(85, 85, 85)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbnmSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidsuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(datetglpesan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtjmlpemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(109, 109, 109)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtidkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbnmKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbnmBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidpemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 82, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidpemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtidbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbnmBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtidkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbnmKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtidsuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbnmSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datetglpesan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtjmlpemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset)
                    .addComponent(btnPesan))
                .addContainerGap(209, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblBARANGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBARANGMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new FormMenuBarang().setVisible(true);
    }//GEN-LAST:event_lblBARANGMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
        setField();
    }//GEN-LAST:event_btnResetMouseClicked

    private void cbnmKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnmKaryawanActionPerformed
        // TODO add your handling code here:
        setIdKaryawan();
    }//GEN-LAST:event_cbnmKaryawanActionPerformed

    private void cbnmBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnmBarangActionPerformed
        // TODO add your handling code here:
        setIdBarang();
        
    }//GEN-LAST:event_cbnmBarangActionPerformed

    private void cbnmSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnmSuplierActionPerformed
        // TODO add your handling code here:
        setIdSuplier();
    }//GEN-LAST:event_cbnmSuplierActionPerformed

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
            java.util.logging.Logger.getLogger(FormpesanBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormpesanBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormpesanBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormpesanBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormpesanBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesan;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cbnmBarang;
    private javax.swing.JComboBox<String> cbnmKaryawan;
    private javax.swing.JComboBox<String> cbnmSuplier;
    private com.toedter.calendar.JDateChooser datetglpesan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBARANG;
    private javax.swing.JPanel pMenuSamping;
    private javax.swing.JTextField txtidbarang;
    private javax.swing.JTextField txtidkaryawan;
    private javax.swing.JTextField txtidpemesanan;
    private javax.swing.JTextField txtidsuplier;
    private javax.swing.JTextField txtjmlpemesanan;
    // End of variables declaration//GEN-END:variables
}
