package com.example.user.cardsadventurer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import charactor.Charactor;


public class MainActivity extends AppCompatActivity {

    Button bstart;
    Button bcontinue;
    Charactor player = new Charactor("愚蠢的人", 1, 20, 1, 0,25);

    int stage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bstart = findViewById(R.id.btn_sta);
        bcontinue = findViewById(R.id.btn_con);

        final int[] player_stats = {player.Level, player.health, player.mana, player.experience, player.Money, stage};
        int[] old_player;
        final ArrayList<Integer> card_hand = new ArrayList<>();
        card_hand.add(0);
        card_hand.add(0);
        card_hand.add(4);
        card_hand.add(4);
        card_hand.add(10);
        card_hand.add(10);
        card_hand.add(13);
        card_hand.add(13);
        card_hand.add(17);
        card_hand.add(17);

        bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                intent.setClass(MainActivity.this, Main2Activity.class);
                bundle.putInt("lv", player_stats[0]);
                bundle.putInt("hp", player_stats[1]);
                bundle.putInt("mp", player_stats[2]);
                bundle.putInt("exp", player_stats[3]);
                bundle.putInt("money", player_stats[4]);
                bundle.putInt("stage", player_stats[5]);
                bundle.putIntegerArrayList("card", card_hand);

                intent.putExtra("new", bundle);
                startActivity(intent);
                finish();
            }
        });

        bcontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "開發中功能，無作用", Toast.LENGTH_SHORT).show();
            }
        });
    }
}