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

    ImageButton mMenuIB, mHomeIB, mLocationIB, mSearchIB, mSettingsIB, mNotificationIB, mCrossIB;

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
        mCrossIB= findViewById(R.id.crossIB);
        mCrossIB.setOnClickListener(mClickListener);
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

    private void showCrossButtonIB(){
        mMenuIB.setVisibility(View.GONE);
    }

    private void hideCrossButtonIB(){
        mMenuIB.setVisibility(View.VISIBLE);
//        mMenuIB.animate().alpha(1).scaleX(1).scaleY(1);
//        mCrossIB.animate().scaleX(0).scaleY(0);
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.menuIB:
                    onMenuOpened();
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

                case R.id.crossIB:
                    onMenuClosed();
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
        hideCrossButtonIB();
        hideHomeIB();
        hideSearchIB();
        hideLocationIB();
        hideSettingsIB();
        hideNotificationsIB();
    }


    private void onMenuOpened() {
        showCrossButtonIB();
        showButtons();
        showHomeIB();
        showSearchIB();
        showLocationIB();
        showSettingsIB();
        showNotificationsIB();
    }

    private void dimMenu(){

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
        AnimatorSet shrinkSet = new AnimatorSet();
        shrinkSet.playTogether(
                ObjectAnimator.ofFloat(mHomeIB, "translationY", 0),
                ObjectAnimator.ofFloat(mHomeIB, "scaleX",  1f,0),
                ObjectAnimator.ofFloat(mHomeIB, "scaleY",  1f,0)
        );
        shrinkSet.start();
    }

    private void showSearchIB() {
        AnimatorSet growSet = new AnimatorSet();
        growSet.playTogether(
                ObjectAnimator.ofFloat(mSearchIB, "translationY", -250),
                ObjectAnimator.ofFloat(mSearchIB, "translationX", 250),
                ObjectAnimator.ofFloat(mSearchIB, "scaleX", 0, 1.2f),
                ObjectAnimator.ofFloat(mSearchIB, "scaleY", 0, 1.2f)
        );
        growSet.start();

        AnimatorSet shrinkSet = new AnimatorSet();
        shrinkSet.playTogether(
                ObjectAnimator.ofFloat(mSearchIB, "translationY", -250, -200),
                ObjectAnimator.ofFloat(mSearchIB, "scaleX", 1.2f, 1f),
                ObjectAnimator.ofFloat(mSearchIB, "scaleY", 1.2f, 1f)
        );

        shrinkSet.setStartDelay(300);
        shrinkSet.start();
    }

    private void hideSearchIB(){
        AnimatorSet shrinkSet = new AnimatorSet();
        shrinkSet.playTogether(
                ObjectAnimator.ofFloat(mSearchIB, "translationY", 0),
                ObjectAnimator.ofFloat(mSearchIB, "translationX", 0),
                ObjectAnimator.ofFloat(mSearchIB, "scaleX",  1f,0),
                ObjectAnimator.ofFloat(mSearchIB, "scaleY",  1f,0)
        );
        shrinkSet.start();
    }


    private void showLocationIB() {
        AnimatorSet growSet = new AnimatorSet();
        growSet.playTogether(
                ObjectAnimator.ofFloat(mLocationIB, "translationY", -250),
                ObjectAnimator.ofFloat(mLocationIB, "translationX", -250),
                ObjectAnimator.ofFloat(mLocationIB, "scaleX", 0, 1.2f),
                ObjectAnimator.ofFloat(mLocationIB, "scaleY", 0, 1.2f)
        );
        growSet.start();

        AnimatorSet shrinkSet = new AnimatorSet();
        shrinkSet.playTogether(
                ObjectAnimator.ofFloat(mLocationIB, "translationY", -250, -200),
                ObjectAnimator.ofFloat(mLocationIB, "scaleX", 1.2f, 1f),
                ObjectAnimator.ofFloat(mLocationIB, "scaleY", 1.2f, 1f)
        );

        shrinkSet.setStartDelay(300);
        shrinkSet.start();
    }

    private void hideLocationIB(){
        AnimatorSet shrinkSet = new AnimatorSet();
        shrinkSet.playTogether(
                ObjectAnimator.ofFloat(mLocationIB, "translationY", 0),
                ObjectAnimator.ofFloat(mLocationIB, "translationX", 0),
                ObjectAnimator.ofFloat(mLocationIB, "scaleX",  1f,0),
                ObjectAnimator.ofFloat(mLocationIB, "scaleY",  1f,0)
        );
        shrinkSet.start();
    }

    private void showSettingsIB() {
        AnimatorSet growSet = new AnimatorSet();
        growSet.playTogether(
                ObjectAnimator.ofFloat(mSettingsIB, "translationY", 250),
                ObjectAnimator.ofFloat(mSettingsIB, "translationX", -250),
                ObjectAnimator.ofFloat(mSettingsIB, "scaleX", 0, 1.2f),
                ObjectAnimator.ofFloat(mSettingsIB, "scaleY", 0, 1.2f)
        );
        growSet.start();

        AnimatorSet shrinkSet = new AnimatorSet();
        shrinkSet.playTogether(
                ObjectAnimator.ofFloat(mSettingsIB, "translationY", 250, 200),
                ObjectAnimator.ofFloat(mSettingsIB, "scaleX", 1.2f, 1f),
                ObjectAnimator.ofFloat(mSettingsIB, "scaleY", 1.2f, 1f)
        );

        shrinkSet.setStartDelay(300);
        shrinkSet.start();
    }

    private void hideSettingsIB(){
        AnimatorSet shrinkSet = new AnimatorSet();
        shrinkSet.playTogether(
                ObjectAnimator.ofFloat(mSettingsIB, "translationY", 0),
                ObjectAnimator.ofFloat(mSettingsIB, "translationX", 0),
                ObjectAnimator.ofFloat(mSettingsIB, "scaleX",  1f,0),
                ObjectAnimator.ofFloat(mSettingsIB, "scaleY",  1f,0)
        );
        shrinkSet.start();
    }


    private void showNotificationsIB() {
        AnimatorSet growSet = new AnimatorSet();
        growSet.playTogether(
                ObjectAnimator.ofFloat(mNotificationIB, "translationY", 250),
                ObjectAnimator.ofFloat(mNotificationIB, "translationX", 250),
                ObjectAnimator.ofFloat(mNotificationIB, "scaleX", 0, 1.2f),
                ObjectAnimator.ofFloat(mNotificationIB, "scaleY", 0, 1.2f)
        );
        growSet.start();

        AnimatorSet shrinkSet = new AnimatorSet();
        shrinkSet.playTogether(
                ObjectAnimator.ofFloat(mNotificationIB, "translationY", 250, 200),
                ObjectAnimator.ofFloat(mNotificationIB, "scaleX", 1.2f, 1f),
                ObjectAnimator.ofFloat(mNotificationIB, "scaleY", 1.2f, 1f)
        );

        shrinkSet.setStartDelay(300);
        shrinkSet.start();
    }

    private void hideNotificationsIB(){
        AnimatorSet shrinkSet = new AnimatorSet();
        shrinkSet.playTogether(
                ObjectAnimator.ofFloat(mNotificationIB, "translationY", 0),
                ObjectAnimator.ofFloat(mNotificationIB, "translationX", 0),
                ObjectAnimator.ofFloat(mNotificationIB, "scaleX",  1f,0),
                ObjectAnimator.ofFloat(mNotificationIB, "scaleY",  1f,0)
        );
        shrinkSet.start();
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
