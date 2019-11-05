package com.eventListeners;

import com.views.Table;
import com.models.State;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenListener implements ActionListener {

    private Table table;
    public OpenListener(Table table){
        this.table = table;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();// création dun nouveau filechosser
        chooser.setApproveButtonText("Choix du fichier..."); // intitulé du bouton
        FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
        chooser.setFileFilter(xmlfilter);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                String thepath = chooser.getSelectedFile().getAbsolutePath();
                System.out.println(thepath);
                State.getInstance().bibliotheque.chargerLivre(thepath);
                State.getInstance().path = thepath;
                table.reload();
                //print(State.getInstance().bibliotheque.getLivre());
            } catch (JAXBException je) {
                System.out.println("erreur jaxb : " + je);
            } catch (Exception t) {
                System.out.println("erreur");
            }
        }
    }
}
