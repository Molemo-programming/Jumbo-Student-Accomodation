/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.hotelbookingsystem;

import java.sql.*;
import register.Authentication;

/**
 *
 * @author Sbani
 */
public class Main {

    public static void main(String[] args) {
        Statement statement;
        ResultSet results;
        Authentication gui=new Authentication();
        gui.login();
    }
}
