package com.movie.movie2.find;

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

public class FindAdapter extends BaseAdapter {

    public FindAdapter(ArrayList<FindDatas> findDatas, Context context) {
        this.findDatas = findDatas;
        this.context = context;
    }

    ArrayList<FindDatas> findDatas;
    Context context;



    @Override
    public int getCount() {
        return findDatas != null ? findDatas.size() : 0;
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
            convertView = inflater.inflate(R.layout.find_item, parent, false);
        }


//        ImageView go = (ImageView)convertView.findViewById(R.id.go);
//        go.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                context.startActivity(new Intent(context,DetailActivity.class));
//            }
//        });

        ImageView custom_img = (ImageView) convertView.findViewById(R.id.custom_place);
        TextView custom_title = (TextView) convertView.findViewById(R.id.custom_title);
        TextView custom_date = (TextView) convertView.findViewById(R.id.custom_date);

        if(findDatas.get(position).place != null) {
            Glide.with(context)
                    .load(findDatas.get(position).place)
                    .bitmapTransform(new CropCircleTransformation(context))
                    .into(custom_img);
        }
        custom_title.setText(findDatas.get(position).title);
        custom_date.setText(findDatas.get(position).time);



        return convertView;
    }
}
