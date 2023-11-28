/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ardi13790.telebot;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import java.awt.*;
import java.text.SimpleDateFormat;


/**
 *
 * @author ASUS
 */
public class frmMessage extends javax.swing.JFrame {

    /**
     * Creates new form frmMember
     */
    DefaultTableModel tabModel;
    ResultSet RsProduk=null;
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/telebot";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    
    public frmMessage() {
        initComponents();
        tampil_data();
        set_editOff();
    }
    
    private void tampil_data(){
        try{
            Object[] judul_kolom = {"ChatID", "Firstname", "Message", "Date"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            tblMember.setModel(tabModel);
            
            Connection conn=(Connection)KoneksiMySql.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsProduk=stt.executeQuery("SELECT * from message");  
            while(RsProduk.next()){
                Object[] data={
                    RsProduk.getString("chat_id"),
                    RsProduk.getString("firstname"),  
                    RsProduk.getString("message"),
                    RsProduk.getString("date")
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
        // disable button
        btnSimpan.setEnabled(false);
        btnKoreksi.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);
        btnKeluar.setEnabled(true);
    }
    
    void tbl_keForm(){
        txtId.setText(tabModel.getValueAt(tblMember.getSelectedRow(),0)+"");
        txtFirstname.setText(tabModel.getValueAt(tblMember.getSelectedRow(),1)+"");
        txtMessage.setText(tabModel.getValueAt(tblMember.getSelectedRow(),2)+"");
        
        btnKoreksi.setEnabled(true);
        btnHapus.setEnabled(true);
        btnBatal.setEnabled(true);
        btnKeluar.setEnabled(true);
        btnSimpan.setEnabled(false);
    }
    
    private void bersih_data(){
        txtId.setText("");
        txtFirstname.setText("");
        txtMessage.setText("");
        txtNewMessage.setText("");
    } 
    
    private void set_editOff(){
        txtId.setEnabled(false);
        txtFirstname.setEnabled(false);
        txtMessage.setEnabled(false);
        txtNewMessage.setEnabled(false);
    }
    
    private void set_editOn(){
        txtId.setEnabled(true);
        txtFirstname.setEnabled(true);
        txtMessage.setEnabled(true);
        txtNewMessage.setEnabled(true);
   }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMember = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        txtFirstname = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnKoreksi = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNewMessage = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultArea = new javax.swing.JTextArea();
        startDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ChatID");

        jLabel2.setText("Firstname");

        tblMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ChatID", "Firstname", "Message", "Date"
            }
        ));
        tblMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMemberMouseClicked(evt);
            }
        });
        tblMember.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tblMemberCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        tblMember.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblMemberPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblMember);

        txtFirstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstnameActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimpanMouseClicked(evt);
            }
        });
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnKoreksi.setText("Koreksi");
        btnKoreksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKoreksiActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        jLabel3.setText("Message");

        jLabel4.setText("Edit to");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Form Message");

        jLabel6.setText("Message");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        resultArea.setColumns(20);
        resultArea.setRows(5);
        jScrollPane2.setViewportView(resultArea);

        jLabel7.setText("Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(289, 289, 289))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addGap(12, 12, 12)
                                        .addComponent(txtNewMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTambah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSimpan))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnKoreksi)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnHapus)
                                        .addGap(24, 24, 24)
                                        .addComponent(btnBatal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnKeluar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSearch))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNewMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah)
                            .addComponent(btnSimpan)
                            .addComponent(btnKoreksi)
                            .addComponent(btnHapus)
                            .addComponent(btnBatal)
                            .addComponent(btnKeluar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstnameActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        bersih_data();
        txtId.requestFocus();
        btnTambah.setEnabled(false);
        btnKeluar.setEnabled(false);
        btnSimpan.setEnabled(true);
        btnKoreksi.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(true);
        set_editOn();
        txtNewMessage.setEnabled(false);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void tblMemberPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblMemberPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMemberPropertyChange

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        bersih_data();
        btnTambah.setEnabled(true);
        btnKeluar.setEnabled(true);
        btnSimpan.setEnabled(false);
        btnKoreksi.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);
        set_editOff();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tblMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMemberMouseClicked
        // TODO add your handling code here:
        set_editOn();
        txtMessage.setEnabled(false);
        btnTambah.setEnabled(false);
        btnKeluar.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnKoreksi.setEnabled(true);
        btnHapus.setEnabled(true);
        btnBatal.setEnabled(true);
        txtId.setEnabled(false);
        txtFirstname.setEnabled(false);
        tbl_keForm();
    }//GEN-LAST:event_tblMemberMouseClicked

    private void btnKoreksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKoreksiActionPerformed
        // TODO add your handling code here:
        btnTambah.setEnabled(true);
        btnKeluar.setEnabled(true);
        btnSimpan.setEnabled(false);
        btnKoreksi.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);
        
        String tId=txtId.getText();
        String tFirstname=txtFirstname.getText();
        String tMessage=txtMessage.getText();
        String tNewMessage=txtNewMessage.getText();
        
        if (tId.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Chat ID masih kosong!");
            txtId.requestFocus();
        }else if (tFirstname.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Firstname masih kosong!");
            txtFirstname.requestFocus();
        }else if (tMessage.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Pesan masih kosong!");
            txtFirstname.requestFocus();
        }else{
            try{
                Connection conn=(Connection)KoneksiMySql.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("UPDATE message SET chat_id='"+tId+"', firstname='"+tFirstname+"', message='"+tNewMessage+"' WHERE chat_id='"+tId+"' and message='"+tMessage+"'");
                bersih_data();
                tampil_data();
                set_editOff();
                JOptionPane.showMessageDialog(this,"Data berhasil diubah","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Ubah data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnKoreksiActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        btnTambah.setEnabled(true);
        btnKeluar.setEnabled(true);
        btnSimpan.setEnabled(false);
        btnKoreksi.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);
        
        String tId=txtId.getText();
        String tMessage=txtMessage.getText();

        if (tId.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Kode produk tidak boleh kosong");
            txtId.requestFocus();
        }else if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?",
            "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
            try{
                Connection conn=(Connection)KoneksiMySql.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("DELETE FROM message WHERE chat_id='"+tId+"' AND message='"+tMessage+"'");
                bersih_data();
                tampil_data();
                set_editOff();
                JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblMemberCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblMemberCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMemberCaretPositionChanged

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String tId=txtId.getText();
        String tFirstname=txtFirstname.getText();
        String tMessage=txtMessage.getText();
        
        btnTambah.setEnabled(true);
        btnKeluar.setEnabled(true);
        btnSimpan.setEnabled(false);
        btnKoreksi.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);

        if (tId.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Chat ID masih kosong!");
            txtId.requestFocus();
        }else if (tFirstname.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Firstname masih kosong!");
            txtFirstname.requestFocus();
        }else if (tMessage.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Pesan masih kosong!");
            txtFirstname.requestFocus();
        }else if (!(new Scanner(tId).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Chat ID harus angka");
            txtId.requestFocus();
        }else{
            try{
                Connection conn=(Connection)KoneksiMySql.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("INSERT INTO message (chat_id, firstname, message)" + "VALUES('"+tId+"','"+tFirstname+"','"+tMessage+"')");
                bersih_data();
                tampil_data();
                set_editOff();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        
        String tSearch = searchField.getText().trim();
        java.util.Date startDate = startDateChooser.getDate();
        
        if (tSearch.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search term");
            return;
        }else if(startDate == null){
            JOptionPane.showMessageDialog(this, "Please select dates");
            return;
        }else{
            try{
                String searchTerm = searchField.getText().trim();
                Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                String sql = "SELECT * FROM message WHERE message LIKE ? AND DATE(date) LIKE ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, "%" + searchTerm + "%");
                statement.setDate(2, new java.sql.Date(startDate.getTime()));

                ResultSet resultSet = statement.executeQuery();
                
                StringBuilder sb = new StringBuilder();
                
                sb.append("------------------------------------------------------------------------").append("\n");
                sb.append("Chat ID").append("               ");
                sb.append("Firstname").append("       ");
                sb.append("Message").append("        ");
                sb.append("Date").append("     \n");
                sb.append("------------------------------------------------------------------------").append("\n");
                
                            
                while (resultSet.next()) {
                    String id = resultSet.getString("chat_id");
                    String firstName = resultSet.getString("firstname");
                    String message = resultSet.getString("message");
                    String date = resultSet.getString("date");
                    sb.append(id).append("          ");
                    sb.append(firstName).append("                 ");
                    sb.append(message).append("        ");
                    sb.append(date).append("     \n");
                    sb.append("------------------------------------------------------------------------").append("\n");
                }

                resultArea.setText(sb.toString());

                resultSet.close();
                statement.close();
                conn.close();
                
            }catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Terjadi kesalahan saat terhubung ke database.");
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    
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
            java.util.logging.Logger.getLogger(frmMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmMessage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnKoreksi;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea resultArea;
    private javax.swing.JTextField searchField;
    private com.toedter.calendar.JDateChooser startDateChooser;
    private javax.swing.JTable tblMember;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtNewMessage;
    // End of variables declaration//GEN-END:variables
}
