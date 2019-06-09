/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_0;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author mgaspar
 */
public class RendezVous {

    @Override
    public String toString() {
        return "RendezVous{" + "horaire=" + horaire + ", MailPatient=" + MailPatient + ", MailPraticien=" + MailPraticien + '}';
    }

     private LocalDateTime horaire;
    private String MailPatient;//mail du patient
    private String MailPraticien;//nom du praticien
   

    public RendezVous(LocalDateTime horaire, String MailPatient, String MailPraticien) {
       
        this.horaire = horaire;
        this.MailPatient = MailPatient;
        this.MailPraticien = MailPraticien;
        
    }
    
  
}
