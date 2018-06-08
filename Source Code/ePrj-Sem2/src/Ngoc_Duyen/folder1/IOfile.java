/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ngoc_Duyen.folder1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.List;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class IOfile {
    public void write(List list, String fileName)
    {
        try (FileOutputStream fos = new FileOutputStream(new File(fileName))){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (Exception e) {
            System.out.println("  ");
        }
    }
    
    public ArrayList read(String fileName)
    {
        ArrayList<NewInterface> list = new ArrayList();
        try (FileInputStream fos = new FileInputStream(new File(fileName))){
            ObjectInputStream oos = new ObjectInputStream(fos);
            list = (ArrayList<NewInterface>) oos.readObject();
        } catch (Exception e) {
            System.out.println("  ");
        }
        return list;
    }

    public void write(ArrayList<NewInterface> Apartment, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
