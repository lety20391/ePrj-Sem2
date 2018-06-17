/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Dat ThinkPad
 */
public class G2TextField extends JTextField {
    String patStr;
    String init;
    String error;
    boolean checkError = false;
    Color tempColor;
    String finalError;

    public String getFinalError() {
        return finalError;
    }

    public void setFinalError(String finalError) {
        this.finalError = finalError;
    }
    public G2TextField()
    {
        super();
        initListener();
        tempColor = this.getBackground();
    }

    public String getPatStr() {
        return patStr;
    }

    public String getInit() {
        return init;
    }

    public String getError() {
        return error;
    }

    public void setPatStr(String patStr) {
        this.patStr = patStr;
    }

    public void setInit(String init) {
        this.init = init;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    public void initData()
    {
        this.setText(init);
    }
    
    public String returnError()
    {
        return error;
    }
    
    public void showError()
    {
        JOptionPane.showMessageDialog(this, finalError, "Error", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void validateTextField()
    {
        tempColor = this.getBackground();
        if (!Pattern.matches(patStr, this.getText()))
        {
            checkError = true;
            this.setBackground(Color.red);
            finalError = "Your input: '" + this.getText() + error;
            showError();
        }
    }
    
    public String allValidate()
    {
        if (!Pattern.matches(patStr, this.getText()))
        {
            checkError = true;
            this.setBackground(Color.red);
            finalError = "Your input: '" + this.getText() + error;
            return finalError;
        }else
        {
            return "";
        }
    }
    
    public void initListener()
    {
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                returnOriginalBackground();
            }
            @Override
            public void mousePressed(MouseEvent e) {
                
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                returnOriginalBackground();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
    }
    
    public void returnOriginalBackground()
    {
        this.setBackground(tempColor);
    }
    
    @Override
    protected void paintComponent(java.awt.Graphics g)
    {
        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D)g.create();             
//        if (checkError == true)
//        {            
//            g2.setBackground(Color.red);
//            g2.dispose();
//        }        
        
    }
}
