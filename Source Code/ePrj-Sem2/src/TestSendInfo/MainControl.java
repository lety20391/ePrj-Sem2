/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSendInfo;

/**
 *
 * @author Dat ThinkPad
 */
public class MainControl {
    DataFrame objDataFrame;
    Thread objThread;
    
    public MainControl()
    {
        objDataFrame = new DataFrame();
    }
    
    public void initialFrame()
    {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                objDataFrame.setVisible(true);
//            }
//        });
          objThread = new Thread(objDataFrame, "Data Frame");
          objThread.start();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainControl objMainControl = new MainControl();
        objMainControl.initialFrame();
        
        
    }
    
}
