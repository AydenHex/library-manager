package com.models;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Auteur {
    private String nom;
    private String prenom;

    public Auteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    public Auteur() {}

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String toString() {
        return this.prenom + " " + this.nom;
    }

}