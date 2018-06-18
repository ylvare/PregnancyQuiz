package com.example.android.pregnancyquiz;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.pregnancyquiz.R;
import com.example.android.pregnancyquiz.RVAdapter;

import java.util.ArrayList;
import java.util.List;

public class Quiz extends Activity {

    private List<Object> questions;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    public String getName(){
        String name = ((EditText) findViewById(R.id.name)).getText().toString();
        return name;
    }

    public class Footer {

        Footer(){
        }
    }

    private void initializeData(){
        questions = new ArrayList<>();

        questions.add(new RadioButtonQuestion("How many beats per minute does the heart of an embryo beat when the embryo is eight weeks old?", "A",
                "A", "150", "200", "250", "300", R.drawable.glad_ylva));
        questions.add(new RadioButtonQuestion(
                "In what week does the tale of the embryo disappear?","A",
                "B", "5 weeks", "9 weeks", "12 weeks", "14 weeks", R.drawable.glad_ylva));
        questions.add(new CheckBoxQuestion("What parts of the baby body develops faster than the legs and feets?", "A",
                "B", "hands", "arms", "chest", "hips", R.drawable.glad_ylva));
        questions.add(new RadioButtonQuestion("At what week does the child-to-be transform from being an embryo to a foetus in medical terms?", "A",
                "B", "6 weeks", "11 weeks", "15 weeks", "19 weeks", R.drawable.glad_ylva));
        questions.add(new RadioButtonQuestion("How many beats per minute does the heart in an embryo beat when the embryo is eight weeks old?", "A",
                "D", "4 weeks", "12 weeks", "16 weeks", "18 weeks", R.drawable.glad_ylva));
        questions.add(new CheckBoxQuestion("What happens typically in week 12 of the foetus development?", "A",
                "B", "The baby can swallow", "The baby urinates for the first time", "The baby can clench his fist", "The baby can hickup", R.drawable.glad_ylva));
        questions.add(new Footer());

    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(questions);
        rv.setAdapter(adapter);
    }

    /*

    public void answerRadioButton(View view){

        switch(view.getId()) {
            case R.id.checkbox_meat:
                if (checked)
                // Put some meat on the sandwich
            else
                // Remove the meat
                break;
            case R.id.checkbox_cheese:
                if (checked)
                // Cheese me
            else
                // I'm lactose intolerant
                break;
            //
        }

    }*/

    public void answerA(View view){
        RadioButtonQuestion rbq = (RadioButtonQuestion)questions.get((int) view.getTag());
        rbq.answer_entered = "A";
    }

    public void answerB(View view){
        RadioButtonQuestion rbq = (RadioButtonQuestion)questions.get((int) view.getTag());
        rbq.answer_entered = "B";
    }

    public void answerC(View view){
        RadioButtonQuestion rbq = (RadioButtonQuestion)questions.get((int) view.getTag());
        rbq.answer_entered = "C";
    }

    public void answerD(View view){
        RadioButtonQuestion rbq = (RadioButtonQuestion)questions.get((int) view.getTag());
        rbq.answer_entered = "D";
    }
}