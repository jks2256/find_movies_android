package com.movie.movie2.first;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.movie.movie2.ApplicationController;
import com.movie.movie2.NetworkService;
import com.movie.movie2.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import static android.widget.Toast.makeText;

public class SignupActivity extends AppCompatActivity {

    final int REQ_CODE_SELECT_IMAGE = 100;

    EditText edt_id;
    EditText edt_email;
    EditText edt_pwd;
    EditText edt_pwd_0;
    EditText edt_name;
    String id;
    String user_email;
    String serverURL = "http://203.252.218.95/Movie/register.jsp";

    String imgUrl = "";
    Uri data;

    //    ImageView setpicture;
    ImageView email_test;
    ImageView number_test;
    ImageView btn_signup;

    NetworkService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_id = (EditText)findViewById(R.id.edt_id);
        edt_email = (EditText)findViewById(R.id.edt_email);
        edt_pwd = (EditText)findViewById(R.id.edt_pwd);
        edt_pwd_0 = (EditText)findViewById(R.id.edt_pwd_0);
//        ImageView setpicture = (ImageView)findViewById(R.id.setpicture);
        ImageView email_test = (ImageView)findViewById(R.id.email_test);
        ImageView id_test = (ImageView)findViewById(R.id.id_test);

        ImageView btn_signup = (ImageView)findViewById(R.id.btn_signup);

        service = ApplicationController.getInstance().getNetworkService();

/*      // 이메일 중복확인버튼_파머
        email_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<resultMessage> EmailCheck = service.emailCheck(String.valueOf(edt_email.getText()));
                EmailCheck.enqueue(new Callback<resultMessage>() {
                    @Override
                    public void onResponse(Call<resultMessage> call, Response<resultMessage> response) {
                        if(response.isSuccessful()){
                            if(response.body().message.equals("yes")){
                                user_email = String.valueOf(edt_email.getText());
                                makeText(getApplicationContext(),"email이 사용가능합니다.", Toast.LENGTH_SHORT).show();
                            }
                            else if(response.body().message.equals("no")){
                                makeText(getApplicationContext(),"email이 중복되었습니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<resultMessage> call, Throwable t) {

                    }
                });
            }
        });
*/
//        setpicture.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
//                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);
//            }
//        });

        // 아이디중복확인 버튼_미완성
        id_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("yj","아이디 중복확인버튼 눌림");

                String id = edt_id.getText().toString();

