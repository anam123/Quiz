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


    Button b1;
    Button b2;
    Button b3;
    TextView tv;
    TextView tv1;
    int n;
    int score=0;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        tv=(TextView)findViewById(R.id.textView);
        tv1=(TextView)findViewById(R.id.textView4);
        Random rand = new Random();

        n = rand.nextInt(1000) + 1;
        tv.setText(Integer.toString(n));
        b3.setEnabled(false);

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
       if(prime(Integer.parseInt(tv.getText().toString()))==true)
       {
          Toast x= Toast.makeText(getApplicationContext(),"You are right, +1",Toast.LENGTH_SHORT);
           x.setGravity(Gravity.CENTER, 0, 0);
           x.show();
           flag=1;
           b3.setEnabled(true);
           b1.setEnabled(false);
           b2.setEnabled(false);

       }
        else {

           Toast x= Toast.makeText(getApplicationContext(),"You are wrong, -1",Toast.LENGTH_SHORT);
           x.setGravity(Gravity.CENTER, 0, 0);
           x.show();
           b3.setEnabled(true);
           b1.setEnabled(false);
           b2.setEnabled(false);
           flag=0;

       }
    }

    public void fals(View v)
    {
        if(prime(Integer.parseInt(tv.getText().toString()))==false)
        {
            Toast x= Toast.makeText(getApplicationContext(),"You are right, +1",Toast.LENGTH_SHORT);
            x.setGravity(Gravity.CENTER, 0, 0);

            x.show();

            b3.setEnabled(true);
            b1.setEnabled(false);
            b2.setEnabled(false);
            flag=1;

        }
        else {

            Toast x= Toast.makeText(getApplicationContext(),"You are wrong, -1",Toast.LENGTH_SHORT);
            x.setGravity(Gravity.CENTER, 0, 0);
            x.show();
            b3.setEnabled(true);
            b1.setEnabled(false);
            b2.setEnabled(false);
            flag=0;
        }


    }

    public void next(View v)
    {
        if(flag==1)
        {
            score=score+1;
            tv1.setText(Integer.toString(score));
        }
        else{
            score=score-1;
            tv1.setText(Integer.toString(score));
        }
        b1.setEnabled(true);
        b2.setEnabled(true);
        Random rand = new Random();
        n = rand.nextInt(1000) + 1;
        tv.setText(Integer.toString(n));
    }

}
