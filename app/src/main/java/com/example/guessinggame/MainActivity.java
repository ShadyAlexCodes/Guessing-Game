package com.example.guessinggame;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Guess guess = new Guess();
    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void btnGuessInteract(View view) {
        EditText getUserGuess = findViewById(R.id.txtUserGuess);

        System.out.println("FIRST GUESSES: " + guess.guesses);

        int userGuess;
        if(guess.guesses > 0) {
            // Check if the text box is empty
            if (TextUtils.isEmpty(getUserGuess.getText().toString())) {
                // Define the error
                getUserGuess.setError("Please enter a number");
                return;
            } else {
                // Otherwise grab the number and parse it into a double
                userGuess = Integer.parseInt(getUserGuess.getText().toString());

                // Remove the error message
                getUserGuess.setError(null);
            }

            TextView guessOutput = findViewById(R.id.txtOutput);
            guessOutput.setText(guess.checkGuess(userGuess, randomNumber));
        }
        else {
            getUserGuess.setEnabled(false);

            Button getBtn = (Button) findViewById(R.id.btnGuess);
            getBtn.setEnabled(false);

        }
    }

    public void btnRandomNumberInteract(View view) {
        int minValue;
        int maxValue;

        EditText getMinValue = findViewById(R.id.txtMinimum);

        // Check if the text box is empty
        if (TextUtils.isEmpty(getMinValue.getText().toString())) {
            // Define the error
            getMinValue.setError("Please enter a number");
            return;
        } else {
            // Otherwise grab the number and parse it into a double
            minValue = Integer.parseInt(getMinValue.getText().toString());
            System.out.println(minValue);
            // Remove the error message
            getMinValue.setError(null);
        }

        EditText getMaxValue = findViewById(R.id.txtMaximum);
        // Check if the text box is empty
        if (TextUtils.isEmpty(getMaxValue.getText().toString())) {
            // Define the error
            getMaxValue.setError("Please enter a number");
            return;
        } else {
            // Otherwise grab the number and parse it into a double
            maxValue = Integer.parseInt(getMaxValue.getText().toString());
            System.out.println(maxValue);
            // Remove the error message
            getMaxValue.setError(null);
        }

        TextView randomNumberGenerated = findViewById(R.id.txtRandomGenerated);
        randomNumber = guess.generateRandomNumber(minValue, maxValue);
        randomNumberGenerated.setText("A random number was generated!");
    }
}