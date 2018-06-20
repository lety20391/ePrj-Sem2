/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nam;

import Library.G2FileBrowserExtend;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Namcham
 */
public class SearchGuest extends javax.swing.JDialog {

    Connection conn;
    Statement stmt;
    ResultSet rs;
    String sql;

    String continueAccount, continueType, guest, path;
    String id, pass, type, ques, answer;
    int acti;
    String fileName = "";

    MainControlInterface main;

    static String linkImg;
    static boolean activeAcc;

    /**
     * Creates new form SearchGuest
     */
    public SearchGuest(java.awt.Frame parent, boolean modal, String account, String type, Connection connection, Statement statement, String guAcc, MainControlInterface main) {
        super(parent, modal);
        initComponents();
        continueAccount = account;
        continueType = type;
        conn = connection;
        stmt = statement;
        this.main = main;
        guest = guAcc;

        setLocationRelativeTo(parent);

        textEditeOnOff(false);
        btnAttach.setEnabled(false);
        rbBlock.setEnabled(false);
        rbUnBlock.setEnabled(false);
        changePassOnOff(false);
        load();
        pack();
    }

    private void textEditeOnOff(boolean check) {
        txtID.setEditable(check);
        txtName.setEditable(check);
        txtIdentity.setEditable(check);
        txtPhone.setEditable(check);
        txtEmail.setEditable(check);
        txtGrade.setEditable(check);
        datechooserDOB.setEnabled(check);
    }

    private void changePassOnOff(boolean check) {
        txtNewPass.setEditable(check);
        cbNewQuestion.setEditable(check);
        txtNewAnswer.setEditable(check);
    }

    private void load() {
        sql = "select * from Account where ID = '" + guest + "'";
        try {
            rs = stmt.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                acti = rs.getInt("Active");
            }
            activeAcc = acti != 0;
        } catch (SQLException ex) {
            Logger.getLogger(SearchCol.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (activeAcc == true) {
            rbUnBlock.setSelected(true);
            rbBlock.setSelected(false);
        } else {
            rbUnBlock.setSelected(false);
            rbBlock.setSelected(true);
        }

        sql = "select * from Guest where IDGu = '" + guest + "'";
        try {
            rs = stmt.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                txtID.setText(rs.getString("IDGu"));
                txtName.setText(rs.getString("NameGu"));
                txtIdentity.setText(rs.getString("IdentificationNumberGu"));
                txtPhone.setText(rs.getString("PhoneGu"));
                txtEmail.setText(rs.getString("EmailGu"));
                txtGrade.setText(rs.getString("StatusGu"));
                linkImg = rs.getString("ImageGu");
                datechooserDOB.setDate(rs.getDate("DOBGu"));
                //acti = rs.getBoolean("Active");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchCol.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon icon = new ImageIcon(linkImg);
        int width = lbImageGU.getWidth();
        int height = lbImageGU.getHeight();
        int icoWidth = icon.getIconWidth();
        int icoHeight = icon.getIconHeight();
        Image image;
        if (icoWidth / icoHeight >= width / height) {
            image = icon.getImage().getScaledInstance(width, icoHeight * width / icoWidth, Image.SCALE_SMOOTH);
        } else {
            image = icon.getImage().getScaledInstance(icoWidth * height / icoHeight, height, Image.SCALE_SMOOTH);
        }

        lbImageGU.setIcon(new ImageIcon(image));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbImageGU = new javax.swing.JLabel();
        btnAttach = new javax.swing.JButton();
        rbBlock = new javax.swing.JRadioButton();
        rbUnBlock = new javax.swing.JRadioButton();
        lbName = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lbName1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lbName2 = new javax.swing.JLabel();
        datechooserDOB = new com.toedter.calendar.JDateChooser();
        lbName3 = new javax.swing.JLabel();
        txtIdentity = new javax.swing.JTextField();
        lbName5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lbName6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lbName7 = new javax.swing.JLabel();
        txtGrade = new javax.swing.JTextField();
        btnChangePass = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        txtNewPass = new javax.swing.JTextField();
        cbNewQuestion = new javax.swing.JComboBox<>();
        txtNewAnswer = new javax.swing.JTextField();
        lbName12 = new javax.swing.JLabel();
        lbName11 = new javax.swing.JLabel();
        lbName10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbImageGU.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        btnAttach.setBackground(new java.awt.Color(51, 255, 204));
        btnAttach.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAttach.setText("Attach");
        btnAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttachActionPerformed(evt);
            }
        });

