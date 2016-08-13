package com.example.anambhatia.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        tv=(TextView)findViewById(R.id.textView);
        Random rand = new Random();

        n = rand.nextInt(1000) + 1;
        tv.setText(Integer.toString(n));


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
          Toast x= Toast.makeText(getApplicationContext(),"You are right!",Toast.LENGTH_LONG);
           x.show();

       }
        else {

           Toast x= Toast.makeText(getApplicationContext(),"You are wrong!",Toast.LENGTH_LONG);
           x.show();

       }
    }

    public void fals(View v)
    {
        if(prime(Integer.parseInt(tv.getText().toString()))==false)
        {
            Toast x= Toast.makeText(getApplicationContext(),"You are right!",Toast.LENGTH_SHORT);
            x.show();
        }
        else {

            Toast x= Toast.makeText(getApplicationContext(),"You are wrong!",Toast.LENGTH_SHORT);
            x.show();

        }


    }

    public void next(View v)
    {
        Random rand = new Random();
        n = rand.nextInt(1000) + 1;
        tv.setText(Integer.toString(n));
    }

}
