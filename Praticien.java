/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_0;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



/**
 *
 * @author mgaspar
 */
public class Praticien extends Inscrit{
    private String Specialite;
    private int tarif;
    private String adresse;
    private String codepostal;
    

    public Praticien(String Specialite, int tarif, String adresse, String codepostal, String Nom, String Mail, String NumTel, String mdp) {
        super(Nom, Mail, NumTel, mdp);
        this.Specialite = Specialite;
        this.tarif = tarif;
        this.adresse = adresse;
        this.codepostal = codepostal;
        
    }
     public String versFichier() {
        return super.versFichier()+Specialite+","+tarif+','+adresse+","+codepostal;
    }
    
     
    

    //Méthode testant l'égalité de deux noms
    public boolean testNom(String nom){
        if (this.Nom.equals(nom) == true) {
            return true;
        } else {
            return false;
        }
    }
    
    //Méthode testant l'égalité de deux spécialités
    public boolean testSpecialite(String Specialite){
        if (this.Specialite.equals(Specialite) == true) {
            return true;
        } else {
            return false;
        }
    }
    
    //Méthode testant l'égalité de deux codes postaux
    public boolean testcodepostal(String codepostal){
        if (this.codepostal.equals(codepostal) == true) {
            return true;
        } else {
            return false;
        }
    }
    
    
    
 
}
 