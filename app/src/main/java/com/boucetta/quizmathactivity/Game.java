package com.boucetta.quizmathactivity;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private ArrayList<Question> questions = new ArrayList<>();
    private int numberCorrect;
    private int numberIncorrect;
    private int totalQuestions;
    private int score;
    private Question currentQuestion;
    private int level;

    public Game(int level) {
        this.numberCorrect = 0;
       this.numberIncorrect = 0;
        this.totalQuestions = 0;
        this.score = 0;
        this.currentQuestion = new Question(100);
        this.level = level;

    }

    public   void makeNewQuestion() {
        currentQuestion = new Question(2 * totalQuestions + level);
        totalQuestions++;
        questions.add(currentQuestion);

    }


    public boolean checkAnswer(int submittedAnswer) {
        boolean isCorrect;
        if (currentQuestion.getAnswer() == submittedAnswer) {
            numberCorrect++;
            isCorrect = true;
        } else {
            numberIncorrect++;
            isCorrect = false;
        }
        score = numberCorrect * 10 - numberIncorrect * 30;

        return isCorrect;
    }



    public int getLevel() {
        return level;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public void setNumberIncorrect(int numberIncorrect) {
        this.numberIncorrect = numberIncorrect;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public int getNumberIncorrect() {
        return numberIncorrect;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getScore() {
        return score;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

}
