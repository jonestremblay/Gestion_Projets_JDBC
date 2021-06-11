package ca.hajofa.services;

import ca.hajofa.dao.JdbcCoursDao;
import ca.hajofa.dao.JdbcEnseignantDao;
import ca.hajofa.entites.Cours;
import ca.hajofa.entites.Enseignant;
import java.util.List;

/**
 * Cette classe de services permet de faciliter l'appel des methodes CoursDao
 * @author Hassna , JonathanTremblay, Fatima
 */
public class CoursServices {

    public static List<Cours> getAllCours() {
        return new JdbcCoursDao().findAll();
    }

    public static boolean createCours(Cours cours, String courriel) {
        return new JdbcCoursDao().create(cours, courriel);
    }
    
     public static boolean deleteCours(Cours cours){
        return new JdbcCoursDao().delete(cours);
    }
    
    public static List<Cours> findByEmailCours(String courrielProf){
        return new JdbcCoursDao().findByEmail(courrielProf);
    }
    public static int findIdCours(List<Cours>  liste,String cours){
        return new JdbcCoursDao().findIdCours(liste,cours);
    }
    
    public static Cours findByCleCours(String cleCours){
        return new JdbcCoursDao().findByCle(cleCours);
    }
    
    public static int findIdCoursByTitre(String titre){
        return new JdbcCoursDao().findIdCoursByTitre(titre);
    }
    
    public static String findTitreCoursByNomEquipe(String nomEquipe){
        return new JdbcCoursDao().findTitreCoursByNomEquipe(nomEquipe);
    }
}
