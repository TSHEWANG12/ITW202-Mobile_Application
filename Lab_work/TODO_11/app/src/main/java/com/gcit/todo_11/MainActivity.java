package com.gcit.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
     private TextView textview;
     private Button button;
    private  String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        if (savedInstanceState != null) {
            textview.setTextColor(savedInstanceState.getInt("color"));
        }

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("color", textview.getCurrentTextColor());
    }
    public void changeColor(View view) {

        Random random = new Random();
        String colorName = mColorArray[random.nextInt(20)];


        int colorResourceName = getResources().getIdentifier(colorName, "color",
                getApplicationContext().getPackageName());

        int colorRes = ContextCompat.getColor(this, colorResourceName);


        textview.setTextColor(colorRes);
    }
}