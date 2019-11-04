package com.may.guess;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

//alerdialog 更動其上面的文字+Listener的使用示範
//範例（期中考）：Shop

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() ;
    int counter = 0;
    private int secret;
    private EditText edNumber;
    private TextView edCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //secret = new Random().nextInt(10)+1;
       // Log.d(TAG,"secret:"+secret);
        edNumber = findViewById(R.id.number);
        edCounter = findViewById(R.id.counter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
        reset();
        Log.d(TAG,"string"+secret);
    }

    public void check(View view) {
       // guessTime+=1;
       // EditText answer = findViewById(R.id.ed_Answer);
       // TextView info = findViewById(R.id.tv_info);//TextView guess = findViewById(R.id.tv_guessTime);
       // int  num = Integer.valueOf(answer.getText().toString());

        int num = Integer.parseInt(edNumber.getText().toString());
        counter++;
        edCounter.setText(counter+"");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset();
            }
        };

        String message = "厲害";
        if (num < secret) {
            message = "Bigger";
            listener = null;
        } else if (num > secret) {
            message = "Smaller";
            listener = null;
        }
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Hahah")
                .setMessage("厲害")
                .setPositiveButton("OK", listener)
                .show();


       /* if (num == secret){
           // info.setText("答對了");

            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("BINGO")
                    .setTitle("棒棒噠")
                    .setPositiveButton("ok",null)
                    .show();
        }else if (num < secret){
            //info.setText("大一點");
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("bigger")
                    .setTitle("haha")
                    .setPositiveButton("ok",null)
                    .show();
        }else if (num > secret){
            //info.setText("小一點");
            new AlertDialog.Builder(MainActivity.this)
                    .setMessage("smaller")
                    .setTitle("haha")
                    .setPositiveButton("ok",null)
                    .show();
        } */

        edCounter.setText("猜了"+Integer.toString(counter)+"次");


    }

    public void reset(){
        secret = new Random().nextInt(10)+1;
        counter = 0;
        edCounter.setText(counter+"");
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