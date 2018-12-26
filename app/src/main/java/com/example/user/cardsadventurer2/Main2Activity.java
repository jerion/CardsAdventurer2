package com.example.user.cardsadventurer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import card.Atk_Card;
import card.Card;
import card.Effect_Card;
import charactor.Charactor;
import stage.Stage;

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
    int test;
    int[][] monster_stats;

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

        level = findViewById(R.id.level_player);
        hpn = findViewById(R.id.hp_player);

        bundle3.putIntArray("monster", monster_stats[0]);

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
    Charactor monster[] = {
            new Charactor("蝙蝠", 1, 3,1,1,3),
            new Charactor("樹精", 2, 12, 3, 3, 7),
            new Charactor("梅杜莎", 3, 15, 4, 6, 20)};

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
            new Atk_Card("冰彈", "冰", 1, 1, 3),
            new Atk_Card("冰彈", "冰", 2, 2, 6),
            new Atk_Card("冰彈", "冰", 3, 3, 9),
            new Atk_Card("冰彈", "冰", 4, 4, 12),
    };

    Effect_Card meditation[] = {
            new Effect_Card("冥想", "無", 1, 1, 3, 0),
            new Effect_Card("冥想", "無", 2, 2, 6, 0),
    };

    Effect_Card corpus[] = {
            new Effect_Card("法典", "無", 1, 1,3, 0),
            new Effect_Card("法典", "無", 2, 2,6, 0),
    };

    Stage stage[] = {
            new Stage("蝙蝠","蝙蝠又名蟙䘃，是對翼手目動物的通稱，翼手目是哺乳動物中僅次於齧齒目動物的第二大類群，現生種共有19科185屬962種，除極地和大洋中的一些島嶼外，分布遍於全世界。"),
            new Stage("樹精","樹精是一種神話裡面描述存在的生物。在中國神話中，樹木也由於生存時間很長，所以得以采天地靈氣，受日月之精華，從而變化成妖。"),
            new Stage("梅杜莎","美杜莎是戈耳貢女妖之一，外觀描述是纏著龍鱗的頭，像野豬一般的獠牙，青銅的手爪，金色的翅膀。任何直望美杜莎雙眼的人都會變成石像。"),
            new Stage("劍客","劍客為行俠仗義的人。"),
    };
}
