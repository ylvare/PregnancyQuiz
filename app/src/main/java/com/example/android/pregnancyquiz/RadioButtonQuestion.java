package com.example.android.pregnancyquiz;

public class RadioButtonQuestion {

    String question;
    String answerEntered;
    String correctAnswer;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    int photoId;

    RadioButtonQuestion(String question, String answerEntered, String correctAnswer, String optionA, String optionB, String optionC, String optionD, int photoId) {
            this.question = question;
        this.answerEntered = answerEntered;
        this.correctAnswer = correctAnswer;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
            this.photoId= photoId;
        }
    }
