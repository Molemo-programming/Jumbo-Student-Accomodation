/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao;

/**
 *
 * @author Sbani
 */
public class Customer {
    private String name;
    private String surname;
    private String email;
    private String contact;
    private String address;

    public Customer(String name, String surname, String email, String contact, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.contact = contact;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }
    
}
