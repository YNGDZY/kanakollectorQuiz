package com.example.deezy.quizredux;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static android.R.attr.button;
import static android.R.attr.onClick;
import static android.os.Build.VERSION_CODES.M;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button start = (Button) findViewById(R.id.start_button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Q1Intent = new Intent(TestActivity.this, QuestionOneActivity.class);
                startActivity(Q1Intent);
            }
        });
    }
}
