package com.example.user.cardsadventurer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import card.Card;
import charactor.Charactor;

public class Main2Activity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        level = findViewById(R.id.level_player);
        hpn = findViewById(R.id.hp_player);

        for (int i = 0; i<4; i++)
        {
            monster_stats[i][0]
        }

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
