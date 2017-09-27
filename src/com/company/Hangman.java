package com.company;


import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        Game game = new Game("treehouse");
        int repeat;
        Prompter prompter = new Prompter(game);
        System.out.printf("Welcome to HANGMAN!%n%n");
        game.buildDashes();
        System.out.printf("Here's your word: %s%n", game.getGuessProgress());
        do {
            repeat = prompter.promptForGuess();
        }while(repeat < 5);
        System.out.printf("%nGAME OVER!%n");
        handleGameRestart();
    }

    public static void handleGameRestart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Y to start a new game: ");
        String restart = scanner.nextLine().toLowerCase();
        restart = String.valueOf(restart.charAt(0));
        if(restart.equals("y")){
            System.out.printf("Entered: %s%n", restart);
            main(new String[0]);
        } else{
            System.exit(0);
        }
    }
}