                try {
                    String result;
                    id_testThread IDB = new id_testThread();
                    result = IDB.execute(edt_id.getText().toString()).get();
                    Log.i("yj","db연결");

                    if(result.equals("0")) {
                        Toast.makeText(getApplicationContext(), "존재하는 아이디입니다.", Toast.LENGTH_SHORT).show();
                        edt_id.setText("");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

/*       // 아이디중복확인 버튼_파머
        id_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<resultMessage> IDCHECK = service.idCheck(String.valueOf(edt_id.getText()));
                IDCHECK.enqueue(new Callback<resultMessage>() {
                    @Override
                    public void onResponse(Call<resultMessage> call, Response<resultMessage> response) {
                        if(response.isSuccessful()){
                            if(response.body().message.equals("no user")){
                                id = String.valueOf(edt_id.getText());
                                makeText(getApplicationContext(),"id가 사용가능합니다.", Toast.LENGTH_SHORT).show();
                            }
                            else if(response.body().message.equals("no")){
                                makeText(getApplicationContext(),"id가 중복되었습니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<resultMessage> call, Throwable t) {
                        makeText(getApplicationContext(),"통신 error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
  */
        // 회원가입 버튼_미완성
        btn_signup.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.i("yj","확인버튼 눌림");

                String name =edt_name.getText().toString();
                String id = edt_id.getText().toString();
                String pw = edt_pwd.getText().toString();
                String email = edt_email.getText().toString();

                try {
                    String result;
                    registerDB IDB = new registerDB();
                    result = IDB.execute(edt_name.getText().toString() , edt_id.getText().toString(), edt_pwd.getText().toString(), edt_email.getText().toString()).get();
                    Log.i("yj","db연결");

                    if(result.equals("0")) {
                        Toast.makeText(getApplicationContext(), "존재하는 아이디입니다.", Toast.LENGTH_SHORT).show();
                        edt_id.setText("");
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "회원가입들 축하합니다.", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                        finish();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }



            }
        });
/*
      //회원가입버튼_파머
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id.equals(String.valueOf(edt_id.getText()))&&user_email.equals(String.valueOf(edt_email.getText()))) {
                    Log.i(id,user_email);
                    if(String.valueOf(edt_pwd.getText()).equals(String.valueOf(edt_pwd_0.getText()))){
                        RequestBody userid = RequestBody.create(MediaType.parse("multipart/form-data"), id);
                        RequestBody email = RequestBody.create(MediaType.parse("multipart/form-data"), user_email);
                        RequestBody password = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(edt_pwd.getText()));
                        RequestBody name = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(edt_name.getText()));
                        MultipartBody.Part img;

                        if (imgUrl == "") {
                            img = null;
                        } else{
                            BitmapFactory.Options options = new BitmapFactory.Options();
//                       options.inSampleSize = 4; //얼마나 줄일지 설정하는 옵션 4--> 1/4로 줄이겠다

                            InputStream in = null; // here, you need to get your context.
                            try {
                                in = getContentResolver().openInputStream(data);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                       //inputstream 형태로 받은 이미지로 부터 비트맵을 만들어 바이트 단위로 압축
                        //그이우 스트림 배열에 담아서 전송합니다.


                            Bitmap bitmap = BitmapFactory.decodeStream(in, null, options); // InputStream 으로부터 Bitmap 을 만들어 준다.
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos);
                            // 압축 옵션( JPEG, PNG ) , 품질 설정 ( 0 - 100까지의 int형 ), 압축된 바이트 배열을 담을 스트림
                            RequestBody photoBody = RequestBody.create(MediaType.parse("image/jpg"), baos.toByteArray());

                            File photo = new File(imgUrl); // 가져온 파일의 이름을 알아내려고 사용합니다

                            Log.i("QWE", imgUrl);

                            // MultipartBody.Part 실제 파일의 이름을 보내기 위해 사용!!
                            img = MultipartBody.Part.createFormData("image", photo.getName(), photoBody);


                        }

                        Call<resultMessage> PostSignup = service.postSignup(userid,password,email,name,img);
                        PostSignup.enqueue(new Callback<resultMessage>() {
                            @Override
                            public void onResponse(Call<resultMessage> call, Response<resultMessage> response) {
                                if(response.isSuccessful()){
                                    if(response.body().message.equals("ok")){
                                        makeText(getApplicationContext(),"회원가입에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                                        finish();
                                    }
                                    else{
                                        makeText(getApplicationContext(),"회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<resultMessage> call, Throwable t) {
                                makeText(getApplicationContext(),"통신 error", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } else {
                    makeText(getApplicationContext(),"id와 전화번호 중복체크를 해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
*/
    }
    // 이미지_파머
    public String getImageNameToUri(Uri data) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(data, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        String imgPath = cursor.getString(column_index);
        String imgName = imgPath.substring(imgPath.lastIndexOf("/") + 1);

        imgUrl = imgPath;
        return imgName;
    }
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        if (requestCode == REQ_CODE_SELECT_IMAGE) {
//            if (resultCode == Activity.RESULT_OK) {
//                try {
//                    //Uri에서 이미지 이름을 얻어온다.
//                    String name_Str = getImageNameToUri(data.getData());
//                    this.data = data.getData();
//
//                    Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
//
//                    ImageView image = (ImageView) findViewById(R.id.user_img);
//
//                    //배치해놓은 ImageView에 set
//                    image.setImageBitmap(image_bitmap);
//
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            } else {
//                imgUrl = "";
//            }
//        }
//    }

    class registerDB extends AsyncTask<String, Integer, String> {

        String receiveMsg;

        //메인쓰레드 -> 신규쓰레드 작업
        protected String doInBackground(String...params){

            // param 에 문자열 저장
            String param = "userId=" + edt_id.getText().toString() + "&userPw=" + edt_pwd.getText().toString() + "&userName="
                    + edt_name.getText().toString() + "&userEmail=" + edt_email.getText().toString() + "";
            Log.i("yj", param);
            try{
                //URL 연결 conn은 웹서버랑 연결하는 객체
                URL url = new URL("http://203.252.218.95:8080/Movie/register.jsp");
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
                }else{
                    Log.i("Movie", conn.getResponseCode()+"통신할 준비가 되지 않은 에러");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return receiveMsg;
        }

        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);

            if(receiveMsg.contains("0")){
                Log.i("yj", "회원가입 실패");
                Toast.makeText(getApplicationContext(),"회원가입 실패",Toast.LENGTH_LONG).show();
            }
            else if(receiveMsg != null){
                Log.i("yj", "회원가입에 성공"+receiveMsg);
                //로그인 성공시 intent 사용해서 다른 액티비티로 넘어감

                //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //receiveMsg = receiveMsg.replaceAll("\\p{Z}","");
                //intent.putExtra("myName", receiveMsg);
                Toast.makeText(getApplicationContext(), "회원가입을 환영합니다",Toast.LENGTH_LONG).show();
                //startActivity(intent);
                finish();

            }
            else {
                Log.i("yj", "회원가입에 실패하였습니다else"+receiveMsg);
                Toast.makeText(getApplicationContext(),"회원가입 실패",Toast.LENGTH_LONG).show();
            }
        }

    }
    // 아이디중복확인 스레드
    class id_testThread extends AsyncTask<String, Integer, String> {

        String receiveMsg;

        //메인쓰레드 -> 신규쓰레드 작업
        protected String doInBackground(String...params){

            // param 에 문자열 저장
            String param = "userId=" + edt_id.getText().toString() + "";
            Log.i("yj", param);
            try{
                //URL 연결 conn은 웹서버랑 연결하는 객체
                URL url = new URL("http://203.252.218.95:8080/Movie/register.jsp");
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
                }else{
                    Log.i("Movie", conn.getResponseCode()+"통신할 준비가 되지 않은 에러");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return receiveMsg;
        }

        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);

            if(receiveMsg.contains("0")){
                Log.i("yj", "아이디 중복임");
                Toast.makeText(getApplicationContext(),"아이디가 중복입니다.",Toast.LENGTH_LONG).show();
            }
            else if(receiveMsg != null){
                Log.i("yj", "아이디 중복아님"+receiveMsg);
                //로그인 성공시 intent 사용해서 다른 액티비티로 넘어감

                //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //receiveMsg = receiveMsg.replaceAll("\\p{Z}","");
                //intent.putExtra("myName", receiveMsg);
                Toast.makeText(getApplicationContext(), "아이디가 중복이 아닙니다.",Toast.LENGTH_LONG).show();
                //startActivity(intent);
                //finish();

            }
            else {
                Log.i("yj", "아이디가 중복입니다.else"+receiveMsg);
                Toast.makeText(getApplicationContext(),"아이디 중복임.",Toast.LENGTH_LONG).show();
            }
        }

    }
}