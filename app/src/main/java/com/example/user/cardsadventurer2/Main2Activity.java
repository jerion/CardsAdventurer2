package com.example.user.cardsadventurer2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

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
    Button card;
    Button skill;
    TextView card_left;
    ImageButton event1, event2, event3;
    TextView intro_event;
    ImageView item1, item2, item3;
    Button get1, get2, get3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        target = findViewById(R.id.name_target);
        conversation = findViewById(R.id.conversation);
        name_item = findViewById(R.id.name_item);
        intro_item = findViewById(R.id.intro_item);
        level = findViewById(R.id.level_player);
        hp = findViewById(R.id.hp_player);
        hpn = findViewById(R.id.hp_player);
        mp = findViewById(R.id.sp_player);
        mpn = findViewById(R.id.sp_player);
        exp = findViewById(R.id.exp_player);
        expn = findViewById(R.id.exp_player);
        money = findViewById(R.id.gold);
        card = findViewById(R.id.btn_card_player);
        skill = findViewById(R.id.btn_skill);
        card_left = findViewById(R.id.card_left);
        event1 = findViewById(R.id.imbtn_event1);
        event2 = findViewById(R.id.imbtn_event2);
        event3 = findViewById(R.id.imbtn_event3);
        intro_event = findViewById(R.id.intro_event);
        item1 = findViewById(R.id.im_item1);
        item2 = findViewById(R.id.im_item2);
        item3 = findViewById(R.id.im_item3);
        get1 = findViewById(R.id.btn_get1);
        get2 = findViewById(R.id.btn_get2);
        get3 = findViewById(R.id.btn_get3);
    }
}
