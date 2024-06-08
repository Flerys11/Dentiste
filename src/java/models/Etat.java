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
public class Etat {
    
    private int idetat;
    
    private int idclient;
    
    private String nom_client;
    
    private String idnify;
    
    private String nom_nify;
    
    private int etat;

    public int getIdetat() {
        return idetat;
    }

    public void setIdetat(int idetat) {
        this.idetat = idetat;
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

    public String getIdnify() {
        return idnify;
    }

    public void setIdnify(String idnify) {
        this.idnify = idnify;
    }

    public String getNom_nify() {
        return nom_nify;
    }

    public void setNom_nify(String nom_nify) {
        this.nom_nify = nom_nify;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Etat() {
    }

    public Etat(int idetat, int idclient, String nom_client, String idnify, String nom_nify, int etat) {
        this.idetat = idetat;
        this.idclient = idclient;
        this.nom_client = nom_client;
        this.idnify = idnify;
        this.nom_nify = nom_nify;
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Etat{" + "idetat=" + idetat + ", idclient=" + idclient + ", nom_client=" + nom_client + ", idnify=" + idnify + ", nom_nify=" + nom_nify + ", etat=" + etat + '}';
    }
    
    
    
    
      public Etat[] getAllEtat_Client() {
            try (Connection connection = getConnection();           
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM getEtatClient");
                 ResultSet rs = preparedStatement.executeQuery()) {

                List<Etat> donneeEtat = new ArrayList<>();

                while (rs.next()) {
                    int idetat = rs.getInt("idetat");
                    int idclient = rs.getInt("idclient");
                    String nom_client = rs.getString("nom_client");
                    String idnify = rs.getString("idnify");
                    String nom_nify = rs.getString("nom_nify");
                    int etat = rs.getInt("etat");
                    donneeEtat.add(new Etat(idetat, idclient,nom_client,idnify,nom_nify,etat));
                }

                return donneeEtat.toArray(new Etat[0]);
            } catch (SQLException e) {
                e.printStackTrace();
                return new Etat[0];
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
      
      public void insertNifyEtat(int id,String nify, String etat,Connection conn) throws Exception{  
        //String symbole = "-" ;
       String val = "";

        int positionSymbole = nify.indexOf(";");
        if (positionSymbole != -1) {
            String symbole = nify.substring(positionSymbole, positionSymbole + 1);   
            //System.out.println("Le symbole est : " + symbole);
            String[] chiffresStr = etat.split(";");
            String[] nifysStr = nify.split(";");
            
                            for (String nifyStr : nifysStr) {
                                 val = nifyStr;
                                   }
            for (String chiffreStr : chiffresStr) {
                

                try {
                    int note = Integer.parseInt(chiffreStr);
                        String sql= "insert  into etat_nify_client (idclient,idnify,etat) values(%s,'%s',%s)";
                        sql=sql.format(sql,id, val,note);
                        if(conn == null){
                            conn=Connexion.getConnection();
                        }
                        conn.createStatement().executeUpdate(sql);
                        //conn.close();
                   // System.out.println("Chiffre récupéré : " + note + "valint :" +val);
                } catch (NumberFormatException e) {
                    System.out.println("La conversion en nombre a échoué pour : " + chiffreStr);
                } 
                }
            //}
            
               System.out.println("valiny" + etat );
            
        } else {
            String[] parties = nify.split("N");

        if (parties.length > 2) {
            String valeurApresSecondN = parties[2];
            String hafa =  parties[1].replace("-", "");
            
            String ini = parties[1].replace("-", "");
            int hafa1 = Integer.parseInt(hafa);
            int initial = Integer.parseInt(ini);
            int valiny = Integer.parseInt(valeurApresSecondN);
                for (int i = initial; i <= valiny; i++) {
                int resultat = hafa1 + i;
                String changeString = String.valueOf(resultat);
                int note = Integer.parseInt(etat);
                String fianl = "N00" +changeString;
                        String sql= "insert  into etat_nify_client (idclient,idnify,etat) values(%s,'%s',%s)";
                        sql=sql.format(sql,id, fianl,note);
                        if(conn == null){
                            conn=Connexion.getConnection();
                        }
                        conn.createStatement().executeUpdate(sql);
                //System.out.println("Résultat : " + fianl);
            }

        } else {
          
        }
    }

        }
          

    }


      
      
      
      
    
      
    
    

