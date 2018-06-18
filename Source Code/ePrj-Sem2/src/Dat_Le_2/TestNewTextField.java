/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dat_Le_2;

import Library.G2TextField;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Dat ThinkPad
 */
public class TestNewTextField extends javax.swing.JFrame {

    /**
     * Creates new form TestNewTextField
     */
    public TestNewTextField() {
        initComponents();
        initDataForTxt2();
        initDataForTxt1();
    }
    
    public void initDataForTxt1()
    {
        txt1.setText("");
        txt1.setPatStr("\\d+");        
        txt1.setError("TextField1 bi loi chi chap nhan chu so 0-9 :v");
    }
    
    public void initDataForTxt2()
    {
        txt2.setPatStr("^(Ho)\\d+");
        txt2.setText("");
        txt2.setError("textfield 2 bi loi");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pTxt = new javax.swing.JPanel();
        txt1 = new Library.G2TextField();
        txt2 = new Library.G2TextField();
        btnTest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pTxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt1.setText("jTextField1");
        txt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt1MouseClicked(evt);
            }
        });

        txt2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt2.setText("jTextField1");

        btnTest.setText("Test");
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pTxtLayout = new javax.swing.GroupLayout(pTxt);
        pTxt.setLayout(pTxtLayout);
        pTxtLayout.setHorizontalGroup(
            pTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTxtLayout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addComponent(btnTest)
                .addGap(137, 137, 137))
            .addGroup(pTxtLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt1)
                    .addGroup(pTxtLayout.createSequentialGroup()
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pTxtLayout.setVerticalGroup(
            pTxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTxtLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnTest)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(pTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt1MouseClicked

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
        // TODO add your handling code here:
//        txt2.validateTextField();
//        txt1.validateTextField();
        Component[] objListComp = pTxt.getComponents();
        String allError = "";
        boolean error = false;
        for (Component objComp : objListComp) {
            if (objComp instanceof Library.G2TextField)
            {
                String temp = ((G2TextField) objComp).allValidate();
                System.out.println(temp);
                if (!temp.isEmpty())
                {
                    error = true;
                    allError += temp+ "\n";
                    //objComp.setBackground(Color.red);
                }
            }
        }
        if (error == true)
            JOptionPane.showMessageDialog(this, allError, "Bi loi", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnTestActionPerformed

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
            java.util.logging.Logger.getLogger(TestNewTextField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestNewTextField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestNewTextField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestNewTextField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestNewTextField().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTest;
    private javax.swing.JPanel pTxt;
    /*
    private javax.swing.JTextField txt1;
    */
    private Library.G2TextField txt1;
    /*
    private javax.swing.JTextField txt2;
    */
    private Library.G2TextField txt2;
    // End of variables declaration//GEN-END:variables
}
