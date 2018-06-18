/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dat_Le_2;

import Dat_Le.*;
import DatabaseConnection.DatabaseConnect;
import Library.G2Panel;
import Library.G2TextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Dat ThinkPad
 */
public class uiContract_2 extends javax.swing.JFrame implements Library.G2FrameInterface{
    Statement stmt;
    DatabaseConnect objDBConnect;
    Connection objConnection;
    ResultSet rs;
    String sql;
    
    HashMap<String, String> dataMap;
    HashMap<String, JTextField> txtMap;
    
    DefaultTableModel conModel;
    Vector header, row, data;
    
    String IDCon, DateCon, IDHo, StatusCon;
    Double PriceCon;
    String IDCo, IDGu, ImageGu, ImageCo;
    
    Library.DateChooser diaDateChooser;
    javax.swing.JFrame objFrame;
    
    Nam.MainControlInterface objMain;
    
    SearchData objSearch;
    String account, type;
    int initRow;
    boolean checkInitRow;
    
    /**
     * Creates new form uiContract
     */
    public uiContract_2(String Account, String type, Connection objConnection, Statement stmt, Nam.MainControlInterface objMain) {
        this.account = account;
        this.type = type;
        this.objConnection = objConnection;
        this.stmt = stmt;
        this.objMain = objMain;
        initComponents();        
        pContract.attachButtonAndSetMainRight(pContract, type);
        manageConfirmButton();
        attachRegexAndErrorInform(pContract);
        showTable("Select * from Contract");
        initDataFromMainControl();
        changeStatusAllTextField(pContract, false);
    }
    
    public uiContract_2(String Account, String type, Connection objConnection, Statement stmt, javax.swing.JFrame objFrame, Nam.MainControlInterface objMain) {
        this.account = account;
        this.type = type;
        this.objConnection = objConnection;
        this.stmt = stmt;
        this.objMain = objMain;
        this.objFrame = objFrame;
        initComponents();            
        pContract.attachButtonAndSetMainRight(pContract, type);
        manageConfirmButton();
        attachRegexAndErrorInform(pContract);
        showTable("Select * from Contract");
        changeStatusAllTextField(pContract, false);
        initData();
    }
    
    private void initDataFromMainControl()
    {
        if(objMain.getIDCon().isEmpty())
            return;
        IDCon = objMain.getIDCon();
        checkInitRow = false;
        TableModel objModel = tblCon.getModel();
        for (int i = 0; i < objModel.getRowCount(); i++) {
            if (IDCon.equalsIgnoreCase((String)objModel.getValueAt(i, 0)))
            {
                checkInitRow = true;
                initRow = i;
                break;
            }
        }        
        tblMouseClickedProcess();
    }
    
    public void manageConfirmButton()
    {
        if (type.equalsIgnoreCase("ad"))
            btnConfirm.setEnabled(true);
        else
            btnConfirm.setEnabled(false);
    }
    
//    public void initData()
//    {
//        dataMap = new HashMap<String, String>();
//        dataMap.put("IDCon", "CON001");
//        dataMap.put("DateCon", "12-12-2018");
//        dataMap.put("IDHo", "HOL001" );
//        dataMap.put("PriceCon", "1234");
//        dataMap.put("StatusCon", "Waiting");
//        btnConfirm.setEnabled(false);        
//        txtMap = new HashMap<String, JTextField>(); 
//        
//    }
    
    public void initData()
    {
        IDHo = objMain.getIDHo();
        txtIDHo.setText(IDHo);
        IDCo = objMain.getIDCo();
        IDGu = objMain.getIDGu();
        txtStatusCon.setText("Waiting");
        if (objFrame instanceof uiHolding_2)
        {
            uiHolding_2 tempObjFrame = (uiHolding_2)objFrame;
            txtDateCon.setText(tempObjFrame.getDateHo());
            txtPriceCon.setText(String.valueOf(tempObjFrame.getTotalHo()));            
        }        
        setImageGuestAndCollaborator();
        //tạo giao diện gây sự chú ý
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAttentionGUI();
            }
        }
        );
          //createAttentionGUI();
    }
    
    public void createAttentionGUI()
    {        
        Component[] objListComp = pContract.getComponents();
        for (Component objComp : objListComp) {
            if(objComp instanceof G2TextField)
                objComp.setBackground(Color.GREEN);
        }
        btnAdd.doClick();
        btnAdd.setBackground(Color.GREEN);
        btnConfirm.setEnabled(false);
        JOptionPane.showMessageDialog(this, "Please fill in GREEN form and Click Save button to complete your contract", "New Contract", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
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
    
    public void initDateChooser()
    {
        diaDateChooser = new Library.DateChooser(this, true);
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                diaDateChooser.showGUI();
                //diaDateChooser.setVisible(true);
            }
        }        
        );   
    }
    
    public void clearAllTextField(G2Panel panel)
    {
        Component[] objComponents = panel.getComponents();
        for (Component objComp : objComponents) {
            if (objComp instanceof G2TextField)
                ((G2TextField) objComp).setText("");
        }
    }
    
    public void changeStatusAllTextField(G2Panel panel, boolean status)
    {
        Component[] objComponents = panel.getComponents();
        for (Component objComp : objComponents) {
            if (objComp instanceof G2TextField)
                ((G2TextField) objComp).setEditable(status);
        }
        txtStatusCon.setEditable(false);
    }
    
    public boolean validateAllTextField()
    {
        Component[] objListComp = pContract.getComponents();
        String allError = "Please fix GREEN TextField\n";
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
            JOptionPane.showMessageDialog(this, allError, "INPUT ERROR", JOptionPane.ERROR_MESSAGE);
        return error;
    }
    
