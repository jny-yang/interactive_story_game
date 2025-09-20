package tw.edu.scu.avgexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.progressindicator.BaseProgressIndicator;

import java.util.ArrayList;

import tw.edu.scu.avgexample.framework.KWBaseSceneActivity;
import tw.edu.scu.avgexample.framework.model.KWCharacterModel;
import tw.edu.scu.avgexample.framework.model.KWEventModel;
import tw.edu.scu.avgexample.framework.model.KWFirstPersonEventModel;
import tw.edu.scu.avgexample.framework.model.KWFullScreenEventModel;
import tw.edu.scu.avgexample.framework.model.KWOptionEventModel;
import tw.edu.scu.avgexample.framework.model.KWThirdPersonEventModel;
import tw.edu.scu.avgexample.framework.utility.KWResourceUtils;
import tw.edu.scu.avgexample.sample.SampleMenuMainActivity;

public class MyScene1Activity extends KWBaseSceneActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_scene1);
    }

    @Override
    protected void initializeEvent () {
        super.initializeEvent();

        Drawable background0 = KWResourceUtils.getDrawableByResourceId(this, R.drawable.view_00);
        Drawable background1 = KWResourceUtils.getDrawableByResourceId(this, R.drawable.view_01);
        Drawable background2 = KWResourceUtils.getDrawableByResourceId(this, R.drawable.view_02);
        Drawable background3 = KWResourceUtils.getDrawableByResourceId(this, R.drawable.view_03);
        KWFirstPersonEventModel event0 = new KWFirstPersonEventModel("在車上度過漫長的時光").setBackgroundDrawable(background0);
        KWFirstPersonEventModel event1 = new KWFirstPersonEventModel("終於從米花車站下車");
        KWFirstPersonEventModel event2 = new KWFirstPersonEventModel("一個陽光燦爛的午後，忙碌之事似乎還未完待續...");
        KWFirstPersonEventModel event3 = new KWFirstPersonEventModel("柯南", "我叫江戶川柯南，原本是一個高中生偵探工藤新一").setBackgroundDrawable(background1);
        KWFirstPersonEventModel event4 = new KWFirstPersonEventModel("柯南", "卻在一次目睹黑色組織的交易後被迫灌下使身體變小的藥物");
        KWFirstPersonEventModel event5 = new KWFirstPersonEventModel("柯南", "為了不危及身旁人的安全，我偽裝成一名小學生，並寄宿於毛利偵探事務所，與叔叔毛利小五郎還有小蘭姐姐一起生活");
        KWFirstPersonEventModel event6 = new KWFirstPersonEventModel("柯南", "身體雖然變小，但頭腦還是一樣棒，現在的我依然是個偵探，默默幫助小五郎叔叔破案");
        KWFirstPersonEventModel event7 = new KWFirstPersonEventModel("柯南", "廢話不多說，我先上樓跟小五郎叔叔打聲招呼！");
        KWFirstPersonEventModel event8 = new KWFirstPersonEventModel("(上樓中...)").setBackgroundDrawable(background2);
        KWFirstPersonEventModel event9 = new KWFirstPersonEventModel("(推開門...)");
        KWFirstPersonEventModel event10 = new KWFirstPersonEventModel("柯南", "唉...叔叔怎麼又在喝阿...").setBackgroundDrawable(background3);
        eventManager.addEvent(event0);
        eventManager.addEvent(event1);
        eventManager.addEvent(event2);
        eventManager.addEvent(event3);
        eventManager.addEvent(event4);
        eventManager.addEvent(event5);
        eventManager.addEvent(event6);
        eventManager.addEvent(event7);
        eventManager.addEvent(event8);
        eventManager.addEvent(event9);
        eventManager.addEvent(event10);
        eventManager.play("我的第一個事件集合");

        ArrayList<String> optionArrayList = new ArrayList<>();
        optionArrayList.add("叫醒叔叔");
        optionArrayList.add("告訴小蘭姐姐");
        KWOptionEventModel event11 = new KWOptionEventModel("觸發1-2選項", "接下來我應該怎麼辦？", optionArrayList);
        eventManager.addEvent(event11);


    }

    @Override
    protected void onOptionSelected (String identifier, int index){
        super.onOptionSelected(identifier, index);
        if ("觸發1-2選項".equals(identifier)) {
            if (index == 0) {

                KWFirstPersonEventModel event1 = new KWFirstPersonEventModel("柯南","喂喂喂 叔叔叔叔，醒醒了別再睡了！");

                KWCharacterModel character01 = new KWCharacterModel(this,"char_02","毛利小五郎");
                KWCharacterModel character02 = new KWCharacterModel(this,"char_01","毛利小五郎");

                KWThirdPersonEventModel event2 = new KWThirdPersonEventModel(character01, "臭小子，怎麼吵醒我，打擾我在夢中跟沖野洋子的約會！");
                KWFirstPersonEventModel event3 = new KWFirstPersonEventModel("柯南","叔叔不好了，有新的案件！");
                KWThirdPersonEventModel event4 = new KWThirdPersonEventModel(character02, "什麼？你說有新的案件！");
                KWThirdPersonEventModel event5 = new KWThirdPersonEventModel(character02, "沒有我大名鼎鼎的名偵探毛利小五郎破不了的案子！");
                KWFirstPersonEventModel event6 = new KWFirstPersonEventModel("柯南","(喂喂喂...==)");
                KWThirdPersonEventModel event7 = new KWThirdPersonEventModel(character02, "不跟你廢話了，我要去跟目暮警官確認一下案件的始末");

                eventManager.addEvent(event1);
                eventManager.addEvent(event2);
                eventManager.addEvent(event3);
                eventManager.addEvent(event4);
                eventManager.addEvent(event5);
                eventManager.addEvent(event6);
                eventManager.addEvent(event7);

                eventManager.play("我的第二個事件集合");

                ArrayList<String> optionArrayList = new ArrayList<>();
                optionArrayList.add("跟叔叔一起去找目暮警官");
                optionArrayList.add("去阿笠博士家找少年偵探團");
                KWOptionEventModel event8 = new KWOptionEventModel("觸發3-4選項", "要不要跟過去呢？", optionArrayList);
                eventManager.addEvent(event8);

                //switchSceneActivity(MyScene2Activity.class);

            }
            else if (index == 1) {

                KWFirstPersonEventModel event1 = new KWFirstPersonEventModel("柯南","小蘭姐姐，叔叔又再喝了啦！喝的醉醺醺的");

                KWCharacterModel character01 = new KWCharacterModel(this,"char_02","毛利小五郎");
                KWCharacterModel character02 = new KWCharacterModel(this,"char_01","毛利小五郎");
                KWCharacterModel character03 = new KWCharacterModel(this,"char_03","毛利蘭");

                KWThirdPersonEventModel event2 = new KWThirdPersonEventModel(character03, "爸爸！怎麼整天辦案不辦案，成天只想喝酒賽馬還有跟沖野洋子約會！");
                KWThirdPersonEventModel event3 = new KWThirdPersonEventModel(character01, "咦咦咦...小...小蘭！");
                KWThirdPersonEventModel event4 = new KWThirdPersonEventModel(character01, "你怎麼知道我在夢中跟沖野洋子約會...");
                KWThirdPersonEventModel event13 = new KWThirdPersonEventModel(character01);
                KWThirdPersonEventModel event14 = new KWThirdPersonEventModel(character03);
                event13.setCharacterPosition(KWEventModel.KW_EVENT_CHARACTER_POSITION_LEFT);
                event14.setCharacterPosition(KWEventModel.KW_EVENT_CHARACTER_POSITION_RIGHT);
                KWFirstPersonEventModel event5 = new KWFirstPersonEventModel("柯南","叔叔、小蘭姐姐，你們別聊了！");
                KWFirstPersonEventModel event6 = new KWFirstPersonEventModel("柯南","大事不好了，有新的案件發生了！");
                KWThirdPersonEventModel event15 = new KWThirdPersonEventModel(character01).setCharacterImageVisibility(false);
                KWThirdPersonEventModel event7 = new KWThirdPersonEventModel(character03, "爸爸！柯南說有新的案件，該你上場了！");
                KWThirdPersonEventModel event16 = new KWThirdPersonEventModel(character03).setCharacterImageVisibility(false);
                KWThirdPersonEventModel event8 = new KWThirdPersonEventModel(character02, "什麼？你說有新的案件！");
                KWThirdPersonEventModel event9 = new KWThirdPersonEventModel(character02, "沒有我大名鼎鼎的名偵探毛利小五郎破不了的案子！");
                KWFirstPersonEventModel event10 = new KWFirstPersonEventModel("柯南","(喂喂喂...==)");
                KWThirdPersonEventModel event11 = new KWThirdPersonEventModel(character02, "不跟你廢話了，我要去跟暮目警官確認一下案件的始末");

                eventManager.addEvent(event1);
                eventManager.addEvent(event2);
                eventManager.addEvent(event3);
                eventManager.addEvent(event4);
                eventManager.addEvent(event13);
                eventManager.addEvent(event14);
                eventManager.addEvent(event5);
                eventManager.addEvent(event6);
                eventManager.addEvent(event15);
                eventManager.addEvent(event7);
                eventManager.addEvent(event16);
                eventManager.addEvent(event8);
                eventManager.addEvent(event9);
                eventManager.addEvent(event10);
                eventManager.addEvent(event11);

                eventManager.play("我的第三個事件集合");


                ArrayList<String> optionArrayList1 = new ArrayList<>();
                optionArrayList1.add("跟叔叔一起去找目暮警官");
                optionArrayList1.add("去阿笠博士家找少年偵探團");
                KWOptionEventModel event12 = new KWOptionEventModel("觸發3-4選項", "要不要跟過去呢？", optionArrayList1);
                eventManager.addEvent(event12);
            }
        }

        if ("觸發3-4選項".equals(identifier)) {
            if (index == 0) {

                Drawable background4 = KWResourceUtils.getDrawableByResourceId(this, R.drawable.view_04);

                KWCharacterModel character04 = new KWCharacterModel(this,"char_04","目暮警官");
                KWCharacterModel character02 = new KWCharacterModel(this,"char_01","毛利小五郎");
                KWCharacterModel character05 = new KWCharacterModel(this,"char_05","毛利小五郎");

                KWThirdPersonEventModel event = new KWThirdPersonEventModel(character02).setCharacterImageVisibility(false);
                KWFirstPersonEventModel event0 = new KWFirstPersonEventModel("接著，柯南就跟著毛利小五郎一起來到了警視廳").setBackgroundDrawable(background4);


                KWThirdPersonEventModel event1 = new KWThirdPersonEventModel(character04, "怎麼了毛利老弟，怎麼突然跑過來警視廳，是要來敘敘舊嗎？");
                KWThirdPersonEventModel event2 = new KWThirdPersonEventModel(character02, "開什麼玩笑呢，目暮警官，我是來打聽最新案件的");
                KWThirdPersonEventModel event3 = new KWThirdPersonEventModel(character02, "畢竟破不了的案子最終還是必須靠我沉睡的小五郎來讓案件水落石出！");
                KWThirdPersonEventModel event4 = new KWThirdPersonEventModel(character04, "有新案情的事怎麼這麼快就傳進你耳朵啦...");
                KWThirdPersonEventModel event5 = new KWThirdPersonEventModel(character04, "對了，柯南怎麼也跟過來啦");
                KWThirdPersonEventModel event21 = new KWThirdPersonEventModel(character04);
                KWThirdPersonEventModel event22 = new KWThirdPersonEventModel(character02);
                event21.setCharacterPosition(KWEventModel.KW_EVENT_CHARACTER_POSITION_LEFT);
                event22.setCharacterPosition(KWEventModel.KW_EVENT_CHARACTER_POSITION_RIGHT);
                KWFirstPersonEventModel event6 = new KWFirstPersonEventModel("柯南","你好，目暮警官！");
                KWFirstPersonEventModel event7 = new KWFirstPersonEventModel("柯南","我跟同學剛好在附近寫作業，就想說過來看看發生了什麼事~");
                KWThirdPersonEventModel event17 = new KWThirdPersonEventModel(character04).setCharacterImageVisibility(false);
                KWThirdPersonEventModel event23 = new KWThirdPersonEventModel(character02).setCharacterImageVisibility(false);
                KWThirdPersonEventModel event8 = new KWThirdPersonEventModel(character05, "臭小子，每次出現這種事情都有你來搗亂！");
                KWThirdPersonEventModel event24 = new KWThirdPersonEventModel(character05).setCharacterImageVisibility(false);
                KWThirdPersonEventModel event9 = new KWThirdPersonEventModel(character04, "沒關係啦毛利老弟，每次有柯南在的地方案件也都能迎刃而解，別太在意！");
                KWThirdPersonEventModel event18 = new KWThirdPersonEventModel(character04).setCharacterImageVisibility(false);
                KWFirstPersonEventModel event10 = new KWFirstPersonEventModel("柯南","(.........那是當然)");
                KWThirdPersonEventModel event11 = new KWThirdPersonEventModel(character05, "那你可別搗亂");
                KWThirdPersonEventModel event25 = new KWThirdPersonEventModel(character05).setCharacterImageVisibility(false);
                KWThirdPersonEventModel event12 = new KWThirdPersonEventModel(character04, "好啦別計較了，我們趕緊說正事，現在這個案件只剩最後一個關鍵");
                KWThirdPersonEventModel event26 = new KWThirdPersonEventModel(character04).setCharacterImageVisibility(false);
                KWThirdPersonEventModel event13 = new KWThirdPersonEventModel(character04, "這一群人聚會喝的都是同一間飲料店同一品項的冰飲，為什麼死的只有一個人？");
                KWThirdPersonEventModel event27 = new KWThirdPersonEventModel(character04).setCharacterImageVisibility(false);
                KWThirdPersonEventModel event14 = new KWThirdPersonEventModel(character05, "對阿，為甚麼呢？");
                KWThirdPersonEventModel event19 = new KWThirdPersonEventModel(character05).setCharacterImageVisibility(false);
                KWFirstPersonEventModel event15 = new KWFirstPersonEventModel("柯南","(剩下的冰飲飲料都喝完了，但...)");
                KWFirstPersonEventModel event16 = new KWFirstPersonEventModel("柯南","(阿！原來如此，我瞭解了！)");


                eventManager.addEvent(event);
                eventManager.addEvent(event0);
                eventManager.addEvent(event1);
                eventManager.addEvent(event2);
                eventManager.addEvent(event3);
                eventManager.addEvent(event4);
                eventManager.addEvent(event5);
                eventManager.addEvent(event21);
                eventManager.addEvent(event22);
                eventManager.addEvent(event6);
                eventManager.addEvent(event7);
                eventManager.addEvent(event17);
                eventManager.addEvent(event23);
                eventManager.addEvent(event8);
                eventManager.addEvent(event24);
                eventManager.addEvent(event9);
                eventManager.addEvent(event18);
                eventManager.addEvent(event10);
                eventManager.addEvent(event11);
                eventManager.addEvent(event25);
                eventManager.addEvent(event12);
                eventManager.addEvent(event26);
                eventManager.addEvent(event13);
                eventManager.addEvent(event27);
                eventManager.addEvent(event14);
                eventManager.addEvent(event19);
                eventManager.addEvent(event15);
                eventManager.addEvent(event16);

                eventManager.play("我的第四個事件集合");

                ArrayList<String> optionArrayList2 = new ArrayList<>();
                optionArrayList2.add("當然要幫叔叔阿");
                optionArrayList2.add("這次看叔叔出糗");
                KWOptionEventModel event20 = new KWOptionEventModel("觸發5-6選項", "是否要再次上演沉睡小五郎的戲碼？", optionArrayList2);
                eventManager.addEvent(event20);

            }
            else if (index == 1) {

                Drawable background5 = KWResourceUtils.getDrawableByResourceId(this, R.drawable.view_05);
                Drawable background6 = KWResourceUtils.getDrawableByResourceId(this, R.drawable.view_06);
                Drawable background4 = KWResourceUtils.getDrawableByResourceId(this, R.drawable.view_04);

                KWCharacterModel character07 = new KWCharacterModel(this,"char_07","阿笠博士");
                KWCharacterModel character08 = new KWCharacterModel(this,"char_08","灰原哀");
                KWCharacterModel character09 = new KWCharacterModel(this,"char_09","少年偵探團");
                KWCharacterModel character04 = new KWCharacterModel(this,"char_04","目暮警官");
                KWCharacterModel character02 = new KWCharacterModel(this,"char_01","毛利小五郎");
                KWCharacterModel character05 = new KWCharacterModel(this,"char_05","毛利小五郎");

                KWThirdPersonEventModel event = new KWThirdPersonEventModel(character02).setCharacterImageVisibility(false);
                KWFirstPersonEventModel event0 = new KWFirstPersonEventModel("接著，柯南來到了阿笠博士家").setBackgroundDrawable(background5);
                KWFirstPersonEventModel event1 = new KWFirstPersonEventModel("來看看博士在不在家~");
                KWFirstPersonEventModel event2 = new KWFirstPersonEventModel("柯南","博士、灰原，你們都在阿！").setBackgroundDrawable(background6);
                KWThirdPersonEventModel event3 = new KWThirdPersonEventModel(character07, "欸，新一，你怎麼來了？");
                KWThirdPersonEventModel event4 = new KWThirdPersonEventModel(character08, "工藤，又有什麼案件發生嗎？");
                KWThirdPersonEventModel event25 = new KWThirdPersonEventModel(character08).setCharacterImageVisibility(false);
                KWFirstPersonEventModel event5 = new KWFirstPersonEventModel("柯南","果然什麼事都瞞不住你們，毛利叔叔正要去找目暮警官");
                KWThirdPersonEventModel event6 = new KWThirdPersonEventModel(character07, "那你不一起過去嗎？");
                KWThirdPersonEventModel event7 = new KWThirdPersonEventModel(character08, "小孩子還在裡面玩耍呢，你要去可以先過去");
                KWThirdPersonEventModel event8 = new KWThirdPersonEventModel(character09, "嘿嘿嘿，什麼事都躲不過我們少年偵探團！少年偵探團出動！");
                KWThirdPersonEventModel event9 = new KWThirdPersonEventModel(character08, "真拿你們沒辦法...");
                KWThirdPersonEventModel event26 = new KWThirdPersonEventModel(character08).setCharacterImageVisibility(false);
                KWFirstPersonEventModel event10 = new KWFirstPersonEventModel("柯南","好吧好吧，既然你們都來了，一起過去吧...");
                KWThirdPersonEventModel event11 = new KWThirdPersonEventModel(character09, "好欸！！！");
                KWThirdPersonEventModel event27 = new KWThirdPersonEventModel(character09).setCharacterImageVisibility(false);
                KWFirstPersonEventModel event12 = new KWFirstPersonEventModel("柯南","你好，目暮警官！").setBackgroundDrawable(background4);
                KWFirstPersonEventModel event13 = new KWFirstPersonEventModel("柯南","我跟他們剛好在附近玩耍，就想說過來看看發生了什麼事~");
                KWThirdPersonEventModel event14 = new KWThirdPersonEventModel(character05, "臭小子，每次出現這種事情都有你來搗亂！");
                KWThirdPersonEventModel event15 = new KWThirdPersonEventModel(character04, "沒關係啦毛利老弟，每次有柯南在的地方案件也都能迎刃而解，別太在意！");
                KWThirdPersonEventModel event28 = new KWThirdPersonEventModel(character02).setCharacterImageVisibility(false);
                KWFirstPersonEventModel event16 = new KWFirstPersonEventModel("柯南","(.........那是當然)");
                KWThirdPersonEventModel event17 = new KWThirdPersonEventModel(character09, "柯南很厲害，但我們少年偵探團也一樣厲害！");
                KWThirdPersonEventModel event18 = new KWThirdPersonEventModel(character05, "你們這些小鬼可別搗亂！！！");
                KWThirdPersonEventModel event19 = new KWThirdPersonEventModel(character04, "好啦別計較了，我們趕緊說正事，現在這個案件只剩最後一個關鍵");
                KWThirdPersonEventModel event20 = new KWThirdPersonEventModel(character04, "這一群人聚會喝的都是同一間飲料店同一品項的冰飲，為什麼死的只有一個人？");
                KWThirdPersonEventModel event21 = new KWThirdPersonEventModel(character05, "對阿，為甚麼呢？");
                KWThirdPersonEventModel event22 = new KWThirdPersonEventModel(character09, "對阿，到底問題出在哪裡？");
                KWThirdPersonEventModel event29 = new KWThirdPersonEventModel(character02).setCharacterImageVisibility(false);
                KWFirstPersonEventModel event23 = new KWFirstPersonEventModel("柯南","(剩下的冰飲飲料都喝完了，但...)");
                KWFirstPersonEventModel event24 = new KWFirstPersonEventModel("柯南","(阿！原來如此，我瞭解了！)");

                eventManager.addEvent(event);
                eventManager.addEvent(event0);
                eventManager.addEvent(event1);
                eventManager.addEvent(event2);
                eventManager.addEvent(event3);
                eventManager.addEvent(event4);
                eventManager.addEvent(event25);
                eventManager.addEvent(event5);
                eventManager.addEvent(event6);
                eventManager.addEvent(event7);
                eventManager.addEvent(event8);
                eventManager.addEvent(event9);
                eventManager.addEvent(event26);
                eventManager.addEvent(event10);
                eventManager.addEvent(event11);
                eventManager.addEvent(event27);
                eventManager.addEvent(event12);
                eventManager.addEvent(event13);
                eventManager.addEvent(event14);
                eventManager.addEvent(event15);
                eventManager.addEvent(event28);
                eventManager.addEvent(event16);
                eventManager.addEvent(event17);
                eventManager.addEvent(event18);
                eventManager.addEvent(event19);
                eventManager.addEvent(event20);
                eventManager.addEvent(event21);
                eventManager.addEvent(event22);
                eventManager.addEvent(event29);
                eventManager.addEvent(event23);
                eventManager.addEvent(event24);

                eventManager.play("我的第七個事件集合");

                ArrayList<String> optionArrayList2 = new ArrayList<>();
                optionArrayList2.add("當然要幫叔叔阿");
                optionArrayList2.add("這次看叔叔出糗");
                KWOptionEventModel event30 = new KWOptionEventModel("觸發5-6選項", "是否要再次上演沉睡小五郎的戲碼？", optionArrayList2);
                eventManager.addEvent(event30);

            }
        }

        if ("觸發5-6選項".equals(identifier)) {
            if (index == 0) {

                Drawable background401 = KWResourceUtils.getDrawableByResourceId(this, R.drawable.view_0401);

                KWCharacterModel character01 = new KWCharacterModel(this,"char_02","毛利小五郎");
                KWCharacterModel character04 = new KWCharacterModel(this,"char_04","目暮警官");
                KWCharacterModel character06 = new KWCharacterModel(this,"char_06","目暮警官");

                KWFirstPersonEventModel event1 = new KWFirstPersonEventModel("柯南","目暮警官，你看那邊！");
                KWThirdPersonEventModel event2 = new KWThirdPersonEventModel(character06, "嗯？怎麼了嗎？");
                KWFirstPersonEventModel event3 = new KWFirstPersonEventModel("柯南","(趁機用麻醉針射向毛利小五郎))");
                KWThirdPersonEventModel event4 = new KWThirdPersonEventModel(character01, "呃呃呃...!@#$%^&*");
                KWThirdPersonEventModel event5 = new KWThirdPersonEventModel(character06, "這不就是，沉睡的小五郎！！！");
                KWThirdPersonEventModel event6 = new KWThirdPersonEventModel(character01, "接下來就由我來解開事件的真相！");
                KWThirdPersonEventModel event8 = new KWThirdPersonEventModel(character01).setCharacterImageVisibility(false);




                eventManager.addEvent(event1);
                eventManager.addEvent(event2);
                eventManager.addEvent(event3);
                eventManager.addEvent(event4);
                eventManager.addEvent(event5);
                eventManager.addEvent(event6);
                eventManager.addEvent(event8);


                eventManager.play("我的第五個事件集合");

                ArrayList<String> optionArrayList2 = new ArrayList<>();
                optionArrayList2.add("點擊查看!");
                KWOptionEventModel event40 = new KWOptionEventModel("觸發7-8選項", "真相只有一個!", optionArrayList2);
                eventManager.addEvent(event40);
            }
            else if (index == 1) {

                Drawable background401 = KWResourceUtils.getDrawableByResourceId(this, R.drawable.view_0401);

                KWCharacterModel character04 = new KWCharacterModel(this,"char_04","目暮警官");

                KWFirstPersonEventModel event1 = new KWFirstPersonEventModel("柯南","目暮警官，其餘的冰飲都喝完了欸");
                KWFirstPersonEventModel event2 = new KWFirstPersonEventModel("柯南","但是冰塊好像都還沒融化呢");
                KWThirdPersonEventModel event3 = new KWThirdPersonEventModel(character04, "哦~我瞭解了！");
                KWThirdPersonEventModel event4 = new KWThirdPersonEventModel(character04, "因為犯人把致命的藥劑存在冰塊裡，死者有咬冰塊的習慣，又因為其他人都在冰塊融化前就飲用完畢，所以這並非隨機殺人！");
                KWThirdPersonEventModel event5 = new KWThirdPersonEventModel(character04, "毛利老弟，這麼簡單都沒想到阿，看來你功力大不如前了！");
                KWThirdPersonEventModel event7 = new KWThirdPersonEventModel(character04).setCharacterImageVisibility(false);

                eventManager.addEvent(event1);
                eventManager.addEvent(event2);
                eventManager.addEvent(event3);
                eventManager.addEvent(event4);
                eventManager.addEvent(event5);
                eventManager.addEvent(event7);


                eventManager.play("我的第六個事件集合");

                ArrayList<String> optionArrayList2 = new ArrayList<>();
                optionArrayList2.add("後續!");
                KWOptionEventModel event40 = new KWOptionEventModel("觸發9-10選項", "被嘲笑了 哈哈哈哈~~~", optionArrayList2);
                eventManager.addEvent(event40);
            }
        }
        if ("觸發7-8選項".equals(identifier)) {
            if (index == 0) {
                Drawable background401 = KWResourceUtils.getDrawableByResourceId(this, R.drawable.view_0401);
                KWFullScreenEventModel event7 = new KWFullScreenEventModel("原來犯人把致命的藥劑存在冰塊裡，死者有咬冰塊的習慣，又因為其他人都在冰塊融化前就飲用完畢，所以這並非一起隨機殺人的案件\n\n這樁殺人案終於落幕，而柯南我又再次幫小五郎叔叔推理了一次，在大家心目中，小五郎叔叔依然是一位大家目光焦點的名偵探！\n\n[HAPPY ENDING]").setBackgroundDrawable(background401);
                eventManager.addEvent(event7);
               eventManager.play("我的第七個事件集合");
            }

            }
        if ("觸發9-10選項".equals(identifier)) {
            if (index == 0) {
                Drawable background401 = KWResourceUtils.getDrawableByResourceId(this, R.drawable.view_0401);
                KWFullScreenEventModel event11 = new KWFullScreenEventModel("後來小五郎叔叔無法接受自己沒有完整推理結果的事實(雖然每一次都是柯南我幫他的)，惱羞成怒，跑回毛利偵探事務所繼續喝酒，連續喝了一整個晚上，小蘭姐姐發現後又罵了叔叔一頓\n\n[BAD ENDING]").setBackgroundDrawable(background401);
                eventManager.addEvent(event11);
                eventManager.play("我的第八個事件集合");
            }
        }

    }


}