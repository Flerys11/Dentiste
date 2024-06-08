/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import conn.Connexion;
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
public class Nify {
    
    private String id;
    
    private String nom;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Nify() {
    }

    public Nify(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Nify{" + "id=" + id + ", nom=" + nom + '}';
    }
    
    
    
        private static final String SELECT_METEO = " select * from nify ";
    
        public Nify[] getAllNify() {
            try (Connection connection = getConnection();           
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_METEO);
                 ResultSet rs = preparedStatement.executeQuery()) {

                List<Nify> donneeNify = new ArrayList<>();

                while (rs.next()) {
                    String id = rs.getString("id");
                    String nom = rs.getString("nom");
                    donneeNify.add(new Nify(id, nom));
                }

                return donneeNify.toArray(new Nify[0]);

            } catch (SQLException e) {
                e.printStackTrace();
                return new Nify[0];
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
        
            Nify nify = new Nify();
            Nify[] nifyArray = nify.getAllNify();
            
            for (Nify nify1 : nifyArray) {
                
                System.out.println("donnee" + nify1.toString());
            }
            
    }
    
    
}
