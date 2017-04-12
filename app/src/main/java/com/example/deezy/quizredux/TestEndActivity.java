package com.example.deezy.quizredux;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;
import static android.os.Build.VERSION_CODES.N;

public class TestEndActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test_end);



        int score = getIntent().getIntExtra("SCORE",-1);




        TextView scoreText = (TextView) findViewById(R.id.score_text);

        scoreText.setText(String.valueOf(score));

        Button retry = (Button) findViewById(R.id.retry_button);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retryIntent = new Intent(TestEndActivity.this, TestActivity.class);
                startActivity(retryIntent);
            }
        });
    }
}
