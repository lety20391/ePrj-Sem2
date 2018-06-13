/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

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
        JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void validateTextField()
    {
        if (!Pattern.matches(patStr, this.getText()))
        {
            showError();
        }
    }
    
    public String allValidate()
    {
        if (!Pattern.matches(patStr, this.getText()))
        {
            return error;
        }else
        {
            return "";
        }
    }
}
