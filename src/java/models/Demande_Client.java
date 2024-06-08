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

/**
 *
 * @author Tmehyg
 */
public class Demande_Client{
    
    private int iddemande;
    
    private int idclient;
    
    private int choixpriorise;
    
    private String nom_client;
    
    private String adresse;

    public int getIddemande() {
        return iddemande;
    }

    public void setIddemande(int iddemande) {
        this.iddemande = iddemande;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getChoixpriorise() {
        return choixpriorise;
    }

    public void setChoixpriorise(int choixpriorise) {
        this.choixpriorise = choixpriorise;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Demande_Client(int iddemande, int idclient, int choixpriorise, String nom_client, String adresse) {
        this.iddemande = iddemande;
        this.idclient = idclient;
        this.choixpriorise = choixpriorise;
        this.nom_client = nom_client;
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Demande_Client{" + "iddemande=" + iddemande + ", idclient=" + idclient + ", choixpriorise=" + choixpriorise + ", nom_client=" + nom_client + ", adresse=" + adresse + '}';
    }

    

    public Demande_Client() {
    }



    
    


    
     public Demande_Client[] getAllDemande() {
            try (Connection connection = getConnection();           
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM getDClient");
                 ResultSet rs = preparedStatement.executeQuery()) {

                List<Demande_Client> donneeDemande = new ArrayList<>();

                while (rs.next()) {
                    int iddemande = rs.getInt("iddemande");
                    int idclient = rs.getInt("idclient");
                    int choixpriorise = rs.getInt("choixpriorise");
                    String nom_client = rs.getString("nom_client");
                    String adresse = rs.getString("adresse");
                    donneeDemande.add(new Demande_Client(iddemande, idclient,choixpriorise,nom_client,adresse));
                }

                return donneeDemande.toArray(new Demande_Client[0]);
            } catch (SQLException e) {
                e.printStackTrace();
                return new Demande_Client[0];
            } finally {
                try {Connection connection = getConnection();
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace(); 
                }
            }
        }
     
     
    
            
            
    public static void main(String[] args) {
        
        Demande_Client demande = new Demande_Client();
        
        Demande_Client[] donneeArray = demande.getAllDemande();
        
        for (Demande_Client demande_Client : donneeArray) {
            
            System.out.println("valiny : " +demande_Client.toString());
        }
    }
    
    
    
    
    
}
