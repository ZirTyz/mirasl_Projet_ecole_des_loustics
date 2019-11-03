package com.example.miras_lucas_projet_ecole_loustics.DB;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity
public class Ville implements Serializable {

    @PrimaryKey
    @NonNull
    private String nom;

    @ColumnInfo(name = "nomPays")
    private String nomPays;

    public Ville(String nom, String nomPays) {
        this.nom = nom;
        this.nomPays = nomPays;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }
}
