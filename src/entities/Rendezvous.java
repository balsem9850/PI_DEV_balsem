/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author MSI GF63
 */
public class Rendezvous {
    public int id;
    public String contrat,date;

    public Rendezvous(int id, String contrat, String date) {
        this.id = id;
        this.contrat = contrat;
        this.date = date;
    }

    public Rendezvous() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContrat() {
        return contrat;
    }

    public void setContrat(String contrat) {
        this.contrat = contrat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Rendezvous{" + "id=" + id + ", contrat=" + contrat + ", date=" + date + '}';
    }
    
}
