//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.10.17 à 10:47:45 AM CEST 
//


package com.models;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Bibliotheque }
     * 
     */
    public Bibliotheque createBibliotheque() {
        return new Bibliotheque();
    }

    /**
     * Create an instance of {@link Bibliotheque.Livre }
     * 
     */
    public Bibliotheque.Livre createBibliothequeLivre() {
        return new Bibliotheque.Livre();
    }

    public Bibliotheque.Livre createLivre(String titre, Bibliotheque.Livre.Auteur auteur, Integer parution, String presentation, Short colonne, Short rangee) {
        Bibliotheque.Livre livre = new Bibliotheque.Livre();
        livre.setTitre(titre);
        livre.setAuteur(auteur);
        livre.setParution(parution);
        livre.setPresentation(presentation);
        livre.setColonne(colonne);
        livre.setRangee(rangee);

        return livre;
    }

    /**
     * Create an instance of {@link Bibliotheque.Livre.Auteur }
     * 
     */
    public Bibliotheque.Livre.Auteur createBibliothequeLivreAuteur() {
        return new Bibliotheque.Livre.Auteur();
    }

    public Bibliotheque.Livre.Auteur createAuteur(String nom, String prenom) {
        Bibliotheque.Livre.Auteur auteur = new Bibliotheque.Livre.Auteur();
        auteur.setNom(nom);
        auteur.setPrenom(prenom);

        return auteur;
    }

}
