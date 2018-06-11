/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dat_Le_2;

import Dat_Le.*;
import DatabaseConnection.DatabaseConnect;
import DatabaseConnection.connectionContainer;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Dat ThinkPad
 */
public class uiHolding_2 extends javax.swing.JFrame implements Library.getIDFromFrame{
    
    Statement stmt;
    DatabaseConnect objDBConnect;
    Connection objConnection;
    ResultSet rs;
    String sql;
    
    HashMap<String, String> dataMap;
    HashMap<String, JTextField> txtMap;
    
    DefaultTableModel hoModel;
    Vector header, row, data;
    
    String IDHo, IDGu, IDApa, IDCo, DateHo,FromDateHo, ToDateHo, PayStatusHo, IDSer;
    Double CommissionHo, TotalHo;

    /**
     * Creates new form uiHolding
     */
    public uiHolding_2() 
    {
        initComponents();
        connectToDatabase();
        initData();
        showTable("Select * from Holding");
    }
    
    public uiHolding_2(Connection objConnection, Statement stmt)
    {
        initComponents();
        this.objConnection = objConnection;
        this.stmt = stmt;
        initData();
        showTable("Select * from Holding");
    }
    
  
    public void modifyTable(JTable table)
    {
        table.removeColumn(table.getColumn("Gu"));
        table.removeColumn(table.getColumn("Apa"));
        table.removeColumn(table.getColumn("Co"));
        table.removeColumn(table.getColumn("Commission"));
    }
    
    public void connectToDatabase()
    {
        DatabaseConnect objDBConnect;
        objDBConnect = new DatabaseConnect();
        connectionContainer connectContainer = objDBConnect.DBConnect("Sem2_project_group2", "sa", "abc123");
        
        objConnection = connectContainer.getObjCon();
        stmt = connectContainer.getStatement();
    }
    
    public void initData()
    {
        manageTextField(pHolding);
        manageTextField(pGuest);
        manageTextField(pCollaborator);
        IDCo = "";
        IDGu = "";
    }

    public void manageTextField(JPanel targetPanel)
    {
        Component[] objComponent = targetPanel.getComponents();
        for (Component comp : objComponent) {
            if (comp instanceof JTextField)
            {
                ((JTextField) comp).setText("");
            }
        }
    }
    
    public void manageBtn(boolean btnSearchStatus, boolean btnAddStatus, boolean btnUpdateStatus, boolean btnDeleteStatus)
    {
        btnSearch.setEnabled(btnSearchStatus);
        btnAdd.setEnabled(btnAddStatus);
        btnUpdate.setEnabled(btnUpdateStatus);
        btnDelete.setEnabled(btnDeleteStatus);
    }
    
    public void getDataFromTextField()
    {
        IDHo = txtIDHo.getText();
        IDGu = txtIDGu.getText();
        IDApa = txtIDApa.getText();
        IDCo = txtIDCo.getText();
        DateHo = txtDateHo.getText();
        FromDateHo = txtFromDateHo.getText();
        ToDateHo = txtToDateHo.getText();
        PayStatusHo = txtPayStatusHo.getText();
        TotalHo = Double.parseDouble(txtTotalHo.getText());
        CommissionHo = Double.parseDouble(txtCommissionHo.getText());
        IDSer = txtIDSer.getText();
    }
    
