package com.riskimidiw.kuispahlawan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.Inet4Address;

public class ScoreActivity extends AppCompatActivity implements View.OnClickListener{
    TextView score, benar, salah, kosong;
    Button pembahasan;
    int benarValue, salahValue, kosongValue, scoreValue;
    String[] listJawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score = (TextView) findViewById(R.id.score);
        benar = (TextView) findViewById(R.id.benar);
        salah = (TextView) findViewById(R.id.salah);
        kosong = (TextView) findViewById(R.id.kosong);
        pembahasan =(Button) findViewById(R.id.btn_pembahsan);

        benarValue = getIntent().getIntExtra("BENAR", 0);
        benar.setText("" + benarValue);
        salahValue = getIntent().getIntExtra("SALAH", 0);
        salah.setText("" + salahValue);
        kosongValue = getIntent().getIntExtra("KOSONG", 0);
        kosong.setText("" + kosongValue);
        scoreValue = benarValue * 10;
        score.setText("" + scoreValue);

        listJawaban = getIntent().getStringArrayExtra("LIST_JAWABAN");

        pembahasan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(), AnswerActivity.class);

        i.putExtra("BENAR", benarValue);
        i.putExtra("SALAH", salahValue);
        i.putExtra("KOSONG", kosongValue);
        i.putExtra("LIST_JAWABAN", listJawaban);

        startActivity(i);
        finish();
    }
}
