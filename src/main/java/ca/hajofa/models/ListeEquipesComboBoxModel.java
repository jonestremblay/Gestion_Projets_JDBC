package ca.hajofa.models;

import ca.hajofa.dao.JdbcEquipeDao;
import ca.hajofa.dao.JdbcEtudiantCoursDao;
import ca.hajofa.entites.Cours;
import ca.hajofa.entites.Equipe;
import ca.hajofa.etudiant.EtudiantConnecte;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * Cette classe definit le model d'un combobox contenant des equipes etudiantes.
 * @author JonathanTremblay
 */
public class ListeEquipesComboBoxModel extends AbstractListModel implements ComboBoxModel{
    
    private static List<Equipe> listeEquipes = new ArrayList<>();
    private final static Equipe fausseEquipeDepart = new Equipe();
    private static int idCours;
    
    public ListeEquipesComboBoxModel(){
        /* Ajoute la fausse equipe pour inviter a faire un choix d'equipe */
        fausseEquipeDepart.setNomEquipe("== Choisissez une équipe ==");
        fausseEquipeDepart.setId_Cours(-1);
        listeEquipes.add(fausseEquipeDepart);
        /* Rmepli la liste des equipes selon le contenu de la base de donnes */
        List<Equipe> liste = new JdbcEquipeDao().findAllByIdEtudiant(idCours);
        for (Equipe eq : liste){
            listeEquipes.add(eq);
        }
    }
    
    public ListeEquipesComboBoxModel(int idCours){
        this.idCours = idCours;
         /* Ajoute la fausse equipe pour inviter a faire un choix d'equipe */
         fausseEquipeDepart.setNomEquipe("== Choisissez une équipe ==");
        fausseEquipeDepart.setId_Cours(-1);
        listeEquipes.add(fausseEquipeDepart);
        /* Rmepli la liste des equipes selon le contenu de la base de donnes */
        List<Equipe> liste = new JdbcEquipeDao().findAllByIdEtudiant(idCours);
        for (Equipe eq : liste){
            listeEquipes.add(eq);
        }
    }
    
    String selection = null ;
    @Override
    public int getSize() {
        return listeEquipes.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listeEquipes.get(index).getNomEquipe();
    }
    
    public static void actualiserListeEquipes(int idCours){
        listeEquipes = new JdbcEquipeDao().findAllByIdCours(idCours);
    }
    
    public static void actualiserLesEquipes(int idCours){
        List<Equipe> liste = new JdbcEquipeDao().findAllByIdCours(idCours);
        List<Equipe> listeAvecFausseEquipe = new ArrayList<>();
        listeAvecFausseEquipe.add(fausseEquipeDepart);
        for (Equipe e : liste){
            listeAvecFausseEquipe.add(e);
        }
        listeEquipes = listeAvecFausseEquipe;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }

    public static List<Equipe> getListeCours(){
        return listeEquipes;
    }
}