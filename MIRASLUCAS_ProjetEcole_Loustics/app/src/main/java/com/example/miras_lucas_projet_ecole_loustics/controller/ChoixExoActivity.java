package com.example.miras_lucas_projet_ecole_loustics.controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.miras_lucas_projet_ecole_loustics.DB.DatabaseClient;
import com.example.miras_lucas_projet_ecole_loustics.DB.Score;
import com.example.miras_lucas_projet_ecole_loustics.MyApplication;
import com.example.miras_lucas_projet_ecole_loustics.R;

import java.util.ArrayList;
import java.util.List;

public class ChoixExoActivity extends AppCompatActivity {

    private Intent intent;
    private DatabaseClient mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_exo);
        mdb = DatabaseClient.getInstance(getApplicationContext());

        getScore();

    }
    public void choixExoMultiplication(View v){
        intent = new Intent(this,ChoixDifficulteActivity.class);
        intent.putExtra(ChoixDifficulteActivity.TYPE_EXO,"multiplication");

        startActivity(intent);


    }
    public void choixExoAddition(View v){
        intent = new Intent(this,ChoixDifficulteActivity.class);
        intent.putExtra(ChoixDifficulteActivity.TYPE_EXO,"addition");


        startActivity(intent);


    }
    public void choixExoCultG(View v){
        intent = new Intent(this,ChoixDifficulteActivity.class);
        intent.putExtra(ChoixDifficulteActivity.TYPE_EXO,"cultG");


        startActivity(intent);


    }

    public void getScore(){
        class getScore extends AsyncTask<Void,Void, List<Score>>{

            @Override
            protected List<Score> doInBackground(Void... voids) {
                ArrayList<Score> scoresUser = new ArrayList<>();
                scoresUser = (ArrayList) mdb.getAppDatabase().scoreDao().getScoreforUser(MyApplication.getInstance().getUser().getId());
                if (scoresUser.isEmpty()){
                    // création des scores s'il n'existe pas et les mettre dans la bdd
                    Score scoreA,scoreM,scoreCG;
                    int idUser = MyApplication.getInstance().getUser().getId();
                    scoresUser.add( new Score(idUser,0,"addition"));
                    scoresUser.add( new Score(idUser,0,"multiplication"));
                    scoresUser.add( new Score(idUser,0,"cultG"));
                    for (int i = 0; i<scoresUser.size();i++) {
                        mdb.getAppDatabase().scoreDao().insert(scoresUser.get(i));
                    }
                }

                return scoresUser;
            }

            @Override
            protected void onPostExecute(List<Score> scores) {
                for (int i = 0; i < scores.size(); i++){
                    switch (scores.get(i).getTypeExo()){
                        case "addition" :
                            MyApplication.getInstance().setScoreAdd(scores.get(i));
                            break;
                        case "multiplication" :
                            MyApplication.getInstance().setScoreMult(scores.get(i));
                            break;
                        case "cultG" :
                            MyApplication.getInstance().setScorecultG(scores.get(i));
                    }
                }
            }
        }

        getScore gs = new getScore();
        gs.execute();
    }
}
// Ici startActivityForResult pour sauvegarder le résultat du joueur !