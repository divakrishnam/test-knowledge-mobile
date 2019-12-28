package com.divakrishnam.testknowledgeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvPoint, tvNickname;
    private Button btnAgain, btnHome;

    public static final String POINT = "";

    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvPoint = findViewById(R.id.tv_point);
        tvNickname = findViewById(R.id.tv_nickname);

        btnAgain = findViewById(R.id.btn_again);
        btnHome = findViewById(R.id.btn_home);

        btnAgain.setOnClickListener(this);
        btnHome.setOnClickListener(this);

        String point = getIntent().getStringExtra(POINT);
        tvPoint.setText(point);

        prefManager = new PrefManager(this);
        String nickname = prefManager.getNickname().trim();
        if (!nickname.isEmpty()){
            tvNickname.setText(String.format("%s%s %s", nickname.substring(0, 1).toUpperCase(), nickname.substring(1), getString(R.string.you_got)));
        }

    }

    @Override
    public void onClick(View view) {
        if (view == btnAgain){
            startActivity(new Intent(getApplicationContext(), TestActivity.class));
            finish();
        }else if(view == btnHome){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }
}
