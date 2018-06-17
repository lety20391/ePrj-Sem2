/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nam;

import Dat_Le_2.uiHolding_2;
import Tuyet_Duyen.Services_2;
import Tuyet_Duyen.Theme_guest_2;
import java.awt.Point;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Namcham
 */
public class MainControlInterface extends javax.swing.JFrame {

    Connection conn;
    Statement stmt;
    ResultSet rs;
    String sql;

    String continueAccount, continueType;

    //phan dat ten cac variable cho tung Frame
    Dat_Le_2.uiHolding_2 objUIHolding;
    Dat_Le_2.uiContract_2 objUIContract;
    Duy.QuanlyCTV_2 objCTV;
    Duy.QuanlyOwner_2 objOwner;
    Tuyet_Duyen.Services_2 objService;
    Tuyet_Duyen.Theme_guest_2 objThemeGuest;
    Account accDialog;
    NotificationAdmin notiAd;

    /**
     * Creates new form MainControlInterface
     *
     * @param account
     * @param type
     * @param connection
     * @param statement
     */
    public MainControlInterface(String account, String type, Connection connection, Statement statement) {
        initComponents();
        conn = connection;
        stmt = statement;
        continueAccount = account;
        continueType = type;
        txtAccount.setText(account);
        colTxtAccount.setText(account);
        guTxtAccount.setText(account);
        setLocationRelativeTo(null);
        load();
        pack();
    }

    private void load() {
        if (continueType.equals("ad")) {
            jTabbedPane.remove(jPanelCol);
            jTabbedPane.remove(jPanelGuest);
        }
        if (continueType.equals("co")) {
            jTabbedPane.remove(jPanelAdmin);
            jTabbedPane.remove(jPanelGuest);
        }
        if (continueType.equals("gu")) {
            jTabbedPane.remove(jPanelAdmin);
            jTabbedPane.remove(jPanelCol);
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
        lbMain = new javax.swing.JLabel();
        lbClose = new javax.swing.JLabel();
        lbMin = new javax.swing.JLabel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelAdmin = new javax.swing.JPanel();
        btnNotification = new javax.swing.JButton();
        txtAccount = new javax.swing.JTextField();
        btnHolding = new javax.swing.JButton();
        btnDiscount = new javax.swing.JButton();
        btnCollaborator = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnGuest = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnServices = new javax.swing.JButton();
        jPanelCol = new javax.swing.JPanel();
        colBtnHolding = new javax.swing.JButton();
        colBtnGuest = new javax.swing.JButton();
        colTxtAccount = new javax.swing.JTextField();
        colBtnDiscount = new javax.swing.JButton();
        colLbNotification = new javax.swing.JButton();
        colBtnCreate = new javax.swing.JButton();
        jPanelGuest = new javax.swing.JPanel();
        guTxtAccount = new javax.swing.JTextField();
        guBtnDiscount = new javax.swing.JButton();
        guBtnNotification = new javax.swing.JButton();
        guBtnViewAllRoom = new javax.swing.JButton();
        guBtnFeedback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        lbMain.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbMain.setForeground(new java.awt.Color(255, 255, 255));
        lbMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMain.setText("Main control System");

        lbClose.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbClose.setForeground(new java.awt.Color(255, 51, 51));
        lbClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbClose.setText("X");
        lbClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lbMain, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbMin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbClose, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbMin, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addComponent(lbMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lbClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanelAdmin.setBackground(new java.awt.Color(102, 102, 102));

        btnNotification.setBackground(new java.awt.Color(255, 0, 0));
        btnNotification.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        btnNotification.setForeground(new java.awt.Color(255, 255, 255));
        btnNotification.setText("Notification");
        btnNotification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotificationActionPerformed(evt);
            }
        });

