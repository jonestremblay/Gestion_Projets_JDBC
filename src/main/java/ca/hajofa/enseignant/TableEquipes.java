/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.hajofa.enseignant;

import ca.hajofa.entites.Equipe;
import ca.hajofa.entites.Etudiant;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Hasna
 */
public class TableEquipes {

    /**
     *Cette methode sert a remplir le combo box avec la liste des equipe 
     * appartenant a un cours
     * @param liste
     * @param comboBoxCours
     */
    public static void setValeurs(List<Equipe> liste, JComboBox comboBoxCours) {

        for (Equipe equipe : liste) {
            String nom = equipe.getNomEquipe();
            comboBoxCours.addItem(nom);
        }

    }
}
