/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tuyet_Duyen;

import DatabaseConnection.DatabaseConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elisa
 */
public class Theme_guest extends javax.swing.JFrame {

    /**
     * Creates new form Theme_guest
     */
    DefaultTableModel CusModel;
    Vector header,data,row;
    String sql;
    ResultSet rs;
    Statement stmt;
    Connection objConnection;
    
    public Theme_guest() {
        initComponents();
        connectSQL();
        showTable();
        manageButton(true,false,false);
        manageTextField(false, false, false,false, false, false,false, false);
    }
    public void connectSQL(){
        DatabaseConnect objDBConnect;
        objDBConnect = new DatabaseConnect();
        
        objConnection = objDBConnect.DBConnect("Sem2_project_group2", "sa", "abc123");
        try {
            stmt = objConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void showTable()
    {
        CusModel = new DefaultTableModel();
        header = new Vector();
        header.add("Service ID");
        header.add("Service Name");
        header.add("Service Birthday");
        header.add("Service Identi No");
        header.add("Service Phone");
        header.add("Service Email");
        header.add("Service Status");
        header.add("Service Collaborator ID");
      
        data = new Vector();
        CusModel.setRowCount(0);
        
        try {            
            //select * from Guest
            sql = "select * from Guest";
            rs = stmt.executeQuery(sql);
            rs.beforeFirst();
            while(rs.next())
            {
                row = new Vector();
                row.add(rs.getString("IDGu"));
                row.add(rs.getString("NameGu"));
                row.add(rs.getString("DOBGu"));
                row.add(rs.getString("IdentificationNumberGu"));
                row.add(rs.getDouble("PhoneGu"));
                row.add(rs.getString("EmailGu"));
                row.add(rs.getString("StatusGu"));
                row.add(rs.getString("IDCo"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        CusModel.setDataVector(data, header);
        tblCustomer.setModel(CusModel);
        //tblBook.setModel(bookModel);
    }

    public void manageButton(boolean BtnAddStatus, boolean BtnUpdateStatus, boolean BtnDeleteStatus)
    {
        btnAdd.setEnabled(BtnAddStatus);
        btnUpdate.setEnabled(BtnUpdateStatus);
        btnDelete.setEnabled(BtnDeleteStatus);
    }
    public void manageTextField(boolean txtIDStatus, boolean txtNameStatus, boolean txtBirthStatus, boolean txtIDNoStatus, boolean txtPhoneStatus, boolean txtEmailStatus,boolean txtStatusStatus, boolean txtCoIDStatus)
    {
        txtID.setEditable(txtIDStatus);
        txtName.setEditable(txtNameStatus);
        txtBirth.setEditable(txtBirthStatus);
        txtIDNo.setEditable(txtIDNoStatus);
        txtPhone.setEditable(txtPhoneStatus);
        txtEmail.setEditable(txtEmailStatus);
        txtStatus.setEditable(txtStatusStatus);
        txtCoID.setEditable(txtCoIDStatus);
    }
    public void clearTxt()
    {
        txtID.setText("");
        txtName.setText("");
        txtBirth.setText("");
        txtIDNo.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtStatus.setText("");
        txtCoID.setText("");
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
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBirth = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIDNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCoID = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnBlock = new javax.swing.JButton();
        btnUnblock = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GUESTs");

        jLabel1.setBackground(new java.awt.Color(153, 0, 102));
        jLabel1.setText("Detail:");

        jLabel2.setText("ID");

        txtID.setText("G12");
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel3.setText("Name");

        txtName.setText("John Thomas");

        jLabel4.setText("Birthday");

        txtBirth.setText("12/12/1975");

        jLabel5.setText("Identi No");

        txtIDNo.setText("278376899");

        jLabel6.setText("Phone");

        txtPhone.setText("0934117989");

        jLabel7.setText("Email");

        txtEmail.setText("JonThomas@gamil.com");

        jLabel8.setText("Status");

        txtStatus.setText("Silver");

        jLabel9.setText("CollaboratorsID");

        txtCoID.setText("Co223");

        btnSearch.setText("Search");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");

        btnDelete.setText("Delete");

        tblCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Status", "Collaborator ID"
            }
        ));
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomer);

        jLabel10.setText("Customer List");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 51));
        jLabel11.setText("Customner Menagement");
        jLabel11.setToolTipText("");

        btnBlock.setText("Block");

        btnUnblock.setText("Unblock");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail)
                            .addComponent(txtPhone)
                            .addComponent(txtIDNo)
                            .addComponent(txtID)
                            .addComponent(txtName)
                            .addComponent(txtBirth)
                            .addComponent(txtStatus)
                            .addComponent(txtCoID, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnUnblock)
                                .addGap(36, 36, 36)
                                .addComponent(btnCancel))
                            .addComponent(btnSearch))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(29, 29, 29)
                        .addComponent(btnDelete)
                        .addGap(322, 322, 322))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(211, 211, 211)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel11)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtIDNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel)
                    .addComponent(btnUnblock)
                    .addComponent(btnBlock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String labelButton = btnAdd.getText();
            if (labelButton.equalsIgnoreCase("Add"))
            {
                clearTxt();               
                manageTextField(true, true, true,true, true, true,true, true);
                btnAdd.setText("Save");            
            }else{
                try {    
                    String ID = txtID.getText();
                    String Name = txtName.getText();
                    String DOB = txtBirth.getText();
                    String IDentiNo = txtIDNo.getText();
                    String Phone = txtPhone.getText();
                    String Email = txtEmail.getText();
                    String Status = txtStatus.getText();
                    String CoID = txtCoID.getText();
                    
                    //bat loi empty voi ID
                    if (ID.isEmpty())
                    {
                        JOptionPane.showMessageDialog(this, "ID cannot be blank. Pls re-enter");
                        txtID.grabFocus();
                        return;
                    }
                    
                    //insert into Services(IDSer, NameSer, Price) values ('S02', 'Lau nha', 200)
                 
                    //sql = "insert into Services(IDSer, NameSer, Price) values ('" + ID + "', '" + Name + "', " + Price +")";
                    
                    //insert into Guest values ('Gu01', 'Dat le', '1995-5-5', '1234456', '012345', 'datle@hetle.com', 'Normal', 'Co01')
                    sql="insert into Guest values ('"+ ID +"', '"+ Name +"', '"+ DOB +"', '"+ IDentiNo +"', '"+ Phone +"', '"+ Email +"', '"+ Status +"', '"+ CoID +"')";
                    stmt.executeUpdate(sql);
                    //hien thi thong tin trong Table
                    showTable();
                    //doi ten button lai thanh Add
                    btnAdd.setText("Add");
                    //xoa trang cac textfield
                    clearTxt(); 
                    //disable cac textfield
                    manageTextField(false, false, false,false, false, false,false, false);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        // TODO add your handling code here:
        manageButton(true, true, true);
        int row;
        String IDGu;
        String NameGu,DOBGu,IdentificationNumberGu,PhoneGu,EmailGu,StatusGu,IDCo;
        
        
        row = tblCustomer.getSelectedRow();
        
        IDGu = (String) tblCustomer.getValueAt(row, 0);        
        NameGu = (String)tblCustomer.getValueAt(row, 1);
        DOBGu = (String)tblCustomer.getValueAt(row, 2);
        IdentificationNumberGu = (String)tblCustomer.getValueAt(row, 3);
        PhoneGu = (String)tblCustomer.getValueAt(row, 4);
        EmailGu = (String)tblCustomer.getValueAt(row, 5);
        StatusGu = (String)tblCustomer.getValueAt(row, 6);
        IDCo = (String)tblCustomer.getValueAt(row, 7);
        
        txtID.setText(IDGu);
        txtName.setText(NameGu);
        txtBirth.setText(DOBGu);
        txtIDNo.setText(IdentificationNumberGu);
        txtPhone.setText(PhoneGu);
        txtEmail.setText(EmailGu);
        txtStatus.setText(StatusGu);
        txtCoID.setText(IDCo);
    }//GEN-LAST:event_tblCustomerMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String labelBtn = btnUpdate.getText();
        if( labelBtn.equalsIgnoreCase("Update"))
        {
            btnUpdate.setText("Save");            
            manageTextField(false, true, true,true,true,true,true,true);
            //dat lai trang thai cac Button
            manageButton(false, true, false);
           
            
        }else
        {
            //kiem tra cac textField co thoa man khong
             String ID = txtID.getText();
            String Name = txtName.getText();
            String DOB = txtBirth.getText();
            String IDentiNo = txtIDNo.getText();
            String Phone = txtPhone.getText();
            String Email = txtEmail.getText();
            String Status = txtStatus.getText();
            String CoID = txtCoID.getText();
            try {
                //tien hanh update thong tin len database
                //cau lenh sql mau da kiem tra thu tren SQL
                //update Services set  NameSer = 'Ban nha', Price = 100 where IDSer = 'S06'
                sql = "update Guest set  NameGu = '" + Name + "',DOBGu = '" + DOB + "',IdentificationNumberGu = '" + IDentiNo + "',PhoneGu = '" + Phone + "',EmailGu  = '" + Email + "',StatusGu = '" + Status + "', IDCo = " + CoID + " where IDGu = '" + ID + "'";
                stmt.executeUpdate(sql);
                
                //chay xong thi doi ten Button lai thanh Update
                btnUpdate.setText("Update");
                //xoa trang cac textField
                clearTxt();
                //enable lai cac Button
                manageButton(true, true, true);
                //cap nhat lai Table
                showTable();
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    
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
            java.util.logging.Logger.getLogger(Theme_guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Theme_guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Theme_guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Theme_guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Theme_guest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBlock;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUnblock;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTextField txtBirth;
    private javax.swing.JTextField txtCoID;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDNo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
