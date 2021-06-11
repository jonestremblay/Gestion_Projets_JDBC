package ca.hajofa.services;

import ca.hajofa.dao.JdbcProjetDao;
import ca.hajofa.entites.Projet;
import ca.hajofa.etudiant.EtudiantConnecte;
import java.time.LocalDate;
import java.util.List;

/**
 * Cette classe de services permet de faciliter l'appel des methodes ProjetDao
 * @author JonathanTremblay 
 */
public  class ProjetServices {
    public static List<Projet> findAllByIDEtudiant(int idEtudiant){
        return new JdbcProjetDao().findAllProjects(idEtudiant);
    }
    
    public static List<Projet> findAllProjectsByIdEquipe(int idEquipe, int idCours){
         return new JdbcProjetDao().findAllProjectsByIdEquipe(idEquipe, idCours);
     }
     
    public static boolean ajouterNouveauProjet(Projet projet){
         return new JdbcProjetDao().create(projet);
     }
     
    public static boolean modifierProjet(Projet projet, LocalDate dateRemise){
         return new JdbcProjetDao().modifierProjet(projet, dateRemise);
     }
     
    public static LocalDate getDateRemiseProjet(int idProjet){
        return new JdbcProjetDao().getDateRemiseProjet(idProjet);
    }
    
    public static boolean createProjet(Projet projet,String cours,String nomEquipe) {
        return new JdbcProjetDao().create(projet,cours,nomEquipe);
    }
    public static List<Projet> findByCoursProjets(String cours){
        return new JdbcProjetDao().findByCours(cours);
    }
    public static boolean deleteProjet(Projet projet){
        return new JdbcProjetDao().delete(projet);
    }
    
    public static Projet findByIdcoursProjet(String cours,String nomEquipe){
        return new JdbcProjetDao().findByIdCours(cours,nomEquipe);
    }
    
    public static boolean updateProjet(Projet projet){
    return new JdbcProjetDao().update(projet);
    
    }
}
