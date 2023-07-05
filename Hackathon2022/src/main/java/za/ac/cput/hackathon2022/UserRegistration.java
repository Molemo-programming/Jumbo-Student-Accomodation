package za.ac.cput.hackathon2022;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sbani Sithole
 */
public class UserRegistration {

    public static final String username = "Administrator";
    public static final String dbpassword = "password";
    Connection con;
    Statement statement;
    ResultSet rs;
    private String title;
    private String name;
    private String surname;
    private String gender;
    private String email;
    private String password;

    public UserRegistration(String title, String name, String surname, String gender, String email, String password) {
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    private boolean verifyDuplicate() {
        boolean notDupli = true;
        int row = 0;
        try {
            String str = "SELECT *FROM Hackathon2022 WHERE EMAIL='" + email + "'";
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Hackathon2022", username, dbpassword);
            statement = con.createStatement();
            rs = statement.executeQuery(str);
            if (rs.next()) {
                notDupli = false;
            }
            con.close();
            statement.close();
            rs.close();

        } catch (Exception e) {

        } finally {
            try {
                if (con != null) {
                    statement.close();
                    rs.close();
                    con.close();
                }
            } catch (Exception e) {
            }
        }
        return notDupli;
    }

    public boolean RehisterUser() {
        int row;
        boolean isAdded = false;
        
        if (verifyDuplicate()) {
            
            try {
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/Hackathon2022", username, dbpassword);
                statement = con.createStatement();                
                String str = "INSERT INTO Hackathon2022 VALUES('" + title + "','" + name + "','" + surname + "','" + gender + "','" + email + "','" + password + "')";
                row = statement.executeUpdate(str);
               
                if (row > 0) {
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                    isAdded = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Failled to add the user");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (Exception err) {
                System.out.println(err.getMessage());
            } finally {

            }
        } else {
            JOptionPane.showMessageDialog(null, "Email already exists");
        }
        return isAdded;
    }
}
