package Model;

import java.util.ArrayList;

public class PlayerModel {

    private final ArrayList<PieceModel> pieces;
    private String name;

    private final String color;

    public PlayerModel(String name, ArrayList<PieceModel> pieces, String color) {
        this.name = name;
        this.pieces = pieces;
        this.color = color;
    }

    public ArrayList<PieceModel> getPieces() {
        return pieces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

}
