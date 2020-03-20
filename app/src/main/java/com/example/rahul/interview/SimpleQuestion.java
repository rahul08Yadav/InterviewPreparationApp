package com.example.rahul.interview;


import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class SimpleQuestion extends AppCompatActivity implements View.OnClickListener {
    TextView tvquestion,tvanswer,tvtotallength_xx,tvtotallength_yy,quesTextView;
    Button bleft,bnext,bshow,bstop,bspeech;
    String[] simple_question,simple_answers;
    public static final String default_answer ="press \"GetAnswer\" Button for Answer" ;
    TextToSpeech ttsobject;
    int result;

    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        findViewByIdes();

        index = 0;
        //Importing the code fromm values folder
        simple_question = getResources().getStringArray(R.array.simple_question);
        simple_answers = getResources().getStringArray(R.array.simple_answers);

        //onClickListener for three button and speak stop button
        bleft.setOnClickListener(this);
        bshow.setOnClickListener(this);
        bnext.setOnClickListener(this);
       /* bspeech.setOnClickListener(this);
        bstop.setOnClickListener(this);*/

        //setting values to the text view
        tvquestion.setText(simple_question[index]);
        tvanswer.setText(default_answer);
        tvtotallength_xx.setText(String.valueOf(index + 1));
        tvtotallength_yy.setText("/" + simple_question.length);

        /*getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.question_actionbar);

        quesTextView.setText("Simple Question");
        quesTextView = (TextView) findViewById(R.id.question_tv);*/


        // Text to speech code
        ttsobject = new TextToSpeech(SimpleQuestion.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
//Define a variable named result and assign the value.
                    result = ttsobject.setLanguage(Locale.US);
                } else {
                    Toast.makeText(getApplicationContext(), "Feature not Supported in Device", Toast.LENGTH_SHORT).show();
                }
            }


        });
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
        bstop = (Button) findViewById(R.id.back_button);
        bspeech = (Button) findViewById(R.id.speech_button);



    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonleft:
                tvanswer.setText(default_answer);
                index--;
                if(index == -1){
                    index = simple_question.length -1;
                    tvtotallength_xx.setText(String.valueOf(index + 1));
                    tvquestion.setText(simple_question[index]);
                }else {
                    tvtotallength_xx.setText(String.valueOf(index + 1));
                    tvquestion.setText(simple_question[index]);
                }
                break;
            case R.id.buttonshow:
                tvanswer.setText(simple_answers[index]);
                break;
            case R.id.buttonnext:
                tvanswer.setText(default_answer);
                index++;
                if(index == simple_question.length) {
                    index = 0;
                    tvtotallength_xx.setText(String.valueOf(index + 1));
                    tvquestion.setText(simple_question[index]);
                }
                else{
                    tvtotallength_xx.setText(String.valueOf(index + 1));
                    tvquestion.setText(simple_question[index]);
                }
                break;
            case R.id.speech_button:
                if(result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){

                    Toast.makeText(getApplicationContext(),"Feature not Supported in Device",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(tvanswer.getText().toString().equals(default_answer)){

                        }
                    else{
                            ttsobject.speak(simple_answers[index],TextToSpeech.QUEUE_FLUSH, null, null);
                        }


                }
                break;
            case R.id.back_button:
                if(ttsobject != null){
                    ttsobject.stop();
                }

                break;

        }


    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        if (ttsobject != null) {
            ttsobject.stop();
            ttsobject.shutdown();
        }
    }
}