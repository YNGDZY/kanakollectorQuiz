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
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import static android.R.attr.button;


public class QuestionTwoActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_question);
        Button next = (Button) findViewById(R.id.Q_Button);

        TextView Title = (TextView) findViewById(R.id.Q_title);
        Title.setText(R.string.title_2);

        ImageView Image = (ImageView) findViewById(R.id.Q_Image);
        Image.setImageResource(R.drawable.i_hirigana_ku);

        TextView Question = (TextView) findViewById(R.id.Q_Text);
        Question.setText(R.string.question_1);
        RadioButton RB1 = (RadioButton) findViewById(R.id.Q_Radio_Button_1);
        RB1.setText("Hi");
        RadioButton RB2 = (RadioButton) findViewById(R.id.Q_Radio_Button_2);
        RB2.setText("Tsu");
        RadioButton RB3 = (RadioButton) findViewById(R.id.Q_Radio_Button_3);
        RB3.setText("Ga");
        RadioButton RB4 = (RadioButton) findViewById(R.id.Q_Radio_Button_4);
        RB4.setText("Ku");













    }
    public void nextButton(View view){
        int score = getIntent().getIntExtra("SCORE",0);

        RadioButton RB4 = (RadioButton) findViewById(R.id.Q_Radio_Button_4);
        Boolean QA = RB4.isChecked();

        if(QA){
            score = score + 1;
        }





        Intent NQIntent = new Intent(QuestionTwoActivity.this, QuestionThreeActivity.class);
        NQIntent.putExtra("SCORE",score);
        startActivity(NQIntent);

    }


}
