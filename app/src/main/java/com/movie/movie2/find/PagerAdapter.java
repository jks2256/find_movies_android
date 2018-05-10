package com.movie.movie2.find;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by f on 2017-09-28.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int tabcount;

    public PagerAdapter(FragmentManager fm, int tabcount) {
        super(fm);
        this.tabcount = tabcount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fragment_first();
            case 1:
                return new Fragment_second();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
