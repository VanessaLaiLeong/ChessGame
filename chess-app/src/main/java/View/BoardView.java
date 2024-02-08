package View;

import Model.BoardModel;
import Model.PieceModel;
import Model.SquareModel;

public class BoardView {

    int dim = 8;

    public void printBoard(BoardModel board) {
        SquareModel[][] squares = board.getSquares();
        int boardSize = squares.length;

        // Define the square tile characters
        String blackTile = "\u2B1B"; // Large black square
        String whiteTile = "\u2B1C"; // Large white square

        // System.out.println(" A B C D E F G H");
        for (int row = 0; row < boardSize; row++) {
            System.out.print(8 - row + " ");
            for (int col = 0; col < boardSize; col++) {
                SquareModel square = squares[row][col];
                String tile = (row + col) % 2 == 0 ? whiteTile : blackTile;

                if (square.getOccupyingPiece() != null) {
                    PieceModel piece = square.getOccupyingPiece();
                    PieceView pieceView = new PieceView();
                    String pieceSymbol = pieceView.getPieceSymbol(piece);
                    System.out.print(" " + tile + pieceSymbol);
                } else {
                    System.out.print(" " + tile + "  ");
                }
            }
            System.out.print("\n");
        }
        System.out.println("    A    B    C    D    E    F    G    H");
    }
}
