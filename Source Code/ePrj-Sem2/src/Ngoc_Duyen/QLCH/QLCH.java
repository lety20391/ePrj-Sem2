/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ngoc_Duyen.QLCH;

import DatabaseConnection.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class QLCH extends javax.swing.JFrame {

    /**
     * Creates new form QLCH
     */
    DefaultTableModel ApartModel ; 
    Vector header , data , row ;
    String sql ;
    ResultSet rs;
    Statement stmt;
    Connection con ;
    public QLCH() {
        initComponents();
        connectSQL();
        showTable();
        manageButton(true,false,false);
        manageTextField(false, false, false, false, false, false, false, false);
        this.setTitle("Apartment Management");
    }
    public void connectSQL()
        {
            try {
                con = DBConnection.getDBConnection(DBConnection.database,DBConnection.account,DBConnection.password);
            } catch (Exception e) {
                e.printStackTrace();
            }        
    }
    public void showTable()
    {
        
        ApartModel = new DefaultTableModel();
        header = new Vector();
        header.add("Service ID");
        header.add("Service Name");
        header.add("Service Address");
        header.add("Service Image");
        header.add("Service Info");
        header.add("Service Status");
        header.add("Service Price");
        header.add("Service IDSup");
        
        data = new Vector();
        ApartModel.setRowCount(0);
        
        try {            
            sql = "select * from Apartment";
            rs = stmt.executeQuery(sql);
            rs.beforeFirst();
            while(rs.next())
            {
                row = new Vector();
                row.add(rs.getString("IDApa"));
                row.add(rs.getString("NameApa"));
                row.add(rs.getString("AddressApa"));
                row.add(rs.getString("ImageApa"));
                row.add(rs.getString("InfoApa"));
                row.add(rs.getString("StatusApa"));
                row.add(rs.getDouble("PriceApa"));
                row.add(rs.getString("IDSupApa"));
                data.add(row);
            }
             } catch (Exception e) {
            e.printStackTrace();
        }
        
        ApartModel.setDataVector(data, header);
        tblApartment.setModel(ApartModel);
        
    }
    public void manageButton(boolean BtnAddStatus, boolean BtnUpdateStatus, boolean BtnDeleteStatus)
    {
        
        btnAdd.setEnabled(BtnAddStatus);
        btnUpdate.setEnabled(BtnUpdateStatus);
        btnDelete.setEnabled(BtnDeleteStatus);
        
    }
    public void manageTextField(boolean txtIDStatus, boolean txtNameStatus, boolean txtAddressStatus,boolean txtImageStatus, boolean txtInfoStatus, boolean txtStatusStatus,  boolean txtPriceStatus, boolean txtIDSupStatus)
    {
        txtID.setEditable(txtIDStatus);
        txtName.setEditable(txtNameStatus);
        txtAddress.setEditable(txtAddressStatus);
        txtImage.setEditable(txtImageStatus);
        txtInfo.setEditable(txtInfoStatus);
        txtStatus.setEditable(txtStatusStatus);
        txtPrice.setEditable(txtPriceStatus);
        txtIDSup.setEditable(txtIDSupStatus);
    }
    public void clearTxt()
    {
        txtID.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtImage.setText("");
        txtInfo.setText("");
        txtStatus.setText("");
        txtPrice.setText("");
        txtIDSup.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblApartment = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLable1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtImage = new javax.swing.JTextField();
        txtInfo = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        txtIDSup = new javax.swing.JTextField();

        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblApartment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Address", "Image", "Infor", "Status", "Price", "IDSup"
            }
        ));
        jScrollPane1.setViewportView(tblApartment);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Apartment Manager");

        jLabel2.setText("Detail : ");

        jLabel3.setText("Apartment List");

        jLable1.setText("ID");

        jLabel5.setText("Name");

        jLabel6.setText("Address");

        jLabel7.setText("Image");

        jLabel8.setText("Info ");

        jLabel9.setText("Status");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        txtImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImageActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel4.setText("Price");

        jLabel10.setText("IDSup");

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtAddress))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtImage))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtInfo))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtStatus)
                                            .addComponent(txtPrice)
                                            .addComponent(txtIDSup))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpdate)
                                .addGap(31, 31, 31)
                                .addComponent(btnDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDSup))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)
                            .addComponent(btnAdd))
                        .addContainerGap(13, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String labelButton = btnAdd.getText();
            if (labelButton.equalsIgnoreCase("Add"))
            {
                //clearTxt();               
                manageTextField(true, true, true,true, true, true, true, true);
                btnAdd.setText("Save");            
            }
            else{
                try {    
                    String ID = txtName.getText();
                    String Name = txtID.getText();
                    String Address = txtAddress.getText();
                    String Image = txtImage.getText();
                    String Info = txtInfo.getText();
                    String Status = txtPrice.getText();
                    String Price = txtPrice.getText();
                    String IDSup = txtPrice.getText();
                    
                    if (ID.isEmpty())
                    {
                        JOptionPane.showMessageDialog(this, "ID cannot be blank. Pls re-enter");
                        txtID.grabFocus();
                        return;
                    }
                    
                    sql="insert into Apartment values ('"+ ID +"', '"+ Name +"', '"+ Address +"', '"+ Image +"', '"+ Info +"','"+ Status +"'  ,'"+ Price +"','"+ IDSup +"')";
                    stmt.executeUpdate(sql);
                    showTable();
                    btnAdd.setText("Add");
                    clearTxt(); 
                    manageTextField(false, false, false,false, false, false, false, false);
                    } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
    }                 
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        UpdateApartment objUA = new UpdateApartment();
        objUA.setVisible(true);
        
        String labelBtn = btnUpdate.getText();
        if( labelBtn.equalsIgnoreCase("Update"))
        {
            btnUpdate.setText("Save");            
            manageTextField(false, true, true,true,true,true,true,true);
            manageButton(false, true, false);
           
            
        }else
        {
            String Name = txtID.getText();
            String ID = txtName.getText();
            String Address = txtAddress.getText();
            String Image = txtImage.getText();
            String Info = txtInfo.getText();
            String Status = txtStatus.getText();
            String Price = txtPrice.getText();
            String IDSup = txtIDSup.getText();
            try {
                sql = "update Apartment set  NameApa = '" + Name + "',AddressApa = '" + Address + "',ImageApa = '" + Image + "',InfoApa = '" + Info + "',StatusApa  = '" + Status+"',PriceApa  = '" + Price+"',IDSupApa  = '" + IDSup+ " where IDApa = '" + ID + "'";
                stmt.executeUpdate(sql);
                
               btnUpdate.setText("Update");
                clearTxt();
                manageButton(true, true, true);
                showTable();
                 } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
//        // TODO add your handling code here:
        try {
            int check = JOptionPane.showConfirmDialog(this, "Are you sure for deleting?");
            if (check == JOptionPane.OK_OPTION)
            {
                String ID = txtName.getText();
                sql = "delete from Apartment where IDApart = '" + ID + "'";
                stmt.executeUpdate(sql);
                showTable();
                clearTxt();
            }else{
                return;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImageActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    
    
     private void tblApartmentMouseClicked(java.awt.event.MouseEvent evt) {                                         
        // TODO add your handling code here:
        manageButton(true, true, true);
        int row;
        String IDApaString , ImageApaString, StatusApaString, IDSupApaString ;
        String NameApaString,OwnerApaString,PriceApaString,InfoApaString ;
        
        
        row = tblApartment.getSelectedRow();
        
        String IDApa = (String) tblApartment.getValueAt(row, 1);        
        String NameApa= (String) tblApartment.getValueAt(row, 2);
        String AddressApa = (String)tblApartment.getValueAt(row, 3);
        String ImageApa = (String)tblApartment.getValueAt(row, 4);
        String InfoApa = (String)tblApartment.getValueAt(row, 5);
        String StatusApa = (String)tblApartment.getValueAt(row, 6);
        String PriceApa = (String)tblApartment.getValueAt(row, 7);
        String IDSupApa = (String)tblApartment.getValueAt(row, 8);
        
        txtID.setText(IDApa);
        txtName.setText(NameApa);
        txtAddress.setText(AddressApa);
        txtImage.setText(ImageApa);
        txtInfo.setText(InfoApa);
        txtStatus.setText(StatusApa);
        txtPrice.setText(PriceApa);
        txtIDSup.setText(IDSupApa);
    }      
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
            java.util.logging.Logger.getLogger(QLCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLCH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLable1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tblApartment;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDSup;
    private javax.swing.JTextField txtImage;
    private javax.swing.JTextField txtInfo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
