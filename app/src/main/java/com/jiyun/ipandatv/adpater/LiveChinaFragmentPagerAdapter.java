package com.jiyun.ipandatv.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by lenovo on 2017/9/14.
 */

public class LiveChinaFragmentPagerAdapter extends FragmentStatePagerAdapter{
    List<Fragment> listFragment;
    List<String> listTitle;
    public LiveChinaFragmentPagerAdapter(FragmentManager supportFragmentManager, List<Fragment> listFragment, List<String> listTitle) {
        super(supportFragmentManager);
        this.listFragment=listFragment;
        this.listTitle=listTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }
}
