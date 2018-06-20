package com.example.android.pregnancyquiz;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
        rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        initializeData();
        initializeAdapter();
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
        Adapter adapter = new Adapter(questions);
        rv.setAdapter(adapter);
    }

    public void answerRadioButton(View view) {
        RadioButtonQuestion rbq = (RadioButtonQuestion) questions.get((int) view.getTag());

        if (view.getId() == R.id.option_a) {
            rbq.answerEntered = Consts.OPTION_A;
        } else if (view.getId() == R.id.option_b) {
            rbq.answerEntered = Consts.OPTION_B;
        } else if (view.getId() == R.id.option_c) {
            rbq.answerEntered = Consts.OPTION_C;
        } else if (view.getId() == R.id.option_d) {
            rbq.answerEntered = Consts.OPTION_D;
        }
    }

    public void answerCheckBox(View view) {
        CheckBoxQuestion cbq = (CheckBoxQuestion) questions.get((int) view.getTag());
        boolean checked = ((CheckBox) view).isChecked();

        if (view.getId() == R.id.option_a) {
            if (checked) {
                cbq.answersEntered[Consts.BOX_A] = Boolean.TRUE;
            } else {
                cbq.answersEntered[Consts.BOX_A] = Boolean.FALSE;
            }
        }

        if (view.getId() == R.id.option_b) {
            if (checked) {
                cbq.answersEntered[Consts.BOX_B] = Boolean.TRUE;
            } else {
                cbq.answersEntered[Consts.BOX_B] = Boolean.FALSE;
            }
        }

        if (view.getId() == R.id.option_c) {
            if (checked) {
                cbq.answersEntered[Consts.BOX_C] = Boolean.TRUE;
            } else {
                cbq.answersEntered[Consts.BOX_C] = Boolean.FALSE;
            }
        }

        if (view.getId() == R.id.option_d) {
            if (checked) {
                cbq.answersEntered[Consts.BOX_D] = Boolean.TRUE;
            } else {
                cbq.answersEntered[Consts.BOX_D] = Boolean.FALSE;
            }
        }
    }

    public void calculateScore(View view) {
        score = Consts.ZERO_SCORE;

        for (Object question : questions) {
            if (question instanceof RadioButtonQuestion) {
                if (((RadioButtonQuestion) question).answerEntered.equals(((RadioButtonQuestion) question).correctAnswer)) {
                    score = score+1;
                }
            }

            if (question instanceof CheckBoxQuestion) {
                Boolean[] answersEntered = ((CheckBoxQuestion) question).answersEntered;
                Boolean[] correctAnswers = ((CheckBoxQuestion) question).correctAnswers;
                if (Arrays.equals(answersEntered, correctAnswers)) {
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
        String text =  name + ", you got " + score + " points out of " + nrQuestions + " possible!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public final class Consts {

        public static final int ZERO_SCORE = 0;

        public static final int BOX_A = 0;
        public static final int BOX_B = 1;
        public static final int BOX_C = 2;
        public static final int BOX_D = 3;


        public static final String OPTION_A = "A";
        public static final String OPTION_B = "B";
        public static final String OPTION_C = "C";
        public static final String OPTION_D = "D";

        private Consts() {

            throw new AssertionError();
        }
    }
}