        txtAccount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        btnHolding.setBackground(new java.awt.Color(255, 51, 102));
        btnHolding.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        btnHolding.setForeground(new java.awt.Color(255, 255, 255));
        btnHolding.setText("Holding");
        btnHolding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoldingActionPerformed(evt);
            }
        });

        btnDiscount.setBackground(new java.awt.Color(51, 255, 51));
        btnDiscount.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        btnDiscount.setForeground(new java.awt.Color(255, 255, 255));
        btnDiscount.setText("Discount");

        btnCollaborator.setBackground(new java.awt.Color(51, 51, 255));
        btnCollaborator.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        btnCollaborator.setForeground(new java.awt.Color(255, 255, 255));
        btnCollaborator.setText("Collaborators");
        btnCollaborator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCollaboratorActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 102, 102));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");

        btnGuest.setBackground(new java.awt.Color(153, 153, 0));
        btnGuest.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        btnGuest.setForeground(new java.awt.Color(255, 255, 255));
        btnGuest.setText("Guest");
        btnGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuestActionPerformed(evt);
            }
        });

        btnCreate.setBackground(new java.awt.Color(153, 0, 153));
        btnCreate.setFont(new java.awt.Font("Tahoma", 1, 33)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Create new Account");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnServices.setBackground(new java.awt.Color(0, 255, 255));
        btnServices.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        btnServices.setForeground(new java.awt.Color(255, 255, 255));
        btnServices.setText("Services");
        btnServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAdminLayout = new javax.swing.GroupLayout(jPanelAdmin);
        jPanelAdmin.setLayout(jPanelAdminLayout);
        jPanelAdminLayout.setHorizontalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelAdminLayout.createSequentialGroup()
                            .addComponent(btnNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnHolding, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelAdminLayout.createSequentialGroup()
                            .addComponent(btnDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCollaborator, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAccount)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuest, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(btnServices, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelAdminLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHolding, btnNotification});

        jPanelAdminLayout.setVerticalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addComponent(txtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHolding, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCollaborator, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnServices, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelAdminLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHolding, btnNotification});

        jTabbedPane.addTab("Manager", jPanelAdmin);

        jPanelCol.setBackground(new java.awt.Color(102, 102, 102));

        colBtnHolding.setBackground(new java.awt.Color(255, 51, 102));
        colBtnHolding.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        colBtnHolding.setForeground(new java.awt.Color(255, 255, 255));
        colBtnHolding.setText("Holding");
        colBtnHolding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colBtnHoldingActionPerformed(evt);
            }
        });

        colBtnGuest.setBackground(new java.awt.Color(153, 153, 0));
        colBtnGuest.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        colBtnGuest.setForeground(new java.awt.Color(255, 255, 255));
        colBtnGuest.setText("Guest");

        colTxtAccount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        colTxtAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                colTxtAccountMouseClicked(evt);
            }
        });

        colBtnDiscount.setBackground(new java.awt.Color(51, 255, 51));
        colBtnDiscount.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        colBtnDiscount.setForeground(new java.awt.Color(255, 255, 255));
        colBtnDiscount.setText("Discount");

        colLbNotification.setBackground(new java.awt.Color(255, 0, 0));
        colLbNotification.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        colLbNotification.setForeground(new java.awt.Color(255, 255, 255));
        colLbNotification.setText("Notification");

        colBtnCreate.setBackground(new java.awt.Color(153, 0, 153));
        colBtnCreate.setFont(new java.awt.Font("Tahoma", 1, 33)); // NOI18N
        colBtnCreate.setForeground(new java.awt.Color(255, 255, 255));
        colBtnCreate.setText("Create new Account");
        colBtnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colBtnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelColLayout = new javax.swing.GroupLayout(jPanelCol);
        jPanelCol.setLayout(jPanelColLayout);
        jPanelColLayout.setHorizontalGroup(
            jPanelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelColLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelColLayout.createSequentialGroup()
                        .addGroup(jPanelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelColLayout.createSequentialGroup()
                                .addComponent(colBtnHolding, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colBtnGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelColLayout.createSequentialGroup()
                                .addComponent(colBtnDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colLbNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colTxtAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                    .addComponent(colBtnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelColLayout.setVerticalGroup(
            jPanelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelColLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(colBtnHolding, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(colBtnGuest))
                    .addComponent(colTxtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colBtnDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colLbNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colBtnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelColLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {colBtnGuest, colBtnHolding});

        jTabbedPane.addTab("Collaborator", jPanelCol);

        jPanelGuest.setBackground(new java.awt.Color(102, 102, 102));

        guTxtAccount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        guBtnDiscount.setBackground(new java.awt.Color(51, 255, 51));
        guBtnDiscount.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        guBtnDiscount.setForeground(new java.awt.Color(255, 255, 255));
        guBtnDiscount.setText("Discount");

        guBtnNotification.setBackground(new java.awt.Color(255, 0, 0));
        guBtnNotification.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        guBtnNotification.setForeground(new java.awt.Color(255, 255, 255));
        guBtnNotification.setText("Notification");

        guBtnViewAllRoom.setBackground(new java.awt.Color(51, 102, 255));
        guBtnViewAllRoom.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        guBtnViewAllRoom.setForeground(new java.awt.Color(255, 255, 255));
        guBtnViewAllRoom.setText("View all apartment");

        guBtnFeedback.setBackground(new java.awt.Color(0, 204, 204));
        guBtnFeedback.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        guBtnFeedback.setForeground(new java.awt.Color(255, 255, 255));
        guBtnFeedback.setText("Feedback");

        javax.swing.GroupLayout jPanelGuestLayout = new javax.swing.GroupLayout(jPanelGuest);
        jPanelGuest.setLayout(jPanelGuestLayout);
        jPanelGuestLayout.setHorizontalGroup(
            jPanelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGuestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guBtnFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelGuestLayout.createSequentialGroup()
                        .addGroup(jPanelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(guBtnViewAllRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelGuestLayout.createSequentialGroup()
                                .addComponent(guBtnDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(guBtnNotification, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(guTxtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelGuestLayout.setVerticalGroup(
            jPanelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGuestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(guBtnDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(guBtnNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(guTxtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guBtnViewAllRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(guBtnFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Guest", jPanelGuest);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 451, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseClicked
        if (JOptionPane.showConfirmDialog(new JFrame(),
                "Do you want to quit this application ?", "",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_lbCloseMouseClicked

    private void lbMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lbMinMouseClicked

    private void btnCollaboratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCollaboratorActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Duy.QuanlyCTV_2(continueAccount, continueType, conn, stmt).setVisible(true);
            }
        }
        );
        dispose();
    }//GEN-LAST:event_btnCollaboratorActionPerformed

    private void btnHoldingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoldingActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                objUIHolding = new uiHolding_2(continueAccount, continueType, conn, stmt);
                objUIHolding.setVisible(true);
            }
        }
        );
        dispose();
    }//GEN-LAST:event_btnHoldingActionPerformed

    private void colBtnHoldingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colBtnHoldingActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //objHolding = new uiHolding_2(connection, stmt);
                //objHolding.setVisible(true);
            }
        }
        );
        dispose();
    }//GEN-LAST:event_colBtnHoldingActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicesActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //new Tuyet_Duyen.Services_2(con, stmt).setVisible(true);
                objService = new Services_2(continueAccount, continueType, conn, stmt);
                objService.setVisible(true);
            }
        }
        );
        dispose();
    }//GEN-LAST:event_btnServicesActionPerformed

    private void btnGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuestActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //new Tuyet_Duyen.Theme_guest_2(con, stmt).setVisible(true);
                objThemeGuest = new Theme_guest_2(continueAccount, continueType, conn, stmt);
                objThemeGuest.setVisible(true);
            }
        }
        );
        dispose();
    }//GEN-LAST:event_btnGuestActionPerformed

    private void colTxtAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colTxtAccountMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                accDialog = new Account(new javax.swing.JFrame(), true, continueAccount, continueType, conn, stmt);
                accDialog.setVisible(true);
                accDialog.getContentPane().add(new JLabel(new Date().toString()));
                accDialog.pack();
                Point point = colTxtAccount.getLocationOnScreen();
                accDialog.setLocation(new Point(point.x, point.y + colTxtAccount.getHeight()));
                accDialog.setVisible(true);
                accDialog.setSize(colTxtAccount.getWidth(), 222);
            }
        });
    }//GEN-LAST:event_colTxtAccountMouseClicked

    private void colBtnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colBtnCreateActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm(continueAccount, continueType, conn, stmt, "main").setVisible(true);
            }
        }
        );
        dispose();
    }//GEN-LAST:event_colBtnCreateActionPerformed

    private void btnNotificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificationActionPerformed
        // TODO add your handling code here:
        notiAd = new NotificationAdmin(this, true, continueAccount, continueType, conn, stmt);
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                notiAd.show();
            }
        }        
        );
    }//GEN-LAST:event_btnNotificationActionPerformed

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
//            java.util.logging.Logger.getLogger(MainControlInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainControlInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainControlInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainControlInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainControlInterface().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCollaborator;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDiscount;
    private javax.swing.JButton btnGuest;
    private javax.swing.JButton btnHolding;
    private javax.swing.JButton btnNotification;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnServices;
    private javax.swing.JButton colBtnCreate;
    private javax.swing.JButton colBtnDiscount;
    private javax.swing.JButton colBtnGuest;
    private javax.swing.JButton colBtnHolding;
    private javax.swing.JButton colLbNotification;
    private javax.swing.JTextField colTxtAccount;
    private javax.swing.JButton guBtnDiscount;
    private javax.swing.JButton guBtnFeedback;
    private javax.swing.JButton guBtnNotification;
    private javax.swing.JButton guBtnViewAllRoom;
    private javax.swing.JTextField guTxtAccount;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAdmin;
    private javax.swing.JPanel jPanelCol;
    private javax.swing.JPanel jPanelGuest;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JLabel lbClose;
    private javax.swing.JLabel lbMain;
    private javax.swing.JLabel lbMin;
    private javax.swing.JTextField txtAccount;
    // End of variables declaration//GEN-END:variables
}
