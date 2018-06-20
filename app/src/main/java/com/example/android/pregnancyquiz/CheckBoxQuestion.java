package com.example.android.pregnancyquiz;

public class CheckBoxQuestion {

    String question;
    Boolean[] answersEntered;
    Boolean[] correctAnswers;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    int photoId;

    CheckBoxQuestion(String question, Boolean answersEntered[], Boolean correctAnswers[], String optionA, String optionB, String optionC, String optionD, int photoId) {
        this.question = question;
        this.answersEntered = answersEntered;
        this.correctAnswers = correctAnswers;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.photoId= photoId;
    }
}