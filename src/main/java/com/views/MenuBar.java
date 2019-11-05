package com.views;

import com.eventListeners.OpenListener;
import com.eventListeners.SaveAsListener;
import com.eventListeners.SaveListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
    private JMenu file;
    private JMenu edition;
    private JMenu about;

    private JMenuItem open;
    private JMenuItem close;
    private JMenuItem save;
    private JMenuItem saveAs;
    private JMenuItem info;

    private Table table;

    public MenuBar(Table table) {
        this.table = table;

        // Set parents menus
        this.file = new JMenu("File");
        this.edition = new JMenu("Edition");
        this.about = new JMenu("About");

        // Set childs menus
        this.open = new JMenuItem("Open");
        this.close = new JMenuItem("Close");
        this.save = new JMenuItem("Save");
        this.saveAs = new JMenuItem("Save as...");
        this.info = new JMenuItem("Informations");

        // Add childs menus to parents
        this.file.add(this.open);
        this.file.add(this.close);
        this.open.addActionListener(new OpenListener(this.table));
        this.close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });


        this.edition.add(this.save);
        this.edition.add(this.saveAs);
        this.save.addActionListener(new SaveListener());
        this.saveAs.addActionListener(new SaveAsListener());
        
        this.about.add(this.info);

        // Add parents menus to MenuBar
        this.add(this.file);
        this.add(this.edition);
        this.add(this.about);
    }

    public Table getTable() {
        return this.table;
    }
}