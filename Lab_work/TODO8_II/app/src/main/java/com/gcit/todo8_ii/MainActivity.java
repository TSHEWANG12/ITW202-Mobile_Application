package com.gcit.todo8_ii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText Open_website,Open_location,Share_text;
    private Button websitebtn,locationbtn,sharebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Open_website = findViewById(R.id.Open_website);
        Open_location = findViewById(R.id.Open_location);
        Share_text = findViewById(R.id.Share_text);
        websitebtn = findViewById(R.id.websitebtn);
        locationbtn = findViewById(R.id.locationbtn);
        sharebtn = findViewById(R.id.sharebtn);

        websitebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = Open_website.getText().toString();
                Uri uri = Uri.parse(text);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("Implicit intent", "Error");
                }
            }
        });
        locationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = Open_location.getText().toString();
                Uri uri = Uri.parse("geo:0,0?q=" + text);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("Implicit intent", "error");
                }

            }
        });
    }

    public void Share(View view) {
        String text=Share_text.getText().toString();
        String mimeType="text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with")
                .setText(text)
                .startChooser();
    }
}