/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package register;

import java.sql.*;
import java.util.*;
import za.ac.cput.hotelbookingsystem.DbConnection;

/**
 *
 * @author Sbani
 */
public class BookingDetails {
    private Statement statement;
    private ResultSet rs;
    private ArrayList arr=new ArrayList();
    private final Connection con=DbConnection.ConnectionDb();
    public BookingDetails() {
    }
    
    public ArrayList bookings(){
        try {
            String sql="SELECT *FROM BOOKINGS JOIN ROOMS ON BOOKINGS.ROOM_ID=ROOMS.ROOM_ID JOIN CUSTOMER ON BOOKINGS.CUSTOMER_ID=CUSTOMER.CUSTOMER_ID";
            statement=con.createStatement();
            rs=statement.executeQuery(sql);
            while(rs.next()){
               
                long bookingId=rs.getLong("booking_id");
                String roomNum=rs.getString("room_num");
                String customerName=rs.getString("name");
                int price=rs.getInt("total_cost");
                boolean paystatus=rs.getBoolean("pay_status");
                arr.add(new Booking(bookingId, roomNum, customerName, price, paystatus));
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arr;
    }

    public ArrayList getArr() {
        return arr;
    }
    
}
