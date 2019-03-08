package com.ctech.amir.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPreviousButton;
    private TextView mQuestionTextView;

    private Question [] mQuestionBank = new Question[] {

        new Question(R.string.question_australia, true),
        new Question(R.string.question_oceans, true),
        new Question(R.string.question_mideast, true ),
        new Question(R.string.question_africa, true),
        new Question(R.string.question_america, true),
        new Question(R.string.question_asia, true ),
    };

    private int mCurrentIndex = 0;
    private void checkAnswer (boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank [mCurrentIndex].isAnswerTrue();
        int messageResourceId = 0;
        if (userPressedTrue == answerIsTrue){
        messageResourceId = R.string.correct_toast;
        } else {
            messageResourceId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResourceId, Toast.LENGTH_SHORT).show();
    }



    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a refrence to the Question Text view and set its text to the question on the current index
        mQuestionTextView = findViewById(R.id.question_text_view);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton  = (Button) findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button );
        mPreviousButton = (Button) findViewById(R.id.previous_button);


        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               checkAnswer(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                }
            });

        mPreviousButton = findViewById(R.id.previous_button);
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                int newQuestionResourceId = mQuestionBank[mCurrentIndex].getTextRedId();
                mQuestionTextView.setText(newQuestionResourceId);
                updateQuestion();
                if (mCurrentIndex == -1){
                    (mCurrentIndex + 1);
            }else{ (mCurrentIndex == 0);

                }

            }
        });


        mNextButton = findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                int newQuestionResourceId = mQuestionBank [mCurrentIndex].getTextRedId();
                mQuestionTextView.setText(newQuestionResourceId);
                updateQuestion();

            }
        });

        updateQuestion();
    }

    //updateQuestion capsolation
    private void updateQuestion () {
        int questionResourceId = mQuestionBank[mCurrentIndex].getTextRedId();
        mQuestionTextView.setText(questionResourceId);
    }




}
