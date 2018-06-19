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
        question_checkbox = itemView.findViewById(R.id.question_checkbox);
        question = itemView.findViewById(R.id.question);
        illustration = itemView.findViewById(R.id.illustration);
        boxA = itemView.findViewById(R.id.option_a);
        boxB = itemView.findViewById(R.id.option_b);
        boxC = itemView.findViewById(R.id.option_c);
        boxD = itemView.findViewById(R.id.option_d);
    }
}
