/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duy;

import Nam.RegisterForm;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DuDu
 */
public class QuanlyCTV_2 extends javax.swing.JFrame {

    Statement stmt;
    DefaultTableModel coModel;
    Vector header, row, data;
    String sql;
    ResultSet rs;

    Connection objConnection;

    String continueAccount, continueType;

    /**
     * Creates new form QuanlyCTV
     *
     * @param account
     * @param type
     * @param objConnection
     * @param stmt
     */
    public QuanlyCTV_2(String account, String type, Connection objConnection, Statement stmt) {
        this.objConnection = objConnection;
        this.stmt = stmt;
        continueAccount = account;
        continueType = type;
        initComponents();
        showTable();
        manageButton(true, true, true, true);
        manageTextfield(false, false, false, false, false, false, false, false, false, false, false, false, false, false);
    }

    public void manageButton(boolean btnAddStatus, boolean btnEditStatus, boolean btnDeleteStatus, boolean btnSearchStatus) {
        btnAdd.setEnabled(btnAddStatus);
        btnEdit.setEnabled(btnEditStatus);
        btnDelete.setEnabled(btnDeleteStatus);
        btnClose.setEnabled(btnSearchStatus);
        setLocationRelativeTo(null);
    }

    public void manageTextfield(boolean txtIDStatus, boolean txtNameStatus, boolean txtAddressStatus, boolean txtPhoneStatus, boolean txtEmailStatus, boolean txtDOBStatus, boolean txtIDNoStatus, boolean txtImageStatus, boolean txtStatusStatus, boolean txtDepositStatus, boolean txtPassStatus, boolean txtTypeStatus, boolean txtQuesStatus, boolean txtAnsStatus) {
        txtID.setEditable(txtIDStatus);
        txtName.setEditable(txtNameStatus);
        txtAddress.setEditable(txtAddressStatus);
        txtPhone.setEditable(txtPhoneStatus);
        txtEmail.setEditable(txtEmailStatus);
        txtDOB.setEditable(txtDOBStatus);
        txtIDNo.setEditable(txtIDNoStatus);
        txtImage.setEditable(txtImageStatus);
        txtStatus.setEditable(txtStatusStatus);
        txtDeposit.setEditable(txtDepositStatus);
        txtPass.setEditable(txtPassStatus);
        txtType.setEditable(txtTypeStatus);
        txtQues.setEditable(txtQuesStatus);
        txtAns.setEditable(txtAnsStatus);
    }

    public void clearTxt() {
        txtID.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtDOB.setText("");
        txtIDNo.setText("");
        txtImage.setText("");
        txtStatus.setText("");
        txtDeposit.setText("");
        txtPass.setText("");
        txtType.setText("");
        txtQues.setText("");
        txtAns.setText("");

    }

//    public void connect()
//    {
//        
//        // TODO code application logic here
//        DatabaseConnect objDBConnect;
//        objDBConnect = new DatabaseConnect();
//        connectionContainer connectContainer = objDBConnect.DBConnect("Sem2_project_group2", "sa", "abc123");
//        
//        objConnection = connectContainer.getObjCon();
//        stmt = connectContainer.getStatement();
//    }
    public void showTable() {
        coModel = new DefaultTableModel();

        header = new Vector();
        header.add("ID");
        header.add("Name");
        header.add("Address");
        header.add("DOB");
        header.add("IDNo");
        header.add("Deposit");
        header.add("Phone");
        header.add("Email");

        header.add("Image");

        data = new Vector();

        coModel.setRowCount(0);

        try {
            //select * from Services
            sql = "select * from Collaborator";
            rs = stmt.executeQuery(sql);

            rs.beforeFirst();
            while (rs.next()) {
                row = new Vector();
                row.add(rs.getString("IDCo"));
                row.add(rs.getString("NameCo"));
                row.add(rs.getString("AddressCo"));
                row.add(rs.getString("DOBCo"));
                row.add(rs.getString("IdentificationNumberCo"));
                row.add(rs.getDouble("DepositCo"));
                row.add(rs.getString("PhoneCo"));
                row.add(rs.getString("EmailCo"));

                row.add(rs.getString("ImageCo"));

                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        coModel.setDataVector(data, header);
        tblCo.setModel(coModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
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
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCo = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtDOB = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtIDNo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtImage = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtDeposit = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtQues = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtAns = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("ID");

        jLabel3.setText("Name");

        jLabel4.setText("Address");

        jLabel5.setText("Phone");

        jLabel6.setText("Email");

        jLabel7.setText("Status");

        txtName.setToolTipText("");

        btnAdd.setText("Add");
        btnAdd.setPreferredSize(new java.awt.Dimension(99, 25));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.setPreferredSize(new java.awt.Dimension(99, 25));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(99, 25));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jRadioButton1.setText("Active");

        jRadioButton2.setText("Locked");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhone)
                            .addComponent(txtAddress)
                            .addComponent(txtName)
                            .addComponent(txtID)
                            .addComponent(txtEmail))
                        .addGap(57, 57, 57))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jRadioButton2.getAccessibleContext().setAccessibleParent(jRadioButton1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COLLABORATOR MANAGERMENT");

        tblCo.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCo);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("DOB");

