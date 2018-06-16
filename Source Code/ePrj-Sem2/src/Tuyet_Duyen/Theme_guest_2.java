/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tuyet_Duyen;


import Library.DateChooser;
import Library.G2FileBrowserExtend;

import Library.G2Panel;
import Library.G2TextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Nam.RegisterForm;
import java.awt.Component;

import javax.swing.SwingUtilities;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;


/**
 *
 * @author Elisa
 */
public class Theme_guest_2 extends javax.swing.JFrame {

    /**
     * Creates new form Theme_guest
     */
    DefaultTableModel CusModel;
    Vector header,data,row;
    String sql;
    ResultSet rs;
    Statement stmt;
    Connection objConnection;



    DateChooser objDateChooser;
    


    
    String IDGu;
    String NameGu,DOBGu,IdentificationNumberGu,PhoneGu,EmailGu,ImageGu,StatusGu,IDCo;
    

    /**/
    String continueAccount;
    public Theme_guest_2(String account, String type, Connection objConnection, Statement stmt) {
        initComponents();
        this.objConnection = objConnection;
        this.stmt = stmt;
        continueAccount = account;
        pButton.attachButtonAndSetMainRight(pButton, type);
        attachRegexAndErrorInform(pGuest);
        //connectSQL();
        //initDateChooser();
        showTable();
        //modifyTable();
        //manageButton(true,false,false);
        manageTextField(false, false, false,false, false, false,false, false);
    }



    
    //---------------------------------------------
    //Phần này dùng để bỏ bớt mấy cột không cần thiết trong bảng đi
    //dữ liệu của Table vẫn được lưu trong modal
    //cột loại bỏ chỉ là view
    //----------------------------------------------
    //VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
    public void modifyTable()
    {
        tblCustomer.removeColumn(tblCustomer.getColumn("Identi No"));
        tblCustomer.removeColumn(tblCustomer.getColumn("Email"));
        tblCustomer.removeColumn(tblCustomer.getColumn("Image"));
        tblCustomer.removeColumn(tblCustomer.getColumn("Collaborator ID"));
    }
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    //---------------------------------------------
    //Phần này dùng để bỏ bớt mấy cột không cần thiết trong bảng đi
    //dữ liệu của Table vẫn được lưu trong modal
    //cột loại bỏ chỉ là view
    //----------------------------------------------

    
    //-------------------------------------------------------
    //cái này dùng để lấy giá trị (gồm Pattern và Thông báo lỗi)
    //mà mình thêm vào TextField ở trong phần Design
    //sau đó nhét vào trong tính năng kiểm tra của
    //G2TextField
    //--------------------------------------------------------
    //VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
    
    public void attachRegexAndErrorInform(Library.G2Panel panel)
    {
        //regexMap = new HashMap<JTextField, String>();
        Component[] listComponent = panel.getComponents();
        for (Component component : listComponent) {
            if (component instanceof Library.G2TextField)
            {
                G2TextField tempTextField = (G2TextField)component;
                //regexMap.put(tempTextField, tempTextField.getText() );
                String data = tempTextField.getText();
                tempTextField.setPatStr(data.substring(0, data.indexOf("err")));
                String tempErr = "' Must change to type of: ";
                tempTextField.setError(tempErr + data.substring(data.indexOf("err") + 3, data.length()));
                tempTextField.setText("");
            }
        }
    }    
    
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    //-------------------------------------------------------
    //cái này dùng để lấy giá trị (gồm Pattern và Thông báo lỗi)
    //mà mình thêm vào TextField ở trong phần Design
    //sau đó nhét vào trong tính năng kiểm tra của
    //G2TextField
    //--------------------------------------------------------
    
