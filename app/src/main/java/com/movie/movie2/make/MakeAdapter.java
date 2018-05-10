package com.movie.movie2.make;

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

public class MakeAdapter extends BaseAdapter {

    public MakeAdapter(ArrayList<MakeDatas> makeDatas, Context context) {
        this.makeDatas = makeDatas;
        this.context = context;
    }

    ArrayList<MakeDatas> makeDatas;
    Context context;



    @Override
    public int getCount() {
        return makeDatas != null ? makeDatas.size() : 0;
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
            convertView = inflater.inflate(R.layout.make_item, parent, false);
        }


        ImageView custom_img = (ImageView) convertView.findViewById(R.id.custom_item_img);
        TextView custom_title = (TextView) convertView.findViewById(R.id.custom_item_title);
        final ImageView custom_check = (ImageView) convertView.findViewById(R.id.custom_item_check);

        convertView.setOnClickListener(new View.OnClickListener() {
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

        if(makeDatas.get(position).img != null) {
            Glide.with(context)
                    .load(makeDatas.get(position).img)
                    .bitmapTransform(new CropCircleTransformation(context))
                    .into(custom_img);
        }
        custom_title.setText(makeDatas.get(position).title);
        custom_check.setImageResource(R.drawable.whitecheckicon);

        return convertView;
    }
}
