package com.jest.smart;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeScreen extends Activity {

    private static int DURATION = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent home = new Intent(WelcomeScreen.this, HomeActivity.class);
                startActivity(home);
                finish();
            }
        }, DURATION);
    }
}
