package com.boucetta.quizmathactivity;

import java.util.Random;

public class Question {
    private int firstNumber;
    private int secondNumber;
    private int answer;
    private int [] answerArray;
    private int answerPosition;
    private int upperLimit;
    private String questionPhrase;

    public Question(int upperLimit) {
        this.upperLimit = upperLimit;
        Random randomNumberMarker = new Random();
        this.firstNumber = randomNumberMarker.nextInt(upperLimit);
        this.secondNumber = randomNumberMarker.nextInt(upperLimit);
        this.answer = this.firstNumber + this.secondNumber;
        this.questionPhrase = this.firstNumber + "+" + this.secondNumber + "=";
        this.answerPosition = randomNumberMarker.nextInt(4);
        this.answerArray = new int[] {0,1,2,3};
        this.answerArray[0] = this.answer + 1;
        this.answerArray[1] = this.answer + 10;
        this.answerArray[2] = this.answer -5;
        this.answerArray[3] = this.answer -2;
        this.answerArray = shuffleArray(this.answerArray);
        this.answerArray[this.answerPosition] = this.answer;

    }

    private int [] shuffleArray(int[] array) {
        int index, temp;
        Random randomNumberGenerator = new Random();
        for (int i = array.length - 1; i > 0; i-- ) {
            index = randomNumberGenerator.nextInt(i+1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;

        }

        return array;
    }






    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public int getAnswer() {
        return answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }
}
