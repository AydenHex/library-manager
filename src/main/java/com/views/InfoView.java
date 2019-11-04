package com.views;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InfoView extends JFrame {

    private JLabel text=new JLabel();


    InfoView() {
        this.setTitle("Information Générals");
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        Container c = getContentPane();
        c.setBackground(Color.white);
        c.setSize(500, 200);
        FlowLayout fl = new FlowLayout();
        c.setLayout(fl);
        JLabel label1 = new JLabel("<html><h1>Bienvenue dans votre application de gestion de votre bibliotheque</h1></html>");
        JLabel label2 = new JLabel("\n");
        JLabel label3 = new JLabel("<html>Pour ouvrir un fichier au format '.xml' <b>selectionnez Fichier|ouvrir</b></html>");
        JLabel label4 = new JLabel("Pour sauvegarder ou sauvegarer sous veuillez selectionner\n");
        JLabel label5 = new JLabel("<html><b>Editon| sauvegarder</b> > Pour sauvegarder </html>");
        JLabel label6 = new JLabel("Editon| sauvegarder sous > Pour sauvegarder sous ");
        JLabel label7 = new JLabel("\n");
        JLabel label8 = new JLabel("Collaborateurs: Louis Rigaud, Quentin Royer");



        Box Test = Box.createVerticalBox();
        Test.add(label1);
        Test.add(label2);
        Test.add(label3);
        Test.add(label4);
        Test.add(label5);
        Test.add(label6);
        Test.add(label7);
        Test.add(label8);
        Test.add(Box.createVerticalGlue());
        c.add(Test);
        setLocationRelativeTo(this.getParent());

        this.setVisible(true);


    }


}

