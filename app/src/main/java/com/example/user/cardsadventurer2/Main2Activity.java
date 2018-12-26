package com.example.user.cardsadventurer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import card.Card;
import charactor.Charactor;

public class Main2Activity extends AppCompatActivity {

    TextView target;
    TextView conversation;
    TextView name_item;
    TextView intro_item;
    TextView level;
    TextView hp, hpn;
    TextView mp, mpn;
    TextView exp, expn;
    TextView money;

    Bundle bundle1 = getIntent().getExtras().getBundle("new");
    int[] player_stats = bundle1.getIntArray("new");

    Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
    Bundle bundle3 = new Bundle();

    int n = 0;
    int[][] monster_stats;

    Button card;
    Button skill;
    TextView card_left;
    ImageButton event1, event2, event3;
    TextView ntro_event;
    ImageView item1, item2, item3;
    Button get1, get2, get3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        level = findViewById(R.id.level_player);
        hpn = findViewById(R.id.hp_player);

        bundle3.putIntArray("monster", monster_stats[0]);

    }
    Charactor monster[] = {
            new Charactor("蝙蝠", 1,3,1,1,3),
            new Charactor("樹精", 2, 12, 3, 3, 7),
            new Charactor("梅杜莎",3, 15, 4, 6, 20)};

    Charactor boss[] = {new Charactor("劍客", 4, 48, 4, 0, 0)};

    Card cardlist[] = {
            new Card("火球", "火", 1, 1, 3),
            new Card("火球", "火", 2, 2, 8)
    };
}
