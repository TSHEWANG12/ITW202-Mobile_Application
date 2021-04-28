package com.gcit.t0do_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText first, second,result;
    private Button addbtn,subbtn,mulbtn,divbtn;
    private Calculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first=findViewById(R.id.first);
        second=findViewById(R.id.second);
        result=findViewById(R.id.result);

        addbtn=findViewById(R.id.addbtn);
        subbtn=findViewById(R.id.subbtn);
        mulbtn=findViewById(R.id.mulbtn);
        divbtn=findViewById(R.id.divbtn);
        mCalculator=new Calculator();

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no1=first.getText().toString();
                String no2=second.getText().toString();
                double value=mCalculator.add(Double.valueOf(no1),Double.valueOf(no2));
                result.setText(String.valueOf(value));

            }
        });

        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no1=first.getText().toString();
                String no2=second.getText().toString();
                double value=mCalculator.sub(Double.valueOf(no1),Double.valueOf(no2));
                result.setText(String.valueOf(value));

            }
        });

        mulbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no1=first.getText().toString();
                String no2=second.getText().toString();
                double value=mCalculator.mul(Double.valueOf(no1),Double.valueOf(no2));
                result.setText(String.valueOf(value));

            }
        });

        divbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no1=first.getText().toString();
                String no2=second.getText().toString();
                double value=mCalculator.div(Double.valueOf(no1),Double.valueOf(no2));
                result.setText(String.valueOf(value));
            }
        });

    }
}