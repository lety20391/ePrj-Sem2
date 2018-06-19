/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.awt.Component;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Dat ThinkPad
 */
public class G2Panel extends JPanel
{
    HashMap<String, JButton> mapBtn;
    HashMap<String, Boolean> mapBaseRight;
    HashMap<String, Boolean> mapBtnStatus;
    String mainRight;
    G2Panel obj;
    Thread checkBtn;
    Boolean[] objListBtnStatus;
    Component[] objListComponents;
    
    public G2Panel()
    {
        super();
        mapBtn = new HashMap<String, JButton>();
        mapBaseRight = new HashMap<String, Boolean>();       
    }
    
    public void attachButtonAndSetMainRight(G2Panel obj, String mainRight)
    {
        this.obj = obj;
        objListComponents = obj.getComponents();
        System.out.println("Comp: " + objListComponents.length);
        int i = 0;
        for (Component objComp : objListComponents) {
            if (objComp instanceof JButton)
            {
                i++;
                JButton tempBtn = (JButton)objComp;
                mapBtn.put(tempBtn.getText().toLowerCase(),tempBtn);
            }
        }       
        saveCurrentBtnStatus();                
        setMainRight(mainRight);
    }
    
    public void returnBtnStatus()
    {
        for (Component objComp : objListComponents) 
        {
            if (objComp instanceof JButton)
            {
                JButton tempBtn = (JButton)objComp;
                boolean status = (boolean)mapBtnStatus.get(tempBtn.getText());
                tempBtn.setEnabled(status);                
            }
        }
    }
    
    public void saveCurrentBtnStatus()
    {
        //Component[] objListComp = obj.getComponents();
        mapBtnStatus = new HashMap<>();
        for (Component objComp : objListComponents) 
        {
            if (objComp instanceof JButton)
            {
                JButton tempBtn = (JButton)objComp;
                Boolean status = Boolean.FALSE;
                if (tempBtn.isEnabled())
                    status = Boolean.TRUE;
                mapBtnStatus.put(tempBtn.getText(), status);
            }
        }
    }
    
    public void checkButton()
    {
        //Component[] objListComp = obj.getComponents();
        boolean checkSaveButton = false;
        int mark = 0;        
        for (int i = 0; i < objListComponents.length; i++) 
        {
            if (objListComponents[i] instanceof JButton)
            {
                JButton tempBtn = (JButton)objListComponents[i];
                if (tempBtn.getText().equalsIgnoreCase("Save"))
                {
                        mark = i;
                        checkSaveButton = true;
                        //break;
                }
            }  
        }
        if (checkSaveButton == false)
                return;
        for (int i = 0; i < objListComponents.length; i++) 
        {
            if ((objListComponents[i] instanceof JButton) && i != mark)
            {
                ((JButton)objListComponents[i]).setEnabled(false);
            }  
        }
        checkSaveButton = false;
    }
    
    public void createThreadToCheckButton()
    {
        if (checkBtn == null)
        {
            checkBtn = new Thread()
            {
                public void run()
                {
                    try {
                        while (true)
                        {
                        checkButton();
                        checkBtn.sleep(4000);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    
                }
            };            
        }
        checkBtn.start();
        
    }
    
    public void setMainRight(String mainRight)
    {
        this.mainRight = mainRight.toLowerCase(); 
        if (mainRight.equalsIgnoreCase("ad"))
        {
            System.out.println("ad");
            mapBaseRight.put("add", Boolean.TRUE);
            mapBaseRight.put("update", Boolean.TRUE);
            mapBaseRight.put("delete", Boolean.TRUE);
        }else if(mainRight.equalsIgnoreCase("co"))
        {
            System.out.println("co");
            mapBaseRight.put("add", Boolean.TRUE);
            mapBaseRight.put("update", Boolean.TRUE);
            mapBaseRight.put("delete", Boolean.FALSE);
        }else if (mainRight.equalsIgnoreCase("gu"))
        {
            System.out.println("gu");
            mapBaseRight.put("add", Boolean.FALSE);
            mapBaseRight.put("update", Boolean.TRUE);
            mapBaseRight.put("delete", Boolean.FALSE);               
        }else{
            JOptionPane.showMessageDialog(this, "Invalid Account Type");
            return;
        }
        setBaseBtnStatus();
    }
    
    public void setBaseBtnStatus()
    {
        Iterator iteEntry = mapBtn.entrySet().iterator();
        while (iteEntry.hasNext())
        {
            HashMap.Entry objEntry = (HashMap.Entry)iteEntry.next();
            String key = ((String)objEntry.getKey()).toLowerCase();
            JButton btn = (JButton)objEntry.getValue();
            if (mapBaseRight.containsKey(key))
            {   System.out.println("key");
                System.out.println(mapBaseRight.get(key).booleanValue());
                btn.setEnabled(mapBaseRight.get(key).booleanValue()); 
            }
        }
    }
    
}
