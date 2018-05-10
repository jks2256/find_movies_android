package com.movie.movie2.like;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.movie.movie2.R;
import com.movie.movie2.chatting.ChattingActivity;
import com.movie.movie2.find.FindActivity;
import com.movie.movie2.friends.MainActivity;

import java.util.ArrayList;

public class LikeActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<LikeDatas> likeDatases;
    LikeAdapter likeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);

        ImageView go_friend = (ImageView)findViewById(R.id.go_friend);
        ImageView go_chat = (ImageView)findViewById(R.id.go_chat);
        ImageView go_like = (ImageView)findViewById(R.id.go_like);

        ImageView confirm = (ImageView)findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FindActivity.class));
            }
        });

        go_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        go_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ChattingActivity.class));
            }
        });
        go_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LikeActivity.class));
            }
        });

        listView = (ListView) findViewById(R.id.listView);
        likeDatases = new ArrayList<LikeDatas>();

        likeDatases.add(new LikeDatas("액션"));
        likeDatases.add(new LikeDatas("드라마"));
        likeDatases.add(new LikeDatas("SF(판타지아)"));
        likeDatases.add(new LikeDatas("로맨스"));
        likeDatases.add(new LikeDatas("공포"));
        likeDatases.add(new LikeDatas("범죄/스릴러"));
        likeDatases.add(new LikeDatas("코메디"));
        likeDatases.add(new LikeDatas("애니메이션"));



        likeAdapter = new LikeAdapter(likeDatases, getApplicationContext());
        listView.setAdapter(likeAdapter);
    }
}
