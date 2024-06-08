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
public class Choix {
    private String idnify;
    
    private int sanitaire;
    
    private int beaute;

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

    public Choix() {
    }

    public Choix(String idnify, int sanitaire, int beaute) {
        this.idnify = idnify;
        this.sanitaire = sanitaire;
        this.beaute = beaute;
    }

    @Override
    public String toString() {
        return "Choix{" + "idnify=" + idnify + ", sanitaire=" + sanitaire + ", beaute=" + beaute + '}';
    }
    
    
    
    
    
    
        public Choix[] getAllChoix() {
            try (Connection connection = getConnection();           
                 PreparedStatement preparedStatement = connection.prepareStatement("select * from choix");
                 ResultSet rs = preparedStatement.executeQuery()) {

                List<Choix> donneeChoix = new ArrayList<>();

                while (rs.next()) {
                    String idnify = rs.getString("idnify");
                    int sanitaire = rs.getInt("sanitaire");
                    int beaute = rs.getInt("beaute");
                    donneeChoix.add(new Choix(idnify, sanitaire,beaute));
                }

                return donneeChoix.toArray(new Choix[0]);

            } catch (SQLException e) {
                e.printStackTrace();
                return new Choix[0];
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
        
            Choix choix = new Choix();
            
            Choix[] array = choix.getAllChoix();
            
            for (Choix choix1 : array) {
                System.out.println("result" + choix1.toString());
                
            }
    }
}
