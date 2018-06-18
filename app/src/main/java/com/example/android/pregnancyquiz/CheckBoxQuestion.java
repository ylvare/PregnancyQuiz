package com.example.android.pregnancyquiz;

public class CheckBoxQuestion {

    String question;
    Boolean [] answers_entered;
    Boolean [] correct_answers;
    String option_a;
    String option_b;
    String option_c;
    String option_d;
    int photoId;

    CheckBoxQuestion(String question, Boolean answers_entered[], Boolean correct_answers[], String option_a, String option_b, String option_c, String option_d, int photoId) {
        this.question = question;
        this.answers_entered = answers_entered;
        this.correct_answers = correct_answers;
        this.option_a=option_a;
        this.option_b=option_b;
        this.option_c=option_c;
        this.option_d=option_d;
        this.photoId= photoId;
    }
}