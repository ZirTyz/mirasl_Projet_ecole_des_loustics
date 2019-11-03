package com.example.miras_lucas_projet_ecole_loustics.DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

//@Database(entities = {User.class, ExerciceAddition.class,ExerciceCultG.class,ExerciceMultiplication.class,Score.class,Ville.class,Pays.class}, version = 1, exportSchema = false)
//public abstract class AppDatabase extends RoomDatabase{
@Database(entities = {User.class,Score.class,Ville.class,Pays.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

    public abstract UserDao userDao();
/*    public abstract ExerciceAdditionDao exerciceAdditionDao();
    public abstract ExerciceMultiplicationDao exerciceMultiplicationDao();
    public abstract ExerciceCultGDao exerciceCultGDao();*/
    public abstract ScoreDao scoreDao();
    public abstract PaysDao paysDao();
    public abstract VilleDao villeDao();
}
