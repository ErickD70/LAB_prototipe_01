/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entidades.NewClass;
import com.lab.BD.ConexionMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import VISTA.FrmConsultaBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author USUARIO
 */
public class Contactos {
    public ArrayList <NewClass> ListadoContactos()
    {
        ArrayList<NewClass> listado = null; 
        ConexionMYSQL con = new ConexionMYSQL();
        
        Connection conexion = con.getConecction();
        
    try{
         listado = new ArrayList<NewClass>();
         
         CallableStatement cb = conexion.prepareCall("select * from Nombre");
         ResultSet resultado = cb.executeQuery();
      
    while (resultado.next())
    {
    NewClass ne = new NewClass();
    ne.setNombre(resultado.getString("Nombre"));
    ne.setEdad(resultado.getString("Edad"));
    ne.setEmail(resultado.getString("Email"));
    ne.setNumeroDeTelefono(resultado.getString("Num. telefono"));
    listado.add(ne);
    }
           
    } catch (SQLException e) {}
        
        return listado;
    }
    public void Add(NewClass ne)
    { 
        ConexionMYSQL con = new ConexionMYSQL();
        Connection conexion=con.getConecction();
    try{
        
         CallableStatement cb = conexion.prepareCall("insert into "
         + "contactos (Nombre,Edad,Email,NumeroDeTel) values('"+ne.getNombre()+"','"+ne.getEdad()+"','"+ne.getEmail()+"','"+ne.getNumeroDeTelefono()+"')");
         cb.execute();
      
         JOptionPane.showMessageDialog(null,"contacto agregado","Mensaje sistema",1);
    } 
    catch (SQLException ex) 
    {
        JOptionPane.showMessageDialog(null,"Error","Mensaje sistema",1);
    }
    
    }
    //public void Delete(NewClass ne)
    //{ConexionMYSQL con = new ConexionMYSQL();
     //Connection conexion=con.getConecction();
    //try
    //{
         //CallableStatement cb = conexion.prepareCall("DELETE FROM "
           //+ "contactos (Nombre,Edad,Email,NumeroDeTel) values('"+ne.getNombre()+"','"+ne.getEdad()+"','"+ne.getEmail()+"','"+ne.getNumeroDeTelefono()+"')");
         //cb.execute();
         
         //JOptionPane.showMessageDialog(null,"contacto eliminado","Mensaje sistema",1);
    //}
    //catch (Exception ex) 
    //{
       //  JOptionPane.showMessageDialog(null,"error","Mensaje sistema",1);
    //}
    //}
   // public void Update(NewClass ne)
    //{ConexionMYSQL con = new ConexionMYSQL();
    // Connection conexion=con.getConecction();
    //try
    //{
       // CallableStatement cb = conexion.prepareCall("UPDATE"
       // + "contactos (Nombre,Edad,Email,NumeroDeTel) SET('"+ne.getNombre()+"','"+ne.getEdad()+"','"+ne.getEmail()+"','"+ne.getNumeroDeTelefono()+"')");
        
         
        // JOptionPane.showMessSageDialog(null,"contacto actualisado","Mensaje sistema",1);
   // }
}
