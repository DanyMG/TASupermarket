/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supermarket.anggota;

import supermarket.karyawan.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import supermarket.FormAnggota;
import supermarket.barang.FormBarang;
import supermarket.jamkerja.FormJamKerja;
import supermarket.laporan.FormLaporan;
import supermarket.suplier.FormSuplier;
import supermarket.FormtambahSuplier;
import supermarket.KoneksiMySQL;

/**
 *
 * @author DanyMG
 */
public class FormAnggota extends javax.swing.JFrame {

    Member mbr=new Member();
    
    Connection con;
    ResultSet RsAnggota;
    Statement stm;
    String selectedEmployee;
    /** Creates new form FormKaryawan */
    public FormAnggota() {
        initComponents();
        open_db();
        setTable();
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
    private void setTable(){
        //Membuat tabel untuk menampilkan karyawan
        DefaultTableModel model= new DefaultTableModel();        
        //Menambahkan kolom
        model.addColumn("ID");        
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("Kota");
        model.addColumn("Nomor Telepon");               
        tblanggota.setModel(model);
        //Mengatur ukuran kolom
        TableColumnModel columnModel=tblanggota.getColumnModel();
        columnModel.getColumn(0).setMaxWidth(30);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(75);
        columnModel.getColumn(4).setPreferredWidth(100);
        tblanggota.setColumnModel(columnModel);
        //Membaca data karyawan
        try{    
            stm=con.createStatement();
            RsAnggota=stm.executeQuery("select * from anggota");
            while (RsAnggota.next())
                model.addRow(new Object[]{          
                    RsAnggota.getString("id_anggota"), RsAnggota.getString("nama_anggota"),
                    RsAnggota.getString("almt_anggota"), RsAnggota.getString("kota_anggota"),
                    RsAnggota.getString("notelp_anggota")
                });
            tblanggota.setModel(model);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR : " +e);
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Psamping = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblSuplier = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblBarang = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblKaryawan = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblAnggota = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblLaporan = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblJamKerja = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel10 = new javax.swing.JPanel();
        txtkaryawanbaru = new javax.swing.JLabel();
        txtkuncicari = new javax.swing.JTextField();
        txtcari = new javax.swing.JLabel();
        txtbatal = new javax.swing.JLabel();
        txteditkaryawan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblanggota = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        Psamping.setBackground(new java.awt.Color(254, 151, 114));
        Psamping.setPreferredSize(new java.awt.Dimension(160, 650));

        jPanel5.setBackground(new java.awt.Color(254, 151, 114));

        lblSuplier.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSuplier.setForeground(new java.awt.Color(52, 17, 9));
        lblSuplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSuplier.setText("Suplier");
        lblSuplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSuplierMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(254, 151, 114));

        lblBarang.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblBarang.setForeground(new java.awt.Color(52, 17, 9));
        lblBarang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBarang.setText("Barang");
        lblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBarangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(254, 151, 114));

        lblKaryawan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblKaryawan.setForeground(new java.awt.Color(52, 17, 9));
        lblKaryawan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKaryawan.setText("Karyawan");
        lblKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKaryawanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lblKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(52, 17, 9));

