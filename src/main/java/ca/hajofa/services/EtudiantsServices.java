package ca.hajofa.services;

import ca.hajofa.dao.*;
import ca.hajofa.entites.Etudiant;
import ca.hajofa.entites.EtudiantCours;
import ca.hajofa.etudiant.EtudiantConnecte;
import java.util.List;

/**
 * Cette classe de services permet de faciliter l'appel des methodes EtudiantDao
 * @author Fatima, JonathanTremblay, Hassna
 */
public class EtudiantsServices {

    public static List<Etudiant> GetAllEtudiants() {
       return new JdbcEtudiantDao().findAll();
    }
    
    public static Etudiant getEtudiantByEmail (String email) {
        return new JdbcEtudiantDao().findByEmail(email);
    }
     
    public static boolean createEtudiant(Etudiant etudiant){
         return new JdbcEtudiantDao().createEtudiant(etudiant);
    }

    public static boolean createEtudiant(Etudiant etudiant,String cours){
        return new JdbcEtudiantDao().create(etudiant, cours);
    }
    

    public static List<Etudiant> findByCoursEtudiant(String cours){
        return new JdbcEtudiantDao().findByCours(cours);
    }

    public static Etudiant findByEmailEtudiant(String email){
        return new JdbcEtudiantDao().findByEmail(email);
    }
    
    public static Etudiant getEtudiantEmail (String email) {
            return new JdbcEtudiantDao().findByEmail(email);
    }
    
    public static int find_last_idEquipe_genere(){
        return new JdbcEtudiantDao().find_last_idEquipe_genere();
    }
    
    public static List<Etudiant> findByEquipeEtudiants(String nomEquipe,String cours){
        return new JdbcEtudiantDao().findByEquipe(nomEquipe,cours);
    }
    
    /**
     * Verifie si l'etudiant connecte fais deja parti d'une equipe dans le
     * cours donne en parametres.
     * @param coursSelectionne
     * @return estDejaEnEquipeDansCours{true, false}
     */
    public static boolean verifierSiEtudiantConnecteDejaEnEquipe(String coursSelectionne){
        boolean estDejaEnEquipeDansCours = false;
        /* Verifie s'il a deja une equipe dans ce cours
           Si c'est le cas, findMembreEnEquipeByTitreCours() retournera null */
        int idCours = CoursServices.findIdCoursByTitre(coursSelectionne);
        EtudiantCours etudiantCours = new JdbcEquipeDao().findMembreEnEquipeByCours(EtudiantConnecte.idEtudiant, idCours);
        if (etudiantCours != null){
            estDejaEnEquipeDansCours = true;
        } else {
            estDejaEnEquipeDansCours = false; 
        }
        return estDejaEnEquipeDansCours;
    }
    
    /**
     * Verifie si l'etudiant donne en parametre fais deja parti d'une equipe 
     * dans le cours donne en parametres.
     * @param idEtudiant
     * @param coursSelectionne
     * @return estDejaEnEquipeDansCours{true, false}
     */
    public static boolean verifierSiEtudiantDejaEnEquipe(int idEtudiant, String coursSelectionne){
        boolean estDejaEnEquipeDansCours = false;
        /* Verifie s'il a deja une equipe dans ce cours
           Si c'est le cas, findMembreEnEquipeByTitreCours() retournera null */
        int idCours = CoursServices.findIdCoursByTitre(coursSelectionne);
        EtudiantCours etudiantCours = new JdbcEquipeDao().findMembreEnEquipeByCours(idEtudiant, idCours);
        if (etudiantCours != null){
            estDejaEnEquipeDansCours = true;
        } else {
            estDejaEnEquipeDansCours = false; 
        }
        return estDejaEnEquipeDansCours;
    }
    
    public static Etudiant getEtudiantCompletById(int idEtudiant){
        return new JdbcEtudiantDao().getEtudiantCompletById(idEtudiant);
    }
    
    public static boolean modifierMotPasse(int idEtudiant, String nouveauMotPasse){
        return new JdbcEtudiantDao().modifierMotPasse(idEtudiant, nouveauMotPasse);
    }
}

