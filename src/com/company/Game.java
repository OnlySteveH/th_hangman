package com.company;

public class Game{
    private String answer;
    private String hits;
    private String misses;

    public Game(String answer) {
        this.answer = answer;
        hits="";
        misses="";
    }

    public boolean applyGuess(char letter) {
        boolean isHit = answer.indexOf(letter) != -1;
        if (isHit) {
            hits += letter;
        } else {
            misses += letter;
        }
        return isHit;
    }

    public static class Hangman {

        public static void main(String[] args) {
            // Your incredible code goes here...
            Game game = new Game("treehouse");

            Prompter prompter = new Prompter(game);

            boolean isHit = prompter.promptForGuess();
            if (isHit) {
                System.out.println("We got a hit!");
            } else {
                System.out.println("Oops missed");
            }
        }
    }
}
