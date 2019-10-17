package com.models;

import java.util.ArrayList;

import com.models.Bibliotheque.Livre;

import org.junit.Before;
import org.junit.BeforeClass;

public class BibliothequeTest {
    private static Bibliotheque bibliotheque;
    private static ObjectFactory of;
    @BeforeClass
    public static void setup() {
        BibliothequeTest.of = new ObjectFactory();
        BibliothequeTest.bibliotheque = BibliothequeTest.of.createBibliotheque();

    }
    @Before
    public final void prepareTest() {
        BibliothequeTest.bibliotheque.livre = new ArrayList<Livre>();
    }

    
}