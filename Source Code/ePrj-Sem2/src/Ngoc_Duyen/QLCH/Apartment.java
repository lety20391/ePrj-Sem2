/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ngoc_Duyen.QLCH;

import Ngoc_Duyen.folder1.NewInterface;
import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class Apartment implements Serializable , NewInterface{
    private int ID;
    private String Name , Location , Amt , Owner;
    private Float Price;

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float Price) {
        this.Price = Price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getAmt() {
        return Amt;
    }

    public void setAmt(String Amt) {
        this.Amt = Amt;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String Owner) {
        this.Owner = Owner;
    }

    @Override
    public Object[] tooOjObjects() {
        return new Object[]
        {
            this.getID(), this.getName(), this.getLocation(), this.getAmt(), this.getOwner(), this.getPrice()
        };
    }

    public void getOwner(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
             
    
}
