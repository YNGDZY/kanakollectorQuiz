package com.example.deezy.quizredux;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;
import static com.example.deezy.quizredux.R.id.feedbackSubmit;

public class FeedbackActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        setTitle(R.string.feedback_header);

        TextView enterText = (TextView) findViewById(R.id.editText);
        final CharSequence userFeedback = enterText.getText();



        Button feedbackSubmit = (Button) findViewById(R.id.feedbackSubmit);


        feedbackSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent feedbackEmail = new Intent(Intent.ACTION_SENDTO);
                feedbackEmail.setData(Uri.parse("mailto:"));
                feedbackEmail.putExtra(Intent.EXTRA_EMAIL, "DeanLCarroll94@gmail.com");
                feedbackEmail.putExtra(Intent.EXTRA_SUBJECT,"Feedback!");
                feedbackEmail.putExtra(Intent.EXTRA_TEXT,userFeedback);
                if (feedbackEmail.resolveActivity(getPackageManager()) != null) {
                    startActivity(feedbackEmail);
                }

            }
        });
    }
}
