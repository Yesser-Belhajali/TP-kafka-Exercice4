package tn.utm.kafka;

public class Vente {

    private String idClient;
    private double montant;
    private String ville;

    public Vente() {
        // requis par Jackson
    }

    public Vente(String idClient, double montant, String ville) {
        this.idClient = idClient;
        this.montant = montant;
        this.ville = ville;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}