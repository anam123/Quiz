package com.example.anambhatia.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Int2;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by AnamBhatia on 25/08/16.
 */
public class CheatActivity  extends AppCompatActivity {


    TextView cheat;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        cheat=(TextView)findViewById(R.id.textView6);
        tv=(TextView)findViewById(R.id.textView7);
        Intent intent = getIntent();
        int value = intent.getIntExtra("number",0);
        boolean prime=intent.getBooleanExtra("prime",true);
        cheat.setText(Integer.toString(value));
        tv.setText(Boolean.toString(prime));

    }


}
