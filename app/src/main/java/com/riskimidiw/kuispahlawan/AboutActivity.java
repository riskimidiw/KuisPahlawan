package com.riskimidiw.kuispahlawan;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{
    LinearLayout btn_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btn_mail = (LinearLayout) findViewById(R.id.btn_mail);
        btn_mail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:riskimidiw@gmail.com"));

        if(i.resolveActivity(getPackageManager())!=null) {
            startActivity(i);
        }
    }
}
