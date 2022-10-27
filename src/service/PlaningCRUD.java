/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import entities.Planing;
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
public class PlaningCRUD implements InterfaceCrud {
     Connection conx = (Connection) MyDB.getInstance().getConnection();
   
     
     @Override
     public void ajouterPlaning(Planing p ) {
        String req = "INSERT INTO `planing`(`id`, `Rendezvous`,`heurejoingabilites`,`prix`) VALUES (" +p.getIdP()+ ",'" +p.getDateRendezvous()+ "','" +p.getHeurejoingabilites()+ "'," +p.getPrix()+ ")" ;
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    
}
     @Override
    public void modifierPlaning(Planing p) {
        
         String req = "UPDATE `planing` SET `Rendezvous`='" +p.getDateRendezvous()+ "',`heurejoingabilites`='"+p.getHeurejoingabilites()+"',`prix`="+p.getPrix()+" WHERE id ="+ p.getIdP();
        Statement st  ;
        try {
        st = conx.createStatement() ;
        st.executeUpdate(req) ;
        System.out.println("Le Planing  est ajouté");}
        
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }

    /**
     *
     * 
     */
    @Override
    public boolean supprimerPlaning(int id) {
         try {
        String req=" DELETE FROM planing WHERE id="+ id ;

        PreparedStatement St = conx.prepareStatement(req);
        St.executeUpdate();
        return true;
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
        return true;
    }
       
    }
     @Override
    public ObservableList<Planing> AfficherPlaning() {
              ObservableList <Planing> list = FXCollections.observableArrayList();
        try {
    String req = "SELECT * FROM  planing";        
    Statement st;
    st =conx.createStatement();
    ResultSet rs = st.executeQuery(req);
    while(rs.next()){
        RendezvousCRUD s=new RendezvousCRUD();
    Planing p  = new Planing (rs.getInt("Id"), rs.getInt("id_UserP"),rs.getInt("id_service"),rs.getString("Rendezvous"),rs.getString("heurejoingabilites"),rs.getInt("prix"));
    p.setRDV(s.findbyid(Integer.parseInt(rs.getString("Rendezvous"))).toString());
    list.add(p);
              }
        }
        catch (SQLException ex){
    System.err.println(ex.getMessage());
}
    return list;
    }
    public ObservableList<Planing> search(String critere) {
              ObservableList <Planing> list = FXCollections.observableArrayList();
        try {
    String req = "SELECT * FROM  planing WHERE  prix LIKE '%"+critere+"%'";        
    Statement st;
    st =conx.createStatement();
    ResultSet rs = st.executeQuery(req);
    while(rs.next()){
                RendezvousCRUD s=new RendezvousCRUD();

      Planing p  = new Planing (rs.getInt("Id"), rs.getInt("id_UserP"),rs.getInt("id_service"),rs.getString("Rendezvous"),rs.getString("heurejoingabilites"),rs.getInt("prix"));
      p.setRDV(s.findbyid(Integer.parseInt(rs.getString("Rendezvous"))).toString());
        //ajoutit variable RDV mhech mawjouda fel base
        //
    list.add(p);
              }
        }
        catch (SQLException ex){
    System.err.println(ex.getMessage());
}
    return list;
    }

}
