package com.example.miras_lucas_projet_ecole_loustics.DB;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class ExerciceMultiplication extends Exercice {

    @ColumnInfo(name = "resultat")
    private int resultat;

    @ColumnInfo(name = "facteurs")
    private ArrayList<Integer> facteurs = new ArrayList<>();

    public ExerciceMultiplication(String difficulte) {
        super(difficulte);
        setResultat();
        setFacteurs();
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat() {
        switch (getDifficulte()){
            case "facile":
                this.resultat =(int) Math.ceil(2+Math.random() * 20);
                break;
            case "normal":
                this.resultat =(int) Math.ceil(10 + Math.random() * 90);
                break;
            case "difficile":
                this.resultat =(int) Math.ceil(100 + Math.random() * 900);
                break;
        }

    }

    public ArrayList<Integer> getFacteurs() {
        return facteurs;
    }

    public void setFacteurs() {
        this.facteurs.clear();
        this.facteurs.addAll(getNombreMultiplicaiton(getResultat()));
    }

    public boolean verifResultat(ArrayList<Integer> valeursChoisis){
        return (valeursChoisis.get(0) * valeursChoisis.get(1) == this.resultat);
    }

    public List<Integer> getNombreMultiplicaiton(int resultat){
        ArrayList<Integer> facteurs = new ArrayList<>();
        if (resultat % 5 == 0){
            facteurs.add(5);
            facteurs.add(resultat/5);

        }
        else if (resultat % 3 == 0){
            int fact1 = 3;
            int temp = fact1 *  (3 + (int) (Math.random() * 3));
            if (resultat % temp == 0){
                facteurs.add(temp);
                facteurs.add(resultat/temp);
            }
            else {
                while (fact1 < resultat && (resultat % fact1) == 0){
                    fact1 = fact1 + 3;
                }
                fact1 = fact1-3;
                facteurs.add(fact1);
                facteurs.add(resultat/fact1);
            }
        }
        else if( resultat % 2 ==0){
            int fact1 = 2;

            while (fact1 < resultat && (resultat % fact1) == 0){
                fact1 = fact1 + 2;
            }
            fact1 = fact1-2;
            facteurs.add(fact1);
            facteurs.add(resultat/fact1);
        }
        else {
            facteurs.add(resultat);
            facteurs.add(1);

        }

        return facteurs;

    }

    public ArrayList<Integer> getAllValeurs(int nombre) {
        ArrayList<Integer> nombreMelange = new ArrayList<>();
        nombreMelange.add(getFacteurs().get(0));
        nombreMelange.add(getFacteurs().get(1));
        System.out.println(getFacteurs().get(0));
        System.out.println(getFacteurs().get(1));
        for (int i = 0; i < nombre-2;i++){

            nombreMelange.add((int)Math.ceil(Math.random()*getResultat()));
        }
        Collections.shuffle(nombreMelange);
        return nombreMelange;
    }
}
