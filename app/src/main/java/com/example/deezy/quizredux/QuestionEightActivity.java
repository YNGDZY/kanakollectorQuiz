package com.example.deezy.quizredux;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import static android.R.attr.button;


public class QuestionEightActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_question_checkbox);
        Button next = (Button) findViewById(R.id.Q_Button);

        TextView Title = (TextView) findViewById(R.id.Q_title);
        Title.setText(R.string.title_8);

        ImageView Image = (ImageView) findViewById(R.id.Q_Image);
        Image.setImageResource(R.drawable.i_hirigana_he);

        TextView Question = (TextView) findViewById(R.id.Q_Text);
        Question.setText(R.string.question_8);

        CheckBox CB1 = (CheckBox) findViewById(R.id.Q_Checkbox_1);
        CB1.setText("He");
        CheckBox CB2 = (CheckBox) findViewById(R.id.Q_Checkbox_2);
        CB2.setText("Katakana");
        CheckBox CB3 = (CheckBox) findViewById(R.id.Q_Checkbox_3);
        CB3.setText("Hirigana");
        CheckBox CB4 = (CheckBox) findViewById(R.id.Q_Checkbox_4);
        CB4.setText("Ta");

    }
    public void nextButton(View view){
        int score = getIntent().getIntExtra("SCORE",0);

        CheckBox CB1 = (CheckBox) findViewById(R.id.Q_Checkbox_1);
        CheckBox CB2 = (CheckBox) findViewById(R.id.Q_Checkbox_2);
        CheckBox CB3 = (CheckBox) findViewById(R.id.Q_Checkbox_3);
        CheckBox CB4 = (CheckBox) findViewById(R.id.Q_Checkbox_4);

        Boolean QA1 = CB1.isChecked();
        Boolean QA2 = CB2.isChecked();
        Boolean QA3 = CB3.isChecked();
        Boolean QA4 = CB4.isChecked();

        if(QA1 && !QA2 && QA3 && !QA4){
            score = score + 1;
        }

        Intent NQIntent = new Intent(QuestionEightActivity.this, QuestionNineActivity.class);
        NQIntent.putExtra("SCORE",score);
        startActivity(NQIntent);

    }
}
