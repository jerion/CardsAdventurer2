package com.example.user.cardsadventurer2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView level_enemy, hp_enemy, sp_enemy, gear_enemy, status_enemy, name_target, intro_target, level_player, hp_player, sp_player, gear_player, status_player, card_enemy, card_num_in_hand;
    Button btn_card_enemy, btn_graveyard_enemy, btn_card_player, btn_graveyard_player, btn_skill, btn_end_turn;
    ImageButton imbtn_item;
    ImageView im_enemy;
    ListView card_battlefield, card_player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
}
