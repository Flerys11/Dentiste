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
public class Remplacement {
    
    private int id;
    
    private String idnify;
    
    private int sanitaire;
    
    private int beaute;
    
    private double prix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdnify() {
        return idnify;
    }

    public void setIdnify(String idnify) {
        this.idnify = idnify;
    }

    public int getSanitaire() {
        return sanitaire;
    }

    public void setSanitaire(int sanitaire) {
        this.sanitaire = sanitaire;
    }

    public int getBeaute() {
        return beaute;
    }

    public void setBeaute(int beaute) {
        this.beaute = beaute;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Remplacement() {
    }

    public Remplacement(int id, String idnify, int sanitaire, int beaute, double prix) {
        this.id = id;
        this.idnify = idnify;
        this.sanitaire = sanitaire;
        this.beaute = beaute;
        this.prix = prix;
    }
    
    
            public Remplacement[] getAllRemplacement() {
            try (Connection connection = getConnection();           
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM traitement");
                 ResultSet rs = preparedStatement.executeQuery()) {

                List<Remplacement> donneeRemplace = new ArrayList<>();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String idnify = rs.getString("idnify");
                    int sanitaire = rs.getInt("sanitaire");
                    int beaute = rs.getInt("beaute");
                    double prix = rs.getDouble("prix");
                    donneeRemplace.add(new Remplacement(id,idnify,sanitaire,beaute,prix));
                }

                return donneeRemplace.toArray(new Remplacement[0]);
            } catch (SQLException e) {
                e.printStackTrace();
                return new Remplacement[0];
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
    
    
    
    
    
}
