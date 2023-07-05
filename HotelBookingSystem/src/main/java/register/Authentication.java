package register;

import java.sql.*;
import javax.swing.JOptionPane;
import za.ac.cput.hotelbookingsystem.DbConnection;

/**
 *
 * @author Sbani
 */
public class Authentication {

    private String name;
    private String surname;
    private int age;
    private String email;
    private long phone;
    private String password;
    private Connection con = DbConnection.ConnectionDb();
    private ResultSet rs;
    private PreparedStatement statemnet;

    public Authentication(String name, String surname, int age, String email, long phone, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Authentication(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Authentication() {
    }

    public boolean login() {
        boolean loged = false;
        try {  
            statemnet = con.prepareStatement("SELECT *from EMPLOYEE WHERE employee_email='"+email+"' AND employee_password COLLATE Latin1_General_CS_AS='"+password+"'");
            rs = statemnet.executeQuery();
            if(rs.next()) {
                System.out.println(rs.getString("employee_email"));
                JOptionPane.showMessageDialog(null, "Operation success");
                loged=true;
            }else{
            JOptionPane.showMessageDialog(null, "User credentials incorrect");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e.getMessage());
        }

        return loged;
    }

    private boolean isUniqueEmail() {
        boolean isUnique = true;

        return isUnique;
    }

    public boolean register() {
        boolean registred = false;
        if (isUniqueEmail()) {
            try {
                String sql = "INSERT INTO EMPLOYEE (employee_name,employee_surname,employee_age,employee_email,employee_phone,employee_password) VALUES(?,?,?,?,?,?)";

                statemnet = con.prepareStatement(sql);
                statemnet.setString(1, name);
                statemnet.setString(2, surname);
                statemnet.setInt(3, age);
                statemnet.setString(4, email);
                statemnet.setLong(5, phone);
                statemnet.setString(6, password);

                int k = statemnet.executeUpdate();
                if (k > 0) {
                    registred = true;
                    JOptionPane.showMessageDialog(null, "Successfuly Registered");
                } else {
                    JOptionPane.showMessageDialog(null, "Error ocured");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Email already being used");
        }
        return registred;
    }
}
