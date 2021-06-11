package ca.hajofa.models;


import ca.hajofa.dao.*;
import ca.hajofa.entites.*;
import ca.hajofa.etudiant.EtudiantConnecte;
import java.util.List;
import javax.swing.AbstractListModel;


/**
 * Cette classe definit le model d'une JList contenant des des etudiants 
 * de la meme equipe.
 * @author JonathanTremblay
 */
public class ListeMembresEquipeModel extends AbstractListModel {
    
    private static List<Etudiant> listeEtudiants = null;
    
    public ListeMembresEquipeModel(int idEquipe){
        listeEtudiants = new JdbcEquipeDao().findTousLesMembresEquipe(idEquipe);
    }
    
    @Override
    public int getSize() {
        return listeEtudiants.size();
    }

    @Override   
    public Object getElementAt(int index) {
        return listeEtudiants.get(index).getNomComplet();
    }
    
    public static void actualiserListeEquipe(int idEquipe){
        listeEtudiants = new JdbcEquipeDao().findTousLesMembresEquipe(idEquipe);
    }
    
    public static List<Etudiant> getListeEquipe(){
        return listeEtudiants;
    }
}
