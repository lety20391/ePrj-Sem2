/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tuyet_Duyen;

import Dat_Le_2.uiHolding_2;
import DatabaseConnection.DatabaseConnect;
import DatabaseConnection.connectionContainer;
import Library.G2Panel;
import Library.G2TextField;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Elisa
 */
public class Services_2 extends javax.swing.JFrame {
    DefaultTableModel serModel;
    Vector header,data,row;
    String sql;
    ResultSet rs;
    Statement stmt;
    Connection objConnection;
    Nam.MainControlInterface objMain;
    G2TextField objOutputTextField;
    
    String IDSer;
    String Nameser;
    Double Price;
    int initRow;
    boolean checkInitRow;
    /**
     * Creates new form Services
     */
    public Services_2(String Account, String type, Connection objConnection, Statement stmt, Nam.MainControlInterface objMain) {
        this.objMain = objMain;
        this.objConnection = objConnection;
        this.stmt = stmt;
        initComponents();      
        //connectSQL();
        pButton.attachButtonAndSetMainRight(pButton, type);
        attachRegexAndErrorInform(pService);
        showTable();
        initData();
//        manageButton(true,false,false);
        manageTextField(false, false, false);
        //clearAllTextField(pService);
    }
    
    public Services_2(String Account, String type, Connection objConnection, Statement stmt, G2TextField objOutputTextField, Nam.MainControlInterface objMain) {
        this.objMain = objMain;
        this.objOutputTextField = objOutputTextField;
        this.objConnection = objConnection;
        this.stmt = stmt;
        initComponents();      
        //connectSQL();
        pButton.attachButtonAndSetMainRight(pButton, type);
        attachRegexAndErrorInform(pService);
        showTable();
        //initData();
//        manageButton(true,false,false);
        manageTextField(false, false, false);
        //clearAllTextField(pService);
    }
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
    
    //init data get from objMain
    public void initData()
    {
        if(objMain.getIDSer().isEmpty())
            return;
        IDSer = objMain.getIDSer();
        checkInitRow = false;
        TableModel objModel = tblService.getModel();
        for (int i = 0; i < objModel.getRowCount(); i++) {
            if (IDSer.equalsIgnoreCase((String)objModel.getValueAt(i, 0)))
            {
                checkInitRow = true;
                initRow = i;
                break;
            }
        }        
        tblMouseClickedProcess();
    }
    