    public void setDataToGuestPanel()
    {
        try {
            
            rs = stmt.executeQuery("Select * from Guest where IDGu = '" + IDGu + "'");
            rs.beforeFirst();
            rs.next();
                txtIDGu2.setText(rs.getString("IDGu"));
                txtNameGu2.setText(rs.getString("NameGu"));
                txtDOBGu2.setText(rs.getString("DOBGu"));
                txtIdentificationNumberGu2.setText(rs.getString("IdentificationNumberGu"));
                txtPhoneGu2.setText(rs.getString("PhoneGu"));
                txtEmailGu2.setText(rs.getString("EmailGu"));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void setDataToCollaboratorPanel()
    {
        try {
            
            rs = stmt.executeQuery("Select * from Collaborator where IDCo = '" + IDCo + "'");
            rs.beforeFirst();
            rs.next();
                txtIDCo2.setText(rs.getString("IDCo"));
                txtNameCo2.setText(rs.getString("NameCo"));
                txtDOBCo2.setText(rs.getString("DOBCo"));
                txtIdentificationNumberCo2.setText(rs.getString("IdentificationNumberCo"));
                txtPhoneCo2.setText(rs.getString("PhoneCo"));
                txtEmailCo2.setText(rs.getString("EmailCo"));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void showTable(String sql)
    {
        hoModel = new DefaultTableModel();
        
        header = new Vector();
        header.add("ID");
        header.add("Gu");
        header.add("Apa");
        header.add("Co");
        header.add("Date");
        header.add("From");
        header.add("To");
        header.add("Status");
        header.add("Total");
        header.add("Commission");
        header.add("Ser");
        
        data = new Vector();
        
        hoModel.setRowCount(0);
        
        try {            
            //select * from Services
            if (sql.isEmpty())                
                sql = "select * from Holding";
            rs = stmt.executeQuery(sql);
            
            rs.beforeFirst();
            while(rs.next())
            {
                row = new Vector();                
                row.add(rs.getString("IDHo"));
                row.add(rs.getString("IDGu"));
                row.add(rs.getString("IDApa"));
                row.add(rs.getString("IDCo"));
                row.add(rs.getString("DateHo"));
                row.add(rs.getString("FromDateHo"));
                row.add(rs.getString("ToDateHo"));
                row.add(rs.getString("PayStatusHo"));
                row.add(rs.getDouble("TotalHo"));
                row.add(rs.getDouble("CommissionHo"));
                row.add(rs.getString("IDSer"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        hoModel.setDataVector(data, header);
        tblHo.setModel(hoModel);
        //remove unnecessary column
        modifyTable(tblHo);
        //show Guest and Collaborator Info
        if (!(IDGu.isEmpty()) && !(IDCo.isEmpty()))
        {
            setDataToGuestPanel();
            setDataToCollaboratorPanel();
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

        pTblHo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pCollaborator = new javax.swing.JPanel();
        txtIDCo2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNameCo2 = new javax.swing.JTextField();
        txtDOBCo2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdentificationNumberCo2 = new javax.swing.JTextField();
        txtPhoneCo2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEmailCo2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        pGuest = new javax.swing.JPanel();
        txtIDGu2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNameGu2 = new javax.swing.JTextField();
        txtDOBGu2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtIdentificationNumberGu2 = new javax.swing.JTextField();
        txtPhoneGu2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtEmailGu2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        pHolding = new javax.swing.JPanel();
        txtIDHo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtIDGu = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtIDCo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtIDApa = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtDateHo = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtFromDateHo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtToDateHo = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtPayStatusHo = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtCommissionHo = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtTotalHo = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnMakeContract = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtIDSer = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Holding");

        pTblHo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pTblHo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblHo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Holding", "Gu", "Apa", "Co", "Date", "From", "To", "Status", "Total", "Commission", "IDSer"
            }
        ));
        tblHo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHo);

        pTblHo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 42, 438, 115));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Holding Detail");
        pTblHo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 9, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Guest");

        pCollaborator.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtIDCo2.setText("jTextField1");

        jLabel3.setText("ID");

        jLabel4.setText("Name");

        txtNameCo2.setText("jTextField1");

        txtDOBCo2.setText("jTextField1");

        jLabel5.setText("DOB");

        jLabel6.setText("IDNo.");

        txtIdentificationNumberCo2.setText("jTextField1");

        txtPhoneCo2.setText("jTextField1");

        jLabel8.setText("Phone");

        jLabel9.setText("Email");

        txtEmailCo2.setText("jTextField1");

        javax.swing.GroupLayout pCollaboratorLayout = new javax.swing.GroupLayout(pCollaborator);
        pCollaborator.setLayout(pCollaboratorLayout);
        pCollaboratorLayout.setHorizontalGroup(
            pCollaboratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCollaboratorLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pCollaboratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(pCollaboratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhoneCo2)
                    .addComponent(txtIdentificationNumberCo2)
                    .addComponent(txtNameCo2)
                    .addComponent(txtDOBCo2)
                    .addGroup(pCollaboratorLayout.createSequentialGroup()
                        .addComponent(txtIDCo2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtEmailCo2))
                .addGap(23, 23, 23))
        );
        pCollaboratorLayout.setVerticalGroup(
            pCollaboratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCollaboratorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCollaboratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIDCo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCollaboratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNameCo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCollaboratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDOBCo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCollaboratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdentificationNumberCo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCollaboratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPhoneCo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pCollaboratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtEmailCo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );

        pGuest.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtIDGu2.setText("jTextField1");

        jLabel7.setText("ID");

        jLabel10.setText("Name");

        txtNameGu2.setText("jTextField1");

        txtDOBGu2.setText("jTextField1");

        jLabel11.setText("DOB");

        jLabel12.setText("IDNo.");

        txtIdentificationNumberGu2.setText("jTextField1");

        txtPhoneGu2.setText("jTextField1");

        jLabel13.setText("Phone");

        jLabel14.setText("Email");

        txtEmailGu2.setText("jTextField1");

        javax.swing.GroupLayout pGuestLayout = new javax.swing.GroupLayout(pGuest);
        pGuest.setLayout(pGuestLayout);
        pGuestLayout.setHorizontalGroup(
            pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGuestLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhoneGu2)
                    .addComponent(txtIdentificationNumberGu2)
                    .addComponent(txtNameGu2)
                    .addComponent(txtDOBGu2)
                    .addGroup(pGuestLayout.createSequentialGroup()
                        .addComponent(txtIDGu2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtEmailGu2))
                .addGap(20, 20, 20))
        );
        pGuestLayout.setVerticalGroup(
            pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGuestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIDGu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNameGu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDOBGu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtIdentificationNumberGu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtPhoneGu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtEmailGu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Collaborator");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pCollaborator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pGuest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pGuest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(pCollaborator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );

        pHolding.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pHolding.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIDHo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIDHo.setText("jTextField1");
        pHolding.add(txtIDHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 13, 197, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("ID");
        pHolding.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 16, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("ID Guest");
        pHolding.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 57, -1, -1));

        txtIDGu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIDGu.setText("jTextField1");
        pHolding.add(txtIDGu, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 54, 197, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("ID Collaborator");
        pHolding.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 98, -1, -1));