        rbBlock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbBlock.setText("Block");

        rbUnBlock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbUnBlock.setText("Active");

        lbName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbName.setText("User ID:");

        txtID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lbName1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbName1.setText("Name:");

        txtName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lbName2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbName2.setText("Date of birth:");

        datechooserDOB.setDateFormatString("yyyy-MM-dd");

        lbName3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbName3.setText("Identified no.:");

        txtIdentity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lbName5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbName5.setText("Phone:");

        txtPhone.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lbName6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbName6.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lbName7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbName7.setText("Grade:");

        txtGrade.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        btnChangePass.setBackground(new java.awt.Color(51, 51, 255));
        btnChangePass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnChangePass.setForeground(new java.awt.Color(255, 255, 255));
        btnChangePass.setText("Update pass, question and answer");
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 51, 51));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(51, 51, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtNewPass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        cbNewQuestion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbNewQuestion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is name of your best friend ?", "What is name of your pet ?", "What is name of your favorite film ?" }));

        txtNewAnswer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lbName12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbName12.setText("New answer:");

        lbName11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbName11.setText("New question:");

        lbName10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbName10.setText("New password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbName12, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNewAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbName11, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbNewQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbName10, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rbBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbUnBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lbImageGU, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(42, 42, 42)
                                    .addComponent(btnAttach, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbName7, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbName1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbName2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datechooserDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbName3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdentity, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbName5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbName6, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(42, 42, 42))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {datechooserDOB, txtName});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbNewQuestion, txtNewAnswer, txtNewPass});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbName1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datechooserDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbName3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdentity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbName5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbName6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbName7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGrade))
                        .addGap(92, 92, 92))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbImageGU, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAttach, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbBlock)
                            .addComponent(rbUnBlock))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btnChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbName10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbName11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbNewQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbName12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNewAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {datechooserDOB, txtName});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbNewQuestion, txtNewAnswer, txtNewPass});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttachActionPerformed
        // TODO add your handling code here:

        G2FileBrowserExtend objFileChooser = new G2FileBrowserExtend();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG Images", "jpg", "png");
        objFileChooser.setFileFilter(filter);
        int returnVal = objFileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            linkImg = objFileChooser.getSelectedFile().getPath();
        }
        if (linkImg.isEmpty()) {
            return;
        }
        //txtImgPath.setText(fileName);
        ImageIcon icon = new ImageIcon(linkImg);
        int width = lbImageGU.getWidth();
        int height = lbImageGU.getHeight();
        int icoWidth = icon.getIconWidth();
        int icoHeight = icon.getIconHeight();
        Image image;
        if (icoWidth / icoHeight >= width / height) {
            image = icon.getImage().getScaledInstance(width, icoHeight * width / icoWidth, Image.SCALE_SMOOTH);
        } else {
            image = icon.getImage().getScaledInstance(icoWidth * height / icoHeight, height, Image.SCALE_SMOOTH);
        }
        lbImageGU.setIcon(new ImageIcon(image));
    }//GEN-LAST:event_btnAttachActionPerformed

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        // TODO add your handling code here:
        String str = btnChangePass.getText().trim();
        if (str.equalsIgnoreCase("Update pass, question and answer")) {
            changePassOnOff(true);
            btnChangePass.setText("Save new password");
        } else {
            if (txtNewPass.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "New password cannot be blank.");
                return;
            }
            if (txtNewAnswer.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "New answer cannot be blank.");
                return;
            }
            ques = (String) cbNewQuestion.getSelectedItem();
            sql = "update Account set Password = '" + txtNewPass.getText() + "', Question = '" + ques + "', Answer = '" + txtNewAnswer.getText() + "' where ID = '" + txtID.getText() + "'";
            try {
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Change password successfully.");
            } catch (SQLException ex) {
                Logger.getLogger(SearchCol.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnChangePass.setText("Update pass, question and answer");
            changePassOnOff(false);
        }
    }//GEN-LAST:event_btnChangePassActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        //main.loadAccCol();
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String str = btnUpdate.getText();
        if (str.equalsIgnoreCase("update")) {
            textEditeOnOff(true);
            txtID.setEditable(false);
            btnAttach.setEnabled(true);
            rbBlock.setEnabled(true);
            rbUnBlock.setEnabled(true);
            btnUpdate.setText("Save");
        } else {

            if (txtID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID cannot be blank. Re-Enter.");
                txtID.grabFocus();
                return;
            }
            if (txtPhone.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Phone cannot be blank. Re-Enter.");
                txtPhone.grabFocus();
                return;
            }
            if (txtName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name cannot be blank. Re-Enter.");
                txtName.grabFocus();
                return;
            }
            if (txtEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Email cannot be blank. Re-Enter.");
                txtEmail.grabFocus();
                return;
            }
            if (txtIdentity.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Identified number cannot be blank. Re-Enter.");
                txtIdentity.grabFocus();
                return;
            }
            if (txtGrade.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Grade cannot be blank. Re-Enter.");
                txtGrade.grabFocus();
                return;
            }
            if (datechooserDOB.getDate() == null) {
                JOptionPane.showMessageDialog(this, "DOB format is not exact. Re-Enter.");
                datechooserDOB.grabFocus();
                return;
            }

            if (!txtPhone.getText().matches("^[0-9]{10,11}$")) {
                JOptionPane.showMessageDialog(this, "Phone just has digit only(10-11 digits)");
                txtPhone.setText("");
                txtPhone.grabFocus();
                return;
            }
            if (!txtIdentity.getText().matches("^[0-9]{9,12}$")) {
                JOptionPane.showMessageDialog(this, "Identified number just has digit only(9-12 digits)");
                txtIdentity.setText("");
                txtIdentity.grabFocus();
                return;
            }
            if (!txtEmail.getText().matches("^[a-zA-Z0-9]{1,}@[a-zA-Z0-9]{1,}\\.[a-zA-Z0-9]{1,}$")) {
                JOptionPane.showMessageDialog(this, "Email format is xxx@xxx.xxx)");
                txtEmail.setText("");
                txtEmail.grabFocus();
                return;
            }

            if (!txtName.getText().matches("^[A-z ]+$")) {
                JOptionPane.showMessageDialog(this, "Name just has characters and spaces");
                txtName.setText("");
                txtName.grabFocus();
                return;
            }
            Date date = new Date();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            int currentyear = calendar.get(Calendar.YEAR);

            calendar.setTime(datechooserDOB.getDate());
            int year = calendar.get(Calendar.YEAR);

            if ((currentyear - year) < 18) {
                JOptionPane.showMessageDialog(this, "This guest is under 18 years old. Re-enter");
                datechooserDOB.setDate(null);
                datechooserDOB.grabFocus();
                return;
            }

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String dob = df.format(datechooserDOB.getDate());
            //double depo = Double.parseDouble(txtDeposit.getText());

            int active;
            if (rbBlock.isSelected()) {
                activeAcc = false;
                active = 0;
            } else {
                activeAcc = true;
                active = 1;
            }
            sql = "update Account set Active = '" + active + "' where ID = '" + txtID.getText() + "'";
            try {
                stmt.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(SearchCol.class.getName()).log(Level.SEVERE, null, ex);
            }

            //path = lbImageCol.getText();
            sql = "update Guest set NameGu = '" + txtName.getText() + "', DOBGu = '" + dob + "', IdentificationNumberGu = '" + txtIdentity.getText() + "', PhoneGu = '" + txtPhone.getText() + "', EmailGu = '" + txtEmail.getText() + "', ImageGu = '" + linkImg + "', StatusGu = '" + txtGrade.getText() + "' where IDGu = '" + txtID.getText() + "'";
            try {
                stmt.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(SearchCol.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(this, "Update successfully.");
            textEditeOnOff(false);
            btnUpdate.setText("Update");
            btnAttach.setEnabled(false);
            rbBlock.setEnabled(false);
            rbUnBlock.setEnabled(false);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

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
//            java.util.logging.Logger.getLogger(SearchGuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SearchGuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SearchGuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SearchGuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                SearchGuest dialog = new SearchGuest(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAttach;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbNewQuestion;
    private com.toedter.calendar.JDateChooser datechooserDOB;
    private javax.swing.JLabel lbImageGU;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbName1;
    private javax.swing.JLabel lbName10;
    private javax.swing.JLabel lbName11;
    private javax.swing.JLabel lbName12;
    private javax.swing.JLabel lbName2;
    private javax.swing.JLabel lbName3;
    private javax.swing.JLabel lbName5;
    private javax.swing.JLabel lbName6;
    private javax.swing.JLabel lbName7;
    private javax.swing.JRadioButton rbBlock;
    private javax.swing.JRadioButton rbUnBlock;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGrade;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIdentity;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNewAnswer;
    private javax.swing.JTextField txtNewPass;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
