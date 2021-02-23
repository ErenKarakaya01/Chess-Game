import java.util.ArrayList;

public class Queen {
    public static ArrayList<ArrayList<Integer>> options(String[][] board, int x, int y, String myTeam, String opponentTeam) {
        //FINDING OPTIONAL MOVES

        ArrayList<ArrayList<Integer>> options = Bishop.options(board,x,y,myTeam,opponentTeam);//Bishop's optional moves

        ArrayList<ArrayList<Integer>> options2 = Rook.options(board,x,y,myTeam,opponentTeam);//Rook's optional moves

        options.addAll(options2);

        return options;
    }
}