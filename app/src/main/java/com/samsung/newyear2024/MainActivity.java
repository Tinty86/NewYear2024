package com.samsung.newyear2024;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView congrats;
    MediaPlayer mp;
    ImageView bell;
    boolean is_Play = false;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        congrats = findViewById(R.id.congrats);
        bell = findViewById(R.id.bell);
        anim = AnimationUtils.loadAnimation(this,R.anim.bell_anim);
        mp = MediaPlayer.create(this, R.raw.jb);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (is_Play) {
            mp.start();
            bell.startAnimation(anim);
        }
    }

    public void go(View view) {
        congrats.setVisibility(View.VISIBLE);
        if (is_Play) {
            mp.pause();
            bell.clearAnimation();
            congrats.clearAnimation();
            is_Play = false;
        }
        else {
            mp.start();
            bell.startAnimation(anim);
            congrats.startAnimation(anim);
            is_Play = true;
        }
    }
}