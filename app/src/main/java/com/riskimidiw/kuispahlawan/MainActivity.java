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

    @Override
    Intent j = new Intent(
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                Intent i = new Intent(this, QuizActivity.class);
                startActivity(i);
                break;
            case R.id.btn_about:this, AboutActivity.class);
                startActivity(j);
        }

    }
}
