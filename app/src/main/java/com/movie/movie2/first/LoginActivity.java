package com.movie.movie2.first;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.movie.movie2.ApplicationController;
import com.movie.movie2.NetworkService;
import com.movie.movie2.R;
import com.movie.movie2.friends.MainActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import static android.widget.Toast.makeText;

public class LoginActivity extends AppCompatActivity {

    private String TAG = LoginActivity.class.getSimpleName();

    EditText edt_id;
    EditText edt_pwd;
    ImageView btn_login;
    ImageView btn_signup;
    NetworkService service;

    public static String userId;
    public static String userPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate in LoginActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        edt_id = (EditText)findViewById(R.id.edt_id);
        edt_pwd = (EditText)findViewById(R.id.edt_pwd);
        btn_login = (ImageView)findViewById(R.id.btn_login);
        btn_signup = (ImageView)findViewById(R.id.btn_signup);

        service = ApplicationController.getInstance().getNetworkService();

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),SignupActivity.class));
            }
        });

        // 로그인버튼
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("yj","로그인버튼 눌림");
                //startActivity(new Intent(getApplicationContext(),MainActivity.class));


                //String name =edt_name.getText().toString();
                String id = edt_id.getText().toString();
                String pw = edt_pwd.getText().toString();
                //String email = edt_email.getText().toString();

                loginThread IDB = new loginThread();
                IDB.execute(id , pw);
                Log.i("yj","db연결2");

            }
        });

        /*
        // 로그인버튼_파머
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("butn","진입");
//                RequestBody id = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(edt_id.getText()));
//                RequestBody password = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(edt_pwd.getText()));

                loginData data = new loginData();
                data.id = String.valueOf(edt_id.getText());
                data.password = String.valueOf(edt_pwd.getText());

                Call<loginresult> GetLogin = service.getLogin(data);
                GetLogin.enqueue(new Callback<loginresult>(){

                    @Override
                    public void onResponse(Call<loginresult> call, Response<loginresult> response) {
                        if(response.isSuccessful()){
                            Log.i("hi","success");
                            if(response.body().message.equals("ok")){
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                intent.putExtra("name",response.body().name);
                                startActivity(intent);
                                finish();
                            }
                            else if(response.body().message.equals("fail")){
                                makeText(getApplicationContext(),"로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<loginresult> call, Throwable t) {
                        makeText(getApplicationContext(),"통신에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
*/

    }
    // 로그인버튼쓰레드
    class loginThread extends AsyncTask<String, Integer, String> {

        String sendMsg, receiveMsg;

        //메인쓰레드 -> 신규쓰레드 작업
        protected String doInBackground(String...params){

            // param 에 문자열 저장
            String param = "userId=" + edt_id.getText().toString() + "&userPw=" + edt_pwd.getText().toString() +"";
            //sendMsg= "userId="+params[0]+"&userPw"+params[1]+"&type="+params[2];
            Log.i("yj", param);
            try{
                //URL 연결 conn은 웹서버랑 연결하는 객체
                URL url = new URL("http://203.252.218.95:8080/Movie/login.jsp");
                //Log.i("yunjae", "http://10.57.177.97/AndroidProject_SharedDiary/signup.jsp");
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                //conn.setRequestProperty("Accept-Charset", "UTF-8");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.connect();
                //URL 연결

                Log.i("yj", "URL연결");

                //osw 은 출력할 문자열을 담을 객체 바구니 //osw 객체에 conn 을 연결
                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

                //osw 객체 바구니에 param 을 집어넣음
                Log.i("yj", "1");
                osw.write(param);
                //flush 쏟아내다 토해내다 . 버퍼에 담긴 내용을 토해냄
                Log.i("yj", param);
                osw.flush();
                Log.i("yj", "3");

                //만악 통신할 준비가 되었을 경우
                if (conn.getResponseCode() == conn.HTTP_OK){

                    //서버에서 안드로이드로 거꾸로 파라미터 값 전달
                    InputStreamReader in = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(in);
                    StringBuffer buffer = new StringBuffer();

                    //줄을 넘기기 전까지 계속 반복
                    while(reader.readLine() != null){
                        buffer.append(reader.readLine());
                    }
                    receiveMsg = buffer.toString();

                    JSONObject json = new JSONObject(receiveMsg);
                    JSONArray jArr = json.getJSONArray("datasend");

                    Log.i("yj", "MainActivity = " + jArr.length());

                    for(int i=0; i<jArr.length(); i++){
                        json = jArr.getJSONObject(i);
                        userId = json.getString("userId");
                        userPw = json.getString("userPw");

                    }

                }else{
                    Log.i("yj", conn.getResponseCode()+"통신할 준비가 되지 않은 에러");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return receiveMsg;
        }

        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);

            if(receiveMsg.contains("0")){
                Log.i("yj", "로그인 실패");
                Toast.makeText(getApplicationContext(),"로그인 실패",Toast.LENGTH_LONG).show();
            }
            else if(receiveMsg != null){
                Log.i("yj", "로그인 성공"+receiveMsg);
                //로그인 성공시 intent 사용해서 다른 액티비티로 넘어감

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //receiveMsg = receiveMsg.replaceAll("\\p{Z}","");
                //intent.putExtra("myName", receiveMsg);

                Log.i("yj", "///////");

                Toast.makeText(getApplicationContext(), "로그인 되었습니다.",Toast.LENGTH_LONG).show();
                startActivity(intent);
                finish();

            }
            else {
                Log.i("yj", "로그인에 실패하였습니다else"+receiveMsg);
                Toast.makeText(getApplicationContext(),"로그인 실패",Toast.LENGTH_LONG).show();
            }
        }

    }
}
