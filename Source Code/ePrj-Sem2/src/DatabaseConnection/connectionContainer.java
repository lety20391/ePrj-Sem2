/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;
import java.sql.*;
/**
 *
 * @author Dat ThinkPad
 */
public class connectionContainer
{
    private Connection objCon;
    private Statement stmt;
    
    public connectionContainer(Connection objCon, Statement stmt)
    {
        this.objCon = objCon;
        this.stmt = stmt;
    }
    
    public Connection getObjCon()
    {
        return objCon;
    }
    
    public Statement getStatement()
    {
        return stmt;
    }
}
