/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nam;

import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Namcham
 */
public class MainControlInterface extends javax.swing.JFrame {

    AccountInfo Ai;
    RegisterForm Rf;

    /**
     * Creates new form MainControlInterface
     */
    public MainControlInterface() {
        initComponents();
        this.setLocationRelativeTo(null);
        Ai = new AccountInfo();

    }

    public void setTxtAccount(String a) {
        txtAccount.setText(a);
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
        jPanel2 = new javax.swing.JPanel();
        btnNotification = new javax.swing.JButton();
        txtAccount = new javax.swing.JTextField();
        btnBooking = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnDiscount = new javax.swing.JButton();
        btnCreateNewAccount = new javax.swing.JButton();
        btnCollaborators = new javax.swing.JButton();
        btnClient = new javax.swing.JButton();
        btnService = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setType(java.awt.Window.Type.POPUP);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        lbRegister.setBackground(new java.awt.Color(255, 153, 0));
        lbRegister.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbRegister.setForeground(new java.awt.Color(255, 255, 255));
        lbRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRegister.setText("Main Control System");

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
                .addComponent(lbRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
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

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        btnNotification.setBackground(new java.awt.Color(255, 0, 255));
        btnNotification.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        btnNotification.setForeground(new java.awt.Color(255, 255, 255));
        btnNotification.setText("Notification");
        btnNotification.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNotification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNotificationMouseClicked(evt);
            }
        });

        txtAccount.setEditable(false);
        txtAccount.setBackground(new java.awt.Color(102, 102, 102));
        txtAccount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtAccount.setForeground(new java.awt.Color(255, 255, 255));
        txtAccount.setSelectionColor(new java.awt.Color(102, 102, 102));
        txtAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAccountMouseClicked(evt);
            }
        });

        btnBooking.setBackground(new java.awt.Color(255, 0, 51));
        btnBooking.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        btnBooking.setForeground(new java.awt.Color(255, 255, 255));
        btnBooking.setText("Booking");
        btnBooking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBookingMouseClicked(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 153, 153));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        btnDiscount.setBackground(new java.awt.Color(255, 255, 0));
        btnDiscount.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        btnDiscount.setForeground(new java.awt.Color(255, 255, 255));
        btnDiscount.setText("Discount");
        btnDiscount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDiscountMouseClicked(evt);
            }
        });

        btnCreateNewAccount.setBackground(new java.awt.Color(102, 0, 102));
        btnCreateNewAccount.setFont(new java.awt.Font("Tahoma", 1, 45)); // NOI18N
        btnCreateNewAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateNewAccount.setText("Create new account");
        btnCreateNewAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateNewAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateNewAccountMouseClicked(evt);
            }
        });

        btnCollaborators.setBackground(new java.awt.Color(51, 255, 51));
        btnCollaborators.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        btnCollaborators.setForeground(new java.awt.Color(255, 255, 255));
        btnCollaborators.setText("Collaborators");
        btnCollaborators.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCollaborators.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCollaboratorsMouseClicked(evt);
            }
        });

        btnClient.setBackground(new java.awt.Color(255, 51, 0));
        btnClient.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        btnClient.setForeground(new java.awt.Color(255, 255, 255));
        btnClient.setText("Clients");
        btnClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClientMouseClicked(evt);
            }
        });

        btnService.setBackground(new java.awt.Color(255, 102, 102));
        btnService.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        btnService.setForeground(new java.awt.Color(255, 255, 255));
        btnService.setText("Services");
        btnService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnServiceMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCreateNewAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCollaborators, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClient, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnService, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClient)
                    .addComponent(btnCollaborators, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateNewAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnService, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBooking, btnNotification});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClient, btnCollaborators, btnDiscount});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMinMouseClicked
        this.setState(JFrame.ICONIFIED);
        Ai.dispose();
    }//GEN-LAST:event_lbMinMouseClicked

    private void lbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseClicked
        if (JOptionPane.showConfirmDialog(new JFrame(),
                "Do you want to quit this application ?", "",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_lbCloseMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        Ai.dispose();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        Ai.dispose();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void txtAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAccountMouseClicked
        if (Ai.isVisible()) {
            Ai.dispose();
        } else {
            Point p = txtAccount.getLocationOnScreen();
            Ai.setLocation(new Point(p.x, p.y + txtAccount.getHeight() + 6));
            Ai.setSize(txtAccount.getWidth(), 138);
            Ai.pack();
            Ai.setVisible(true);
        }
    }//GEN-LAST:event_txtAccountMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Ai.dispose();
    }//GEN-LAST:event_formMouseDragged

    private void btnCreateNewAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateNewAccountMouseClicked
        Ai.dispose();
        Rf = new RegisterForm();
        Rf.setVisible(true);
        setVisible(false);

    }//GEN-LAST:event_btnCreateNewAccountMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        Ai.dispose();
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnBookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBookingMouseClicked
        Ai.dispose();
    }//GEN-LAST:event_btnBookingMouseClicked

    private void btnNotificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotificationMouseClicked
        Ai.dispose();
    }//GEN-LAST:event_btnNotificationMouseClicked

    private void btnDiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDiscountMouseClicked
        Ai.dispose();
    }//GEN-LAST:event_btnDiscountMouseClicked

    private void btnCollaboratorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCollaboratorsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCollaboratorsMouseClicked

    private void btnClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClientMouseClicked

    private void btnServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiceMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnServiceMouseClicked

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
            java.util.logging.Logger.getLogger(MainControlInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainControlInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainControlInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainControlInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainControlInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBooking;
    private javax.swing.JButton btnClient;
    private javax.swing.JButton btnCollaborators;
    private javax.swing.JButton btnCreateNewAccount;
    private javax.swing.JButton btnDiscount;
    private javax.swing.JButton btnNotification;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnService;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbClose;
    private javax.swing.JLabel lbMin;
    private javax.swing.JLabel lbRegister;
    private javax.swing.JTextField txtAccount;
    // End of variables declaration//GEN-END:variables
}
