import java.util.ArrayList;
import java.util.Arrays;

public class Bishop {

    public static ArrayList<ArrayList<Integer>> options(String[][] board, int x, int y, String myTeam, String opponentTeam) {
        //FINDING OPTIONAL MOVES

        ArrayList<ArrayList<Integer>> options = new ArrayList<ArrayList<Integer>>();

        int tempX = x;
        int tempY = y;

        tempX++;
        tempY--;

        while (tempX <= 7 && tempY >= 0 && !board[tempY][tempX].contains(myTeam)){
            options.add(new ArrayList<Integer>(Arrays.asList(tempX, tempY)));

            if (board[tempY][tempX].contains(opponentTeam))
                break;

            tempX++;
            tempY--;
        }

        tempX = x;
        tempY = y;

        tempX--;
        tempY--;

        while (tempX >= 0 && tempY >= 0 && !board[tempY][tempX].contains(myTeam)){
            options.add(new ArrayList<Integer>(Arrays.asList(tempX, tempY)));

            if (board[tempY][tempX].contains(opponentTeam))
                break;

            tempX--;
            tempY--;
        }

        tempX = x;
        tempY = y;

        tempX--;
        tempY++;

        while (tempX >= 0 && tempY <= 7 && !board[tempY][tempX].contains(myTeam)){
            options.add(new ArrayList<Integer>(Arrays.asList(tempX, tempY)));

            if (board[tempY][tempX].contains(opponentTeam))
                break;

            tempX--;
            tempY++;
        }

        tempX = x;
        tempY = y;

        tempX++;
        tempY++;

        while (tempX <= 7 && tempY <= 7 && !board[tempY][tempX].contains(myTeam)){
            options.add(new ArrayList<Integer>(Arrays.asList(tempX, tempY)));

            if (board[tempY][tempX].contains(opponentTeam))
                break;

            tempX++;
            tempY++;
        }

        return options;

    }

}