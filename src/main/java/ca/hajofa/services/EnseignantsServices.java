package ca.hajofa.services;

import ca.hajofa.dao.*;
import ca.hajofa.entites.Enseignant;
import ca.hajofa.jdbc.*;
import java.util.List;

/**
 * Cette classe de services permet de faciliter l'appel des methodes EnseignantDao
 * @author Fatima, Hassna
 */
public class EnseignantsServices {
    
    public static List<Enseignant> GetAllProfs() {
       return new JdbcEnseignantDao().findAll();
    }
    
    public static Enseignant getProfEmail (String email) {
        return new JdbcEnseignantDao().findByEmail(email);
    }
    
    public static boolean createEnseignant (Enseignant prof){
        return new JdbcEnseignantDao().createEnseignant(prof);
    }

    public static List<Enseignant>findByIdProf(int id_prof){
        return new JdbcEnseignantDao().findById(id_prof);
    }
    
    public static boolean updateProf(String courriel,String motpass){
        return new JdbcEnseignantDao().update(courriel,motpass);
    }
}
