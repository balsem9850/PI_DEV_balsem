package entities;

/**
 *
 * @author Balcem
 */
public class Planing {
    private int idP;
    private int id_UserP;
    private int id_service;
    private   String dateRendezvous;
    private String heurejoingabilites ;
    private int prix ;
    private String RDV;
    /**
     *
     */
    public Planing() {
    }

    public Planing(int idP, int id_UserP, int id_service, String dateRendezvous, String heurejoingabilites,  int  prix) {
        this.idP = idP;
        this.id_UserP = id_UserP;
        this.id_service = id_service;
        this.dateRendezvous = dateRendezvous;
        this.heurejoingabilites = heurejoingabilites;
        this.prix = prix;
      
    }
 public Planing( int id_UserP, int id_service, String dateRendezvous, String heurejoingabilites,  int  prix) {
        this.id_UserP = id_UserP;
        this.id_service = id_service;
        this.dateRendezvous = dateRendezvous;
        this.heurejoingabilites = heurejoingabilites;
        this.prix = prix;
      
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public int getId_UserP() {
        return id_UserP;
    }

    public void setId_UserP(int id_UserP) {
        this.id_UserP = id_UserP;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public String getDateRendezvous() {
        return dateRendezvous;
    }

    public void setDateRendezvous(String dateRendezvous) {
        this.dateRendezvous = dateRendezvous;
    }

    public String getHeurejoingabilites() {
        return heurejoingabilites;
    }

    public void setHeurejoingabilites(String heurejoingabilites) {
        this.heurejoingabilites = heurejoingabilites;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getRDV() {
        return RDV;
    }

    public void setRDV(String RDV) {
        this.RDV = RDV;
    }

    @Override
    public String toString() {
        return "Planing{" + "idP=" + idP + ", id_UserP=" + id_UserP + ", id_service=" + id_service + ", dateRendezvous=" + dateRendezvous + ", heurejoingabilites=" + heurejoingabilites + ", prix=" + prix + '}';
    }
    
}