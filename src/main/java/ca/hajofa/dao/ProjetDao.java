package ca.hajofa.dao;


import ca.hajofa.entites.Projet;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Hassna, JonathanTremblay, Fatima
 */
public interface ProjetDao {
    public List<Projet> findAllProjects(int idEtudiant);
    public boolean create(Projet projet);
    public boolean create(Projet projet,String cours,String nomEquipe);
    public boolean delete(Projet projet);
    public boolean update(Projet projet);
    public List<Projet> findAllProjectsByIdEquipe(int idEquipe, int idCours);
    public Projet findByIdCours(String cours,String nomEquipe);
    public List<Projet> findByCours(String cours);
    public boolean modifierProjet(Projet projet, LocalDate dateRemise);
    public LocalDate getDateRemiseProjet(int idProjet);
    public Projet getProjetByIdEquipe(int idEquipe);
}
