package com.example.learnengish_android.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnengish_android.R;

public class QuestionActivity extends AppCompatActivity {
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
//        continueButton = findViewById(R.id.buttonContinue);
//        continueButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               openResultActivity();
//            }
//        });
    }

    public void openResultActivity(){
        Intent intent = new Intent(QuestionActivity.this, Result_Activity.class);
        startActivity(intent);
    }

}
