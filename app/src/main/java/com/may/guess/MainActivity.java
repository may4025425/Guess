package com.may.guess;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {


    String TAG = MainActivity.class.getSimpleName()  ;
    private TextView number;
    int initnumber;
    int secret = new Random().nextInt(10)+1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"secret"+secret);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        number = findViewById(R.id.num);


        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                initnumber = 0;
                number.setText(String.valueOf(initnumber));
            }
        });
    }

    public void commit(View view){
        String n = number.getText().toString();
        int guessnum = Integer.parseInt(n);

        if(guessnum==secret){
            Toast.makeText(MainActivity.this,"猜中了",Toast.LENGTH_LONG).show();

        }else if (guessnum<secret) {
            Toast.makeText(MainActivity.this,"大一點",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this,"小一點",Toast.LENGTH_LONG).show();
        }


    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
