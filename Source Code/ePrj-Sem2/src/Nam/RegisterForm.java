/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nam;

import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Namcham
 */
public class RegisterForm extends javax.swing.JFrame {
    
    Connection conn;
    Statement stmt;
    ResultSet rs;
    String sql;

    String continueAccount, continueType;

    /**
     * Creates new form RegisterForm
     * @param account
     * @param type
     * @param statement
     * @param connection
     */
    public RegisterForm(String account, String type, Connection connection, Statement statement) {
        initComponents();
        continueAccount = account;
        continueType = type;
        conn = connection;
        stmt = statement;
        this.setLocationRelativeTo(null);
        txtPathImageCo.setEditable(false);
        txtPathImageGU.setEditable(false);
    }

    private void coResetText() {
        txtAddressCo.setText("");
        txtIDCo.setText("");
        txtNameCo.setText("");
        dateChooserDOBCo.setDate(null);
        txtDepositCo.setText("");
        txtEmailCo.setText("");
        txtGradeCo.setText("");
        txtIdentifyCo.setText("");
        txtPhoneCo.setText("");
        txtPathImageCo.setText("");
    }

    private void guResetText() {
        txtIDGU.setText("");
        txtNameGU.setText("");
        txtDOBGU.setText("");
        txtIdentifyGU.setText("");
        txtPhoneGU.setText("");
        txtEmailGU.setText("");
        txtStatusGU.setText("");
        txtBelongCoGU.setText("");
        txtPathImageGU.setText("");
    }
    
    private void load() {
        if (continueType.equals("co")) {
            jTabblePane.remove(pnelCol);
        }
    }
    
    private void checkBlankCo(){
        if (txtIDCo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID cannot be blank. Re-Enter.");
            txtIDCo.grabFocus();
            return ;
        }
        if (txtPhoneCo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Phone cannot be blank. Re-Enter.");
            txtPhoneCo.grabFocus();
            return ;
        }
        if (txtNameCo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be blank. Re-Enter.");
            txtNameCo.grabFocus();
            return ;
        }
        if (txtEmailCo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email cannot be blank. Re-Enter.");
            txtEmailCo.grabFocus();
            return ;
        }
        if (txtIdentifyCo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Identified number cannot be blank. Re-Enter.");
            txtIdentifyCo.grabFocus();
            return ;
        }
        if (txtGradeCo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Grade cannot be blank. Re-Enter.");
            txtGradeCo.grabFocus();
            return ;
        }
        if (dateChooserDOBCo.getDate() == null) {
            JOptionPane.showMessageDialog(this, "DOB cannot be blank. Re-Enter.");
            dateChooserDOBCo.grabFocus();
            return ;
        }
        if (txtDepositCo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Deposit cannot be blank. Re-Enter.");
            txtDepositCo.grabFocus();
            return ;
        }
        if (txtAddressCo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Address cannot be blank. Re-Enter.");
            txtAddressCo.grabFocus();
            return ;
        }
    }
    
