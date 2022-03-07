/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lab.BD;
import  java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author USUARIO
 */
public class ConexionMYSQL {
    
    private static Connection connectionBD = null;
    public Connection getConecction ()
    {
        
        try {
    String url = "jdbc:mysql://localhost:3306/lab";
    String User="Erick";        
    String password = "root";  
    
    connectionBD = DriverManager.getConnection(url,User,password);
    System.out.println("conexion exitosa");
    } catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"Error"+e.toString());
    }
    return connectionBD;    
    }
   
    
}
        