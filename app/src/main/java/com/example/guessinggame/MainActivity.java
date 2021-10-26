package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void btnGuessInteract(View view) {
        Guess guess = new Guess();

        int userGuess;
        EditText getUserGuess = (EditText) findViewById(R.id.txtUserGuess);
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

        TextView guessOutput = (TextView) findViewById(R.id.txtOutput);
        guessOutput.setText(guess.checkGuess(userGuess, randomNumber));

    }

    public void btnRandomNumberInteract(View view) {
        Guess guess = new Guess();
        int minValue;
        int maxValue;

        EditText getMinValue = (EditText) findViewById(R.id.txtMinimum);

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

        EditText getMaxValue = (EditText) findViewById(R.id.txtMaximum);
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

        TextView randomNumberGenerated = (TextView) findViewById(R.id.txtRandomGenerated);
        randomNumber = guess.generateRandomNumber(minValue, maxValue);
        randomNumberGenerated.setText("A random number was generated: " + randomNumber);
    }
}