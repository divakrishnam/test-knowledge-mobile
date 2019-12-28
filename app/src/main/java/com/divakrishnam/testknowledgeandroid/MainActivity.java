package com.divakrishnam.testknowledgeandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStart;
    FloatingActionButton btnIntro;
    EditText etNickname;

    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btn_start);
        btnIntro = findViewById(R.id.fb_intro);
        etNickname = findViewById(R.id.et_nickname);

        btnStart.setOnClickListener(this);
        btnIntro.setOnClickListener(this);

        prefManager = new PrefManager(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.about) {
            startActivity(new Intent(this, AboutActivity.class));
        } else if (menuItem.getItemId() == R.id.setting) {
            startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view == btnIntro) {
            PrefManager prefManager = new PrefManager(getApplicationContext());
            prefManager.setFirstTimeLaunch(true);
            startActivity(new Intent(MainActivity.this, IntroSliderActivity.class));
            finish();
        } else if (view == btnStart) {
            toTest();
        }
    }

    private void toTest(){
        String nickname = etNickname.getText().toString().trim();
        if (!nickname.isEmpty()){
            prefManager.setNickname(nickname);
            startActivity(new Intent(MainActivity.this, TestActivity.class));
            etNickname.setText("");
        }else{
            Toast.makeText(getApplicationContext(), R.string.nickname_is_empty, Toast.LENGTH_SHORT).show();
        }
    }
}