        lblAnggota.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAnggota.setForeground(new java.awt.Color(254, 151, 114));
        lblAnggota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnggota.setText("Anggota");
        lblAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnggotaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblAnggota)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblAnggota)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel8.setBackground(new java.awt.Color(254, 151, 114));

        lblLaporan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblLaporan.setForeground(new java.awt.Color(52, 17, 9));
        lblLaporan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLaporan.setText("Laporan");
        lblLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLaporanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblLaporan)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblLaporan)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel9.setBackground(new java.awt.Color(254, 151, 114));

        lblJamKerja.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblJamKerja.setForeground(new java.awt.Color(52, 17, 9));
        lblJamKerja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJamKerja.setText("Jam Kerja");
        lblJamKerja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblJamKerjaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJamKerja)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblJamKerja)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PsampingLayout = new javax.swing.GroupLayout(Psamping);
        Psamping.setLayout(PsampingLayout);
        PsampingLayout.setHorizontalGroup(
            PsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PsampingLayout.createSequentialGroup()
                .addGroup(PsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PsampingLayout.setVerticalGroup(
            PsampingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PsampingLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 170, Short.MAX_VALUE))
        );

        jPanel1.add(Psamping);

        jPanel3.setBackground(new java.awt.Color(255, 229, 220));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 0));

        jToolBar1.setBackground(new java.awt.Color(255, 229, 220));
        jToolBar1.setRollover(true);

        jPanel10.setBackground(new java.awt.Color(255, 229, 220));

        txtkaryawanbaru.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtkaryawanbaru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/supermarket/gambar/iconfinder_new10_216291.png"))); // NOI18N
        txtkaryawanbaru.setText("Anggota Baru");
        txtkaryawanbaru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtkaryawanbaruMouseClicked(evt);
            }
        });

        txtcari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/supermarket/gambar/iconfinder_11_Search_106236.png"))); // NOI18N
        txtcari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcariMouseClicked(evt);
            }
        });

        txtbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/supermarket/gambar/iconfinder_Delete_1493279.png"))); // NOI18N

        txteditkaryawan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txteditkaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/supermarket/gambar/iconfinder_new-24_103173.png"))); // NOI18N
        txteditkaryawan.setText("Edit Anggota");
        txteditkaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txteditkaryawanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(txtkaryawanbaru)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txteditkaryawan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtkuncicari, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbatal)
                .addGap(0, 353, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtkaryawanbaru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtkuncicari, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txteditkaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(txtbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jToolBar1.add(jPanel10);

        tblanggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tblanggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblanggotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblanggota);
        if (tblanggota.getColumnModel().getColumnCount() > 0) {
            tblanggota.getColumnModel().getColumn(0).setMinWidth(10);
            tblanggota.getColumnModel().getColumn(1).setMinWidth(100);
            tblanggota.getColumnModel().getColumn(2).setMinWidth(100);
            tblanggota.getColumnModel().getColumn(3).setMinWidth(50);
            tblanggota.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtkaryawanbaruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtkaryawanbaruMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new FormtambahKaryawan().setVisible(true);
    }//GEN-LAST:event_txtkaryawanbaruMouseClicked

    private void txtcariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcariMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txtcariMouseClicked

    private void lblSuplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSuplierMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new FormSuplier().setVisible(true);
    }//GEN-LAST:event_lblSuplierMouseClicked

    private void lblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarangMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new FormBarang().setVisible(true);
    }//GEN-LAST:event_lblBarangMouseClicked

    private void lblKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKaryawanMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new FormAnggota().setVisible(true);
    }//GEN-LAST:event_lblKaryawanMouseClicked

    private void lblJamKerjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJamKerjaMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new FormJamKerja().setVisible(true);
    }//GEN-LAST:event_lblJamKerjaMouseClicked

    private void lblAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnggotaMouseClicked
        // TODO add your handling code here: 
        this.setVisible(false);
        new FormAnggota().setVisible(true);
    }//GEN-LAST:event_lblAnggotaMouseClicked

    private void lblLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLaporanMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new FormLaporan().setVisible(true);
    }//GEN-LAST:event_lblLaporanMouseClicked

    private void txteditkaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txteditkaryawanMouseClicked
        if(selectedEmployee!=null){
            this.setVisible(false);
            new FormeditAnggota(selectedEmployee).setVisible(true);
        }
        else JOptionPane.showMessageDialog(this, "Tidak ada karyawan yang dipilih.", "Alert", JOptionPane.WARNING_MESSAGE);
        
    }//GEN-LAST:event_txteditkaryawanMouseClicked

    private void tblanggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblanggotaMouseClicked
        selectedEmployee=tblanggota.getValueAt(tblanggota.getSelectedRow(),0).toString();
        txtkuncicari.setText(selectedEmployee);
    }//GEN-LAST:event_tblanggotaMouseClicked

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
            java.util.logging.Logger.getLogger(FormAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new FormAnggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Psamping;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblAnggota;
    private javax.swing.JLabel lblBarang;
    private javax.swing.JLabel lblJamKerja;
    private javax.swing.JLabel lblKaryawan;
    private javax.swing.JLabel lblLaporan;
    private javax.swing.JLabel lblSuplier;
    private javax.swing.JTable tblanggota;
    private javax.swing.JLabel txtbatal;
    private javax.swing.JLabel txtcari;
    private javax.swing.JLabel txteditkaryawan;
    private javax.swing.JLabel txtkaryawanbaru;
    private javax.swing.JTextField txtkuncicari;
    // End of variables declaration//GEN-END:variables

}
