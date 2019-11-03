package com.example.miras_lucas_projet_ecole_loustics.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.miras_lucas_projet_ecole_loustics.R;

public class ChoixTypeMultiplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_type_multiplication);
    }
    public void choixTableM(View v){
        Intent intent = new Intent(this,ChoixDifficulteActivity.class);
        intent.putExtra(ChoixDifficulteActivity.NON_JEU,"tm");

    }
}
