package com.views;

import com.eventListeners.OpenListener;
import com.eventListeners.SaveAsListener;
import com.eventListeners.SaveListener;
import com.models.State;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBException;
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
                if (State.getInstance().modification) {
                    String[] options = {"Sauvegarder", "Annuler", "Quitter sans sauvegarder"};
                    int x = JOptionPane.showOptionDialog(null,
                            "Vous avez des modifications en cours...",
                            "",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            null,
                            options,
                            options[0]);
                    switch (x) {
                        case 0:
                            try{
                                if (State.getInstance().path != null) {
                                    State.getInstance().bibliotheque.sauvegarderLivre(State.getInstance().path);
                                    State.getInstance().modification = false;
                                    JOptionPane.showMessageDialog(null, "Votre fichier à bien été sauvegarder");
                                }
                                else {
                                    JFileChooser chooser = new JFileChooser();// création dun nouveau filechosser
                                    chooser.setApproveButtonText("Choix du fichier..."); // intitulé du bouton
                                    FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
                                    chooser.setFileFilter(xmlfilter);
                                    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                                        String thepath = chooser.getSelectedFile().getAbsolutePath();
                                        System.out.println(thepath);
                                        State.getInstance().bibliotheque.sauvegarderLivre(thepath + ".xml");
                                        State.getInstance().path = thepath;
                                        State.getInstance().modification = false;
                                        JOptionPane.showMessageDialog(null, "Votre fichier à bien été sauvegarder");
                                    }
                                }
                                System.exit(0);
                            } catch (JAXBException je) {
                                System.out.println("Erreur JAXB : " + je);
                            }
                            break;
                        case 1:
                            break;
                        case 2:
                            System.exit(0);
                    }
                }
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