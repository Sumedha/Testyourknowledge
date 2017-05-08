package com.example.android.testyouritknowledge;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    RadioButton q1_r4;
    EditText q2_answer;
    CheckBox q3_c1;
    CheckBox q3_c2;
    CheckBox q3_c3;
    CheckBox q3_c4;
    EditText q4_answer;
    RadioButton q5_r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        CharSequence resultsDisplay;
        Log.e(LOG_TAG, " " + this.findViewById(R.id.btnDisplay));
        int answer1_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;
        int final_score;

        Boolean answer1;

        q1_r4 = (RadioButton) this.findViewById(R.id.q1_r4);
        answer1 = q1_r4.isChecked();
        if (answer1) {
            answer1_score = 1;
        } else {
            answer1_score = 0;
        }

        String answer2;
        q2_answer = (EditText) this.findViewById(R.id.q2_answer);
        answer2 = q2_answer.getText().toString();
        if (answer2.equalsIgnoreCase("ascii")) {
            answer2_score = 1;
        } else {
            answer2_score = 0;
        }

        Boolean answer3_choice1;
        Boolean answer3_choice2;
        Boolean answer3_choice3;
        Boolean answer3_choice4;
        q3_c1 = (CheckBox) this.findViewById(R.id.q3_c1);
        q3_c2 = (CheckBox) this.findViewById(R.id.q3_c2);
        q3_c3 = (CheckBox) this.findViewById(R.id.q3_c3);
        q3_c4 = (CheckBox) this.findViewById(R.id.q3_c4);
        answer3_choice1 = q3_c1.isChecked();
        answer3_choice2 = q3_c2.isChecked();
        answer3_choice3 = q3_c3.isChecked();
        answer3_choice4 = q3_c4.isChecked();
        if (answer3_choice1 && answer3_choice2 && !answer3_choice3 && answer3_choice4) {
            answer3_score = 1;
        } else {
            answer3_score = 0;
        }

        String answer4;
        q4_answer = (EditText) this.findViewById(R.id.q4_answer);
        answer4 = q4_answer.getText().toString();
        if (answer4.equalsIgnoreCase("Seoul")) {
            answer4_score = 1;
        } else {
            answer4_score = 0;
        }

        Boolean answer5;

        q5_r2 = (RadioButton) this.findViewById(R.id.q5_r2);
        answer5 = q5_r2.isChecked();
        if (answer5) {
            answer5_score = 1;
        } else {
            answer5_score = 0;
        }
        final_score = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score;

        if (final_score == 5) {
            resultsDisplay = "Perfect! You scored 5 out of 5";
        } else {
            resultsDisplay = "Try again. You scored " + final_score + " out of 5";
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultsDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}

