/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dat_Le;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Dat ThinkPad
 */
public class NewMain implements ActionListener{
    static TestPanel objTP;
    static ReceivePanel objRP;
    static JFrame objF, objF2;
    /**
     * @param args the command line arguments
     */
    public NewMain()
    {
        objTP = new TestPanel();         
        objRP = new ReceivePanel();
        objF  = new JFrame("Test Frame");
        objF2  = new JFrame("Receive Frame");
    }
    public void createAndShowUI()
    {
        //create Frame to display TestPanel
        objTP.addListener(this);        
        objF.setSize(300, 300);
        objF.getContentPane().add(objTP);
        
        
        
        //create Frame to display ReceivePanel
        //create Frame to display TestPanel
        
        objF2.setSize(300, 300);
        objF2.getContentPane().add(objRP);
        
        objF.pack();
        objF.setVisible(true);
        objF2.pack();
        objF2.setVisible(true);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("1");
        objRP.setInput(objTP.getjTextField1().getText());
        objRP.change();
    }
    public static void main(String[] args) {
        
        //create thread to display Frame
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewMain().createAndShowUI();                
            }
        });
                              
    }

    
    
}
