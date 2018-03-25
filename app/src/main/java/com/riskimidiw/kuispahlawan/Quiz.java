package com.riskimidiw.kuispahlawan;

import java.util.ArrayList;

public class Quiz {
    private ArrayList<Soal> quizList= new ArrayList<>();

    /**
     *
     * @param quiz
     * @param answer
     * @param optA
     * @param optB
     * @param optC
     * @param optD
     *
     * add quizPahlawan to ArrayList of Soal
     */
    public void addQuiz(String quiz, String answer, String optA, String optB, String optC, String optD) {
        Soal soal = new Soal();

        soal.setQuiz(quiz);
        soal.setAnswer(answer);
        soal.setOptA(optA);
        soal.setOptB(optB);
        soal.setOptC(optC);
        soal.setOptD(optD);

        quizList.add(soal);
    }

    /**
     *
     * @param indek
     * @return Soal
     */
    public Soal getSoal(int indek) {
        return quizList.get(indek);
    }

    /**
     *
     * @return ArrayList<Soal>
     */
    public ArrayList<Soal> getQuizList() {
        return quizList;
    }

    class Soal {
        private String quiz, answer, optA, optB, optC, optD;

        public String getQuiz() {
            return quiz;
        }

        public void setQuiz(String quiz) {
            this.quiz = quiz;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getOptA() {
            return optA;
        }

        public void setOptA(String optA) {
            this.optA = optA;
        }

        public String getOptB() {
            return optB;
        }

        public void setOptB(String optB) {
            this.optB = optB;
        }

        public String getOptC() {
            return optC;
        }

        public void setOptC(String optC) {
            this.optC = optC;
        }

        public String getOptD() {
            return optD;
        }

        public void setOptD(String optD) {
            this.optD = optD;
        }

        /**
         *
         * @return String
         * get String answer value
         */
        public String getStringAnswer() {
            switch (getAnswer()) {
                case "A" :
                    return getOptA();
                case "B" :
                    return getOptB();
                case "C" :
                    return getOptC();
                case "D" :
                    return getOptD();
            }

            return null;
        }
    }
}
