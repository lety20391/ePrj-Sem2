/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nam;

import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Namcham
 */
public class ViewAllApartmentGu extends javax.swing.JDialog {

    Connection conn;
    Statement stmt;
    ResultSet rs;
    String sql;
    DefaultTableModel ColModel;
    Vector header, data, row;
    
    String continueAccount, continueType;
    
    String iDApa, nameApa, infoApa, addressApa, imageApa, idSup, statusApa;
    double priceApa;

    /**
     * Creates new form ViewAllApartmentGu
     */
    public ViewAllApartmentGu(java.awt.Frame parent, boolean modal, String account, String type, Connection connection, Statement statement) {
        super(parent, modal);
        initComponents();
        
        continueAccount = account;
        continueType = type;
        conn = connection;
        stmt = statement;
        if (continueType.equalsIgnoreCase("gu")||continueType.equalsIgnoreCase("co")) {
            txtSupApa.setVisible(false);
            lbIDApa6.setVisible(false);
        }
        setLocationRelativeTo(parent);
        setTextOnOff(false);
        pack();
    }

    public void load() {
        ColModel = new DefaultTableModel();
        header = new Vector();
        header.add("ID");
        header.add("Name");
        header.add("Address");
        header.add("Info");
        header.add("Status");
        header.add("Price");

        data = new Vector();
        ColModel.setRowCount(0);
        
        sql = "select * from Apartment";
        try {
            rs = stmt.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                row = new Vector();
                row.add(rs.getString("IDApa"));
                row.add(rs.getString("NameApa"));
                row.add(rs.getString("AddressApa"));
                row.add(rs.getDouble("InfoApa"));
                row.add(rs.getString("StatusApa"));
                row.add(rs.getDouble("PriceApa"));

                data.add(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotificationAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ColModel.setDataVector(data, header);
        tbApa.setModel(ColModel);
    }
    
    private void setTextOnOff(boolean check) {
        txtIDApa.setEditable(check);
        txtAddressApa.setEditable(check);
        txtInfoApa.setEditable(check);
        txtNameApa.setEditable(check);
        txtPriceApa.setEditable(check);
        txtSupApa.setEditable(check);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbApa = new javax.swing.JTable();
        lbIDApa = new javax.swing.JLabel();
        lbImageApartment = new javax.swing.JLabel();
        lbNameApa = new javax.swing.JLabel();
        lbIDApa2 = new javax.swing.JLabel();
        lbIDApa3 = new javax.swing.JLabel();
        lbIDApa4 = new javax.swing.JLabel();
        lbIDApa5 = new javax.swing.JLabel();
        lbIDApa6 = new javax.swing.JLabel();
        txtIDApa = new javax.swing.JTextField();
        txtNameApa = new javax.swing.JTextField();
        txtAddressApa = new javax.swing.JTextField();
        txtInfoApa = new javax.swing.JTextField();
        rbYes = new javax.swing.JRadioButton();
        rbNo = new javax.swing.JRadioButton();
        txtSupApa = new javax.swing.JTextField();
        txtPriceApa = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        tbApa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbApa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbApaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbApa);

        lbIDApa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbIDApa.setText("ID");

        lbImageApartment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        lbNameApa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbNameApa.setText("Name");

        lbIDApa2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbIDApa2.setText("Address");

        lbIDApa3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbIDApa3.setText("Infomation");

        lbIDApa4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbIDApa4.setText("Available");

        lbIDApa5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbIDApa5.setText("Price/day");

        lbIDApa6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbIDApa6.setText("ID Supplier");

        txtIDApa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtNameApa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtAddressApa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtInfoApa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        buttonGroup1.add(rbYes);
        rbYes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rbYes.setText("Yes");

        buttonGroup1.add(rbNo);
        rbNo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rbNo.setText("No");

        txtSupApa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtPriceApa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIDApa6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSupApa, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIDApa, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIDApa, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbNameApa, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNameApa, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIDApa2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAddressApa, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIDApa3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtInfoApa, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIDApa4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(rbYes, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbNo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIDApa5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPriceApa, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(lbImageApartment, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbIDApa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIDApa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNameApa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNameApa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbIDApa2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddressApa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbIDApa3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtInfoApa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbIDApa4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbYes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbNo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbIDApa5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPriceApa))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbIDApa6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSupApa)))
                    .addComponent(lbImageApartment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbApaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbApaMouseClicked
        // TODO add your handling code here:
        int selectedRow;
        selectedRow = tbApa.getSelectedRow();
        iDApa = (String) tbApa.getValueAt(selectedRow, 0);
        nameApa = (String) tbApa.getValueAt(selectedRow, 1);
        addressApa = (String) tbApa.getValueAt(selectedRow, 2);
        infoApa = (String) tbApa.getValueAt(selectedRow, 3);
        statusApa = (String) tbApa.getValueAt(selectedRow, 4);
        priceApa = (Double) tbApa.getValueAt(selectedRow, 5);
        
        txtIDApa.setText(iDApa);
        txtNameApa.setText(nameApa);
        txtAddressApa.setText(addressApa);
        txtInfoApa.setText(infoApa);
        if (statusApa.equalsIgnoreCase("available")) {
            rbYes.isSelected();
        }else{
            rbNo.isSelected();
        }
        
        sql = "select * from Apartment where IDApa = '"+iDApa+"'";
        try {
            rs = stmt.executeQuery(sql);
            rs.beforeFirst();
            while (rs.next()) {
                imageApa = rs.getString("ImageApa");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllApartmentGu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ImageIcon icon = new ImageIcon(imageApa);
        int width = lbImageApartment.getWidth();
        int height = lbImageApartment.getHeight();
        int icoWidth = icon.getIconWidth();
        int icoHeight = icon.getIconHeight();
        Image image;
        if (icoWidth / icoHeight >= width / height) {
            image = icon.getImage().getScaledInstance(width, icoHeight * width / icoWidth, Image.SCALE_SMOOTH);
        } else {
            image = icon.getImage().getScaledInstance(icoWidth * height / icoHeight, height, Image.SCALE_SMOOTH);
        }

        lbImageApartment.setIcon(new ImageIcon(image));
    }//GEN-LAST:event_tbApaMouseClicked

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

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
//            java.util.logging.Logger.getLogger(ViewAllApartmentGu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewAllApartmentGu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewAllApartmentGu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewAllApartmentGu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ViewAllApartmentGu dialog = new ViewAllApartmentGu(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnClose;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbIDApa;
    private javax.swing.JLabel lbIDApa2;
    private javax.swing.JLabel lbIDApa3;
    private javax.swing.JLabel lbIDApa4;
    private javax.swing.JLabel lbIDApa5;
    private javax.swing.JLabel lbIDApa6;
    private javax.swing.JLabel lbImageApartment;
    private javax.swing.JLabel lbNameApa;
    private javax.swing.JRadioButton rbNo;
    private javax.swing.JRadioButton rbYes;
    private javax.swing.JTable tbApa;
    private javax.swing.JTextField txtAddressApa;
    private javax.swing.JTextField txtIDApa;
    private javax.swing.JTextField txtInfoApa;
    private javax.swing.JTextField txtNameApa;
    private javax.swing.JTextField txtPriceApa;
    private javax.swing.JTextField txtSupApa;
    // End of variables declaration//GEN-END:variables
}
