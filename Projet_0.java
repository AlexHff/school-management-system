/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_0;

/**
 *
 * @author mgaspar
 */
public class Projet_0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Création du site "lesdocteurs"
       Doctosite lesdocteurs= new Doctosite("lesdocteurs");
       // System.out.println(lesdocteurs.toString());
        
        //Création d'un inscrit afin de verifier que la méthode vers fichier fonctionne et crée bien un fichier par inscrit
       //Inscrit i1= new Inscrit("Marine","marine.gaspar@epfedu.fr","0625154585","motdepasse");
       //i1.versfichier();
       
       //Création de praticiens afin de tester la méthode d'ajout d'un praticien a la liste de praticiens
      lesdocteurs.ajout("Généraliste",20, "7 rue des roses", "92330", "Dupont", "michel.dupont@gmail.com", "0123457689", "MichelD");
      lesdocteurs.ajout("Pédiatre",35, "19 rue Diderot", "92330", "Laurent", "jean.laurent@gmail.com", "0109124673", "Jeanll");
      lesdocteurs.ajout("Généraliste",22, "51 rue de Bretagne", "92330", "Dupont", "fanny.dupont@gmail.com", "0124560258", "FannyD");
      
      lesdocteurs.ajout("patient1", "patient1@mail.com", "010101101", "rien");
      lesdocteurs.ajout("patient0", "patient0@mail.com", "010101101", "rien");
      //lesdocteurs.SauvfichierListePatients();
      
      //lesdocteurs.IdentificationPraticiens("fanny.dupont@gmail.com","FannyD");
      lesdocteurs.prendreRendezVous("patient1@mail.com", "jean.laurent@gmail.com");
      
      //Teste de la méthode recherche praticien dans le cas ou le patient renseigne le code postal, la spécialité ainsi que le nom du praticien
       //lesdocteurs.recherchePraticien("92330","Généraliste","Dupont");
       
       //Teste des méyhode d'affichage des listes de patients et de practiciens
       //lesdocteurs.afficherPraticiens();
       //lesdocteurs.afficherPatients();
     
    }
    
}
