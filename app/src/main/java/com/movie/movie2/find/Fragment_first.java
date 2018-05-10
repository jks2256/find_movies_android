package com.movie.movie2.find;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.movie.movie2.R;

import java.util.ArrayList;

/**
 * Created by f on 2017-04-29.
 */

public class Fragment_first extends android.support.v4.app.Fragment{

    ListView listView;
    ArrayList<FindDatas> findDatas;
    FindAdapter findAdapter;

    public Fragment_first() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.first_content, container, false);

        listView = (ListView) view.findViewById(R.id.listView);
        findDatas = new ArrayList<FindDatas>();

        findDatas.add(new FindDatas("time","title","dk ahadl dkswhgek"));
        findDatas.add(new FindDatas("time","title","dk ahadl dkswhgek"));
        findDatas.add(new FindDatas("time","title","dk ahadl dkswhgek"));
        findDatas.add(new FindDatas("time","title","dk ahadl dkswhgek"));
        findDatas.add(new FindDatas("time","title","dk ahadl dkswhgek"));
        findDatas.add(new FindDatas("time","title","dk ahadl dkswhgek"));
        findDatas.add(new FindDatas("time","title","dk ahadl dkswhgek"));
        findDatas.add(new FindDatas("time","title","dk ahadl dkswhgek"));
        findDatas.add(new FindDatas("time","title","dk ahadl dkswhgek"));

        findAdapter = new FindAdapter(findDatas, getContext());
        listView.setAdapter(findAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getContext(),DetailActivity.class));
            }
        });

        return view;
    }
}
