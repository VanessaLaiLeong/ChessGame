package Model;

import java.util.HashMap;
import java.util.Map;

public class KnightModel extends PieceModel{

    public KnightModel(String color){
        super(color);
    }

    @Override
    public HashMap<String, Integer> getPossibleMaxMovements(){
        return null;
    }

    public int getPossibleMoves(boolean hasMoved) {
        return 8;
    }
}
