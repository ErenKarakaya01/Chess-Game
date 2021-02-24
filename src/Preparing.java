public class Preparing {
    //PIECE COLORS
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";

    //BACKGROUNG COLORS
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    //PREPARING BOARD
    public static String[][] getBoard() {
        String[][] board = new String[8][8];

        for (int i=0; i<8; i++)
            for (int j=0; j<8; j++)
                board[i][j] = "";

        String[][] piece_order = {{"♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"},
                                    {"♟", "♟", "♟", "♟", "♟", "♟", "♟", "♟"}};

        for (int i=0; i<2; i++)
            for (int j=0; j<8; j++) {
                board[i][j] = ANSI_BLUE + piece_order[i][j] + ANSI_RESET;
                board[7-i][j] = ANSI_RED + piece_order[i][j] + ANSI_RESET;
            }

        return board;
    }

}
