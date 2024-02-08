package Model;

import java.util.HashMap;
import java.util.Map;

public class RookModel extends PieceModel{
    public RookModel(String color){
        super(color);
    }

    @Override
    public HashMap<String, Integer> getPossibleMaxMovements(){
        HashMap<String, Integer> possibleMoves= new HashMap<>();
        possibleMoves.put("U", 8);
        possibleMoves.put("R", 8);
        possibleMoves.put("D", 8);
        possibleMoves.put("L", 8);
        possibleMoves.put("UL", 0);
        possibleMoves.put("UR", 0);
        possibleMoves.put("DR", 0);
        possibleMoves.put("DL", 0);
        return possibleMoves;
    }

}
