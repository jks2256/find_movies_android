package com.movie.movie2;

import com.movie.movie2.first.loginData;
import com.movie.movie2.first.loginresult;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by f on 2017-06-30.
 */

public interface NetworkService {

    //회원가입
    @Multipart
    @POST("/users")
    Call<resultMessage> postSignup(@Part("userid") RequestBody userid,
                                              @Part("password") RequestBody password,
                                              @Part("email") RequestBody email,
                                              @Part("name") RequestBody name,
                                              @Part MultipartBody.Part img);

    //login
    @POST("/users/login")
    Call<loginresult> getLogin(@Body loginData loginData);

    @GET("/users/idtest/{userid}")
    Call<resultMessage> idCheck(@Path("userid") String userid);

    @GET("/users/emailtest/{email}")
    Call<resultMessage> emailCheck(@Path("email") String email);

//    @Multipart
//    @POST("/post/add")
//    Call<PostResult> registerPost(@Part("category") int category,
//                                  @Part("part") RequestBody part,
//                                  @Part("title") RequestBody title,
//                                  @Part("contents") RequestBody contents,
//                                  @Part("user_nick") RequestBody user_nick,
//                                  @Part MultipartBody.Part[] image);
//
//    @POST("/post/deletecheck")
//    Call<deletecheckResult> deletecheck(@Body deleteInfo deleteinfo);
//
//    @POST("/post/delete")
//    Call<deleteResult> deletePost(@Body deleteInfo deleteInfo);
//
//    @GET("/alarm/{user_nick}")
//    Call<AlarmResults> getAlarmDatas(@Path("user_nick") String user_nick);
//
//    @GET("/alarm/readinfo/{alarm_id}")
//    Call<AlarmCheck> postAlarmCheck(@Path("alarm_id") int alarm_id);

}
