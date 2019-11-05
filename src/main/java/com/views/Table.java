package com.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;

import com.models.State;

public class Table extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private TableModel tableModel;
    private JTable jtable;
    private JScrollPane jscrollPane;
    private JPanel panTable;

    public Table() {
        tableModel = new TableModel(State.getInstance().bibliotheque);
        panTable = new JPanel();
        jtable = new JTable(tableModel) {
            private static final long serialVersionUID = 1L;

            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row))
                    c.setBackground(row % 2 == 0 ? getBackground() : Color.LIGHT_GRAY);
                return c;
            }
        };
        jscrollPane = new JScrollPane(jtable);
        initComponent();
    }

    public void initComponent() {
        //setBackground(Color.white);

        panTable.setBorder((BorderFactory.createTitledBorder("Tableau des livres")));
        jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtable.getSelectionModel().addListSelectionListener(new TableListener());
        setPreferredSize(new Dimension(500,300));
        reload();
        panTable.add(jscrollPane, BorderLayout.CENTER);
        setVisible(true);
        //panTable.setPreferredSize(new Dimension(200, 200));
        add(panTable);
    }

    public void reload() {
        tableModel.fireTableDataChanged();
        jtable.repaint();
    }


    class TableListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting()) {
                State.getInstance().indiceSelectionned = jtable.getSelectedRow();
            }
        }
    }
}