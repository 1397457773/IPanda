package com.jiyun.ipandatv.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/9/15.
 */
public class LiveAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<String> title;

    public LiveAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> title) {
        super(fm);
        this.fragments = fragments;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return title.get(position);
    }
}