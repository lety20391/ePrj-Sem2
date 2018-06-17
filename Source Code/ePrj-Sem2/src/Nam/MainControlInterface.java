/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nam;

import Dat_Le_2.uiContract_2;
import Dat_Le_2.uiHolding_2;
import Tuyet_Duyen.Services_2;
import Tuyet_Duyen.Theme_guest_2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Namcham
 */
public class MainControlInterface extends javax.swing.JFrame implements ActionListener {

    Connection conn;
    Statement stmt;
    ResultSet rs;
    String sql;

    String continueAccount, continueType;
    int count = 0;

    //phan dat ten cac variable cho tung Frame
    Dat_Le_2.uiHolding_2 objUIHolding;
    Dat_Le_2.uiContract_2 objUIContract;
    Duy.QuanlyCTV_2 objCTV;
    Duy.QuanlyOwner_2 objOwner;
    Tuyet_Duyen.Services_2 objService;
    Tuyet_Duyen.Theme_guest_2 objThemeGuest;
    NotificationFormToCol accDialog;
    NotificationAdmin notiAd;
    
    String IDGu, IDCo, IDApa, IDSup, IDSer, IDHo,IDCon;

    public String getIDGu() {
        return IDGu;
    }

    public String getIDCo() {
        return IDCo;
    }

    public String getIDApa() {
        return IDApa;
    }

    public String getIDSup() {
        return IDSup;
    }

    public String getIDSer() {
        return IDSer;
    }

    public String getIDHo() {
        return IDHo;
    }

    public String getIDCon() {
        return IDCon;
    }

    public void setIDHo(String IDHo) {
        this.IDHo = IDHo;
    }

    public void setIDCon(String IDCon) {
        this.IDCon = IDCon;
    }

    public void setIDGu(String IDGu) {
        this.IDGu = IDGu;
    }

    public void setIDCo(String IDCo) {
        this.IDCo = IDCo;
    }

    public void setIDApa(String IDApa) {
        this.IDApa = IDApa;
    }

    public void setIDSup(String IDSup) {
        this.IDSup = IDSup;
    }

