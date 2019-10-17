package com.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBException;

import com.models.Bibliotheque;

public class WindowManager extends JFrame {

    private static final long serialVersionUID = 1L;
    private Bibliotheque bibliotheque;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu file=new JMenu("Fichier");
    private JMenu Edition =new JMenu("Edition");
    private JMenu About=new JMenu ("About");

    private JMenuItem open = new JMenuItem("Ouvrir");
    private JMenuItem close = new JMenuItem("Fermer");
    private JMenuItem  Sauvegarder = new JMenuItem("Sauvegarder");
    private JMenuItem SauvegarderSous = new JMenuItem("Sauvegarder Sous");
    private JMenuItem Info = new JMenuItem("informations");

    private JButton ajouterBouton, supprimerBouton;
    private JLabel livreLabel,auteurLabel, presentationLabel,rangeeLabel, colonneLabel, parutionLabel;
    private JTextField livre,auteur,rangee, colonne, parution;
    private JTextArea presentation;





    public WindowManager(){
        //caracteristiques de la fenetre
        this.bibliotheque = new Bibliotheque();
        this.setTitle("Gestion Livre");
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.initComponent();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    private void initComponent(){
        //implementation du menu a completer
        file.add(open);
        file.add(close);
        close.addActionListener(new FileListener());
        open.addActionListener(new FileListener());

        Edition.add(Sauvegarder);
        Edition.add(SauvegarderSous);

        About.add(Info);



        menuBar.add(file);
        menuBar.add(Edition);
        menuBar.add(About);
        this.setJMenuBar(menuBar);

        //affichage tableau
        JPanel panTable=new JPanel();
        panTable.setBorder((BorderFactory.createTitledBorder("Tableau des livres")));
        JTable tableau = new JTable(new Table(this.bibliotheque));
        panTable.add(tableau, BorderLayout.CENTER);





        //affichage formulaire
        JPanel panForm=new JPanel();



        panForm.setPreferredSize(new Dimension(400,400));
        panForm.setBackground(Color.white);

        panForm.setBorder((BorderFactory.createTitledBorder("Formulaire d'interaction")));

        livreLabel=new JLabel("Livre : ");
        presentationLabel=new JLabel("Résumé : ");
        auteurLabel=new JLabel("Auteur: ");
        rangeeLabel=new JLabel("rangée : ");
        colonneLabel = new JLabel("colonne : ");
        parutionLabel = new JLabel("parution : ");

        livre=new JTextField();
        presentation = new JTextArea(5, 2);
        presentation.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        auteur=new JTextField();
        rangee=new JTextField();
        colonne = new JTextField();
        parution = new JTextField();



        Box BLivre=Box.createHorizontalBox();
        BLivre.setPreferredSize(new Dimension(200,25));
        BLivre.add(livreLabel/*,RIGHT_ALIGNMENT*/);

        BLivre.add(livre);


        Box BAuteur=Box.createHorizontalBox();
        BAuteur.setPreferredSize(new Dimension(100,25));
        BAuteur.add(auteurLabel);
        BAuteur.add(auteur);

        Box BParution=Box.createHorizontalBox();
        BParution.setPreferredSize(new Dimension(100,25));
        BParution.add(parutionLabel);
        BParution.add(parution);

        Box BPresentation = Box.createHorizontalBox();
        BPresentation.setPreferredSize(new Dimension(100,100));
        BPresentation.add(presentationLabel);
        BPresentation.add(presentation);

        Box BRangee= Box.createHorizontalBox();
        BRangee.setPreferredSize(new Dimension(100,25));
        BRangee.add(rangeeLabel);
        BRangee.add(rangee);

        Box BColonne=Box.createHorizontalBox();
        BColonne.setPreferredSize(new Dimension(100,25));
        BColonne.add(colonneLabel);
        BColonne.add(colonne);

        Box haut =Box.createVerticalBox();

        haut.setAlignmentX(Component.CENTER_ALIGNMENT);

        haut.add(BLivre);
        haut.add(BAuteur);
        haut.add(BParution);
        haut.add(BPresentation);
        haut.add(BRangee);
        haut.add(BColonne);

        panForm.add(haut);

        JPanel control = new JPanel();
        control.setBackground(Color.white);
        ajouterBouton=new JButton("<html><font color='green'>+</font></html>");
        supprimerBouton=new JButton("<html><font color='red'>-</font></html>");
        control.add(ajouterBouton);
        control.add(supprimerBouton);


        /*
        panForm.add(livreLabel);
        panForm.add(livre);
        panForm.add(parutionLabel);
        panForm.add(annee);
        panForm.add(auteurLabel);
        panForm.add(auteur);
        panForm.add(rangeeLabel);
        panForm.add(rangee);*/





        JPanel content = new JPanel();
        content.setBackground(Color.white);
        content.add(panTable);

        JPanel Form=new JPanel();
        Form.add(panForm);

        this.getContentPane().add(control,BorderLayout.SOUTH);
        this.getContentPane().add(content, BorderLayout.WEST);
        this.getContentPane().add(Form,BorderLayout.EAST);
        pack();
    }

    class FileListener implements ActionListener{
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==close) {
                System.exit(0);
                
            }
            if (e.getSource()==open) {
                JFileChooser chooser = new JFileChooser();//création dun nouveau filechoser
                FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
                chooser.setApproveButtonText("Choix du fichier..."); //intitulé du bouton
                chooser.setFileFilter(xmlfilter);
                chooser.setFileSelectionMode(0);
                //chooser.showOpenDialog(null); //affiche la boite de dialogue
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {	
                    String path = chooser.getSelectedFile().getAbsolutePath();
                    System.out.println(path);
                    try {
                        bibliotheque.chargerLivre(path);
                    }
                    catch (JAXBException je) {
                        JOptionPane.showMessageDialog(null, "Can't open this file : " + je, "Erreur - Ouverture", JOptionPane.ERROR_MESSAGE);
                    }
                }      
            }
       }
    }


}



