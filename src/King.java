import java.util.ArrayList;
import java.util.Arrays;

public class King {
    public static ArrayList<ArrayList<Integer>> options(String[][] board, int x, int y, String myTeam, String opponentTeam) {
        ArrayList<ArrayList<Integer>> options = new ArrayList<ArrayList<Integer>>();
        //X, Y
        int[][] check = {{1,-1},
                {0,-1},
                {-1,-1},
                {-1,0},
                {-1,1},
                {0,1},
                {1,1},
                {1,0}};

        for (int[] i:check)
            if (i[0]+x <= 7 && i[0]+x >= 0 && i[1]+y <= 7 && i[1]+y >= 0 && !board[i[1]+y][i[0]+x].contains(myTeam))
                options.add(new ArrayList<Integer>(Arrays.asList(i[0]+x, i[1]+y)));

        return options;
    }
}