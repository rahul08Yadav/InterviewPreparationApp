package com.example.rahul.interview;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by rahul on 9/8/19.
 */

public class ToughQuestion extends AppCompatActivity implements View.OnClickListener{
    TextView tvquestion,tvanswer,tvtotallength_xx,tvtotallength_yy,quesTextView;
    Button bleft,bnext,bshow,bback,bspeech;

    String[] difficult_question,difficult_answer;

    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        findViewByIdes();

        //Importing the code fromm values folder
        difficult_answer = getResources().getStringArray(R.array.difficult_answers);
        difficult_question = getResources().getStringArray(R.array.difficult_questions);

        //onClickListener for three button
        bleft.setOnClickListener(this);
        bshow.setOnClickListener(this);
        bnext.setOnClickListener(this);

        index =  0;
        tvquestion.setText(difficult_question[index]);
        tvanswer.setText("press \"Answer\" Button for Answer");
        tvtotallength_xx.setText(String.valueOf(index+1));
        tvtotallength_yy.setText("/"+difficult_question.length);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.question_actionbar);

        quesTextView = (TextView) findViewById(R.id.question_tv);

        quesTextView.setText("Tough Question");

    }
    protected void findViewByIdes(){
        //Initialisation of TextView
        tvquestion = (TextView) findViewById(R.id.tvquestion);
        tvanswer = (TextView) findViewById(R.id.tvanswer);
        tvtotallength_xx = (TextView) findViewById(R.id.tvxx);
        tvtotallength_yy = (TextView) findViewById(R.id.tvyy);


        //Initialisation of Button
        bleft = (Button) findViewById(R.id.buttonleft);
        bshow = (Button) findViewById(R.id.buttonshow);
        bnext = (Button) findViewById(R.id.buttonnext);

        LinearLayout mainActivity = (LinearLayout) findViewById(R.id.question_actionbar);

        //Actionbar Initialisation
         bback = (Button) findViewById(R.id.back_button);
         bspeech = (Button) findViewById(R.id.speech_button);




    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonleft:
                tvanswer.setText("press \"Answer\" Button for Answer");
                index--;
                if(index == -1){
                    index = difficult_question.length -1;
                    tvquestion.setText(difficult_question[index]);
                    tvtotallength_xx.setText(String.valueOf(index+1));
                }
                else{
                tvquestion.setText(difficult_question[index]);
                tvtotallength_xx.setText(String.valueOf(index+1));
                }
                break;
            case R.id.buttonshow:
                tvanswer.setText(difficult_answer[index]);
                break;
            case R.id.buttonnext:
                tvanswer.setText("press \"Answer\" Button for Answer");
                index++;
                if(index == difficult_question.length){
                    index=0;
                    tvquestion.setText(difficult_question[index]);
                    tvtotallength_xx.setText(String.valueOf(index + 1));

                }else {
                    tvquestion.setText(difficult_question[index]);
                    tvtotallength_xx.setText(String.valueOf(index + 1));
                }
                break;

        }
    }
}
