package com.gcit.todo_4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity<resultCode, requestCode> extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.gcit.todo_4.MESSAGE";
    private static final int TEXT_REQUEST = 1;
    private EditText editText;
    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.ueser_message);
        tv1 = findViewById(R.id.replytext);
        tv2 = findViewById(R.id.replymessage);


    }

    public void SEND(View view) {
        String message = editText.getText().toString();
        Intent obj = new Intent(this, MainActivity2.class);
        obj.putExtra("EXTRA_MESSAGE", message);
        startActivityForResult(obj,TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String message =data.getStringExtra(MainActivity2.EXTRA_REPLY);
                tv1.setVisibility(View.VISIBLE);
                tv2.setText(message);
                tv2.setVisibility(View.VISIBLE);
            }
        }
    }

}
