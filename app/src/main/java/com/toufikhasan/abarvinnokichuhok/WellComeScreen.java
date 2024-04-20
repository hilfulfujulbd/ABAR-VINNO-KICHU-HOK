package com.toufikhasan.abarvinnokichuhok;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.toufikhasan.abarvinnokichuhok.main.MainApp;

public class WellComeScreen extends AppCompatActivity {
    LinearLayout developerInfo;
    Animation developerAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_well_come_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        developerInfo = findViewById(R.id.developer_info);

        // ProgressBar Animation
        developerAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.dev_animation);

        developerInfo.setAnimation(developerAnimation);

        Thread thread = new Thread(this::ProssingApplication);
        thread.start();
    }

    public void ProssingApplication() {
        int progress;
        for (progress = 0; progress <= 100; progress = progress + 1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        openApplication();
    }

    public void openApplication() {
        startActivity(new Intent(WellComeScreen.this, MainActivity.class));
        finish();
    }
}