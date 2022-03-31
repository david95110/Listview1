package com.example.listview1.controller;

import com.example.listview1.model.Personne;

import java.util.ArrayList;

public class DaoPersonne {
    //on definit un ArrayList pour stocker les personnes
    static ArrayList<Personne> list = new ArrayList<>();
    public static void addPersonne(Personne personne){
        list.add(personne);
    }
}
