/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao;

/**
 *
 * @author Sbani
 */
public class Booking {
    private String customerEmail;
    private String cin;
    private String cout;
    private int guests;
    private int price;

    public Booking(String customerEmail, String cin, String cout, int guests, int price) {
        this.customerEmail = customerEmail;
        this.cin = cin;
        this.cout = cout;
        this.guests = guests;
        this.price = price;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCin() {
        return cin;
    }

    public String getCout() {
        return cout;
    }

    public int getGuests() {
        return guests;
    }

    public int getPrice() {
        return price;
    }
    
    
}
