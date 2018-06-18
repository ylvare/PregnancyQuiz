package com.example.android.pregnancyquiz;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class RadioButtonQuestionVH extends RecyclerView.ViewHolder {

    CardView question_radiobutton;
    TextView question;
    ImageView illustration;
    RadioButton buttonA;
    RadioButton buttonB;
    RadioButton buttonC;
    RadioButton buttonD;

    RadioButtonQuestionVH(View itemView) {
        super(itemView);
        question_radiobutton = (CardView) itemView.findViewById(R.id.question_radiobutton);
        question = (TextView) itemView.findViewById(R.id.question);
        illustration = (ImageView) itemView.findViewById(R.id.illustration);
        buttonA = (RadioButton) itemView.findViewById(R.id.option_a);
        buttonB = (RadioButton) itemView.findViewById(R.id.option_b);
        buttonC = (RadioButton) itemView.findViewById(R.id.option_c);
        buttonD = (RadioButton) itemView.findViewById(R.id.option_d);
    }
}