    //--------------------------------------------------------
    //Cái này dùng để kiểm tra coi các TextField được nhập vào
    //có bị lỗi gì không dựa trên các Pattern mình nhập ở Design
    //--------------------------------------------------------
    //VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
    public boolean validateAllTextField(G2Panel panel)
    {
        Component[] objListComp = panel.getComponents();
        String allError = "";
        boolean error = false;
        for (Component objComp : objListComp) {
            if (objComp instanceof G2TextField)
            {
                String temp = ((G2TextField) objComp).allValidate();
                if (!temp.isEmpty())
                {
                    error = true;
                    allError += temp+ "\n";
                }
            }
        }
        if (error == true)
        {
            JOptionPane.showMessageDialog(this, allError, "Bi loi", JOptionPane.ERROR_MESSAGE);
            return true;
        }else
            return false;
    }
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    //--------------------------------------------------------
    //Cái này dùng để kiểm tra coi các TextField được nhập vào
    //có bị lỗi gì không dựa trên các Pattern mình nhập ở Design
    //--------------------------------------------------------
    

    //------------------------------------------------------
    //tui tạo lại method mới để connect nên tui ẩn cái này đi
    //------------------------------------------------------
    //VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
    
    
//    public void connectSQL(){
//        DatabaseConnect objDBConnect;
//        objDBConnect = new DatabaseConnect();
//        
//        objConnection = objDBConnect.DBConnect("Sem2_project_group2", "sa", "abc123");
//        try {
//            stmt = objConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
    
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    //------------------------------------------------------
    //tui tạo lại method mới để connect nên tui ẩn cái này đi
    //------------------------------------------------------
    
    
    //------------------------------------------------------
    //đây là cái method mới để kết nối
    //------------------------------------------------------
    //VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
//    public void connectSQL()
//    {
//        DatabaseConnect objDBConnect;
//        objDBConnect = new DatabaseConnect();
//        connectionContainer connectContainer = objDBConnect.DBConnect("Sem2_project_group2", "sa", "abc123");
//        
//        objConnection = connectContainer.getObjCon();
//        stmt = connectContainer.getStatement();
//    }
    
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    //------------------------------------------------------
    //đây là method mới để kết nối
    //------------------------------------------------------
    
    
    public void showTable()
    {
        CusModel = new DefaultTableModel();
        header = new Vector();
        header.add("ID");
        header.add("Name");
        header.add("Birthday");
        header.add("Identi No");
        header.add("Phone");
        header.add("Email");
        header.add("Image");
        header.add("Status");
        header.add("Collaborator ID");
      
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
                row.add(rs.getString("PhoneGu"));
                row.add(rs.getString("EmailGu"));
                row.add(rs.getString("ImageGu"));
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
        modifyTable();
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



    public void initDateChooser()
    {
        objDateChooser = new DateChooser(this, true);
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                objDateChooser.showGUI();
            }
        }        
        );
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        pButton = new Library.G2Panel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        pGuest = new Library.G2Panel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new Library.G2TextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new Library.G2TextField();
        jLabel4 = new javax.swing.JLabel();
        txtBirth = new Library.G2TextField();
        jLabel5 = new javax.swing.JLabel();
        txtIDNo = new Library.G2TextField();
        jLabel6 = new javax.swing.JLabel();
        txtPhone = new Library.G2TextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new Library.G2TextField();
        jLabel8 = new javax.swing.JLabel();
        txtStatus = new Library.G2TextField();
        jLabel9 = new javax.swing.JLabel();
        txtCoID = new Library.G2TextField();
        jLabel1 = new javax.swing.JLabel();


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GUESTs");

        pGuestImage = new Library.G2ImagePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GUESTs");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());


        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 51));
        jLabel11.setText("Customner Management");
        jLabel11.setToolTipText("");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, 549, -1));

        pButton.setBackground(new java.awt.Color(102, 0, 102));

        btnAdd.setBackground(new java.awt.Color(102, 0, 102));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(102, 0, 102));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(102, 0, 102));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pButtonLayout = new javax.swing.GroupLayout(pButton);
        pButton.setLayout(pButtonLayout);
        pButtonLayout.setHorizontalGroup(
            pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pButtonLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pButtonLayout.setVerticalGroup(
            pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(pButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 264, -1, 152));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblCustomer.setBackground(new java.awt.Color(255, 204, 255));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 60, 341, -1));

        pGuest.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("ID");

        txtID.setText("^(Gu)\\d+errGuxx with x is number");
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel3.setText("Name");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblCustomer.setBackground(new java.awt.Color(255, 204, 255));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pGuest.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("ID");

        txtID.setText("^(Gu)\\d+errGuxx with x is number");
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel3.setText("Name");


        txtName.setText("\\w+(.)*\\w*errnormal paragraph");

        jLabel4.setText("Birthday");

        txtBirth.setText("^\\d{4}(-)\\d{2}(-)\\d{2}erryyyy-MM-dd");

        txtBirth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBirthMouseClicked(evt);
            }
        });



        jLabel5.setText("Identi No");

        txtIDNo.setText("\\d{9}errsequence of 9 digit");

        jLabel6.setText("Phone");

        txtPhone.setText("^(0)\\d{8,10}errsequence of 9 - 11 digit");

        jLabel7.setText("Email");

        txtEmail.setText("(\\w+)[@](\\w+)[.](\\w+)[.]?\\w*errexample@xxx.xx");

        jLabel8.setText("Status");

        txtStatus.setText("\\w+(.)*\\w*errnormal paragraph");

        jLabel9.setText("CollaboratorsID");

        txtCoID.setText("^(Co)\\d+errHoxx with x is number");

        jLabel1.setBackground(new java.awt.Color(153, 0, 102));
        jLabel1.setText("Detail:");

        javax.swing.GroupLayout pGuestLayout = new javax.swing.GroupLayout(pGuest);
        pGuest.setLayout(pGuestLayout);
        pGuestLayout.setHorizontalGroup(
            pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGuestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pGuestLayout.createSequentialGroup()
                        .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txtName)
                            .addComponent(txtBirth)
                            .addComponent(txtID)
                            .addComponent(txtIDNo)
                            .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(txtStatus)
                            .addComponent(txtCoID)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pGuestLayout.setVerticalGroup(
            pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pGuestLayout.createSequentialGroup()

                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                .addContainerGap(22, Short.MAX_VALUE)

                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIDNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pGuest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pGuest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(61, 61, 61))

        );

        getContentPane().add(pGuest, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        pGuestImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pGuestImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pGuestImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pGuestImageLayout = new javax.swing.GroupLayout(pGuestImage);
        pGuestImage.setLayout(pGuestImageLayout);
        pGuestImageLayout.setHorizontalGroup(
            pGuestImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );
        pGuestImageLayout.setVerticalGroup(
            pGuestImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(pGuestImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 264, -1, 152));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        // TODO add your handling code here:
        manageButton(true, true, true);
        int row;
        
        
        
        row = tblCustomer.getSelectedRow();
        TableModel tblModel = tblCustomer.getModel();
        
        IDGu = (String) tblModel.getValueAt(row, 0);        
        NameGu = (String)tblModel.getValueAt(row, 1);
        DOBGu = (String)tblModel.getValueAt(row, 2);
        IdentificationNumberGu = (String)tblModel.getValueAt(row, 3);
        PhoneGu = (String)tblModel.getValueAt(row, 4);
        EmailGu = (String)tblModel.getValueAt(row, 5);
        ImageGu = (String)tblModel.getValueAt(row, 6);
        StatusGu = (String)tblModel.getValueAt(row, 7);
        IDCo = (String)tblModel.getValueAt(row, 8);
        
        txtID.setText(IDGu);
        txtName.setText(NameGu);
        txtBirth.setText(DOBGu);
        txtIDNo.setText(IdentificationNumberGu);
        txtPhone.setText(PhoneGu);
        txtEmail.setText(EmailGu);
        txtStatus.setText(StatusGu);
        txtCoID.setText(IDCo);
        //show Guest Image
        pGuestImage.inputImage(ImageGu);
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


        } else {
            //kiem tra cac textField co thoa man khong


        }else
        {
            //kiem tra cac textField co thoa man khong 
            //nếu có lỗi thì thoát ra khỏi lệnh update
            if(validateAllTextField(pGuest))
                return;



            String ID = txtID.getText();
            String Name = txtName.getText();
            String DOB = txtBirth.getText();
            String IDentiNo = txtIDNo.getText();
            String Phone = txtPhone.getText();
            String Email = txtEmail.getText();
            //String Image = 
            String Status = txtStatus.getText();
            String CoID = txtCoID.getText();
            try {
                //tien hanh update thong tin len database
                //cau lenh sql mau da kiem tra thu tren SQL
                //update Guest set  NameSer = 'Ban nha', Price = 100 where IDSer = 'S06'
                sql = "update Guest set  NameGu = '" + Name + "',DOBGu = '" + DOB + "',IdentificationNumberGu = '" + IDentiNo + "',PhoneGu = '" + Phone + "',EmailGu  = '" + Email + "', ImageGu = '"+ ImageGu +"' ,StatusGu = '" + Status + "', IDCo = '" + CoID + "' where IDGu = '" + ID + "'";
                
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

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int check = JOptionPane.showConfirmDialog(this, "Are you sure for deleting?");
            if (check == JOptionPane.OK_OPTION)
            {
                String ID = txtID.getText();
                //cau lenh SQL mau da kiem tra thu tren SQl
                //delete from Guest where IDGu = 'S06'
                sql = "delete from Guest where IDGu = '" + ID + "'";
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
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm(continueAccount,"gu", objConnection, stmt).setVisible(true);
            }
        });
    }//GEN-LAST:event_btnAddActionPerformed


    private void txtBirthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBirthMouseClicked
        // TODO add your handling code here:
        initDateChooser();
        objDateChooser.addListener(txtBirth);
        objDateChooser.setVisible(true);
    }//GEN-LAST:event_txtBirthMouseClicked

    

    private void pGuestImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pGuestImageMouseClicked
        // TODO add your handling code here:
        G2FileBrowserExtend objFileChooser = new G2FileBrowserExtend();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JPG & PNG Images", "jpg", "png");
        objFileChooser.setFileFilter(filter);
        int returnVal = objFileChooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
           this.ImageGu = objFileChooser.getSelectedFile().getPath();
           pGuestImage.inputImage(ImageGu);
        }
    }//GEN-LAST:event_pGuestImageMouseClicked

    

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
            java.util.logging.Logger.getLogger(Theme_guest_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Theme_guest_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Theme_guest_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Theme_guest_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Theme_guest_2().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    /*
    private javax.swing.JPanel pButton;
    */
    private Library.G2Panel pButton;
    /*
    private javax.swing.JPanel pGuest;
    */
    private Library.G2Panel pGuest;

    /*
    private javax.swing.JPanel pGuestImage;
    */
    private Library.G2ImagePanel pGuestImage;
    private javax.swing.JTable tblCustomer;
    /*
    private javax.swing.JTextField txtBirth;
    */
    private Library.G2TextField txtBirth;
    /*
    private javax.swing.JTextField txtCoID;
    */
    private Library.G2TextField txtCoID;
    /*
    private javax.swing.JTextField txtEmail;
    */
    private Library.G2TextField txtEmail;
    /*
    private javax.swing.JTextField txtID;
    */
    private Library.G2TextField txtID;
    /*
    private javax.swing.JTextField txtIDNo;
    */
    private Library.G2TextField txtIDNo;
    /*
    private javax.swing.JTextField txtName;
    */
    private Library.G2TextField txtName;
    /*
    private javax.swing.JTextField txtPhone;
    */
    private Library.G2TextField txtPhone;
    /*
    private javax.swing.JTextField txtStatus;
    */
    private Library.G2TextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
