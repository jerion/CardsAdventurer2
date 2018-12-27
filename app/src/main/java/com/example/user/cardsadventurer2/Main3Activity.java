package com.example.user.cardsadventurer2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView hp_enemy, mp_enemy, hp_player, mp_player;
    TextView hpn_enemy, mpn_enemy, hpn_player, mpn_player;
    TextView level_enemy, gear_enemy, status_enemy, level_player, gear_player, status_player;
    TextView name_target, intro_target, card_enemy, card_num_in_hand;
    Button btn_card_enemy, btn_graveyard_enemy, btn_card_player, btn_graveyard_player, btn_skill, btn_end_turn;
    ImageButton imbtn_item;
    ImageView im_enemy;
    ListView card_battlefield, card_player;

    String enemy_name;
    int[] enemy_stats = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        level_enemy = findViewById(R.id.level_enemy);
        hp_enemy = findViewById(R.id.hp_enemy);
        mp_enemy = findViewById(R.id.sp_enemy);
        gear_enemy = findViewById(R.id.gear_enemy);
        status_enemy = findViewById(R.id.status_enemy);
        name_target = findViewById(R.id.name_target);
        intro_target = findViewById(R.id.intro_target);
        level_player = findViewById(R.id.level_player);
        hp_player = findViewById(R.id.hp_player);
        mp_player = findViewById(R.id.sp_player);
        gear_player = findViewById(R.id.gear_player);
        status_player = findViewById(R.id.status_player);
        card_enemy = findViewById(R.id.card_enemy);
        card_num_in_hand = findViewById(R.id.card_num_in_hand);
        btn_card_enemy = findViewById(R.id.btn_card_enemy);
        btn_graveyard_enemy = findViewById(R.id.btn_graveyard_enemy);
        btn_card_player = findViewById(R.id.btn_card_player);
        btn_graveyard_player = findViewById(R.id.btn_graveyard_player);
        btn_skill = findViewById(R.id.btn_skill);
        btn_end_turn = findViewById(R.id.btn_end_turn);
        imbtn_item = findViewById(R.id.imbtn_item);
        im_enemy = findViewById(R.id.im_enemy);
        card_battlefield = findViewById(R.id.card_battlefield);
        card_player = findViewById(R.id.card_player);


    }
}