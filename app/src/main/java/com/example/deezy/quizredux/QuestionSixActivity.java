package com.example.deezy.quizredux;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import static android.R.attr.button;


public class QuestionSixActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_question_entertext);
        Button next = (Button) findViewById(R.id.Q_Button);

        TextView Title = (TextView) findViewById(R.id.Q_title);
        Title.setText(R.string.title_6);

        ImageView Image = (ImageView) findViewById(R.id.Q_Image);
        Image.setImageResource(R.drawable.i_katakana_tsu);

        TextView Question = (TextView) findViewById(R.id.Q_Text);
        Question.setText(R.string.question_6);













    }
    public void nextButton(View view){
        int score = getIntent().getIntExtra("SCORE",0);

        EditText editText = (EditText) findViewById(R.id.Q_EditText);
        CharSequence answer = "tsu";
        CharSequence answer2 = "Tsu";

        CharSequence user = editText.getText();

        Boolean QA = false;

        if(answer == user){
            QA = true;
        }else if(answer2 == user){
            QA = true;
        }

        if(QA){
            score = score +1;
        }

        Intent NQIntent = new Intent(QuestionSixActivity.this, QuestionSevenActivity.class);
        NQIntent.putExtra("SCORE",score);
        startActivity(NQIntent);

    }
}
