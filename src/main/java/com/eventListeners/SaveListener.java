package com.eventListeners;

import com.models.State;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
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
        } catch (JAXBException je) {
            System.out.println("Erreur JAXB : " + je);
        }
    }
}
