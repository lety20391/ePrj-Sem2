/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dell
 */
public class DBConnection {
static Connection conn;
    public static String database="Sem2_Project_Group2";
    public static String account="sa";
    public static String password="123456789";
    public static Connection getDBConnection(String db, String acc, String pass)
    {
        try {
            String url = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            //String url = "com.mysql.jdbc.Driver";
            Class.forName(url);
            String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName="+db;
            //String dbUrl = "jdbc:mysql://localhost:3306"+db
            conn = DriverManager.getConnection(dbUrl,acc,pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
