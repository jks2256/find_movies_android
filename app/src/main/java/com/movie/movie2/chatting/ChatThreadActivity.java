package com.movie.movie2.chatting;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.movie.movie2.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.PrintWriter;
import java.net.Socket;


public class ChatThreadActivity extends AppCompatActivity {
    private Socket socket;

    BufferedReader socket_in;

    PrintWriter socket_out;

    Button btnSend;
    EditText etText;
    TextView my_recycler_view;

    String data;



    @Override

    public void onCreate(Bundle savedInstanceState) {

        // TODO Auto-generated method stub

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etText = (EditText) findViewById(R.id.etText);

        btnSend = (Button) findViewById(R.id.btnSend);

        my_recycler_view = (TextView) findViewById(R.id.my_recycler_view);

        btnSend.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Log.w("yj", "버튼눌림");

                String data = etText.getText().toString();

                Log.w("yj", " " + data);

                if(data != null) {

                    socket_out.println(data);


                }

            }

        });

        Thread worker = new Thread() {

            public void run() {

                try {

                    socket = new Socket("203.252.218.95", 6000);

                    socket_out = new PrintWriter(socket.getOutputStream(), true);

                    socket_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                } catch (IOException e) {

                    e.printStackTrace();


                }

                try {

                    while (true) {

                        data = socket_in.readLine();

                        my_recycler_view.post(new Runnable() {

                            public void run() {

                                my_recycler_view.setText(data);

                            }

                        });

                    }

                } catch (Exception e) {
                    Log.i("yj","오류");
                }

            }

        };

        worker.start();

    }



    @Override

    protected void onStop() {

        // TODO Auto-generated method stub

        super.onStop();

        try {

            socket.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
