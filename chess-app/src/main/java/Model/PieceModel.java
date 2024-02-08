package Model;

import java.util.HashMap;

public abstract class PieceModel {
    private String color;
    private boolean isCaptured = false;
    private String[] possibleMaxMovements;
    private boolean hasMoved = false;

    // The rest will be defined in the children
    public PieceModel(String color) {
        this.color = color;
    }

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    private int moves = 0;


    public void setPossibleMaxMovements(String[] possibleMaxMovements) {
        this.possibleMaxMovements = possibleMaxMovements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCaptured(boolean isCaptured) {
        this.isCaptured = isCaptured;
    }

    //tive de alterar esta funcao pq nao faz muito sentido passar um bool
    //    public boolean checkCaptured(boolean isCaptured) {
    //        if (this.isCaptured) {
    //            return true;
    //        } else {
    //            return false;
    //        }
    //    }

    public boolean checkCaptured() {
        return this.isCaptured;
    }

    abstract public HashMap<String, Integer> getPossibleMaxMovements();

    public void updatePossibleMoves(String dir, int val){}

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }



}