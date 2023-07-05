/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao;

/**
 *
 * @author Sbani
 */
public class Payment {
    private int cardNo;
    private String email;
    private int code;
    private String holderName;

    public Payment(int cardNo, String email, int code, String holderName) {
        this.cardNo = cardNo;
        this.email = email;
        this.code = code;
        this.holderName = holderName;
    }

    public int getCardNo() {
        return cardNo;
    }

    public String getEmail() {
        return email;
    }

    public int getCode() {
        return code;
    }

    public String getHolderName() {
        return holderName;
    }
    
    
    
}
