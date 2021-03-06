package com.example.user.cardsadventurer2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import card.Card;
import charactor.Charactor;
import stage.Stage;

public class Main2Activity extends AppCompatActivity {

    TextView target, conversation, level, hp, mp, exp, money, card_left;
    Button card;
    ImageButton event1;

    int[] player_stats = new int[6];
    String monster_name = new String();
    int[] monster_stats = new int[5];
    ArrayList<Integer> card_hand = new ArrayList<Integer>();

    ArrayList<Card> cardArrayList = new ArrayList<>();

    Card normal_atk[] = new Card[4];
    Card fire_ball[] = new Card[6];
    Card ice_ball[] = new Card[3];
    Card meditation[] = new Card[4];
    Card corpus[] = new Card[3];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setCard();

        final Bundle bundle = getIntent().getExtras().getBundle("new");

        player_stats[0] = bundle.getInt("lv");
        player_stats[1] = bundle.getInt("hp");
        player_stats[2] = bundle.getInt("mp");
        player_stats[3] = bundle.getInt("exp");
        player_stats[4] = bundle.getInt("money");
        player_stats[5] = bundle.getInt("stage");
        card_hand = bundle.getIntegerArrayList("card");

        while (player_stats[3]>=player[player_stats[0]-1].experience)
        {
            player_stats[1] = player[player_stats[0]].health;
            player_stats[2] = player[player_stats[0]].mana;
            player_stats[3] = player_stats[3] - player[player_stats[0]-1].experience;
            player_stats[0] = player[player_stats[0]].Level;
        }

        target = findViewById(R.id.name_target);
        conversation = findViewById(R.id.conversation);
        level = findViewById(R.id.level_player);
        hp = findViewById(R.id.hp_player);
        mp = findViewById(R.id.sp_player);
        exp = findViewById(R.id.exp_player);
        money = findViewById(R.id.gold);
        card = findViewById(R.id.btn_card_player);
        card_left = findViewById(R.id.card_left);
        event1 = findViewById(R.id.imbtn_event1);

        level.setText(""+player_stats[0]);
        hp.setText(""+player_stats[1]+"/"+player_stats[1]);
        mp.setText(""+player_stats[2]+"/"+player_stats[2]);
        exp.setText(""+player_stats[3]+"/"+player[player_stats[0]-1].experience);
        money.setText(""+player_stats[4]);

        target.setText(stage[player_stats[5]].Name);
        conversation.setText(stage[player_stats[5]].Description);

        card_left.setText(""+(4-player_stats[5]));

        String[] events = {
                "enemy1", "enemy2", "enemy4", "enemy3", "target5"
        };
        String uri = "@drawable/" + events[player_stats[5]].toString();
        int imgRes = getResources().getIdentifier(uri, null, getPackageName());
        event1.setImageResource(imgRes);

