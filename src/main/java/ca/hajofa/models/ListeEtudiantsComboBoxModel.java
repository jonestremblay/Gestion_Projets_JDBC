package ca.hajofa.models;

import ca.hajofa.dao.*;
import ca.hajofa.entites.*;
import ca.hajofa.etudiant.EtudiantConnecte;
import ca.hajofa.ui.FenEtudiant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * Cette classe definit le model d'un combobox ayant des etudiants.
 * @author jonat
 */
public class ListeEtudiantsComboBoxModel extends AbstractListModel implements ComboBoxModel{
    
    final static String NOM_FAUX_ETUDIANT_DEPART = "== Quel étudiant(e) ? ==";
    final private static Etudiant fauxEtudiantDepart = new Etudiant(NOM_FAUX_ETUDIANT_DEPART);
    private static List<Etudiant> listeEtudiants = new ArrayList<>();
    String selection = null ;

    
    public ListeEtudiantsComboBoxModel(int idCours){
        listeEtudiants.clear();
        /* Ajoute le faux cours pour inviter a faire un choix */
        fauxEtudiantDepart.setNomComplet(NOM_FAUX_ETUDIANT_DEPART);
        listeEtudiants.add(fauxEtudiantDepart);
        /* Rempli la liste selon le contenu de la base de donnees */
        List<Etudiant> liste =  new JdbcEtudiantDao().findByIDCours(idCours);
        for (Etudiant e : liste){
            listeEtudiants.add(e);
        }
    }

    public static List<Etudiant> getListeEtudiants() {
        return listeEtudiants;
    }

    public static void setListeEtudiants(List<Etudiant> listeEtudiants) {
        ListeEtudiantsComboBoxModel.listeEtudiants = listeEtudiants;
    }
   
    @Override
    public int getSize() {
        return listeEtudiants.size();
    }

    @Override
    public Object getElementAt(int index) {
        Etudiant etudiant = listeEtudiants.get(index);
        /* Retourne seulement le nomComplet si c'est le premier index 
                "== Quel étudiant(e) ? =="     */
        if (etudiant.getNomComplet().equals(NOM_FAUX_ETUDIANT_DEPART)){
            return etudiant.getNomComplet();
        }
        return etudiant.getNomComplet() + " [" + etudiant.getId_Etudiant() + "]";
    }
    
    public static void actualiserListeEtudiant(int idCours){
        listeEtudiants = new JdbcEtudiantDao().findByIDCours(idCours);
    }
    
    public static List<Etudiant> getListeEtudiantAJour(int idCours){
        return new JdbcEtudiantDao().findByIDCours(idCours);
    }
    
    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }

     
}
