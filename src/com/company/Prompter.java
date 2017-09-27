package com.company;

import java.util.Scanner;

class Prompter {

    private Game game;

    public Prompter(Game game) {
        this.game = game;
    }

    public int promptForGuess() {
        char guess = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter a letter:  %n%n");
        String guessInput = scanner.nextLine().toLowerCase();
        try {
            guess = guessInput.charAt(0);
        } catch (Exception exc){
            System.out.printf("Something went wrong - try again! ... %n");
            promptForGuess();
        }
        return game.applyGuess(guess);
    }
}