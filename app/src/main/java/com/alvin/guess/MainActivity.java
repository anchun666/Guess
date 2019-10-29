package com.alvin.guess;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

     int guessTime = 0 ;
     int counter = 0;
     TextView textView;
     Button button;
     int answer = new Random().nextInt(10)+1;
     String TAG = MainActivity.class.getSimpleName();
    private TextView ed_counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView=findViewById(R.id.editText);
        button = findViewById(R.id.button);
        Log.d(TAG,"answer:" + answer);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {




            public void onClick(View view) {




            }
        });
    }

    public void clicktwo(View view){
        guessTime += 1;
        textView=findViewById(R.id.editText);
        button = findViewById(R.id.button);
        ed_counter = findViewById(R.id.ed_counter);
        Log.d(TAG,"Answer:" + answer);
        EditText editText = findViewById(R.id.editText);
        TextView textView2 = findViewById(R.id.textView2);
        ed_counter.setText(counter+" ");
        counter = 0;
        counter ++ ;
        int guess = Integer.valueOf(editText.getText().toString());


        if (guess == answer) {
            //Toast.makeText(MainActivity.this, "Bingo", Toast.LENGTH_LONG).show();
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Result")
                    .setMessage("Bingo")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            answer = new Random().nextInt(10)+1;
                            counter = 0;

                        }
                    })
                    .show();

        }else if(guess < answer) {
            Toast.makeText(MainActivity.this, "Bigger", Toast.LENGTH_LONG).show();

        }else if(guess > answer) {
            Toast.makeText(MainActivity.this, "Smaller", Toast.LENGTH_LONG).show();

        }
        textView2.setText("猜了"+Integer.toString(guessTime)+"次");
        ed_counter.setText("猜了"+Integer.toString(guessTime)+"次");
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

