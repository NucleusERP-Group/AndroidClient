package com.martdevelopersinc.nucleussaaserp_android_client;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.analytics.FirebaseAnalytics;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    private ImageView logo;
    private static int splashTimeOut=7000;

    //Load Google Analytics
    private FirebaseAnalytics NucleusSaaS_ERP_AndroidClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo=(ImageView)findViewById(R.id.logo);

        // Obtain the FirebaseAnalytics instance.
        NucleusSaaS_ERP_AndroidClient = FirebaseAnalytics.getInstance(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this,WebViewActivity.class);
                startActivity(i);
                finish();
            }
        },splashTimeOut);

        Animation my_anim = AnimationUtils.loadAnimation(this,R.anim.splash_animation);
        logo.startAnimation(my_anim);
    }
}