import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Play {
    public static void play() {
        System.out.println("Welcome to the chess game!");

        String turn = "RED";
        String myTeam = Preparing.ANSI_RED;
        String opponentTeam = Game.findOpponentTeam(myTeam);
        String[][] board = Preparing.getBoard();

        ArrayList<String> killedPiecesOfRed = new ArrayList<String>();
        ArrayList<String> killedPiecesOfBlue = new ArrayList<String>();

        //CHECKING FOR CASTLING MOVE
        boolean didRedKingMove = false;
        boolean didRedLeftRookMove = false;
        boolean didRedRightRookMove = false;

        boolean didBlueKingMove = false;
        boolean didBlueLeftRookMove = false;
        boolean didBlueRightRookMove = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Your turn RED!");

        while (true) {

            Game.showDeadPieces(killedPiecesOfRed, killedPiecesOfBlue);

            Game.showBoard(board, myTeam);

            System.out.println("Which piece do you want to play? (uppercase letter + integer)");

            String moveFrom = scanner.nextLine();

            if (Game.isInputValid(moveFrom)) {

                int[] coordinate = Game.toCoordinate(moveFrom);

                if (board[coordinate[1]][coordinate[0]].contains(myTeam)) {

                    ArrayList<ArrayList<Integer>> options = Game.options(board, coordinate[0], coordinate[1], myTeam, opponentTeam);

                    while (true) {

                        Game.showBoardWithMoves(board, myTeam, options);

                        Game.showMoves(options);

                        Game.showCastling(board, myTeam, moveFrom, didBlueKingMove, didBlueLeftRookMove, didBlueRightRookMove, didRedKingMove, didRedLeftRookMove, didRedRightRookMove);

                        System.out.println("\nChoose where to play! To cancel: C");

                        String moveTo = scanner.nextLine();

                        if (moveTo.equals("C")) //CANCELING THE CHOOSE
                            break;

                        //MAKING CASTLING MOVE IF POSSIBLE
                        boolean didMakeCastling = Game.makeCastling(board, myTeam, moveFrom, moveTo, didBlueKingMove, didBlueLeftRookMove, didBlueRightRookMove, didRedKingMove, didRedLeftRookMove, didRedRightRookMove);


                        if (Game.isInputValid(moveTo)) {

                            int[] cords = Game.toCoordinate(moveTo);

                            if (options.contains(new ArrayList<Integer>(Arrays.asList(cords[0], cords[1])))) {
                                //MOVING PIECES
                                if (board[cords[1]][cords[0]].contains(Preparing.ANSI_RED))
                                    killedPiecesOfRed.add(board[cords[1]][cords[0]]);

                                else if (board[cords[1]][cords[0]].contains(Preparing.ANSI_BLUE))
                                    killedPiecesOfBlue.add(board[cords[1]][cords[0]]);

                                board[cords[1]][cords[0]] = board[coordinate[1]][coordinate[0]];

                                board[coordinate[1]][coordinate[0]] = "";


                            }

                            else {
                                System.out.println("Please choose from optional moves!");
                                continue;
                            }


                        }

                        else if (!Game.isInputValid(moveTo) && !didMakeCastling){
                            System.out.println("Please enter a valid choose!");
                            continue;
                        }

                        //CHANGING PAWN IF POSSIBLE
                        Game.changePawn(board, myTeam);

                        //CHECKING IF THEY MOVED OR NOT FOR CASTLING MOVE
                        if (!didRedKingMove && !board[7][4].equals(Preparing.ANSI_RED + "♚" + Preparing.ANSI_RESET))
                            didRedKingMove = true;

                        if (!didRedLeftRookMove && !board[7][0].equals(Preparing.ANSI_RED + "♜" + Preparing.ANSI_RESET))
                            didRedLeftRookMove = true;

                        if (!didRedRightRookMove && !board[7][7].equals(Preparing.ANSI_RED + "♜" + Preparing.ANSI_RESET))
                            didRedRightRookMove = true;

                        if (!didBlueKingMove && !board[0][4].equals(Preparing.ANSI_BLUE + "♚" + Preparing.ANSI_RESET))
                            didBlueKingMove = true;

                        if (!didBlueLeftRookMove && !board[0][0].equals(Preparing.ANSI_BLUE + "♜" + Preparing.ANSI_RESET))
                            didBlueLeftRookMove = true;

                        if (!didBlueRightRookMove && !board[0][7].equals(Preparing.ANSI_BLUE + "♜" + Preparing.ANSI_RESET))
                            didBlueRightRookMove = true;

                        //CHECKING IF THE GAME WAS END
                        if (!Game.wasFound(board, Preparing.ANSI_RED + "♚" + Preparing.ANSI_RESET)) {
                            Game.showBoard(board, myTeam);
                            System.out.println("BLUE TEAM WON! CONGRATULATIONS!");
                            return;
                        }

                        if (!Game.wasFound(board, Preparing.ANSI_BLUE + "♚" + Preparing.ANSI_RESET)) {
                            Game.showBoard(board, myTeam);
                            System.out.println("RED TEAM WON! CONGRATULATIONS!");
                            return;
                        }

                        myTeam = opponentTeam;
                        opponentTeam = Game.findOpponentTeam(myTeam);

                        if (turn.equals("RED"))
                            turn = "BLUE";
                        else
                            turn = "RED";

                        System.out.println("Your turn " + turn + "!");

                        break;

                    }
                }
                else {
                    System.out.println("Please enter a valid choose!");
                }

            }

            else {
                System.out.println("Please enter a valid choose!");
            }


        }
    }
}