//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.10.17 à 10:47:45 AM CEST 
//

package com.models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="livre" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="titre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="auteur">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="presentation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="parution" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                   &lt;element name="colonne" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="rangee" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "livre"
})
@XmlRootElement(name = "bibliotheque")
public class Bibliotheque {

    @XmlElement(required = true)
    protected List<Bibliotheque.Livre> livre;

    /**
     * Gets the value of the livre property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the livre property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLivre().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Bibliotheque.Livre }
     * 
     * 
     */
    public List<Bibliotheque.Livre> getLivre() {
        if (livre == null) {
            livre = new ArrayList<Bibliotheque.Livre>();
        }
        return this.livre;
    }

    public void chargerLivre(String path) throws JAXBException{
        JAXBContext jaxbContext = JAXBContext.newInstance(Bibliotheque.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        //reset bibliotheque
        this.getLivre().clear();
        
        //We had written this file in marshalling example
        Bibliotheque emps = (Bibliotheque) jaxbUnmarshaller.unmarshal(new File(path));
        
        for(Livre emp : emps.getLivre())
        {
            this.getLivre().add(emp);
        }
    }

    public void sauvegarderLivre(String path) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Bibliotheque.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        //Marshal the employees list in file
        jaxbMarshaller.marshal(this, new File(path));
    }


    /**
     * <p>Classe Java pour anonymous complex type.
     * 
     * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="titre" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="auteur">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="presentation" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="parution" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *         &lt;element name="colonne" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="rangee" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "titre",
        "auteur",
        "presentation",
        "parution",
        "colonne",
        "rangee"
    })
    public static class Livre {

        @XmlElement(required = true)
        protected String titre;
        @XmlElement(required = true)
        protected Bibliotheque.Livre.Auteur auteur;
        @XmlElement(required = true)
        protected String presentation;
        @XmlSchemaType(name = "unsignedShort")
        protected int parution;
        @XmlSchemaType(name = "unsignedByte")
        protected short colonne;
        @XmlSchemaType(name = "unsignedByte")
        protected short rangee;


        /**
         * Obtient la valeur de la propriété titre.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */

        public String getTitre() {
            return titre;
        }

        /**
         * Définit la valeur de la propriété titre.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitre(String value) {
            this.titre = value;
        }

        /**
         * Obtient la valeur de la propriété auteur.
         * 
         * @return
         *     possible object is
         *     {@link Bibliotheque.Livre.Auteur }
         *     
         */
        public Bibliotheque.Livre.Auteur getAuteur() {
            return auteur;
        }

        /**
         * Définit la valeur de la propriété auteur.
         * 
         * @param value
         *     allowed object is
         *     {@link Bibliotheque.Livre.Auteur }
         *     
         */
        public void setAuteur(Bibliotheque.Livre.Auteur value) {
            this.auteur = value;
        }

        /**
         * Obtient la valeur de la propriété presentation.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPresentation() {
            return presentation;
        }

        /**
         * Définit la valeur de la propriété presentation.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPresentation(String value) {
            this.presentation = value;
        }

        /**
         * Obtient la valeur de la propriété parution.
         * 
         */
        public int getParution() {
            return parution;
        }

        /**
         * Définit la valeur de la propriété parution.
         * 
         */
        public void setParution(int value) {
            this.parution = value;
        }

        /**
         * Obtient la valeur de la propriété colonne.
         * 
         */
        public short getColonne() {
            return colonne;
        }

        /**
         * Définit la valeur de la propriété colonne.
         * 
         */
        public void setColonne(short value) {
            this.colonne = value;
        }

        /**
         * Obtient la valeur de la propriété rangee.
         * 
         */
        public short getRangee() {
            return rangee;
        }

        /**
         * Définit la valeur de la propriété rangee.
         * 
         */
        public void setRangee(short value) {
            this.rangee = value;
        }


        /**
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "nom",
            "prenom"
        })
        public static class Auteur {

            @XmlElement(required = true)
            protected String nom;
            @XmlElement(required = true)
            protected String prenom;

            /**
             * Obtient la valeur de la propriété nom.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNom() {
                return nom;
            }

            /**
             * Définit la valeur de la propriété nom.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNom(String value) {
                this.nom = value;
            }

            /**
             * Obtient la valeur de la propriété prenom.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPrenom() {
                return prenom;
            }

            /**
             * Définit la valeur de la propriété prenom.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPrenom(String value) {
                this.prenom = value;
            }

            @Override
            public String toString() {
                return this.getPrenom() + " " + this.getNom();
            }

        }

    }

}
