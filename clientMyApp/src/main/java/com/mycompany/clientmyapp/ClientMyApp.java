/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.clientmyapp;

import java.io.InputStream;
import java.net.*;

/**
 *
 * @author Sbani
 */
public class ClientMyApp {

    public static void main(String[] args) {
        try {
            Socket soc=new Socket("localhost", 1543);
            InputStream sl=soc.getInputStream();
        } catch (Exception e) {
        }
    }
}
