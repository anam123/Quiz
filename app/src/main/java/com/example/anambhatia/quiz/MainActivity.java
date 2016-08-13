package com.example.anambhatia.quiz;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        correct= (Button)findViewById(R.id.button);
        incorrect=(Button)findViewById(R.id.button2);
        nxt=(Button)findViewById(R.id.button3);
        random=(TextView)findViewById(R.id.textView);
        marks=(TextView)findViewById(R.id.textView4);
        Random rand = new Random();

        n = rand.nextInt(1000) + 1;
        random.setText(Integer.toString(n));
        nxt.setEnabled(false);

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
       if(prime(Integer.parseInt(random.getText().toString()))==true)
       {
          Toast x= Toast.makeText(getApplicationContext(),"You are right, +1",Toast.LENGTH_SHORT);
           x.setGravity(Gravity.CENTER, 0, 0);
           x.show();
           flag=1;
           nxt.setEnabled(true);
           correct.setEnabled(false);
           incorrect.setEnabled(false);

       }
        else {

           Toast x= Toast.makeText(getApplicationContext(),"You are wrong, -1",Toast.LENGTH_SHORT);
           x.setGravity(Gravity.CENTER, 0, 0);
           x.show();
           nxt.setEnabled(true);
           correct.setEnabled(false);
           incorrect.setEnabled(false);
           flag=0;

       }
    }

    public void fals(View v)
    {
        if(prime(Integer.parseInt(random.getText().toString()))==false)
        {
            Toast x= Toast.makeText(getApplicationContext(),"You are right, +1",Toast.LENGTH_SHORT);
            x.setGravity(Gravity.CENTER, 0, 0);

            x.show();

            nxt.setEnabled(true);
            correct.setEnabled(false);
            incorrect.setEnabled(false);
            flag=1;

        }
        else {

            Toast x= Toast.makeText(getApplicationContext(),"You are wrong, -1",Toast.LENGTH_SHORT);
            x.setGravity(Gravity.CENTER, 0, 0);
            x.show();
            nxt.setEnabled(true);
            correct.setEnabled(false);
            incorrect.setEnabled(false);
            flag=0;
        }


    }

    public void next(View v)
    {
        if(flag==1)
        {
            score=score+1;
            marks.setText(Integer.toString(score));
        }
        else{
            score=score-1;
            marks.setText(Integer.toString(score));
        }
        correct.setEnabled(true);
        incorrect.setEnabled(true);
        Random rand = new Random();
        n = rand.nextInt(1000) + 1;
        random.setText(Integer.toString(n));
    }

}
