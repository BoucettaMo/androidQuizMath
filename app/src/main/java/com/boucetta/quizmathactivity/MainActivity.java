package com.boucetta.quizmathactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_start,btn_answer0, btn_answer1,btn_answer2,btn_answer3;
    TextView tv_timer, tv_question, tv_score, tv_bottom;
    ProgressBar progressBar;
    int level = 5;
    Game g = new Game(level);
    int secondRemaining=30;
    CountDownTimer timer = new CountDownTimer(30000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
         secondRemaining--;
         tv_timer.setText(Integer.toString(secondRemaining)+"sc");
         progressBar.setProgress(30-secondRemaining);
        }

        @Override
        public void onFinish() {
            btn_answer0.setEnabled(false);
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);
            tv_bottom.setText("Times is up:"+" "+ g.getNumberCorrect()+"/"+ (g.getTotalQuestions()-1));

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_start.setVisibility(View.VISIBLE);
                    progressBar.setProgress(0);
                    secondRemaining = 30;
                }
            }, 4000);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = findViewById(R.id.btnstart);
        btn_answer0 = findViewById(R.id.btn_answer0);
        btn_answer1 = findViewById(R.id.btn_answer1);
        btn_answer2 = findViewById(R.id.btn_answer2);
        btn_answer3 = findViewById(R.id.btn_answer3);
        tv_timer = findViewById(R.id.timer);
        tv_question = findViewById(R.id.operation);
        tv_score = findViewById(R.id.score);
        tv_bottom = findViewById(R.id.bottomTextView);
        progressBar = findViewById(R.id.progressBar);
        tv_timer.setText("0sec");
        tv_question.setText("");
        tv_bottom.setText("Press Go");
        tv_score.setText("0pts");

        View.OnClickListener btnStartClickListener =  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);

                progressBar.setProgress(0);
                secondRemaining = 30;
                g = new Game(level);
                btn_answer0.setEnabled(true);
                btn_answer1.setEnabled(true);
                btn_answer2.setEnabled(true);
                btn_answer3.setEnabled(true);

                nextTurn();
                timer.start();
            }

            
        };

        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked = (Button) v;
                int answerSelected = Integer.parseInt(buttonClicked.getText().toString());
                g.checkAnswer(answerSelected);
                tv_score.setText(Integer.toString(g.getScore())+"pts");
                nextTurn();
            }
        };

        btn_start.setOnClickListener(btnStartClickListener);
        btn_answer0.setOnClickListener(answerButtonClickListener);
        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);

    }

     @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.level_activity,menu);
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item ) {
        int id = item.getItemId();

        if (id == R.id.easy ) {
            level = 5;
        }
        if (id == R.id.mean ) {
            level = 50;
        }
        if (id == R.id.difficult ) {
            level = 500;
        }



     return true;
    }

    private void nextTurn() {

        g.makeNewQuestion();
       int[] answers= g.getCurrentQuestion().getAnswerArray();
        btn_answer0.setText(Integer.toString(answers[0]));
        btn_answer1.setText(Integer.toString(answers[1]));
        btn_answer2.setText(Integer.toString(answers[2]));
        btn_answer3.setText(Integer.toString(answers[3]));
        tv_question.setText(g.getCurrentQuestion().getQuestionPhrase());
        tv_bottom.setText(g.getNumberCorrect() + "/" + (g.getTotalQuestions()-1) );
    }
}