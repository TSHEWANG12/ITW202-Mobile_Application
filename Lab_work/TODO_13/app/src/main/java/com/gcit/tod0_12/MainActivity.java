package com.gcit.tod0_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String list;
    public static final String LOG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public void showDonutOrder(View view) {
        String donut = "You ordered a donut";
        list = donut;
        Toast.makeText(this,"You ordered a donut",Toast.LENGTH_SHORT).show();
    }

    public void showIceCreamOrder(View view) {
        String ice = "You ordered a ice cream";
        list = ice;
        Toast.makeText(this,"You ordered a ice cream",Toast.LENGTH_SHORT).show();
    }

    public void showFroyoOrder(View view) {
        String froyo = "You ordered a froyo";
        list = froyo;
        Toast.makeText(this,"You ordered a froyo",Toast.LENGTH_SHORT).show();
    }

    public void Call(View view) {
       Intent intent =new Intent(this,OderItems.class);
        intent.putExtra("list", list);
       startActivity(intent);
    }
}