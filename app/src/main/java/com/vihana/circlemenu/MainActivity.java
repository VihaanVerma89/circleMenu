package com.vihana.circlemenu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        initButtons();
        initToolbar();
    }

    private void initToolbar() {
        getSupportActionBar().hide();
    }

    ImageButton mMenuIB, mHomeIB, mLocationIB, mSearchIB, mSettingsIB, mNotificationIB;

    private void initButtons() {
        findButtons();
//        hideButtons();
    }

    private void findButtons() {
        mMenuIB = findViewById(R.id.menuIB);
        mMenuIB.setOnClickListener(mClickListener);
        mHomeIB = findViewById(R.id.homeIB);
        mHomeIB.setOnClickListener(mClickListener);
        mSearchIB = findViewById(R.id.searchIB);
        mSearchIB.setOnClickListener(mClickListener);
        mLocationIB = findViewById(R.id.locationIB);
        mLocationIB.setOnClickListener(mClickListener);
        mSettingsIB = findViewById(R.id.settingIB);
        mSearchIB.setOnClickListener(mClickListener);
        mNotificationIB = findViewById(R.id.notificationIB);
        mNotificationIB.setOnClickListener(mClickListener);
    }

    private void hideButtons() {
        mHomeIB.setVisibility(View.GONE);
        mLocationIB.setVisibility(View.GONE);
        mSearchIB.setVisibility(View.GONE);
        mSettingsIB.setVisibility(View.GONE);
        mNotificationIB.setVisibility(View.GONE);
    }

    private void showButtons() {
        mHomeIB.setVisibility(View.VISIBLE);
        mLocationIB.setVisibility(View.VISIBLE);
        mSearchIB.setVisibility(View.VISIBLE);
        mSettingsIB.setVisibility(View.VISIBLE);
        mNotificationIB.setVisibility(View.VISIBLE);
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.menuIB:
                    onMenuIBClicked();
                    break;

                case R.id.homeIB:
                    onHomeIBClicked();
                    break;
                case R.id.searchIB:
                    onSearchIBClicked();
                    break;
                case R.id.notificationIB:
                    onNotificationIBClicked();
                    break;
                case R.id.settingIB:
                    onSettingsIBClicked();
                    break;
                case R.id.locationIB:
                    onLocationIBClicked();
                    break;
            }
        }
    };


    boolean mMenuClosed = true;

    private void onMenuIBClicked() {
        if (mMenuClosed) {
            mMenuClosed = false;
            onMenuOpened();
        } else {
            mMenuClosed = true;
            onMenuClosed();
        }
    }

    private void onMenuClosed() {
//        hideButtons();
        hideHomeIB();
    }

    private void showHomeIB() {
        AnimatorSet growSet = new AnimatorSet();
        growSet.playTogether(
                ObjectAnimator.ofFloat(mHomeIB, "translationY", -350),
                ObjectAnimator.ofFloat(mHomeIB, "scaleX", 0, 1.2f),
                ObjectAnimator.ofFloat(mHomeIB, "scaleY", 0, 1.2f)
        );
        growSet.start();

        AnimatorSet shrinkSet = new AnimatorSet();
        shrinkSet.playTogether(
                ObjectAnimator.ofFloat(mHomeIB, "translationY", -350, -300),
                ObjectAnimator.ofFloat(mHomeIB, "scaleX", 1.2f, 1f),
                ObjectAnimator.ofFloat(mHomeIB, "scaleY", 1.2f, 1f)
        );

        shrinkSet.setStartDelay(300);
        shrinkSet.start();
    }

    private void hideHomeIB(){
        AnimatorSet growSet = new AnimatorSet();
        growSet.playTogether(
                ObjectAnimator.ofFloat(mHomeIB, "translationY", 0),
                ObjectAnimator.ofFloat(mHomeIB, "scaleX",  1f,0),
                ObjectAnimator.ofFloat(mHomeIB, "scaleY",  1f,0)
        );
        growSet.start();

//        AnimatorSet shrinkSet = new AnimatorSet();
//        shrinkSet.playTogether(
//                ObjectAnimator.ofFloat(mHomeIB, "translationY", -350, -300),
//                ObjectAnimator.ofFloat(mHomeIB, "scaleX", 1.2f, 1f),
//                ObjectAnimator.ofFloat(mHomeIB, "scaleY", 1.2f, 1f)
//        );
//
//        shrinkSet.setStartDelay(300);
//        shrinkSet.start();
    }

    private void onMenuOpened() {
        showButtons();

        showHomeIB();


    }

    private void onHomeIBClicked() {

    }

    private void onSearchIBClicked() {

    }

    private void onNotificationIBClicked() {

    }

    private void onSettingsIBClicked() {

    }

    private void onLocationIBClicked() {

    }
}
