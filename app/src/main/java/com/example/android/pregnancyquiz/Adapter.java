package com.example.android.pregnancyquiz;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int RADIO_BUTTON = 0, CHECK_BOX = 1, FOOTER = 2;
    List<Object> questions;

    public Adapter(List<Object> questions) {
        this.questions = questions;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (questions.get(position) instanceof RadioButtonQuestion) {
            return RADIO_BUTTON;
        } else if (questions.get(position) instanceof CheckBoxQuestion) {
            return CHECK_BOX;
        } else if (questions.get(position) instanceof Quiz.Footer) {
            return FOOTER;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case RADIO_BUTTON:
                View v1 = inflater.inflate(R.layout.question_radiobutton, viewGroup, false);
                viewHolder = new RadioButtonQuestionVH(v1);
                break;
            case CHECK_BOX:
                View v2 = inflater.inflate(R.layout.question_checkbox, viewGroup, false);
                viewHolder = new CheckBoxQuestionVH(v2);
                break;

            case FOOTER:
                View v3 = inflater.inflate(R.layout.footer, viewGroup, false);
                viewHolder = new FooterVH(v3);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        switch (viewHolder.getItemViewType()) {
            case RADIO_BUTTON:
                RadioButtonQuestionVH rbvh = (RadioButtonQuestionVH) viewHolder;
                configureRadioButtonQuestionVH(rbvh, position);
                break;
            case CHECK_BOX:
                CheckBoxQuestionVH cbvh = (CheckBoxQuestionVH) viewHolder;
                configureCheckBoxQuestionVH(cbvh, position);
                break;

            case FOOTER:
                FooterVH fvh = (FooterVH) viewHolder;
                break;

            default:
                break;
        }
    }

    private void configureRadioButtonQuestionVH(RadioButtonQuestionVH rbvh, int position) {
        RadioButtonQuestion rbq = (RadioButtonQuestion) questions.get(position);
        rbvh.question.setText(rbq.question);
        rbvh.illustration.setImageResource(rbq.photoId);

        rbvh.buttonA.setText(rbq.optionA);
        rbvh.buttonB.setText(rbq.optionB);
        rbvh.buttonC.setText(rbq.optionC);
        rbvh.buttonD.setText(rbq.optionD);

        rbvh.buttonA.setTag(position);
        rbvh.buttonB.setTag(position);
        rbvh.buttonC.setTag(position);
        rbvh.buttonD.setTag(position);
    }

    private void configureCheckBoxQuestionVH(CheckBoxQuestionVH cbqvh, int position) {
        CheckBoxQuestion cbq = (CheckBoxQuestion) questions.get(position);
        cbqvh.question.setText(cbq.question);
        cbqvh.illustration.setImageResource(cbq.photoId);

        cbqvh.boxA.setText(cbq.optionA);
        cbqvh.boxB.setText(cbq.optionB);
        cbqvh.boxC.setText(cbq.optionC);
        cbqvh.boxD.setText(cbq.optionD);

        cbqvh.boxA.setTag(position);
        cbqvh.boxB.setTag(position);
        cbqvh.boxC.setTag(position);
        cbqvh.boxD.setTag(position);
    }

    public class FooterVH extends RecyclerView.ViewHolder {

        CardView footer;
        Button button;

        FooterVH(View itemView) {
            super(itemView);
            footer = itemView.findViewById(R.id.footer);
            button = itemView.findViewById(R.id.score);
        }
    }

}