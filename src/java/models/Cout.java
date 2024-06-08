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
public class Cout {
    
    private int id;
    
    private String idnify;
    
    private double remplacement;
    
    private double extraction;
    
    private double traitement;
    
    private double nettoyage;

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



    public double getRemplacement() {
        return remplacement;
    }

    public void setRemplacement(double remplacement) {
        this.remplacement = remplacement;
    }

    public double getExtraction() {
        return extraction;
    }

    public void setExtraction(double extraction) {
        this.extraction = extraction;
    }

    public double getTraitement() {
        return traitement;
    }

    public void setTraitement(double traitement) {
        this.traitement = traitement;
    }

    public double getNettoyage() {
        return nettoyage;
    }

    public void setNettoyage(double nettoyage) {
        this.nettoyage = nettoyage;
    }
    
    

    public Cout() {
    }
    
    

    public Cout(int id, String idnify, double remplacement, double extraction, double traitement, double nettoyage) {
        this.id = id;
        this.idnify = idnify;
        this.remplacement = remplacement;
        this.extraction = extraction;
        this.traitement = traitement;
        this.nettoyage = nettoyage;
    }

    @Override
    public String toString() {
        return "Cout{" + "id=" + id + ", idnify=" + idnify + ", remplacement=" + remplacement + ", extraction=" + extraction + ", traitement=" + traitement + ", nettoyage=" + nettoyage + '}';
    }
    
    
    
    
    
      public Cout[] getAllCout() {
            try (Connection connection = getConnection();           
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cout");
                 ResultSet rs = preparedStatement.executeQuery()) {

                List<Cout> donneeCout = new ArrayList<>();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String idnify = rs.getString("idnify");
                    double remplacement = rs.getDouble("remplacement");
                    double extraction = rs.getDouble("extraction");
                    double traitement = rs.getDouble("traitement");
                    double nettoyage = rs.getDouble("nettoyage");
                    
                    donneeCout.add(new Cout(id,idnify ,remplacement,extraction,traitement,nettoyage));
                }

                return donneeCout.toArray(new Cout[0]);
            } catch (SQLException e) {
                e.printStackTrace();
                return new Cout[0];
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
        
          Cout cout = new Cout();
          
          Cout[] array = cout.getAllCout();
          
          for (Cout cout1 : array) {
              
              System.out.println("resutl" + cout1.toString());
              
          }
    }
    
    
    
}
