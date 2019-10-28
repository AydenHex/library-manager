package com.models;

public class State 
{ 
    // static variable single_instance of type State 
    private static State single_instance = null; 
   
    public Bibliotheque bibliotheque;
    public int indiceSelectionned;
  
    // private constructor restricted to this class itself 
    private State() 
    { 
        bibliotheque = new Bibliotheque();
        this.indiceSelectionned = -1;
    } 
  
    // static method to create instance of Singleton class 
    public static State getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new State(); 
  
        return single_instance; 
    } 
} 