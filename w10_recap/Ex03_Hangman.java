package teme.w10_recap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Ex03_Hangman {

    private String PickAWord() throws IOException {

        String x = Files.readAllLines(Paths
                .get("curs/enunturi_teme/resources/w10_pt_tema__top500_cautari_cuvinte_romanesti.csv"))
                .get((int) (Math.random() * 483));
        System.out.println(x);
        //String[] word = x.split("");
        //System.out.println(Arrays.toString(word));
        return x;
    }

    private String PickDifficulty() throws IOException {
        String difWord = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Pick a difficulty(easy,med,hard)");
        String diff = sc.next();
        switch (diff) {
            case "easy":
                do {
                    difWord = PickAWord();
                }
                while (difWord.length() > 4);
                break;
            case "med":
                do {
                    difWord = PickAWord();
                }
                while (difWord.length() < 7 && difWord.length() < 5);
                break;
            case "hard":
                do {
                    difWord = PickAWord();
                }
                while (difWord.length() < 7);
                break;
        }
        System.out.println(difWord);
        return difWord;
    }


    public static void main(String[] args) throws IOException {
        int lives = 6;
        //the random word_to lowerCase
        String theWord = new Ex03_Hangman().PickDifficulty().toLowerCase();
        //Dash word
        //aici
        String[] dashWord = new String[theWord.length()];
        for (int i = 0; i < theWord.length(); i++) {
            if (i == 0 || i == theWord.length() - 1) {
                dashWord[i] = String.valueOf(theWord.charAt(i));
            } else {
                dashWord[i] = String.valueOf('_');
            }
        }
        //the conditon and loop
        while (lives >= 0 && Arrays.toString(dashWord).contains("_")) {
            boolean containt = false;
            Scanner sc = new Scanner(System.in);
            System.out.println("Lets play hangman");
            HangmanFromChar(lives);
            System.out.println("The word is :");
            System.out.println(Arrays.toString(dashWord));
            System.out.println("Pick a letter");
            String letter = sc.next().toLowerCase();
            for (int i = 1; i < theWord.length() - 1; i++) {
                if (letter.charAt(0) == theWord.charAt(i)) {
                    dashWord[i] = String.valueOf(theWord.charAt(i));
                    containt = true;
                }

            }
            if (!containt) {
                lives = lives - 1;
            }


        }
        System.out.println("You won");
        System.out.println("The word was :" + Arrays.toString(dashWord).replace(",", ""));

    }


    private static void HangmanFromChar(int lives) {
        if (lives == 6) {
            System.out.println(" _ _ _ _ _ _ _");
            System.out.println("|             |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("_ _ _ _ _ _ _ _");
        } else if (lives == 5) {
            System.out.println(" _ _ _ _ _ _ _");
            System.out.println("|             |");
            System.out.println("|             O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("_ _ _ _ _ _ _ _");
        } else if (lives == 4) {
            System.out.println(" _ _ _ _ _ _ _");
            System.out.println("|             |");
            System.out.println("|             O");
            System.out.println("|             |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("_ _ _ _ _ _ _ _");
        } else if (lives == 3) {
            System.out.println(" _ _ _ _ _ _ _");
            System.out.println("|             |");
            System.out.println("|             O");
            System.out.println("|            /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("_ _ _ _ _ _ _ _");
        } else if (lives == 2) {
            System.out.println(" _ _ _ _ _ _ _");
            System.out.println("|             |");
            System.out.println("|             O");
            System.out.println("|            /|\\ ");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("_ _ _ _ _ _ _ _");
        } else if (lives == 1) {
            System.out.println(" _ _ _ _ _ _ _");
            System.out.println("|             |");
            System.out.println("|             O");
            System.out.println("|            /|\\ ");
            System.out.println("|            /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("_ _ _ _ _ _ _ _");
        } else if (lives == 0) {
            System.out.println("Game Over");
            System.out.println(" _ _ _ _ _ _ _");
            System.out.println("|             |");
            System.out.println("|             O");
            System.out.println("|            /|\\ ");
            System.out.println("|            / \\");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("_ _ _ _ _ _ _ _");
            System.out.println("G A M E  O V E R");
        }


    }


}
