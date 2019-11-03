package com.example.miras_lucas_projet_ecole_loustics.controller;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miras_lucas_projet_ecole_loustics.DB.DatabaseClient;
import com.example.miras_lucas_projet_ecole_loustics.DB.Exercice;
import com.example.miras_lucas_projet_ecole_loustics.DB.ExerciceAddition;
import com.example.miras_lucas_projet_ecole_loustics.DB.ExerciceCultG;
import com.example.miras_lucas_projet_ecole_loustics.DB.ExerciceMultiplication;
import com.example.miras_lucas_projet_ecole_loustics.DB.Pays;
import com.example.miras_lucas_projet_ecole_loustics.DB.Ville;
import com.example.miras_lucas_projet_ecole_loustics.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ExerciceActivity extends AppCompatActivity {

    private DatabaseClient mdb;
    public static final String TYPE_EXO = "type_exo";
    public static final String DIFFICULTE = "difficulte";
    private String typeExo;
    private String difficulte;
    private ArrayList<ExerciceAddition> exerciceA = new ArrayList<>();
    private ArrayList<ExerciceMultiplication> exerciceM = new ArrayList<>();
    private ArrayList<ExerciceCultG> exerciceCG = new ArrayList<>();
    private ArrayList<LinearLayout> layouts = new ArrayList<>();
    private TextView text;
    private ArrayList<Integer> listValeur = new ArrayList<>();
    private ArrayList<Integer> listValeurChoose = new ArrayList<>();
    private ArrayList<String> listVille = new ArrayList<>();
    private ArrayList<String> listVilleChoose = new ArrayList<>();
    private ArrayList<Pays> pays= new ArrayList<>();
    private ArrayList<Ville> villes = new ArrayList<>();
    private int compteur;
    private int numExo;
    private int nbExo;
    private int tailleP = 40;
    private Intent intent;
    private int bonneRep = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);

        typeExo = getIntent().getStringExtra(TYPE_EXO);
        difficulte = getIntent().getStringExtra(DIFFICULTE);
        mdb = DatabaseClient.getInstance(getApplicationContext());
        numExo = 0;



        if (typeExo.matches("cultG")){
            nbExo = 5;




        }
        else {
            nbExo = 10;
            System.out.println(typeExo);
            System.out.println("addition");
            System.out.println(typeExo == "addition");
            if (typeExo.matches("addition")){
                for (int i = 0; i<nbExo; i++){
                    exerciceA.add(new ExerciceAddition(difficulte));
                }

            }
            else {
                for (int i = 0; i<nbExo; i++){
                    exerciceM.add(new ExerciceMultiplication(difficulte));
                }

            }
        }

        // Test
