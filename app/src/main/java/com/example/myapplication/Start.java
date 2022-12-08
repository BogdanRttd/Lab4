package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.example.lab4_tockyjb.R;

public class Start extends AppCompatActivity {
    Button start, menu, popmenu;
    TextView difficulty;
    String difficulty_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        start = (Button) findViewById(R.id.button5);
        menu = (Button) findViewById(R.id.button6);
        difficulty = (TextView) findViewById(R.id.textView7);
        popmenu = (Button) findViewById(R.id.button8);
        registerForContextMenu(menu);
        addListenerOnButton();

        PopupMenu popupMenu = new PopupMenu(
                this,
                popmenu);

        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.seconds_90) {
                } else if (id == R.id.seconds_45) {
                } else if (id == R.id.seconds_15) {
                }
                return false;
            }
        });

        popmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.time_menu, menu);
        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.difficulty_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.easy:
                difficulty.setText("90");
                break;
            case R.id.medium:
                difficulty.setText("45");
                break;
            case R.id.hard:
                difficulty.setText("15");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.easy:
                difficulty.setText("90");
                return true;
            case R.id.medium:
                difficulty.setText("45");
                return true;
            case R.id.hard:
                difficulty.setText("15");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addListenerOnButton() {
        start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        difficulty_1 = difficulty.getText().toString();
                        next();
                    }
                }
        );
    }

    public void next(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("key1", difficulty_1);
        startActivity(intent);
    }
}

