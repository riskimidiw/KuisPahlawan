package com.riskimidiw.kuispahlawan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnStart, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btn_start);
        btnAbout = (Button) findViewById(R.id.btn_about);
        btnStart.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
    }

    Intent j;
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                j = new Intent(this, QuizActivity.class);
                startActivity(j);
                break;
            case R.id.btn_about:
                j = new Intent(this, AboutActivity.class);
                startActivity(j);
        }

    }
}
