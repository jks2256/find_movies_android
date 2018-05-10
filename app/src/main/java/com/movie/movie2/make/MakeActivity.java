package com.movie.movie2.make;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.movie.movie2.R;

import java.util.ArrayList;

public class MakeActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<MakeDatas> makeDatas;
    MakeAdapter makeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make);

        listView = (ListView) findViewById(R.id.listView);
        makeDatas = new ArrayList<MakeDatas>();

        makeDatas.add(new MakeDatas(null,"title"));
        makeDatas.add(new MakeDatas(null,"title"));
        makeDatas.add(new MakeDatas(null,"title"));
        makeDatas.add(new MakeDatas(null,"title"));
        makeDatas.add(new MakeDatas(null,"title"));
        makeDatas.add(new MakeDatas(null,"title"));
        makeDatas.add(new MakeDatas(null,"title"));
        makeDatas.add(new MakeDatas(null,"title"));
        makeDatas.add(new MakeDatas(null,"title"));
        makeDatas.add(new MakeDatas(null,"title"));
        makeDatas.add(new MakeDatas(null,"title"));



        makeAdapter = new MakeAdapter(makeDatas, getApplicationContext());
        listView.setAdapter(makeAdapter);

    }
}
