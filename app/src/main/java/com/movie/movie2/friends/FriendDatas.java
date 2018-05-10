package com.movie.movie2.friends;

/**
 * Created by f on 2017-09-27.
 */

public class FriendDatas {
    //데이터 임의로 넣어놓았습니다. api문서에 따라 통신 데이터 불러오세요
    String img;
    String title;
    String content;

    public FriendDatas(String img, String title, String content) {
        //나중에 img int말고 string으로 선언해서 bitmap으로 uri변환시켜서 넣으면 됩니다.
        this.img = img;
        this.title = title;
        this.content = content;
    }
}
