package com.views;

import com.eventListeners.AddBookListener;
import com.models.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlButtons extends JPanel {
    private Button add, remove;
    private BookForm bookform;
    private Table table;

    public ControlButtons(BookForm bookform, Table table) {
        add = new Button("+");
        remove = new Button("-");
        this.bookform = bookform;
        this.table = table;
        initComponents();

    }

    public void initComponents() {
        add(add);
        add(remove);
        add.addActionListener(new AddBookListener(this.bookform));
        remove.addActionListener(new RemoveListener());
        this.table.reload();
    }

    class RemoveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (State.getInstance().indiceSelectionned != -1) {
                int dialogResult = JOptionPane.showConfirmDialog (null, "Voulez vous supprimer ce livre ?");
                if (dialogResult == JOptionPane.YES_OPTION){
                    State.getInstance().bibliotheque.getLivre().remove(State.getInstance().indiceSelectionned);
                    State.getInstance().indiceSelectionned = -1;
                    State.getInstance().modification = true;
                    table.reload();
                    System.out.println(State.getInstance().bibliotheque.getLivre().size());
                }
            }
        }
    }
}
