package com.example.miras_lucas_projet_ecole_loustics.DB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ScoreDao {
    @Query("SELECT * FROM Score")
    List<Score> getAll();

    @Query("SELECT * FROM Score where idUser = :idU")
    List<Score> getScoreforUser(int idU);
    @Insert
    void insert(Score score);

    @Insert
    long[] insertAll(Score... scores);

    @Delete
    void delete(Score score);

    @Update
    void update(Score score);
}
