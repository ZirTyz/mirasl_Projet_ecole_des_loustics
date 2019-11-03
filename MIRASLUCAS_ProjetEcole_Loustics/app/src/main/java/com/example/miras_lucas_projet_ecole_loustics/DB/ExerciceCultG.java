package com.example.miras_lucas_projet_ecole_loustics.DB;


import android.arch.persistence.room.Entity;

import java.util.ArrayList;

@Entity
public class ExerciceCultG extends Exercice {

    private Pays pays;
    private ArrayList<Ville> villes;
    private DatabaseClient mdb;

    public ExerciceCultG(String difficulte, Pays pays, ArrayList<Ville> villes) {
        super(difficulte);
        this.pays = pays;
        this.villes = villes;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public ArrayList<Ville> getVilles() {
        return villes;
    }

    public void setVilles(ArrayList<Ville> villes) {
        this.villes = villes;
    }

    public int verifResulat(ArrayList<String> nomVilles){
        int nbBonneRep = 0;
        int compteur;
        for (int i =0; i<nomVilles.size(); i++){
            compteur = 0;
            while (compteur<this.villes.size() && this.villes.get(compteur).getNom() != nomVilles.get(i)){
                compteur++;
            }
            if (compteur !=this.villes.size()){
                nbBonneRep++;
            }

        }

        return nbBonneRep;
    }

    public ArrayList<String> getAllValeurs() {
        ArrayList<String> nomVilles = new ArrayList<>();
        nomVilles.add(villes.get(0).getNom());
        nomVilles.add(villes.get(1).getNom());
        nomVilles.add(villes.get(2).getNom());
        return nomVilles;
    }
}
