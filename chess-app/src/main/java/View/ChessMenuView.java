package View;

import java.util.Scanner;

public class ChessMenuView {

    public void printMenu() {
        System.out.println("Chess Game Menu:");
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
    }

    public void printChooseName(int player){

        if(player == 1)
            System.out.print("Enter the name of the player for white pieces: ");
        else if(player==2)
            System.out.print("Enter the name of the player for black pieces: ");
    }
     public void printStartGame(String whitePlayer,String blackPlayer){
         System.out.println("Starting the game with " + whitePlayer + " vs " + blackPlayer);
     }

    public void printExit(){
        System.out.println("Exiting the game. Goodbye!");
    }

    public void printInvalid(){
        System.out.println("Invalid choice. Please try again.");
    }



}
