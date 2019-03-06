package e.taufan.customerapps;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    Boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        sharedPreferences = getSharedPreferences("WijayaBaru_Prefs",MODE_PRIVATE);
        firstTime = sharedPreferences.getBoolean("firstTime",true);
        if(firstTime){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    firstTime = false;
                    editor.putBoolean("firstTime", firstTime);
                    editor.apply();
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            },5000);

        }else{
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }




    }
}
