/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Duy;

import Library.G2FileBrowserExtend;
import Nam.RegisterForm;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
    
    String IDCo, NameCo, AddressCo, DOBCo, IDNoCo, PhoneCo, EmailCo, ImageCo, GradeCo;
    Double DepositCo;
    int NumberOfGuest;
    
    int StatusCo;
    
    String TypeCo, QuesCo, AnsCo, PassCo;
    
    Nam.MainControlInterface objMain;
    boolean checkInitRow;
    int initRow;

    /**
     * Creates new form QuanlyCTV
     *
     * @param account
     * @param type
     * @param objConnection
     * @param stmt
     */
    public QuanlyCTV_2(String account, String type, Connection objConnection, Statement stmt, Nam.MainControlInterface objMain) {
        this.objMain = objMain;
        this.objConnection = objConnection;
        this.stmt = stmt;
        continueAccount = account;
        continueType = type;
        initComponents();
        showTable();
        initData();
        pButton.attachButtonAndSetMainRight(pButton, type);
        //manageButton(true, true, true, true);
        manageTextfield(false, false, false, false, false, false, false, false, false, false, false, false, false, false);
    }
    
    //init data get from objMain
    public void initData()
    {
        if(objMain.getIDCo().isEmpty())
            return;
        IDCo = objMain.getIDCo();
        checkInitRow = false;
        TableModel objModel = tblCo.getModel();
        for (int i = 0; i < objModel.getRowCount(); i++) {
            if (IDCo.equalsIgnoreCase((String)objModel.getValueAt(i, 0)))
            {
                checkInitRow = true;
                initRow = i;
                break;
            }
        }        
        tblMouseClickedProcess();
    }

    public void manageButton(boolean btnAddStatus, boolean btnEditStatus, boolean btnDeleteStatus, boolean btnSearchStatus) {
        btnAdd.setEnabled(btnAddStatus);
        btnUpdate.setEnabled(btnEditStatus);
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
        header.add("GradeCo");
        header.add("Total Guest");

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
                row.add(rs.getString("GradeCo"));
                row.add(rs.getInt("NumberOfGuest"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        coModel.setDataVector(data, header);
        tblCo.setModel(coModel);
        //ẩn bớt mấy cột không cần thiết bằng modifyTable()
        //thực ra là xóa view, giữ nguyên Model
        modifyTable();
        
    }
    
    public void modifyTable()
    {
        tblCo.removeColumn(tblCo.getColumn("Address"));
        tblCo.removeColumn(tblCo.getColumn("IDNo"));
        tblCo.removeColumn(tblCo.getColumn("Image"));
        tblCo.removeColumn(tblCo.getColumn("GradeCo"));
    }

    private void setDataToAccountPanel()
    {
        try {
            //select Active from Account where ID = 'Co01'
            sql ="select * from Account where ID = '"+IDCo+"'";
            rs= stmt.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            TypeCo = rs.getString("Type");
            StatusCo = rs.getInt("Active");
            QuesCo = rs.getString("Question");
            AnsCo = rs.getString("Answer");
            PassCo = rs.getString("Password");
            
            txtPass.setText(PassCo);
            txtType.setText(TypeCo);
            txtQues.setText(QuesCo);
            txtAns.setText(AnsCo);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        radActivate = new javax.swing.JRadioButton();
        radLock = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
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
        pAccount = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtQues = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtAns = new javax.swing.JTextField();
        pCollaboratorImage = new Library.G2ImagePanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCo = new javax.swing.JTable();
        pButton = new Library.G2Panel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("ID");

        jLabel3.setText("Name");

        jLabel4.setText("Address");

        jLabel5.setText("Phone");

        jLabel6.setText("Email");

        jLabel7.setText("Status");

        txtName.setToolTipText("");

        buttonGroup1.add(radActivate);
        radActivate.setText("Active");

        buttonGroup1.add(radLock);
        radLock.setText("Locked");
        radLock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radLockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(radActivate)
                                .addGap(45, 45, 45)
                                .addComponent(radLock)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radActivate)
                    .addComponent(radLock)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        radLock.getAccessibleContext().setAccessibleParent(radActivate);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COLLABORATOR MANAGERMENT");

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
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDOB, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtIDNo)
                            .addComponent(txtImage)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStatus)
                            .addComponent(txtDeposit))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
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
                .addGap(14, 14, 14))
        );

        pAccount.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("Pass");

        jLabel14.setText("Type");

        jLabel15.setText("Ques");

        jLabel16.setText("Answer");

        javax.swing.GroupLayout pAccountLayout = new javax.swing.GroupLayout(pAccount);
        pAccount.setLayout(pAccountLayout);
        pAccountLayout.setHorizontalGroup(
            pAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAccountLayout.createSequentialGroup()
                        .addGroup(pAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addGap(76, 76, 76)
                        .addGroup(pAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtType)
                            .addComponent(txtPass)))
                    .addGroup(pAccountLayout.createSequentialGroup()
                        .addGroup(pAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(64, 64, 64)
                        .addGroup(pAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAns)
                            .addComponent(txtQues))))
                .addContainerGap())
        );
        pAccountLayout.setVerticalGroup(
            pAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAccountLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(16, 16, 16))
        );

        pCollaboratorImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pCollaboratorImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pCollaboratorImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pCollaboratorImageLayout = new javax.swing.GroupLayout(pCollaboratorImage);
        pCollaboratorImage.setLayout(pCollaboratorImageLayout);
        pCollaboratorImageLayout.setHorizontalGroup(
            pCollaboratorImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );
        pCollaboratorImageLayout.setVerticalGroup(
            pCollaboratorImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAdd.setText("Add");
        btnAdd.setPreferredSize(new java.awt.Dimension(99, 25));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(99, 25));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(99, 25));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pButtonLayout = new javax.swing.GroupLayout(pButton);
        pButton.setLayout(pButtonLayout);
        pButtonLayout.setHorizontalGroup(
            pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pButtonLayout.setVerticalGroup(
            pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pCollaboratorImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pCollaboratorImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radLockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radLockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radLockActionPerformed

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
       //tách thành method riêng ở bên dưới
       //để tận dụng lại khi initData
       tblMouseClickedProcess();
        
    }//GEN-LAST:event_tblCoMouseClicked

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
            row = tblCo.getSelectedRow();
        TableModel tblModel = tblCo.getModel();

        IDCo = (String) tblModel.getValueAt(row, 0);
        NameCo = (String) tblModel.getValueAt(row, 1);
        AddressCo = (String) tblModel.getValueAt(row, 2);
        DOBCo = (String) tblModel.getValueAt(row, 3);
        IDNoCo = (String) tblModel.getValueAt(row, 4);
        DepositCo = (Double) tblModel.getValueAt(row, 5);
        PhoneCo = (String) tblModel.getValueAt(row, 6);
        EmailCo = (String) tblModel.getValueAt(row, 7);
        ImageCo = (String) tblModel.getValueAt(row, 8);
        GradeCo = (String) tblModel.getValueAt(row, 9);
        NumberOfGuest = (int) tblModel.getValueAt(row, 10);

        txtID.setText(IDCo);
        txtName.setText(NameCo);
        txtAddress.setText(AddressCo);
        txtDOB.setText(DOBCo);
        txtIDNo.setText(IDNoCo);
        txtPhone.setText(PhoneCo);
        txtEmail.setText(EmailCo);
        //txtStatus.setText(StatusCo);
        txtImage.setText(ImageCo);
        //tra ve kieu String vi Price la kieu Double
        txtDeposit.setText(String.valueOf(DepositCo));
        //hiển thị hình ảnh
        pCollaboratorImage.inputImage(ImageCo);
        setRadButton();
        setDataToAccountPanel();
    }
    
    private void setRadButton()
    {
        try {
            //select Active from Account where ID = 'Co01'
            sql ="select Active from Account where ID = '"+IDCo+"'";
            rs= stmt.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            StatusCo = rs.getInt("Active");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (StatusCo == 1)
            radActivate.setSelected(true);
        else
            radLock.setSelected(true);
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        String labelBtn = btnUpdate.getText();
        if (labelBtn.equalsIgnoreCase("Update")) {
            btnUpdate.setText("Save");
            manageTextfield(false, true, true, true, true, true, true, true, true, true, true, true, true, true);
            manageButton(false, true, false, false);
        } else {
            //------------------------------------
            //Kiểm tra lỗi TextField trước khi update
            //------------------------------------
            
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
                sql = "update Collaborator set  NameCo = '" + Name + "', AddressCo = '" + Address + "', PhoneCo = '" + Phone + "',EmailCo = '" + Email + "', DOBCo = '" + DOB + "', IdentificationNumberCo = '" + IDNo + "', ImageCo = '" + Image + "', DepositCo = '" + Deposit + "' where IDCo = '" + ID + "'";
                stmt.executeUpdate(sql);
                btnUpdate.setText("Edit");
                clearTxt();
                manageButton(true, true, true, true);
                showTable();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

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

    private void pCollaboratorImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pCollaboratorImageMouseClicked
        // TODO add your handling code here:
        G2FileBrowserExtend objFileChooser = new G2FileBrowserExtend();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG Images", "jpg", "png");
        objFileChooser.setFileFilter(filter);
        int returnVal = objFileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.ImageCo = objFileChooser.getSelectedFile().getPath();
            txtImage.setText(ImageCo);
            pCollaboratorImage.inputImage(ImageCo);
        }
    }//GEN-LAST:event_pCollaboratorImageMouseClicked

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
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pAccount;
    /*
    private javax.swing.JPanel pButton;
    */
    private Library.G2Panel pButton;
    /*
    private javax.swing.JPanel pCollaboratorImage;
    */
    private Library.G2ImagePanel pCollaboratorImage;
    private javax.swing.JRadioButton radActivate;
    private javax.swing.JRadioButton radLock;
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
        objMain.setIDCo(IDCo);
    }
}
