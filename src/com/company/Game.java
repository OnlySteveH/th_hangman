package com.company;

public class Game{
    private String answer;
    private String hits;
    private String misses;
    private int failCount = 0;
    private String guessProgress;

    public Game(String answer) {
        this.answer = answer;
        hits = "";
        misses = "";
    }

    public String getGuessProgress() {
        return guessProgress;
    }

    public void buildDashes(){
        guessProgress = "";
        for(char c : answer.toCharArray()){
            guessProgress += '-';
        }
    }

    private String addLettersToDashes(char letter){
        char[] progressArray = guessProgress.toCharArray();
        int i = 0;
        for(char c : answer.toCharArray()) {
            if(c == letter) {
                progressArray[i] = letter;
                guessProgress = String.valueOf(progressArray);
            }
            i++;
        }
        return guessProgress;
    }

    public int applyGuess(char letter) {

        int letterPosition = answer.indexOf(letter);
        if (misses.contains(String.valueOf(letter)) ||
                hits.contains(String.valueOf(letter)) ||
                letter == '\0') {
                System.out.printf("You've already guessed that - try again!%n");
        } else {
            if (letterPosition != -1) {
                hits += letter;
                System.out.println("We got a hit!");
            } else {
                misses += letter;
                System.out.println("Oops, missed!");
                failCount++;
                System.out.printf("You have %d guesses left! %n", 5 - failCount);
            }
        }
        System.out.printf("Your word now looks like: %s%n", addLettersToDashes(letter));
        if(!guessProgress.contains("-")){
            System.out.printf("%n%nYOU WIN!!! Congratulations!%n%n");
            Hangman.handleGameRestart();
        }
        return failCount;
    }
}
