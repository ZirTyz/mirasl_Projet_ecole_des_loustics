package com.example.miras_lucas_projet_ecole_loustics.controller;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.miras_lucas_projet_ecole_loustics.DB.Score;
import com.example.miras_lucas_projet_ecole_loustics.MyApplication;
import com.example.miras_lucas_projet_ecole_loustics.R;

public class ChoixDifficulteActivity extends AppCompatActivity {

    public static final String NON_JEU = "nom_jeu";
    public static final String TYPE_EXO = "type_exo";
    private String nomJeu, typeExo;
    private Intent intent;
    private TextView score;
    private Button normal,difficile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_difficulte);
        nomJeu = getIntent().getStringExtra(NON_JEU);
        typeExo = getIntent().getStringExtra(TYPE_EXO);
        score = findViewById(R.id.Score);
        normal = findViewById(R.id.normal);
        difficile = findViewById(R.id.difficile);
        switch (typeExo){
            case "addition" :
                score.setText("Score : " + MyApplication.getInstance().getScoreAdd().getScore());
                if (MyApplication.getInstance().getScoreAdd().getScore() <10){
                    normal.setText("Score de 10 minimum");
                    normal.setTextColor(Color.BLACK);
                    normal.setEnabled(false);
                    difficile.setText("Score de 20 minimum");
                    difficile.setTextColor(Color.BLACK);
                    difficile.setEnabled(false);
                } else if (MyApplication.getInstance().getScoreAdd().getScore() <20){
                    difficile.setText("Score de 20 minimum");
                    difficile.setTextColor(Color.BLACK);
                    difficile.setEnabled(false);
                }

                break;
            case "multiplication" :
                score.setText("Score : " + MyApplication.getInstance().getScoreMult().getScore());
                if (MyApplication.getInstance().getScoreMult().getScore() <10){
                    normal.setText("Score de 10 minimum");
                    normal.setTextColor(Color.BLACK);
                    normal.setEnabled(false);
                    difficile.setText("Score de 20 minimum");
                    difficile.setTextColor(Color.BLACK);
                    difficile.setEnabled(false);
                } else if (MyApplication.getInstance().getScoreMult().getScore() <20){
                    difficile.setText("Score de 20 minimum");
                    difficile.setTextColor(Color.BLACK);
                    difficile.setEnabled(false);
                }

                break;
            case "cultG" :
                score.setText("Score : " + MyApplication.getInstance().getScorecultG().getScore());
                if (MyApplication.getInstance().getScorecultG().getScore() <10){
                    normal.setText("Score de 10 minimum");
                    normal.setTextColor(Color.BLACK);
                    normal.setEnabled(false);
                    difficile.setText("Score de 20 minimum");
                    difficile.setTextColor(Color.BLACK);
                    difficile.setEnabled(false);
                } else if (MyApplication.getInstance().getScorecultG().getScore() <20){
                    difficile.setText("Score de 20 minimum");
                    difficile.setTextColor(Color.BLACK);
                    difficile.setEnabled(false);
                }

                break;
        }

    }

    public void choixDifficulteFacile(View v){
        intent = new Intent(this,ExerciceActivity.class);
        intent.putExtra(ExerciceActivity.TYPE_EXO,typeExo);
        intent.putExtra(ExerciceActivity.DIFFICULTE,"facile");

        startActivity(intent);


    }
    public void choixDifficulteNormal(View v){
        intent = new Intent(this,ExerciceActivity.class);
        intent.putExtra(ExerciceActivity.TYPE_EXO,typeExo);
        intent.putExtra(ExerciceActivity.DIFFICULTE,"normal");

        startActivity(intent);


    }
    public void choixDifficulteDifficile(View v){
        intent = new Intent(this,ExerciceActivity.class);
        intent.putExtra(ExerciceActivity.TYPE_EXO,typeExo);
        intent.putExtra(ExerciceActivity.DIFFICULTE,"difficile");

        startActivity(intent);


    }


}
