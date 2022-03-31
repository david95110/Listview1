package com.example.listview1.controller;

import com.example.listview1.model.Personne;

import java.util.ArrayList;

public class DaoPersonne {
    //on definit un ArrayList pour stocker les personnes
    static ArrayList<Personne> list = new ArrayList<>();
    // l!arrayList (ça pourrait être dans une DB)
    public static void addPersonne(Personne personne){
        list.add(personne);
    }
    // cette methode permet de recuperer la liste des personnes
    // qui peuvent provenir d'une même DB
    public static ArrayList<Personne> getAllPersonnes(){
        return list;
    }
}
