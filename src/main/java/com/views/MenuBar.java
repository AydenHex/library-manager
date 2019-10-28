package com.views;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
    private JMenu File;
    private JMenu Edition;
    private JMenu About;

    private JMenuItem open;
    private JMenuItem close;
    private JMenuItem save;
    private JMenuItem saveAs;
    private JMenuItem info;

    public MenuBar() {
        // Set parents menus
        this.File = new JMenu("File");
        this.Edition = new JMenu("Edition");
        this.About = new JMenu("About");

        // Set childs menus
        this.open = new JMenuItem("Open");
        this.close = new JMenuItem("Close");
        this.save = new JMenuItem("Save");
        this.saveAs = new JMenuItem("Save as...");
        this.info = new JMenuItem("Informations");

        // Add childs menus to parents
        this.File.add(this.open);
        this.File.add(this.close);

        this.Edition.add(this.save);
        this.Edition.add(this.saveAs);
        
        this.About.add(this.info);

        // Add parents menus to MenuBar
        this.add(this.File);
        this.add(this.Edition);
        this.add(this.About);


    }
}