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
    Nam.MainControlInterface objMain;

    int initRow;
    boolean checkInitRow;
    
    String account, type;
    
    /**
     * Creates new form QuanlyOwner
     */
    public QuanlyOwner_2(String account, String type, Connection objConnection, Statement stmt, Nam.MainControlInterface objMain) {
        this.objMain = objMain;
        this.objConnection = objConnection;
        this.stmt = stmt;
        this.account = account;
        this.type = type;
        initComponents();
        objMain.setVisible(false);
        //connect();
        showTable();
        initDataFromMainControl();
        pButton.attachButtonAndSetMainRight(pButton, type);
        pButton.createThreadToCheckButton();
        //manageButton(true,true,true,true);
        manageTextfield(false,false,false,false,false);
        initID();
    }
       
    private void initDataFromMainControl()
    {
        if(objMain.getIDSup().isEmpty())
            return;
        IDSup = objMain.getIDSup();
        checkInitRow = false;
        TableModel objModel = tblSup.getModel();
        for (int i = 0; i < objModel.getRowCount(); i++) {
            if (IDSup.equalsIgnoreCase((String)objModel.getValueAt(i, 0)))
            {
                checkInitRow = true;
                initRow = i;
                break;
            }
        }        
        tblMouseClickedProcess();
    }
    
    public void initID()
    {
        IDSup = "";
    }
    
    public void manageButton(boolean btnAddStatus, boolean btnEditStatus, boolean btnViewStatus, boolean btnSearchStatus)
    {
        btnAdd.setEnabled(btnAddStatus);
        btnUpdate.setEnabled(btnEditStatus);
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
        radActivated = new javax.swing.JRadioButton();
        radLocked = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSup = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pButton = new Library.G2Panel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pSupplier.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("ID");

        jLabel3.setText("Name");

        jLabel4.setText("Address");

        jLabel5.setText("Phone");

        jLabel6.setText("Email");

        jLabel7.setText("Status");

        txtName.setToolTipText("");

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        btnGroupRad.add(radActivated);
        radActivated.setText("Activated");
        radActivated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radActivatedActionPerformed(evt);
            }
        });

        btnGroupRad.add(radLocked);
        radLocked.setText("Locked");
        radLocked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radLockedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pSupplierLayout = new javax.swing.GroupLayout(pSupplier);
        pSupplier.setLayout(pSupplierLayout);
        pSupplierLayout.setHorizontalGroup(
            pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(4, 4, 4)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID)
                    .addComponent(txtName)
                    .addComponent(txtAddress)
                    .addComponent(txtPhone)
                    .addComponent(txtEmail))
                .addGap(10, 10, 10))
            .addGroup(pSupplierLayout.createSequentialGroup()
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pSupplierLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(radActivated)
                        .addGap(18, 18, 18)
                        .addComponent(radLocked))
                    .addGroup(pSupplierLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pSupplierLayout.setVerticalGroup(
            pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSupplierLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(15, 15, 15)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(radActivated)
                    .addComponent(radLocked))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SUPPLIER MANAGERMENT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(99, 25));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
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

        javax.swing.GroupLayout pButtonLayout = new javax.swing.GroupLayout(pButton);
        pButton.setLayout(pButtonLayout);
        pButtonLayout.setHorizontalGroup(
            pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pButtonLayout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pButtonLayout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(184, 184, 184))
        );
        pButtonLayout.setVerticalGroup(
            pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        getStatusSup();
    }//GEN-LAST:event_radLockedActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String IDSup;
        String NameSup, AddressSup, PhoneSup, EmailSup;
        String labelButton = btnAdd.getText();
        if (labelButton.equalsIgnoreCase("Add"))
        {
            //clearTxt();
            //manageButton(true, false, false, false);
            manageTextfield(true, true, true,true, true);
            btnAdd.setText("Save");
        }else
        {
        
            try {
                //cần phải kiểm tra dữ liệu trước khi add
                
                //lay du lieu tu textField
                IDSup = txtID.getText();
                NameSup = txtName.getText();
                AddressSup = txtAddress.getText();               
                PhoneSup = txtPhone.getText();
                EmailSup= txtEmail.getText();
                //insert into Supplier values ('Su01', 'Sup 1' , 'Q10', '12345', 'Sup@sup.vn', 'Normal')
                sql = "insert into Supplier values ('" + IDSup + "', '"+ NameSup +"' , '" + AddressSup +"', '" + PhoneSup + "', '" + EmailSup + "', '" + StatusSup + "')";
                stmt.executeUpdate(sql);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            showTable();
            btnAdd.setText("Add");
            
            //manageButton(true, true, true, true);
            pButton.returnBtnStatus();
            manageTextfield(false, false,false,false,false);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
    String labelBtn = btnUpdate.getText();
        if( labelBtn.equalsIgnoreCase("Update"))
        {
            btnUpdate.setText("Save");
            manageTextfield(false,true,true,true,true);
            //manageButton(false,true,false,false);
        }
        else
        {
            //Kiểm tra textfield trước khi nhập
            IDSup = txtID.getText();
            NameSup = txtName.getText();
            AddressSup = txtAddress.getText();               
            PhoneSup = txtPhone.getText();
            EmailSup= txtEmail.getText();
         
            try {
                //update Guest set  NameSer = 'Ban nha', Price = 100 where IDSer = 'S06'
                    sql = "update Supplier set NameSup = '"+ NameSup +"', AddressSup = '"+ AddressSup +"', PhoneSup = '"+ PhoneSup +"',EmailSup = '"+ EmailSup  +"',StatusSup = '"+ StatusSup +"' where IDSup = '"+ IDSup +"'";
                    //System.out.println(StatusSup);
                    stmt.executeUpdate(sql);
                    
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            btnUpdate.setText("Update");
            clearTxt();
            //manageButton(true,true,true,true);
            showTable();
            pButton.returnBtnStatus();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblSupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupMouseClicked
        //tách thành method riêng khai báo ở bên dưới
        //để tiện sử dụng lại khi cần hoặc khi initData từ
        //MainControl
        tblMouseClickedProcess();
        
       
    }//GEN-LAST:event_tblSupMouseClicked
    
    private void tblMouseClickedProcess()
    {
        int row;
        //nếu có dữ liệu init thì load trước
        //không có thì đợi click chuột vào bảng mới load
        if (checkInitRow)
        {
            row = initRow;
            checkInitRow = false;
        }
        else
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
       
        if (StatusSup.equalsIgnoreCase("Activated"))
        {
            radActivated.setSelected(true);
            radLocked.setSelected(false);
        }else
        {
            radActivated.setSelected(false);
            radLocked.setSelected(true);
        }
    }
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
     try {
            txtID.setEditable(true);
            if (txtID.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "ID cannot be blank", "ID Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int check = JOptionPane.showConfirmDialog(this, "You want to delete,sure?");
            if (check == JOptionPane.OK_OPTION)
            {
                String ID = txtID.getText();
                //cau lenh SQL mau da kiem tra thu tren SQl
                //delete from Guest where IDGu = 'S06'
                sql = "delete from Supplier where IDSup = '" + ID + "'";
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

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void radActivatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radActivatedActionPerformed
        // TODO add your handling code here:
        getStatusSup();
    }//GEN-LAST:event_radActivatedActionPerformed

    public void getStatusSup()
    {
        if (radActivated.isSelected())
            StatusSup = "Activated";
        else
            StatusSup = "Blocked";
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
    private javax.swing.JButton btnDelete;
    private javax.swing.ButtonGroup btnGroupRad;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    /*
    private javax.swing.JPanel pButton;
    */
    private Library.G2Panel pButton;
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

@Override
    public void dispose(){
        if (objMain != null)
        {
            objMain.setVisible(true);
            returnDataToMainInterface();
        }
        super.dispose();
    }

    public void returnDataToMainInterface()
    {        
        objMain.setIDSup(IDSup);
    }
}
