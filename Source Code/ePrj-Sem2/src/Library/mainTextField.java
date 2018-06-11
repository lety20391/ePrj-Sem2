/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Dat ThinkPad
 */
public class mainTextField extends javax.swing.JTextField
{
    StringListener objStrListener;
    Object objThis;
    
//    public mainTextField(StringListener objStrListener)
//    {
//        this.objStrListener = objStrListener;
//    }
    
    public mainTextField()
    {
        objThis = this;
    }
    
    public void addStringListener(StringListener objStrListener)
    {
        this.objStrListener = objStrListener;
    }
    
    public void checkTextField()
    {
        
        this.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sendData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sendData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sendData();
            }
            
            public void sendData()
            {
                objStrListener.receiveData(((mainTextField)objThis).getText());
            }
        });
        
    }
}
