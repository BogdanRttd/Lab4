package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList images = new ArrayList();
    Button myButton1;
    ImageView imageView;
    CheckBox image1,image2,image3,image4,image5;
    int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView) findViewById(R.id.imageView);
        CheckBox image1=(CheckBox) findViewById(R.id.checkBox);
        CheckBox image2=(CheckBox) findViewById(R.id.checkBox2);
        CheckBox image3=(CheckBox) findViewById(R.id.checkBox3);
        CheckBox image4=(CheckBox) findViewById(R.id.checkBox4);
        CheckBox image5=(CheckBox) findViewById(R.id.checkBox5);


        image1.setChecked(true);
        images.add(R.drawable.ic_account_circle_black_48dp);
        imageView.setImageDrawable(getResources().getDrawable((int) images.get(0)));

        myButton1 = (Button) findViewById(R.id.button);
        myButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=(count+1)%5;
                imageView.setImageDrawable(getResources().getDrawable((int) images.get(count)));
            }
        });
    }
    public void checkImage(View v){
        boolean ch = ((CheckBox) v).isChecked();
        switch (v.getId()){
            case R.id.checkBox:
                if (ch)
                    images.add(R.drawable.ic_account_circle_black_48dp);
                else
                    images.remove(R.drawable.ic_account_circle_black_48dp);
                break;
            case R.id.checkBox2:
                if (ch)
                    images.add(R.drawable.ic_adjust_black_48dp);
                else
                    images.remove(R.drawable.ic_adjust_black_48dp);
                break;
            case R.id.checkBox3:
                if (ch)
                    images.add(R.drawable.ic_alarm_on_black_48dp);
                else
                    images.remove(R.drawable.ic_alarm_on_black_48dp);
                break;
            case R.id.checkBox4:
                if (ch)
                    images.add(R.drawable.ic_assistant_black_48dp);
                else
                    images.remove(R.drawable.ic_assistant_black_48dp);
                break;
            case R.id.checkBox5:
                if (ch)
                    images.add(R.drawable.ic_brightness_4_black_48dp);
                else
                    images.remove(R.drawable.ic_brightness_4_black_48dp);
                break;
        }
    }
}

