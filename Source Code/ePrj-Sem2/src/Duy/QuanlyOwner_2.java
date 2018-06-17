/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duy;

import DatabaseConnection.DatabaseConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author DuDu
 */
public class QuanlyOwner_2 extends javax.swing.JFrame {
        Statement stmt;
    DefaultTableModel supModel;
    Vector header, row, data;
    String sql;
    ResultSet rs;

    Connection objConnection;
    
    String IDSup, NameSup, AddressSup, EmailSup, PhoneSup, StatusSup;

    /**
     * Creates new form QuanlyOwner
     */
    public QuanlyOwner_2(String account, String type, Connection objConnection, Statement stmt) {
        this.objConnection = objConnection;
        this.stmt = stmt;
        initComponents();
        //connect();
        showTable();
        //manageButton(true,true,true,true);
        manageTextfield(false,false,false,false,false);
    }
       
    public void manageButton(boolean btnAddStatus, boolean btnEditStatus, boolean btnViewStatus, boolean btnSearchStatus)
    {
        btnAdd.setEnabled(btnAddStatus);
        btnEdit.setEnabled(btnEditStatus);
        btnDelete.setEnabled(btnViewStatus);
        btnSearch.setEnabled(btnSearchStatus);
    }
//    public void connect()
//    {
//        
//        // TODO code application logic here
//        
//        DatabaseConnect objDBConnect;
//        objDBConnect = new DatabaseConnect();
//        Connection objConnection;
//        objConnection = (Connection) objDBConnect.DBConnect("Sem2_project_group2", "sa", "123");
//        try {
//            stmt = objConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
    public void showTable()
    {
        supModel = new DefaultTableModel();
        
        header = new Vector();
        header.add("ID");
        header.add("Name");
        header.add("Address");
        header.add("Phone");
        header.add("Email");
        header.add("Status");
        
        data = new Vector();
        
        supModel.setRowCount(0);
        
        try {            
            //select * from Services
            sql = "select * from Supplier";
            rs = stmt.executeQuery(sql);
            
            rs.beforeFirst();
            while(rs.next())
            {
                row = new Vector();                
                row.add( rs.getString("IDSup"));
                row.add(rs.getString("NameSup"));
                row.add(rs.getString("AddressSup"));
                row.add(rs.getString("PhoneSup"));
                row.add(rs.getString("EmailSup"));
                row.add(rs.getString("StatusSup"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        supModel.setDataVector(data, header);
        tblSup.setModel(supModel);
        //tblBook.setModel(bookModel);
        //ẩn bớt các cột không dùng đến
        //thật ra là xóa bớt view và giữ lại model
        modifyTable();
    }

    public void modifyTable()
    {
        tblSup.removeColumn(tblSup.getColumn("Address"));
        tblSup.removeColumn(tblSup.getColumn("Phone"));
        tblSup.removeColumn(tblSup.getColumn("Email"));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupRad = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSup = new javax.swing.JTable();
        pSupplier = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        radActivated = new javax.swing.JRadioButton();
        radLocked = new javax.swing.JRadioButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SUPPLIER MANAGERMENT");

        btnClose.setText("Close");
        btnClose.setPreferredSize(new java.awt.Dimension(99, 25));

        tblSup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ));
        tblSup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSup);

        pSupplier.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("ID");

        jLabel3.setText("Name");

        jLabel4.setText("Address");

        jLabel5.setText("Phone");

        jLabel6.setText("Email");

        jLabel7.setText("Status");

        txtName.setToolTipText("");

        btnEdit.setText("Edit");
        btnEdit.setPreferredSize(new java.awt.Dimension(99, 25));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setAutoscrolls(true);
        btnDelete.setPreferredSize(new java.awt.Dimension(99, 25));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.setPreferredSize(new java.awt.Dimension(99, 25));

        btnGroupRad.add(radActivated);
        radActivated.setText("Activated");

        btnGroupRad.add(radLocked);
        radLocked.setText("Locked");
        radLocked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radLockedActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pSupplierLayout = new javax.swing.GroupLayout(pSupplier);
        pSupplier.setLayout(pSupplierLayout);
        pSupplierLayout.setHorizontalGroup(
            pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSupplierLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pSupplierLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhone)
                            .addComponent(txtAddress)
                            .addComponent(txtName)
                            .addComponent(txtID)
                            .addComponent(txtEmail))
                        .addGap(57, 57, 57))
                    .addGroup(pSupplierLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(radActivated)
                        .addGap(18, 18, 18)
                        .addComponent(radLocked)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSupplierLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pSupplierLayout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pSupplierLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        pSupplierLayout.setVerticalGroup(
            pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSupplierLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(radActivated)
                    .addComponent(radLocked))
                .addGap(27, 27, 27)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGap(34, 34, 34)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void clearTxt()
    {
        txtID.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
    }       

    public void manageTextfield (boolean txtIDStatus, boolean txtNameStatus, boolean txtAddressStatus, boolean txtPhoneStatus, boolean txtEmailStatus)
    {
        txtID.setEditable(txtIDStatus);
        txtName.setEditable(txtNameStatus);
        txtAddress.setEditable(txtAddressStatus);
        txtPhone.setEditable(txtPhoneStatus);
        txtEmail.setEditable(txtEmailStatus);
    }    
    private void radLockedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radLockedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radLockedActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
         String IDSup;
        String NameSup, AddressSup, PhoneSup, EmailSup;
        String labelButton = btnAdd.getText();
        if (labelButton.equalsIgnoreCase("Add"))
        {
            clearTxt();
            manageButton(true, false, false, false);
            manageTextfield(true, true, true,true, true);
            btnAdd.setText("Save");
        }else
        {
        
            try {
                //lay du lieu tu textField
                IDSup = txtID.getText();
                NameSup = txtName.getText();
                AddressSup = txtAddress.getText();
               
                PhoneSup = txtPhone.getText();
                EmailSup= txtEmail.getText();
             
              
                //insert into Account(ID, Password, Type, Question, Answer) values ('Co01', 'abc123', 'Co', 'Dog Name' , 'Duy')
    //            sql = "insert into Account(ID, Password, Type, Question, Answer) values ('" + IDSup + "', '" + Pass + "', '" + Type + "', '" + Ques + "' , '" + Ans + "')";
   //             stmt.executeUpdate(sql);

                //insert into Collaborator(IDCo, NameCo, AddressCo, DOBCo, IdentificationNumberCo, DepositCo, PhoneCo, EmailCo, StatusCo, ImageCo) values ('Co01', 'Duy', 'Q5', '2005-12-20',  '1234', 123, '12345', 'email', 'Normal', 'Link' )
    //            sql = "insert into Supplier (IDCo, NameCo, AddressCo, DOBCo, IdentificationNumberCo, DepositCo, PhoneCo, EmailCo, StatusCo, ImageCo) values ('" + IDCo + "', '" + NameCo + "', '" + AddressCo + "', '" + DOBCo + "',  '" + IDNoCo + "', " + DepositCo + ", '" + PhoneCo + "', '" + EmailCo + "', '" + StatusCo + "', '" + ImageCo + "' )";
    //            stmt.executeUpdate(sql);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            showTable();
            btnAdd.setText("Add");
            
            manageButton(true, true, true, true);
            manageTextfield(false, false,false,false,false);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
    String labelBtn = btnEdit.getText();
        if( labelBtn.equalsIgnoreCase("Edit"))
        {
            btnEdit.setText("Save");
            manageTextfield(false,true,true,true,true);
            manageButton(false,true,false,false);
        }
        else
        {
            String ID = txtID.getText();
            String Name = txtName.getText();
            String Address = txtAddress.getText();
            String Phone =   txtPhone.getText();
            String Email =   txtEmail.getText();
         
            try {
                //update Guest set  NameSer = 'Ban nha', Price = 100 where IDSer = 'S06'
                    sql = "update Supplier set NameSup = '"+Name+"', AddressSup = '"+Address+"', PhoneSup = '"+Phone+"',EmailSup = '"+Email+"'' where IDSup = '"+ID+"'";
                    stmt.executeUpdate(sql);
                    btnEdit.setText("Edit");
                    clearTxt();
                    manageButton(true,true,true,true);
                    showTable();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tblSupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupMouseClicked
      int row;
        
        row = tblSup.getSelectedRow();
        TableModel tblModel = tblSup.getModel();
        IDSup = (String) tblModel.getValueAt(row, 0);       
        NameSup = (String)tblModel.getValueAt(row, 1);
        AddressSup = (String)tblModel.getValueAt(row, 2);   
        PhoneSup = (String)tblModel.getValueAt(row, 3);
        EmailSup = (String)tblModel.getValueAt(row, 4);
        StatusSup = (String)tblModel.getValueAt(row, 5);
           
        
        txtID.setText(IDSup);
        txtName.setText(NameSup);
        txtAddress.setText(AddressSup);
        txtPhone.setText(PhoneSup);
        txtEmail.setText(EmailSup);
       
        System.out.println(StatusSup);
        if (StatusSup.equalsIgnoreCase("1"))
        {
            radActivated.setSelected(true);
            radLocked.setSelected(false);
        }else
        {
            radActivated.setSelected(false);
            radLocked.setSelected(true);
        }
       
    }//GEN-LAST:event_tblSupMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
     try {
            int check = JOptionPane.showConfirmDialog(this, "You want to delete,sure?");
            if (check == JOptionPane.OK_OPTION)
            {
                String ID = txtID.getText();
                //cau lenh SQL mau da kiem tra thu tren SQl
                //delete from Guest where IDGu = 'S06'
                sql = "delete from Supplier where IDCo = '" + ID + "'";
                stmt.executeUpdate(sql);
                //xoa xong thi cap nhat lai Table
                showTable();
                //xoa cac textField
                clearTxt();
            }else{
                return;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(QuanlyOwner_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanlyOwner_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanlyOwner_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanlyOwner_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new QuanlyOwner_2().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.ButtonGroup btnGroupRad;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pSupplier;
    private javax.swing.JRadioButton radActivated;
    private javax.swing.JRadioButton radLocked;
    private javax.swing.JTable tblSup;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
