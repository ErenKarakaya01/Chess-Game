import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    //This method converts a char to integer based on the game board
    public static int convert(char letter) {
        HashMap<Character, Integer> toInteger = new HashMap<Character, Integer>();

        toInteger.put('A', 0);
        toInteger.put('B', 1);
        toInteger.put('C', 2);
        toInteger.put('D', 3);
        toInteger.put('E', 4);
        toInteger.put('F', 5);
        toInteger.put('G', 6);
        toInteger.put('H', 7);

        return toInteger.get(letter);
    }

    //This method converts an integer to char based on the game board
    public static char convert(int integer) {
        HashMap<Integer, Character> toCharacter = new HashMap<Integer, Character>();

        toCharacter.put(0, 'A');
        toCharacter.put(1, 'B');
        toCharacter.put(2, 'C');
        toCharacter.put(3, 'D');
        toCharacter.put(4, 'E');
        toCharacter.put(5, 'F');
        toCharacter.put(6, 'G');
        toCharacter.put(7, 'H');

        return toCharacter.get(integer);
    }

    //SHOWING BOARD
    public static void showBoard(String[][] board, String myTeam) {
        if (myTeam.equals(Preparing.ANSI_RED)) {
            System.out.println("   |  A |  B |  C |  D | E |  F |  G |  H |");

            String background = Preparing.ANSI_WHITE_BACKGROUND;

            for (int i=0; i<8; i++) {
                System.out.print(" " + (8-i) + " |");

                for (int j=0; j<8; j++) {

                    if (board[i][j].equals("")) {
                        if (background.equals(Preparing.ANSI_BLACK_BACKGROUND))
                            //This pawn symbol is here just to collimate the board
                            System.out.print(" " + background + Preparing.ANSI_BLACK + "♟" + Preparing.ANSI_RESET + " |");
                        else
                            System.out.print(" " + background + Preparing.ANSI_WHITE + "♟" + Preparing.ANSI_RESET + " |");
                    }

                    else
                        System.out.print(" " + background + board[i][j] + Preparing.ANSI_RESET + " |");

                    if (background.equals(Preparing.ANSI_WHITE_BACKGROUND))
                        background = Preparing.ANSI_BLACK_BACKGROUND;
                    else
                        background = Preparing.ANSI_WHITE_BACKGROUND;
                }
                if (background.equals(Preparing.ANSI_WHITE_BACKGROUND))
                    background = Preparing.ANSI_BLACK_BACKGROUND;
                else
                    background = Preparing.ANSI_WHITE_BACKGROUND;

                System.out.println(Preparing.ANSI_RESET + "\n-------------------------------------------");
            }
        }

        else {
            System.out.println("   |  H |  G |  F |  E | D |  C |  B |  A |");

            String background = Preparing.ANSI_WHITE_BACKGROUND;

            for (int i=7; i>=0; i--) {
                System.out.print(" " + (8-i) + " |");

                for (int j=7; j>=0; j--) {

                    if (board[i][j].equals("")) {
                        if (background.equals(Preparing.ANSI_BLACK_BACKGROUND))
                            System.out.print(" " + background + Preparing.ANSI_BLACK + "♟" + Preparing.ANSI_RESET + " |");
                        else
                            System.out.print(" " + background + Preparing.ANSI_WHITE + "♟" + Preparing.ANSI_RESET + " |");
                    }

                    else
                        System.out.print(" " + background + board[i][j] + Preparing.ANSI_RESET + " |");

                    if (background.equals(Preparing.ANSI_WHITE_BACKGROUND))
                        background = Preparing.ANSI_BLACK_BACKGROUND;
                    else
                        background = Preparing.ANSI_WHITE_BACKGROUND;
                }
                if (background.equals(Preparing.ANSI_WHITE_BACKGROUND))
                    background = Preparing.ANSI_BLACK_BACKGROUND;
                else
                    background = Preparing.ANSI_WHITE_BACKGROUND;

                System.out.println(Preparing.ANSI_RESET + "\n-------------------------------------------");
            }
        }
    }

    //SHOWING BOARD WITH POTENTIAL MOVE(S)
    public static void showBoardWithMoves(String[][] board, String myTeam, ArrayList<ArrayList<Integer>> options) {
        if (myTeam.equals(Preparing.ANSI_RED)) {
            System.out.println("   |  A |  B |  C |  D | E |  F |  G |  H |");

            String background = Preparing.ANSI_WHITE_BACKGROUND;

            for (int i=0; i<8; i++) {
                System.out.print(" " + (8-i) + " |");

                for (int j=0; j<8; j++) {

                    if (board[i][j].equals("")) {
                        if (options.contains(new ArrayList<Integer>(Arrays.asList(j, i))))
                            System.out.print(" " + Preparing.ANSI_GREEN_BACKGROUND + Preparing.ANSI_GREEN + "♟" + Preparing.ANSI_RESET + " |");
                        else if (background.equals(Preparing.ANSI_BLACK_BACKGROUND))
                            System.out.print(" " + background + Preparing.ANSI_BLACK + "♟" + Preparing.ANSI_RESET + " |");
                        else
                            System.out.print(" " + background + Preparing.ANSI_WHITE + "♟" + Preparing.ANSI_RESET + " |");
                    }
                    else {
                        if (options.contains(new ArrayList<Integer>(Arrays.asList(j, i))))
                            System.out.print(" " + Preparing.ANSI_GREEN_BACKGROUND + board[i][j] + Preparing.ANSI_RESET + " |");
                        else
                            System.out.print(" " + background + board[i][j] + Preparing.ANSI_RESET + " |");
                    }

                    if (background.equals(Preparing.ANSI_WHITE_BACKGROUND))
                        background = Preparing.ANSI_BLACK_BACKGROUND;
                    else
                        background = Preparing.ANSI_WHITE_BACKGROUND;
                }
                if (background.equals(Preparing.ANSI_WHITE_BACKGROUND))
                    background = Preparing.ANSI_BLACK_BACKGROUND;
                else
                    background = Preparing.ANSI_WHITE_BACKGROUND;

                System.out.println(Preparing.ANSI_RESET + "\n-------------------------------------------");
            }
        }

        else {
            System.out.println("   |  H |  G |  F |  E | D |  C |  B |  A |");

            String background = Preparing.ANSI_WHITE_BACKGROUND;

            for (int i=7; i>=0; i--) {
                System.out.print(" " + (8-i) + " |");

                for (int j=7; j>=0; j--) {

                    if (board[i][j].equals("")) {
                        if (options.contains(new ArrayList<Integer>(Arrays.asList(j, i))))
                            System.out.print(" " + Preparing.ANSI_GREEN_BACKGROUND + Preparing.ANSI_GREEN + "♟" + Preparing.ANSI_RESET + " |");
                        else if (background.equals(Preparing.ANSI_BLACK_BACKGROUND))
                            System.out.print(" " + background + Preparing.ANSI_BLACK + "♟" + Preparing.ANSI_RESET + " |");
                        else
                            System.out.print(" " + background + Preparing.ANSI_WHITE + "♟" + Preparing.ANSI_RESET + " |");
                    }
                    else {
                        if (options.contains(new ArrayList<Integer>(Arrays.asList(j, i))))
                            System.out.print(" " + Preparing.ANSI_GREEN_BACKGROUND + board[i][j] + Preparing.ANSI_RESET + " |");
                        else
                            System.out.print(" " + background + board[i][j] + Preparing.ANSI_RESET + " |");
                    }

                    if (background.equals(Preparing.ANSI_WHITE_BACKGROUND))
                        background = Preparing.ANSI_BLACK_BACKGROUND;
                    else
                        background = Preparing.ANSI_WHITE_BACKGROUND;
                }
                if (background.equals(Preparing.ANSI_WHITE_BACKGROUND))
                    background = Preparing.ANSI_BLACK_BACKGROUND;
                else
                    background = Preparing.ANSI_WHITE_BACKGROUND;

                System.out.println(Preparing.ANSI_RESET + "\n-------------------------------------------");
            }
        }
    }

    //SHOWING POTENTIAL MOVE(S)
    public static void showMoves(ArrayList<ArrayList<Integer>> moves) {
        System.out.println("Potential Move(s): ");

        for (int i=0; i<moves.size(); i++) {
            System.out.print(String.valueOf(convert(moves.get(i).get(0))) + (8 -(moves.get(i).get(1))));

            if ((i+1) % 7 == 0)
                System.out.println("\n-----------------------------------");
            else
                System.out.print(" - ");
        }
    }

    //SHOWING DEAD PIECES
    public static void showDeadPieces(ArrayList<String> killedPiecesOfRed, ArrayList<String> killedPiecesOfBlue) {
        System.out.print("Killed pieces of Blue: - ");
        for (int i=0; i<killedPiecesOfBlue.size(); i++)
            System.out.print(killedPiecesOfBlue.get(i) + " - ");
        System.out.println();

        System.out.print("Killed pieces of Red: - ");
        for (int i=0; i<killedPiecesOfRed.size(); i++)
            System.out.print(killedPiecesOfRed.get(i) + " - ");
        System.out.println();
    }

    //CHECKING IF THE INPUT IS VALID
    public static boolean isInputValid(String input) {
        boolean checkLength = input.length() == 2;
        if (!checkLength)
            return false;

        boolean checkFirstChar = (int)input.charAt(0) >= (int)'A' && (int)input.charAt(0) <= (int)'H';
        boolean checkSecondChar = (int)input.charAt(1) >= (int)'1' && (int)input.charAt(1) <= (int)'8';

        if (checkFirstChar && checkSecondChar)
            return true;
        return false;
    }

    //CONVERTING TO COORDINATE
    public static int[] toCoordinate(String input) {
        int[] coordinate = new int[2];

        coordinate[0] = convert(input.charAt(0));
        coordinate[1] = 7 - (Character.getNumericValue(input.charAt(1)) - 1);

        return coordinate;
    }

    //This method returns true if there is the piece in the on the board, otherwise false
    public static boolean wasFound(String[][] board, String piece) {
        for (String[] i:board)
            for (String j:i)
                if (j.equals(piece))
                    return true;
        return false;
    }

    //FINDING OPPONENT TEAM
    public static String findOpponentTeam(String myTeam) {
        if (myTeam.equals(Preparing.ANSI_RED))
            return Preparing.ANSI_BLUE;
        return Preparing.ANSI_RED;
    }

    //FINDING WHICH PIECE'S OPTIONS METHOD WILL BE USED
    public static ArrayList<ArrayList<Integer>> options(String[][] board, int x, int y, String myTeam, String opponentTeam) {
        if (board[y][x].contains("♝"))
            return Bishop.options(board, x, y, myTeam, opponentTeam);

        else if (board[y][x].contains("♚"))
            return King.options(board, x, y, myTeam, opponentTeam);

        else if (board[y][x].contains("♞"))
            return Knight.options(board, x, y, myTeam, opponentTeam);

        else if (board[y][x].contains("♟"))
            return Pawn.options(board, x, y, myTeam, opponentTeam);

        else if (board[y][x].contains("♛"))
            return Queen.options(board, x, y, myTeam, opponentTeam);

        return Rook.options(board, x, y, myTeam, opponentTeam);
    }

    //CHECKING RIGHT CASTLING MOVE OF RED
    public static boolean checkRightCastlingOfRed(String[][] board, String input, boolean didRedKingMove, boolean didRedRightRookMove) {
        boolean areEmpty = board[7][5] == "" && board[7][6] == "";
        boolean didTheyMove = !didRedKingMove && !didRedRightRookMove;
        boolean isInputConvenient = input.equals("E1") || input.equals("H1");

        if (areEmpty && didTheyMove && isInputConvenient)
            return true;
        return false;
    }

    //CHECKING LEFT CASTLING MOVE OF RED
    public static boolean checkLeftCastlingOfRed(String[][] board, String input, boolean didRedKingMove, boolean didRedLeftRookMove) {
        boolean areEmpty = board[7][1] == "" && board[7][2] == "" && board[7][3] == "";
        boolean didTheyMove = !didRedKingMove && !didRedLeftRookMove;
        boolean isInputConvenient = input.equals("E1") || input.equals("A1");

        if (areEmpty && didTheyMove && isInputConvenient)
            return true;
        return false;
    }

    //CHECKING RIGHT CASTLING MOVE OF BLUE
    public static boolean checkRightCastlingOfBlue(String[][] board, String input, boolean didBlueKingMove, boolean didBlueRightRookMove) {
        boolean areEmpty = board[0][1].equals("") && board[0][2].equals("") && board[0][3].equals("");
        boolean didTheyMove = !didBlueKingMove && !didBlueRightRookMove;
        boolean isInputConvenient = input.equals("A8") || input.equals("E8");

        if (areEmpty && didTheyMove && isInputConvenient)
            return true;
        return false;
    }

    //CHECKING LEFT CASTLING MOVE OF BLUE
    public static boolean checkLeftCastlingOfBlue(String[][] board, String input, boolean didBlueKingMove, boolean didBlueLeftRookMove) {
        boolean areEmpty = board[0][5] == "" && board[0][6] == "";
        boolean didTheyMove = !didBlueKingMove && !didBlueLeftRookMove;
        boolean isInputConvenient = input.equals("E8") || input.equals("H8");

        if (areEmpty && didTheyMove && isInputConvenient)
            return true;
        return false;
    }

    //CHECKING CASTLING MOVE INPUT
    public static void showCastling(String[][] board, String myTeam, String moveFrom, boolean didBlueKingMove, boolean didBlueLeftRookMove, boolean didBlueRightRookMove, boolean didRedKingMove, boolean didRedLeftRookMove, boolean didRedRightRookMove) {
        if (myTeam.equals(Preparing.ANSI_RED) && checkLeftCastlingOfRed(board, moveFrom, didRedKingMove, didRedLeftRookMove))
            System.out.println("\nSPECIAL MOVE! To left castling move: CASTLING1");

        if (myTeam.equals(Preparing.ANSI_RED) && checkRightCastlingOfRed(board, moveFrom, didRedKingMove, didRedRightRookMove))
            System.out.println("\nSPECIAL MOVE! To right castling move: CASTLING2");

        if (myTeam.equals(Preparing.ANSI_BLUE) && checkLeftCastlingOfBlue(board, moveFrom, didBlueKingMove, didBlueLeftRookMove))
            System.out.println("\nSPECIAL MOVE! To left castling move: CASTLING1");

        if (myTeam.equals(Preparing.ANSI_BLUE) && checkRightCastlingOfBlue(board, moveFrom, didBlueKingMove, didBlueRightRookMove))
            System.out.println("\nSPECIAL MOVE! To right castling move: CASTLING2");
    }

    //MAKING CASTLING MOVE
    public static boolean makeCastling(String[][] board, String myTeam, String moveFrom, String moveTo, boolean didBlueKingMove, boolean didBlueLeftRookMove, boolean didBlueRightRookMove, boolean didRedKingMove, boolean didRedLeftRookMove, boolean didRedRightRookMove) {
        if (myTeam.equals(Preparing.ANSI_RED) && checkLeftCastlingOfRed(board, moveFrom, didRedKingMove, didRedLeftRookMove) && moveTo.equals("CASTLING1")) {
            board[7][0] = "";
            board[7][4] = "";
            board[7][2] = Preparing.ANSI_RED + "♚" + Preparing.ANSI_RESET;
            board[7][3] = Preparing.ANSI_RED + "♜" + Preparing.ANSI_RESET;

            return true;
        }

        else if (myTeam.equals(Preparing.ANSI_RED) && checkRightCastlingOfRed(board, moveFrom, didRedKingMove, didRedRightRookMove) && moveTo.equals("CASTLING2")) {
            board[7][7] = "";
            board[7][4] = "";
            board[7][6] = Preparing.ANSI_RED + "♚" + Preparing.ANSI_RESET;
            board[7][5] = Preparing.ANSI_RED + "♜" + Preparing.ANSI_RESET;

            return true;
        }

        else if (myTeam.equals(Preparing.ANSI_BLUE) && checkLeftCastlingOfBlue(board, moveFrom, didBlueKingMove, didBlueLeftRookMove) && moveTo.equals("CASTLING1")) {
            board[0][7] = "";
            board[0][4] = "";
            board[0][6] = Preparing.ANSI_BLUE + "♚" + Preparing.ANSI_RESET;
            board[0][5] = Preparing.ANSI_BLUE + "♜" + Preparing.ANSI_RESET;

            return true;
        }

        else if (myTeam.equals(Preparing.ANSI_BLUE) && checkRightCastlingOfBlue(board, moveFrom, didBlueKingMove, didBlueRightRookMove) && moveTo.equals("CASTLING2")) {
            board[0][0] = "";
            board[0][4] = "";
            board[0][2] = Preparing.ANSI_BLUE + "♚" + Preparing.ANSI_RESET;
            board[0][3] = Preparing.ANSI_BLUE + "♜" + Preparing.ANSI_RESET;

            return true;
        }

        return false;
    }

    //CHANGING PAWN
    public static void changePawn(String[][] board, String myTeam) {
        int y;
        if (myTeam.equals(Preparing.ANSI_RED))
            y = 0;
        else
            y = 7;

        for (int i=0; i<8; i++) {
            if (board[y][i].contains("♟")) {
                while (true) {
                    System.out.println("To which piece do you want to change? (1-4)");
                    System.out.println(" 1   2   3   4 ");
                    System.out.println(" ♜  ♞  ♝  ♛ ");

                    Scanner scanner = new Scanner(System.in);

                    String choose = scanner.nextLine();

                    if (choose.equals("1")) {
                        board[y][i] = myTeam + "♜" + Preparing.ANSI_RESET;
                        return;
                    }

                    else if (choose.equals("2")) {
                        board[y][i] = myTeam + "♞" + Preparing.ANSI_RESET;
                        return;
                    }

                    else if (choose.equals("3")) {
                        board[y][i] = myTeam + "♝" + Preparing.ANSI_RESET;
                        return;
                    }

                    else if (choose.equals("4")) {
                        board[y][i] = myTeam + "♛" + Preparing.ANSI_RESET;
                        return;
                    }

                    else
                        System.out.println("Please enter a valid value!");

                }
            }
        }
    }



}
