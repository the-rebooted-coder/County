package com.onesilicodiode.happiness;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;

@SuppressLint("CustomSplashScreen")
public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        one();
        setContentView(R.layout.launch_activity);
    }
    private void one() {
        int feelUI = 860;
        two();
        new Handler().postDelayed(this::vibrateDevice, feelUI);
    }
    private void two() {
        int feelUItwo = 920;
        three();
        new Handler().postDelayed(this::vibrateDeviceSecond, feelUItwo);
    }
    private void three() {
        int feelUIthree = 980;
        fireSplashScreen();
        new Handler().postDelayed(this::vibrateDeviceThird, feelUIthree);
    }
    private void fireSplashScreen() {
        int splash_screen_time_out = 2500;
        new Handler().postDelayed(this::check, splash_screen_time_out);
    }
    private void check() {
        Intent toLanding = new Intent (LaunchActivity.this,LandingActivity.class);
        startActivity(toLanding);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }

    private void vibrateDevice() {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(28, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            vibrator.vibrate(25);
        }
    }
    private void vibrateDeviceSecond() {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(32, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            vibrator.vibrate(28);
        }
    }
    private void vibrateDeviceThird() {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(36, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            vibrator.vibrate(32);
        }
    }
}