package com.example.miras_lucas_projet_ecole_loustics.DB;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import java.io.Serializable; // voir si obligé
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*@Entity*/
public class ExerciceAddition extends Exercice {


    private int resultat;

    private ArrayList<Integer> membres = new ArrayList<>();

    public ExerciceAddition(String difficulte) {
        super(difficulte);
        setResultat();
        setMembres();
    }

    public List<Integer> getNombreAddition(int resultat){
        ArrayList<Integer> membres = new ArrayList<>();
        if(resultat <=2){
            membres.add(resultat);
            membres.add(0);
        }
        else {
            double memb1,memb2;
            memb1 = Math.ceil(resultat/2) + (Math.random() * ((Math.ceil(resultat/2)) -1 ));
            memb1 = Math.ceil(memb1);
            memb2 = resultat - memb1;
            membres.add((int) memb1);
            membres.add((int) memb2);
        }
        return membres;


    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat() {
        switch (getDifficulte()){
            case "facile":
                this.resultat =(int) Math.ceil(1+Math.random() * 20);
                break;
            case "normal":
                this.resultat =(int) Math.ceil(10 + Math.random() * 90);
                break;
            case "difficile":
                this.resultat =(int) Math.ceil(100 + Math.random() * 900);
                break;
        }

    }

    public ArrayList<Integer> getMembres() {
        return membres;
    }

    public void setMembres() {
        this.membres.clear();
        this.membres.addAll(getNombreAddition(this.resultat));
    }

    public boolean verifResultat(ArrayList<Integer> valeursChoisis){
        return (valeursChoisis.get(0) + valeursChoisis.get(1) == this.resultat);
    }

    public ArrayList<Integer> getAllValeurs(int nombre) {
        ArrayList<Integer> nombreMelange = new ArrayList<>();
        nombreMelange.add(getMembres().get(0));
        nombreMelange.add(getMembres().get(1));
        for (int i = 0; i < nombre-2;i++){

            nombreMelange.add((int)Math.ceil(Math.random()*getResultat()));
        }
        Collections.shuffle(nombreMelange);
        return nombreMelange;
    }

    // Todo verif des calculs pour addition et multiplication


}
