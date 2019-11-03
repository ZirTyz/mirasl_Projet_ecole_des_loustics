package com.example.miras_lucas_projet_ecole_loustics.DB;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ForeignKey;
import java.io.Serializable;

@Entity
public class Score implements Serializable {

    @PrimaryKey (autoGenerate = true)
    private int id;

    @ColumnInfo(name = "idUser")
    private int idUser;

    @ColumnInfo(name = "score")
    private int score = 0;

    // Pourrait être de type énum mais je n'ai as envie de surcharger l'app pour rien !
    @ColumnInfo(name = "typeExo")
    private String typeExo; // addition ou multiplication ou cultG


    // todo : score permet de débloquer les niveau de difficulté

    public Score(int idUser, int score, String typeExo) {
        this.idUser = idUser;
        this.score = score;
        this.typeExo = typeExo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTypeExo() {
        return typeExo;
    }

    public void setTypeExo(String typeExo) {
        this.typeExo = typeExo;
    }



}
