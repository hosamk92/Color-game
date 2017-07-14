package com.immortal.color;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    TextView t1,t2;
    Random rand;
    String [] Colo =  new String[]{"Red","Green","Gray","Yellow",
            "Blue","Orange","Purple","Brown","Pink","White"};

    int [] Col =  new int[]{Color.RED,Color.GREEN,Color.GRAY,Color.YELLOW,
            Color.BLUE,Color.parseColor("#FF4500")
            ,Color.parseColor("#9932CC"),Color.parseColor("#D2691E"),Color.parseColor("#FFC0CB"),Color.WHITE};

    int n,n2,tr;
    long  startTime = 0;
    ImageButton w,t;
    ProgressBar p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView)findViewById(R.id.tv1);
        t2 = (TextView)findViewById(R.id.tv2);
        w = (ImageButton)findViewById(R.id.wrong) ;
        t = (ImageButton)findViewById(R.id.true1) ;
        rand = new Random();
        final Intent intent = new Intent(this, gameover.class);

        n = rand.nextInt(9) ;
        n2 = rand.nextInt(9) ;
        tr = rand.nextInt(2) ;
        if(tr==1)n2=n;
        t1.setText(Colo[n]);
        t1.setTextColor(Col[n2]);
        w.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startTime = System.currentTimeMillis();
                if (n != n2)
                {
                    t2.setText("" + (Integer.parseInt(t2.getText().toString())+1));
                }
                else {
                    intent.putExtra("score",t2.getText().toString());
                    startActivity(intent);
                    finish();
                }
                // Code here executes on main thread after user presses button
                n = rand.nextInt(9) ;
                n2 = rand.nextInt(9) ;
                tr = rand.nextInt(2) ;
                if(tr==1)n2=n;
                t1.setText(Colo[n]);
                t1.setTextColor(Col[n2]);
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startTime = System.currentTimeMillis();
                if (n == n2)
                {
                    t2.setText("" + (Integer.parseInt(t2.getText().toString())+1));
                }
                else {
                    intent.putExtra("score", t2.getText().toString());
                    startActivity(intent);
                    finish();
                }
                // Code here executes on main thread after user presses button
                n = rand.nextInt(9) ;
                n2 = rand.nextInt(9) ;
                tr = rand.nextInt(2) ;
                if(tr==1)n2=n;
                t1.setText(Colo[n]);
                t1.setTextColor(Col[n2]);
            }
        });
    }
}