//    public void testCollection(HashMap data, JPanel panel)
//    {
//        Component[] objGetComponents = pContract.getComponents();
//        
//        Set keySet = data.entrySet();
//        Iterator ite = keySet.iterator();
//        
//        while (ite.hasNext())
//        {
//            Map.Entry entry = (Map.Entry)ite.next();
//            String tempKey = (String)entry.getKey();
//            System.out.println(tempKey);
//        }
//        
//    }
    
    
//    public void connectToDatabase()
//    {
//        objDBConnect = new DatabaseConnect();        
//        objConnection = objDBConnect.DBConnect("Sem2_project_group2", "sa", "abc123");
//        try {
//            stmt = objConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

//    public void bindTextField()
//    {
//        Component[] objGetComponents = pContract.getComponents();
//        for (Component objTemp : objGetComponents) {
//            if (objTemp instanceof JTextField)
//            {
//                JTextField obj = (JTextField) objTemp;
//                
//                Set keySet = dataMap.keySet();
//                Iterator ite = keySet.iterator();
//                
//                
//                while(ite.hasNext())
//                {
//                    String key = (String)ite.next();
//                    String name = obj.getText();
//                    String test = name.substring(3);
//                    
//                    if (test.equalsIgnoreCase(key))
//                    {
//                        txtMap.put(key, obj);
//                        obj.setText(dataMap.get(key));
//                    }
//                }
//                
//                
//            }
//        }
//        
//    }
    
    public void manageBtn(boolean btnSearchStatus, boolean btnAddStatus, boolean btnUpdateStatus, boolean btnDeleteStatus)
    {
        btnSearch.setEnabled(btnSearchStatus);
        btnAdd.setEnabled(btnAddStatus);
        btnUpdate.setEnabled(btnUpdateStatus);
        btnDelete.setEnabled(btnDeleteStatus);
        pContract.attachButtonAndSetMainRight(pContract, type);
    }
    
    public void showTable(String sql)
    {
        conModel = new DefaultTableModel();
        
        header = new Vector();
        header.add("ID Contract");
        header.add("ID Holding");
        header.add("Date Contract");
        header.add("Price");
        header.add("Status");
        
        data = new Vector();
        
        conModel.setRowCount(0);
        
        try {            
            //select * from Services
            if (sql.isEmpty())                
                sql = "select * from Contract";
            rs = stmt.executeQuery(sql);
            
            rs.beforeFirst();
            while(rs.next())
            {
                row = new Vector();                
                row.add( rs.getString("IDCon"));
                row.add(rs.getString("DateCon"));
                row.add(rs.getString("IDHo"));
                row.add(rs.getDouble("PriceCon"));
                row.add(rs.getString("StatusCon"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        conModel.setDataVector(data, header);
        tblCon.setModel(conModel);
        //tblBook.setModel(bookModel);
    }
    public void getDataFromTextField()
    {
        IDCon = txtIDCon.getText();
        DateCon = txtDateCon.getText();
        IDHo = txtIDHo.getText();
        PriceCon = Double.parseDouble(txtPriceCon.getText());
        StatusCon = txtStatusCon.getText();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pGuestImage = new Library.G2ImagePanel();
        pCollaboratorImage = new Library.G2ImagePanel();
        jLabel13 = new javax.swing.JLabel();
        pContract = new Library.G2Panel();
        jLabel14 = new javax.swing.JLabel();
        txtIDCon = new Library.G2TextField();
        txtIDHo = new Library.G2TextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDateCon = new Library.G2TextField();
        txtPriceCon = new Library.G2TextField();
        jLabel17 = new javax.swing.JLabel();
        txtStatusCon = new Library.G2TextField();
        jLabel18 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblCon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Contract", "ID Holding", "Date", "Price", "Status"
            }
        ));
        tblCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCon);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Contract");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Guest");

        pGuestImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pGuestImageLayout = new javax.swing.GroupLayout(pGuestImage);
        pGuestImage.setLayout(pGuestImageLayout);
        pGuestImageLayout.setHorizontalGroup(
            pGuestImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );
        pGuestImageLayout.setVerticalGroup(
            pGuestImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        pCollaboratorImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pCollaboratorImageLayout = new javax.swing.GroupLayout(pCollaboratorImage);
        pCollaboratorImage.setLayout(pCollaboratorImageLayout);
        pCollaboratorImageLayout.setHorizontalGroup(
            pCollaboratorImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );
        pCollaboratorImageLayout.setVerticalGroup(
            pCollaboratorImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Collaborator");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGuestImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(98, 98, 98)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(pCollaboratorImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pGuestImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pCollaboratorImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pContract.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("ID");

        txtIDCon.setText("^(Con)\\d+errHoxx with x is number");

        txtIDHo.setText("^(Ho)\\d+errHoxx with x is number");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("ID Holding");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Date");

        txtDateCon.setText("^\\d{4}(-)\\d{2}(-)\\d{2}erryyyy-MM-dd");
        txtDateCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDateConMouseClicked(evt);
            }
        });
        txtDateCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateConActionPerformed(evt);
            }
        });

        txtPriceCon.setText("\\d+(.)*(\\d)+errxxx.xx with x is number");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Price");

        txtStatusCon.setEditable(false);
        txtStatusCon.setText("\\w+(.)*\\werrnormal paragraph");
        txtStatusCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusConActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Status");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
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

        btnConfirm.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pContractLayout = new javax.swing.GroupLayout(pContract);
        pContract.setLayout(pContractLayout);
        pContractLayout.setHorizontalGroup(
            pContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContractLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pContractLayout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pContractLayout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContractLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtStatusCon, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContractLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPriceCon, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContractLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDateCon, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContractLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIDCon, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pContractLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtIDHo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pContractLayout.setVerticalGroup(
            pContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContractLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtIDCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtIDHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtDateCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtPriceCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtStatusCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(pContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pContract, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pContract, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        //this.bindTextField();
        if (!type.equalsIgnoreCase("ad"))
        {
            JOptionPane.showMessageDialog(this, "Sorry. This Feature just be used by Administrator", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int ans = JOptionPane.showConfirmDialog(this, "Are you sure to CONFIRM this Contract", "Warning", JOptionPane.OK_CANCEL_OPTION);
        if (ans == JOptionPane.CANCEL_OPTION)
            return;
        txtStatusCon.setText("Activated");
        btnUpdate.setText("Save");
        btnUpdate.doClick();
        sendMoneyToCollaborator();
    }//GEN-LAST:event_btnConfirmActionPerformed

    public void sendMoneyToCollaborator()
    {
        try {
            //select CommissionHo, IDCo from Holding where IDHo = 'Ho01'
            sql = "select CommissionHo, IDCo from Holding where IDHo = '"+IDHo+"'";
            rs = stmt.executeQuery(sql);
            rs.beforeFirst();
            rs.next();
            Double money = rs.getDouble("CommissionHo");
            String IDCo = rs.getString("IDCo");
            System.out.println(money);
            System.out.println(IDCo);
            
            //update Collaborator set DepositCo = DepositCo + 1000 where IDCo = 'Co01'
            sql = "update Collaborator set DepositCo = DepositCo + "+money.toString()+" where IDCo = '"+IDCo+"'";
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void txtDateConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateConActionPerformed

    private void txtStatusConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusConActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
//        Set keySet = txtMap.keySet();
//        Iterator ite = keySet.iterator();
//        while(ite.hasNext())
//        {
//            String key = (String)ite.next();
//            if (key.equalsIgnoreCase("IDCon"))
//            {
//                txtMap.get(key).setText("Test");
//            }
//        }
        
        changeStatusAllTextField(pContract, true);
        manageBtn(false, true, false, false);        
        String labelButton = btnAdd.getText();
        if (labelButton.equalsIgnoreCase("Add"))
        {
            btnAdd.setText("Save");
        }else
        {
            if (validateAllTextField())
                return;
            getDataFromTextField();
            try {
                //insert into [Contract] values ('Con01', '2018-6-3', 'Ho01', 9500, 'Da xac nhan')
                sql = "insert into [Contract] values ('"+IDCon+"', '"+DateCon+"', '"+IDHo+"', "+ PriceCon+", '"+StatusCon+"')";
                stmt.executeUpdate(sql);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            sql = "select * from Contract";
            showTable(sql);
            btnAdd.setText("Add");
            manageBtn(true, true, true, true);
            clearAllTextField(pContract);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblConMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConMouseClicked
        // TODO add your handling code here:
        //tách riêng thành method khác để tái sử dụng khi cần
        //init Data từ MainControl
        tblMouseClickedProcess();
    }//GEN-LAST:event_tblConMouseClicked

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
            row = tblCon.getSelectedRow();
        IDCon = (String) tblCon.getValueAt(row, 0);       
        DateCon = (String)tblCon.getValueAt(row, 1);
        IDHo = (String)tblCon.getValueAt(row, 2);
        PriceCon = (Double)tblCon.getValueAt(row, 3);
        StatusCon = (String)tblCon.getValueAt(row, 4);       
        
        txtIDCon.setText(IDCon);
        txtDateCon.setText(DateCon);
        txtIDHo.setText(IDHo);
        txtPriceCon.setText(String.valueOf(PriceCon));
        txtStatusCon.setText(StatusCon);
        
        setImageGuestAndCollaborator();
        if (!StatusCon.equalsIgnoreCase("activated"))
            btnConfirm.setEnabled(true);
        else
            btnConfirm.setEnabled(false);
    }
    
    public void setImageGuestAndCollaborator()
    {
        try {
            //select IDGu, IDCo from Holding where IDHo = 'Ho01'
            sql = "select IDGu, IDCo from Holding where IDHo = '"+ IDHo +"'";
            rs = stmt.executeQuery(sql);
            rs.beforeFirst();
            while(rs.next())
            {
                IDGu = rs.getString("IDGu");
                IDCo = rs.getString("IDCo");
            }
            
            //find Guest Image
            rs = stmt.executeQuery("Select ImageGu from Guest where IDGu = '" + IDGu + "'");
            rs.beforeFirst();
            rs.next();
            ImageGu = rs.getString("ImageGu");
            System.out.println(ImageGu);
            
            //find Collaborator Image
            rs = stmt.executeQuery("Select ImageCo from Collaborator where IDCo = '" + IDCo + "'");
            rs.beforeFirst();
            rs.next();
            ImageCo = rs.getString("ImageCo");
            System.out.println(ImageCo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        pGuestImage.inputImage(ImageGu);
        pCollaboratorImage.inputImage(ImageCo);
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
                        
        manageBtn(false, false, true, false);
        changeStatusAllTextField(pContract, true);
        String labelButton = btnUpdate.getText();
        if (labelButton.equalsIgnoreCase("Update"))
        {
            btnUpdate.setText("Save");
        }else
        {
            if (validateAllTextField())
                return;
            getDataFromTextField();        
            try {
                //update Contract set DateCon = '1991-03-03', IDHo = 'Ho01', PriceCon = 1234, StatusCon = 'Blocked' where IDCon = 'Con01'
                sql = "update Contract set DateCon = '"+ DateCon +"', IDHo = '"+ IDHo +"', PriceCon = "+ PriceCon +", StatusCon = '" + StatusCon + "' where IDCon = '" + IDCon + "'";
                stmt.executeUpdate(sql);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            sql = "select * from COntract";
            showTable(sql);
            btnUpdate.setText("Update");
            clearAllTextField(pContract);
            manageBtn(true, true, true, true);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtDateConMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDateConMouseClicked
        // TODO add your handling code here:
        initDateChooser();
        diaDateChooser.addListener(txtDateCon);
        diaDateChooser.setVisible(true);
    }//GEN-LAST:event_txtDateConMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String[] arrSearch = {"IDCon" , "DateCon" , "IDHo" ,"StatusCon" };
        objSearch = new SearchData(this, true);
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                objSearch.showGUI(arrSearch, "Contract");
                objSearch.setVisible(true);
            }
        }        
        );
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
            java.util.logging.Logger.getLogger(uiContract_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uiContract_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uiContract_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uiContract_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new uiContract_2().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    /*
    private javax.swing.JPanel pCollaboratorImage;
    */
    private Library.G2ImagePanel pCollaboratorImage;
    /*
    private javax.swing.JPanel pContract;
    */
    private Library.G2Panel pContract;
    /*
    private javax.swing.JPanel pGuestImage;
    */
    private Library.G2ImagePanel pGuestImage;
    private javax.swing.JTable tblCon;
    /*
    private javax.swing.JTextField txtDateCon;
    */
    private Library.G2TextField txtDateCon;
    /*
    private javax.swing.JTextField txtIDCon;
    */
    private Library.G2TextField txtIDCon;
    /*
    private javax.swing.JTextField txtIDHo;
    */
    private Library.G2TextField txtIDHo;
    /*
    private javax.swing.JTextField txtPriceCon;
    */
    private Library.G2TextField txtPriceCon;
    /*
    private javax.swing.JTextField txtStatusCon;
    */
    private Library.G2TextField txtStatusCon;
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
        objMain.setIDHo(IDHo);
        objMain.setIDCo(IDCo);
        objMain.setIDGu(IDGu);
        objMain.setIDCon(IDCon);
    }
}
