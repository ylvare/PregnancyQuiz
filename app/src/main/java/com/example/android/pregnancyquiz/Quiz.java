package com.example.android.pregnancyquiz;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Quiz extends Activity {

    private List<Object> questions;
    private RecyclerView rv;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    public String getName() {
        String name = ((EditText) findViewById(R.id.name)).getText().toString();
        return name;
    }

    public class Footer {
        Footer() {
        }
    }

    private void initializeData() {
        questions = new ArrayList<>();

        Boolean[] emptyAnswers1 = {Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE};
        Boolean[] emptyAnswers2 = {Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE};
        Boolean[] correctAnswer1 = {Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE};
        Boolean[] correctAnswer2 = {Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE};

        questions.add(new RadioButtonQuestion("How many beats per minute does the heart of an embryo beat when the embryo is eight weeks old?", "", "A", "150", "200", "250", "300", R.drawable.baby));
        questions.add(new RadioButtonQuestion("In what week does the tale of the embryo disappear?", "", "B", "5 weeks", "9 weeks", "12 weeks", "14 weeks", R.drawable.baby));
        questions.add(new CheckBoxQuestion("What parts of the baby body develops faster than the legs and feets?", emptyAnswers1, correctAnswer1, "hands", "arms", "chest", "hips", R.drawable.baby));
        questions.add(new RadioButtonQuestion("At what week does the child-to-be transform from being an embryo to a foetus in medical terms?", "", "B", "6 weeks", "11 weeks", "15 weeks", "19 weeks", R.drawable.baby));
        questions.add(new RadioButtonQuestion("At what week can the baby in the uterus hear the outside world?", "", "D", "4 weeks", "12 weeks", "16 weeks", "18 weeks", R.drawable.baby));
        questions.add(new CheckBoxQuestion("What happens typically in week 12 of the foetus development?", emptyAnswers2, correctAnswer2, "The baby can swallow", "The baby urinates for the first time", "The baby can clench his fist", "The baby can hickup", R.drawable.baby));
        questions.add(new Footer());

    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(questions);
        rv.setAdapter(adapter);
    }


    public void answerRadioButton(View view) {
        RadioButtonQuestion rbq = (RadioButtonQuestion) questions.get((int) view.getTag());

        if (view.getId() == R.id.option_a) {
            rbq.answer_entered = "A";
        } else if (view.getId() == R.id.option_b) {
            rbq.answer_entered = "B";
        }
        if (view.getId() == R.id.option_c) {
            rbq.answer_entered = "C";
        } else if (view.getId() == R.id.option_d) {
            rbq.answer_entered = "D";
        }
    }

    public void answerCheckBox(View view) {
        CheckBoxQuestion cbq = (CheckBoxQuestion) questions.get((int) view.getTag());
        boolean checked = ((CheckBox) view).isChecked();

        if (view.getId() == R.id.option_a) {
            if (checked) {
                cbq.answers_entered[0] = Boolean.TRUE;
            } else {
                cbq.answers_entered[0] = Boolean.FALSE;
            }
        }

        if (view.getId() == R.id.option_b) {
            if (checked) {
                cbq.answers_entered[1] = Boolean.TRUE;
            } else {
                cbq.answers_entered[1] = Boolean.FALSE;
            }
        }

        if (view.getId() == R.id.option_c) {
            if (checked) {
                cbq.answers_entered[2] = Boolean.TRUE;
            } else {
                cbq.answers_entered[2] = Boolean.FALSE;
            }
        }

        if (view.getId() == R.id.option_d) {
            if (checked) {
                cbq.answers_entered[3] = Boolean.TRUE;
            } else {
                cbq.answers_entered[3] = Boolean.FALSE;
            }
        }
    }

    public void calculateScore(View view) {
        score = 0;

        for (Object question : questions) {
            if (question instanceof RadioButtonQuestion) {
                if (((RadioButtonQuestion) question).answer_entered.equals (((RadioButtonQuestion) question).correct_answer)){
                    score = score+1;
                }
            }

            if (question instanceof CheckBoxQuestion) {

                Boolean [] answers_entered = ((CheckBoxQuestion) question).answers_entered;
                Boolean [] correct_answers = ((CheckBoxQuestion) question).correct_answers;
                if(Arrays.equals(answers_entered,correct_answers)){
                    score = score+1;
                }
            }

        }

        toast();
    }

    private void toast(){
        Context context = getApplicationContext();
        int nrQuestions = questions.size()-1;
        String name = ((EditText) findViewById(R.id.name)).getText().toString();
        String text =  name + " , you got " + score + " points out of " + nrQuestions + " possible!";
        //CharSequence text = "Invalid order quantity";

        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}