    private void checkBlankGu(){
        if (txtIDGU.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID cannot be blank. Re-Enter.");
            txtIDGU.grabFocus();
            return ;
        }
        if (txtNameGU.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be blank. Re-Enter.");
            txtNameGU.grabFocus();
            return ;
        }
        if (txtDOBGU.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "DOB cannot be blank. Re-Enter.");
            txtDOBGU.grabFocus();
            return ;
        }
        if (txtIdentifyGU.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Identified number cannot be blank. Re-Enter.");
            txtIdentifyGU.grabFocus();
            return ;
        }
        if (txtPhoneGU.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Phone cannot be blank. Re-Enter.");
            txtPhoneGU.grabFocus();
            return ;
        }
        if (txtEmailGU.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email cannot be blank. Re-Enter.");
            txtEmailGU.grabFocus();
            return ;
        }
        if (txtStatusGU.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Status cannot be blank. Re-Enter.");
            txtStatusGU.grabFocus();
            return ;
        }
        if (txtBelongCoGU.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Belonging to Collaborator cannot be blank. Re-Enter.");
            txtBelongCoGU.grabFocus();
            return ;
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

        jPanel1 = new javax.swing.JPanel();
        lbRegister = new javax.swing.JLabel();
        lbMin = new javax.swing.JLabel();
        lbClose = new javax.swing.JLabel();
        jTabblePane = new javax.swing.JTabbedPane();
        pnelCol = new javax.swing.JPanel();
        lbImageCo = new javax.swing.JLabel();
        lbIDCo = new javax.swing.JLabel();
        lbNameCo = new javax.swing.JLabel();
        lbIdentifyCo2 = new javax.swing.JLabel();
        lbDOBCo = new javax.swing.JLabel();
        lbAddressCo = new javax.swing.JLabel();
        txtIDCo = new javax.swing.JTextField();
        txtNameCo = new javax.swing.JTextField();
        txtIdentifyCo = new javax.swing.JTextField();
        lbPhoneCo = new javax.swing.JLabel();
        txtPhoneCo = new javax.swing.JTextField();
        lbEmailCo = new javax.swing.JLabel();
        lbGradeCo = new javax.swing.JLabel();
        lbDepositCo = new javax.swing.JLabel();
        txtEmailCo = new javax.swing.JTextField();
        txtGradeCo = new javax.swing.JTextField();
        txtDepositCo = new javax.swing.JTextField();
        txtPathImageCo = new javax.swing.JTextField();
        btnAttachCo = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        txtAddressCo = new javax.swing.JTextArea();
        btnCreateCo = new javax.swing.JButton();
        btnResetCo = new javax.swing.JButton();
        btnBackCo = new javax.swing.JButton();
        dateChooserDOBCo = new com.toedter.calendar.JDateChooser();
        pnelGuest = new javax.swing.JPanel();
        lbAttachImageGuest = new javax.swing.JLabel();
        lbIDGU = new javax.swing.JLabel();
        lbNameGU = new javax.swing.JLabel();
        lbDOBGU = new javax.swing.JLabel();
        lbIdentifyGU = new javax.swing.JLabel();
        lbIPhoneGU = new javax.swing.JLabel();
        lbEmailGU = new javax.swing.JLabel();
        lbStatusGU = new javax.swing.JLabel();
        lbCoIDGU = new javax.swing.JLabel();
        txtIDGU = new javax.swing.JTextField();
        txtNameGU = new javax.swing.JTextField();
        txtDOBGU = new javax.swing.JTextField();
        txtIdentifyGU = new javax.swing.JTextField();
        txtPhoneGU = new javax.swing.JTextField();
        txtEmailGU = new javax.swing.JTextField();
        txtStatusGU = new javax.swing.JTextField();
        txtBelongCoGU = new javax.swing.JTextField();
        btnBackGu = new javax.swing.JButton();
        btnCreateGU = new javax.swing.JButton();
        btnResetGU = new javax.swing.JButton();
        txtPathImageGU = new javax.swing.JTextField();
        btnAttachGU = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        lbRegister.setBackground(new java.awt.Color(255, 153, 0));
        lbRegister.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbRegister.setForeground(new java.awt.Color(255, 255, 255));
        lbRegister.setText("    Register");

        lbMin.setBackground(new java.awt.Color(255, 153, 0));
        lbMin.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbMin.setForeground(new java.awt.Color(255, 51, 51));
        lbMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMin.setText("_");
        lbMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMinMouseClicked(evt);
            }
        });

        lbClose.setBackground(new java.awt.Color(255, 153, 0));
        lbClose.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbClose.setForeground(new java.awt.Color(255, 51, 51));
        lbClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbClose.setText("x");
        lbClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lbRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(lbMin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbClose, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMin, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbClose, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnelCol.setBackground(new java.awt.Color(102, 102, 102));

        lbImageCo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        lbIDCo.setBackground(new java.awt.Color(153, 153, 153));
        lbIDCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbIDCo.setForeground(new java.awt.Color(255, 255, 255));
        lbIDCo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbIDCo.setText("ID");

        lbNameCo.setBackground(new java.awt.Color(153, 153, 153));
        lbNameCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNameCo.setForeground(new java.awt.Color(255, 255, 255));
        lbNameCo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNameCo.setText("Name");

        lbIdentifyCo2.setBackground(new java.awt.Color(153, 153, 153));
        lbIdentifyCo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbIdentifyCo2.setForeground(new java.awt.Color(255, 255, 255));
        lbIdentifyCo2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbIdentifyCo2.setText("Identify No.");

        lbDOBCo.setBackground(new java.awt.Color(153, 153, 153));
        lbDOBCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbDOBCo.setForeground(new java.awt.Color(255, 255, 255));
        lbDOBCo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDOBCo.setText("DOB");

        lbAddressCo.setBackground(new java.awt.Color(153, 153, 153));
        lbAddressCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbAddressCo.setForeground(new java.awt.Color(255, 255, 255));
        lbAddressCo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbAddressCo.setText("Address");

        txtIDCo.setBackground(new java.awt.Color(153, 153, 153));
        txtIDCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIDCo.setForeground(new java.awt.Color(255, 255, 255));

        txtNameCo.setBackground(new java.awt.Color(153, 153, 153));
        txtNameCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNameCo.setForeground(new java.awt.Color(255, 255, 255));

        txtIdentifyCo.setBackground(new java.awt.Color(153, 153, 153));
        txtIdentifyCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIdentifyCo.setForeground(new java.awt.Color(255, 255, 255));

        lbPhoneCo.setBackground(new java.awt.Color(153, 153, 153));
        lbPhoneCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPhoneCo.setForeground(new java.awt.Color(255, 255, 255));
        lbPhoneCo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPhoneCo.setText("Phone");

        txtPhoneCo.setBackground(new java.awt.Color(153, 153, 153));
        txtPhoneCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPhoneCo.setForeground(new java.awt.Color(255, 255, 255));

        lbEmailCo.setBackground(new java.awt.Color(153, 153, 153));
        lbEmailCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEmailCo.setForeground(new java.awt.Color(255, 255, 255));
        lbEmailCo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbEmailCo.setText("Email");

        lbGradeCo.setBackground(new java.awt.Color(153, 153, 153));
        lbGradeCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbGradeCo.setForeground(new java.awt.Color(255, 255, 255));
        lbGradeCo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbGradeCo.setText("Grade");

        lbDepositCo.setBackground(new java.awt.Color(153, 153, 153));
        lbDepositCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbDepositCo.setForeground(new java.awt.Color(255, 255, 255));
        lbDepositCo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDepositCo.setText("Deposit");

        txtEmailCo.setBackground(new java.awt.Color(153, 153, 153));
        txtEmailCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEmailCo.setForeground(new java.awt.Color(255, 255, 255));

        txtGradeCo.setBackground(new java.awt.Color(153, 153, 153));
        txtGradeCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtGradeCo.setForeground(new java.awt.Color(255, 255, 255));

        txtDepositCo.setBackground(new java.awt.Color(153, 153, 153));
        txtDepositCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDepositCo.setForeground(new java.awt.Color(255, 255, 255));

        txtPathImageCo.setBackground(new java.awt.Color(153, 153, 153));
        txtPathImageCo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPathImageCo.setForeground(new java.awt.Color(255, 255, 255));

        btnAttachCo.setBackground(new java.awt.Color(51, 255, 204));
        btnAttachCo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAttachCo.setForeground(new java.awt.Color(255, 255, 255));
        btnAttachCo.setText("Attach");
        btnAttachCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttachCoActionPerformed(evt);
            }
        });

        txtAddressCo.setColumns(20);
        txtAddressCo.setRows(5);
        jScrollPane.setViewportView(txtAddressCo);

        btnCreateCo.setBackground(new java.awt.Color(51, 51, 255));
        btnCreateCo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCreateCo.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateCo.setText("Create");
        btnCreateCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCoActionPerformed(evt);
            }
        });

        btnResetCo.setBackground(new java.awt.Color(255, 51, 51));
        btnResetCo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnResetCo.setForeground(new java.awt.Color(255, 255, 255));
        btnResetCo.setText("Reset");
        btnResetCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetCoActionPerformed(evt);
            }
        });

        btnBackCo.setBackground(new java.awt.Color(255, 255, 102));
        btnBackCo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBackCo.setForeground(new java.awt.Color(255, 255, 255));
        btnBackCo.setText("Back");

        javax.swing.GroupLayout pnelColLayout = new javax.swing.GroupLayout(pnelCol);
        pnelCol.setLayout(pnelColLayout);
        pnelColLayout.setHorizontalGroup(
            pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnelColLayout.createSequentialGroup()
                .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnelColLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnelColLayout.createSequentialGroup()
                                    .addComponent(lbDOBCo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dateChooserDOBCo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbDepositCo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnelColLayout.createSequentialGroup()
                                    .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnCreateCo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBackCo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(pnelColLayout.createSequentialGroup()
                                            .addComponent(btnResetCo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(114, 114, 114)
                                            .addComponent(btnAttachCo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtPathImageCo, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(10, 10, 10)))
                            .addGroup(pnelColLayout.createSequentialGroup()
                                .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnelColLayout.createSequentialGroup()
                                        .addComponent(lbIDCo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIDCo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbPhoneCo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnelColLayout.createSequentialGroup()
                                        .addComponent(lbNameCo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNameCo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbEmailCo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnelColLayout.createSequentialGroup()
                                        .addComponent(lbIdentifyCo2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIdentifyCo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbGradeCo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhoneCo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmailCo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGradeCo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDepositCo, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(lbImageCo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnelColLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbAddressCo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pnelColLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDepositCo, txtEmailCo, txtGradeCo, txtIDCo, txtPhoneCo});

        pnelColLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBackCo, btnCreateCo, btnResetCo});

        pnelColLayout.setVerticalGroup(
            pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnelColLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIDCo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIDCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbPhoneCo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPhoneCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNameCo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNameCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbEmailCo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmailCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIdentifyCo2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdentifyCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbGradeCo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGradeCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbDOBCo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbDepositCo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDepositCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateChooserDOBCo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnelColLayout.createSequentialGroup()
                        .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAddressCo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAttachCo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCreateCo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnResetCo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPathImageCo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBackCo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbImageCo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pnelColLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbIDCo, txtDepositCo, txtEmailCo, txtGradeCo, txtIDCo, txtIdentifyCo, txtNameCo, txtPhoneCo});

        jTabblePane.addTab("Collaborators", pnelCol);

        pnelGuest.setBackground(new java.awt.Color(102, 102, 102));

        lbAttachImageGuest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lbIDGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbIDGU.setForeground(new java.awt.Color(255, 255, 255));
        lbIDGU.setText("ID");

        lbNameGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbNameGU.setForeground(new java.awt.Color(255, 255, 255));
        lbNameGU.setText("Name");

        lbDOBGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbDOBGU.setForeground(new java.awt.Color(255, 255, 255));
        lbDOBGU.setText("DOB");

        lbIdentifyGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbIdentifyGU.setForeground(new java.awt.Color(255, 255, 255));
        lbIdentifyGU.setText("Identify no.");

        lbIPhoneGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbIPhoneGU.setForeground(new java.awt.Color(255, 255, 255));
        lbIPhoneGU.setText("Phone");

        lbEmailGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbEmailGU.setForeground(new java.awt.Color(255, 255, 255));
        lbEmailGU.setText("Email");

        lbStatusGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbStatusGU.setForeground(new java.awt.Color(255, 255, 255));
        lbStatusGU.setText("Status");

        lbCoIDGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbCoIDGU.setForeground(new java.awt.Color(255, 255, 255));
        lbCoIDGU.setText("Belong to Collaborator");

        txtIDGU.setBackground(new java.awt.Color(153, 153, 153));
        txtIDGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtIDGU.setForeground(new java.awt.Color(255, 255, 255));

        txtNameGU.setBackground(new java.awt.Color(153, 153, 153));
        txtNameGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtNameGU.setForeground(new java.awt.Color(255, 255, 255));

        txtDOBGU.setBackground(new java.awt.Color(153, 153, 153));
        txtDOBGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtDOBGU.setForeground(new java.awt.Color(255, 255, 255));

        txtIdentifyGU.setBackground(new java.awt.Color(153, 153, 153));
        txtIdentifyGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtIdentifyGU.setForeground(new java.awt.Color(255, 255, 255));

        txtPhoneGU.setBackground(new java.awt.Color(153, 153, 153));
        txtPhoneGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtPhoneGU.setForeground(new java.awt.Color(255, 255, 255));

        txtEmailGU.setBackground(new java.awt.Color(153, 153, 153));
        txtEmailGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtEmailGU.setForeground(new java.awt.Color(255, 255, 255));

        txtStatusGU.setBackground(new java.awt.Color(153, 153, 153));
        txtStatusGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtStatusGU.setForeground(new java.awt.Color(255, 255, 255));

        txtBelongCoGU.setBackground(new java.awt.Color(153, 153, 153));
        txtBelongCoGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtBelongCoGU.setForeground(new java.awt.Color(255, 255, 255));

        btnBackGu.setBackground(new java.awt.Color(255, 255, 51));
        btnBackGu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBackGu.setForeground(new java.awt.Color(255, 255, 255));
        btnBackGu.setText("Back");

        btnCreateGU.setBackground(new java.awt.Color(51, 51, 255));
        btnCreateGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCreateGU.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateGU.setText("Create");

        btnResetGU.setBackground(new java.awt.Color(255, 51, 51));
        btnResetGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnResetGU.setForeground(new java.awt.Color(255, 255, 255));
        btnResetGU.setText("Reset");
        btnResetGU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetGUActionPerformed(evt);
            }
        });

        txtPathImageGU.setBackground(new java.awt.Color(153, 153, 153));
        txtPathImageGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtPathImageGU.setForeground(new java.awt.Color(255, 255, 255));

        btnAttachGU.setBackground(new java.awt.Color(51, 255, 153));
        btnAttachGU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAttachGU.setForeground(new java.awt.Color(255, 255, 255));
        btnAttachGU.setText("Attach");
        btnAttachGU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttachGUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnelGuestLayout = new javax.swing.GroupLayout(pnelGuest);
        pnelGuest.setLayout(pnelGuestLayout);
        pnelGuestLayout.setHorizontalGroup(
            pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnelGuestLayout.createSequentialGroup()
                .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnelGuestLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbAttachImageGuest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPathImageGU, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))
                    .addGroup(pnelGuestLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnAttachGU, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnelGuestLayout.createSequentialGroup()
                        .addComponent(lbCoIDGU, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBelongCoGU, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnelGuestLayout.createSequentialGroup()
                            .addComponent(lbIdentifyGU, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdentifyGU, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnelGuestLayout.createSequentialGroup()
                            .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbIDGU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbStatusGU, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbEmailGU, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbNameGU, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbDOBGU, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIPhoneGU, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnelGuestLayout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtIDGU, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNameGU, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDOBGU, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnelGuestLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPhoneGU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmailGU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtStatusGU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(31, 31, 31))
            .addGroup(pnelGuestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBackGu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCreateGU, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnResetGU, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );

        pnelGuestLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbDOBGU, lbEmailGU, lbIDGU, lbIPhoneGU, lbIdentifyGU, lbNameGU, lbStatusGU});

        pnelGuestLayout.setVerticalGroup(
            pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnelGuestLayout.createSequentialGroup()
                .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnelGuestLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDGU)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnelGuestLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbIDGU, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNameGU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNameGU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDOBGU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDOBGU))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbIdentifyGU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdentifyGU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIPhoneGU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhoneGU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEmailGU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmailGU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbStatusGU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStatusGU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCoIDGU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBelongCoGU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(pnelGuestLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lbAttachImageGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPathImageGU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAttachGU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBackGu)
                    .addComponent(btnCreateGU, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetGU))
                .addContainerGap())
        );

        pnelGuestLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbCoIDGU, lbDOBGU, lbEmailGU, lbIDGU, lbIPhoneGU, lbIdentifyGU, lbNameGU, lbStatusGU, txtBelongCoGU, txtEmailGU, txtIdentifyGU, txtNameGU, txtPhoneGU, txtStatusGU});

        pnelGuestLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBackGu, btnCreateGU, btnResetGU});

        jTabblePane.addTab("Guest", pnelGuest);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabblePane)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabblePane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lbMinMouseClicked

    private void lbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseClicked
        if (JOptionPane.showConfirmDialog(new JFrame(),
                "Do you want to quit this application ?", "",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_lbCloseMouseClicked

    private void btnResetCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetCoActionPerformed
        // TODO add your handling code here:
        coResetText();
        lbImageCo.setIcon(null);
    }//GEN-LAST:event_btnResetCoActionPerformed

    private void btnResetGUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetGUActionPerformed
        // TODO add your handling code here:
        guResetText();
        lbAttachImageGuest.setIcon(null);
    }//GEN-LAST:event_btnResetGUActionPerformed

    private void btnAttachCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttachCoActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String fileName = file.getAbsolutePath();
        txtPathImageCo.setText(fileName);
        ImageIcon icon = new ImageIcon(fileName);
        Image image = icon.getImage().getScaledInstance(lbImageCo.getWidth(), lbImageCo.getHeight(), Image.SCALE_SMOOTH);
        lbImageCo.setIcon(new ImageIcon(image));
    }//GEN-LAST:event_btnAttachCoActionPerformed

    private void btnAttachGUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttachGUActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String fileName = file.getAbsolutePath();
        txtPathImageGU.setText(fileName);
        ImageIcon icon = new ImageIcon(fileName);
        Image image = icon.getImage().getScaledInstance(lbAttachImageGuest.getWidth(), lbAttachImageGuest.getHeight(), Image.SCALE_SMOOTH);
        lbAttachImageGuest.setIcon(new ImageIcon(image));
    }//GEN-LAST:event_btnAttachGUActionPerformed

    private void btnCreateCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCoActionPerformed
        // TODO add your handling code here:
        checkBlankCo();
        if (!txtIDCo.getText().matches("^Co[0-9]{1,3}$")) {
            JOptionPane.showMessageDialog(this, "ID format is Co[xxx] with xxx is 1-3 digits");
            txtIDCo.setText("");
            txtIDCo.grabFocus();
        }
    }//GEN-LAST:event_btnCreateCoActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegisterForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAttachCo;
    private javax.swing.JButton btnAttachGU;
    private javax.swing.JButton btnBackCo;
    private javax.swing.JButton btnBackGu;
    private javax.swing.JButton btnCreateCo;
    private javax.swing.JButton btnCreateGU;
    private javax.swing.JButton btnResetCo;
    private javax.swing.JButton btnResetGU;
    private com.toedter.calendar.JDateChooser dateChooserDOBCo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTabbedPane jTabblePane;
    private javax.swing.JLabel lbAddressCo;
    private javax.swing.JLabel lbAttachImageGuest;
    private javax.swing.JLabel lbClose;
    private javax.swing.JLabel lbCoIDGU;
    private javax.swing.JLabel lbDOBCo;
    private javax.swing.JLabel lbDOBGU;
    private javax.swing.JLabel lbDepositCo;
    private javax.swing.JLabel lbEmailCo;
    private javax.swing.JLabel lbEmailGU;
    private javax.swing.JLabel lbGradeCo;
    private javax.swing.JLabel lbIDCo;
    private javax.swing.JLabel lbIDGU;
    private javax.swing.JLabel lbIPhoneGU;
    private javax.swing.JLabel lbIdentifyCo2;
    private javax.swing.JLabel lbIdentifyGU;
    private javax.swing.JLabel lbImageCo;
    private javax.swing.JLabel lbMin;
    private javax.swing.JLabel lbNameCo;
    private javax.swing.JLabel lbNameGU;
    private javax.swing.JLabel lbPhoneCo;
    private javax.swing.JLabel lbRegister;
    private javax.swing.JLabel lbStatusGU;
    private javax.swing.JPanel pnelCol;
    private javax.swing.JPanel pnelGuest;
    private javax.swing.JTextArea txtAddressCo;
    private javax.swing.JTextField txtBelongCoGU;
    private javax.swing.JTextField txtDOBGU;
    private javax.swing.JTextField txtDepositCo;
    private javax.swing.JTextField txtEmailCo;
    private javax.swing.JTextField txtEmailGU;
    private javax.swing.JTextField txtGradeCo;
    private javax.swing.JTextField txtIDCo;
    private javax.swing.JTextField txtIDGU;
    private javax.swing.JTextField txtIdentifyCo;
    private javax.swing.JTextField txtIdentifyGU;
    private javax.swing.JTextField txtNameCo;
    private javax.swing.JTextField txtNameGU;
    private javax.swing.JTextField txtPathImageCo;
    private javax.swing.JTextField txtPathImageGU;
    private javax.swing.JTextField txtPhoneCo;
    private javax.swing.JTextField txtPhoneGU;
    private javax.swing.JTextField txtStatusGU;
    // End of variables declaration//GEN-END:variables
}
