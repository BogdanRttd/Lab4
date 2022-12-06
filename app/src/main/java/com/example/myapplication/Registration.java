package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Registration extends AppCompatActivity {
    EditText name;
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name = (EditText) findViewById(R.id.editText_username);
        email = (EditText) findViewById(R.id.editText_email);
        password = (EditText) findViewById(R.id.editText_password);
    }

    public void Btn_log (View v) {
        if (name.getText().toString().equals("Bogdan") && password.getText().toString().equals("Rttd") && email.getText().toString().equals("bogdantockyj@gmail.com")) {
            Toast.makeText(getApplicationContext(), "Успішний вхід!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Невірні дані!",Toast.LENGTH_SHORT).show();
        }
    }
}