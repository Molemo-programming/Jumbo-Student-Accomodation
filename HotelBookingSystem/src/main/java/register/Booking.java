/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package register;

/**
 *
 * @author Sbani
 */
public class Booking {

    private long booking_id;
    private String room_number;
    private String customer_name;
    private int price;
    private boolean payStatus;
    public Booking(long booking_id, String room_number, String customer_name, int price,boolean payStatus) {
        this.booking_id = booking_id;
        this.room_number = room_number;
        this.customer_name = customer_name;
        this.price = price;
        this.payStatus=payStatus;
    }

    public long getBooking_id() {
        return booking_id;
    }

    public String getRoom_number() {
        return room_number;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isPayStatus() {
        return payStatus;
    }

}
