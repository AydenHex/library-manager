package com.views;

import javax.swing.table.AbstractTableModel;

import com.models.Bibliotheque;

public class Table extends AbstractTableModel {
     private Bibliotheque bibliotheque;
     private static final long serialVersionUID = 1L;

    private final String[] entetes = {"Titre", "Auteur","Année","Rangée","Colonne"};

    public Table(Bibliotheque bibliotheque) {
        super();
        this.bibliotheque = bibliotheque;

    }

    public int getRowCount() {
        return this.bibliotheque.getLivre().size();
    }

    public int getColumnCount() {
        return entetes.length;
    }

    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.bibliotheque.getLivre().get(rowIndex).getTitre();
            case 1:
                return this.bibliotheque.getLivre().get(rowIndex).getAuteur();
            case 2:
                return this.bibliotheque.getLivre().get(rowIndex).getParution();
            case 3:
                return this.bibliotheque.getLivre().get(rowIndex).getRangee();
            case 4:
                return this.bibliotheque.getLivre().get(rowIndex).getColonne();
            default:
                return null; //Ne devrait jamais arriver
        }
    }


}