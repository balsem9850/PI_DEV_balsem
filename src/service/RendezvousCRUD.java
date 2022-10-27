/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import entities.Planing;
import entities.Rendezvous;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;



/**
 *
 * @author Balcem
 */
public class RendezvousCRUD {
     Connection conx = (Connection) MyDB.getInstance().getConnection();
   
     
     
     public void ajouter(Rendezvous p ) {
        String req = "INSERT INTO `rendezvous` ( `date`, `contrat`) VALUES ( '"+p.getDate()+"','"+p.getContrat()+"');";
        System.out.print(req);
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
}
    public void modifier(Rendezvous p) {
        
         String req = "UPDATE `rendezvous` SET `date`='" +p.getDate()+ "',`contrat`='"+p.getContrat()+"' WHERE id ='"+ p.getId()+"'";
         System.out.print(req);
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;
        System.out.println("Le Planing  est ajouté");}
        
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

   
    public boolean supprimer(int id) {
         try {
        String req=" DELETE FROM rendezvous WHERE id="+ id ;

        PreparedStatement St = conx.prepareStatement(req);
        St.executeUpdate();
        return true;
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
        return false;
    }
       
    }
    public ObservableList<Rendezvous> Afficher() {
              ObservableList <Rendezvous> list = FXCollections.observableArrayList();
        try {
    String req = "SELECT * FROM  rendezvous";        
    Statement st;
    st =conx.createStatement();
    ResultSet rs = st.executeQuery(req);
    while(rs.next()){
    Rendezvous p  = new Rendezvous (rs.getInt(1), rs.getString("contrat"),rs.getString("date"));
    list.add(p);
              }
        }
        catch (SQLException ex){
    System.err.println(ex.getMessage());
}
    return list;
    }
    
    public Rendezvous findbyid(int id){
    try {
    String req = "SELECT * FROM  rendezvous WHERE id='"+id+"'";        
    Statement st;
    st =conx.createStatement();
    ResultSet rs = st.executeQuery(req);
    while(rs.next()){
    Rendezvous p  = new Rendezvous (rs.getInt(1), rs.getString("contrat"),rs.getString("date"));
    return p;
              }
        }
        catch (SQLException ex){
    System.err.println(ex.getMessage());
    return new Rendezvous();
}
         return null;
    }
           

}
