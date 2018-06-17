/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ngoc_Duyen.QLCH;

/**
 *
 * @author Dell
 */
import Library.G2FileBrowserExtend;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class QLCH1 extends javax.swing.JFrame {

    /**
     * Creates new form QLCH1
     */
    DefaultTableModel ApartModel ; 
    Vector header , data , row ;
    String sql ;
    ResultSet rs;
    Statement stmt;
    Connection con ;
    
    String IDApa , AddressApa, ImageApa, StatusApa, IDSupApa, NameApa,OwnerApa,InfoApa;
    Double PriceApa;
    
    String continueAccount, continueType;
    
    public QLCH1(String account, String type, Connection con, Statement stmt) 
    {
        this.con = con;
        this.stmt = stmt;
        continueAccount = account;
        continueType = type;
        initComponents();
        //connectSQL();
        showTable();
        manageButton(true,true, true );//false,false);
        manageTextField(false, false, false, false, false, false, false, false);
        this.setTitle("Apartment Management");
    }

    

//    public void connectSQL()
//    {
//        Connection con;
//        Statement stmt;
//        
//        DatabaseConnect objDBConnect;
//        objDBConnect = new DatabaseConnect();
//        connectionContainer connectContainer = objDBConnect.DBConnect("Sem2_project_group2", "sa", "123456789", "1433");
//        
//        con = connectContainer.getObjCon();
//        stmt = connectContainer.getStatement();
//        
//    
//        objDBConnect.ListTable();
//        objDBConnect.Close();
//        
//        {
//            try {
//                con = DBConnection.getDBConnection(DBConnection.database,DBConnection.account,DBConnection.password);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }        
//    }}

//    public void connectSQL()
//        {
//            try {
//                con = DBConnection.getDBConnection(DBConnection.database,DBConnection.account,DBConnection.password);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }        
//    }

    public void showTable()
    {
        ApartModel = new DefaultTableModel();
        header = new Vector();
        header.add("ID");
        header.add("Name");
        header.add("Address");
        header.add("Image");
        header.add("Info");
        header.add("Status");
        header.add("Price");
        header.add("IDSup");
        
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
                row.add(rs.getString("IDSup"));
                data.add(row);
            }
             } catch (Exception e) {
            e.printStackTrace();
        }        
        ApartModel.setDataVector(data, header);
        tblApartment.setModel(ApartModel);
        modifyTable();
    }
    
    public void modifyTable()
    {
        tblApartment.removeColumn(tblApartment.getColumn("Image"));
        tblApartment.removeColumn(tblApartment.getColumn("Info"));
        tblApartment.removeColumn(tblApartment.getColumn("IDSup"));
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblApartment = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtImage = new javax.swing.JTextField();
        txtInfo = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtIDSup = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pApaImage = new Library.G2ImagePanel();
        jPanel2 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblApartment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Address", "Image", "Info", "Status", "Price", "IDSupl"
            }
        ));
        tblApartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblApartmentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblApartment);

        jLabel4.setText("ID");

        jLabel5.setText("Name");

        jLabel6.setText("Address");

        jLabel7.setText("Image");

        jLabel8.setText("Info");

        jLabel9.setText("Status");

        jLabel10.setText("Price");

        jLabel11.setText("IDSup");

        txtID.setText("jTextField1");
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtName.setText("jTextField2");

        txtAddress.setText("jTextField3");

        txtImage.setText("jTextField4");

        txtInfo.setText("jTextField5");

        txtStatus.setText("jTextField6");

        txtPrice.setText("jTextField7");

        txtIDSup.setText("jTextField8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIDSup, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrice))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStatus)
                            .addComponent(txtInfo)
                            .addComponent(txtImage)
                            .addComponent(txtAddress)
                            .addComponent(txtName)
                            .addComponent(txtID))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDSup, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Apartment Manager");

        jLabel2.setText("Detail :");

        jLabel3.setText("Aparment List :");

        pApaImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pApaImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pApaImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pApaImageLayout = new javax.swing.GroupLayout(pApaImage);
        pApaImage.setLayout(pApaImageLayout);
        pApaImageLayout.setHorizontalGroup(
            pApaImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );
        pApaImageLayout.setVerticalGroup(
            pApaImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd))
                .addGap(23, 23, 23))
        );

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pApaImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(235, 235, 235)
                                .addComponent(jLabel3)))
                        .addGap(0, 239, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pApaImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBack)))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int check = JOptionPane.showConfirmDialog(this, "Are you sure for deleting?");
            if (check == JOptionPane.OK_OPTION)
            {
                String ID = txtID.getText();
                sql = "delete from Apartment where IDApa = '" + ID + "'";
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
                    if (!checkblank())
                        return;
                    String ID = txtID.getText();
                    String Name = txtName.getText();
                    String Address = txtAddress.getText();
                    String Image = txtImage.getText();
                    String Info = txtInfo.getText();
                    String Status = txtStatus.getText();
                    String Price = txtPrice.getText();
                    String IDSup = txtIDSup.getText();
                    
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
//        UpdateApartment objUA = new UpdateApartment();
//        objUA.setVisible(true);
        
        String labelBtn = btnUpdate.getText();
        if( labelBtn.equalsIgnoreCase("Update"))
        {
            btnUpdate.setText("Save");            
            manageTextField(false, true, true,true,true,true,true,true);
            manageButton(false, true, false);
                       
        }else
            {
            if (!checkblank())
                return;
            String ID = txtID.getText();
            String Name = txtName.getText();
            String Address = txtAddress.getText();
            String Image = txtImage.getText();
            String Info = txtInfo.getText();
            String Status = txtStatus.getText();
            String Price = txtPrice.getText();
            String IDSup = txtIDSup.getText();
            try {
                sql = "update Apartment set  NameApa = '" + Name + "',AddressApa = '" + Address + "',ImageApa = '" + Image + "',InfoApa = '" + Info + "',StatusApa  = '" + Status+"',PriceApa  = '" + Price+"',IDSup  = '" + IDSup+ "' where IDApa = '" + ID + "'";
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

    private void tblApartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblApartmentMouseClicked
        // TODO add your handling code here:
        manageButton(true, true, true);
        int row;
                
        row = tblApartment.getSelectedRow();
        TableModel tblModel = tblApartment.getModel();
        IDApa = (String) tblModel.getValueAt(row, 0);        
        NameApa= (String) tblModel.getValueAt(row, 1);
        AddressApa = (String)tblModel.getValueAt(row, 2);
        ImageApa = (String)tblModel.getValueAt(row, 3);
        InfoApa = (String)tblModel.getValueAt(row, 4);
        StatusApa = (String)tblModel.getValueAt(row, 5);
        PriceApa = (Double)tblModel.getValueAt(row, 6);
        IDSupApa = (String)tblModel.getValueAt(row, 7);
        txtID.setText(IDApa);
        txtName.setText(NameApa);
        txtAddress.setText(AddressApa);
        txtImage.setText(ImageApa);
        txtInfo.setText(InfoApa);
        txtStatus.setText(StatusApa);
        txtPrice.setText(String.valueOf(PriceApa));
        txtIDSup.setText(IDSupApa);
        
        pApaImage.inputImage(ImageApa);
    }//GEN-LAST:event_tblApartmentMouseClicked

    private void pApaImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pApaImageMouseClicked
        // TODO add your handling code here:
        G2FileBrowserExtend objFileChooser = new G2FileBrowserExtend();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG Images", "jpg", "png");
        objFileChooser.setFileFilter(filter);
        int returnVal = objFileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.ImageApa = objFileChooser.getSelectedFile().getPath();
            txtImage.setText(ImageApa);
            pApaImage.inputImage(ImageApa);
        }
    }//GEN-LAST:event_pApaImageMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        
        new Nam.MainControlInterface(continueAccount, continueType, con, stmt).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
   
    public boolean checkblank()
    {
        boolean check = true;
        if (txtID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID cannot be blank. Re-Enter.");
            txtID.grabFocus();
            check = false;
            return check;
        }
        
        if (txtName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be blank. Re-Enter.");
            txtName.grabFocus();
            check = false;
            return check;
        }
        if (txtAddress.getText().isEmpty()) {
             JOptionPane.showMessageDialog(this, "Address cannot be blank. Re-Enter.");
            txtAddress.grabFocus();
            check = false;
            return check;
        }
        if (txtImage.getText().isEmpty()) {
             JOptionPane.showMessageDialog(this, "Image cannot be blank. Re-Enter.");
            txtImage.grabFocus();
            check = false;
            return check;
             }
        if (txtInfo.getText().isEmpty()) {
             JOptionPane.showMessageDialog(this, "Info cannot be blank. Re-Enter.");
            txtInfo.grabFocus();
            check = false;
            return check;
        }
        if (txtIDSup.getText().isEmpty()) {
             JOptionPane.showMessageDialog(this, "IDSup cannot be blank. Re-Enter.");
            txtIDSup.grabFocus();
            check = false;
            return check;
        }
        
        if (txtPrice.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Price cannot be blank. Re-Enter.");
            txtPrice.grabFocus();
            check = false;
            return check;
        }
        
        return check;
    }
    public static void main(String args[]) {
//        Connection con;
//        Statement stmt;
//        
//        DatabaseConnect objDBConnect;
//        objDBConnect = new DatabaseConnect();
//        connectionContainer connectContainer = objDBConnect.DBConnect("Sem2_project_group2", "sa", "123456789", "1433");
//        
//        con = connectContainer.getObjCon();
//        stmt = connectContainer.getStatement();
//        
//  
//        objDBConnect.ListTable();
//        objDBConnect.Close();
        
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
            java.util.logging.Logger.getLogger(QLCH1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLCH1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLCH1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLCH1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new QLCH1().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    /*
    private javax.swing.JPanel pApaImage;
    */
    private Library.G2ImagePanel pApaImage;
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
