package com.divakrishnam.testknowledgeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etAnswer1, etAnswer5;
    private Spinner spAnswer4;
    private CheckBox cbImplicit, cbExplicit, cbActivity;
    private RadioButton rbBundle, rbActivity, rbString;
    private Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        etAnswer1 = findViewById(R.id.et_answer1);
        etAnswer5 = findViewById(R.id.et_answer5);
        spAnswer4 = findViewById(R.id.sp_answer4);
        cbImplicit = findViewById(R.id.cb_implicit);
        cbExplicit = findViewById(R.id.cb_explicit);
        cbActivity = findViewById(R.id.cb_activity);
        rbBundle = findViewById(R.id.rb_bundle);
        rbActivity = findViewById(R.id.rb_activity);
        rbString = findViewById(R.id.rb_string);
        btnFinish = findViewById(R.id.btn_finish);

        btnFinish.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnFinish){
            validationAnswer();
        }
    }

    private void validationAnswer(){

        boolean valid = false;

        String answer1 = etAnswer1.getText().toString().trim().toLowerCase();
        String answer2 = "";
        String answer3 = "";
        String answer4 = "";
        String answer5 = etAnswer5.getText().toString().trim().toLowerCase();

        if(answer1.isEmpty()){
            valid = true;
        }

        if(answer5.isEmpty()){
            valid = true;
        }

        if (rbString.isChecked()){
            answer2 = rbString.getText().toString().toLowerCase();
        }else if(rbActivity.isChecked()){
            answer2 = rbActivity.getText().toString().toLowerCase();
        }else if(rbBundle.isChecked()){
            answer2 = rbBundle.getText().toString().toLowerCase();
        }else{
            valid = true;
        }

        if (cbActivity.isChecked()){
            answer3 += cbActivity.getText().toString().toLowerCase();
        }

        if (cbExplicit.isChecked()){
            answer3 += cbExplicit.getText().toString().toLowerCase();
        }

        if (cbImplicit.isChecked()){
            answer3 += cbImplicit.getText().toString().toLowerCase();
        }

        if (!cbImplicit.isChecked() && !cbExplicit.isChecked() && !cbActivity.isChecked()){
            valid = true;
        }

        answer4 = spAnswer4.getSelectedItem().toString().toLowerCase();

        if (valid){
            Toast.makeText(getApplicationContext(), R.string.answer_is_empty, Toast.LENGTH_SHORT).show();
        }else {
            resultTest(answer1, answer2, answer3, answer4, answer5);
        }
    }
    private void resultTest(String answer1, String answer2, String answer3, String answer4, String answer5){
        int point = 0;

        if (answer1.equals("activity")){
            point += 20;
        }

        if (answer2.equals("bundle")){
            point += 20;
        }

        if (answer3.equals("implicit intentexplicit intent") || answer3.equals("explicit intentimplicit intent")){
            point += 20;
        }

        if (answer4.equals("button")){
            point += 20;
        }

        if (answer5.equals("viewgroup")){
            point += 20;
        }

        Intent result = new Intent(getApplicationContext(), ResultActivity.class);
        result.putExtra(ResultActivity.POINT, String.valueOf(point));
        startActivity(result);
        finish();
    }
}
