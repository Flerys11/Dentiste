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
public class Client {
    
    private int id;
    
    private String nom;
    
    private double budget;

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Client() {
    }

    public Client(int id, String nom, double budget) {
        this.id = id;
        this.nom = nom;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nom=" + nom + ", budget=" + budget + '}';
    }


    
    
    
       public Client[] getAllClient() {
            try (Connection connection = getConnection();           
                 PreparedStatement preparedStatement = connection.prepareStatement("select * from getClient");
                 ResultSet rs = preparedStatement.executeQuery()) {

                List<Client> donneeClient = new ArrayList<>();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nom = rs.getString("nom");
                    double budget = rs.getDouble("argent");
                    donneeClient.add(new Client(id, nom, budget));
                }

                return donneeClient.toArray(new Client[0]);

            } catch (SQLException e) {
                e.printStackTrace();
                return new Client[0];
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
       
       
       public Client getById(int idclient) {
           Client client = null;
           try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from getClient where id = ?");) {
			preparedStatement.setInt(1, idclient);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
			 int id = rs.getInt("id");
                        String nom = rs.getString("nom");
                        double budget = rs.getDouble("argent");
			client = new Client(id, nom,budget);
			}
           } catch (Exception e) {
              e.printStackTrace();

           }finally {
                try {Connection connection = getConnection();
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace(); 
                }
            }
        return client;
       }
       
       
       
      public static void main(String[] args) {
        
          Client client = new Client();
          
        Client[] clientArray  =  client.getAllClient();
          


    for (Client c : clientArray) {
        System.out.println(c.toString());
    }
    }
    
}
