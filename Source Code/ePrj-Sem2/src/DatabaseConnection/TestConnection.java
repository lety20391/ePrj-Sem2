/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Dat ThinkPad
 */
public class TestConnection {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        DatabaseConnect objDBConnect;
        objDBConnect = new DatabaseConnect();
        connectionContainer connectContainer = objDBConnect.DBConnect("Sem2_project_group2", "sa", "abc123");
        
        Connection con = connectContainer.getObjCon();
        Statement stmt = connectContainer.getStatement();
        
        
        
        //Test List All Table
        objDBConnect.ListTable();
        objDBConnect.Close();
        
    }
    
}
