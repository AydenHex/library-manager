package com.views;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.models.Bibliotheque;

public class BookTable extends JScrollPane {
    private Bibliotheque bibliotheque;
    private Table table;
    private JTable tableau;

    public BookTable(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
        this.initComponent();
    }

    private void initComponent() {
        this.setBorder((BorderFactory.createTitledBorder("Tableau des livres")));
        table = new Table(bibliotheque);
        table.fireTableDataChanged();
        tableau = new JTable(table);
        tableau.repaint();
        JScrollPane test = new JScrollPane(tableau);
    }
    
}
// affichage tableau
        
        //JScrollPane test = new JScrollPane(tableau);