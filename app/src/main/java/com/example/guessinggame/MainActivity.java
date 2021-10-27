package com.example.guessinggame;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Globally define the guess class
    Guess guess = new Guess();
    // Globally define a variable to store the random number
    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // User submission button interaction
    public void btnGuessInteract(View view) {
        // Grab the users guess, output view, and submission button
        EditText getUserGuess = findViewById(R.id.txtUserGuess);
        TextView guessOutput = findViewById(R.id.txtOutput);
        Button getBtn = (Button) findViewById(R.id.btnGuess);

        // Create an integer to store the users guess
        int userGuess;

        // Check if the guess counter is greater than 0
        if(guess.guesses > 0) {
            // Check if the text box is empty
            if (TextUtils.isEmpty(getUserGuess.getText().toString())) {
                // Define the error
                getUserGuess.setError("Please enter a number");
                return;
            } else {
                // Otherwise grab the number and parse it into an integer
                userGuess = Integer.parseInt(getUserGuess.getText().toString());
                // Remove the error message
                getUserGuess.setError(null);
            }
            // Use the guess class to check their guess parsing the guessed number and the random number itself/
            guessOutput.setText(guess.checkGuess(userGuess, randomNumber));
        }
        // Otherwise..
        else {
            // Disable the ability for a user to submit a guess or use the button
            getUserGuess.setEnabled(false);
            getBtn.setEnabled(false);

            // Tell the user they are out of guesses.
            guessOutput.setText("You are out of guesses!");

        }
    }

    // Random number button interaction
    public void btnRandomNumberInteract(View view) {
        // Define the minimum value.
        int minValue;
        // Define the maximum value.
        int maxValue;

        // Grab both the minimum and maximum values
        EditText getMinValue = findViewById(R.id.txtMinimum);
        EditText getMaxValue = findViewById(R.id.txtMaximum);

        // Grab the output box to alert the invidual when the number is generated
        TextView randomNumberGenerated = findViewById(R.id.txtRandomGenerated);

        // Check if the text box is empty
        if (TextUtils.isEmpty(getMinValue.getText().toString())) {
            // Define the error
            getMinValue.setError("Please enter a number");
            return;
        } else {
            // Otherwise grab the number and parse it into a integer
            minValue = Integer.parseInt(getMinValue.getText().toString());
            // Remove the error message
            getMinValue.setError(null);
        }

        // Check if the text box is empty
        if (TextUtils.isEmpty(getMaxValue.getText().toString())) {
            // Define the error
            getMaxValue.setError("Please enter a number");
            return;
        } else {
            // Otherwise grab the number and parse it into a integer
            maxValue = Integer.parseInt(getMaxValue.getText().toString());
            // Remove the error message
            getMaxValue.setError(null);
        }

        // Check if the minimum number is greater than the maximum value, or if it is equal to the maximum value
        if(minValue > maxValue || minValue == maxValue) {
            // Change the text color
            randomNumberGenerated.setTextColor(Color.RED);
            // Request that they provide another set of numbers.
            randomNumberGenerated.setText("Please select a smaller minimum number!");
        } else {
            // Assign the random number a random generated number in an inclusive range
            randomNumber = guess.generateRandomNumber(minValue, maxValue);
            // Set the text color back to grey.
            randomNumberGenerated.setTextColor(Color.DKGRAY);
            // Tell the user that the random number has been generated
            randomNumberGenerated.setText("A random number was generated!");
        }
    }
}