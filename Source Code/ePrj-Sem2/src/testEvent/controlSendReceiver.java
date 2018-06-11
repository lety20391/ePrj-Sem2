/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dat ThinkPad
 */
public class controlSendReceiver implements ActionListener{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ReceiverFrame objR = new ReceiverFrame();
        SwingUtilities.invokeLater(objR);
        SendData objS = new SendData();
        SwingUtilities.invokeLater(objS);
        objS.addReceiver(objR);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(objR);
    }
    
}
