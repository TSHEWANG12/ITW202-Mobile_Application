package com.gcit.todo_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_REPLY= "com.gcit.todo_4.reply";
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText=findViewById(R.id.replytext);
        Intent intent = getIntent();
        String message=intent.getStringExtra("EXTRA_MESSAGE");
        TextView textView=findViewById(R.id.dispaly_message);
        textView.setText(message);
    }

    public void Reply(View view) {
        String message =editText.getText().toString();
        Intent obj = new Intent();
        obj.putExtra(EXTRA_REPLY,message);
        setResult(RESULT_OK,obj);
        finish();
    }
}