    public void setIDSer(String IDSer) {
        this.IDSer = IDSer;
    }

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
        txtAccount.setEditable(false);
        colTxtAccount.setText(account);
        colTxtAccount.setEditable(false);
        guTxtAccount.setText(account);
        guTxtAccount.setEditable(false);
        setLocationRelativeTo(null);
        load();
        txtCoDeposit.setEditable(false);
        txtCoGrade.setEditable(false);
        txtCoName.setEditable(false);
        txtCoNumberOfGuest.setEditable(false);
        txtNotification.setEditable(false);
        txtCoLogout.setEditable(false);
        pack();
        initData();
    }
    
    private void initData()
    {
        IDGu ="";
        IDCo="";
        IDApa="";
        IDSup="";
        IDSer="";
        IDHo = "";
        IDCon = "";
    }

    private void load() {
        if (continueType.equals("ad")) {
            jTabbedPane.remove(jPanelCol);
            jTabbedPane.remove(jPanelGuest);
        }
        if (continueType.equals("co")) {
            jTabbedPane.remove(jPanelAdmin);
            jTabbedPane.remove(jPanelGuest);
            loadCol();
        }
        if (continueType.equals("gu")) {
            jTabbedPane.remove(jPanelAdmin);
            jTabbedPane.remove(jPanelCol);
        }
    }

    public void loadCol() {
        int countNoti = 0;
        sql = "select * from Collaborator where IDCo = '" + colTxtAccount.getText() + "'";
        try {
            rs = stmt.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                txtCoDeposit.setText("Deposit: " + String.valueOf(rs.getDouble("DepositCo")));
                txtCoGrade.setText("Grade: " + rs.getString("GradeCo"));
                txtCoNumberOfGuest.setText("Number of guests: " + rs.getInt("NumberOfGuest"));
                txtCoName.setText("" + rs.getString("NameCo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotificationFormToCol.class.getName()).log(Level.SEVERE, null, ex);
        }

        sql = "select * from " + continueAccount + " where Status = 'unread' order by Status";
        try {
            rs = stmt.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                countNoti++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotificationFormToCol.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtNotification.setText("Notification: " + countNoti);
        txtCoLogout.setText("Logout");
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
        btnCollaborator = new javax.swing.JButton();
        btnGuest = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnServices = new javax.swing.JButton();
        btnOwners = new javax.swing.JButton();
        btnContract = new javax.swing.JButton();
        btnApartment = new javax.swing.JButton();
        jPanelCol = new javax.swing.JPanel();
        colBtnHolding = new javax.swing.JButton();
        colBtnGuest = new javax.swing.JButton();
        colTxtAccount = new javax.swing.JTextField();
        colBtnCreate = new javax.swing.JButton();
        txtCoName = new javax.swing.JTextField();
        txtCoNumberOfGuest = new javax.swing.JTextField();
        txtCoDeposit = new javax.swing.JTextField();
        txtCoGrade = new javax.swing.JTextField();
        txtNotification = new javax.swing.JTextField();
        txtCoLogout = new javax.swing.JTextField();
        colBtnViewApartment = new javax.swing.JButton();
        jPanelGuest = new javax.swing.JPanel();
        guTxtAccount = new javax.swing.JTextField();
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

        btnCollaborator.setBackground(new java.awt.Color(51, 51, 255));
        btnCollaborator.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        btnCollaborator.setForeground(new java.awt.Color(255, 255, 255));
        btnCollaborator.setText("Collaborators");
        btnCollaborator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCollaboratorActionPerformed(evt);
            }
        });

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

        btnOwners.setBackground(new java.awt.Color(0, 204, 51));
        btnOwners.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        btnOwners.setForeground(new java.awt.Color(255, 255, 255));
        btnOwners.setText("Owners");
        btnOwners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOwnersActionPerformed(evt);
            }
        });

        btnContract.setBackground(new java.awt.Color(153, 102, 255));
        btnContract.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        btnContract.setForeground(new java.awt.Color(255, 255, 255));
        btnContract.setText("Contracts");
        btnContract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContractActionPerformed(evt);
            }
        });

        btnApartment.setBackground(new java.awt.Color(102, 102, 255));
        btnApartment.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        btnApartment.setForeground(new java.awt.Color(255, 255, 255));
        btnApartment.setText("Apartment");
        btnApartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApartmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAdminLayout = new javax.swing.GroupLayout(jPanelAdmin);
        jPanelAdmin.setLayout(jPanelAdminLayout);
        jPanelAdminLayout.setHorizontalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addComponent(btnNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHolding, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCreate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(btnCollaborator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnApartment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAccount)
                    .addComponent(btnServices, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(btnOwners, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(btnContract, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelAdminLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHolding, btnNotification});

        jPanelAdminLayout.setVerticalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addComponent(txtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnServices, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHolding, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCollaborator, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnContract, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addComponent(btnApartment, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnOwners, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        colBtnGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colBtnGuestActionPerformed(evt);
            }
        });

        colTxtAccount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        colBtnCreate.setBackground(new java.awt.Color(153, 0, 153));
        colBtnCreate.setFont(new java.awt.Font("Tahoma", 1, 33)); // NOI18N
        colBtnCreate.setForeground(new java.awt.Color(255, 255, 255));
        colBtnCreate.setText("Create new Account");
        colBtnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colBtnCreateActionPerformed(evt);
            }
        });

        txtCoName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtCoNumberOfGuest.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtCoDeposit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtCoGrade.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtNotification.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtNotification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNotificationMouseClicked(evt);
            }
        });

        txtCoLogout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCoLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCoLogoutMouseClicked(evt);
            }
        });

        colBtnViewApartment.setBackground(new java.awt.Color(153, 0, 153));
        colBtnViewApartment.setFont(new java.awt.Font("Tahoma", 1, 33)); // NOI18N
        colBtnViewApartment.setForeground(new java.awt.Color(255, 255, 255));
        colBtnViewApartment.setText("View All Apartment");
        colBtnViewApartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colBtnViewApartmentActionPerformed(evt);
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
                        .addComponent(colBtnCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(colBtnViewApartment))
                    .addGroup(jPanelColLayout.createSequentialGroup()
                        .addGroup(jPanelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(colBtnGuest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(colBtnHolding, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(colTxtAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(txtCoName, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(txtCoNumberOfGuest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(txtCoDeposit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(txtCoGrade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(txtNotification, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(txtCoLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanelColLayout.setVerticalGroup(
            jPanelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelColLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelColLayout.createSequentialGroup()
                        .addComponent(colBtnHolding, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(colBtnGuest))
                    .addGroup(jPanelColLayout.createSequentialGroup()
                        .addComponent(colTxtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCoName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(txtCoNumberOfGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCoDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCoGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCoLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanelColLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colBtnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colBtnViewApartment, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelColLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {colBtnGuest, colBtnHolding});

        jTabbedPane.addTab("Collaborator", jPanelCol);

        jPanelGuest.setBackground(new java.awt.Color(102, 102, 102));

        guTxtAccount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        guBtnViewAllRoom.setBackground(new java.awt.Color(51, 102, 255));
        guBtnViewAllRoom.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        guBtnViewAllRoom.setForeground(new java.awt.Color(255, 255, 255));
        guBtnViewAllRoom.setText("View all apartment");
        guBtnViewAllRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guBtnViewAllRoomActionPerformed(evt);
            }
        });

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
                    .addComponent(guBtnViewAllRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanelGuestLayout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(guTxtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(281, Short.MAX_VALUE))
        );
        jPanelGuestLayout.setVerticalGroup(
            jPanelGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGuestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(guTxtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
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
                invokeQuanlyCTV();
            }
        }
        );
    }//GEN-LAST:event_btnCollaboratorActionPerformed

    private void invokeQuanlyCTV()
    {
        objCTV = new Duy.QuanlyCTV_2(continueAccount, continueType, conn, stmt, this);
        objCTV.setVisible(true);
    }
    
    private void btnHoldingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoldingActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() {
                invokeUIHolding();
            }
        }
        );
        dispose();
    }//GEN-LAST:event_btnHoldingActionPerformed

    private void colBtnHoldingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colBtnHoldingActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                invokeUIHolding();
            }
        }
        );
        dispose();
    }//GEN-LAST:event_colBtnHoldingActionPerformed

    public void invokeUIHolding()
    {
        objUIHolding = new uiHolding_2(continueAccount, continueType, conn, stmt, this);
        objUIHolding.setVisible(true);
    }
    
    
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                new RegisterForm(continueAccount, continueType, conn, stmt, "main").setVisible(true);
            }
        }
        );
        dispose();

    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicesActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //new Tuyet_Duyen.Services_2(con, stmt).setVisible(true);
                invokeServiceFrame();
            }
        }
        );
    }//GEN-LAST:event_btnServicesActionPerformed

    private void invokeServiceFrame()
    {
        objService = new Services_2(continueAccount, continueType, conn, stmt, this);
        objService.setVisible(true);
    }
    
    private void btnGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuestActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                invokeThemeGuest2();
            }
        }        
        );
    }//GEN-LAST:event_btnGuestActionPerformed

    private void colBtnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colBtnCreateActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm(continueAccount, continueType, conn, stmt, "main").setVisible(true);
            }
        }
        );
    }//GEN-LAST:event_colBtnCreateActionPerformed

    private void btnNotificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificationActionPerformed
        // TODO add your handling code here:
        notiAd = new NotificationAdmin(this, true, continueAccount, continueType, conn, stmt);
        notiAd.setVisible(true);
    }//GEN-LAST:event_btnNotificationActionPerformed

    private void btnOwnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOwnersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOwnersActionPerformed

    private void txtCoLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCoLogoutMouseClicked
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(new JFrame(),
                "Do you want to quit this application ?", "",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_txtCoLogoutMouseClicked

    private void txtNotificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNotificationMouseClicked
        // TODO add your handling code here:
        new NotificationFormToCol(this, true, continueAccount, continueType, conn, stmt, this).setVisible(true);
    }//GEN-LAST:event_txtNotificationMouseClicked

    private void colBtnGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colBtnGuestActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                invokeThemeGuest2();
            }
        }        
        );
    }//GEN-LAST:event_colBtnGuestActionPerformed

    public void invokeThemeGuest2()
    {
        objThemeGuest = new Theme_guest_2(continueAccount, continueType, conn, stmt, this);
        objThemeGuest.setVisible(true);
    }
    
    private void btnContractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContractActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                invokeContract();
            }
        }
        );
    }//GEN-LAST:event_btnContractActionPerformed

    private void btnApartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApartmentActionPerformed
        // TODO add your handling code here:
        new Ngoc_Duyen.QLCH.QLCH1(continueAccount, continueType, conn, stmt).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnApartmentActionPerformed

    private void colBtnViewApartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colBtnViewApartmentActionPerformed
        // TODO add your handling code here:
        new ViewAllApartmentGu(this, true, continueAccount, continueType, conn, stmt).setVisible(true);
    }//GEN-LAST:event_colBtnViewApartmentActionPerformed

    private void guBtnViewAllRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guBtnViewAllRoomActionPerformed
        // TODO add your handling code here:
        new ViewAllApartmentGu(this, true, continueAccount, continueType, conn, stmt).setVisible(true);
    }//GEN-LAST:event_guBtnViewAllRoomActionPerformed

    public void invokeContract()
    {
        objUIContract = new uiContract_2(continueAccount, continueType, conn, stmt, this);
        objUIContract.setVisible(true);
    }
    
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
    private javax.swing.JButton btnApartment;
    private javax.swing.JButton btnCollaborator;
    private javax.swing.JButton btnContract;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnGuest;
    private javax.swing.JButton btnHolding;
    private javax.swing.JButton btnNotification;
    private javax.swing.JButton btnOwners;
    private javax.swing.JButton btnServices;
    private javax.swing.JButton colBtnCreate;
    private javax.swing.JButton colBtnGuest;
    private javax.swing.JButton colBtnHolding;
    private javax.swing.JButton colBtnViewApartment;
    private javax.swing.JTextField colTxtAccount;
    private javax.swing.JButton guBtnFeedback;
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
    private javax.swing.JTextField txtCoDeposit;
    private javax.swing.JTextField txtCoGrade;
    private javax.swing.JTextField txtCoLogout;
    private javax.swing.JTextField txtCoName;
    private javax.swing.JTextField txtCoNumberOfGuest;
    private javax.swing.JTextField txtNotification;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
