package com.example.user.cardsadventurer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import card.Atk_Card;
import card.Card;
import card.Effect_Card;
import charactor.Charactor;
import stage.Stage;

public class Main2Activity extends AppCompatActivity {

    TextView target, conversation, level, hp, mp, exp, money, card_left;
    Button card, skill;
    ImageButton event1;

    int[] player_stats = new int[6];
    String monster_name = new String();
    int[] monster_stats = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Bundle bundle = getIntent().getExtras().getBundle("new");

        player_stats[0] = bundle.getInt("lv");
        player_stats[1] = bundle.getInt("hp");
        player_stats[2] = bundle.getInt("mp");
        player_stats[3] = bundle.getInt("exp");
        player_stats[4] = bundle.getInt("money");
        player_stats[5] = bundle.getInt("stage");


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
        skill = findViewById(R.id.btn_skill);
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
            if (player_stats[5]>0) {
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

            }
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

    Atk_Card normal_atk[] = {
            new Atk_Card("攻擊", "無", 1, 0, 2),
            new Atk_Card("攻擊", "無", 2, 0, 4),
            new Atk_Card("攻擊", "無", 3, 0, 6),
            new Atk_Card("攻擊", "無", 4, 0, 8),
    };

    Atk_Card fire_ball[] = {
            new Atk_Card("火球", "火", 1, 1, 3),
            new Atk_Card("火球", "火", 2, 2, 6),
            new Atk_Card("火球", "火", 3, 3, 9),
            new Atk_Card("火球", "火", 4, 4, 12),
    };

    Atk_Card ice_ball[] = {
            new Atk_Card("冰彈", "冰", 1, 1, 4),
            new Atk_Card("冰彈", "冰", 2, 2, 6),
            new Atk_Card("冰彈", "冰", 3, 4, 14)
    };

    Effect_Card meditation[] = {
            new Effect_Card("冥想", "無", 1, 1, 3, 0),
            new Effect_Card("冥想", "無", 2, 2, 6, 0)
    };

    Effect_Card corpus[] = {
            new Effect_Card("法典", "無", 1, 1,0, 1),
            new Effect_Card("法典", "無", 2, 3,0, 2)
    };

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
}
