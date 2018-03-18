package colegio;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private static final long SPLASH_SCREEN_DELAY = 700;
    private Typeface LinLibertineB;

    private TextView texto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       this.LinLibertineB = Typeface.createFromAsset(getAssets(), "fuentes/LinLibertineB.ttf");

       texto1 = (TextView)findViewById(R.id.sp_txt);
       texto1.setTypeface(LinLibertineB);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent().setClass( SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, SPLASH_SCREEN_DELAY);
    }

}

