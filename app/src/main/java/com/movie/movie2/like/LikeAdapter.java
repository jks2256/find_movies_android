package com.movie.movie2.like;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.movie.movie2.R;

import java.util.ArrayList;

/**
 * Created by f on 2017-09-27.
 */

public class LikeAdapter extends BaseAdapter {

    public LikeAdapter(ArrayList<LikeDatas> likeDatas, Context context) {
        this.likeDatas = likeDatas;
        this.context = context;
    }

    ArrayList<LikeDatas> likeDatas;
    Context context;



    @Override
    public int getCount() {
        return likeDatas != null ? likeDatas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int[] flag = {0};
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.like_item, parent, false);

        }


        TextView custom_title = (TextView) convertView.findViewById(R.id.custom_item_taste);
        final ImageView custom_check = (ImageView) convertView.findViewById(R.id.custom_item_check);

        custom_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag[0] == 0){
                    custom_check.setImageResource(R.drawable.yellowcheckboxicon);
                    flag[0]++;
                } else if(flag[0] == 1){
                    custom_check.setImageResource(R.drawable.whitecheckicon);
                    flag[0]--;
                }
            }
        });

        custom_title.setText(likeDatas.get(position).like);
        custom_check.setImageResource(R.drawable.whitecheckicon);

        return convertView;
    }
}
