package com.example.android.pregnancyquiz;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

//public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.QuestionViewHolder> {

    public class QuestionViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView question;
        ImageView illustration;
        RadioButton buttonA;
        RadioButton buttonB;
        RadioButton buttonC;
        RadioButton buttonD;

        QuestionViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            question = (TextView)itemView.findViewById(R.id.question);
            illustration = (ImageView)itemView.findViewById(R.id.illustration);
            buttonA = (RadioButton) itemView.findViewById(R.id.option_a);
            buttonB = (RadioButton) itemView.findViewById(R.id.option_b);
            buttonC = (RadioButton) itemView.findViewById(R.id.option_c);
            buttonD = (RadioButton) itemView.findViewById(R.id.option_d);
        }
    }

    List<Question2> questions;
    RVAdapter(List<Question2> questions){
        this.questions = questions;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.question, viewGroup, false);
        QuestionViewHolder qvh = new QuestionViewHolder(v);
        return qvh;
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder personViewHolder, int i) {
        personViewHolder.question.setText(questions.get(i).question);
        personViewHolder.illustration.setImageResource(questions.get(i).photoId);
        personViewHolder.buttonA.setText(questions.get(i).option_a);
        personViewHolder.buttonB.setText(questions.get(i).option_b);
        personViewHolder.buttonC.setText(questions.get(i).option_c);
        personViewHolder.buttonD.setText(questions.get(i).option_d);

        personViewHolder.buttonA.setTag(i);
        personViewHolder.buttonB.setTag(i);
        personViewHolder.buttonC.setTag(i);
        personViewHolder.buttonD.setTag(i);
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

}