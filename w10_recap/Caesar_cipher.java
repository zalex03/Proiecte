package teme.w10_recap;

import java.util.Arrays;
import java.util.Scanner;

public class Caesar_cipher {

    String text = "pokemon";
    private String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public String[] StringToArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please insert a word");
        String text = sc.nextLine();
        String[] stringToArray = text.toLowerCase().split("");

        //List<String> arrayToList = new ArrayList<>();
        //arrayToList = Arrays.asList(stringToArray);
        //System.out.println(Arrays.toString(stringToArray).replace(",",""));
        return stringToArray;
    }

    public int NumberForEncryption() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert the number for encryption");
        int number = sc.nextInt();
        return number;
    }

    public void YesOrNo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to encrypt another word?");
        String answer = sc.nextLine().toLowerCase();
        if (answer.equals("yes")) {
            EncryptedCode();
        }
        return;
    }

    private void EncryptedCode() {
        String[] word = StringToArray();
        int number = NumberForEncryption();
        int lengthAlphabet = 25;
        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (word[i].equals(alphabet[j])) {
                    if (j + number > lengthAlphabet) {
                        word[i] = alphabet[number - (alphabet.length - j)];
                        break;
                    } else if (j + number < 0) {
                        word[i] = alphabet[alphabet.length + (j + number)];
                        break;
                    }
                    word[i] = alphabet[j + number];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(word).replace(",", ""));
        YesOrNo();

    }

    public static void main(String[] args) {
        // new Caesar_cipher().StringToArray(new Caesar_cipher().text);
        new Caesar_cipher().EncryptedCode();
        //new Caesar_cipher().StringToArray();
    }
}
