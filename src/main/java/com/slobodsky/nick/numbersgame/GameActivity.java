package com.slobodsky.nick.numbersgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView tvNumber, tvResult;

    Button btnPlus, btnMinus, btnCheck;

    int currentNumber, numberToGuess, tries;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        tvNumber = findViewById(R.id.tvNumber);

        tvResult = findViewById(R.id.tvResult);

        btnPlus = findViewById(R.id.btnPlus);

        btnMinus = findViewById(R.id.btnMinus);

        btnCheck = findViewById(R.id.btnCheck);

        currentNumber = 0;

        r = new Random();

        numberToGuess = r.nextInt(50) + 1;

        tries = 0;

        tvNumber.setText("" + currentNumber);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentNumber < 100)
                {
                    currentNumber++;
                }

                tvNumber.setText("" + currentNumber);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentNumber > 0)
                {
                    currentNumber--;
                }

                tvNumber.setText("" + currentNumber);
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentNumber == numberToGuess)
                {
                    tvResult.setText("Congratulations ! You guessed in " + tries +  " tries !");

                    btnCheck.setEnabled(false);

                    btnPlus.setEnabled(false);

                    btnMinus.setEnabled(false);
                }

                if (currentNumber < numberToGuess)
                {
                    tvResult.setText("Up !");

                    tries++;
                }

                if (currentNumber > numberToGuess)
                {
                    tvResult.setText("Down !");

                    tries++;
                }
            }
        });
    }
}
