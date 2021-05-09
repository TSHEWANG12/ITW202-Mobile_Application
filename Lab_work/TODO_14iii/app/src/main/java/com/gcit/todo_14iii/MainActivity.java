package com.gcit.todo_14iii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.time.Month;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment data=new DatePickerFragment();
                data.show(getSupportFragmentManager(),"Date Picker");
            }
        });
    }

    public void processDatePickerResult(int year, int month, int dayOfMonth) {
        String Month=Integer.toString(month+1);
        String day=Integer.toString(dayOfMonth);
        String Year=Integer.toString(year);
        String data_message=(Month+"/"+day+"/"+Year);
        Toast.makeText(this,"Date"+data_message,Toast.LENGTH_SHORT).show();
    }
}