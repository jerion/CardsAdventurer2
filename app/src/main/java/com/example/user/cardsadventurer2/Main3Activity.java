package com.example.user.cardsadventurer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import charactor.Charactor;

public class Main3Activity extends AppCompatActivity {

    TextView hp_enemy, mp_enemy, hp_player, mp_player;
    TextView level_enemy, level_player;
    TextView name_target, intro_target, card_enemy, card_num_in_hand;
    Button btn_card_enemy, btn_graveyard_enemy, btn_card_player, btn_graveyard_player, btn_end_turn;
    ImageButton imbtn_item;
    ImageView im_enemy;
    ListView card_battlefield, card_player;

    Intent intent2 = new Intent(Main3Activity.this, Main2Activity.class);

    String enemy_name;
    int[] player_stats = new int[6];
    int[] monster_stats = new int[5];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle bundle = getIntent().getExtras().getBundle("new");
        Bundle bundle1 = getIntent().getExtras().getBundle("monster");

        level_enemy = findViewById(R.id.level_enemy);
        hp_enemy = findViewById(R.id.hp_enemy);
        mp_enemy = findViewById(R.id.sp_enemy);
        name_target = findViewById(R.id.name_target);
        intro_target = findViewById(R.id.intro_target);
        level_player = findViewById(R.id.level_player);
        hp_player = findViewById(R.id.hp_player);
        mp_player = findViewById(R.id.sp_player);
        card_enemy = findViewById(R.id.card_enemy);
        card_num_in_hand = findViewById(R.id.card_num_in_hand);
        btn_card_enemy = findViewById(R.id.btn_card_enemy);
        btn_graveyard_enemy = findViewById(R.id.btn_graveyard_enemy);
        btn_card_player = findViewById(R.id.btn_card_player);
        btn_graveyard_player = findViewById(R.id.btn_graveyard_player);
        btn_end_turn = findViewById(R.id.btn_end_turn);
        imbtn_item = findViewById(R.id.imbtn_item);
        im_enemy = findViewById(R.id.im_enemy);
        card_battlefield = findViewById(R.id.card_battlefield);
        card_player = findViewById(R.id.card_player);

        player_stats[0] = bundle.getInt("lv");
        player_stats[1] = bundle.getInt("hp");
        player_stats[2] = bundle.getInt("mp");
        player_stats[3] = bundle.getInt("exp");
        player_stats[4] = bundle.getInt("money");
        player_stats[5] = bundle.getInt("stage");

        enemy_name = bundle1.getString("name");
        monster_stats[0] = bundle1.getInt("lv");
        monster_stats[1] = bundle1.getInt("hp");
        monster_stats[2] = bundle1.getInt("mp");
        monster_stats[3] = bundle1.getInt("exp");
        monster_stats[4] = bundle1.getInt("money");

        String[] events = {
                "enemy1", "enemy2", "enemy4", "enemy3", "target5"
        };
        String uri = "@drawable/" + events[player_stats[5]].toString();
        int imgRes = getResources().getIdentifier(uri, null, getPackageName());
        im_enemy.setImageResource(imgRes);

        level_player.setText(""+player_stats[0]);
        hp_player.setText(""+player_stats[1]+"/"+player_stats[1]);
        mp_player.setText(""+player_stats[2]+"/"+player_stats[2]);

        level_enemy.setText(""+monster_stats[0]);
        hp_enemy.setText(""+monster_stats[1]+"/"+monster_stats[1]);
        mp_enemy.setText(""+monster_stats[2]+"/"+monster_stats[2]);

        btn_card_enemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                intent2.setClass(Main3Activity.this, Main2Activity.class);
                bundle.putInt("lv", player_stats[0]);
                bundle.putInt("hp", player_stats[1]);
                bundle.putInt("mp", player_stats[2]);
                bundle.putInt("exp", player_stats[3]+monster_stats[3]);
                bundle.putInt("money", player_stats[4]+monster_stats[4]);
                bundle.putInt("stage", player_stats[5]+1);
                intent2.putExtra("new", bundle);
                startActivity(intent2);
                finish();
            }
        });
    }

    Charactor player[] = {
            new Charactor("",1,20,1,2,0),
            new Charactor("",2,25,2,5,0),
            new Charactor("",3,30,3,3,0),
            new Charactor("",4,35,4,0,0)
    };
}