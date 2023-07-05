package com.company.dao;

import java.sql.*;

public class BookingDAO {

    private static Connection con;
    private static Statement statement;
    private static ResultSet rs;

    public static boolean isCon() {
        try {
            String host = "jdbc:mysql://localhost:3306/hotelbookingsystem";
            String user = "root";
            String password = "";
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(host, user, password);
            System.out.println("Success");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean addCustomer(Customer customer) {
        if (isCon()) {
            try {
                statement = con.createStatement();
                String sql = "INSERT INTO customer(name,surname,email,contact,address) VALUES('" + customer.getName() + "','" + customer.getSurname() + "','" + customer.getEmail() + "','" + customer.getContact() + "','" + customer.getAddress() + "')";
                int k = statement.executeUpdate(sql);
                if (k > 0) {
                    return true;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public static boolean addCard(Payment card) {
        if (isCon()) {
            try {
                statement = con.createStatement();
                String sql = "INSERT INTO card(card_num,customer_email,security_code,holder_name) VALUES(" + card.getCardNo() + ",'" + card.getEmail() + "'," + card.getCode() + ",'" + card.getHolderName() + "')";
                int k = statement.executeUpdate(sql);
                if (k > 0) {
                    return true;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public static boolean Book(Booking book) {
        if (isCon()) {
            try {
                statement = con.createStatement();
                String sql = "INSERT INTO booking(customer_email,check_in,check_out,guests,price) VALUES('" + book.getCustomerEmail() + "','" + book.getCin() + "','" + book.getCout() + "'," + book.getGuests() + ", " + book.getPrice() + ")";
                int k = statement.executeUpdate(sql);
                if (k > 0) {
                    return true;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}
