package com.example.sh_polak.udemyadapter;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Games game;
    public static final int WELCOME=0;
    Games[]colection=new Games[]{
        new Games("Alien Isolation",10001,"alien","Horror game","https://www.youtube.com/watch?v=kc1MwlTwv3E"),
        new Games("BattleField one",10002,"bttlefield","Horror game","https://www.youtube.com/watch?v=EuTjdP7Pm7M"),
        new Games("Call Of Duty(On development)",10003,"cod","Shooter","https://www.youtube.com/watch?v=D4Q_XYVescc"),
        new Games("Dark soul 3",10004,"darksoul","Horror game","https://www.youtube.com/watch?v=b6MXWZ4mheo"),
        new Games("Dota2",10005,"dota","Moba","https://www.youtube.com/watch?v=-HoNSAmxpFc"),
        new Games("Euro truck 2",10006,"euro","simulation","https://www.youtube.com/watch?v=OBPGaLpUSfQ"),
        new Games("Fifa 17",10007,"fifa","simulation","https://www.youtube.com/watch?v=J0QuTkUBfRk"),
        new Games("For Honor",10008,"forhonor","Fightin game","https://www.youtube.com/watch?v=XRNE2qtG2Zw"),
        new Games("Goat simulator",10009,"goat","simulation","https://www.youtube.com/watch?v=--LBSm-BL6Y"),
        new Games("HeartStone",10010,"heartstone","Card game","https://www.youtube.com/watch?v=HaZH57Q9B18"),
        new Games("League Of Legends",10011,"lol","Moba","https://www.youtube.com/watch?v=t2fWYyI1xeE"),
        new Games("mount And blade",10012,"mab","Rpg game","https://www.youtube.com/watch?v=WGimKmmt0Ak"),
        new Games("Resident Evil",10013,"reo","Horror game","https://www.youtube.com/watch?v=4BpR4Vrcxho"),
        new Games("Shadow of mordor",10014,"shadow","Rpg","https://www.youtube.com/watch?v=-OOd1SrDDH0"),
        new Games("Sims",10015,"sims","simulation","https://www.youtube.com/watch?v=SrxVF9NPPoA"),
        new Games("TeamFortress2",10016,"tf2","Shotter hame","https://www.youtube.com/watch?v=5r3txqe1-h4"),
            new Games("Skyrim",10017,"skyrim","Rpg","https://www.youtube.com/watch?v=bH1GUi8rNQk"),
            new Games("Surgeaon simulator",100018,"surgeon","simulation","https://www.youtube.com/watch?v=edtP4zCdV2g"),
            new Games("Yakuza 0",10019,"yakuza","crime","https://www.youtube.com/watch?v=yYpN2LjkUmk")
    };
    private ListView mlistView;
    private PlaceAdapter mPlaceAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlistView=(ListView)findViewById(R.id.list);
        mPlaceAdapter=new PlaceAdapter(this,R.layout.row,colection);
        if(mlistView!=null){
            mlistView.setAdapter(mPlaceAdapter);
        }
      mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                try{
                   Intent b = new Intent(Intent.ACTION_VIEW,Uri.parse(colection[i].url.toString()));
                   // Intent b=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(b);
                }catch (Exception e) {
                    System.out.println("wrong url");
                }
                }
        });
    }

    public void logOut(View view) {
       WelcomeActivity.setEdit("","",false);
        startActivity(new Intent(this,WelcomeActivity.class));
    }
}
