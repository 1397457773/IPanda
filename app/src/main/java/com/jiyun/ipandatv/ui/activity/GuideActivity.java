package com.jiyun.ipandatv.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.jiyun.ipandatv.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GuideActivity extends BaseActivity {


    @Bind(R.id.vp_ViewPager)
    ViewPager vpViewPager;
    private List<Integer> list = new ArrayList();
    private ImageView img;
    private SharedPreferences sp;

    @Override
    public void initData() {

        list.add(R.mipmap.guide_one);
        list.add(R.mipmap.guide_two);
        list.add(R.mipmap.guide_three);

        GuideViewPagerAdapter  adapter = new GuideViewPagerAdapter();
        vpViewPager.setCurrentItem(0,false);
        vpViewPager.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        vpViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == vpViewPager.getChildCount()-1){
                    img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SharedPreferences.Editor edit = sp.edit();
                            edit.putString("tag","tag");
                            edit.commit();

                            startActivity(new Intent(GuideActivity.this,MainActivity.class));
                            finish();
                        }
                    });
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        String tag = sp.getString("tag", "1");
        if (tag.equals("tag")){
            startActivity(new Intent(GuideActivity.this,MainActivity.class));
            finish();
        }
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        sp = this.getSharedPreferences("guide.db", 1);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_guide;
    }

    private class GuideViewPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = View.inflate(GuideActivity.this,R.layout.item_guide,null);
            img = view.findViewById(R.id.iv_ViewPager);
            img.setImageResource(list.get(position));

            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView(((View)object));
        }
    }

}
