package com.views;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

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
        JLabel label3 = new JLabel("<html>Pour ouvrir un fichier au foramt '.xml' <b>selectionnez Fichier|ouvrir</b></html>");
        JLabel label4 = new JLabel("Pour sauvegarder ou sauvegarer sous veuillez selectionner Editon| sauvegarder\n");
        JLabel label5 = new JLabel("Editon| sauvegarder > Pour sauvegarder ");
        JLabel label6 = new JLabel("Editon| sauvegarder sous > Pour sauvegarder sous ");



        Box Test = Box.createVerticalBox();
        Test.add(label1);
        Test.add(label2);
        Test.add(label3);
        Test.add(label4);
        Test.add(label5);
        Test.add(label6);
        Test.add(Box.createVerticalGlue());
        c.add(Test);
        setLocationRelativeTo(this.getParent());

        this.setVisible(true);


    }


}

 /* private void initComponentInfo(){

        String htmlFilePath = "C:\\Users\\lrigaudf\\Downloads\\info.html"; // path to your new file
        File htmlFile = new File(htmlFilePath);

// open the default web browser for the HTML page
        try {
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }

// if a web browser is the default HTML handler, this might work too
        try {
            Desktop.getDesktop().open(htmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }*/