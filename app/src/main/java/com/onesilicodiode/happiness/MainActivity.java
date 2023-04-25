package com.onesilicodiode.happiness;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tsuryo.androidcountdown.Counter;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Counter mCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button activateZen = findViewById(R.id.zenModeActiviate);
        activateZen.setOnClickListener(view -> {
            vibrateDevice();
            Intent toZenMode = new Intent(MainActivity.this, ZenMode.class);
            startActivity(toZenMode);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        });
        mCounter = findViewById(R.id.counter);
        mCounter.setDate("2023-05-02T00:00:00");
        mCounter.setListener(new Counter.Listener() {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d(TAG, "onTick: Counter - " + millisUntilFinished);
                vibrateDevice();
            }

            @Override
            public void onTick(long days, long hours, long minutes, long seconds) {
                Log.d(TAG, "onTick: Counter - " + days + "d " +
                        hours + "h " +
                        minutes + "m " +
                        seconds + "s " );
            }
        });
    }
    private void vibrateDevice() {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(20, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            vibrator.vibrate(20);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        finishAffinity();
    }
}