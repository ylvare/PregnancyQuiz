package com.example.android.pregnancyquiz;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.pregnancyquiz.R;
import com.example.android.pregnancyquiz.RVAdapter;

import java.util.ArrayList;
import java.util.List;

public class Quiz extends Activity {

    private List<Question2> questions;
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

    private void initializeData(){
        questions = new ArrayList<>();

        questions.add(new Question2("How many beats per minute does the heart in an embryo beat when the embryo is eight weeks old?", "A",
                "B", "150", "200", "250", "300", R.drawable.glad_ylva));
        questions.add(new Question2("How many beats per minute does the heart in an embryo beat when the embryo is eight weeks old?", "A",
                "B", "150", "200", "250", "300", R.drawable.glad_ylva));
        questions.add(new Question2("How many beats per minute does the heart in an embryo beat when the embryo is eight weeks old?", "A",
                "B", "150", "200", "250", "300", R.drawable.glad_ylva));
        questions.add(new Question2("How many beats per minute does the heart in an embryo beat when the embryo is eight weeks old?", "A",
                "B", "150", "200", "250", "300", R.drawable.glad_ylva));
        questions.add(new Question2("How many beats per minute does the heart in an embryo beat when the embryo is eight weeks old?", "A",
                "B", "150", "200", "250", "300", R.drawable.glad_ylva));

    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(questions);
        rv.setAdapter(adapter);
    }

    public void answerA(View view){
        questions.get((int) view.getTag()).answer_entered = "A";

    }

    public void answerB(View view){
        questions.get((int) view.getTag()).answer_entered = "B";

    }

    public void answerC(View view){
        questions.get((int) view.getTag()).answer_entered = "C";

    }

    public void answerD(View view){
        questions.get((int) view.getTag()).answer_entered = "D";
    }
}