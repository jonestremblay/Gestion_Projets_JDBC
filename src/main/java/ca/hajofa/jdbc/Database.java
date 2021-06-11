/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.hajofa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hasna
 */
public class Database {
    private static Connection cnx = null;
    
    
    private static String pilote = "com.mysql.cj.jdbc.Driver",
                url = "jdbc:mysql://db.jonesdb.me/gestion_Projets_TP1?serverTimezone=UTC",
                user = "profbdeb",
                password = "bdeb";
    
    public static Connection getConnexion() {
        try {
            if (cnx==null || cnx.isClosed()) {
                cnx = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnx;
    }

    public static void setUrl(String url) {
        Database.url = url;
    }

    public static void setUser(String user) {
        Database.user = user;
    }

    public static void setPassword(String password) {
        Database.password = password;
    }
    public static boolean loadDriver(String pilote) {
        try {
            Class.forName(pilote);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    } 
    public static void close() {
        if (cnx!=null) {
            try {
                cnx.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
