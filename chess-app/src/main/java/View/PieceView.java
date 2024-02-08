package View;

import Model.*;

public class PieceView {

    public String getPieceSymbol(PieceModel piece) {
        if (piece != null) {
            if (piece.getColor() == "black") {
                String result = "";
                String className = piece.getClass().getSimpleName();
                if (className.equals("BlackPawnModel") || className.equals("WhitePawnModel")) {
                    result = "b" + className.toLowerCase().charAt(0);
                    return result;
                }
                if (className.equals("KnightModel")) {
                    result = "bN";
                    return result;
                }
                result = "b" + piece.getClass().getSimpleName().charAt(0);
                return result;
            } else {
                if (piece.getColor() == "white") {
                    String result = "";
                    String className = piece.getClass().getSimpleName();
                    if (className.equals("BlackPawnModel") || className.equals("WhitePawnModel")) {
                        result = "w" + className.toLowerCase().charAt(0);
                        return result;
                    }
                    if (className.equals("KnightModel")) {
                        result = "wN";
                        return result;
                    }
                    result = "w" + piece.getClass().getSimpleName().charAt(0);
                    return result;
                }
            }
            return " "; // Add symbols for other piece types as needed
        }
        return " "; // Add symbols for other piece types as needed
    }
}


