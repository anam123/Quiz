package com.example.anambhatia.quiz;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by AnamBhatia on 25/08/16.
 */
public class HintActivity  extends Activity {

    TextView hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        hint=(TextView)findViewById(R.id.textView5);
        hint.setText("A prime number is divisible by 1 or the number itself.");
    }


}
