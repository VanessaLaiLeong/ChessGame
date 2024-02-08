package View;

import Model.BoardModel;

import java.util.Locale;
import java.util.Scanner;

public class GameView {
    BoardView view;
    public GameView(){
        view = new BoardView();
    }

    public void printBoard(BoardModel boardModel){
        view.printBoard(boardModel);
    }

    public void printWhitePicecesTurn() {
        System.out.println("White Piceces turn:");
    }

    public static void impossibleMove(){
        System.out.println("This move is not Valid!");
    }

    public static void emptySquare(){
        System.out.println("There's no piece in that square");
    }


}
