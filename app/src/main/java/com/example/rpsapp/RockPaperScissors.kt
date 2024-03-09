package com.example.rpsapp

import kotlin.system.exitProcess

fun main() {
    val choices = listOf<String>("Rock", "Paper", "Scissors");
    var computerChoice :String;
    var playerChoice: String;

    var firstRound = true;
    do {
        if (!firstRound){
            println("\nDo you want to keep playing? Please enter yes or no!");
            val continuePlay = readln();
            if (continuePlay.lowercase().equals("no")){ println("Thank you for playing! :-)"); exitProcess(0);}
        }
        firstRound = false;

        computerChoice =  choices.get((0..2).random());
        println("Please enter your choice, Rock, Paper or Scissors!");
        playerChoice = readln().lowercase();
        when {
            playerChoice == computerChoice.lowercase() -> printHelper("Tie", playerChoice, computerChoice);
            playerChoice.equals("rock") && computerChoice.lowercase().equals("scissors") -> printHelper("Win", playerChoice, computerChoice);
            playerChoice.equals("paper") && computerChoice.lowercase().equals("rock") -> printHelper("Win", playerChoice, computerChoice);
            playerChoice.equals("scissors") && computerChoice.lowercase().equals("paper") -> printHelper("Win", playerChoice, computerChoice);
            else -> printHelper("LOSE", playerChoice, computerChoice);
        }
    } while (true);
}

fun printHelper(outcome: String, playerChoice: String, computerChoice: String){
    val winMessage = "YOU WON!";
    val tieMessage = "IT'S A TIE"

    val output: String = when {
        outcome == "Win" -> "$winMessage, computer chose: $computerChoice";
        outcome == "Tie" -> "$tieMessage, computer chose: $computerChoice";
        else -> "YOU LOST :-(\ncomputer chose: $computerChoice";
    }
    println(output)
}