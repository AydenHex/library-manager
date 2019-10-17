package com.models;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bibliotheque")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bibliotheque {
    @XmlElement(name = "livre")
    private ArrayList<Livre> livres; 
    private String xmlPath;

    public Bibliotheque() {
        this.livres = new ArrayList<Livre>();
    }

    public String getXmlPath() {
        return this.xmlPath;
    }

    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }
    public ArrayList<Livre> getLivres() {
        return this.livres;
    }

    public void setLivres(ArrayList<Livre> livres) {
        this.livres = livres;
    }
    public void marshalingExample(Bibliotheque bib) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Bibliotheque.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        
        //Marshal the employees list in file
        jaxbMarshaller.marshal(this, new File(this.xmlPath));
    }
    public void unMarshalingExample() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Bibliotheque.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        
        //We had written this file in marshalling example
        Bibliotheque emps = (Bibliotheque) jaxbUnmarshaller.unmarshal( new File("Biblio.xml") );
        
        for(Livre emp : emps.getLivres())
        {
            this.livres.add(emp);
        }
    }
}