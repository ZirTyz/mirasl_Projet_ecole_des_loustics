package com.example.miras_lucas_projet_ecole_loustics.controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.miras_lucas_projet_ecole_loustics.DB.DatabaseClient;
import com.example.miras_lucas_projet_ecole_loustics.DB.Score;
import com.example.miras_lucas_projet_ecole_loustics.MyApplication;
import com.example.miras_lucas_projet_ecole_loustics.R;

public class ResultatActivity extends AppCompatActivity {

    public static final String BONNEREP = "0";
    public static final String TYPE_EXO = "type_exo";
    private String bonneRep;
    private String typeExo;
    private boolean bon = false;
    private Intent intent;
    private DatabaseClient mdb;
    private TextView textScore;
    private String nbPointMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bonneRep = getIntent().getStringExtra(BONNEREP);
        typeExo = getIntent().getStringExtra(TYPE_EXO);
        mdb = DatabaseClient.getInstance(getApplicationContext());
        switch (typeExo){
            case "addition" :
                if (Integer.parseInt(bonneRep)>=5){
                    bon = true;
                    MyApplication.getInstance().getScoreAdd().setScore(MyApplication.getInstance().getScoreAdd().getScore() + 5);
                    System.out.println(MyApplication.getInstance().getScoreAdd().getScore());

                }
                setDBScore();
                nbPointMax = "10";
                break;
            case "multiplication" :
                if (Integer.parseInt(bonneRep)>=5){
                    bon = true;
                    MyApplication.getInstance().getScoreMult().setScore(MyApplication.getInstance().getScoreMult().getScore() + 5);


                }
                setDBScore();
                nbPointMax = "10";
                break;
            case "cultG" :
                if (Integer.parseInt(bonneRep)>=8){
                    bon = true;
                    MyApplication.getInstance().getScorecultG().setScore(MyApplication.getInstance().getScorecultG().getScore() + 5);


                }
                setDBScore();
                nbPointMax = "15";
                break;
        }

        if (bon) {
            setContentView(R.layout.activity_resultat_bon);
        }else {
            setContentView(R.layout.activity_resultat_mauvais);
        }

        textScore = findViewById(R.id.Score);
        textScore.setText(bonneRep + " sur " + nbPointMax);
    }
    public void goToMenu(View v){
        intent = new Intent(this,ChoixExoActivity.class);
        startActivity(intent);
    }

    public void setDBScore(){
        class setDBScore extends AsyncTask<Void,Void,Score> {

            @Override
            protected Score doInBackground(Void... voids) {
                mdb.getAppDatabase().scoreDao().update(MyApplication.getInstance().getScoreAdd());
                mdb.getAppDatabase().scoreDao().update(MyApplication.getInstance().getScoreMult());
                mdb.getAppDatabase().scoreDao().update(MyApplication.getInstance().getScorecultG());
                return (MyApplication.getInstance().getScorecultG());
            }
        }
        setDBScore ss = new setDBScore();
        ss.execute();
    }
}
