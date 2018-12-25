package com.example.user.cardsadventurer2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import charactor.Charactor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Charactor witch;
    Charactor monster1;

    int level = witch.level;

    public void setWitch(Charactor witch) {
        this.witch = witch;
        witch.setcharactor(1,20,1,2);
    }

    public void setMonster1(Charactor monster1) {
        this.monster1 = monster1;
        monster1.setcharactor(1,5,1,1);
    }
}

