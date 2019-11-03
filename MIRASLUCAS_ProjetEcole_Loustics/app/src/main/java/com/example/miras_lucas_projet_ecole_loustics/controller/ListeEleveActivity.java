package com.example.miras_lucas_projet_ecole_loustics.controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.miras_lucas_projet_ecole_loustics.DB.DatabaseClient;
import com.example.miras_lucas_projet_ecole_loustics.DB.User;
import com.example.miras_lucas_projet_ecole_loustics.MyApplication;
import com.example.miras_lucas_projet_ecole_loustics.R;

import java.util.ArrayList;
import java.util.List;

public class ListeEleveActivity extends AppCompatActivity {

    private DatabaseClient mDb;
    private ListeEleveAdapter adapter;
    private Intent intent;

    private ListView listEleve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_eleve);

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // récupérer les vues
        listEleve = findViewById(R.id.listEleve);

        adapter = new ListeEleveAdapter(this, new ArrayList<User>());
        listEleve.setAdapter(adapter);

        // Ajout d'un événement click à la listeView
        listEleve.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = adapter.getItem(position);

                MyApplication.getInstance().setUser(user);

                intent = new Intent(ListeEleveActivity.this, ChoixExoActivity.class);

                startActivity(intent);
                // todo : cf : soft'war employé ! Zone du code pour l'instance de l'élève ! A FAIRE !!!!!!!!!!!!!
            }
        });

        getUsers();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // récupérer les vues
        listEleve = findViewById(R.id.listEleve);

        adapter = new ListeEleveAdapter(this, new ArrayList<User>());
        listEleve.setAdapter(adapter);

        // Ajout d'un événement click à la listeView
        listEleve.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = adapter.getItem(position);

                MyApplication.getInstance().setUser(user);

                intent = new Intent(ListeEleveActivity.this, ChoixExoActivity.class);

                startActivity(intent);
                // todo : cf : soft'war employé ! Zone du code pour l'instance de l'élève ! A FAIRE !!!!!!!!!!!!!
            }
        });

        getUsers();
    }

    private void getUsers() {
        class getUsers extends AsyncTask<Void,Void, List<User>>{

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> userList = mDb.getAppDatabase()
                        .userDao()
                        .getAll();

                return userList;
            }

            @Override
            protected void onPostExecute(List<User> userList) {
                super.onPostExecute(userList);

                // Mettre à jour l'adapter avec la liste des users
                adapter.clear();
                adapter.addAll(userList);

                // Notifier l'adapter du changement
                adapter.notifyDataSetChanged();
            }
        }

        getUsers gu =new getUsers();
        gu.execute();

    }

    public void nouveauEleve(View v){
        intent = new Intent(this,AjouterEleveActivity.class);
        startActivity(intent);
    }
}
