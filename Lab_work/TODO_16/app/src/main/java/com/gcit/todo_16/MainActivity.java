package com.gcit.todo_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mrecyclerView;
    private WordlistAdapter adapter;
    private final LinkedList<String> mWordList = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 20; i++){
            mWordList.addLast("Word" + i);
        }

        mrecyclerView = findViewById(R.id.recyclerview);
        adapter = new WordlistAdapter(this, mWordList);
        mrecyclerView.setAdapter(adapter);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = mWordList.size();

                mWordList.addLast("+ Word " + wordListSize);
                mrecyclerView.getAdapter().notifyItemInserted(wordListSize);

                mrecyclerView.smoothScrollToPosition(wordListSize);
            }
        });
    }
}