        txtIDCo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIDCo.setText("jTextField1");
        pHolding.add(txtIDCo, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 95, 197, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("ID Apartment");
        pHolding.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 139, -1, -1));

        txtIDApa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIDApa.setText("jTextField1");
        pHolding.add(txtIDApa, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 136, 197, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Date");
        pHolding.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 180, -1, -1));

        txtDateHo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDateHo.setText("jTextField1");
        pHolding.add(txtDateHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 177, 197, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("From Date");
        pHolding.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 221, -1, -1));

        txtFromDateHo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFromDateHo.setText("jTextField1");
        pHolding.add(txtFromDateHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 218, 197, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("To Date");
        pHolding.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 262, -1, -1));

        txtToDateHo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtToDateHo.setText("jTextField1");
        pHolding.add(txtToDateHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 259, 197, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Status");
        pHolding.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 340, -1, -1));

        txtPayStatusHo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPayStatusHo.setText("jTextField1");
        pHolding.add(txtPayStatusHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 337, 197, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Commission");
        pHolding.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 381, -1, -1));

        txtCommissionHo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCommissionHo.setText("jTextField1");
        pHolding.add(txtCommissionHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 378, 197, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Total");
        pHolding.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 422, -1, -1));

        txtTotalHo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTotalHo.setText("jTextField1");
        pHolding.add(txtTotalHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 419, 197, -1));

        btnSearch.setText("Search");
        pHolding.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 453, 144, 57));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pHolding.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 453, 154, 57));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pHolding.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 521, 144, 57));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pHolding.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 521, 154, 57));

        btnMakeContract.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMakeContract.setText("Make Contract");
        pHolding.add(btnMakeContract, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 584, 341, 68));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Services");
        pHolding.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 303, -1, -1));

        txtIDSer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIDSer.setText("jTextField1");
        pHolding.add(txtIDSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 300, 197, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pTblHo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(pHolding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pHolding, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pTblHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoMouseClicked
        // TODO add your handling code here:
        int row;
        
        row = tblHo.getSelectedRow();
        TableModel tblModel = tblHo.getModel();
        
        IDHo = (String) tblModel.getValueAt(row, 0);       
        IDGu = (String)tblModel.getValueAt(row, 1);
        IDApa = (String)tblModel.getValueAt(row, 2);
        IDCo = (String)tblModel.getValueAt(row, 3);
        DateHo = (String)tblModel.getValueAt(row, 4);
        FromDateHo = (String)tblModel.getValueAt(row, 5);
        ToDateHo = (String)tblModel.getValueAt(row, 6);
        PayStatusHo = (String)tblModel.getValueAt(row, 7);
        TotalHo = (Double)tblModel.getValueAt(row, 8);
        CommissionHo = (Double)tblModel.getValueAt(row, 9);
        IDSer = (String)tblModel.getValueAt(row, 10);
        
        
        txtIDHo.setText(IDHo);
        txtIDGu.setText(IDGu);
        txtIDApa.setText(IDApa);
        txtIDCo.setText(IDCo);
        txtDateHo.setText(DateHo);
        txtFromDateHo.setText(FromDateHo);
        txtToDateHo.setText(ToDateHo);
        txtPayStatusHo.setText(PayStatusHo);
        txtTotalHo.setText(String.valueOf(TotalHo));
        txtCommissionHo.setText(String.valueOf(CommissionHo));
        txtIDSer.setText(IDSer);
        
        setDataToGuestPanel();
        setDataToCollaboratorPanel();
    }//GEN-LAST:event_tblHoMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
        getDataFromTextField();
        manageBtn(false, true, false, false);
        
        String labelButton = btnAdd.getText();
        if (labelButton.equalsIgnoreCase("Add"))
        {
            btnAdd.setText("Save");
        }else
        {
        
            try {
                //insert into Holding values('Ho01', 'Gu01', 'Ap01', 'Co01', '2018-5-5', '2018-6-6', '2018-6-12', 'Chua thanh toan', 10000, 100, 'Se01')
                sql = "insert into Holding values('"+IDHo+"', '"+IDGu+"', '"+IDApa+"', '"+IDCo+"', '"+DateHo+"', '"+FromDateHo+"', '"+ToDateHo+"', '"+PayStatusHo+"', "+TotalHo+", "+CommissionHo+", '"+IDSer+"')";
                stmt.executeUpdate(sql);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            sql = "select * from Holding";
            showTable(sql);
            btnAdd.setText("Add");
            manageBtn(true, true, true, true);
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        getDataFromTextField();
        manageBtn(false, false, true, false);
        
        String labelButton = btnUpdate.getText();
        if (labelButton.equalsIgnoreCase("Update"))
        {
            btnUpdate.setText("Save");
        }else
        {
        
            try {
                //update Holding set IDGu = 'Gu01', IDApa = 'Ap01', IDCo = 'Co02', DateHo = '2018-8-6', FromDateHo = '2019-6-6', ToDateHo = '2019-6-10', PayStatusHo = 'Thanh toan 50%', TotalHo = 100, CommissionHo = 10, IDSer = 'Se02' where IDHo = 'Ho01'
                sql = "update Holding set IDGu = '" + IDGu + "', IDApa = '" + IDApa + "', IDCo = '" + IDCo + "', DateHo = '" + DateHo + "', FromDateHo = '" + FromDateHo + "', ToDateHo = '" + ToDateHo + "', PayStatusHo = '" + PayStatusHo + "', TotalHo = " + TotalHo + ", CommissionHo = " + CommissionHo + ", IDSer = '" + IDSer + "' where IDHo = '" + IDHo + "'";
                stmt.executeUpdate(sql);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            sql = "select * from Holding";
            showTable(sql);
            btnUpdate.setText("Update");
            manageBtn(true, true, true, true);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        getDataFromTextField();
        manageBtn(false, false, false, true);
        String labelButton = btnDelete.getText();
        if (labelButton.equalsIgnoreCase("Delete"))
        {
            btnDelete.setText("Continue");
        }else
        {
        
            try {
                //delete Holding where IDHo = 'Ho03'
                sql = "delete Holding where IDHo = '"+ IDHo +"'";
                stmt.executeUpdate(sql);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            sql = "select * from Holding";
            showTable(sql);
            btnDelete.setText("Delete");
            manageBtn(true, true, true, true);
        }
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
            java.util.logging.Logger.getLogger(uiHolding_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uiHolding_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uiHolding_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uiHolding_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uiHolding_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnMakeContract;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pCollaborator;
    private javax.swing.JPanel pGuest;
    private javax.swing.JPanel pHolding;
    private javax.swing.JPanel pTblHo;
    private javax.swing.JTable tblHo;
    private javax.swing.JTextField txtCommissionHo;
    private javax.swing.JTextField txtDOBCo2;
    private javax.swing.JTextField txtDOBGu2;
    private javax.swing.JTextField txtDateHo;
    private javax.swing.JTextField txtEmailCo2;
    private javax.swing.JTextField txtEmailGu2;
    private javax.swing.JTextField txtFromDateHo;
    private javax.swing.JTextField txtIDApa;
    private javax.swing.JTextField txtIDCo;
    private javax.swing.JTextField txtIDCo2;
    private javax.swing.JTextField txtIDGu;
    private javax.swing.JTextField txtIDGu2;
    private javax.swing.JTextField txtIDHo;
    private javax.swing.JTextField txtIDSer;
    private javax.swing.JTextField txtIdentificationNumberCo2;
    private javax.swing.JTextField txtIdentificationNumberGu2;
    private javax.swing.JTextField txtNameCo2;
    private javax.swing.JTextField txtNameGu2;
    private javax.swing.JTextField txtPayStatusHo;
    private javax.swing.JTextField txtPhoneCo2;
    private javax.swing.JTextField txtPhoneGu2;
    private javax.swing.JTextField txtToDateHo;
    private javax.swing.JTextField txtTotalHo;
    // End of variables declaration//GEN-END:variables

    @Override
    public String returnMainId() {
        return IDHo;
    }
    
    @Override
    public void dispose(){
        System.out.println("Disposed complete");
        super.dispose();
    }
}
