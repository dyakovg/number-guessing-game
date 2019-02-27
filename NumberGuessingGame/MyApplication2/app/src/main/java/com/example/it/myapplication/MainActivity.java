package com.example.it.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int num1, num2, points;    // the numbers on the left and right buttons
                            // player's point total; initially 0
    private Button buttonLeft, buttonRight;
    private TextView pointsTxt;

    /*
     * Updates the player's score based on whether they guessed correctly.
     * Also shows a 'toast' which is a brief popup message.
     */
    private void check(int a, int b) {
        if (a > b) {
            points++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            points--;
            Toast.makeText(this, "You are STUPID.", Toast.LENGTH_SHORT).show();
        }

        pointsTxt.setText("Points: " + points);
        roll();
    }

     //Chooses new random integers to appear on the two buttons.
    private void roll() {
        // pick two random numbers
        Random r = new Random();
        num1 = r.nextInt(9);
        num2 = r.nextInt(9);
        while (num2 == num1) {
            num2 = r.nextInt(9);
        }

        // set the buttons to display the random numbers
        buttonLeft.setText(String.valueOf(num1));     // "" + int -> converts int to String
                                                // String.valueOf(int) -> convert in to String
        buttonRight.setText(String.valueOf(num2));
    }

    //This method is called by Android when our activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pointsTxt = findViewById(R.id.pointsTextView);

        buttonLeft = findViewById(R.id.buttonLeft);
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(num1, num2);
            }
        });

        buttonRight = findViewById(R.id.buttonRight);
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(num2, num1);
            }
        });
        roll();   // <-- we added this line to set initial button random numbers
    }
}