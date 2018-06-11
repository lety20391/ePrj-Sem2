/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Dat ThinkPad
 */

/*
Class này tạo connection tới Database SQL trong máy
Tham số truyền vào là DatabaseName, Account và Password
Đối tượng trả về là 1 Connection
Cách sử dụng:

1. Tạo 1 đối tượng thuộc Class này

DatabaseConnect objDBConnect;
objDBConnect = new DatabaseConnect();

2. Khởi tạo kết nối đến SQL của máy với tham số DatabaseName, Accout, Password 
thông qua method DBConnect

Vì Class DatabaseConnect trả về 2 đối tượng 
1 thuộc class Connection
2 thuộc class Statement
nên mình khai báo 1 kiểu dữ liệu mới (Class mới) là connectionContainer, trong đó sẽ chứa 2 variable kiểu Connection và kiểu Statement

Đối tượng objConnection và statement này chính là object Connection lên Database sẽ được
sử dụng để chạy các câu truy vấn Query trong code của mỗi bạn

Connection objConnection;
objConnection = objDBConnect.DBConnect("prj2Database", "sa", "abc123");

3. Nếu kết nối thành công sẽ có thông báo "Connection Established"
Nên kiểm tra kết nối này trước, nếu không thành công thì không làm ăn cơm cháo gì được

4. Ví dụ kết nối nằm trong file TestConnection.java

5. Method ListTable sử dụng để liệt kê tất cả các bảng có trong Database được kết nối (đang thử nghiệm)

6. Method Close sử dụng để đóng kết nối đến Database
*/
public class DatabaseConnect {
    Connection objConnection;
    Statement statement;
    ResultSet resultSet;
    String url;
    connectionContainer objConContainer;
    String port;
    
    
    public  connectionContainer DBConnect(String DatabaseName, String Account, String Password, String port)
    {
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            url = "jdbc:sqlserver://localhost:"+port+";database="+DatabaseName;
            objConnection = DriverManager.getConnection(url, Account, Password);
            statement = objConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("");
            System.out.println("--------Connection established---------");
            objConContainer = new connectionContainer(objConnection, statement);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return objConContainer;
    }
    
    public void ListTable(){
        try {
            DatabaseMetaData metaObj = objConnection.getMetaData();
            ResultSet rsTable = metaObj.getTables(null, null, null, new String[] {"TABLE"});
            while (rsTable.next()) 
            {
                System.out.println("*******************");
                String tableName = rsTable.getString("TABLE_NAME");
                System.out.println(tableName);
                ResultSet rsCol = metaObj.getColumns(null, null, tableName, null);
                while(rsCol.next()){
                    System.out.print(rsCol.getString("COLUMN_NAME") + ", ");
                }
                System.out.println("");
                System.out.println("*******************");
                System.out.println("");
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void Close(){
        try {
            objConnection.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
