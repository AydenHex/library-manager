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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableCellRenderer;
import javax.xml.bind.JAXBException;

import com.exceptions.ExceptionForm;
import com.models.Bibliotheque;
import com.models.Bibliotheque.Livre;
import com.models.Bibliotheque.Livre.Auteur;

public class WindowManager extends JFrame {

    private static final long serialVersionUID = 1L;
    private Bibliotheque bibliotheque = new Bibliotheque();
    private boolean modification;
    private String path;

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
    private JLabel livreLabel, nomAuteurLabel, prenomAuteurLabel, parutionLabel, rangeeLabel, colonneLabel,
            presentationLabel;
    private JTextField slivre, sauteurnom, sauteurprenom, sparution, srangee, scolonne;
    private JTextArea spresentation;
    private Box haut;

    private JTable tableau;
    private TableModel tableModel;

    private String applyType;

    public WindowManager() {
        // caracteristiques de la fenetre
        this.setTitle("Gestion Livre");
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.modification = false;
        this.path = "";
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
        Sauvegarder.addActionListener(new EditionListener());
        SauvegarderSous.addActionListener(new EditionListener());

        About.add(Info);
        Info.addActionListener(new InfoListener());

        menuBar.add(file);
        menuBar.add(Edition);
        menuBar.add(About);
        this.setJMenuBar(menuBar);

        // affichage tableau
        JPanel panTable = new JPanel();
        panTable.setBorder((BorderFactory.createTitledBorder("Tableau des livres")));
        tableModel = new TableModel(bibliotheque);
        tableModel.fireTableDataChanged();
        tableau = new JTable(tableModel) {
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row))
                    c.setBackground(row % 2 == 0 ? getBackground() : Color.LIGHT_GRAY);
                return c;
            }
        };
        tableau.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        
            @Override
             public void valueChanged(ListSelectionEvent event) {
            System.out.println(tableau.getValueAt(tableau.getSelectedRow(), 0));
        }
        });
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
        nomAuteurLabel = new JLabel("Nom auteur: ");
        prenomAuteurLabel = new JLabel("Prenom auteur");
        rangeeLabel = new JLabel("Rangée : ");
        presentationLabel = new JLabel("Présentation : ");
        colonneLabel = new JLabel("Colonne : ");

        slivre = new JTextField();
        sparution = new JTextField();
        sauteurnom = new JTextField();
        sauteurprenom = new JTextField();
        srangee = new JTextField();

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        spresentation = new JTextArea(2, 5);
        spresentation.setBorder(border);
        scolonne = new JTextField();

        Box BLivre = Box.createHorizontalBox();
        BLivre.setPreferredSize(new Dimension(200, 25));
        BLivre.add(livreLabel/* ,RIGHT_ALIGNMENT */);

        BLivre.add(slivre);

        Box BAuteurNom = Box.createHorizontalBox();
        BAuteurNom.setPreferredSize(new Dimension(100, 25));
        BAuteurNom.add(nomAuteurLabel);
        BAuteurNom.add(sauteurnom);

        Box BAuteurPrenom = Box.createHorizontalBox();
        BAuteurPrenom.setPreferredSize(new Dimension(100, 25));
        BAuteurPrenom.add(prenomAuteurLabel);
        BAuteurPrenom.add(sauteurprenom);

        Box BAnnee = Box.createHorizontalBox();
        BAnnee.setPreferredSize(new Dimension(100, 25));
        BAnnee.add(parutionLabel);
        BAnnee.add(sparution);

        Box BPresentation = Box.createHorizontalBox();
        BPresentation.setPreferredSize(new Dimension(100, 100));
        BPresentation.add(presentationLabel);
        BPresentation.add(spresentation);

        Box BRangee = Box.createHorizontalBox();
        BRangee.setPreferredSize(new Dimension(100, 25));
        BRangee.add(rangeeLabel);
        BRangee.add(srangee);

        Box BColonne = Box.createHorizontalBox();
        BColonne.setPreferredSize(new Dimension(100, 25));
        BColonne.add(colonneLabel);
        BColonne.add(scolonne);

        apply = new JButton("Appliquer");
        apply.addActionListener(new ApplyListener());

        haut = Box.createVerticalBox();

        haut.setAlignmentX(Component.CENTER_ALIGNMENT);

        haut.add(BLivre);
        haut.add(BAuteurNom);
        haut.add(BAuteurPrenom);
        haut.add(BAnnee);
        haut.add(BPresentation);
        haut.add(BColonne);
        haut.add(BRangee);
        haut.add(apply);

        panForm.add(haut);

        JPanel control = new JPanel();
        control.setBackground(Color.white);
        ajouterBouton = new JButton("<html><font color='green'>+</font></html>");
        supprimerBouton = new JButton("<html><font color='red'>-</font></html>");

        ajouterBouton.addActionListener(new AddRemoveListener());
        supprimerBouton.addActionListener(new AddRemoveListener());

        control.add(ajouterBouton);
        control.add(supprimerBouton);

        /*
         * panForm.add(livreLabel); panForm.add(livre); panForm.add(anneeLabel);
         * panForm.add(annee); panForm.add(auteurLabel); panForm.add(auteur);
         * panForm.add(rangeeLabel); panForm.add(rangee);
         */

        JPanel content = new JPanel();
        content.setBackground(Color.white);
        content.add(panTable);

        JPanel Form = new JPanel();
        Form.add(panForm);

        this.getContentPane().add(control, BorderLayout.SOUTH);
        this.getContentPane().add(content, BorderLayout.WEST);
        this.getContentPane().add(Form, BorderLayout.EAST);

        this.disableFormComponent();

        pack();
    }

    public void enableFormComponent() {
        slivre.setEnabled(true);
        sauteurnom.setEnabled(true);
        sauteurprenom.setEnabled(true);
        sparution.setEnabled(true);
        spresentation.setEnabled(true);
        scolonne.setEnabled(true);
        srangee.setEnabled(true);
        apply.setEnabled(true);
    }

    public void disableFormComponent() {
        slivre.setEnabled(false);
        sauteurnom.setEnabled(true);
        sauteurprenom.setEnabled(true);
        sparution.setEnabled(false);
        spresentation.setEnabled(false);
        scolonne.setEnabled(false);
        srangee.setEnabled(false);
        apply.setEnabled(false);
    }

    public void verifyForm() throws ExceptionForm {
        String titre = slivre.getText();
        String sAuteurNom = sauteurnom.getText();
        String sAuteurPrenom = sauteurprenom.getText();
        String sParution = sparution.getText();
        String sPresentation = spresentation.getText();
        String sColonne = scolonne.getText();
        String sRangee = scolonne.getText();

        if (titre == "" && sAuteurNom == "" && sAuteurPrenom == "" && sParution == "" && sPresentation == ""
                && sColonne == "" && sRangee == "") {
            throw new ExceptionForm("Veuillez remplir tout les champs avant de valider");
        }
        if (Integer.parseInt(sColonne) < 1 && Integer.parseInt(sColonne) > 5) {
            throw new ExceptionForm("Veuillez choisir une colonne entre 1 et 4");
        }
        if (Integer.parseInt(sRangee) < 1 && Integer.parseInt(sRangee) > 6) {
            throw new ExceptionForm("Veuillez choisir une colonne entre 1 et 5");
        }

    }

    class FileListener implements ActionListener {
        // Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == close) {
                String[] options = { "Sauvegarder", "Ne pas sauvegarder", "annuler" }; //sauvegarder=0; Ne pas sauvegarder=1,; annuler=2;

                if (modification) {
                    int value = JOptionPane.showOptionDialog(null, "Souhaitez-vous vraiment quitter sans sauvegarder",
                            "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
                            options[0]);

                    switch (value) {
                    case 0:
                        try {
                            bibliotheque.sauvegarderLivre(path);
                            break;
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    case 1:
                        System.exit(0);
                        break;
                    case 2:
                        break;

                    }
                }
                System.exit(0);

            }
            if (e.getSource() == open) {
                JFileChooser chooser = new JFileChooser();// création dun nouveau filechosser
                chooser.setApproveButtonText("Choix du fichier..."); // intitulé du bouton
                FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
                chooser.setFileFilter(xmlfilter);
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        String thepath = chooser.getSelectedFile().getAbsolutePath();
                        System.out.println(thepath);
                        bibliotheque.chargerLivre(thepath);
                        path = thepath;
                        System.out.println(bibliotheque.getLivre().get(0));
                        tableModel.fireTableDataChanged();
                        tableau.repaint();
                    } catch (JAXBException je) {
                        System.out.println("erreur jaxb : " + je);
                    } catch (Exception t) {
                        System.out.println("erreur");
                    }
                }
            }
        }
    }

    class AddRemoveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == ajouterBouton) {
                applyType = "add";
                enableFormComponent();
            }
        }
    }

    class ApplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                verifyForm();
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, x);
            }
            if (applyType == "add") {
                Auteur auteur = new Auteur();
                auteur.setPrenom(sauteurprenom.getText());
                auteur.setNom(sauteurnom.getText());

                Livre livre = new Livre();
                livre.setTitre(slivre.getText());
                livre.setPresentation(spresentation.getText());
                livre.setParution(Integer.parseInt(sparution.getText()));
                livre.setColonne(Short.parseShort(scolonne.getText()));
                livre.setRangee(Short.parseShort(srangee.getText()));
                livre.setAuteur(auteur);
                bibliotheque.getLivre().add(livre);
                modification = true;
                tableModel.fireTableDataChanged();
                tableau.repaint();
            }

        }
    }

    class EditionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            /**
             * if (path == "") { JOptionPane.showMessageDialog(null, "Veuillez ouvrir un
             * fichier avant de sauvegarder"); return; }
             */
            if (e.getSource() == Sauvegarder) {
                try {
                    bibliotheque.sauvegarderLivre(path);
                    modification = false;
                    JOptionPane.showMessageDialog(null, "Votre fichier à bien été sauvegarder");
                } catch (JAXBException je) {
                    System.out.println("Erreur JAXB : " + e);
                }
            }
            if (e.getSource() == SauvegarderSous) {
                JFileChooser chooser = new JFileChooser();// création dun nouveau filechosser
                chooser.setApproveButtonText("Choix du fichier..."); // intitulé du bouton
                FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
                chooser.setFileFilter(xmlfilter);
                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        String thepath = chooser.getSelectedFile().getAbsolutePath();
                        System.out.println(thepath);
                        bibliotheque.sauvegarderLivre(thepath);
                        path = thepath;
                        modification = false;
                    } catch (JAXBException je) {
                        System.out.println("erreur jaxb : " + je);
                    } catch (Exception t) {
                        System.out.println("erreur : " + t);
                    }
                }
            }
        }
    }
    class InfoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==Info)
            {
                InfoView info =new InfoView();

            }

        }
    }

}

  


