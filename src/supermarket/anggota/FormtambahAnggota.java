/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supermarket.anggota;


import javax.swing.JOptionPane;

import supermarket.barang.FormBarang;
import supermarket.jamkerja.FormJamKerja;
import supermarket.karyawan.FormKaryawan;
import supermarket.suplier.FormSuplier;

/**
 *
 * @author DanyMG
 */
public class FormtambahAnggota extends javax.swing.JFrame {

    Member mbr= new Member();
    int id;
    String[] member;
            
    public FormtambahAnggota(int lasId) {
        initComponents();
        id=lasId+1;
        setField(this.id);
    }
        
    private void setField(int id){
        txtidkaryawan.setText(Integer.toString(id));        
        txtnama.setText("");
        txtalamat.setText("");
        txtkota.setText("");
        txtnotelp.setText("");
    }
    public boolean isNameEmpty(){
        if(txtnama.getText().equals("")) return true;
        else return false;
    }
    private boolean isEditField(){
        //Fungsi untuk mengembalikan nilai true jika ada perubahan data
        if(txtnama.getText().equals("")&&txtalamat.getText().equals("")
                &&txtkota.getText().equals("")&&txtnotelp.getText().equals("")) return false;
        else return true;
    }
    private boolean checkEmptyField(){
        //Fungsi untuk mengembalikan nilai true jika ada field karyawan baru yang kosong
        if(txtnama.getText().equals("")||txtalamat.getText().equals("")
                ||txtkota.getText().equals("")||txtnotelp.getText().equals("")) return true;
        else return false;
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
        lblTambKaryawan = new javax.swing.JLabel();
        lblidkaryawan = new javax.swing.JLabel();
        lblnmkaryawan = new javax.swing.JLabel();
        txtidkaryawan = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        lblalamat = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();
        lblkota = new javax.swing.JLabel();
        txtkota = new javax.swing.JTextField();
        lblnotelp = new javax.swing.JLabel();
        txtnotelp = new javax.swing.JTextField();
        btntambah = new javax.swing.JToggleButton();
        btnreset = new javax.swing.JToggleButton();
        lblkembali = new javax.swing.JLabel();

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

        jPanel6.setBackground(new java.awt.Color(52, 17, 9));

        lblKaryawan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblKaryawan.setForeground(new java.awt.Color(254, 151, 114));
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

        jPanel7.setBackground(new java.awt.Color(254, 151, 114));

        lblAnggota.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAnggota.setForeground(new java.awt.Color(52, 17, 9));
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

        lblTambKaryawan.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTambKaryawan.setForeground(new java.awt.Color(253, 77, 12));
        lblTambKaryawan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTambKaryawan.setText("Anggota Baru");

        lblidkaryawan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblidkaryawan.setText("ID Anggota");

        lblnmkaryawan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblnmkaryawan.setText("Nama ");

        txtidkaryawan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtidkaryawan.setEnabled(false);

        txtnama.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblalamat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblalamat.setText("Alamat");

        txtalamat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblkota.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblkota.setText("Kota ");

        txtkota.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblnotelp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblnotelp.setText("Nomor Telepon");

        txtnotelp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btntambah.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btntambah.setText("Tambah");
        btntambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntambahMouseClicked(evt);
            }
        });

        btnreset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnreset.setText("Reset");
        btnreset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnresetMouseClicked(evt);
            }
        });

        lblkembali.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblkembali.setText("< Kembali");
        lblkembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblkembaliMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTambKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblidkaryawan)
                    .addComponent(lblnmkaryawan)
                    .addComponent(lblalamat)
                    .addComponent(lblkota)
                    .addComponent(lblnotelp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtidkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkota, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnotelp, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblkembali)
                .addGap(60, 60, 60))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblkembali)
                .addGap(75, 75, 75)
                .addComponent(lblTambKaryawan)
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblidkaryawan)
                    .addComponent(txtidkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnmkaryawan)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblalamat)
                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblkota)
                    .addComponent(txtkota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnotelp)
                    .addComponent(txtnotelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntambah)
                    .addComponent(btnreset))
                .addContainerGap(186, Short.MAX_VALUE))
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

    private void btnresetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresetMouseClicked
            setField(this.id);
    }//GEN-LAST:event_btnresetMouseClicked

    private void btntambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntambahMouseClicked
        if(isNameEmpty()) JOptionPane.showMessageDialog(this, "Nama anggota wajib diisi.");
        else{
            member=new String[]{Integer.toString(id),txtnama.getText(), txtalamat.getText(), txtkota.getText(), txtnotelp.getText(), "0"};
            if(mbr.addMember(member)){
                JOptionPane.showMessageDialog(this, "Data anggota berhasil ditambahkan.");
                this.id++;
                setField(id);
            }
            else JOptionPane.showMessageDialog(this, "Data anggota gagal ditambahkan.");
        }        
    }//GEN-LAST:event_btntambahMouseClicked

    private void lblSuplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSuplierMouseClicked
        this.setVisible(false);
        new FormSuplier().setVisible(true);
    }//GEN-LAST:event_lblSuplierMouseClicked

    private void lblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarangMouseClicked
        this.setVisible(false);
        new FormBarang().setVisible(true);
    }//GEN-LAST:event_lblBarangMouseClicked

    private void lblKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKaryawanMouseClicked
        this.setVisible(false);
        new FormKaryawan().setVisible(true);
    }//GEN-LAST:event_lblKaryawanMouseClicked

    private void lblJamKerjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJamKerjaMouseClicked
        this.setVisible(false);
        new FormJamKerja().setVisible(true);
    }//GEN-LAST:event_lblJamKerjaMouseClicked

    private void lblAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnggotaMouseClicked
        this.setVisible(false);
        new FormAnggota().setVisible(true);
    }//GEN-LAST:event_lblAnggotaMouseClicked

    private void lblkembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblkembaliMouseClicked
        // TODO add your handling code here:
        if(!isEditField()){        
            this.setVisible(false);
            new FormKaryawan().setVisible(true);
        }
        else{
            String[] pilihan= new String[2];
            pilihan[0]="Ya";
            pilihan[1]="Tidak";       
            int pilih=JOptionPane.showOptionDialog(this, "Apa Anda yakin ingin kembali?\nJika Anda mengklik \"Yes\" maka data yang Anda inputkan akan tidak ditambahkan.","Kembali", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,pilihan,null);
            if(JOptionPane.YES_OPTION==pilih){
                this.setVisible(false);
                new FormKaryawan().setVisible(true);
            }
        }
    }//GEN-LAST:event_lblkembaliMouseClicked
    
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
            java.util.logging.Logger.getLogger(FormtambahAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormtambahAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormtambahAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormtambahAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Psamping;
    private javax.swing.JToggleButton btnreset;
    private javax.swing.JToggleButton btntambah;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblAnggota;
    private javax.swing.JLabel lblBarang;
    private javax.swing.JLabel lblJamKerja;
    private javax.swing.JLabel lblKaryawan;
    private javax.swing.JLabel lblLaporan;
    private javax.swing.JLabel lblSuplier;
    private javax.swing.JLabel lblTambKaryawan;
    private javax.swing.JLabel lblalamat;
    private javax.swing.JLabel lblidkaryawan;
    private javax.swing.JLabel lblkembali;
    private javax.swing.JLabel lblkota;
    private javax.swing.JLabel lblnmkaryawan;
    private javax.swing.JLabel lblnotelp;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtidkaryawan;
    private javax.swing.JTextField txtkota;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnotelp;
    // End of variables declaration//GEN-END:variables

}
