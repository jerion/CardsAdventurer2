package com.example.user.cardsadventurer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import card.Card;
import charactor.Charactor;

public class Main3Activity extends AppCompatActivity {

    TextView hp_enemy, mp_enemy, hp_player, mp_player;
    TextView level_enemy, level_player;
    TextView name_target, intro_target, card_enemy, card_num_in_hand;
    Button btn_card_player, btn_graveyard_player, btn_end_turn;
    ImageView im_enemy;
    ListView card_battlefield;
    GridView card_player, grida;

    Intent intent2 = new Intent(Main3Activity.this, Main2Activity.class);

    String enemy_name;
    int[] player_stats = new int[6];
    int[] monster_stats = new int[5];
    int[] monster_stats_max = new int[5];
    ArrayList<Integer> card_hand = new ArrayList<Integer>();
    ArrayList<Integer> card_now = new ArrayList<>();

    ArrayList<Integer> card_handd = new ArrayList<Integer>();

    ArrayList<Card> cardArrayList = new ArrayList<>();

    Card normal_atk[] = new Card[4];
    Card fire_ball[] = new Card[6];
    Card ice_ball[] = new Card[3];
    Card meditation[] = new Card[4];
    Card corpus[] = new Card[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        setCard();
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
        btn_card_player = findViewById(R.id.button2);
        btn_graveyard_player = findViewById(R.id.btn_graveyard_player);
        btn_end_turn = findViewById(R.id.btn_end_turn);
        im_enemy = findViewById(R.id.im_enemy);
        card_battlefield = findViewById(R.id.card_battlefield);
        card_player = findViewById(R.id.card_player);
        grida = findViewById(R.id.grida);

        player_stats[0] = bundle.getInt("lv");
        player_stats[1] = bundle.getInt("hp");
        player_stats[2] = bundle.getInt("mp");
        player_stats[3] = bundle.getInt("exp");
        player_stats[4] = bundle.getInt("money");
        player_stats[5] = bundle.getInt("stage");
        card_hand = bundle.getIntegerArrayList("card");
        card_handd = bundle.getIntegerArrayList("card");

        enemy_name = bundle1.getString("name");
        monster_stats[0] = bundle1.getInt("lv");
        monster_stats[1] = bundle1.getInt("hp");
        monster_stats[2] = bundle1.getInt("mp");
        monster_stats[3] = bundle1.getInt("exp");
        monster_stats[4] = bundle1.getInt("money");
        monster_stats_max = monster_stats;

        String[] events = {
                "enemy1", "enemy2", "enemy4", "enemy3"
        };
        String uri = "@drawable/" + events[player_stats[5]].toString();
        int imgRes = getResources().getIdentifier(uri, null, getPackageName());
        im_enemy.setImageResource(imgRes);

        level_player.setText("" + player_stats[0]);
        hp_player.setText("" + player_stats[1] + "/" + player[player_stats[0] - 1].health);
        mp_player.setText("" + player_stats[2] + "/" + player[player_stats[0] - 1].mana);

        level_enemy.setText("" + monster_stats[0]);
        hp_enemy.setText("" + monster_stats[1] + "/" + monster_stats_max[1]);
        mp_enemy.setText("" + monster_stats[2] + "/" + monster_stats_max[2]);

        btn_card_player.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Data[] carddata = new Data[card_hand.size()];
                    for (int i = 0; i<card_hand.size(); i++)
                    {
                        carddata[i] = new Data();
                        carddata[i].name = String.valueOf(
                                cardArrayList.get(card_hand.get(i).intValue()).level);

                        switch (cardArrayList.get(card_hand.get(i)).name)
                        {
                            case "攻擊":
                                carddata[i].photo = R.drawable.attack1;
                                break;
                            case "火球":
                                carddata[i].photo = R.drawable.attack2;
                                break;
                            case "冰彈":
                                carddata[i].photo = R.drawable.attack3;
                                break;
                            case "冥想":
                                carddata[i].photo = R.drawable.effect2;
                                break;
                            case "法典":
                                carddata[i].photo = R.drawable.effect1;
                                break;

                            default:
                                break;
                        }
                    }
                    myAdapter CardAdapter = new myAdapter(carddata, R.layout.card);
                    GridView gridView = findViewById(R.id.grida);
                    gridView.setAdapter(CardAdapter);
                }
        });

        btn_end_turn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    intent2.setClass(Main3Activity.this, Main2Activity.class);
                    bundle.putInt("lv", player_stats[0]);
                    bundle.putInt("hp", player_stats[1]);
                    bundle.putInt("mp", player_stats[2]);
                    bundle.putInt("exp", player_stats[3] + monster_stats[3]);
                    bundle.putInt("money", player_stats[4] + monster_stats[4]);
                    bundle.putInt("stage", player_stats[5] + 1);
                    bundle.putIntegerArrayList("card", card_handd);
                    intent2.putExtra("new", bundle);
                    startActivity(intent2);
                    finish();
                }
        });
    }

    Charactor player[] = {
            new Charactor("", 1, 20, 1, 2, 0),
            new Charactor("", 2, 25, 2, 5, 0),
            new Charactor("", 3, 30, 3, 3, 0),
            new Charactor("", 4, 35, 4, 0, 0)
    };

    void setCard(){
        for (int i = 0; i<normal_atk.length; i++)
            normal_atk[i] = new Card();

        for (int i = 0; i<fire_ball.length; i++)
            fire_ball[i] = new Card();

        for (int i = 0; i<ice_ball.length; i++)
            ice_ball[i] = new Card();

        for (int i = 0; i<meditation.length; i++)
            meditation[i] = new Card();

        for (int i = 0; i<corpus.length; i++)
            corpus[i] = new Card();

        normal_atk[0].set_AttackCard("攻擊", "無", 1, 0, 2);//0
        normal_atk[1].set_AttackCard("攻擊", "無", 2, 0, 4);
        normal_atk[2].set_AttackCard("攻擊", "無", 3, 0, 6);
        normal_atk[3].set_AttackCard("攻擊", "無", 4, 0, 8);

        fire_ball[0].set_AttackCard("火球", "火", 1, 1, 3);//4
        fire_ball[1].set_AttackCard("火球", "火", 2, 2, 6);
        fire_ball[2].set_AttackCard("火球", "火", 3, 3, 10);
        fire_ball[3].set_AttackCard("火球", "火", 4, 4, 15);
        fire_ball[4].set_AttackCard("火球", "火", 5, 5, 21);
        fire_ball[5].set_AttackCard("火球", "火", 6, 6, 30);

        ice_ball[0].set_AttackCard("冰彈", "水", 1, 1, 4);//10
        ice_ball[1].set_AttackCard("冰彈", "水", 2, 2, 7);
        ice_ball[2].set_AttackCard("冰彈", "水", 3, 4, 14);

        meditation[0].set_EffectCard("冥想", "無", 1, 1, 2, 0);//13
        meditation[1].set_EffectCard("冥想", "無", 2, 2, 5, 0);
        meditation[2].set_EffectCard("冥想", "無", 3, 3, 8, 0);
        meditation[3].set_EffectCard("冥想", "無", 4, 4, 11, 0);

        corpus[0].set_EffectCard("法典", "無", 1, 1,0, 1);//17
        corpus[1].set_EffectCard("法典", "無", 2, 3,0, 2);
        corpus[2].set_EffectCard("法典", "無", 3, 5,0, 3);


        for (int i = 0; i<normal_atk.length; i++)
            cardArrayList.add(normal_atk[i]);

        for (int i = 0; i<fire_ball.length; i++)
            cardArrayList.add(fire_ball[i]);

        for (int i = 0; i<ice_ball.length; i++)
            cardArrayList.add(ice_ball[i]);

        for (int i = 0; i<meditation.length; i++)
            cardArrayList.add(meditation[i]);

        for (int i = 0; i<corpus.length; i++)
            cardArrayList.add(corpus[i]);
    }

    class Data {
        int photo;
        String name;
    }

    public class myAdapter extends BaseAdapter {
        private Data[] data;
        private int view;

        public myAdapter(Data[] data, int view) {
            this.data = data;
            this.view = view;
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(view, parent, false);
            TextView name = convertView.findViewById(R.id.textView2);
            ImageView fig = convertView.findViewById(R.id.imageView6);
            name.setText(data[position].name);
            fig.setImageResource(data[position].photo);
            return convertView;
        }
    }
}