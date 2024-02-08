package Model;

import View.GameView;

import java.util.ArrayList;
import java.util.Objects;

public class BoardModel {
    private final int dim = 8;
    private SquareModel[][] squares;
    // Using lists because it's better for indexing
    private final ArrayList<PieceModel> piecesPlayer1;
    private final ArrayList<PieceModel> piecesPlayer2;

    public BoardModel() {
        squares = new SquareModel[dim][dim];
        piecesPlayer1 = new ArrayList<>();
        piecesPlayer2 = new ArrayList<>();
        setBoard();
        setPieces();
    }

    /*
     * Method to set the board
     */
    public void setBoard() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {

                if ((i + j) % 2 == 0) {
                    squares[i][j] = new SquareModel(i, j, "WHITE");
                } else {
                    squares[i][j] = new SquareModel(i, j, "BLACK");
                }
            }
        }
    }

    /*
     * Method to set the pieces in the board
     */
    public void setPieces() {
        setPawn();
        setRook();
        setKnight();
        setBishop();
        setQueen();
        setKing();
    }

    /*
     * Method to set pawn pieces
     */
    private void setPawn() {
        // setting pieces for player1 aka white
        for (int col = 0; col < dim; col++) {
            WhitePawnModel pawn = new WhitePawnModel("white");
            piecesPlayer1.add(pawn);
            squares[6][col].setOccupyingPiece(piecesPlayer1.get(piecesPlayer1.size() - 1));
            // System.out.println(squares[6][col].getOccupyingPiece());
        }

        // setting pieces for player2 aka black
        for (int col = 0; col < dim; col++) {
            BlackPawnModel pawn = new BlackPawnModel("black");
            piecesPlayer2.add(pawn);
            squares[1][col].setOccupyingPiece(piecesPlayer2.get(piecesPlayer2.size() - 1));
            // System.out.println(squares[6][col].getOccupyingPiece());
        }
    }

    /*
     * Method to set rook pieces
     */
    private void setRook() {
        // setting rook pieces for player1
        RookModel rook1 = new RookModel("white");
        piecesPlayer1.add(rook1);
        squares[7][0].setOccupyingPiece(piecesPlayer1.get(piecesPlayer1.size() - 1));
        // System.out.println(squares[7][0]);

        RookModel rook2 = new RookModel("white");
        piecesPlayer1.add(rook2);
        squares[7][7].setOccupyingPiece(piecesPlayer1.get(piecesPlayer1.size() - 1));

        // setting rook pieces for player2
        RookModel rook3 = new RookModel("black");
        piecesPlayer2.add(rook3);
        squares[0][0].setOccupyingPiece(piecesPlayer2.get(piecesPlayer2.size() - 1));

        RookModel rook4 = new RookModel("black");
        piecesPlayer2.add(rook4);
        squares[0][7].setOccupyingPiece(piecesPlayer2.get(piecesPlayer2.size() - 1));
    }

    /*
     * Method to set knight pieces
     */
    private void setKnight() {
        // setting night pieces for player1
        KnightModel knight1 = new KnightModel("white");
        piecesPlayer1.add(knight1);
        squares[7][1].setOccupyingPiece(piecesPlayer1.get(piecesPlayer1.size() - 1));

        KnightModel knight2 = new KnightModel("white");
        piecesPlayer1.add(knight2);
        squares[7][6].setOccupyingPiece(piecesPlayer1.get(piecesPlayer1.size() - 1));

        // setting night pieces for player2
        KnightModel knight3 = new KnightModel("black");
        piecesPlayer2.add(knight3);
        squares[0][1].setOccupyingPiece(piecesPlayer2.get(piecesPlayer2.size() - 1));

        KnightModel knight4 = new KnightModel("black");
        piecesPlayer2.add(knight4);
        squares[0][6].setOccupyingPiece(piecesPlayer2.get(piecesPlayer2.size() - 1));
    }

    /*
     * Method to set bishop pieces
     */
    private void setBishop() {
        // setting bishop for player1
        BishopModel bishop1 = new BishopModel("white");
        piecesPlayer1.add(bishop1);
        squares[7][2].setOccupyingPiece(piecesPlayer1.get(piecesPlayer1.size() - 1));

        BishopModel bishop2 = new BishopModel("white");
        piecesPlayer1.add(bishop2);
        squares[7][5].setOccupyingPiece(piecesPlayer1.get(piecesPlayer1.size() - 1));

        // setting bishop for player2
        BishopModel bishop3 = new BishopModel("black");
        piecesPlayer2.add(bishop3);
        squares[0][2].setOccupyingPiece(piecesPlayer2.get(piecesPlayer2.size() - 1));

        BishopModel bishop4 = new BishopModel("black");
        piecesPlayer2.add(bishop4);
        squares[0][5].setOccupyingPiece(piecesPlayer2.get(piecesPlayer2.size() - 1));
    }

    /*
     * Method to set queen pieces
     */
    private void setQueen() {
        // setting queen for player1
        QueenModel queen1 = new QueenModel("white");
        piecesPlayer1.add(queen1);
        squares[7][3].setOccupyingPiece(piecesPlayer1.get(piecesPlayer1.size() - 1));
        // setting queen for player2
        QueenModel queen2 = new QueenModel("black");
        piecesPlayer2.add(queen2);
        squares[0][3].setOccupyingPiece(piecesPlayer2.get(piecesPlayer2.size() - 1));
    }

    /*
     * Method to set king pieces
     */
    private void setKing() {
        // setting king for player1
        KingModel king1 = new KingModel("white");
        piecesPlayer1.add(king1);
        squares[7][4].setOccupyingPiece(piecesPlayer1.get(piecesPlayer1.size() - 1));
        // setting king for player2
        KingModel king2 = new KingModel("black");
        piecesPlayer2.add(king2);
        squares[0][4].setOccupyingPiece(piecesPlayer2.get(piecesPlayer2.size() - 1));
    }

    /*
     * Method to move pieces
     */
    public Boolean movePiece(int curRow, int curCol, int finalRow, int finalCol, PlayerModel playerTurn) {
        SquareModel currentSquare = getSquareByPosition(curRow, curCol);
        PieceModel currentPiece = currentSquare.getOccupyingPiece();
        if (currentPiece == null) {
            GameView.emptySquare();
            return false;
        }
        if (!currentPiece.getColor().equals(playerTurn.getColor())) {
            GameView.impossibleMove();
            return false;
        }
        SquareModel finalSquare = getSquareByPosition(finalRow, finalCol);
        String dir = getMoveDirection(currentSquare, finalRow, finalCol);
        Class<?> pieceClass = currentPiece.getClass();
        if (pieceClass.equals(KnightModel.class)) {
            if (!isKnightMoveValid(currentSquare, finalSquare, currentPiece)) {
                GameView.impossibleMove();
                return false;
            }
        } else {
            if (!isValidMove(currentSquare, currentPiece, pieceClass, finalSquare, dir)) {
                GameView.impossibleMove();
                return false;
            }
        }
        updatePawnAfterFirstMove(currentPiece, pieceClass, curRow);
        if (finalSquare.getOccupyingPiece() != null) {
            finalSquare.getOccupyingPiece().setCaptured(true);
        }
        currentSquare.updateSquarePiece(currentSquare, finalSquare);
        return true;
    }

    /*
     * Method to get the current square based on the row and col
     */
    public SquareModel getSquareByPosition(int row, int col) {
        squares = getSquares();
        for (SquareModel[] square : squares) {
            for (SquareModel squareModel : square) {
                if (squareModel.getCord().getRow() == row && squareModel.getCord().getCol() == col) {
                    return squareModel;
                }
            }
        }
        return null;
    }

    /*
     * Method to get directions of the move that the player is making,
     * if the row is < 0 then if moves up "U"
     * if the row is > 0 then if moves down "D"
     * if the col is < 0 then if moves left "L"
     * if the col is > 0 then if moves right "R"
     */
    public String getMoveDirection(SquareModel square, int finalRow, int finalCol) {
        Cordinate cord = square.getCord();
        int rowMov = cord.getDistanceRow(finalRow);
        int colMov = cord.getDistanceCol(finalCol);
        String direction = "";
        if (rowMov < 0 && colMov == 0)
            direction += "U";
        if (colMov > 0 && rowMov < 0)
            direction += "UR";
        if (colMov < 0 && rowMov < 0)
            direction += "UL";
        if (rowMov > 0 && colMov == 0)
            direction += "D";
        if (colMov > 0 && rowMov > 0)
            direction += "DR";
        if (colMov < 0 && rowMov > 0)
            direction += "DL";
        if (colMov < 0 && rowMov == 0)
            direction += "L";
        if (colMov > 0 && rowMov == 0)
            direction += "R";
        return direction;
    }

    /*
     * Method to validate knight movement
     */
    private boolean isKnightMoveValid(SquareModel currentSquare, SquareModel finalSquare, PieceModel piece) {
        Cordinate curCord = currentSquare.getCord();
        Cordinate finalCord = finalSquare.getCord();
        int rowDiff = Math.abs(curCord.getRow() - finalCord.getRow());
        int colDiff = Math.abs(curCord.getCol() - finalCord.getCol());
        // verifying if there's a same color piece in the square that we want to play
        if (isFinalSquareObstructed(piece, finalSquare)) {
            return false;
        }
        // verifying if the movement is in L shape for all directions
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }

    /*
     * Verifies if the final square is either empty or has a pieces of the other
     * player that can be eaten
     * if return true then is a piece with the same color
     * else return false, meaning that is not obstructed
     */
    public Boolean isFinalSquareObstructed(PieceModel piece, SquareModel finalSquare) {
        String finalSquareColor = checkFinalSquarePieceColor(finalSquare);
        Class<? extends PieceModel> pieceClass = piece.getClass();
        if (!finalSquareColor.isEmpty() && pieceClass != BlackPawnModel.class && pieceClass != WhitePawnModel.class) {
            return Objects.equals(piece.getColor(), finalSquareColor);
        }
        return false;
    }

    /*
     * this method verifies if the final (where the piece is going when moved) color
     * of the piece
     */
    public String checkFinalSquarePieceColor(SquareModel finalSquare) {
        PieceModel piece = finalSquare.getOccupyingPiece();
        if (piece == null) {
            return "";
        } else {
            return piece.getColor();
        }
    }

    /*
     * Method that verifies if the move is valid
     * by evaluating the necessary steps to get to the destination
     * square form the given initial square.
     */
    public boolean isValidMove(SquareModel initSquare, PieceModel currentPiece, Class<?> pieceClass,
            SquareModel finalSquare, String dir) {
        Cordinate initCord = initSquare.getCord();
        Cordinate finalCord = finalSquare.getCord();
        int finalRow = finalCord.getRow();
        int finalCol = finalCord.getCol();

        // checking if final row is outside the board
        if (finalRow < 0 || finalRow > 7)
            return false;

        updatePawnDiagonal(pieceClass, currentPiece, finalSquare, dir, 1);
        int maxMoves = currentPiece.getPossibleMaxMovements().get(dir);

        // if the direction we want the moves are 0, meaning it can not do on that
        // direction, return false
        if (maxMoves == 0)
            return false;
        if (isMoveObstructed(initSquare, finalRow, finalCol, dir))
            return false;
        if (isFinalSquareObstructed(currentPiece, finalSquare))
            return false;
        // verifying the pieces that have limited moves in the board
        if (!isDistanceValid(initCord, pieceClass, finalRow, finalCol, maxMoves, dir))
            return false;
        updatePawnDiagonal(pieceClass, currentPiece, finalSquare, dir, 0);
        return true;
    }

    /*
     * update pawn map if pawn wants to eat enemy piece
     */
    private void updatePawnDiagonal(Class<?> pieceClass, PieceModel currentPiece, SquareModel finalSquare, String dir,
            int newVal) {
        if (pieceClass.equals(BlackPawnModel.class) && (dir.equals("DR") || dir.equals("DL"))) {
            // verifying of the piece that is in the diagonal is another color
            if (!checkFinalSquarePieceColor(finalSquare).equals(currentPiece.getColor()))
                currentPiece.updatePossibleMoves(dir, newVal);
        }
        if (pieceClass.equals(WhitePawnModel.class) && (dir.equals("UR") || dir.equals("UL"))) {
            // verifying of the piece that is in the diagonal is another color
            if (!checkFinalSquarePieceColor(finalSquare).equals(currentPiece.getColor()))
                currentPiece.updatePossibleMoves(dir, newVal);
        }
    }

    /*
     * verifies if there's any piece in the path of the movement
     * if there's a piece in the path between the initial position and the final
     * position returns true
     */
    public Boolean isMoveObstructed(SquareModel currSquare, int finalRow, int finalCol, String direction) {
        int iniRow = currSquare.getCord().getRow();
        int iniCol = currSquare.getCord().getCol();
        int rowDist = currSquare.getCord().getDistanceRow(finalRow);
        int colDist = currSquare.getCord().getDistanceCol(finalCol);
        int finalRowDist = iniRow + rowDist;
        int finalColDist = iniCol + colDist;

        switch (direction) {
            case "D":
                for (int i = iniRow + 1; i < finalRowDist; i++) {
                    if (squares[i][iniCol].getOccupyingPiece() != null) {
                        return true;
                    }
                }
                break;
            case "U":
                for (int i = iniRow - 1; i > finalRowDist; i--) {
                    if (squares[i][iniCol].getOccupyingPiece() != null) {
                        return true;
                    }
                }
                break;
            case "L":
                for (int i = iniCol - 1; i > finalColDist; i--) {
                    if (squares[iniRow][i].getOccupyingPiece() != null) {
                        return true;
                    }
                }
                break;
            case "R":
                for (int i = iniCol + 1; i < finalColDist; i++) {

                    if (squares[iniRow][i].getOccupyingPiece() != null) {
                        return true;
                    }
                }
                break;
            case "UR": // Up-Right
                for (int i = iniRow - 1, j = iniCol + 1; i > (finalRowDist) && j <= finalColDist; i--, j++) {
                    if (squares[i][j].getOccupyingPiece() != null) {
                        return true;
                    }
                }
                break;
            case "UL": // Up-Left
                for (int i = iniRow - 1, j = iniCol - 1; i > (finalRowDist) && j >= (finalColDist); i--, j--) {
                    if (squares[i][j].getOccupyingPiece() != null) {
                        return true;
                    }
                }
                break;
            case "DR": // Down-Right
                for (int i = iniRow + 1, j = iniCol + 1; i < (finalRowDist) && j <= (finalColDist); i++, j++) {
                    if (squares[i][j].getOccupyingPiece() != null) {
                        return true;
                    }
                }
                break;
            case "DL": // Down-Left
                for (int i = iniRow + 1, j = iniCol - 1; i < finalRowDist && j >= (finalColDist); i++, j--) {
                    if (squares[i][j].getOccupyingPiece() != null) {
                        return true;
                    }
                }
                break;
        }
        return false; // No obstruction found
    }

    /*
     * this method verifies if the distance that the player wants to play is
     * allowed by the distance that the piece can make in that direction
     */
    public boolean isDistanceValid(Cordinate cord, Class<?> pieceType, int finalRow, int finalCol, int maxDist,
            String dir) {
        if (pieceType.equals(KnightModel.class))
            return false;
        // calculating distance that player wants to play
        int rowMov = cord.getDistanceRow(finalRow);
        int colMov = cord.getDistanceCol(finalCol);
        if (dir.equals("U") || dir.equals("L")) {
            rowMov *= -1;
            colMov *= -1;
        }
        return rowMov <= maxDist && colMov <= maxDist;
    }

    /*
     * Method to get each player pieces
     * Param playerNum: can either be 1 or 2 - for testing
     */
    public ArrayList<PieceModel> getPiecesPlayer(int playerNum) {
        if (playerNum == 1)
            return piecesPlayer1;
        else
            return piecesPlayer2;
    }

    /*
     * Method to get squares
     */
    public SquareModel[][] getSquares() {
        return this.squares;
    }

    /*
     * update pawn map after pawn 1st movement
     */
    private void updatePawnAfterFirstMove(PieceModel currentPiece, Class<?> pieceType, int curRow) {
        if ((pieceType.equals(BlackPawnModel.class) && curRow == 1) ||
                (pieceType.equals(WhitePawnModel.class) && curRow == 6)) {
            currentPiece.updatePossibleMoves(" ", 1);
        }
    }

    public SquareModel getSquareByCoord(int[] coord, BoardModel board) {
        SquareModel result = null;
        SquareModel[][] squares = board.getSquares();

        for (SquareModel[] square : squares) {
            for (int j = 0; j < squares.length; j++) {
                SquareModel element = square[j];

                if (element.getCord().getCol() == coord[1] && element.getCord().getRow() == coord[0]) {
                    result = element;
                }
            }
        }

        return result;
    }

    public boolean isKingCaptured() {
        for (PieceModel piece : piecesPlayer1) {
            if (piece.getClass().equals(KingModel.class) && piece.checkCaptured() == true) {
                return true;
            }
        }
        for (PieceModel piece : piecesPlayer2) {
            if (piece.getClass().equals(KingModel.class) && piece.checkCaptured() == true) {
                return true;
            }
        }
        return false;
    }
}
