/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.awt.Component;
import java.awt.Panel;
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
    String mainRight;
    
    public G2Panel()
    {
        super();
        mapBtn = new HashMap<String, JButton>();
        mapBaseRight = new HashMap<String, Boolean>();       
    }
    
    public void attachButtonAndSetMainRight(G2Panel obj, String mainRight)
    {
        Component[] objListComp = obj.getComponents();
        System.out.println("Comp: " + objListComp.length);
        for (Component objComp : objListComp) {
            if (objComp instanceof JButton)
            {
                JButton tempBtn = (JButton)objComp;
                mapBtn.put(tempBtn.getText().toLowerCase(),tempBtn);
            }
        }
        
        setMainRight(mainRight);
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
