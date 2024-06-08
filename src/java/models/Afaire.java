package models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Afaire {
    
   private String idnify;
   
   private int idclient;
   
   private String nom_client;
   
   private String nom_nify;
   
   private double cout_total;
   
   private double etat;

    public double getEtat() {
        return etat;
    }

    public void setEtat(double etat) {
        this.etat = etat;
    }


   
   

    public String getIdnify() {
        return idnify;
    }

    public void setIdnify(String idnify) {
        this.idnify = idnify;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getNom_nify() {
        return nom_nify;
    }

    public void setNom_nify(String nom_nify) {
        this.nom_nify = nom_nify;
    }

    public double getCout_total() {
        return cout_total;
    }

    public void setCout_total(double cout_total) {
        this.cout_total = cout_total;
    }

    public Afaire() {
    }

    public Afaire(String idnify, int idclient, String nom_client, String nom_nify, double cout_total, double etat) {
        this.idnify = idnify;
        this.idclient = idclient;
        this.nom_client = nom_client;
        this.nom_nify = nom_nify;
        this.cout_total = cout_total;
        this.etat = etat;
    }

    public static List<Afaire> listAfaire(int idclient) {
        List<Afaire> result = new ArrayList<>();
        Traitement traitement = new Traitement();
        Client client = new Client();
        Client[] donneeClient = client.getAllClient();
        double total_rep = 0.0;
        double somme = 0.0;
        double etat =0.0;
        List<Traitement> trait = traitement.Calcul_Cout_Total(idclient);
        
        for (Traitement traitement0 : trait) {
            somme += traitement0.getCout_total();
        }
        
        trait.sort(
            Comparator.comparing(Traitement::getIdnify, 
                Comparator.comparingInt(idnify -> {
                    if (idnify.compareTo("N001") >= 0 && idnify.compareTo("N0016") <= 0) {
                        return 0;
                    }
                    return 1;
                }))
                .thenComparingDouble(Traitement::getCoeff)
                .reversed()
        );

        for (Traitement traitement1 : trait) {
            
                total_rep += traitement1.getCout_total();
                //System.out.println("t "+ somme);
                //System.out.println("valiny "+traitement1.getCout_total());
                if( total_rep <= donneeClient[0].getBudget()) {
                    etat = 10;
                    
                    Afaire afaire = new Afaire(traitement1.getIdnify(), traitement1.getIdclient(),
                                          traitement1.getNom_client(), traitement1.getNom_nify(), traitement1.getCout_total(),etat);
                    result.add(afaire);
                    //System.out.println("etat " +etat);
                } else {
                    System.out.println("ato");
                    double reste = total_rep - donneeClient[0].getBudget();
                    double valeur_entre = traitement1.getCout_total() - reste;
                    //System.out.println("valiny "+ valeur_entre);
                    
                    etat = 10 - (reste/1000 );
                    System.out.println("etat 1 " +(reste/1000 ));
                    
                    Afaire afaire = new Afaire(traitement1.getIdnify(), traitement1.getIdclient(),
                                          traitement1.getNom_client(), traitement1.getNom_nify(), valeur_entre,etat);
                    result.add(afaire);
                }
                
                
        }
     
        return result;
    }

    public static void main(String[] args) {
        int id = 1;
        List<Afaire> array = listAfaire(id);
        
        for (Afaire afaire : array) {
            
            System.out.println("idnify " +afaire.idnify +" nom_nify "+afaire.nom_nify +" nom_client " +afaire.nom_client + " cout " +afaire.cout_total +" etat "+afaire.etat);
            
        }
    }
}
