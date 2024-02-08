package Model;

import java.util.HashMap;

public class QueenModel extends PieceModel{

    public QueenModel(String color){
        super(color);
    }

    @Override
    public HashMap<String, Integer> getPossibleMaxMovements() {
        HashMap<String, Integer> possibleMoves= new HashMap<>();
        possibleMoves.put("U", 8);
        possibleMoves.put("R", 8);
        possibleMoves.put("D", 8);
        possibleMoves.put("L", 8);
        possibleMoves.put("UL", 8);
        possibleMoves.put("UR", 8);
        possibleMoves.put("DR", 8);
        possibleMoves.put("DL", 8);
        return possibleMoves;

    }

}
