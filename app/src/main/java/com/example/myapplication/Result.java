package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Result extends AppCompatActivity {
    TextView message;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        message = (TextView) findViewById(R.id.textView5);
        answer = (TextView) findViewById(R.id.textView6);
        answer.setText(getIntent().getStringExtra("key"));
    }

    public void backgame(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void send(View v)
    {
        Intent intent = new Intent(this,email.class);
        startActivity(intent);
    }
}