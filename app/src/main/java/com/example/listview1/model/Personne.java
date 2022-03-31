package com.example.listview1.model;

import java.io.Serializable;
//on sérialise l'objet Personne,cad le convertir en chaine pour être envoyé
//à l'autre Avivity, qui va le désérialiser en objet
public class Personne implements Serializable {
    private int id;
    private String nom, prenom;


    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
