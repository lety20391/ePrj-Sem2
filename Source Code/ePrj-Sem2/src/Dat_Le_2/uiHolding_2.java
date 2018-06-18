/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dat_Le_2;

import DatabaseConnection.DatabaseConnect;
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
import Library.DateChooser;
import Library.G2Panel;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import Library.G2TextField;
import Ngoc_Duyen.QLCH.QLCH1;
import Tuyet_Duyen.Services_2;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Dat ThinkPad
 */
public class uiHolding_2 extends javax.swing.JFrame implements Library.G2FrameInterface{
    String account, type;
    Statement stmt;
    DatabaseConnect objDBConnect;
    Connection objConnection;
    ResultSet rs;
    String sql;
    
    HashMap<String, String> dataMap;
    HashMap<String, JTextField> txtMap;
    //HashMap<JTextField, String> regexMap;
    
    DefaultTableModel hoModel;
    Vector header, row, data;
    
    String IDHo, IDGu, IDApa, IDCo, DateHo,FromDateHo, ToDateHo, PayStatusHo, IDSer;
    Double CommissionHo, TotalHo;
    
    String imageGu, imageCo;
    
    String patStr;
    
    DateChooser diaDateChooser;
    
    SearchData objSearch;
    
    Nam.MainControlInterface objMain;
    TestMain.TestMain objMain2;
    uiContract_2 objContract;
    Library.G2FrameInterface objG2Frame;
    Tuyet_Duyen.Services_2 objSer2;
    Ngoc_Duyen.QLCH.QLCH1 objQLCH;
    
    
    boolean checkInitRow;
    int initRow;
    
    Double ratioCommission = 0.1;
    boolean BookingSuccess = false;
    
    Double pricePerDay;
    
    public uiHolding_2() throws HeadlessException 
    {
        
    }
    
    

    /**
     * Creates new form uiHolding
     */
//    public uiHolding_2() 
//    {
//        initComponents();
//        //connectToDatabase();
//        initData();
//        showTable("Select * from Holding");
//    }
    
    public uiHolding_2(String account, String type, Connection objConnection, Statement stmt, Nam.MainControlInterface objMain)
    {
        this.account = account;
        this.type = type;
        this.objConnection = objConnection;
        this.stmt = stmt;
        this.objMain = objMain;
        objMain.setVisible(false);
        
        initComponents();   
        pHolding.attachButtonAndSetMainRight(pButton,type); 
        attachRegexAndErrorInform(pHolding);  
        newData();
        showTable("Select * from Holding");
        initData();
    }
    
    public uiHolding_2(String Account, String type, Connection objConnection, Statement stmt, Library.G2FrameInterface objG2Frame, Nam.MainControlInterface objMain)
    {
        this.objConnection = objConnection;
        this.stmt = stmt;
        this.objMain = objMain;
        this.objG2Frame = objG2Frame;
        objMain.setVisible(false);
        
        initComponents();   
        //patStr = txtIDHo.getText();
        pHolding.attachButtonAndSetMainRight(pButton,type); 
        attachRegexAndErrorInform(pHolding);
        
        //initDateChooser();
        newData();
        showTable("Select * from Holding"); 
        initData();
        //pImageGuest.setSize(300, 400);
//        pImageGuest.inputImage("\\src\\Image\\Guest\\Gu01.jpg");
//        pImageCollaborator.inputImage("\\src\\Image\\Collaborator\\Co01.jpg");
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
            }
        }
    }
    
    
    public void modifyTable(JTable table)
    {
        table.removeColumn(table.getColumn("Gu"));
        table.removeColumn(table.getColumn("Apa"));
        table.removeColumn(table.getColumn("Co"));
        table.removeColumn(table.getColumn("Commission"));
    }
    
