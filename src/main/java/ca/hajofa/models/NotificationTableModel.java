package ca.hajofa.models;

import ca.hajofa.entites.ListeNotifications;
import ca.hajofa.entites.Notification;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Cette classe definit le model d'une JTable contenant les notifications.
 * @author JonathanTremblay
 */
public class NotificationTableModel extends AbstractTableModel{

    private String[] columnNames = {"Contenu"};
    
    private ArrayList<Notification> listeNotifications = ListeNotifications.getListeNotifs();
    
    @Override
    public int getRowCount() {
        int size;
        if (listeNotifications == null) {
            size = 0;
        } else {
            size = listeNotifications.size();
        }
        return size;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object tmp = null;
        switch (columnIndex) {
            case 0:
                tmp = listeNotifications.get(rowIndex).toString();
                break;
            default:
                break;
        }
        return tmp;
    }
    
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    public Class getColumnsClass(int col){
        switch (col) {
            default:
                return String.class;
        }
    }
    
    /**
     * Retourne un objet transaction correspondant à la rangée
     * donnée en paramètre
     * @param row
     * @return Notification notificationDeLaRangée
     */
    public Notification getRow(int row){
       final int idEtudiant = 2345;
       String notification = String.valueOf(getValueAt(row,1));
       return new Notification(idEtudiant, notification );
    }
}
