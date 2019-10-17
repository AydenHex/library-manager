package com.models;

import static org.junit.Assert.*;

import com.models.Bibliotheque.Livre.Auteur;

import org.junit.BeforeClass;
import org.junit.Test;

public class AuteurTest {
    static ObjectFactory of;

    @BeforeClass
    public static void setup() {
        AuteurTest.of = new ObjectFactory();
    }

    @Test
    public final void testAuteurToString() {
        Auteur auteur = AuteurTest.of.createBibliothequeLivreAuteur();
        auteur.setNom("Doe");
        auteur.setPrenom("John");

        assertEquals("Doe", auteur.getNom());
        assertEquals("John", auteur.getPrenom());
    }
}