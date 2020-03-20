package com.example.rahul.interview;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bsimple, btough, bseeotherapps, brateapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewByIdes();
        bsimple.setOnClickListener(this);
        btough.setOnClickListener(this);
        bseeotherapps.setOnClickListener(this);
        brateapp.setOnClickListener(this);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.activity_actionbar);
    }
    protected void findViewByIdes(){
        bsimple = (Button) findViewById(R.id.button1);
        btough = (Button) findViewById(R.id.button2);
        bseeotherapps = (Button) findViewById(R.id.button3);
        brateapp = (Button) findViewById(R.id.button3);

        LinearLayout mainActivity = (LinearLayout) findViewById(R.id.activity_actionbar);


    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button1:
                Intent i = new Intent(MainActivity.this,SimpleQuestion.class);
                startActivity(i);
                break;
            case R.id.button2:
                Intent j = new Intent(MainActivity.this,ToughQuestion.class);
                startActivity(j);
                break;
            case R.id.button3:
                try{
                    Uri uri1 = Uri.parse("market://search?q=Tencent Games") ;//write the publisher name for q=.
                    Intent goToMarket1 = new Intent(Intent.ACTION_VIEW,uri1);
                    startActivity(goToMarket1);}
                catch (ActivityNotFoundException e){
                    Uri uri1 = Uri.parse("http://play.google.com/store/apps/details?q=Tencent Games") ;//write the publisher name for q=.
                    Intent goToMarket1 = new Intent(Intent.ACTION_VIEW,uri1);
                    startActivity(goToMarket1);

                }

                break;
            case R.id.button4:
                try{
                Uri uri1 = Uri.parse("market://details?id = "+getPackageName()) ;//uriString from play store
                Intent goToMarket1 = new Intent(Intent.ACTION_VIEW,uri1);
                startActivity(goToMarket1);}
                catch (ActivityNotFoundException e){
                    Uri uri1 = Uri.parse("http://play.google.com/store/apps/details?id = "+getPackageName()) ;//uriString from play store
                    Intent goToMarket1 = new Intent(Intent.ACTION_VIEW,uri1);
                    startActivity(goToMarket1);

                }
                break;
        }

    }
}
