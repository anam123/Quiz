package com.example.anambhatia.quiz;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button correct;
    Button incorrect;
    Button nxt;
    TextView random;
    TextView marks;
    int n;
    int score=0;
    int flag=0;
    int clicked=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        correct= (Button)findViewById(R.id.button);
        incorrect=(Button)findViewById(R.id.button2);
        nxt=(Button)findViewById(R.id.button3);
        random=(TextView)findViewById(R.id.textView);
        marks=(TextView)findViewById(R.id.textView4);

        if (savedInstanceState == null) {
            Random rand = new Random();
            n = rand.nextInt(1000) + 1;
            random.setText(Integer.toString(n));
            nxt.setClickable(false);
        }


    }



    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("score", score);

        savedInstanceState.putInt("n", n);
        savedInstanceState.putInt("clicked", clicked);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        score = savedInstanceState.getInt("score");
         n = savedInstanceState.getInt("n");
        clicked = savedInstanceState.getInt("clicked");
        random.setText(Integer.toString(n));
        marks.setText(Integer.toString(score));
        if(clicked==1) {
            correct.setClickable(false);
            incorrect.setClickable(false);
            correct.setAlpha(.5f);
            incorrect.setAlpha(.5f);
        }



    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen for landscape and portrait and set portrait mode always
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        }
    }

    public boolean prime(int n)
    {
        int flag=0;
        if (n==1)
        {
            return false;
        }
        else if(n==2)
        {
            return true;
        }
        else  {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {

                    flag=1;
                }
            }
            if(flag==0)
            {
                return true;
            }
            else{
                return false;
            }
        }
    }

    public void tru(View v)
    {
        clicked=1;
       if(prime(Integer.parseInt(random.getText().toString()))==true)
       {
          Toast x= Toast.makeText(getApplicationContext(),"You are right, +1",Toast.LENGTH_SHORT);
           x.setGravity(Gravity.CENTER, 0, 0);
           x.show();
           score=score+1;
           marks.setText(Integer.toString(score));
           flag=1;
           correct.setAlpha(.5f);
           incorrect.setAlpha(.5f);
           nxt.setClickable(true);
           correct.setClickable(false);
           incorrect.setClickable(false);

       }
        else {


           Toast x= Toast.makeText(getApplicationContext(),"You are wrong, -1",Toast.LENGTH_SHORT);
           x.setGravity(Gravity.CENTER, 0, 0);
           x.show();
           score=score-1;
           marks.setText(Integer.toString(score));
           nxt.setClickable(true);
           correct.setAlpha(.5f);
           incorrect.setAlpha(.5f);
           correct.setClickable(false);
           incorrect.setClickable(false);
           flag=0;

       }
    }

    public void fals(View v)
    {
        clicked=1;
        if(prime(Integer.parseInt(random.getText().toString()))==false)
        {
            Toast x= Toast.makeText(getApplicationContext(),"You are right, +1",Toast.LENGTH_SHORT);
            x.setGravity(Gravity.CENTER, 0, 0);

            x.show();
            score=score+1;
            marks.setText(Integer.toString(score));
            nxt.setClickable(true);
            correct.setAlpha(.5f);
            incorrect.setAlpha(.5f);
            correct.setClickable(false);
            incorrect.setClickable(false);
            flag=1;


        }
        else {

            Toast x= Toast.makeText(getApplicationContext(),"You are wrong, -1",Toast.LENGTH_SHORT);
            x.setGravity(Gravity.CENTER, 0, 0);
            x.show();
            score=score-1;
            marks.setText(Integer.toString(score));
            nxt.setClickable(true);
            correct.setAlpha(.5f);
            incorrect.setAlpha(.5f);
            correct.setClickable(false);
            incorrect.setClickable(false);
            flag=0;
        }


    }

    public void next(View v)
    {
        correct.setClickable(true);
        incorrect.setClickable(true);
        clicked=0;
        correct.setAlpha(1f);
        incorrect.setAlpha(1f);
        Random rand = new Random();
        n = rand.nextInt(1000) + 1;
        random.setText(Integer.toString(n));
    }

}
