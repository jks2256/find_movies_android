package com.movie.movie2.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.movie.movie2.R;
import com.movie.movie2.friends.MainActivity;
import com.movie.movie2.like.LikeActivity;

import java.util.ArrayList;

public class ChattingActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ChattingDatas> chattingDatas;
    ChattingAdapter chattingAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        ImageView go_friend = (ImageView)findViewById(R.id.go_friend);
        ImageView go_chat = (ImageView)findViewById(R.id.go_chat);
        ImageView go_like = (ImageView)findViewById(R.id.go_like);


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
        chattingDatas = new ArrayList<ChattingDatas>();
        chattingDatas.add(new ChattingDatas(null,"title","content","1번째"));
        chattingDatas.add(new ChattingDatas(null,"title","content","2번째"));
        chattingDatas.add(new ChattingDatas(null,"title","content","3번째"));
        chattingDatas.add(new ChattingDatas(null,"title","content","4번째"));
//        chattingDatas.add(new ChattingDatas(null,"title","content","4번째"));
//        chattingDatas.add(new ChattingDatas(null,"title","content","4번째"));
//        chattingDatas.add(new ChattingDatas(null,"title","content","4번째"));
//        chattingDatas.add(new ChattingDatas(null,"title","content","4번째"));
//        chattingDatas.add(new ChattingDatas(null,"title","content","4번째"));
//        chattingDatas.add(new ChattingDatas(null,"title","content","4번째"));
//        chattingDatas.add(new ChattingDatas(null,"title","content","4번째"));
//        chattingDatas.add(new ChattingDatas(null,"title","content","4번째"));
//        chattingDatas.add(new ChattingDatas(null,"title","content","4번째"));
//        chattingDatas.add(new ChattingDatas(null,"title","content","4번째"));
//        chattingDatas.add(new ChattingDatas(null,"title","content","4번째"));


        chattingAdapter = new ChattingAdapter(chattingDatas, getApplicationContext());
        listView.setAdapter(chattingAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),Chat.class));
            }
        });

    }
    /*
    public void sendMessage(View view){
    Intent intent = new Intent(this,DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        Intent.putExtra(EXTRA_MESSAGE,message);
    }*/
}
