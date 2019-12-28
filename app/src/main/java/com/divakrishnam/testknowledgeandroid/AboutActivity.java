package com.divakrishnam.testknowledgeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnPhone, btnWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btnPhone = findViewById(R.id.btn_phone);
        btnWebsite = findViewById(R.id.btn_website);

        btnPhone.setOnClickListener(this);
        btnWebsite.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == btnPhone){
            phone();
        }else if(view == btnWebsite){
            website();
        }
    }

    public void phone() {
        String number = "0222009562";
        Uri uri = Uri.parse("tel:"+number);
        Intent phone = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(phone);
    }

    public void website() {
        String url = "http://poltekpos.ac.id/";
        Uri uri = Uri.parse(url);
        Intent website = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(website);
    }
}
