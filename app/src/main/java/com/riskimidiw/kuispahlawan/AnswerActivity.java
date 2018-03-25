package com.riskimidiw.kuispahlawan;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    LinearLayout rootView, descriptionView;
    TextView numberTextView, answerTextView, soalTextView;
    String[] listJawaban;
    Quiz quizPahlawan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        listJawaban = getIntent().getStringArrayExtra("LIST_JAWABAN");
        quizPahlawan = QuizActivity.getQuiz();

        rootView = findViewById(R.id.root_view);

        for(int i=0; i<10; i++) {
            // add LinearLayout for rootview of number and checked answer
            descriptionView = new LinearLayout(this);
            descriptionView.setPadding(16,16,16,16);

            // add TextView for number
            numberTextView = new TextView(this);
            numberTextView.setText("NO : " + (i+1) + "       ");

            // add answer TextView, show what your answer before
            answerTextView = new TextView(this);
            if(getAnswerValue(i)!= null) {
                answerTextView.setText("Jawaban Kamu : " + getAnswerValue(i));
            }else {
                answerTextView.setText("Jawaban Kamu : -");
            }

            // add quiz TextView that show quiz quote
            soalTextView = new TextView(this);
            soalTextView.setPadding(16, 16, 16, 16);

            // make backround red if false and green if true
            if(listJawaban[i] == null) {
                soalTextView.setBackgroundColor(Color.RED);
            } else if(listJawaban[i].equals(quizPahlawan.getSoal(i).getAnswer())) {
                soalTextView.setBackgroundColor(Color.parseColor("#15d211"));
            }else {
                soalTextView.setBackgroundColor(Color.RED);
            }

            soalTextView.setTextColor(Color.WHITE);
            soalTextView.setText(quizPahlawan.getSoal(i).getQuiz() + "\n\n- " + quizPahlawan.getSoal(i).getStringAnswer()+ " -");

            descriptionView.addView(numberTextView);
            descriptionView.addView(answerTextView);
            rootView.addView(descriptionView);
            rootView.addView(soalTextView);
        }

    }

    /**
     *
     * @param i
     * @return String
     */
    private String getAnswerValue(int i) {
        String soalTmp = "";

        if(listJawaban[i] == null) {
            soalTmp = null;
        } else if (listJawaban[i].equals("A")) {
            soalTmp = quizPahlawan.getSoal(i).getOptA();
        } else if(listJawaban[i].equals("B")) {
            soalTmp = quizPahlawan.getSoal(i).getOptB();
        } else if(listJawaban[i].equals("C")) {
            soalTmp = quizPahlawan.getSoal(i).getOptC();
        } else if(listJawaban[i].equals("D")) {
            soalTmp = quizPahlawan.getSoal(i).getOptD();
        }

        return soalTmp;
    }
}
