/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.hajofa.dao;

import ca.hajofa.jdbc.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonat
 */
public class JdbcEquipeEtudianteDao implements EquipeEtudianteDao {

    @Override
    public boolean ajouterEtudiantDansEquipe(int idEquipe, int idEtudiant_toAdd) {
        Connection cnx = null;
        PreparedStatement prepStm = null;
        String requete = "INSERT INTO EquipeEtudiante VALUES (?, ?)";
        boolean equipeAjoute = false;
        try {
            cnx = Database.getConnexion();
            prepStm = cnx.prepareStatement(requete);
            prepStm.setInt(1, idEquipe);
            prepStm.setInt(2, idEtudiant_toAdd);
            if(prepStm.executeUpdate() > 0){
                equipeAjoute = true;
            }
            return equipeAjoute;
        } catch (SQLException ex){
            Logger.getLogger(JdbcEquipeDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        Database.close();
        return equipeAjoute;
    }
    
}
