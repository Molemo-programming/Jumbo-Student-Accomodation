
package za.ac.cput.hotelbookingsystem;

/**
 * @author Sbani
 */
import java.sql.*;
public class DbConnection {
    
    public static Connection ConnectionDb(){
        Connection con=null;
        try {
            String host="jdbc:mysql://localhost:3306/hoteldb";
            String user="root";
            String password="";
            //Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(host,user,password);
            System.out.println("Success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
