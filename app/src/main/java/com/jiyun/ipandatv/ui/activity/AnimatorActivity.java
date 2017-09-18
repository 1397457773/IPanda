package com.jiyun.ipandatv.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.jiyun.ipandatv.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AnimatorActivity extends AppCompatActivity {

    @Bind(R.id.activity_animator)
    RelativeLayout activityAnimator;
    private Handler handler = new Handler();
    private int x = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        ButterKnife.bind(this);

        handler.postDelayed(runnable,1000);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            x--;
            handler.postDelayed(runnable,1000);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (x == 0){
                        startActivity(new Intent(AnimatorActivity.this,GuideActivity.class));
                        finish();
                    }
                }
            });
        }
    };
}
