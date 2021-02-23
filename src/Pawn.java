import java.util.ArrayList;
import java.util.Arrays;

public class Pawn {
    public static ArrayList<ArrayList<Integer>> options(String[][] board, int x, int y, String myTeam, String opponentTeam) {

        //FINDING OPTIONAL MOVES

        ArrayList<ArrayList<Integer>> options = new ArrayList<ArrayList<Integer>>();

        if (myTeam.contains(Preparing.ANSI_RED) && y != 0) {
            if (board[y-1][x] == "")
                options.add(new ArrayList<Integer>(Arrays.asList(x, y-1)));

            if (x != 7 && board[y-1][x+1].contains(opponentTeam))
                options.add(new ArrayList<Integer>(Arrays.asList(x+1, y-1)));

            if (x != 0 && board[y-1][x-1].contains(opponentTeam))
                options.add(new ArrayList<Integer>(Arrays.asList(x-1, y-1)));

            if (y == 6 && board[y-2][x] == "" && board[y-1][x] == "")
                options.add(new ArrayList<Integer>(Arrays.asList(x, y-2)));
        }

        else if (myTeam.contains(Preparing.ANSI_BLUE) && y != 7) {
            if (board[y+1][x] == "")
                options.add(new ArrayList<Integer>(Arrays.asList(x, y+1)));

            if (x != 0 && board[y+1][x-1].contains(opponentTeam))
                options.add(new ArrayList<Integer>(Arrays.asList(x-1, y+1)));

            if (x != 7 && board[y+1][x+1].contains(opponentTeam))
                options.add(new ArrayList<Integer>(Arrays.asList(x+1, y+1)));

            if (y == 1 && board[y+2][x] == "" && board[y+1][x] == "")
                options.add(new ArrayList<Integer>(Arrays.asList(x, y+2)));
        }

        return options;

    }
}