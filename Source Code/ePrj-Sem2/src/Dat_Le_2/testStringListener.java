/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dat_Le_2;

import Library.StringListener;

/**
 *
 * @author Dat ThinkPad
 */
public class testStringListener {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StringListener objStrListen = new StringListener("");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                testMainTextField objTestMain = new testMainTextField();
                objTestMain.setVisible(true);
                objTestMain.addStringListen(objStrListen);
            }
        });
    }
    
}