        event1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if ((4-player_stats[5])>0) {
                switch (player_stats[5]) {
                    case 0:
                    case 1:
                    case 2:
                        monster_stats[0] = monster[player_stats[5]].Level;
                        monster_stats[1] = monster[player_stats[5]].health;
                        monster_stats[2] = monster[player_stats[5]].mana;
                        monster_stats[3] = monster[player_stats[5]].experience;
                        monster_stats[4] = monster[player_stats[5]].Money;
                        monster_name = monster[player_stats[5]].Name;
                        break;
                    case 3:
                        monster_stats[0] = boss[0].Level;
                        monster_stats[1] = boss[0].health;
                        monster_stats[2] = boss[0].mana;
                        monster_stats[3] = boss[0].experience;
                        monster_stats[4] = boss[0].Money;
                        monster_name = boss[0].Name;
                        break;
                    default:
                        break;
                }

                Intent intent3 = new Intent(Main2Activity.this, Main3Activity.class);
                Bundle bundle3 = new Bundle();
                Bundle bundle3_1 = new Bundle();

                bundle3.putInt("lv", player_stats[0]);
                bundle3.putInt("hp", player_stats[1]);
                bundle3.putInt("mp", player_stats[2]);
                bundle3.putInt("exp", player_stats[3]);
                bundle3.putInt("money", player_stats[4]);
                bundle3.putInt("stage", player_stats[5]);
                bundle3.putIntegerArrayList("card", card_hand);

                bundle3_1.putInt("lv", monster_stats[0]);
                bundle3_1.putInt("hp", monster_stats[1]);
                bundle3_1.putInt("mp", monster_stats[2]);
                bundle3_1.putInt("exp", monster_stats[3]);
                bundle3_1.putInt("money", monster_stats[4]);
                bundle3_1.putString("name", monster_name);

                intent3.putExtra("new", bundle3);
                intent3.putExtra("monster", bundle3_1);
                startActivity(intent3);
                finish();
            }

            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                builder.setTitle("遊戲結束");
                builder.setMessage("");
                builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent1 = new Intent(Main2Activity.this, MainActivity.class);
                        startActivity(intent1);
                        finish();
                    }
                });
                builder.show();
            }
            }
        });

        card.setOnClickListener(new View.OnClickListener() {
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
                GridView gridView = findViewById(R.id.grid2);
                gridView.setAdapter(CardAdapter);
            }
        });
    }

    Charactor player[] = {
            new Charactor("",1,20,1,1,0),
            new Charactor("",2,25,2,3,0),
            new Charactor("",3,30,3,6,0),
            new Charactor("",4,35,4,20,0)
    };

    Charactor monster[] = {
            new Charactor("蝙蝠", 1, 3,1,1,3),
            new Charactor("樹精", 2, 12, 3, 3, 7),
            new Charactor("梅杜莎", 3, 15, 4, 6, 20)
    };

    Charactor boss[] = {new Charactor("劍客", 4, 48, 4, 0, 0)};

    Stage stage[] = {
            new Stage("蝙蝠","蝙蝠又名蟙䘃，是對翼手目動物的通稱，翼手目是哺乳動物中僅次於齧齒目動物的第二大類群，現生種共有19科185屬962種，除極地和大洋中的一些島嶼外，分布遍於全世界。"),
            new Stage("樹精","樹精是一種神話裡面描述存在的生物。在中國神話中，樹木也由於生存時間很長，所以得以采天地靈氣，受日月之精華，從而變化成妖。"),
            new Stage("梅杜莎","美杜莎是戈耳貢女妖之一，外觀描述是纏著龍鱗的頭，像野豬一般的獠牙，青銅的手爪，金色的翅膀。任何直望美杜莎雙眼的人都會變成石像。"),
            new Stage("劍客","劍客為行俠仗義的人。"),
            new Stage("洞穴","結束"),
            new Stage("工匠","專注於某一領域、針對這一領域的產品研發或加工過程全身心投入，精益求精、一絲不苟的完成整個工序的每一個環節，可稱其為工匠。"),
            new Stage("分岔路", "就像是Y。V的部分是分叉的路。一個向左一個向右。"),
            new Stage("水井","水井，主要用於開採地下水的工程構築物。它可以是豎向的﹑斜向的和不同方向組合的﹐但一般以豎向為主﹐可用於生活取水﹑灌溉﹐也可用於躲避隱藏或貯存一些東西等。"),
            new Stage("巫師","指替人祈禱的裝神弄鬼的人。"),
            new Stage("酒吧","是指提供啤酒、葡萄酒、洋酒、雞尾酒等酒精類飲料的消費場所。"),
            new Stage("商人","商人，以別人產生的商品或服務進行貿易，從而賺取利潤的人。")
    };

    void setCard(){
        for (int i = 0; i<normal_atk.length; i++)
        {
            normal_atk[i] = new Card();
        }

        for (int i = 0; i<fire_ball.length; i++)
        {
            fire_ball[i] = new Card();
        }

        for (int i = 0; i<ice_ball.length; i++)
        {
            ice_ball[i] = new Card();
        }

        for (int i = 0; i<meditation.length; i++)
        {
            meditation[i] = new Card();
        }

        for (int i = 0; i<corpus.length; i++)
        {
            corpus[i] = new Card();
        }

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


        for (int i = 0; i<normal_atk.length; i++){
            cardArrayList.add(normal_atk[i]);}

        for (int i = 0; i<fire_ball.length; i++){
            cardArrayList.add(fire_ball[i]);}

        for (int i = 0; i<ice_ball.length; i++){
            cardArrayList.add(ice_ball[i]);}

        for (int i = 0; i<meditation.length; i++){
            cardArrayList.add(meditation[i]);}

        for (int i = 0; i<corpus.length; i++){
            cardArrayList.add(corpus[i]);}
    }

    class Data
    {
        int photo; String name;
    }

    public class myAdapter extends BaseAdapter
    {
        private  Data[] data;
        private int view;

        public myAdapter(Data[] data, int view)
        {
            this.data = data; this.view = view;
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