//    public void connectToDatabase()
//    {
//        DatabaseConnect objDBConnect;
//        objDBConnect = new DatabaseConnect();
//        connectionContainer connectContainer = objDBConnect.DBConnect("Sem2_project_group2", "sa", "abc123");
//        
//        objConnection = connectContainer.getObjCon();
//        stmt = connectContainer.getStatement();
//    }
    private void newData()
    {
        manageTextField(pHolding, "test");
        manageTextField(pGuest);
        manageTextField(pCollaborator);
        IDCo = "";
        IDGu = "";
    }
    
    public void initData()
    {     
        //khởi tạo data từ MainControl
        if(objMain.getIDHo().isEmpty())
            return;
        IDHo = objMain.getIDHo();
        checkInitRow = false;
        TableModel objModel = tblHo.getModel();
        for (int i = 0; i < objModel.getRowCount(); i++) {
            if (IDHo.equalsIgnoreCase((String)objModel.getValueAt(i, 0)))
            {
                checkInitRow = true;
                initRow = i;
                break;
            }
        }        
        tblMouseClickedProcess();
    }
    
    public void initDateChooser()
    {
        diaDateChooser = new DateChooser(this, true);
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                diaDateChooser.showGUI();
            }
        }        
        );
        
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
    
    public void manageTextField(G2Panel targetPanel, String test)
    {
        Component[] objComponent = targetPanel.getComponents();
        for (Component comp : objComponent) {
            if (comp instanceof G2TextField)
            {
                G2TextField objTxt = (G2TextField)comp;
                //objTxt.setText(objTxt.getPatStr());
                objTxt.setText("");
            }
        }
    }
    //UPDATE--------------------
    //Su dung phuong thuc validate trong G2TextField
    //----------------------------
    //VVVVVVVVVVVVVVVVVVVVVVVVVVVV
    
