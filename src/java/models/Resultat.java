/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Tmehyg
 */
public class Resultat {
    
    
     private String idnify;
        private int idclient;
        private int coefficient;

        public Resultat(String idnify, int idclient, int coefficient) {
            this.idnify = idnify;
            this.idclient = idclient;
            this.coefficient = coefficient;
        }

        public String getIdnify() {
            return idnify;
        }

        public int getIdclient() {
            return idclient;
        }

        public int getCoefficient() {
            return coefficient;
        }
    
}
