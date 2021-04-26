 package com.GCIT.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView tv;
int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView9);



    }

    public void Toast(View view) {
        Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT).show();
    }

    public void Count(View view) {
        a++;
        tv.setText(String.valueOf(a));
    }
}