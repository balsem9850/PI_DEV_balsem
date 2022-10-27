package service;

import entities.Planing;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface InterfaceCrud {
    public void ajouterPlaning (Planing p) ;
    public void modifierPlaning(Planing p) ;
    public boolean supprimerPlaning(int id) ;
        public List<Planing> AfficherPlaning() ;
}