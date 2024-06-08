/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import static conn.Connexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author Tmehyg
 */
public class Traitement {
    
   private String idnify;
   
   private int idclient;
   
   private String nom_client;
   
   private String nom_nify;
   
   private double Cout_total;
   
   private int coeff;

    public String getIdnify() {
        return idnify;
    }

    public void setIdnify(String idnify) {
        this.idnify = idnify;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
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
        return Cout_total;
    }

    public void setCout_total(double Cout_total) {
        this.Cout_total = Cout_total;
    }
   
   

    public Traitement() {
    }
   
   

    public Traitement(String idnify, int idclient, String nom_client, String nom_nify, double Cout_total, int coeff) {
        this.idnify = idnify;
        this.idclient = idclient;
        this.nom_client = nom_client;
        this.nom_nify = nom_nify;
        this.Cout_total = Cout_total;
        this.coeff = coeff;
    }
    
    
   public List<Traitement> Calcul_Cout_Total(int idclient) {
    List<Traitement> result = new ArrayList<>();
    Traite_Donnee traite_donnee = new Traite_Donnee();
    Etat etat = new Etat();
    Etat[] donneEtat = etat.getAllEtat_Client();
    Cout cout = new Cout();
    Cout[] donneeCout = cout.getAllCout();
    List<Resultat> resultats = traite_donnee.verif_Demande(idclient);
    for (Etat etat1 : donneEtat) {
        if (resultats.get(0).getIdclient() == idclient && idclient == etat1.getIdclient()) {
            //System.out.println("coef "+resultats.get(0).getCoefficient());
            for (Cout cout1 : donneeCout) {
                if (etat1.getIdnify().equals(cout1.getIdnify())) {
                    int etat_nify = etat1.getEtat();
                    
                    double valeur1 = 0.0;
                    double valeur2 = 0.0;
                    double valeur3 = 0.0;
                    double valeur4 = 0.0;
                    
                    switch (etat_nify) {
                        case 0:
                            valeur1 = cout1.getRemplacement();
                            break;
                        case 1:
                        case 2:
                        case 3:
                            //valeur2 = cout1.getExtraction() + cout1.getRemplacement();
                            double val0 = cout1.getExtraction();
                            if (etat_nify == 1) {
                                valeur3 = (val0 * 3)+ (cout1.getTraitement()*3) +(cout1.getNettoyage()*3);
                               
                            } else if (etat_nify == 2) {
                                valeur3 = (val0 * 2)+ (cout1.getTraitement()*3) +(cout1.getNettoyage()*3);
                              
                            } else {
                                valeur3 = val0 + (cout1.getTraitement()*3) +(cout1.getNettoyage()*3);
                                
                            }
                            
                            break;
                        case 4:
                        case 5:
                        case 6:
                            double val1 = cout1.getTraitement();
                            if (etat_nify == 5) {
                                valeur3 = (val1 * 3) + (cout1.getNettoyage() * 3);
                               
                            } else if (etat_nify == 6) {
                                valeur3 = (val1 * 2) + (cout1.getNettoyage() * 3);
                              
                            } else {
                                valeur3 = val1 + (cout1.getNettoyage() * 3);
                                
                            }
                            break;
                        case 7:
                        case 8:
                        case 9:
                            if (etat_nify == 7) {
                                valeur4 = cout1.getNettoyage() * 3;
                                
                            } else if (etat_nify == 8) {
                                valeur4 = cout1.getNettoyage() * 2;
                                
                            } else {
                                valeur4 = cout1.getNettoyage();
                               
                            }
                            break;
                        default:     
                    }
                    Traitement traitement = new Traitement(etat1.getIdnify(), etat.getIdclient(), 
                     etat1.getNom_client(), etat1.getNom_nify(), valeur1+valeur2+valeur3+valeur4, resultats.get(0).getCoefficient());
                    result.add(traitement);
                }
            }
        } else {
           
        }
    }
    return result;
}

    
    public static void main(String[] args) {
        int idclient = 3;
       Traitement traitement = new Traitement();
       List<Traitement> traitements = traitement.Calcul_Cout_Total(idclient);
        for (Traitement trait : traitements) {
            System.out.println("ID: " + trait.idnify+ ", Nom_nify : " + trait.nom_nify + " nom_client :"+trait.nom_client +" cout :" +trait.Cout_total+ " coeff :"+ trait.coeff );
            
            
        }
    }
    
   
   
    
    
}
