/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tmehyg
 */
public class Traite_Donnee {

    public Traite_Donnee() {
    }
    
    
       public List<Resultat> verif_Demande(int idclient) {
        Demande_Client demande_client = new Demande_Client();
        Demande_Client[] donnee_demande = demande_client.getAllDemande();
        Choix choix = new Choix();
        Choix[] donnee_choix = choix.getAllChoix();

        List<Resultat> resultats = new ArrayList<>();

        for (Demande_Client demande_Client : donnee_demande) {
            if (idclient == demande_Client.getIdclient()) {
                for (Choix choix1 : donnee_choix) {
                    if (demande_Client.getChoixpriorise() == 0) {
                        
                        resultats.add(new Resultat(choix1.getIdnify(), idclient, choix1.getSanitaire()));
                    } else {
                       
                        resultats.add(new Resultat(choix1.getIdnify(), idclient, choix1.getBeaute()));
                    }
                }
            } else {
                System.out.println("tsis");
            }
        }

        return resultats;
    }
    
    

    public static void main(String[] args) {
        Traite_Donnee traite_donnee = new Traite_Donnee();
        int id = 3;
        List<Resultat> resultats = traite_donnee.verif_Demande(id);

        // Afficher les résultats
        for (Resultat resultat : resultats) {
            System.out.println("nify: " + resultat.getIdnify() + ", idclient: " + resultat.getIdclient() + ", coefficient: " + resultat.getCoefficient());
        }
    }
    
}
