package com.example.miras_lucas_projet_ecole_loustics.controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.miras_lucas_projet_ecole_loustics.DB.DatabaseClient;
import com.example.miras_lucas_projet_ecole_loustics.DB.User;
import com.example.miras_lucas_projet_ecole_loustics.MyApplication;
import com.example.miras_lucas_projet_ecole_loustics.R;

public class MainActivity extends AppCompatActivity {
    private DatabaseClient mdb;
    private Intent intent;
    private User anonyme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdb = DatabaseClient.getInstance(getApplicationContext());
    }

    public void mainActivityClasse(View v){
        intent = new Intent(this,ListeEleveActivity.class);
        startActivity(intent);
    }

    public void mainActivityAnonyme(View v){
        getAnonyme();

    }

    private void getAnonyme() {
        class getAnonyme extends AsyncTask<Void,Void, User>{

            @Override
            protected User doInBackground(Void... voids) {
                anonyme = mdb.getAppDatabase().userDao().getAnonyme();
                return anonyme;
            }

            @Override
            protected void onPostExecute(User user) {
                MyApplication.getInstance().setUser(user);
                intent = new Intent(MainActivity.this, ChoixExoActivity.class);

                startActivity(intent);
            }
        }
        getAnonyme ge = new getAnonyme();
        ge.execute();
    }
}
// TOdo faire l'activité result qui regarde le nombre de bonne rep < 50% pas d'ajout > 50% ajout de 5 points
// difficulté : pour calcul facile : 4 valeurs dispo et result comris entre 0 et 20
// normal 6 valeusr dispo et result compris entre 10 et 100
// dur 9 valeurs de dispo et result entre 100 et 1000
// Pour cult G 5 question par difficulté : recherche de ville et de pays !
