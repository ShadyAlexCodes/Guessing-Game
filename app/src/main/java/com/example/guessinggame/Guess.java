package com.example.guessinggame;

public class Guess {

    public String checkGuess(int userGuess, int randomNumber) {

        if (userGuess < randomNumber) {
            System.out.println("A");
            return "Your guess was too low!";
        } else if (userGuess > randomNumber) {
            System.out.println("B");
            return "Your guess was too high!";
        } else {
            System.out.println("C");
            return "Your guess was perfect!";
        }
    }

    public int generateRandomNumber(int minValue, int maxValue) {
        return (int) Math.floor(Math.random() * (maxValue - minValue + 1) + minValue);
    }

}
