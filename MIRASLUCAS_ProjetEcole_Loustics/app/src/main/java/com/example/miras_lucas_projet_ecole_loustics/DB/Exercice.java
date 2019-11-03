package com.example.miras_lucas_projet_ecole_loustics.DB;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class Exercice  implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "difficulte")
    private String difficulte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public Exercice(String difficulte) {
        this.difficulte = difficulte;
    }



// Todo rendre cette classe abstract ou je ne sais pas !
    // Zone vérif mutliplication

    /*
    *
    */

// Todo faire attention au classe abstraite le room peut bloquer ou n'importe; jamais utilisé !




}
