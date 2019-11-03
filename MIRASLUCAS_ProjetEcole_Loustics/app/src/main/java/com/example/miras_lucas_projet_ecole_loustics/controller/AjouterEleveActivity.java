package com.example.miras_lucas_projet_ecole_loustics.controller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miras_lucas_projet_ecole_loustics.DB.DatabaseClient;
import com.example.miras_lucas_projet_ecole_loustics.DB.User;
import com.example.miras_lucas_projet_ecole_loustics.R;

public class AjouterEleveActivity extends AppCompatActivity {

    // DATA
    private DatabaseClient mDb;

    // VIEW
    private EditText editNom;
    private EditText editPrenom;
    private Button ajoutEleve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_eleve);

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        editNom = findViewById(R.id.editNom);
        editPrenom = findViewById(R.id.editPrenom);
        ajoutEleve = findViewById(R.id.button_save);


        ajoutEleve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterEleve();
            }
        });
    }

    private void ajouterEleve() {

        // Récupérer les informations contenues dans la vue
        final String sPrenom = editPrenom.getText().toString().trim();
        final String sNom = editNom.getText().toString().trim();

        // Vérifier les informations fournies par l'utilisateur
        if (sPrenom.isEmpty()) {
            editPrenom.setError("Prenom required");
            editPrenom.requestFocus();
            return;
        }

        if (sNom.isEmpty()) {
            editNom.setError("Nom required");
            editNom.requestFocus();
            return;
        }

        class AjouterEleve extends AsyncTask<Void, Void, User> {


            @Override
            protected User doInBackground(Void... voids) {
                // creation a User
                User user = new User();
                user.setNom(sNom);
                user.setPrenom(sPrenom);

                // adding to database
                mDb.getAppDatabase()
                        .userDao()
                        .insert(user);

                return user;
            }

            // A Voir pour voir les différences
            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);

                // Quand la tache est créée, on arrête l'activité AddTaskActivity (on l'enleve de la pile d'activités)
                setResult(RESULT_OK);
                finish();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }


        AjouterEleve ae = new AjouterEleve();
        ae.execute();

    }
}
