package ca.hajofa.dao;

import ca.hajofa.entites.Equipe;
import ca.hajofa.entites.Projet;
import ca.hajofa.jdbc.Database;
import ca.hajofa.services.CoursServices;
import ca.hajofa.services.EquipeServices;
import ca.hajofa.services.ProjetServices;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author JonathanTremblay, Fatima, Hassna
 */
public class JdbcProjetDao implements ProjetDao{

    /**
     * Trouve tous les projets associe a l'etudiant donne en parametre
     * @param idEtudiant etudiant recherche
     * @return listeProjets
     */
    @Override
    public List<Projet> findAllProjects(int idEtudiant) {
        ArrayList<Projet> listeProjets  = new ArrayList<>();
        String requete = "SELECT * FROM Projets p JOIN EquipeEtudiante ee ON"
                + " (p.ID_Equipe=ee.ID_Equipe) WHERE ee.ID_Etudiant = ?";
        Connection cnx = null;
        PreparedStatement prepStm = null;
        ResultSet res = null;
        
        try {
            cnx = Database.getConnexion();
            prepStm = cnx.prepareStatement(requete);
            prepStm.setInt(1, idEtudiant);
            res = prepStm.executeQuery();
           
            while(res.next()){
                int idProjet = Integer.parseInt(res.getString("ID_Projet"));
                int idCours = Integer.parseInt(res.getString("ID_Cours"));
                int idEquipe = res.getInt("ID_Equipe");
                String titre = res.getString("titre");
                String description = res.getString("aPropos");
                LocalDate dateRemise = ProjetServices.getDateRemiseProjet(idProjet);
                listeProjets.add(new Projet(idProjet, titre, description, 
                        idCours, idEquipe, dateRemise));
            }
            return listeProjets;
        } catch (SQLException ex){
            Logger.getLogger(JdbcProjetDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        Database.close();
        return listeProjets;   
    }

    /**
     * Cree un nouveau projet dans la base de donnee
     * @param projet
     * @return true si le projet a ete cree
     */
    @Override
    public boolean create(Projet projet) {
        boolean projetCree = false;

        final String requete = "INSERT INTO Projets (titre, aPropos, dateRemise,"
                             + " ID_Cours, ID_Equipe) VALUES (?, ?, ?, ?, ?)";
        Connection cnx = Database.getConnexion();
        PreparedStatement prepStm = null;
        try {
            prepStm = cnx.prepareStatement(requete);
            prepStm.setString(1, projet.getTitre());
            prepStm.setString(2, projet.getDescription());
            Date date = null;
            try {
                date = Date.valueOf(projet.getDateRemiseLocalDate());
            } catch (NullPointerException npe){}
            prepStm.setDate(3, date);
            prepStm.setInt(4, projet.getId_Cours());
            prepStm.setInt(5, projet.getId_Equipe());
            
            if(prepStm.executeUpdate() > 0){
                projetCree = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcEtudiantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Database.close();

        return projetCree;
    }
    
    /**
     *La methode delete permet de supprimer un projet
     * @param projet
     * @return
     */
    @Override
    public boolean delete(Projet projet) {
        String requete = "DELETE FROM Projets WHERE ID_Projet=?";

        Connection cnx = Database.getConnexion();
        if (cnx == null) {
            return false;
        }
        try (
                PreparedStatement stm = cnx.prepareStatement(requete);) {
            stm.setInt(1, projet.getId_Projet());
            int n = stm.executeUpdate();
            return n > 0;
        } catch (SQLException ex) {
            Logger.getLogger(JdbcEtudiantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Database.close();
        return false;
    }
    
    /**
     *La methode update permet de modifier un projet 
     * @param projet
     * @return
     */
    @Override
    public boolean update(Projet projet) {
        String requete = "UPDATE Projets SET titre=? ,aPropos=? ,dateRemise=?  WHERE ID_Projet=?";

        Connection cnx = Database.getConnexion();
        if (cnx==null) {
            return false;
        }
        try (
            PreparedStatement stm = cnx.prepareStatement(requete);
        ){
            stm.setString(1,projet.getTitre());
            stm.setString(2,projet.getDescription());
            stm.setString(3,projet.getDateRemise());
            stm.setInt(4,projet.getId_Projet());
            int n = stm.executeUpdate();
            return n>0;            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcEtudiantDao.class.getName()).log(Level.SEVERE, null, ex);
        }     
        Database.close();
        return false;
    }

    /**
     * Permet de recuperer les projets associés a une equipe d'un cours
     * @param idEquipe
     * @param idCours
     * @return
     */
    @Override
    public List<Projet> findAllProjectsByIdEquipe(int idEquipe, int idCours) {
        ArrayList<Projet> listeProjets  = new ArrayList<>();
        String requete = "SELECT * FROM Projets p WHERE ID_Equipe = ? "
                        + " AND ID_Cours = ?";
        Connection cnx = null;
        PreparedStatement prepStm = null;
        ResultSet res = null;
        LocalDate dateRemise = null;
        String description = null;
        try {
            cnx = Database.getConnexion();
            prepStm = cnx.prepareStatement(requete);
            prepStm.setInt(1, idEquipe);
            prepStm.setInt(2, idCours);
            res = prepStm.executeQuery();
            while(res.next()){
                int idProjet = res.getInt("ID_Projet");
                String titre = res.getString("titre");
                try {
                    dateRemise = res.getDate("dateRemise").toLocalDate(); // return SQL formatted date
                    description = res.getString("aPropos");
                } catch (NullPointerException npe){
                    Logger.getLogger(JdbcProjetDao.class.getName()).log(Level.SEVERE, null, npe);
                }
                listeProjets.add(new Projet(idProjet, titre, description, 
                        idCours, idEquipe, dateRemise));
            }
            return listeProjets;
        } catch (SQLException ex){
            Logger.getLogger(JdbcProjetDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        Database.close();
        return listeProjets;   
    }

    /**
     * Permet de modifier un projet donnee en parametre, dans la base de donnee
     * @param projet 
     * @param dateRemise peut etre null
     * @return
     */
    @Override
    public boolean modifierProjet(Projet projet, LocalDate dateRemise) {
        boolean projetModifier = false;
        final String requete = "UPDATE Projets SET titre = ? , aPropos = ? , "
                            + "dateRemise = ? WHERE ID_Projet=?";
        Connection cnx = Database.getConnexion();
        PreparedStatement prepStm = null;
        String description = null;
        try {
            prepStm = cnx.prepareStatement(requete);
            prepStm.setString(1, projet.getTitre());
            try {
                description = projet.getDescription();
            } catch (NullPointerException npe){
                Logger.getLogger(JdbcProjetDao.class.getName()).log(Level.SEVERE, null, npe);
            }
            prepStm.setString(2, description);
            prepStm.setDate(3, Date.valueOf(dateRemise));
            prepStm.setInt(4, projet.getId_Projet());
            
            if(prepStm.executeUpdate() > 0){
                projetModifier = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcProjetDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Database.close();
        return projetModifier;
    }
    
    /**
     * Permet d'obtenir la date de remise d'un projet, grace au idProjet.
     * @param idProjet
     * @return
     */
    @Override
    public LocalDate getDateRemiseProjet(int idProjet) {
        String requete = "SELECT dateRemise FROM Projets p WHERE ID_Projet = ? ";
        Connection cnx = null;
        PreparedStatement prepStm = null;
        ResultSet res = null;
        LocalDate dateRemise = null;
        try {
            cnx = Database.getConnexion();
            prepStm = cnx.prepareStatement(requete);
            prepStm.setInt(1, idProjet);
            res = prepStm.executeQuery();
            while(res.next()){
                dateRemise = res.getDate("dateRemise").toLocalDate();
            }
            return dateRemise;
        } catch (SQLException ex){
            Logger.getLogger(JdbcProjetDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        Database.close();
        return dateRemise;   
    }

    /**
     * Permet d'obtenir le projet selon le id de l'equipe associe
     * @param idEquipe
     * @return
     */
    @Override
    public Projet getProjetByIdEquipe(int idEquipe) {
        String requete = "SELECT * FROM Projets p WHERE ID_Equipe = ? ";
        Connection cnx = null;
        PreparedStatement prepStm = null;
        ResultSet res = null;
        Projet projet = new Projet();
        try {
            cnx = Database.getConnexion();
            prepStm = cnx.prepareStatement(requete);
            prepStm.setInt(1, idEquipe);
            res = prepStm.executeQuery();
            while(res.next()){
                int idProjet = res.getInt("ID_Projet");
                String titre = res.getString("titre");
                projet.setTitre(titre);
                projet.setId_Projet(idProjet);
            }
            return projet;
        } catch (SQLException ex){
            Logger.getLogger(JdbcProjetDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        Database.close();
        return projet;   
    }
    
    /**
     *La methode create permet de creer un projet
     * @param projet
     * @param cours
     * @param nomEquipe
     * @return
     */
    @Override
    public boolean create(Projet projet, String cours, String nomEquipe) {
        boolean cree = false;
        int idCours = CoursServices.findIdCours(CoursServices.getAllCours(), cours);

        Equipe equipe = EquipeServices.findEquipeByIdNOm(idCours, nomEquipe);

        String requete = "INSERT INTO Projets (titre,aPropos,dateRemise,"
                + "ID_Cours,ID_Equipe) VALUES(?,?,?,?,?)";

        Connection cnx = Database.getConnexion();
        if (findByEquipe(nomEquipe).size() <= 0) {
            try (
                    PreparedStatement stm = cnx.prepareStatement(requete);) {
                stm.setString(1, projet.getTitre());
                stm.setString(2, projet.getDescription());
                stm.setString(3, projet.getDateRemise());
                stm.setInt(4, idCours);
                stm.setInt(5, equipe.getId_Equipe());
                stm.executeUpdate();
                cree = true;
            } catch (SQLException ex) {
                Logger.getLogger(JdbcEtudiantDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            Database.close();
        } else {
            JOptionPane.showMessageDialog(null, "Cette equipe a déjà un projet",
                    "Projet",
                    JOptionPane.ERROR_MESSAGE);
        }

        return cree;
    }
    
    /**
     *La methode findByIdCours permet de chercher un projet par le id du cours
     * @param cours
     * @param nomEquipe
     * @return
     */
    @Override
    public Projet findByIdCours(String cours, String nomEquipe) {
        Projet projet = new Projet();
        int idCours = CoursServices.findIdCours(CoursServices.getAllCours(),
                cours);
       
        int idEquipe = (EquipeServices.findEquipeByIdNOm(idCours, nomEquipe)).getId_Equipe();
        
        
        String requete = "SELECT * FROM Projets  WHERE ID_Cours=? AND ID_Equipe=?";
        PreparedStatement stm;
        Connection cnx = Database.getConnexion();

        try {
            stm = cnx.prepareStatement(requete);
            stm.setInt(1, idCours);
            stm.setInt(2, idEquipe);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                
                

                projet.setId_Projet(rs.getInt("ID_Projet"));
                projet.setTitre(rs.getString("titre"));
                projet.setId_Equipe(rs.getInt("ID_Equipe"));
                projet.setDateRemise(rs.getString("dateRemise"));
                projet.setDescription(rs.getString("aPropos"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcEquipeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return projet;
    }
    
    /**
     *La methode findByCours permet de chercher la liste des projets existant dans un cours
     * @param cours
     * @return
     */
    @Override
    public List<Projet> findByCours(String cours) {
        List<Projet> liste = new ArrayList<>();
        Projet projet;
        String requete = "SELECT * FROM Projets p JOIN Cours c "
                + "ON (p.ID_Cours = c.ID_Cours) WHERE c.aPropos =?";
        Connection cnx = Database.getConnexion();

        try (
                PreparedStatement stm = cnx.prepareStatement(requete);) {
            stm.setString(1, cours);
            ResultSet res = stm.executeQuery();
            while (res.next()) {
                projet = new Projet();
                projet.setId_Projet(res.getInt("ID_Projet"));
                projet.setTitre(res.getString("titre"));
                projet.setDateRemise(res.getString("dateRemise"));
                projet.setDescription(res.getString("aPropos"));

                liste.add(projet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcEtudiantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Database.close();
        return liste;
    }
    
    /**
     *La methode findByEquipe permet de chercher la liste des projets des equipe
     * @param nomEquipe
     * @return
     */
    public List<Projet> findByEquipe(String nomEquipe) {

        List<Projet> listeProjet = new ArrayList<>();
        String requete = "SELECT * FROM Projets p JOIN Equipes e ON(p.ID_Equipe=e.ID_Equipe) WHERE nomEquipe=?";
        PreparedStatement stm;
        Connection cnx = Database.getConnexion();

        try {
            stm = cnx.prepareStatement(requete);
            stm.setString(1, nomEquipe);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Projet projet = new Projet();
                projet.setTitre(rs.getString("titre"));
                projet.setId_Equipe(rs.getInt("ID_Equipe"));
                projet.setDateRemise(rs.getString("dateRemise"));
                listeProjet.add(projet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcEquipeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listeProjet;
    }
}
