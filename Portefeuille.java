/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Controleur.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
import java.util.Map;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;
//import java.util.Map.Entry;
//import java.util.Set;
/**
 *
 * @author Grouhel
 */
public class Portefeuille {
    public Map<String, Fonds> MapFonds;
    public Map<String, Instrument> MapInstrument;

    public Map<String, Fonds> getMapFonds() {
        return MapFonds;
    }

    public Map<String, Instrument> getMapInstrument() {
        return MapInstrument;
    }
   
    
    public Portefeuille()
    {
        System.out.println("je suis dans constructeur de portefeuille");
        Fonds fond = new Fonds(16);
        MapFonds = new HashMap();
        MapFonds.put("tamere", fond);
        MapInstrument = new HashMap();
    }
    
    public double recherche(String fond) throws FondsInexistant
    {
        System.out.println("je suis dans recherche avec comme para:");
        System.out.println(fond);
            double m_amount;
           if(MapFonds.containsKey(fond) == true)
           {
               m_amount = MapFonds.get(fond).getAmount();
               System.out.println(m_amount);
               return m_amount;
           }
           else {
                  
                   throw new FondsInexistant();
                    
                }
    }
     public ArrayList<Fonds> recherche_instru(String instrument) throws InstruInexistant
    {
           ArrayList<Fonds>fonds_instrument;
           
           if(MapFonds.containsKey(instrument) == true)
           {
               fonds_instrument = MapInstrument.get(instrument).getfonds_instrument();
               return fonds_instrument;
           }
           else {
                   throw new InstruInexistant();
                }
    }
     
      public void add_fond(String fond, double amount) throws FondsExistant
    {      
           if(MapFonds.containsKey(fond) == true)
           {
               throw new FondsExistant();
               
           }
      else {
               // ajout d'un fond dans la map +  instanciation d'un fond avce son montant en para
                MapFonds.put(fond,new Fonds(amount));
                   
            }
    }
      public void add_fond_to_intstru(String instru_key, Fonds fond) 
    {      
        // ajouter un fond à un l'instruement
        MapInstrument.get(instru_key).add_fonds(fond);
          
    }
      public void supp_fond(String fond_key) 
    {      
        double amount;
        // recherche le fond à supprimer
        try{
            amount=recherche( fond_key);
            // supprimer un fond de la hashmap
            MapFonds.remove(fond_key);
        }
        catch(FondsInexistant i){
        
            System.out.println("Fond inexistant");
        }
    }      
}

