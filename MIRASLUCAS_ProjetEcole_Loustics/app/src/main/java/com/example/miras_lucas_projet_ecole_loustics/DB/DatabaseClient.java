package com.example.miras_lucas_projet_ecole_loustics.DB;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.concurrent.Executors;


public class DatabaseClient {
    // Instance unique permettant de faire le lien avec la base de données
    private static DatabaseClient instance;

    // Objet représentant la base de données de votre application
    private AppDatabase appDatabase;

    // Constructeur
    private DatabaseClient(final Context context) {

        // Créer l'objet représentant la base de données de votre application
        // à l'aide du "Room database builder"
        // MyToDos est le nom de la base de données
        //appDatabase = Room.databaseBuilder(context, AppDatabase.class, "MyToDos").build();

        // Ajout de la méthode addCallback permettant de populate (remplir) la base de données à sa création
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "EcoleDesLoustics").addCallback(roomDatabaseCallback).build();
    }

    // Méthode statique
    // Retourne l'instance de l'objet DatabaseClient
    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseClient(context);
        }
        return instance;
    }

    // Retourne l'objet représentant la base de données de votre application
    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    // Objet permettant de populate (remplir) la base de données à sa création
    RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {

        // Called when the database is created for the first time.
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // TODO remplir la bdd ici
            db.execSQL("INSERT INTO User (nom,prenom) VALUES (\"Anonyme\",\"Anonyme\")");
            db.execSQL("INSERT INTO User (nom,prenom) VALUES (\"Cartman\",\"Eric\")");
            db.execSQL("INSERT INTO User (nom,prenom) VALUES (\"Stotch\",\"Butters\")");
            db.execSQL("INSERT INTO Pays (nom,nomVille1,nomVille2,nomVille3) VALUES (\"France\",\"Paris\",\"Lyon\",\"Marseille\")");
            db.execSQL("INSERT INTO Pays (nom,nomVille1,nomVille2,nomVille3) VALUES (\"Espagne\",\"Madrid\",\"Barcelone\",\"Murcia\")");
            db.execSQL("INSERT INTO Pays (nom,nomVille1,nomVille2,nomVille3) VALUES (\"Etats-Unis\",\"Boston\",\"Chicago\",\"Washington\")");
            db.execSQL("INSERT INTO Pays (nom,nomVille1,nomVille2,nomVille3) VALUES (\"Russie\",\"Moscou\",\"Sotchi\",\"Kazan\")");
            db.execSQL("INSERT INTO Pays (nom,nomVille1,nomVille2,nomVille3) VALUES (\"Japon\",\"Tokyo\",\"Kyoto\",\"Osaka\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Tokyo\",\"Japon\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Kyoto\",\"Japon\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Osaka\",\"Japon\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Moscou\",\"Russie\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Sotchi\",\"Russie\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Kazan\",\"Russie\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Paris\",\"France\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Lyon\",\"France\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Marseille\",\"France\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Madrid\",\"Espagne\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Barcelone\",\"Espagne\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Murcia\",\"Espagne\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Boston\",\"Etats-Unis\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Chicago\",\"Etats-Unis\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Washington\",\"Etats-Unis\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Pekin\",\"Chine\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Shanghai\",\"Japon\")");
            db.execSQL("INSERT INTO Ville (nom,nomPays) VALUES (\"Tianjin\",\"Japon\")");


        }
    };

}
