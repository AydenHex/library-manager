package com.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBException;

import com.models.Bibliotheque;

public class WindowManager extends JFrame {

    private static final long serialVersionUID = 1L;
    private Bibliotheque bibliotheque = new Bibliotheque();

    private JMenuBar menuBar = new JMenuBar();
    private JMenu file = new JMenu("Fichier");
    private JMenu Edition = new JMenu("Edition");
    private JMenu About = new JMenu("About");

    private JMenuItem open = new JMenuItem("Ouvrir");
    private JMenuItem close = new JMenuItem("Fermer");
    private JMenuItem Sauvegarder = new JMenuItem("Sauvegarder");
    private JMenuItem SauvegarderSous = new JMenuItem("Sauvegarder Sous");
    private JMenuItem Info = new JMenuItem("informations");

    private JButton ajouterBouton, supprimerBouton, apply;
    private JLabel livreLabel, auteurLabel, parutionLabel, rangeeLabel, colonneLabel, presentationLabel;
    private JTextField livre, auteur, parution, rangee, colonne;
    private JTextArea presentation;

    private JTable tableau;
    private Table table;

    public WindowManager() {
        // caracteristiques de la fenetre
        this.setTitle("Gestion Livre");
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.initComponent();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initComponent() {
        // implementation du menu a completer
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

        // affichage tableau
        JPanel panTable = new JPanel();
        panTable.setBorder((BorderFactory.createTitledBorder("Tableau des livres")));
        table = new Table(bibliotheque);
        table.fireTableDataChanged();
        tableau = new JTable(table);
        tableau.repaint();
        JScrollPane test = new JScrollPane(tableau);
        panTable.add(test, BorderLayout.CENTER);

        // affichage formulaire
        JPanel panForm = new JPanel();

        panForm.setPreferredSize(new Dimension(400, 400));
        panForm.setBackground(Color.white);

        panForm.setBorder((BorderFactory.createTitledBorder("Formulaire d'interaction")));

        livreLabel = new JLabel("Livre : ");
        parutionLabel = new JLabel("Parution : ");
        auteurLabel = new JLabel("Auteur: ");
        rangeeLabel = new JLabel("Rangée : ");
        presentationLabel = new JLabel("Présentation : ");
        colonneLabel = new JLabel("Colonne : ");

        livre = new JTextField();
        parution = new JTextField();
        auteur = new JTextField();
        rangee = new JTextField();

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        presentation = new JTextArea(2,5);
        presentation.setBorder(border);
        colonne = new JTextField();



        Box BLivre=Box.createHorizontalBox();
        BLivre.setPreferredSize(new Dimension(200,25));
        BLivre.add(livreLabel/*,RIGHT_ALIGNMENT*/);

        BLivre.add(livre);


        Box BAuteur=Box.createHorizontalBox();
        BAuteur.setPreferredSize(new Dimension(100,25));
        BAuteur.add(auteurLabel);
        BAuteur.add(auteur);


        Box BAnnee= Box.createHorizontalBox();
        BAnnee.setPreferredSize(new Dimension(100,25));
        BAnnee.add(parutionLabel);
        BAnnee.add(parution);
        
        Box BPresentation = Box.createHorizontalBox();
        BPresentation.setPreferredSize(new Dimension(100,100));
        BPresentation.add(presentationLabel);
        BPresentation.add(presentation);

        Box BRangee= Box.createHorizontalBox();
        BRangee.setPreferredSize(new Dimension(100,25));
        BRangee.add(rangeeLabel);
        BRangee.add(rangee);

        Box BColonne = Box.createHorizontalBox();
        BColonne.setPreferredSize(new Dimension(100, 25));
        BColonne.add(colonneLabel);
        BColonne.add(colonne);

        apply = new JButton("Appliquer");

        Box haut =Box.createVerticalBox();

        haut.setAlignmentX(Component.CENTER_ALIGNMENT);

        haut.add(BLivre);
        haut.add(BAuteur);
        haut.add(BAnnee);
        haut.add(BPresentation);
        haut.add(BColonne);
        haut.add(BRangee);
        haut.add(apply);

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
        panForm.add(anneeLabel);
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

        this.disableFormComponent();

        pack();
    }

    public void enableFormComponent() {
        livre.setEnabled(true);
        auteur.setEnabled(true);
        parution.setEnabled(true);
        presentation.setEnabled(true);
        colonne.setEnabled(true);
        rangee.setEnabled(true);
		apply.setEnabled(true);
    }

    public void disableFormComponent() {
        livre.setEnabled(false);
        auteur.setEnabled(false);
        parution.setEnabled(false);
        presentation.setEnabled(false);
        colonne.setEnabled(false);
        rangee.setEnabled(false);
        apply.setEnabled(false);
    }

    class FileListener implements ActionListener{
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==close) {
                System.exit(0);
                
            }
            if (e.getSource()==open) {
                JFileChooser chooser = new JFileChooser();//création dun nouveau filechosser
                chooser.setApproveButtonText("Choix du fichier..."); //intitulé du bouton
                FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
                chooser.setFileFilter(xmlfilter);
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {	
                    try {
                        String path = chooser.getSelectedFile().getAbsolutePath();
                        System.out.println(path);
                        bibliotheque.chargerLivre(path);
                        System.out.println(bibliotheque.getLivre().get(0));
                        table.fireTableDataChanged();
                        tableau.repaint();
                    }
                    catch (JAXBException je) {
                        System.out.println("erreur jaxb");
                    }
                    catch (Exception t) {
                        System.out.println("erreur");
                    }
                }
            }
        }
    }

    class AddRemoveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }
    }
}

  


