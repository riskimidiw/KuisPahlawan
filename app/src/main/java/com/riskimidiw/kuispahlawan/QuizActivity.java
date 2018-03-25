package com.riskimidiw.kuispahlawan;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    TextView quizTextView, numberTextView, btnNextTextView;
    LinearLayout btnNext, btnPrev, btnHint;
    ImageView imgHint1, imgHint2, imgHint3;
    RadioButton rdbA, rdbB, rdbC, rdbD;
    RadioGroup rdgAnswer;
    static Quiz quizPahlawan;
    int indekValue, benarValue, salahValue, kosongValue, hintValue = 3;
    String[] listJawaban;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        listJawaban = new String[10];

        quizTextView = (TextView) findViewById(R.id.quiz);
        numberTextView = (TextView) findViewById(R.id.action_number);
        btnNextTextView = (TextView) findViewById(R.id.btn_next_txt);
        btnNext = (LinearLayout) findViewById(R.id.btn_next);
        btnPrev = (LinearLayout) findViewById(R.id.btn_prev);
        btnHint = (LinearLayout) findViewById(R.id.hint);
        rdbA = (RadioButton) findViewById(R.id.rdb_a);
        rdbB = (RadioButton) findViewById(R.id.rdb_b);
        rdbC = (RadioButton) findViewById(R.id.rdb_c);
        rdbD = (RadioButton) findViewById(R.id.rdb_d);
        rdgAnswer = (RadioGroup) findViewById(R.id.rdg_answer);
        imgHint1 = (ImageView) findViewById(R.id.hint1);
        imgHint2 = (ImageView) findViewById(R.id.hint2);
        imgHint3 = (ImageView) findViewById(R.id.hint3);

        // Add Quiz Data
        quizPahlawan = new Quiz();
        quizPahlawan.addQuiz("\" Kurang pandai dapat diperbaiki dengan belajar. Kurang cakap" +
                         " dapat diperbaiki dengan pengalaman. Namun tidak jujur itu sulit diperbaiki. \"",
                 "A", "Moh Hatta", "Soekarno" , "Jenderal Sudirman",
                 "Moh Yamin");

        quizPahlawan.addQuiz("\" Kemerdekan nasional bukan pencapaian akhir, tapi rakyat bebas" +
                         " berkarya adalah puncaknya. \"",
                 "B", "Soekarno", "Sutan Syahrir", "R.A. Kartini",
                 "Bung Tomo");

        quizPahlawan.addQuiz("\" Memimpin adalah menderita. \"", "C", "Soekarno",
                "Jenderal Soedirman", "KH Agus Salim", "Ki Hadjar Dewantara");

        quizPahlawan.addQuiz("\"  Dalam menghadapi musuh, tak ada yang lebih mengena daripada " +
                "senjata kasih sayang. \"", "C", "R.A. Kartini", "Pangeran Diponegoro",
                "Cut Nyak Dien", "Kapitan Pattimura");

        quizPahlawan.addQuiz("\" Robek-robeklah badanku, potong-potonglah jasad ini, tetapi " +
                "jiwaku dilindungi benteng merah putih. akan tetap hidup, tetap menuntut bela, " +
                "siapapun lawan yang aku hadapi. \"", "C", "Kapitan Pattimura",
                "Pangeran Diponegoro", "Jenderal Sudirman", "Bung Tomo");

        quizPahlawan.addQuiz("\" Lawan sastra ngesti mulya (dengan ilmu kita menuju kemuliaan). \"",
                "D", "KH Agus Salim", "Jendral Sudirman", "R.A. Kartini",
                "Ki Hadjar Dewantara");

        quizPahlawan.addQuiz("\" Bangsa yang besar adalah bangsa yang menghormati jasa pahlawannya. \"",
                "A", "Soekarno", "Jenderal Sudirman", "Moh Hatta",
                "Supomo");

        quizPahlawan.addQuiz("\" MERDEKA atau MATI \"", "A", "Bung Tomo", "Soekarno",
                "Jenderal Sudirman", "Moh Yamin");

        quizPahlawan.addQuiz("\" Kita yang berjuang jangan sekali-kali mengharapkan pangkat," +
                " kedudukan, ataupun gaji yang tinggi. \"", "B", "Abdul Muis",
                "Supriadi", "Jenderal Sudirman", "Bung Tomo");

        quizPahlawan.addQuiz("\" Berikan aku 1000 orang tua, niscaya akan kucabut semeru dari akarnya," +
                " berikan aku 1 pemuda, niscaya akan kuguncangkan dunia. \"", "C",
                "Moh Hatta", "Bung Tomo", "Soekarno", "Jenderal Soedirman");

        // Set initial quizPahlawan view
        setView(quizPahlawan, 0);
        quizTextView.setBackgroundColor(Color.BLUE);

        btnNext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                switch (rdgAnswer.getCheckedRadioButtonId()) {
                    case R.id.rdb_a:
                        listJawaban[indekValue] = "A";
                        break;
                    case R.id.rdb_b:
                        listJawaban[indekValue] = "B";
                        break;
                    case R.id.rdb_c:
                        listJawaban[indekValue] = "C";
                        break;
                    case R.id.rdb_d:
                        listJawaban[indekValue] = "D";
                        break;
                }

                indekValue++;

                // Finish
                if(indekValue > 9) {
                    indekValue = 9;
                    calculateAnswer();

                    Intent i = new Intent(v.getContext(), ScoreActivity.class);
                    i.putExtra("BENAR", benarValue);
                    i.putExtra("SALAH", salahValue);
                    i.putExtra("KOSONG", kosongValue);
                    i.putExtra("LIST_JAWABAN", listJawaban);

                    startActivity(i);
                    finish();

                }

                // Smart checked radio button, remember what you checked before on radio button
                if(listJawaban[indekValue] != null) {
                    rdgAnswer.check(getCheckedButton(listJawaban[indekValue]));
                }else {
                    rdgAnswer.clearCheck();
                }

                // change text button while almost finish
                if(indekValue == 9) {
                    btnNextTextView.setText("SELESAI");
                }

                // Set quizPahlawan view
                setView(quizPahlawan, indekValue);
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (rdgAnswer.getCheckedRadioButtonId()) {
                    case R.id.rdb_a:
                        listJawaban[indekValue] = "A";
                        break;
                    case R.id.rdb_b:
                        listJawaban[indekValue] = "B";
                        break;
                    case R.id.rdb_c:
                        listJawaban[indekValue] = "C";
                        break;
                    case R.id.rdb_d:
                        listJawaban[indekValue] = "D";
                        break;
                }

                indekValue--;

                // make user can't back when the quizPahlawan number is one
                if(indekValue < 0) {
                    indekValue = 0;
                    Toast.makeText(v.getContext(), "Oops! tidak bisa kembali", Toast.LENGTH_SHORT).show();
                }

                // Smart checked radio button, remember what you checked before on radio button
                if(listJawaban[indekValue] != null) {
                    rdgAnswer.check(getCheckedButton(listJawaban[indekValue]));
                }else {
                    rdgAnswer.clearCheck();
                }

                // make default next button text
                if(indekValue < 9) {
                    btnNextTextView.setText("NEXT");
                }

                // Set quizPahlawan view
                setView(quizPahlawan, indekValue);

            }
        });

        btnHint.setOnClickListener(new View.OnClickListener() {

            @Override

            // make hint decrease and hint image gone when clicked
            public void onClick(View v) {

                if(hintValue > 0) {
                    hintValue--;
                    Toast.makeText(v.getContext(), "Jawaban " + quizPahlawan.getSoal(indekValue).getAnswer()
                            , Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(v.getContext(), "Oops, Hint habis", Toast.LENGTH_SHORT).show();
                }

                switch (hintValue) {
                    case 2:
                        imgHint3.setVisibility(View.GONE);
                        break;
                    case 1:
                        imgHint2.setVisibility(View.GONE);
                        break;
                    case 0:
                        imgHint1.setVisibility(View.GONE);
                        break;

                }
            }
        });
    }

    /**
     *
     * @param quiz
     * @param indek
     */
    private void setView(Quiz quiz, int indek) {
        Quiz.Soal soal = quiz.getSoal(indek);

        quizTextView.setText(soal.getQuiz());
        numberTextView.setText((indek+1) + " / 10");
        rdbA.setText("A.  " + soal.getOptA());
        rdbB.setText("B.  " + soal.getOptB());
        rdbC.setText("C.  " + soal.getOptC());
        rdbD.setText("D.  " + soal.getOptD());

        switch (indek) {
            case 0:
                quizTextView.setBackgroundColor(Color.BLUE);
                break;
            case 1:
                quizTextView.setBackgroundColor(Color.GRAY);
                break;
            case 2:
                quizTextView.setBackgroundColor(Color.RED);
                break;
            case 3:
                quizTextView.setBackgroundColor(Color.MAGENTA);
                break;
            case 4:
                quizTextView.setBackgroundColor(Color.DKGRAY);
                break;
            case 5:
                quizTextView.setBackgroundColor(Color.BLUE);
                break;
            case 6:
                quizTextView.setBackgroundColor(Color.BLACK);
                break;
            case 7:
                quizTextView.setBackgroundColor(Color.RED);
                break;
            case 8:
                quizTextView.setBackgroundColor(Color.BLUE);
                break;
            case 9:
                quizTextView.setBackgroundColor(Color.DKGRAY);
                break;
        }
    }

    /**
     *
     * @param jawaban
     * @return
     */
    private int getCheckedButton(String jawaban) {

        if(jawaban.equals("A")) {
            return R.id.rdb_a;
        }else if(jawaban.equals("B")) {
            return R.id.rdb_b;
        }else if(jawaban.equals("C")) {
            return R.id.rdb_c;
        }else if(jawaban.equals("D")) {
            return R.id.rdb_d;
        }

        return 0;
    }

    private void calculateAnswer() {
        for(int i=0; i<listJawaban.length; i++) {
            if(listJawaban[i] == null) {
                kosongValue++;
            } else if(listJawaban[i].equals(quizPahlawan.getSoal(i).getAnswer())) {
                benarValue++;
            }else {
                salahValue++;
            }
        }
    }

    /**
     *
     * @return Quiz
     */
    public static Quiz getQuiz() {
        return quizPahlawan;
    }

}