//    public void validateTextField()
//    {
//        
//        Iterator iteEntry = regexMap.entrySet().iterator();
//        while (iteEntry.hasNext())
//        {
//            HashMap.Entry objEntry = (HashMap.Entry)iteEntry.next();
//            String patRegex = (String)objEntry.getValue();
//            JTextField objTextField = (JTextField)objEntry.getKey();
//            if (Pattern.matches(patRegex, objTextField.getText()))
//            {
//                System.out.println("Chuan com me nau");
//            }else
//            {
//                objTextField.setBackground(Color.red);
//            }
//            
//        }        
//        
//    }
    
    //^^^^^^^^^^^^^^^^^^^^^^^^^^
    //UPDATE--------------------
    //Su dung phuong thuc validate trong G2TextField
    //----------------------------
    
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
    
    public boolean validateAllTextField()
    {
        Component[] objListComp = pHolding.getComponents();
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
                //get image path
                imageGu = rs.getString("ImageGu");
                pImageGuest.inputImage(imageGu);
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
                //get image for collaborator
                imageCo = rs.getString("ImageCo");
                pImageCollaborator.inputImage(imageCo);            
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
            
            if (!rs.isBeforeFirst())
            {
                JOptionPane.showMessageDialog(this, "Sorry we cant find anything here", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
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
    
    public void BookSuccess(Double pricePerDay)
    {
        BookingSuccess = true;
        ratioCommission = 0.15;
        this.pricePerDay = pricePerDay;
    }
    
    public double TotalMoney(Double price)
    {
        System.out.println(pricePerDay);
        int totalDay = 0;
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = myFormat.parse(FromDateHo);
            Date date2 = myFormat.parse(ToDateHo);
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            
            totalDay = cal2.get(Calendar.DAY_OF_YEAR) - cal1.get(Calendar.DAY_OF_YEAR) + 1;
                        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return totalDay * pricePerDay;
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
        pImageGuest = new Library.G2ImagePanel();
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
        pImageCollaborator = new Library.G2ImagePanel();
        jLabel15 = new javax.swing.JLabel();
        pHolding = new Library.G2Panel();
        txtIDHo = new Library.G2TextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtIDGu = new Library.G2TextField();
        jLabel18 = new javax.swing.JLabel();
        txtIDCo = new Library.G2TextField();
        jLabel19 = new javax.swing.JLabel();
        txtIDApa = new Library.G2TextField();
        jLabel20 = new javax.swing.JLabel();
        txtDateHo = new Library.G2TextField();
        jLabel21 = new javax.swing.JLabel();
        txtFromDateHo = new Library.G2TextField();
        jLabel22 = new javax.swing.JLabel();
        txtToDateHo = new Library.G2TextField();
        jLabel23 = new javax.swing.JLabel();
        txtPayStatusHo = new Library.G2TextField();
        jLabel24 = new javax.swing.JLabel();
        txtCommissionHo = new Library.G2TextField();
        jLabel25 = new javax.swing.JLabel();
        txtTotalHo = new Library.G2TextField();
        jLabel26 = new javax.swing.JLabel();
        txtIDSer = new Library.G2TextField();
        pButton = new Library.G2Panel();
        btnSearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnBookApartment = new javax.swing.JButton();
        btnMakeContract = new javax.swing.JButton();
        btnTotal = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Holding");
        setPreferredSize(new java.awt.Dimension(1200, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        pTblHo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 42, 438, 110));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Holding Detail");
        pTblHo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 9, -1, -1));

        getContentPane().add(pTblHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 462, -1));

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

        pImageGuest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pImageGuestLayout = new javax.swing.GroupLayout(pImageGuest);
        pImageGuest.setLayout(pImageGuestLayout);
        pImageGuestLayout.setHorizontalGroup(
            pImageGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pImageGuestLayout.setVerticalGroup(
            pImageGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        pImageCollaborator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pImageCollaboratorLayout = new javax.swing.GroupLayout(pImageCollaborator);
        pImageCollaborator.setLayout(pImageCollaboratorLayout);
        pImageCollaboratorLayout.setHorizontalGroup(
            pImageCollaboratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );
        pImageCollaboratorLayout.setVerticalGroup(
            pImageCollaboratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(pImageGuest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(pImageCollaborator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
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
                        .addComponent(pImageGuest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pGuest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pImageCollaborator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pCollaborator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 176, -1, 460));

        pHolding.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtIDHo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIDHo.setText("^(Ho)\\d+errHoxx with x is number");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("ID");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("ID Guest");

        txtIDGu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIDGu.setText("^(Gu)\\d+errGuxx with x is number");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("ID Collaborator");

        txtIDCo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIDCo.setText("^(Co)\\d+errCoxx with x is number");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("ID Apartment");

        txtIDApa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIDApa.setText("^(Ap)\\d+errApxx with x is number");
        txtIDApa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIDApaMouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Date");

        txtDateHo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDateHo.setText("^\\d{4}(-)\\d{2}(-)\\d{2}erryyyy-MM-dd");
        txtDateHo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDateHoMouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("From Date");

        txtFromDateHo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFromDateHo.setText("^\\d{4}(-)\\d{2}(-)\\d{2}erryyyy-MM-dd");
        txtFromDateHo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFromDateHoMouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("To Date");

        txtToDateHo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtToDateHo.setText("^\\d{4}(-)\\d{2}(-)\\d{2}erryyyy-MM-dd");
        txtToDateHo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtToDateHoMouseClicked(evt);
            }
        });
        txtToDateHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtToDateHoActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Status");

        txtPayStatusHo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPayStatusHo.setText("\\w+(.)*\\werrnormal paragraph");
        txtPayStatusHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPayStatusHoActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Commission");

        txtCommissionHo.setEditable(false);
        txtCommissionHo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCommissionHo.setText("\\d+(.)*(\\d)+errxxx.xx with x is number");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Total");

        txtTotalHo.setEditable(false);
        txtTotalHo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTotalHo.setText("\\d+(.)*(\\d)+errxxx.xx with x is number");
        txtTotalHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalHoActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Services");

        txtIDSer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIDSer.setText("^(Se)\\d+errSexx with x is number");
        txtIDSer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIDSerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pHoldingLayout = new javax.swing.GroupLayout(pHolding);
        pHolding.setLayout(pHoldingLayout);
        pHoldingLayout.setHorizontalGroup(
            pHoldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHoldingLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pHoldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(127, 127, 127)
                        .addComponent(txtIDHo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(83, 83, 83)
                        .addComponent(txtIDGu, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(37, 37, 37)
                        .addComponent(txtIDCo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(48, 48, 48)
                        .addComponent(txtIDApa, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(112, 112, 112)
                        .addComponent(txtDateHo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(72, 72, 72)
                        .addComponent(txtFromDateHo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(90, 90, 90)
                        .addComponent(txtToDateHo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(88, 88, 88)
                        .addComponent(txtIDSer, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(99, 99, 99)
                        .addComponent(txtPayStatusHo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(61, 61, 61)
                        .addComponent(txtCommissionHo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(109, 109, 109)
                        .addComponent(txtTotalHo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pHoldingLayout.setVerticalGroup(
            pHoldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHoldingLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pHoldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel16))
                    .addComponent(txtIDHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pHoldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel17))
                    .addComponent(txtIDGu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pHoldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel18))
                    .addComponent(txtIDCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pHoldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel19))
                    .addComponent(txtIDApa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pHoldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel20))
                    .addComponent(txtDateHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pHoldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel21))
                    .addComponent(txtFromDateHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pHoldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel22))
                    .addComponent(txtToDateHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pHoldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel26))
                    .addComponent(txtIDSer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(pHoldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel23))
                    .addComponent(txtPayStatusHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pHoldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel24))
                    .addComponent(txtCommissionHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pHoldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pHoldingLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel25))
                    .addComponent(txtTotalHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(126, 126, 126))
        );

        getContentPane().add(pHolding, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, 540));

        pButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBookApartment.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBookApartment.setText("Book Apartment");
        btnBookApartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookApartmentActionPerformed(evt);
            }
        });

        btnMakeContract.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMakeContract.setText("->Contract");
        btnMakeContract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeContractActionPerformed(evt);
            }
        });

        btnTotal.setText("Total");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pButtonLayout = new javax.swing.GroupLayout(pButton);
        pButton.setLayout(pButtonLayout);
        pButtonLayout.setHorizontalGroup(
            pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBookApartment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMakeContract, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pButtonLayout.setVerticalGroup(
            pButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBookApartment, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMakeContract, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(pButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 160, 630));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 370, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoMouseClicked
        // TODO add your handling code here:
        //tách thành method riêng để tiện sử dụng lại khi cần
        tblMouseClickedProcess();
    }//GEN-LAST:event_tblHoMouseClicked

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
        CommissionHo = TotalHo * ratioCommission;
        
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
    }
    
    public String getDateHo() {
        return DateHo;
    }

    public Double getTotalHo() {
        return TotalHo;
    }

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
            if (validateAllTextField())
                return;
            CommissionHo = TotalHo * ratioCommission;
            
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
            if(validateAllTextField())
                return;
            CommissionHo = TotalHo * ratioCommission;
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

    private void btnMakeContractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeContractActionPerformed
        // TODO add your handling code here:
        if(validateAllTextField())
            return;
        returnDataToMainInterface();
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                invokeContract();
            }
        }
        );
    }//GEN-LAST:event_btnMakeContractActionPerformed

    public void invokeContract()
    {
        objContract = new uiContract_2(account, type, objConnection, stmt, this, objMain);
        objContract.setVisible(true);
    }
    
    private void txtTotalHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalHoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalHoActionPerformed

    private void txtPayStatusHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPayStatusHoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPayStatusHoActionPerformed

    private void txtDateHoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDateHoMouseClicked
        // TODO add your handling code here:
        initDateChooser();
        diaDateChooser.addListener(txtDateHo);
        diaDateChooser.setVisible(true);        
    }//GEN-LAST:event_txtDateHoMouseClicked

    private void txtFromDateHoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFromDateHoMouseClicked
        // TODO add your handling code here:
        initDateChooser();
        diaDateChooser.addListener(txtFromDateHo);
        diaDateChooser.setVisible(true); 
        FromDateHo = txtFromDateHo.getText();
        showTotalAndCommission();
    }//GEN-LAST:event_txtFromDateHoMouseClicked

    private void txtToDateHoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtToDateHoMouseClicked
        // TODO add your handling code here:
        initDateChooser();
        diaDateChooser.addListener(txtToDateHo);
        diaDateChooser.setVisible(true); 
        ToDateHo = txtTotalHo.getText();
        showTotalAndCommission();
    }//GEN-LAST:event_txtToDateHoMouseClicked

        
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String[] arrSearch = {"IDHo" , "IDGu" , "IDApa" ,"IDCo" , "DateHo" ,"FromDateHo" ,"ToDateHo" ,"PayStatusHo", "IDSer"};
        objSearch = new SearchData(this, true);
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                objSearch.showGUI(arrSearch, "Holding");
                objSearch.setVisible(true);
            }
        }        
        );
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtToDateHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtToDateHoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtToDateHoActionPerformed

    private void txtIDSerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDSerMouseClicked
        // TODO add your handling code here:
        
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                invokeService();
            }
        });
    }//GEN-LAST:event_txtIDSerMouseClicked

    private void txtIDApaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIDApaMouseClicked
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
               invokeQLCH(); 
            }
        });
    }//GEN-LAST:event_txtIDApaMouseClicked

    private void btnBookApartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookApartmentActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
               invokeQLCH(); 
            }
        });
        
    }//GEN-LAST:event_btnBookApartmentActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        // TODO add your handling code here:
        showTotalAndCommission();
    }//GEN-LAST:event_btnTotalActionPerformed

    public void showTotalAndCommission()
    {
        TotalHo = TotalMoney(pricePerDay);
        txtTotalHo.setText(String.valueOf(TotalHo));
        CommissionHo = TotalHo * ratioCommission;
        txtCommissionHo.setText(String.valueOf(CommissionHo));
    }
    
    private void invokeQLCH()
    {
        objQLCH = new QLCH1(account, type, objConnection, stmt, this , objMain);
        objQLCH.setVisible(true);
    }
    
    private void invokeService()
    {
        objSer2 = new Services_2(account, type, objConnection, stmt, txtIDSer, objMain);
        objSer2.setVisible(true);
    }
    
    public void goToContract()
    {
        btnMakeContract.doClick();
    }
    
    public void setIDApa(String data)
    {
        txtIDApa.setText(data);
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
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new uiHolding_2().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBookApartment;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnMakeContract;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTotal;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    /*
    private javax.swing.JPanel pButton;
    */
    private Library.G2Panel pButton;
    private javax.swing.JPanel pCollaborator;
    private javax.swing.JPanel pGuest;
    /*
    private javax.swing.JPanel pHolding;
    */
    private Library.G2Panel pHolding;
    /*
    private javax.swing.JPanel pImageCollaborator;
    */
    private Library.G2ImagePanel pImageCollaborator;
    /*
    private javax.swing.JPanel pImageGuest;
    */
    private Library.G2ImagePanel pImageGuest;
    private javax.swing.JPanel pTblHo;
    private javax.swing.JTable tblHo;
    /*
    private javax.swing.JTextField txtCommissionHo;
    */
    private Library.G2TextField txtCommissionHo;
    private javax.swing.JTextField txtDOBCo2;
    private javax.swing.JTextField txtDOBGu2;
    /*
    private javax.swing.JTextField txtDateHo;
    */
    private Library.G2TextField txtDateHo;
    private javax.swing.JTextField txtEmailCo2;
    private javax.swing.JTextField txtEmailGu2;
    /*
    private javax.swing.JTextField txtFromDateHo;
    */
    private Library.G2TextField txtFromDateHo;
    /*
    private javax.swing.JTextField txtIDApa;
    */
    private Library.G2TextField txtIDApa;
    /*
    private javax.swing.JTextField txtIDCo;
    */
    private Library.G2TextField txtIDCo;
    private javax.swing.JTextField txtIDCo2;
    /*
    private javax.swing.JTextField txtIDGu;
    */
    private Library.G2TextField txtIDGu;
    private javax.swing.JTextField txtIDGu2;
    /*
    private javax.swing.JTextField txtIDHo;
    */
    private Library.G2TextField txtIDHo;
    /*
    private javax.swing.JTextField txtIDSer;
    */
    private Library.G2TextField txtIDSer;
    private javax.swing.JTextField txtIdentificationNumberCo2;
    private javax.swing.JTextField txtIdentificationNumberGu2;
    private javax.swing.JTextField txtNameCo2;
    private javax.swing.JTextField txtNameGu2;
    /*
    private javax.swing.JTextField txtPayStatusHo;
    */
    private Library.G2TextField txtPayStatusHo;
    private javax.swing.JTextField txtPhoneCo2;
    private javax.swing.JTextField txtPhoneGu2;
    /*
    private javax.swing.JTextField txtToDateHo;
    */
    private Library.G2TextField txtToDateHo;
    /*
    private javax.swing.JTextField txtTotalHo;
    */
    private Library.G2TextField txtTotalHo;
    // End of variables declaration//GEN-END:variables

   
    
    @Override
    public void dispose(){
        if (objMain != null)
        {
            objMain.setVisible(true);
            returnDataToMainInterface();
        }
        if (objMain2 != null)
            objMain2.setVisible(true);
        super.dispose();
    }

    public void returnDataToMainInterface()
    {
        objMain.setIDHo(IDHo);
        objMain.setIDCo(IDCo);
        objMain.setIDGu(IDGu);
        objMain.setIDApa(IDApa);
    }
//    @Override
//    public void receiveData() {
//        System.out.println("data");
//    }

//    @Override
//    public void showTable() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
