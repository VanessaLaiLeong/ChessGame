package Model;

public class Cordinate {
    private final int col;
    private final int row;

    public Cordinate(int row, int col){
        this.row = row;
        this.col = col;
    }


    /*
    * Method to get the distance between the final row of the new position to the current row
    * */
    public int getDistanceRow(int finRow){
        int val = finRow - row;
        //int ret = val > 0 ?  val : -1 * val;
        return val;
    }
    /*
     * Method to get the distance between the final col of the new position to the current row
     * */
    public int getDistanceCol(int finCol) {
        int val = finCol - col;
        //int ret = val > 0 ? val : -1 * val;
        return val;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}
