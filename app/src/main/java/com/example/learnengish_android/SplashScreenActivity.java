package com.example.learnengish_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenActivity extends AppCompatActivity {
    private static int WELCOME_TIMEOUT = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EasySplashScreen config = new EasySplashScreen(SplashScreenActivity.this)
                .withFullScreen()
                //.withTargetActivity(MainActivity.class)
                //.withSplashTimeOut(5000)
                .withBackgroundColor(Color.parseColor("#1a1b29"))
                .withHeaderText("Header")
                .withFooterText("Footer")
                .withBeforeLogoText("Before Logo Text")
                .withAfterLogoText("After Logo Text")
                .withLogo(R.mipmap.ic_launcher_round);

        config.getHeaderTextView().setTextColor(Color.WHITE);
        config.getFooterTextView().setTextColor(Color.WHITE);
        config.getBeforeLogoTextView().setTextColor(Color.WHITE);
        config.getAfterLogoTextView().setTextColor(Color.WHITE);

        View easySplashScreen = config.create();
        setContentView(easySplashScreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(SplashScreenActivity.this,MainActivity.class);
                startActivity(welcome);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        },WELCOME_TIMEOUT);


    }
}
