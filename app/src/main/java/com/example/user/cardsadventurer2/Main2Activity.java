package com.example.user.cardsadventurer2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import charactor.Charactor;

public class Main2Activity extends AppCompatActivity {

    TextView level;
    TextView hp, hpn;
    TextView mp, mpn;
    TextView exp, expn;
    TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        level = findViewById(R.id.level_player);
        hpn = findViewById(R.id.hp_player);
    }

    Charactor monster[] = { new Charactor("蝙蝠", 1,3,1,1,3),
            new Charactor("樹精", 2, 12, 3, 3, 7),
            new Charactor("梅杜莎",3, 15, 4, 6, 20)};

    Charactor boss[] = {new Charactor("劍客", 4, 48, 4, 0, 0)};
}
