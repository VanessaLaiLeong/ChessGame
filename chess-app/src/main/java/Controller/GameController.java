package Controller;

import java.util.Scanner;

import Model.*;
import View.*;

public class GameController {
    ChessMenuView menuView = new ChessMenuView();
    BoardModel board;
    GameView gameView;
    PlayerModel player1;
    PlayerModel player2;
    String nameP1;
    String nameP2;

    public static void main(String[] args) {
        GameController game = new GameController();

        game.Init();
    }

    private void Init() {
        while (true) {
            int choice = menu();
            if (choice == 1) {
                setGame();
                play();
                break;
            }
        }
    }

    public int menu() {
        Scanner scanner = new Scanner(System.in);

        menuView.printMenu();
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                scanner.nextLine(); // Consume the newline character
                menuView.printChooseName(1);
                nameP1 = scanner.nextLine();
                menuView.printChooseName(2);
                nameP2 = scanner.nextLine();
                menuView.printStartGame(nameP1, nameP2);
                break;
            case 2:
                menuView.printExit();
                scanner.close();
                System.exit(0);
                break;
            default:
                menuView.printInvalid();
        }
        return choice;
    }

    private void setGame() {
        board = new BoardModel();
        gameView = new GameView();
        player1 = new PlayerModel(nameP1, board.getPiecesPlayer(1), "white");
        player2 = new PlayerModel(nameP2, board.getPiecesPlayer(2), "black");

    }

    private void play() {
        Scanner scanner = new Scanner(System.in);
        int iniRow, iniCol, finalRow, finalCol;
        PlayerModel playerTurn = player1;

        while (true) {
            gameView.printBoard(board);

            System.out.println(playerTurn.getName() + ": Insert coord->");
            String coordIni = scanner.nextLine().toLowerCase();

            iniCol = getPlayerCol(coordIni);
            iniRow = getPlayerRow(coordIni);

            System.out.println(playerTurn.getName() + ": Where to move->");
            String coordFinal = scanner.nextLine().toLowerCase();

            finalCol = getPlayerCol(coordFinal);
            finalRow = getPlayerRow(coordFinal);

            // Statement returns false when move isn't valid
            if (board.movePiece(iniRow, iniCol, finalRow, finalCol, playerTurn))
                playerTurn = playerTurn.getName().equals(player1.getName()) ? player2 : player1;

            // Check for checks and checkmates:
            if (board.isKingCaptured()) {
                System.out.println("Game is over");
                scanner.close();
                break;
            }
        }
    }

    private int getPlayerCol(String coord) {
        int[] myArray = PgnReader.convertNotationIntoInt(coord);
        if (myArray.length > 0) {
            return myArray[0];
        } else
            return 0;
    }

    private int getPlayerRow(String coord) {
        int[] myArray2 = PgnReader.convertNotationIntoInt(coord);
        if (myArray2.length > 0) {
            return myArray2[1];
        } else
            return 0;
    }
}
