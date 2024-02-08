package Model;

import java.util.HashMap;

public class BlackPawnModel extends PieceModel {
    private final HashMap <String, Integer> possibleMoves;


    public BlackPawnModel(String color) {
        super(color);
        possibleMoves = new HashMap<>();
        possibleMoves.put("U", 0);
        possibleMoves.put("R", 0);
        possibleMoves.put("D", 2);
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
            possibleMoves.put("D",val);
        possibleMoves.put(dir,val);
    }


    @Override
    public void setMoves(int moves) {
        super.setMoves(moves);
    }
}
