/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.io.Serializable;

/**
 *
 * @author Dat ThinkPad
 */
//khai báo class tương tự như String
public class StringListener implements getIDFromFrame
{
    private String strData;

    public StringListener(String strData)
    {
        this.strData = strData;
    }

    public String getStrData() 
    {
        return strData;
    }

    public void setStrData(String strData) 
    {
        this.strData = strData;
    }

    @Override
    public void receiveData(String data) 
    {
        this.strData = data;
        System.out.println(strData);
    }
    
    
}
