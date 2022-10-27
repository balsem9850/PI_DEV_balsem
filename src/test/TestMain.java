/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import entities.Planing;
import service.PlaningCRUD;
import utils.MyDB;
/**
 *
 * @author Balcem
 */
public class TestMain {
     public static void main(String[] args) {
        MyDB c =MyDB.getInstance();
       Planing P1=new Planing(7544,3,1,"esb@g","az19",50);
        PlaningCRUD cc=new PlaningCRUD();
        
        
     
        
      cc.ajouterPlaning(P1);
     //   cc.modifierUser(P1);
     // cc.supprimerUser(24);
     //   cc.AfficherUser().foprEach(System.out::println);
    }
    
}
    
