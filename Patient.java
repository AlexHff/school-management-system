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
public class Patient extends Inscrit implements Comparable<Patient> {
    
    public Patient(String Nom,String Mail, String NumTel,String mdp){
    super(Nom,Mail,NumTel,mdp);
    }

    @Override
    public int compareTo(Patient p) {
    if (this.Mail.compareTo(p.Mail)>0) return +1;
    else return -1;
    }
    
  

        
    }

