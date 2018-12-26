package com.example.user.cardsadventurer2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

import charactor.Charactor;


public class MainActivity extends AppCompatActivity {

    Button bstart;
    Button bcontinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bstart = findViewById(R.id.btn_sta);
        bcontinue = findViewById(R.id.btn_con);

        int[] player_stats = {player.level, player.health,player.mana,player.experience,player.money};
        int[] old_player ;

        final Intent intent = new Intent(MainActivity.this, Main2Activity.class);

        Bundle bundle = new Bundle();
        bundle.putIntArray("new",player_stats);

        bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        bcontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    Charactor player = new Charactor("愚蠢的人", 1, 20, 1, 2,25);
}