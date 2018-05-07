/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;
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

Vì Class DatabaseConnect trả về 1 đối tượng thuộc class Connection
nên mình khai báo 1 đối tượng objConnection để gán vào

Đối tượng objConnection này chính là object Connection lên Database sẽ được
sử dụng để chạy các câu truy vấn Query trong code của mỗi bạn

Connection objConnection;
objConnection = objDBConnect.DBConnect("prj2Database", "sa", "abc123");

3. Nếu kết nối thành công sẽ có thông báo "Connection Established"
Nên kiểm tra kết nối này trước, nếu không thành công thì không làm ăn cơm cháo gì được

4. Ví dụ kết nối nằm trong file TestConnection.java

*/

public class DatabaseConnect {
    Connection objConnection;
    Statement statement;
    ResultSet resultSet;
    String url;
    
    
    public  Connection DBConnect(String DatabaseName, String Account, String Password)
    {
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            url = "jdbc:sqlserver://localhost:1433;database="+DatabaseName;
            objConnection = DriverManager.getConnection(url, Account, Password);
            System.out.println("");
            System.out.println("--------Connection established---------");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return objConnection;
    }
    
}
