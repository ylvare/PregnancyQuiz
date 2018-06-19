package com.example.android.pregnancyquiz;

public class RadioButtonQuestion {

    String question;
    String answer_entered;
    String correct_answer;
    String option_a;
    String option_b;
    String option_c;
    String option_d;
    int photoId;

    RadioButtonQuestion(String question, String answer_entered, String correct_answer, String option_a, String option_b, String option_c, String option_d, int photoId) {
            this.question = question;
            this.answer_entered = answer_entered;
            this.correct_answer = correct_answer;
            this.option_a=option_a;
            this.option_b=option_b;
            this.option_c=option_c;
            this.option_d=option_d;
            this.photoId= photoId;
        }
    }