    public void clearAllTextField(G2Panel panel)
    {
        Component[] objListComp = panel.getComponents();
        for (Component objComp : objListComp) {
            if (objComp instanceof G2TextField)
                ((G2TextField) objComp).setText("");
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
        serModel = new DefaultTableModel();
        header = new Vector();
        header.add("Service ID");
        header.add("Service Name");
        header.add("Service Price");
        data = new Vector();
        serModel.setRowCount(0);
        
        try {            
            //select * from Services
            sql = "select * from Services";
            rs = stmt.executeQuery(sql);
            rs.beforeFirst();
            while(rs.next())
            {
                row = new Vector();
                row.add(rs.getString("IDSer"));
                row.add(rs.getString("NameSer"));
                row.add(rs.getDouble("Price"));
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        serModel.setDataVector(data, header);
        tblService.setModel(serModel);
        //tblBook.setModel(bookModel);
    }

    public void manageButton(boolean BtnAddStatus, boolean BtnUpdateStatus, boolean BtnDeleteStatus)
    {
        btnAdd.setEnabled(BtnAddStatus);
        btnUpdate.setEnabled(BtnUpdateStatus);
        btnDelete.setEnabled(BtnDeleteStatus);
    }
    
    public void manageTextField(boolean txtIDStatus, boolean txtNameStatus, boolean txtPriceStatus)
    {
        txtID.setEditable(txtIDStatus);
        txtName.setEditable(txtNameStatus);
        txtPrice.setEditable(txtPriceStatus);
    }
    
    public void clearTxt()
    {
        txtID.setText("");
        txtName.setText("");
        txtPrice.setText("");
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
        pService = new Library.G2Panel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new Library.G2TextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new Library.G2TextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrice = new Library.G2TextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblService = new javax.swing.JTable();
        pButton = new Library.G2Panel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("services");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 102, 0));
        jLabel1.setText("Services");

        pService.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("ID Service");

        txtID.setText("^(Se)\\d+errSexx with x is number");

        jLabel3.setText("Name");

        txtName.setText("\\w+(.)*\\werrnormal paragraph");
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel4.setText("Price");

        txtPrice.setText("\\d+(.)*(\\d)+errxxx.xx with x is number");

        javax.swing.GroupLayout pServiceLayout = new javax.swing.GroupLayout(pService);
        pService.setLayout(pServiceLayout);
        pServiceLayout.setHorizontalGroup(
            pServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pServiceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pServiceLayout.createSequentialGroup()
                        .addGroup(pServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(40, 40, 40)
                        .addGroup(pServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName)
                            .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))
                    .addGroup(pServiceLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtID)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pServiceLayout.setVerticalGroup(
            pServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pServiceLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(pServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(14, 14, 14)
                .addGroup(pServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblService.setBackground(new java.awt.Color(255, 204, 255));
        tblService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "IDService", "Name", "Price"
            }
        ));
        tblService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServiceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblService);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addContainerGap())
        );

        pButton.setBackground(new java.awt.Color(102, 0, 102));
        pButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAdd.setBackground(new java.awt.Color(102, 0, 102));
        btnAdd.setForeground(new java.awt.Color(0, 102, 51));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(102, 0, 51));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(102, 0, 51));
        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
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
                .addContainerGap()
                .addGroup(pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pButtonLayout.setVerticalGroup(
            pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
            String labelButton = btnAdd.getText();
            if (labelButton.equalsIgnoreCase("Add"))
            {
                clearTxt();               
                manageTextField(true, true, true);
                btnAdd.setText("Save");            
            }else{
                try {    
                    String ID = txtID.getText();
                    String Name = txtName.getText();
                    String Price = txtPrice.getText();
                    
                    //bat loi empty voi ID
                    if (ID.isEmpty())
                    {
                        JOptionPane.showMessageDialog(this, "ID cannot be blank. Pls re-enter");
                        txtID.grabFocus();
                        return;
                    }
                    
                    //insert into Services(IDSer, NameSer, Price) values ('S02', 'Lau nha', 200)
                    sql = "insert into Services(IDSer, NameSer, Price) values ('" + ID + "', '" + Name + "', " + Price +")";
                    stmt.executeUpdate(sql);
                    //hien thi thong tin trong Table
                    showTable();
                    //doi ten button lai thanh Add
                    btnAdd.setText("Add");
                    //xoa trang cac textfield
                    clearTxt(); 
                    //disable cac textfield
                    manageTextField(false, false, false);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServiceMouseClicked
        // TODO add your handling code here:
        tblMouseClickedProcess();
        //tách thành method riêng ngay bên dưới để có thể tái sử dụng
        //lúc initData
    }//GEN-LAST:event_tblServiceMouseClicked

    private void tblMouseClickedProcess()
    {
        manageButton(true, true, true);
        int row;
        //nếu có dữ liệu init thì load trước
        //không có thì đợi click chuột vào bảng mới load
        if (checkInitRow)
        {
            row = initRow;
            checkInitRow = false;
        }
        else
            row = tblService.getSelectedRow();
        
        IDSer = (String) tblService.getValueAt(row, 0);        
        Nameser = (String)tblService.getValueAt(row, 1);
        Price = (double)tblService.getValueAt(row, 2);
        
        txtID.setText(IDSer);
        txtName.setText(Nameser);
        //tra ve kieu String vi Price la kieu Double
        txtPrice.setText(String.valueOf(Price));
        
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        String labelBtn = btnUpdate.getText();
        if( labelBtn.equalsIgnoreCase("Update"))
        {
            btnUpdate.setText("Save");            
            manageTextField(true, true, true);
            //dat lai trang thai cac Button
            manageButton(false, true, false);           
            
        }else
        {
            //kiem tra cac textField co thoa man khong 
            //nếu có lỗi thì thoát ra khỏi lệnh update
            if(validateAllTextField(pService))
                return;
            
            String ID = txtID.getText();
            String Name = txtName.getText();
            String Price = txtPrice.getText();
            try {
                //tien hanh update thong tin len database
                //cau lenh sql mau da kiem tra thu tren SQL
                //update Services set  NameSer = 'Ban nha', Price = 100 where IDSer = 'S06'
                sql = "update Services set  NameSer = '" + Name + "', Price = " + Price + " where IDSer = '" + ID + "'";
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

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
        //manageTextField(true, true, true);
        
        try {
            int check = JOptionPane.showConfirmDialog(this, "Are you sure for deleting?");
            if (check == JOptionPane.OK_OPTION)
            {
                String ID = txtID.getText();
                //cau lenh SQL mau da kiem tra thu tren SQl
                //delete from Services where IDSer = 'S06'
                sql = "delete from Services where IDSer = '" + ID + "'";
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
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
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
            java.util.logging.Logger.getLogger(Services_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Services_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Services_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Services_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Services_2().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    /*
    private javax.swing.JPanel pButton;
    */
    private Library.G2Panel pButton;
    /*
    private javax.swing.JPanel pService;
    */
    private Library.G2Panel pService;
    private javax.swing.JTable tblService;
    /*
    private javax.swing.JTextField txtID;
    */
    private Library.G2TextField txtID;
    /*
    private javax.swing.JTextField txtName;
    */
    private Library.G2TextField txtName;
    /*
    private javax.swing.JTextField txtPrice;
    */
    private Library.G2TextField txtPrice;
    // End of variables declaration//GEN-END:variables
@Override
    public void dispose(){
        if (objMain != null)
        {
            objMain.setVisible(true);
            returnDataToMainInterface();
        }
        if(objOutputTextField != null)
            objOutputTextField.setText(IDSer);
        super.dispose();
    }

    public void returnDataToMainInterface()
    {        
        objMain.setIDSer(IDSer);
    }
    
}
