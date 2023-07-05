/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.examprep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
DAO.java
This is a database class having Select, Insert, Update, Delete
Author: Hanno Visser Immelman (221074414)
 */
public class DAO {

    static final String DATABASE_URL = "jdbc:derby://localhost:1527/CarsDB";
    private final String username = "administrator";
    private final String password = "password";
//Inserting new Items into database

    public void InsertCar(ArrayList arr) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, username, password);
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Car VALUES ('" + arr.get(0).toString() + "',"
                    + "'" + arr.get(1).toString() + "',"
                    + "'" + arr.get(2).toString() + "',"
                    + "'" + arr.get(3).toString() + "')");

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Warning" + sqlException);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
//Selecting items form database for combobox

    public ArrayList populate() {
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        ArrayList listModelNum = new ArrayList();
        try {
            connection = DriverManager.getConnection(DATABASE_URL, username, password);
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT Model_Num FROM Car");
            while (result.next()) {
                listModelNum.add(result.getString(1));

            }
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Warning" + sqlException);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listModelNum;
    }
//Selecting items from database to put into text fields

    public ArrayList SelectedItems(String modelNum) {
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        ArrayList listItems = new ArrayList();
        try {
            connection = DriverManager.getConnection(DATABASE_URL, username, password);
            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM Car WHERE Model_Num = '" + modelNum + "'");
            while (result.next()) {
                listItems.add(result.getString(1));
                listItems.add(result.getString(2));
                listItems.add(result.getString(3));
                listItems.add(result.getString(4));

            }
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Warning" + sqlException);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
        return listItems;
    }
//Update items in database

    public void UpdateDB(ArrayList arr, String oldModelNum) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, username, password);
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE Car SET Model_Num = '" + arr.get(0).toString()
                    + "', Car_Name = '" + arr.get(1).toString()
                    + "', Car_Manufacturer = '" + arr.get(2).toString()
                    + "', Engine_HP = '" + arr.get(3).toString()
                    + "' WHERE Model_Num = '" + oldModelNum + "'");

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Warning" + sqlException);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
//Delete items from database

    public void DeleteDB(String modelNum) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, username, password);
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Car WHERE model_num = '" + modelNum + "'");

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Warning" + sqlException);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
