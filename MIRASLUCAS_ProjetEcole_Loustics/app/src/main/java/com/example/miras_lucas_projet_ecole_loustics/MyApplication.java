package com.example.miras_lucas_projet_ecole_loustics;

import android.app.Application;
import android.content.Context;


import com.example.miras_lucas_projet_ecole_loustics.DB.Score;
import com.example.miras_lucas_projet_ecole_loustics.DB.User;

public class MyApplication extends Application {
    private static MyApplication instance;
    private User user;
    private Score scoreAdd, scoreMult, scorecultG;

    public static MyApplication getInstance() {
        return instance;
    }
    public static Context getContext(){
        return instance.getApplicationContext();
    }

    public static void setInstance(MyApplication instance) {
        MyApplication.instance = instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Score getScoreAdd() {
        return scoreAdd;
    }

    public void setScoreAdd(Score scoreAdd) {
        this.scoreAdd = scoreAdd;
    }

    public Score getScoreMult() {
        return scoreMult;
    }

    public void setScoreMult(Score scoreMult) {
        this.scoreMult = scoreMult;
    }

    public Score getScorecultG() {
        return scorecultG;
    }

    public void setScorecultG(Score scorecultG) {
        this.scorecultG = scorecultG;
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }


}
