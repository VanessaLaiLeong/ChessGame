package Model;

import java.util.HashMap;
import java.util.Map;

public class KingModel extends PieceModel {

    public KingModel(String color){
        super(color);
    }

    /*
    * Keys: U for up, D for down, R for right, L for left
    * Value: number of square that the piece can move in each movement
    * (considering any position of the piece as well and if the boar was empty)
    * */
    @Override
    public HashMap<String, Integer> getPossibleMaxMovements() {
        HashMap<String, Integer> possibleMoves= new HashMap<>();
        possibleMoves.put("U", 1);
        possibleMoves.put("R", 1);
        possibleMoves.put("D", 1);
        possibleMoves.put("L", 1);
        possibleMoves.put("UL", 1);
        possibleMoves.put("UR", 1);
        possibleMoves.put("DR", 1);
        possibleMoves.put("DL", 1);
        return possibleMoves;
    }


}
