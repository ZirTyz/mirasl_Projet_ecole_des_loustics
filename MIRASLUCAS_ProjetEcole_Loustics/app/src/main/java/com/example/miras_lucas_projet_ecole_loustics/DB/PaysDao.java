package com.example.miras_lucas_projet_ecole_loustics.DB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface PaysDao {

    @Query("SELECT * FROM Pays")
    List<Pays> getAll();

    @Insert
    void insert(Pays pays);

    @Insert
    long[] insertAll(Pays... pays);

    @Delete
    void delete(Pays pays);

    @Update
    void update(Pays pays);
}
