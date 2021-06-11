package ca.hajofa.services;

import ca.hajofa.dao.*;
import ca.hajofa.entites.Equipe;
import java.util.List;

/**
 * Cette classe de services permet de faciliter l'appel des methodes EquipesDao
 * @author JonathanTremblay, Hassna, Fatima
 */
public class EquipesServices {
    
    public static boolean creerEquipe(Equipe equipe){
        return new JdbcEquipeDao().create(equipe);
    }
    
    public static boolean ajouterEtudiantDansEquipe(
            int idEquipe, int idEtudiant_toAdd){
        return new JdbcEquipeEtudianteDao().ajouterEtudiantDansEquipe(
                idEquipe, idEtudiant_toAdd);
    }
    
    public static int find_ID_Equipe(String nomEquipe, int idCours){
        return new JdbcEquipeDao().find_ID_Equipe_ByNomEquipeAndCours(nomEquipe, idCours);
    }
    
    public static String findNomEquipe(int idCours, int idEtudiant){
        return new JdbcEquipeDao().find_NomEquipe_ByIdCoursEtudiant(idCours, idEtudiant);
    }
    
    public static List<Equipe> findAllEquipesByIdCours(int idCours){
        return new JdbcEquipeDao().findAllByIdCours(idCours);
    }
}