//        typeExo = "multiplication";
//        difficulte = "difficile";
//        exerciceM = new ExerciceMultiplication(difficulte,12);


        layouts.add((LinearLayout) findViewById(R.id.pL1Lin1)); // 0 : layout choix des reponses haut
        layouts.add((LinearLayout) findViewById(R.id.pL1Lin2)); // 1 : layout choix des reponses milieu
        layouts.add((LinearLayout) findViewById(R.id.pL1Lin3)); // 2 : layout choix des reponses bas
        layouts.add((LinearLayout) findViewById(R.id.pL1Lin1));   // 3 : layout nom pays pour cultG Modifier mais pas envie de tout modifier
        layouts.add((LinearLayout) findViewById(R.id.pL2Lin11)); // 4 : layout zone de validation 1
        layouts.add((LinearLayout) findViewById(R.id.pL2Lin12)); // 5 : layout zone de type de calcul
        layouts.add((LinearLayout) findViewById(R.id.pL2Lin13)); // 6 : layout zone de validation 2
        layouts.add((LinearLayout) findViewById(R.id.pL2Lin14)); // 7 : layout zone du egale
        layouts.add((LinearLayout) findViewById(R.id.pL2Lin15)); // 8 : layout zone du resultat

        listValeurChoose.add(0);
        listValeurChoose.add(0);
        listVilleChoose.add("kimper");
        listVilleChoose.add("kimper");
        listVilleChoose.add("kimper");



        // Creation de la vue en fionction du jeu fournis !
        switch (difficulte){
            case "facile" :
                setCaseClickable(2,2, difficulte, typeExo);
                break;
            case "normal" :
                setCaseClickable(3,2, difficulte, typeExo);
                break;
            case "difficile" :
                setCaseClickable(3,3, difficulte, typeExo);
                break;
        }


    }



    public void setCaseClickable(int ligne, int nombre, String difficulte, String typeExo){

        switch (typeExo){
            case "addition" :
                text = new TextView(this);
                setDesign(text,tailleP);
                text.setText("+");
                layouts.get(5).addView(text);
                text = new TextView(this);
                setDesign(text,tailleP);
                text.setText("=");
                layouts.get(7).addView(text);
                text = new TextView(this);
                setDesign(text,tailleP);
                text.setText(Integer.toString(exerciceA.get(numExo).getResultat()));
                layouts.get(8).addView(text);

                listValeur.addAll(exerciceA.get(numExo).getAllValeurs(ligne*nombre));
                setItemInLAyout(ligne,nombre);
                break;
            case "multiplication" :
                text = new TextView(this);
                setDesign(text,tailleP);
                text.setText("x");
                layouts.get(5).addView(text);
                text = new TextView(this);
                setDesign(text,tailleP);
                text.setText("=");
                layouts.get(7).addView(text);
                text = new TextView(this);
                setDesign(text,tailleP);
                text.setText(Integer.toString(exerciceM.get(numExo).getResultat()));
                layouts.get(8).addView(text);


                listValeur.addAll(exerciceM.get(numExo).getAllValeurs(ligne*nombre));
                setItemInLAyout(ligne,nombre);
                break;
            case "cultG" :
                getExerciceCG(ligne,nombre);
                break;



        }



    }

    private void setItemInLAyout(int ligne, int nombre) {
        int compteur =0;
        for (int i =0; i <ligne;i++){
            for (int j= 0; j<nombre; j++){
                text = new TextView(this);

                if (listValeur.isEmpty()){
                    setDesign(text,25);
                    text.setText(listVille.get(compteur));
                    final int finalCompteur1 = compteur;
                    text.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (layouts.get(6).getChildCount() ==0){
                                listVilleChoose.set(0,listVille.get(finalCompteur1));
                                text = new TextView(ExerciceActivity.this);
                                text.setText(listVille.get(finalCompteur1));
                                setDesign(text,tailleP);
                                layouts.get(6).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        layouts.get(6).removeAllViews();
                                        listVilleChoose.set(0,"kimper");
                                    }
                                });
                                layouts.get(6).addView(text);
                            }
                            else if (layouts.get(7).getChildCount() == 0){
                                listVilleChoose.set(1,listVille.get(finalCompteur1));
                                text = new TextView(ExerciceActivity.this);
                                text.setText(listVille.get(finalCompteur1));
                                setDesign(text,tailleP);
                                layouts.get(7).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        layouts.get(7).removeAllViews();
                                        listVilleChoose.set(1,"kimper");
                                    }
                                });
                                layouts.get(7).addView(text);

                            }else if (layouts.get(8).getChildCount() == 0){
                                listVilleChoose.set(2,listVille.get(finalCompteur1));
                                text = new TextView(ExerciceActivity.this);
                                text.setText(listVille.get(finalCompteur1));
                                setDesign(text,tailleP);
                                layouts.get(8).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        layouts.get(8).removeAllViews();
                                        listVilleChoose.set(2,"kimper");
                                    }
                                });
                                layouts.get(8).addView(text);

                            }

                        }
                    });

                }
                else {
                    setDesign(text, tailleP);
                    text.setText(Integer.toString(listValeur.get(compteur)));
                    final int finalCompteur = compteur;
                    text.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (layouts.get(4).getChildCount() ==0){
                                listValeurChoose.set(0,listValeur.get(finalCompteur));
                                text = new TextView(ExerciceActivity.this);
                                text.setText(Integer.toString(listValeur.get(finalCompteur)));
                                setDesign(text,tailleP);
                                layouts.get(4).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        layouts.get(4).removeAllViews();
                                        listValeurChoose.set(0,0);
                                    }
                                });
                                layouts.get(4).addView(text);
                            }
                            else if (layouts.get(6).getChildCount() == 0){
                                listValeurChoose.set(1,listValeur.get(finalCompteur));
                                text = new TextView(ExerciceActivity.this);
                                text.setText(Integer.toString(listValeur.get(finalCompteur)));
                                setDesign(text,tailleP);
                                layouts.get(6).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        layouts.get(6).removeAllViews();
                                        listValeurChoose.set(1,0);
                                    }
                                });
                                layouts.get(6).addView(text);

                            }

                        }
                    });

                }
                compteur++;


                // Définition du Layout à construire.
                LinearLayout postLayout = new LinearLayout(this);
                postLayout.setWeightSum(1);
                postLayout.setPadding(200,0,200,0);

                // Définition de la façon dont le composant va remplir le layout.
                LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

                // Ajout du composant au layout.
                postLayout.addView(text,	layoutParam);
                layouts.get(i).addView(postLayout);


                // todo faire en sorte de faire une fonction dans le modèle qui donne des val au pif !
            }
        }
    }

    private void getExerciceCG(final int ligne, final int nombre) {
        class getExerciceCG extends AsyncTask<Void,Void, List<Pays>>{

            @Override
            protected List<Pays> doInBackground(Void... voids) {
                pays = (ArrayList<Pays>) mdb.getAppDatabase().paysDao().getAll();
                for (int i = 0; i < pays.size(); i++){
                    exerciceCG.add(new ExerciceCultG(difficulte,pays.get(i),(ArrayList<Ville>)mdb.getAppDatabase().villeDao().getAllVilleDunPays(pays.get(i).getNom())));
                }
                listVille.addAll(exerciceCG.get(numExo).getAllValeurs());
                for (int i = 0; i<(ligne*nombre)-3;i++){
                    getUneVille();

                }
                return pays;
            }

            @Override
            protected void onPostExecute(List<Pays> pays) {

                Collections.shuffle(listVille);
                text = new TextView(ExerciceActivity.this);
                setDesign(text,tailleP);
                text.setText(exerciceCG.get(numExo).getPays().getNom() + " : ");
                layouts.get(4).addView(text);
                setItemInLAyout(ligne, nombre);
            }
        }
        getExerciceCG ge = new getExerciceCG();
        ge.execute();
    }

    private void getUneVille() {
        class getUneVille extends AsyncTask<Void,Void,String>{

            @Override
            protected String doInBackground(Void... voids) {
                listVille.add(mdb.getAppDatabase().villeDao().getUneVille().getNom());
                return "OK";
            }
        }
        getUneVille guv = new getUneVille();
        guv.execute();
    }

    public void setDesign(TextView text, int tailleP){
        text.setGravity(View.TEXT_ALIGNMENT_CENTER);
        text.setTextSize(tailleP);
        text.setBackgroundColor(Color.parseColor("#90000000"));
        text.setTextColor(Color.RED);
        text.setPadding(10,0,10,0);
    }

    public void exerciceActivityValider(View v){
        switch (typeExo){
            case "addition" :
                if (exerciceA.get(numExo).verifResultat(listValeurChoose)){
                    bonneRep++;
                }
                break;
            case "multiplication" :
                if (exerciceM.get(numExo).verifResultat(listValeurChoose)){
                    bonneRep++;
                }
                break;
            case "cultG" :
                bonneRep = bonneRep + (exerciceCG.get(numExo).verifResulat(listVilleChoose));
                break;
        }
        if (nbExo-1 == numExo){
            intent = new Intent(this,ResultatActivity.class);
            intent.putExtra(ResultatActivity.TYPE_EXO,typeExo);
            intent.putExtra(ResultatActivity.BONNEREP,Integer.toString(bonneRep));
            startActivity(intent);
        }
        else {
            numExo++;
            listVille.clear();
            listValeur.clear();
            listVilleChoose.clear();
            listValeurChoose.clear();
            listValeurChoose.add(0);
            listValeurChoose.add(0);
            listVilleChoose.add("kimper");
            listVilleChoose.add("kimper");
            listVilleChoose.add("kimper");

            for (int i = 0; i<layouts.size();i++){
                layouts.get(i).removeAllViews();
            }
            switch (difficulte){
                case "facile" :
                    setCaseClickable(2,2, difficulte, typeExo);
                    break;
                case "normal" :
                    setCaseClickable(3,2, difficulte, typeExo);
                    break;
                case "difficile" :
                    setCaseClickable(3,3, difficulte, typeExo);
                    break;
            }
        }
    }


}
