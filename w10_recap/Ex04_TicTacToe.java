package teme.w10_recap;

import java.util.Scanner;

public class Ex04_TicTacToe {
    public static char[] moves = new char[9];
    static String playerOne = "";
    static String playerTwo = "";
    static boolean hasWon = false;
    static int playerOneScore = 0;
    static int playerTwoScore = 0;

    public static void main(String[] args) {
        // char array of 9 for all posible moves , and populate it with *

        for (int i = 0; i < moves.length; i++) {
            moves[i] = '*';
        }
        //player name insert
        Scanner sc = new Scanner(System.in);
        System.out.println("Player one! What is your name?");
        playerOne = sc.next();
        System.out.println("Player two! What is your name?");
        playerTwo = sc.next();
        System.out.println("Welcome " + playerOne + " and " + playerTwo);
        //game engine
        TableDesign(moves);
        Game();


    }

    public static void Game() {
        char x = 'X';
        char o = 'O';
        do {

            System.out.println("" + playerOne + " place your X");
            //Chose position
            Position(x);
            if (WinningCondition()) {
                System.out.println("" + playerOne + " you have won the game");
                playerOneScore++;
                if (PlayAgain()) {
                    Game();
                }
                return;
            }
            System.out.println("" + playerTwo + " place your O");
            Position(o);
            if (WinningCondition()) {
                System.out.println("" + playerTwo + " you have won the game");
                if (PlayAgain()) {
                    playerTwoScore++;
                    Game();
                }
                return;
            }

        }

        while (!hasWon);
    }

    public static boolean WinningCondition() {
        if (moves[0] == moves[1] && moves[1] == moves[2] && moves[0] != '*') {
            hasWon = true;

        } else if (moves[3] == moves[4] && moves[4] == moves[5] && moves[3] != '*') {
            hasWon = true;
        } else if (moves[6] == moves[7] && moves[7] == moves[8] && moves[6] != '*') {
            hasWon = true;
        } else if (moves[0] == moves[3] && moves[3] == moves[6] && moves[3] != '*') {
            hasWon = true;
        } else if (moves[1] == moves[4] && moves[4] == moves[7] && moves[4] != '*') {
            hasWon = true;
        } else if (moves[2] == moves[5] && moves[5] == moves[8] && moves[2] != '*') {
            hasWon = true;
        } else if (moves[0] == moves[4] && moves[4] == moves[8] && moves[8] != '*') {
            hasWon = true;
        } else if (moves[2] == moves[4] && moves[4] == moves[6] && moves[6] != '*') {
            hasWon = true;
        } else {
            hasWon = false;
        }
        return hasWon;
    }

    public static void Position(char x) {
        Scanner sc = new Scanner(System.in);
        String position = sc.next().toUpperCase();
        //Check position
        switch (position) {
            case "A1":
                if (!(moves[0] == '*')) {
                    System.out.println("Invalid position. Pick a new spot");
                    break;

                }
                moves[0] = x;
                TableDesign(moves);
                return;
            case "A2":
                if (!(moves[1] == '*')) {
                    System.out.println("Invalid position. Pick a new spot");
                    break;
                }
                moves[1] = x;
                TableDesign(moves);
                return;
            case "A3":
                if (!(moves[2] == '*')) {
                    System.out.println("Invalid position. Pick a new spot");
                    break;
                }
                moves[2] = x;
                TableDesign(moves);
                return;
            case "B1":
                if (!(moves[3] == '*')) {
                    System.out.println("Invalid position. Pick a new spot");
                    break;
                }
                moves[3] = x;
                TableDesign(moves);
                return;
            case "B2":
                if (!(moves[4] == '*')) {
                    System.out.println("Invalid position. Pick a new spot");
                    break;
                }
                moves[4] = x;
                TableDesign(moves);
                return;
            case "B3":
                if (!(moves[5] == '*')) {
                    System.out.println("Invalid position. Pick a new spot");
                    break;
                }
                moves[5] = x;
                TableDesign(moves);
                return;
            case "C1":
                if (!(moves[6] == '*')) {
                    System.out.println("Invalid position. Pick a new spot");
                    break;
                }
                moves[6] = x;
                TableDesign(moves);
                return;
            case "C2":
                if (!(moves[7] == '*')) {
                    System.out.println("Invalid position. Pick a new spot");
                    break;
                }
                moves[7] = x;
                TableDesign(moves);
                return;
            case "C3":
                if (!(moves[8] == '*')) {
                    System.out.println("Invalid position. Pick a new spot");
                    break;
                }
                moves[8] = x;
                TableDesign(moves);
                return;
        }
        Position(x);

    }

    public static boolean PlayAgain() {
        boolean playAgain = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Want to play again?");
        String answer = sc.next();
        if (answer.equals("yes")) {
            playAgain = true;
            for (int i = 0; i < moves.length; i++) {
                moves[i] = '*';
            }
        }
        TableDesign(moves);
        return playAgain;
    }


    private static void TableDesign(char[] moves) {

        System.out.println("   1   2   3     Score");
        System.out.println("A| " + moves[0] + " | " + moves[1] + " | " + moves[2] + " |   " + playerOne + "   " + playerOneScore);
        System.out.println("B| " + moves[3] + " | " + moves[4] + " | " + moves[5] + " |   " + playerTwo + "   " + playerTwoScore);
        System.out.println("C| " + moves[6] + " | " + moves[7] + " | " + moves[8] + " |");


    }


}
