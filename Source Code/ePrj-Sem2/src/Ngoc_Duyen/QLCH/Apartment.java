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
    private int ID , IDSup;
    private String Name , Address , Info , Status , Image;
    private Float Price;

    public int getIDSup() {
        return IDSup;
    }

    public void setIDSup(int IDSup) {
        this.IDSup = IDSup;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

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

//    public String getLocation() {
//        return Location;
//    }
//
//    public void setLocation(String Location) {
//        this.Location = Location;
//    }
//
//    public String getAmt() {
//        return Amt;
//    }
//
//    public void setAmt(String Amt) {
//        this.Amt = Amt;
//    }
//
//    public String getOwner() {
//        return Owner;
//    }
//
//    public void setOwner(String Owner) {
//        this.Owner = Owner;
//    }

    @Override
    public Object[] tooOjObjects() {
        return new Object[]
        {
            this.getID(), this.getName(), this.getAddress(), this.getImage(), this.getInfo(), this.getStatus(), this.getPrice(), this.getIDSup()
        };
    }

//    public void getOwner(String text) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
    
             
    
}
