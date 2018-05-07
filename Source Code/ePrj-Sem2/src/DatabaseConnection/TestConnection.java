/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;

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
        Connection objConnection;
        objConnection = objDBConnect.DBConnect("prj2Database", "sa", "abc123");
    }
    
}
