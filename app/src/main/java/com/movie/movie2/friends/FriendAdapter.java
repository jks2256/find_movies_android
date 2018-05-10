package com.movie.movie2.friends;

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

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by f on 2017-09-27.
 */

public class FriendAdapter extends BaseAdapter {

    public FriendAdapter(ArrayList<FriendDatas> friendDatas, Context context) {
        this.friendDatas = friendDatas;
        this.context = context;
    }

    ArrayList<FriendDatas> friendDatas;
    Context context;



    @Override
    public int getCount() {
        return friendDatas != null ? friendDatas.size()-1 : 0;
    }

    @Override
    public Object getItem(int position) {
        return position-1;
    }

    @Override
    public long getItemId(int position) {
        return position-1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(position==0){
                convertView = inflater.inflate(R.layout.freind_head, parent, false);
            } else{
                convertView = inflater.inflate(R.layout.freind_item, parent, false);
            }
        }


        ImageView custom_img = (ImageView) convertView.findViewById(R.id.custom_item_img);
        TextView custom_title = (TextView) convertView.findViewById(R.id.custom_item_title);
        TextView custom_content = (TextView) convertView.findViewById(R.id.custom_item_content);

        if(friendDatas.get(position).img != null) {
            Glide.with(context)
                    .load(friendDatas.get(position).img)
                    .bitmapTransform(new CropCircleTransformation(context))
                    .into(custom_img);
        }
        custom_title.setText(friendDatas.get(position).title);
        custom_content.setText(friendDatas.get(position).content);

        return convertView;
    }
}
