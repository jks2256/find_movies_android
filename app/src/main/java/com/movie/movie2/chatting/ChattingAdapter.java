package com.movie.movie2.chatting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.movie.movie2.R;

import java.util.ArrayList;

/**
 * Created by f on 2017-09-27.
 */

public class ChattingAdapter extends BaseAdapter {

    public ChattingAdapter(ArrayList<ChattingDatas> chattingDatas, Context context) {
        this.chattingDatas = chattingDatas;
        this.context = context;
    }

    ArrayList<ChattingDatas> chattingDatas;
    Context context;

    @Override
    public int getCount() {
        return chattingDatas != null ? chattingDatas.size() : 0;
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
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.chatting_item, parent, false);
        }


        ImageView custom_img = (ImageView) convertView.findViewById(R.id.custom_item_img);
        TextView custom_title = (TextView) convertView.findViewById(R.id.custom_item_title);
        TextView custom_content = (TextView) convertView.findViewById(R.id.custom_item_content);
        TextView custom_date = (TextView) convertView.findViewById(R.id.custom_item_date);

        if(chattingDatas.get(position).img != null) {
            Glide.with(context)
                    .load(chattingDatas.get(position).img)
                    .into(custom_img);
        }
        custom_title.setText(chattingDatas.get(position).title);
        custom_content.setText(chattingDatas.get(position).content);
        custom_date.setText(chattingDatas.get(position).date);

        return convertView;
    }
}
