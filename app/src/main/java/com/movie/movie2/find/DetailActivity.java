package com.movie.movie2.find;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.movie.movie2.R;
import com.movie.movie2.chatting.ChattingActivity;
import com.movie.movie2.friends.MainActivity;
import com.movie.movie2.like.LikeActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView go_friend = (ImageView)findViewById(R.id.gogo_friend);
        ImageView go_chat = (ImageView)findViewById(R.id.gogo_chat);
        ImageView go_like = (ImageView)findViewById(R.id.gogo_like);


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
    }
}
