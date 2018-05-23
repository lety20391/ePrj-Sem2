/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dat_Le;

import javax.swing.SwingUtilities;

/**
 *
 * @author Dat ThinkPad
 */
public class MainFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TestJFrame1 objFrame1 = new TestJFrame1();
        new Thread(new Runnable() {
        public void run() {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    objFrame1.setVisible(true);
                }
            });
            }
        }).start();
        String[] tempData = objFrame1.Send();
        objFrame1.dispose();
        //TestJFrame2 objFrame2 = new TestJFrame2(tempData);
    }
    
}
