package Model;

import java.util.HashMap;

public class WhitePawnModel extends PieceModel {
    private final HashMap <String, Integer> possibleMoves;

    public WhitePawnModel(String color) {
        super(color);
        possibleMoves = new HashMap<>();
        possibleMoves.put("U", 2);
        possibleMoves.put("R", 0);
        possibleMoves.put("D", 0);
        possibleMoves.put("L", 0);
        possibleMoves.put("UL", 0);
        possibleMoves.put("UR", 0);
        possibleMoves.put("DR", 0);
        possibleMoves.put("DL", 0);
    }

    @Override
    public HashMap<String, Integer> getPossibleMaxMovements() {
        return possibleMoves;
    }

    @Override
    public void updatePossibleMoves(String dir, int val) {
        if(possibleMoves.get(dir)==null)
            possibleMoves.put("U",1);
        possibleMoves.put(dir,1);
    }


    @Override
    public void setMoves(int moves) {
        super.setMoves(moves);
    }



}
