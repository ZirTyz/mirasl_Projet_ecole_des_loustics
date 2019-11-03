package com.example.miras_lucas_projet_ecole_loustics.DB;


// permet de créer la bdd ! pas obligatoire surement !

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Instance implements Serializable {

    @PrimaryKey
    private int id = 0;

    @ColumnInfo(name = "instance")
    private boolean instance = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instance(int id, boolean instance) {
        this.id = id;
        this.instance = instance;
    }

    public void setInstance(boolean instance) {
        this.instance = instance;
    }

    public boolean isInstance() {
        if(!this.instance){
            createDataBase();
            return this.instance;
        }
        else return this.instance;
    }

    public void createDataBase(){
        // TODO Faire la création de la bdd plus du contenue des exercices !



    }
}
