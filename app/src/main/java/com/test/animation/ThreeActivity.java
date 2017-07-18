package com.test.animation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ThreeActivity extends AppCompatActivity {

    @InjectView(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        ButterKnife.inject(this);

        setTitle("属性动画");
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        ObjectAnimator.ofFloat(btn, "translationY", -btn.getHeight()).start();
    }
}
