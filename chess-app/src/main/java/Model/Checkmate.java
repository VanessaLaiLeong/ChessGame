package Model;

import java.util.ArrayList;

public class Checkmate {

    // Finds the king on the board
    // Never call this function unless there is a king on the board
    // if there is no king, this function returns null
    private static SquareModel findKing(BoardModel board) {
        SquareModel result = null;

        for (int i = 0; i < board.getSquares().length; i++) {
            for (int j = 0; j < board.getSquares().length; j++) {
                SquareModel square = board.getSquares()[i][j];
                String currentPiece = "blank";
                try {
                    currentPiece = square
                            .getOccupyingPiece()
                            .getClass()
                            .getName();
                } catch (Exception e) {
                    continue;
                }

                if (!currentPiece.equals("Model.KingModel"))
                    continue;

                result = square;
            }
        }

        return result;
    }

    // Figures out the squares controlled by a piece given a square and board
    private static ArrayList<SquareModel> getSquaresControlled(SquareModel initSquare, BoardModel board) {
        ArrayList<SquareModel> result = new ArrayList<>();
        SquareModel[][] squares = board.getSquares();
        PieceModel currentPiece = initSquare.getOccupyingPiece();
        SquareModel finalSquare;
        String dir;
        boolean valid = false;

        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                finalSquare = squares[i][j];
                dir = board.getMoveDirection(
                        initSquare,
                        finalSquare.getCord().getRow(),
                        finalSquare.getCord().getCol());
                try {
                    valid = board.isValidMove(
                            initSquare,
                            currentPiece,
                            currentPiece.getClass(),
                            finalSquare,
                            dir);
                } catch (Exception e) {
                    continue;
                }

                if (!valid) {
                    continue;
                } else {
                    result.add(finalSquare);
                }
            }
        }

        return result;
    }

    // Checks if the king is in checkmate when it get's checked
    private static boolean isCheckmate(SquareModel initSquare, ArrayList<SquareModel> controlledSquares,
            BoardModel board, SquareModel kingSquare) {
        boolean result = false;
        ArrayList<SquareModel> kingSquares = getSquaresControlled(kingSquare, board);

        if (controlledSquares.containsAll(kingSquares)) {
            result = true;
        }

        return result;
    }

    // Uses the previous functions to find out if the current check
    // is a regular check or a checkmate.
    // result = 0 -> not a check
    // result = 1 -> is only a check
    // result = 2 -> it's checkmate
    public static int isCheck(SquareModel initSquare, BoardModel board) {
        int result = 0;
        SquareModel kingSquare = findKing(board);
        ArrayList<SquareModel> controlledSquares = getSquaresControlled(initSquare, board);

        if (controlledSquares.contains(kingSquare)) {
            result = 1;
            if (isCheckmate(initSquare, controlledSquares, board, kingSquare)) {
                result = 2;
            }
        }

        return result;
    }
}
