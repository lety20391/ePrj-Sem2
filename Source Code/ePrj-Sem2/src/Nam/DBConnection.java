/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nam;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Namcham
 */
public class DBConnection {

    static Connection connection;

    public static Connection getDBConnection(String db, String acc, String pass, String port) {
        try {
            String url = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(url);
            String dbUrl = "jdbc:sqlserver://localhost:"+port+";databaseName="+db;
            //String dbUrl = "jdbc:mysql://localhost:3306"+db;
            connection = DriverManager.getConnection(dbUrl, acc, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
