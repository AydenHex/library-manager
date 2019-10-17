package com.models;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BibliothequeTest {
    private Bibliotheque bibliotheque = new Bibliotheque();

    @Before
    public final void prepareTest() {
        this.bibliotheque.setLivres(new ArrayList<Livre>());
    }

    @Test
    public final void addLivre() {
        Auteur auteur = new Auteur("John", "Doe");
        Livre livre = new Livre("LivreTest", auteur, "PresentationTest", 2000, 2, 2);
        
        this.bibliotheque.getLivres().add(livre);

        assertTrue(this.bibliotheque.getLivres().size() == 1);
    }

    @Test
    public final void removeLivre() {
        Auteur auteur = new Auteur("John", "Doe");
        Livre livre = new Livre("LivreTest", auteur, "PresentationTest", 2000, 2, 2);
        
        this.bibliotheque.getLivres().add(livre);
        this.bibliotheque.getLivres().remove(livre);

        assertTrue(this.bibliotheque.getLivres().size() == 0);
    }
}