package com.test.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }


    @OnClick({R.id.translate, R.id.scale, R.id.rotate, R.id.alpha, R.id.set, R.id.start_second})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.translate:
                setAnimation(R.anim.anim_translate);
                break;
            case R.id.scale:
                setAnimation(R.anim.anim_scale);
                break;
            case R.id.rotate:
                setAnimation(R.anim.anim_rotate);
                break;
            case R.id.alpha:
                setAnimation(R.anim.anim_alpha);
                break;
            case R.id.set:
                setAnimation(R.anim.set_anim);
                break;
            case R.id.start_second:
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
        }
    }

    private void setAnimation(int resId) {
        Animation anim = AnimationUtils.loadAnimation(this, resId);
        anim.setFillAfter(true);
        anim.setDuration(3000);
        iv.startAnimation(anim);
    }
}
