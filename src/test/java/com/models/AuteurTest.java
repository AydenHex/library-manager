package com.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class AuteurTest {

    @Test
    public final void testAuteurToString() {
        Auteur auteur = new Auteur("John", "Doe");
        assertEquals("Doe John", auteur.toString());
    }
}