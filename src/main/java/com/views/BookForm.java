package com.views;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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

    public BookForm() {
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

        setLayout(new GridBagLayout());

        setBorder((BorderFactory.createTitledBorder("Formulaire d'interaction")));
        setPreferredSize(new Dimension(250, 400));

        initComponent();
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

        //add(form);
    }
}