        jLabel9.setText("IDNo");

        jLabel10.setText("Image");

        jLabel11.setText("Status");

        jLabel12.setText("Deposit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDNo)
                            .addComponent(txtImage)
                            .addComponent(txtDOB)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDeposit)
                            .addComponent(txtStatus))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("Pass");

        jLabel14.setText("Type");

        jLabel15.setText("Ques");

        jLabel16.setText("Answer");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPass)
                            .addComponent(txtType)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAns)
                            .addComponent(txtQues))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addGap(196, 196, 196))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        /*
        String IDCo;
        String NameCo, AddressCo, DOBCo, IDNoCo, PhoneCo, EmailCo, StatusCo, ImageCo, Pass, Type, Ques, Ans;
        String DepositCo;
        String labelButton = btnAdd.getText();
        if (labelButton.equalsIgnoreCase("Add"))
        {
            clearTxt();
            manageButton(true, false, false, false);
            manageTextfield(true, true, true,true, true, true,true, true, true, true, true, true, true, true);
            btnAdd.setText("Save");
        }else
        {
        
            try {
                //lay du lieu tu textField
                IDCo = txtID.getText();
                NameCo = txtName.getText();
                AddressCo = txtAddress.getText();
                DOBCo = txtDOB.getText();
                IDNoCo = txtIDNo.getText();
                PhoneCo = txtPhone.getText();
                EmailCo = txtEmail.getText();
                StatusCo = txtStatus.getText();
                ImageCo = txtImage.getText();
                //tra ve kieu String vi Price la kieu Double
                DepositCo = txtDeposit.getText();
                Pass = txtPass.getText();
                Type = txtType.getText();
                Ques = txtQues.getText();
                Ans = txtAns.getText();
                //insert into Account(ID, Password, Type, Question, Answer) values ('Co01', 'abc123', 'Co', 'Dog Name' , 'Duy')
                sql = "insert into Account(ID, Password, Type, Question, Answer) values ('" + IDCo + "', '" + Pass + "', '" + Type + "', '" + Ques + "' , '" + Ans + "')";
                stmt.executeUpdate(sql);

                //insert into Collaborator(IDCo, NameCo, AddressCo, DOBCo, IdentificationNumberCo, DepositCo, PhoneCo, EmailCo, StatusCo, ImageCo) values ('Co01', 'Duy', 'Q5', '2005-12-20',  '1234', 123, '12345', 'email', 'Normal', 'Link' )
                sql = "insert into Collaborator(IDCo, NameCo, AddressCo, DOBCo, IdentificationNumberCo, DepositCo, PhoneCo, EmailCo, StatusCo, ImageCo) values ('" + IDCo + "', '" + NameCo + "', '" + AddressCo + "', '" + DOBCo + "',  '" + IDNoCo + "', " + DepositCo + ", '" + PhoneCo + "', '" + EmailCo + "', '" + StatusCo + "', '" + ImageCo + "' )";
                stmt.executeUpdate(sql);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            showTable();
            btnAdd.setText("Add");
            
            manageButton(true, true, true, true);
            manageTextfield(false, false,false,false,false,false,false,false,false,false,false,false,false,false);
        }
         */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm(continueAccount, continueType, objConnection, stmt, "col").setVisible(true);
            }
        });
        dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblCoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCoMouseClicked
        // TODO add your handling code here:

        int row;
        String IDCo;
        String NameCo, AddressCo, DOBCo, IDNoCo, PhoneCo, EmailCo, StatusCo, ImageCo;
        Double DepositCo;

        row = tblCo.getSelectedRow();

        IDCo = (String) tblCo.getValueAt(row, 0);
        NameCo = (String) tblCo.getValueAt(row, 1);
        AddressCo = (String) tblCo.getValueAt(row, 2);
        DOBCo = (String) tblCo.getValueAt(row, 3);
        IDNoCo = (String) tblCo.getValueAt(row, 4);
        DepositCo = (Double) tblCo.getValueAt(row, 5);
        PhoneCo = (String) tblCo.getValueAt(row, 6);
        EmailCo = (String) tblCo.getValueAt(row, 7);
        StatusCo = (String) tblCo.getValueAt(row, 8);
        ImageCo = (String) tblCo.getValueAt(row, 9);

        txtID.setText(IDCo);
        txtName.setText(NameCo);
        txtAddress.setText(AddressCo);
        txtDOB.setText(DOBCo);
        txtIDNo.setText(IDNoCo);
        txtPhone.setText(PhoneCo);
        txtEmail.setText(EmailCo);
        txtStatus.setText(StatusCo);
        txtImage.setText(ImageCo);
        //tra ve kieu String vi Price la kieu Double
        txtDeposit.setText(String.valueOf(DepositCo));
    }//GEN-LAST:event_tblCoMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        String labelBtn = btnEdit.getText();
        if (labelBtn.equalsIgnoreCase("Edit")) {
            btnEdit.setText("Save");
            manageTextfield(false, true, true, true, true, true, true, true, true, true, true, true, true, true);
            manageButton(false, true, false, false);
        } else {
            String ID = txtID.getText();
            String Name = txtName.getText();
            String Address = txtAddress.getText();
            String Phone = txtPhone.getText();
            String Email = txtEmail.getText();
            String DOB = txtDOB.getText();
            String IDNo = txtIDNo.getText();
            String Image = txtImage.getText();
            String Status = txtStatus.getText();
            String Deposit = txtDeposit.getText();

            try {
                //update Guest set  NameSer = 'Ban nha', Price = 100 where IDSer = 'S06'
                sql = "update Collaborator set  NameCo = '" + Name + "', AddressCo = '" + Address + "', PhoneCo = '" + Phone + "',EmailCo = '" + Email + "', DOBCo = '" + DOB + "', IdentificationNumberCo = '" + IDNo + "', ImageCo = '" + Image + "', StatusCo = '" + Status + "', DepositCo = '" + Deposit + "' where IDCo = '" + ID + "'";
                stmt.executeUpdate(sql);
                btnEdit.setText("Edit");
                clearTxt();
                manageButton(true, true, true, true);
                showTable();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int check = JOptionPane.showConfirmDialog(this, "You want to delete,sure?");
            if (check == JOptionPane.OK_OPTION) {
                String ID = txtID.getText();
                //cau lenh SQL mau da kiem tra thu tren SQl
                //delete from Guest where IDGu = 'S06'
                sql = "delete from Collaborator where IDCo = '" + ID + "'";
                stmt.executeUpdate(sql);
                //xoa xong thi cap nhat lai Table
                showTable();
                //xoa cac textField
                clearTxt();
            } else {
                return;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(QuanlyCTV_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanlyCTV_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanlyCTV_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanlyCTV_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new QuanlyCTV_2().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCo;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAns;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtDeposit;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDNo;
    private javax.swing.JTextField txtImage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtQues;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}
