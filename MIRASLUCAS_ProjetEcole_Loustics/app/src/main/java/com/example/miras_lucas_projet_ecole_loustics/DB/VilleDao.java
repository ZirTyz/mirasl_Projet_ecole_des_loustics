package com.example.miras_lucas_projet_ecole_loustics.DB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface VilleDao  {

    @Query("SELECT * FROM Ville")
    List<Ville> getAll();

    @Query("SELECT * FROM Ville WHERE nomPays = :nompays")
    List<Ville> getAllVilleDunPays(String nompays);

    @Query("SELECT * FROM Ville Order by Random() LIMIT 1")
    Ville getUneVille();

    @Insert
    void insert(Ville ville);

    @Insert
    long[] insertAll(Ville... villes);

    @Delete
    void delete(Ville ville);

    @Update
    void update(Ville ville);
}
