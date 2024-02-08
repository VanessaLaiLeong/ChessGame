package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * PgnReader
 */
public class PgnReader {
    // Gets a file path from the user by reading from stdin
    public static String getFilePathFromUser() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Insert path to file:");
        String userInput = reader.nextLine();

        reader.close();
        return userInput;
    }

    // Loads a file and returns Scanner object ready to be used
    // to read said file
    public static Scanner loadPgnFile(String filePath) {
        File myFile = new File(filePath);

        // Obligatory try catch to handle files not being found
        try {

            return new Scanner(myFile);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Move> getMoveList(Scanner reader) {
        String[] splitArray = reader.nextLine().split(" ");
        ArrayList<Move> movesList = new ArrayList<>();
        int j = 0;
        int moveNumber;

        for (int i = 0; i < splitArray.length; i++) {
            if (splitArray[i].contains(".")) {
                moveNumber = Integer.parseInt(splitArray[i].replace(".", ""));
                Move newMove = new Move(
                        moveNumber,
                        splitArray[i + 1],
                        splitArray[i + 2]);

                movesList.add(j, newMove);
                j++;
            }
        }
        reader.close();
        return movesList;
    }

    // Converts chess notation into x and y coordinates usable in matrices
    public static int[] convertNotationIntoInt(String notation) {
        String[] array = notation.split("");
        int column = 0, row = 0;
        int[] returnArray = { column, row };

        for (String s : array) {
            switch (s) {
                // colunas:
                case "a" -> column = 0;
                case "b" -> column = 1;
                case "c" -> column = 2;
                case "d" -> column = 3;
                case "e" -> column = 4;
                case "f" -> column = 5;
                case "g" -> column = 6;
                case "h" -> column = 7;

                // linhas:
                case "1" -> row = 7;
                case "2" -> row = 6;
                case "3" -> row = 5;
                case "4" -> row = 4;
                case "5" -> row = 3;
                case "6" -> row = 2;
                case "7" -> row = 1;
                case "8" -> row = 0;
            }
            returnArray[0] = column;
            returnArray[1] = row;
        }

        return returnArray;
    }

    // Converts chess notation into x and y coordinates usable in matrices
    public static String convertIntIntoNotation(int[] coord) {
        String result = "";
        int row = coord[0];
        int col = coord[1];

        switch (row) {
            case 0:
                result += "a";
                break;
            case 1:
                result += "b";
                break;
            case 2:
                result += "c";
                break;
            case 3:
                result += "d";
                break;
            case 4:
                result += "e";
                break;
            case 5:
                result += "f";
                break;
            case 6:
                result += "g";
                break;
            case 7:
                result += "h";
                break;

            default:
                break;
        }

        switch (col) {
            case 0:
                result += "8";
                break;
            case 1:
                result += "7";
                break;
            case 2:
                result += "6";
                break;
            case 3:
                result += "5";
                break;
            case 4:
                result += "4";
                break;
            case 5:
                result += "3";
                break;
            case 6:
                result += "2";
                break;
            case 7:
                result += "1";
                break;

            default:
                break;
        }

        return result;
    }
}
