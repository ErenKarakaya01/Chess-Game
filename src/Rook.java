import java.util.ArrayList;
import java.util.Arrays;

public class Rook {
    public static ArrayList<ArrayList<Integer>> options(String[][] board, int x, int y, String myTeam, String opponentTeam) {

        //FINDING OPTIONAL MOVES

        ArrayList<ArrayList<Integer>> options = new ArrayList<ArrayList<Integer>>();

        for (int i = x+1; i <= 7; i++) {
            if (board[y][i].contains(opponentTeam)) {
                options.add(new ArrayList<Integer>(Arrays.asList(i, y)));
                break;
            }
            else if (board[y][i].contains(myTeam))
                break;

            options.add(new ArrayList<Integer>(Arrays.asList(i, y)));
        }
        for (int i = x-1; i >= 0; i--) {
            if (board[y][i].contains(opponentTeam)) {
                options.add(new ArrayList<Integer>(Arrays.asList(i, y)));
                break;
            }
            else if (board[y][i].contains(myTeam))
                break;

            options.add(new ArrayList<Integer>(Arrays.asList(i, y)));
        }
        for (int i = y+1; i <= 7; i++) {
            if (board[i][x].contains(opponentTeam)) {
                options.add(new ArrayList<Integer>(Arrays.asList(x, i)));
                break;
            }
            else if (board[i][x].contains(myTeam))
                break;

            options.add(new ArrayList<Integer>(Arrays.asList(x, i)));
        }
        for (int i = y-1; i >= 0; i--) {
            if (board[i][x].contains(opponentTeam)) {
                options.add(new ArrayList<Integer>(Arrays.asList(x, i)));
                break;
            }
            else if (board[i][x].contains(myTeam))
                break;

            options.add(new ArrayList<Integer>(Arrays.asList(x, i)));
        }

        return options;
    }
}