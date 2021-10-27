package com.example.guessinggame;

public class Guess {

    int guesses = 3;

    public String checkGuess(int userGuess, int randomNumber) {
        System.out.println("NOG: " + guesses);
        if(guesses >= 0) {
            if (userGuess < randomNumber) {
                System.out.println("A");
                guesses--;
                return "Your guess was too low!\n You now have " + guesses + " left!";
            } else if (userGuess > randomNumber) {
                System.out.println("B");
                guesses--;
                return "Your guess was too high!\n You now have " + guesses + " left!";
            } else {
                System.out.println("C");
                return "Your guess was perfect!";
            }
        } else {
            return "You are out of guesses!";
        }
    }

    public int generateRandomNumber(int minValue, int maxValue) {
        return (int) Math.floor(Math.random() * (maxValue - minValue + 1) + minValue);
    }

}
