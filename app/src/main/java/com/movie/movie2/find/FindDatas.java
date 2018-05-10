package com.movie.movie2.find;

/**
 * Created by f on 2017-09-27.
 */

public class FindDatas {
    //데이터 임의로 넣어놓았습니다. api문서에 따라 통신 데이터 불러오세요
    String time;
    String place;
    String title;

    public FindDatas(String time, String title, String place) {
        this.time = time;
        this.title = title;
        this.place = place;
    }
}
