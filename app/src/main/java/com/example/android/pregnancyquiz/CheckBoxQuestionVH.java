package com.example.android.pregnancyquiz;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


public class CheckBoxQuestionVH extends RecyclerView.ViewHolder {

    CardView question_checkbox;
    TextView question;
    ImageView illustration;
    CheckBox boxA;
    CheckBox boxB;
    CheckBox boxC;
    CheckBox boxD;

    CheckBoxQuestionVH(View itemView) {
        super(itemView);
        question_checkbox = (CardView) itemView.findViewById(R.id.question_checkbox);
        question = (TextView) itemView.findViewById(R.id.question);
        illustration = (ImageView) itemView.findViewById(R.id.illustration);
        boxA = (CheckBox) itemView.findViewById(R.id.option_a);
        boxB = (CheckBox) itemView.findViewById(R.id.option_b);
        boxC = (CheckBox) itemView.findViewById(R.id.option_c);
        boxD = (CheckBox) itemView.findViewById(R.id.option_d);
    }
}
