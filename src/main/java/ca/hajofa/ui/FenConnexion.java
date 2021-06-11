/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.hajofa.ui;

import ca.hajofa.dao.*;
import ca.hajofa.enseignant.EnseignantConnecte;
import ca.hajofa.jdbc.Database;
import ca.hajofa.entites.*;
import ca.hajofa.etudiant.EtudiantConnecte;
import ca.hajofa.services.EtudiantsServices;
import ca.hajofa.services.EnseignantsServices;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author fatima
 */
public class FenConnexion extends javax.swing.JFrame {

    //genere la liste prof
    String modeConnexion;
    List<Enseignant> listeProfs = EnseignantsServices.GetAllProfs();
    //generer la liste etudiants
    List<Etudiant> listeEtudiants = EtudiantsServices.GetAllEtudiants();

    public FenConnexion() {
        initComponents();
        modeConnexion = "";
        this.getRootPane().setDefaultButton(btnConnexion);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnEtudiant = new javax.swing.JButton();
        btnProf = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnConnexion = new javax.swing.JButton();
        lblPremiere = new javax.swing.JLabel();
        txtMdp = new javax.swing.JPasswordField();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(37, 83, 158));
        jPanel1.setForeground(new java.awt.Color(37, 83, 158));

        jLabel1.setFont(new java.awt.Font("Bradley Hand ITC", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestion des projets");

        jLabel6.setFont(new java.awt.Font("Bradley Hand ITC", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Connexion");

        btnEtudiant.setText("Étudiant");
        btnEtudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEtudiantActionPerformed(evt);
            }
        });

        btnProf.setText("Enseignant");
        btnProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mot de passe");

        lblEmail.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Courrier électronique");

        txtEmail.setEnabled(false);

        btnConnexion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnConnexion.setText("Connexion");
        btnConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnexionActionPerformed(evt);
            }
        });

        lblPremiere.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPremiere.setForeground(new java.awt.Color(255, 255, 255));
        lblPremiere.setText("Première utilisation ? Enregistrez-vous!");
        lblPremiere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPremiereMouseClicked(evt);
            }
        });

        txtMdp.setEnabled(false);

        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ideas.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(label)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(lblPremiere))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMdp, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEmail))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(btnConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(btnProf, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)))
                        .addContainerGap(27, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEtudiant)
                    .addComponent(btnProf))
                .addGap(37, 37, 37)
                .addComponent(lblEmail)
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPremiere, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnexionActionPerformed
        //verifier les champs
        switch (modeConnexion) {
            case "Etudiant":
                verifierChampsEtudiant();
                break;
            case "Enseignant":
                verifierChampsEnseignant();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Vous devez choisir un type"
                        + " de compte!", "Oups", JOptionPane.ERROR_MESSAGE);
                break;
        }

    }//GEN-LAST:event_btnConnexionActionPerformed

    private void btnEtudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEtudiantActionPerformed
        /* verifier si le button etudiant est selectionner
        si oui donc se conencter en tant que etudiant*/
        if (btnEtudiant.isEnabled()) {
            txtEmail.setEnabled(true);
            txtMdp.setEnabled(true);
            lblEmail.setText("Courrier électronique étudiant");
            modeConnexion = "Etudiant";
        }
    }//GEN-LAST:event_btnEtudiantActionPerformed

    private void lblPremiereMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPremiereMouseClicked
        ouvrirFenetreInscription();
    }//GEN-LAST:event_lblPremiereMouseClicked

    private void btnProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfActionPerformed
        /* verifier si le button enseignant est selectionner
        si oui donc se conencter en tant que enseignant*/
        if (btnProf.isEnabled()) {
            txtEmail.setEnabled(true);
            txtMdp.setEnabled(true);
            lblEmail.setText("Courrier électronique enseignant");
            modeConnexion = "Enseignant";

        }
    }//GEN-LAST:event_btnProfActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnexion;
    private javax.swing.JButton btnEtudiant;
    private javax.swing.JButton btnProf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPremiere;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtMdp;
    // End of variables declaration//GEN-END:variables

    private void verifierChampsEnseignant() {
        //objet prof
        Enseignant prof = new Enseignant();
        //attribut
        String email = txtEmail.getText();
        //stock valeur email dans objet prof
        prof = EnseignantsServices.getProfEmail(email);
        if (verifierChamps()) {
            if (email.equals(prof.getEmail()) && txtMdp.getText().equals(prof.getPasswd())) {

                EnseignantConnecte.idEnseignant = prof.getId_Enseignant();
                EnseignantConnecte.courriel = prof.getEmail();
               //Acces a la connexion de la fenetre profs
                ouvrirFenetreEnseignant();
            } else {
                //afficher un message d'erreur 
                JOptionPane.showMessageDialog(null, "Entree invalide.Veuillez recommencez",
                        "Invalide", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println(prof);
        }
    }

    private void verifierChampsEtudiant() {
        //objet etudiant
        Etudiant etudiant = new Etudiant();
        //attribut
        String email = txtEmail.getText();
        //stock valeur de mail dans objet etudiant
        etudiant = EtudiantsServices.getEtudiantByEmail(email);
        if (verifierChamps()) {
            if (email.equals(etudiant.getEmail()) && txtMdp.getText().equals(etudiant.getPasswd())) {
                EtudiantConnecte.idEtudiant = etudiant.getId_Etudiant();
                EtudiantConnecte.courriel = etudiant.getEmail();
                //Acces a la connexion de la fenetre profs
                ouvrirFenetreEtudiant();
            } else {
                //afficher un message d'erreur 
                JOptionPane.showMessageDialog(null, "Entree invalide.Veuillez recommencez",
                        "Invalide", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     *La methode verifierChamo permet valider les champs
     * 
     * @return
     */
    private boolean verifierChamps() {
        boolean flag = true;
        if (txtEmail.getText().isEmpty() || txtMdp.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs!",
                    "Invalide", JOptionPane.ERROR_MESSAGE);
            return flag = false;
        }
        return flag;
    }
    
     /**
     *La methode ouvrirFenetreEtudiant permet d'ouvrir la fenetre etudiant
     * 
     * @return
     */
    private void ouvrirFenetreEtudiant() {
        FenEtudiant fenEtudiant = new FenEtudiant();
        fenEtudiant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenEtudiant.setVisible(true);
        this.dispose();
    }
    
    /**
     *La methode ouvrirFenetreEnseignant permet d'ouvrir la fenetre enseignant
     * 
     * @return
     */
    private void ouvrirFenetreEnseignant() {
        FenEnseignant fenEnseignant = new FenEnseignant();
        fenEnseignant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenEnseignant.setVisible(true);
        this.dispose();
    }
    
    /**
     *La methode ouvrirFenetreInscriptionpermet d'ouvrir la fenetre inscription
     * 
     * @return
     */
    private void ouvrirFenetreInscription() {
        FenInscription fenInscription = new FenInscription();
        fenInscription.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenInscription.setVisible(true);
        this.dispose();
    }
}
