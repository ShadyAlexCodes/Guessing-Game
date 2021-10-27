package com.example.guessinggame;

public class Guess {

    // Define the total number of guesses
    int guesses = 3;

    // Create a returnable string
    public String checkGuess(int userGuess, int randomNumber) {
        // Check if the guess is less than 0
        if(guesses > 0) {
            // Check if the user guess is less than the random number
            if (userGuess < randomNumber) {
                // Remove the total number of guesses left
                guesses--;

                // Inform the user their guess was too low and how many they have left
                return "Your guess was too low!\n You now have " + guesses + " left!";
            }
            // Check if the users guess is higher than the random number.
            else if (userGuess > randomNumber) {
                // Remove the total number of guesses left
                guesses--;
                // Inform the user their guess is too high and how many they have left
                return "Your guess was too high!\n You now have " + guesses + " left!";
            } else {
                // Set the count to negative one.
                guesses = -1;

                // Inform the user that their guess was perfect!
                return "Your guess was perfect!";
            }
        } else {
            // Yell at them that they're out of guesses!
            return "You are out of guesses!";
        }
    }

    // Generate a random number
    public int generateRandomNumber(int minValue, int maxValue) {
        return (int) Math.floor(Math.random() * (maxValue - minValue + 1) + minValue);
    }

}
