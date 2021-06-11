/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.hajofa.etudiant;

import ca.hajofa.dao.JdbcNotificationDao;
import ca.hajofa.entites.ListeNotifications;
import java.util.TimerTask;
import ca.hajofa.ui.FenEtudiant;

/**
 * Cette classe definit le TimerTask de notifications, afin que l'affichage
 * des notifications s'actualise chaque X secondes .
 * @author Jonathan Tremblay
 */
public class NotificationUpdater extends TimerTask{

    @Override
    public void run() {
        ListeNotifications.setListeNotifs(new JdbcNotificationDao()
                              .lireNotifications(EtudiantConnecte.idEtudiant));
        FenEtudiant.mettreAJourNotifications();
    }
    
}
