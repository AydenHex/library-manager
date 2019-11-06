package com.views;

import com.models.Bibliotheque;
import com.models.State;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BookForm extends JPanel {
    private JPanel formPanel;
    private JLabel lTitle, lWriterFirstname, lWriterLastname, lRelease, lResume, lRow, lColumn;
    private JTextField title, writerFirstname, writerLastname, release, row, column;
    private JTextArea resume;
    private JButton validate;
    private Font font;
    private Dimension textDimension;
    private boolean statut;
    private String action;
    private Table table;

    public BookForm(Table table) {
        font = new Font("Verdana", Font.PLAIN, 14);
        textDimension = new Dimension(100, 20);

        lTitle = new JLabel("Titre : ");
        lWriterFirstname = new JLabel("Prénom Auteur : ");
        lWriterLastname = new JLabel("Nom Auteur : ");
        lRelease = new JLabel("Parution : ");
        lResume = new JLabel("Résumé : ");
        lRow = new JLabel("Rangée : ");
        lColumn = new JLabel("Colonne : ");

        title = new JTextField();
        release = new JTextField(3);
        resume = new JTextArea(4, 8);
        row = new JTextField(2);
        column = new JTextField(2);

        writerFirstname = new JTextField();
        writerLastname = new JTextField();

        this.table = table;

        validate = new JButton("Valider");
        validate.addActionListener(new BookFormListener());

        setLayout(new GridBagLayout());

        setBorder((BorderFactory.createTitledBorder("Formulaire d'interaction")));
        setPreferredSize(new Dimension(250, 400));
        this.action = "";

        initComponent();
        this.disableForm();
    }

    public void disableForm() {
        for (Component component : this.getComponents()) {
            component.setEnabled(false);
        }
        this.setEnabled(false);
        this.statut = false;
    }

    public void enableForm() {
        for (Component component : this.getComponents()) {
            component.setEnabled(true);
        }
        this.setEnabled(true);
        this.statut = true;
    }

    public void initComponent() {

        /**
         * bTitle.setPreferredSize(new Dimension(200, 25)); bTitle.add(lTitle);
         * bTitle.add(title);
         * 
         * bWriter.setPreferredSize(new Dimension(200, 25)); bWriter.add(lWriter);
         * bWriter.add(writerFirstname); bWriter.add(writerLastname);
         * 
         * form = Box.createVerticalBox();
         * form.setAlignmentX(Component.CENTER_ALIGNMENT);
         * 
         * form.add(bTitle); form.add(bWriter);
         */
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        lTitle.setFont(font);
        add(lTitle, c);
        c.gridx = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        title.setPreferredSize(textDimension);
        add(title, c);

        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        lWriterFirstname.setFont(font);
        add(lWriterFirstname, c);
        c.gridx = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        writerFirstname.setPreferredSize(textDimension);
        add(writerFirstname, c);

        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        lWriterLastname.setFont(font);
        add(lWriterLastname, c);
        c.gridx = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        writerLastname.setPreferredSize(textDimension);
        add(writerLastname, c);

        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        lRelease.setFont(font);
        add(lRelease, c);
        c.gridx = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        release.setPreferredSize(textDimension);
        add(release, c);

        c.gridx = 0;
        c.gridy = 4;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        lResume.setFont(font);
        add(lResume, c);
        c.gridx = 1;
        c.gridheight = 4;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        resume.setPreferredSize(textDimension);
        add(resume, c);

        c.gridx = 0;
        c.gridy = 9;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        lRow.setFont(font);
        add(lRow, c);
        c.gridx = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        row.setPreferredSize(textDimension);
        add(row, c);

        c.gridx = 0;
        c.gridy = 15;
        c.anchor = GridBagConstraints.LAST_LINE_END;
        lColumn.setFont(font);
        add(lColumn, c);
        c.gridx = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        column.setPreferredSize(textDimension);
        add(column, c);

        c.gridx = 0;
        c.gridy = 21;
        add(validate, c);

        //add(form);
    }
    public Boolean getStatus() {
        return this.statut;
    }
    public String getAction() {
        return this.action;
    }
    public void setAction(String value) {
        this.action = value;
    }
    public Bibliotheque.Livre generateBook() {
        Bibliotheque.Livre livre = new Bibliotheque.Livre();
        Bibliotheque.Livre.Auteur auteur = new Bibliotheque.Livre.Auteur();

        auteur.setNom(writerLastname.getText());
        auteur.setPrenom(writerFirstname.getText());

        livre.setTitre(title.getText());
        livre.setAuteur(auteur);
        livre.setPresentation(resume.getText());
        livre.setParution(Integer.parseInt(release.getText()));
        livre.setColonne(Short.parseShort(column.getText()));
        livre.setRangee(Short.parseShort(row.getText()));

        return livre;
    }

    public void loadBook(Bibliotheque.Livre livre) {
        title.setText(livre.getTitre());
        writerFirstname.setText(livre.getAuteur().getPrenom());
        writerLastname.setText(livre.getAuteur().getNom());
        resume.setText(livre.getPresentation());
        release.setText(Integer.toString(livre.getParution()));
        column.setText(Short.toString(livre.getColonne()));
        row.setText(Short.toString(livre.getRangee()));
    }
    public class BookFormListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (State.getInstance().addAction) {
                State.getInstance().bibliotheque.getLivre().add(generateBook());
            } else {
                State.getInstance().bibliotheque.getLivre().set(State.getInstance().indiceSelectionned, generateBook());
            }
            table.reload();
            disableForm();
            State.getInstance().modification = true;
        }
    }

}