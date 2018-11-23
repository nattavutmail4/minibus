package com.example.seven.minibus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        iv.startAnimation(myanim); // animation ของรูปภาพ
        final Intent intent = new Intent(this,Main2Activity.class);
        Thread timer = new Thread(){
            public  void  run(){
                try{
                    sleep(5000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    finish(); // สิ้นสุดการทำงานของ แอคทีวีตี้
                }
            }
        };
        timer.start();
    }
}
