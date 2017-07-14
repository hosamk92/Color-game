package com.immortal.color;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by IMMORTAl on 7/14/2017.
 */

public class gameover extends Activity {

    Button b ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);
        Intent intent = getIntent();
        String message = intent.getStringExtra("score");
        TextView t = (TextView) findViewById(R.id.val);
        final Intent nintent = new Intent(this, MainActivity.class);
        t.setText(message);
        b = (Button) findViewById(R.id.Restart);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(nintent);
                finish();
            }
        });
    }
}
