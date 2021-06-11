package ca.hajofa.control;
import ca.hajofa.entites.Etudiant;
import ca.hajofa.ui.*;
import javax.swing.JFrame;


public class AppCtr {
    public static void main(String[] args) {
          FenConnexion fenCnx = new FenConnexion();
          fenCnx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          fenCnx.setVisible(true);
    }
}
