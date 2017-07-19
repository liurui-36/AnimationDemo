package com.test.animation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ThreeActivity extends AppCompatActivity {

    @InjectView(R.id.btn_1)
    Button btn_1;
    @InjectView(R.id.btn_2)
    Button btn_2;
    @InjectView(R.id.btn_3)
    Button btn_3;
    @InjectView(R.id.btn_4)
    Button btn_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        ButterKnife.inject(this);

        setTitle("属性动画");
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                ObjectAnimator.ofFloat(btn_1, "translationY", btn_1.getHeight()).start();
                break;
            case R.id.btn_2:
                changeColor();
                break;
            case R.id.btn_3:
                all();
                break;
            case R.id.btn_4:
                AnimatorSet set = (AnimatorSet) AnimatorInflater
                        .loadAnimator(ThreeActivity.this, R.animator.animator);
                set.setTarget(btn_4);
                set.start();
                break;
        }
    }

    private void changeColor() {
        ValueAnimator anim = ObjectAnimator
                .ofInt(btn_2, "backgroundColor", 0xFFFFFFFF, 0xFFFF0000);
        anim.setDuration(3000);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.start();
    }

    private void all() {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(btn_3, "rotationX", 0, 360),
                ObjectAnimator.ofFloat(btn_3, "rotationY", 0, 180),
                ObjectAnimator.ofFloat(btn_3, "rotation", 0, -90),
                ObjectAnimator.ofFloat(btn_3, "translationX", 0, 90),
                ObjectAnimator.ofFloat(btn_3, "translationY", 0, 90),
                ObjectAnimator.ofFloat(btn_3, "scaleX", 1, 2),
                ObjectAnimator.ofFloat(btn_3, "scaleY", 1, 2),
                ObjectAnimator.ofFloat(btn_3, "alpha", 1, 0.2f, 1)
        );
        set.setDuration(5000).start();
    }

}
