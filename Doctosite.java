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
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author mgaspar
 */
public class Doctosite {

    private String NomSite;

    //Créaion d'une liste de praticiens
    private LinkedList<Praticien> ListePraticiens = new LinkedList();
    //Créaion d'une liste de patient
    private TreeSet<Patient> ListePatients = new TreeSet<>();

    public Doctosite(String NomSite) {
        this.NomSite = NomSite;
    }

    @Override
    public String toString() {
        return "Doctosite{" + "ListePraticiens=" + ListePraticiens + ", ListePatients=" + ListePatients + '}';
    }

    public void SauvfichierListePatients() {
        try {
            FileWriter fich = new FileWriter("NomPatients.txt");

            Iterator<Patient> it = ListePatients.iterator();
            while (it.hasNext() == true) {
                Patient p = it.next();
                fich.write(p.Mail + System.lineSeparator());
            }
            fich.close();

        } catch (IOException ex) {
            System.out.println("Erreur dans la sauvegarde");
        }
    }

    //Méthode d'ajout d'un praticien a la liste de praticien
    public void ajout(String Specialite, int tarif, String adresse, String codepostal, String Nom, String Mail, String NumTel, String mdp) {
        Praticien p = new Praticien(Specialite, tarif, adresse, codepostal, Nom, Mail, NumTel, mdp);
        ListePraticiens.add(p);
        //Création d'un fichier propre au praticien ajouté a la liste
        //  p.versfichier();
    }

    //Méthode d'ajout d'un patient a la liste de patient   
    public void ajout(String Nom, String Mail, String NumTel, String mdp) {
        Patient t = new Patient(Nom, Mail, NumTel, mdp);
        ListePatients.add(t);
        //Création d'un fichier propre au patient ajouté a la liste
        //  t.versfichier();

    }

    public void depuisFichierPatients() throws FileNotFoundException, IOException {
        try (FileReader fich = new FileReader("NomPatients.txt")) {
            BufferedReader br = new BufferedReader(fich);
            String info = br.readLine();//email du patient
            while (info != null) {
                //ouvrir le fichier qui a pour nom info
                FileReader fich2 = new FileReader(info + ".txt");
                BufferedReader br2 = new BufferedReader(fich2);
                String line = br2.readLine();
                String[] tab = line.split(",");
                ajout(tab[0], tab[1], tab[2], tab[3]);
                br2.close();

                info = br.readLine();
            }

            //Fermer le fichier
            br.close();
        }
    }

    public void depuisFichierPraticiens() throws FileNotFoundException, IOException {
        try (FileReader fich3 = new FileReader("NomPraticiens.txt")) {
            BufferedReader br3 = new BufferedReader(fich3);
            String info = br3.readLine();//email du praticien
            while (info != null) {
                //ouvrir le fichier qui a pour nom info
                FileReader fich4 = new FileReader(info + ".txt");
                BufferedReader br4 = new BufferedReader(fich4);
                String line = br4.readLine();
                String[] tab = line.split(",");
                ajout(tab[0], Integer.valueOf(tab[1]), tab[2], tab[3], tab[4], tab[5], tab[6], tab[7]);
                br4.close();

                info = br4.readLine();
            }

            //Fermer le fichier
            br3.close();
        }
    }

//Méthode de recherche multicritères basique
    public void recherchePraticien(String codepostal, String Specialite) {
        Iterator<Praticien> it = ListePraticiens.iterator();
        boolean rep = false;
        while (it.hasNext() == true) {
            Praticien p = it.next();
            if (p.testcodepostal(codepostal) && p.testSpecialite(Specialite)) {
                rep = true;
                System.out.println(p.toString());
            }

        }
        if (!rep) {
            System.out.println("Aucun praticien trouvé");
        }
    }

    //Méthode de recherche multicritères particulière (quand l'utilisateur connait le nom du médecin)
    public void recherchePraticien(String codepostal, String Specialite, String nom) {
        Iterator<Praticien> it = ListePraticiens.iterator();
        boolean rep = false;
        while (it.hasNext() == true) {
            Praticien p = it.next();
            if (p.testcodepostal(codepostal) && p.testSpecialite(Specialite) && p.testNom(nom)) {
                rep = true;
                System.out.println(p.toString());
            }

        }
        if (!rep) {
            System.out.println("Aucun praticien trouvé");
        }

    }

    //Méthode affichant la liste de praticien  
    public void afficherPraticiens() {
        System.out.println(ListePraticiens);
    }

    //Méthode affichant la liste de patient  
    public void afficherPatients() {
        System.out.println(ListePatients);
    }

    public void IdentificationPraticiens(String Mail, String mdp) {

        Iterator<Praticien> it = ListePraticiens.iterator();
        boolean rep = false;
        while (it.hasNext() == true) {
            Praticien p = it.next();
            if (p.testMail(Mail) && p.testmdp(mdp)) {
                rep = true;
                System.out.println("Bienvenue sur lesdocteurs.com");
            }

        }
        if (!rep) {
            System.out.println("Aucun compte trouvé");
        }

    }

    public Praticien recherchePraticien(String mail) {
        Iterator<Praticien> it = ListePraticiens.iterator();
        boolean rep = false;
        while (it.hasNext() == true) {
            Praticien p = it.next();
            if (p.testMail(mail)) {
                return p;
            }
        }
        return null;
    }

    public Patient recherchePatient(String mail) {
        Iterator<Patient> it = ListePatients.iterator();
        boolean rep = false;
        while (it.hasNext() == true) {
            Patient p = it.next();
            if (p.testMail(mail)) {
                return p;
            }
        }
        return null;
    }

    public void prendreRendezVous(String MailPatient, String MailPraticien) {
        //Afficher
        LocalDateTime horaire;
        int year = 2018, month, day, hour, minute=00;
        //demander avec un scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le mois de votre rendez-vous :");
        month = sc.nextInt();
        System.out.println("Veuillez saisir le jour de votre rendez-vous :");
        day = sc.nextInt();
        System.out.println("Veuillez saisir l'heure de votre rendez-vous :");
        hour = sc.nextInt();
        

        horaire = LocalDateTime.of(year, month, day, hour, minute);
        RendezVous r = new RendezVous(horaire, MailPatient, MailPraticien);
        Patient pa;
        pa = recherchePatient(MailPatient);
        pa.ajoutRendezVous(r);

        Praticien pr;
        pr = recherchePraticien(MailPraticien);
        pr.ajoutRendezVous(r);
        System.out.println(pr);
    }

}
