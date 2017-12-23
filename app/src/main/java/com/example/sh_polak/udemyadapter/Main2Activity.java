package com.example.sh_polak.udemyadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {
    ListView list2;
    String []scores={"gamestop:7","ign:9","angryJoe:8","lazyReviews:9"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        list2=(ListView)findViewById(R.id.listview);
        list2.setAdapter(new GameAdapter(scores,this));
    }
}
