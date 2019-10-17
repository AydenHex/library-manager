package com.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "livre")
@XmlAccessorType(XmlAccessType.FIELD)
public class Livre {
    private String titre;
    @XmlElement(name = "auteur")
    private Auteur auteur;
    private String presentation;
    private Integer parution;
    private Integer colonne;
    private Integer rangee;

    public Livre() {}

    public Livre(String titre, Auteur auteur, String presentation, Integer parution, Integer colonne, Integer rangee) {
        this.titre = titre;
        this.auteur = auteur;
        this.presentation = presentation;
        this.parution = parution;
        this.colonne = colonne;
        this.rangee = rangee;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Auteur getAuteur() {
        return this.auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public String getPresentation() {
        return this.presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public Integer getParution() {
        return this.parution;
    }

    public void setParution(Integer parution) {
        this.parution = parution;
    }

    public Integer getColonne() {
        return this.colonne;
    }

    public void setColonne(Integer colonne) {
        this.colonne = colonne;
    }

    public Integer getRangee() {
        return this.rangee;
    }

    public void setRangee(Integer rangee) {
        this.rangee = rangee;
    }

}