package com.gcit.todo_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    int a=0;
    private int countIncrease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
        if(savedInstanceState!=null){
            countIncrease = savedInstanceState.getInt("Count");
            tv.setText(String.valueOf(countIncrease));
        }
    }

    public void Count(View view) {
        a++;

        tv.setText(String.valueOf(a));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Count",countIncrease);
    }
}