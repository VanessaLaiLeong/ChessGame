package Model;

public class SquareModel {

    private final Cordinate coord;
    private final String color;
    private PieceModel occupyingPiece = null;

    public SquareModel(int row, int col, String color) {
        this.coord = new Cordinate(row,col);
        this.color = color;
    }

    public Cordinate getCord(){
        return this.coord;
    }

    public String getColor() {
        return color;
    }


    public void setOccupyingPiece(PieceModel occupyingPiece) {
        this.occupyingPiece = occupyingPiece;
    }

    public PieceModel getOccupyingPiece() {
        return occupyingPiece;
    }

    /*
    *Method to change the piece when moving
    * */
    public void updateSquarePiece(SquareModel currentSquare, SquareModel newSquare){
        newSquare.occupyingPiece = currentSquare.occupyingPiece;
        currentSquare.occupyingPiece = null;
    }


}
