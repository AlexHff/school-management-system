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
import java.util.Iterator;
import java.util.LinkedList;



/**
 *
 * @author mgaspar
 */
public class Inscrit {
    protected String Nom;
    protected String Mail;
    protected String NumTel;
    protected String mdp;
    protected LinkedList<RendezVous> agenda=new LinkedList<>();

    public Inscrit(String Nom, String Mail, String NumTel, String mdp) {
        this.Nom = Nom;
        this.Mail = Mail;
        this.NumTel = NumTel;
        this.mdp = mdp;
    }

    public void ajoutRendezVous(RendezVous r){
        agenda.add(r);
    }
    @Override
    public String toString() {
        return "Inscrit{" + "Nom=" + Nom + ", Mail=" + Mail + ", NumTel=" + NumTel + "Agenda" + agenda+'}';
    }
    public String versFichier() {
        return Nom +","+ Mail + NumTel+","+mdp;
    }
    
  
    //Méthode permettant d'écrire dans le fichier de l'inscrit ses attributs
      public void Sauvfichier()   {
        try (FileWriter fich = new FileWriter(this.Mail+".txt")) {
            
                fich.write(versFichier() );
               
                fich.close();
           
        }catch(IOException ex){
            System.out.println("Erreur dans la sauvegarde");
        }
}
      public void depuisFichier() throws FileNotFoundException, IOException{
        
        }
    
    public boolean testMail(String Mail){
        if (this.Mail.equals(Mail) == true) {
            return true;
        } else {
            return false;
        }
    }
    public boolean testmdp(String mdp){
        if (this.mdp.equals(mdp) == true) {
            return true;
        } else {
            return false;
        }
    }
    
  }

