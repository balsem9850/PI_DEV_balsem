/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Balcem
 */
public class MyDB {
     String url ="jdbc:mysql://localhost:3306/upserve" ; 
    String user = "root" ;
    String pwd = "" ; 
    Statement st ;
    private static MyDB instance ;
     Connection conx ;
    
    private MyDB () {
        try {
            conx = DriverManager.getConnection(url,user,pwd) ;
            System.out.println("Connexion etablie !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage()) ;
        }
    }
    
        public static MyDB getInstance() {
           
            if (instance ==null) 
                instance = new MyDB () ;
            return instance ;
        }
     public  Connection getConnection(){
         return conx;
     }
   
}
