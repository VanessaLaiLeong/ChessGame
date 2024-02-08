package Model;

import java.util.HashMap;
import java.util.Map;

public class BishopModel extends PieceModel{

    public BishopModel(String color){
        super(color);
    }

    @Override
    public HashMap<String, Integer> getPossibleMaxMovements() {
        HashMap<String, Integer> possibleMoves= new HashMap<>();
        possibleMoves.put("U", 0);
        possibleMoves.put("R", 0);
        possibleMoves.put("D", 0);
        possibleMoves.put("L", 0);
        possibleMoves.put("UL", 8);
        possibleMoves.put("UR", 8);
        possibleMoves.put("DR", 8);
        possibleMoves.put("DL", 8);
        return possibleMoves;
    }


}
