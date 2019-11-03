package com.example.miras_lucas_projet_ecole_loustics.DB;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity
public class Pays implements Serializable {

    @PrimaryKey @NonNull
    private String nom;

    @ColumnInfo(name = "nomVille1")
    private String nomVille1;

    @ColumnInfo(name = "nomVille2")
    private String nomVille2;

    @ColumnInfo(name = "nomVille3")
    private String nomVille3;

    public Pays(String nom, String nomVille1, String nomVille2, String nomVille3) {
        this.nom = nom;
        this.nomVille1 = nomVille1;
        this.nomVille2 = nomVille2;
        this.nomVille3 = nomVille3;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomVille1() {
        return nomVille1;
    }

    public void setNomVille1(String nomVille1) {
        this.nomVille1 = nomVille1;
    }

    public String getNomVille2() {
        return nomVille2;
    }

    public void setNomVille2(String nomVille2) {
        this.nomVille2 = nomVille2;
    }

    public String getNomVille3() {
        return nomVille3;
    }

    public void setNomVille3(String nomVille3) {
        this.nomVille3 = nomVille3;
    }
}
