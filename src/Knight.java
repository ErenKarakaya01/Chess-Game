import java.util.ArrayList;
import java.util.Arrays;

public class Knight {
    public static ArrayList<ArrayList<Integer>> options(String[][] board, int x, int y, String myTeam, String opponentTeam) {

        //FINDING OPTIONAL MOVES

        ArrayList<ArrayList<Integer>> options = new ArrayList<ArrayList<Integer>>();

        int tempX = 1;
        int tempY = 2;

        for (int i=0;i<2;i++) {
            if (x+tempX <= 7 && y-tempY >= 0 && !board[y-tempY][x+tempX].contains(myTeam))
                options.add(new ArrayList<Integer>(Arrays.asList(x+tempX, y-tempY)));

            if (x-tempX >= 0 && y-tempY >= 0 && !board[y-tempY][x-tempX].contains(myTeam))
                options.add(new ArrayList<Integer>(Arrays.asList(x-tempX, y-tempY)));

            if (x-tempX >= 0 && y+tempY <= 7 && !board[y+tempY][x-tempX].contains(myTeam))
                options.add(new ArrayList<Integer>(Arrays.asList(x-tempX, y+tempY)));

            if (x+tempX <= 7 && y+tempY <= 7 && !board[y+tempY][x+tempX].contains(myTeam))
                options.add(new ArrayList<Integer>(Arrays.asList(x+tempX, y+tempY)));

            tempX = 2;
            tempY = 1;
        }

        return options;

    }
}