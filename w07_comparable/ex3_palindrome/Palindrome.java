package teme.w07_comparable.ex3_palindrome;

import java.util.Arrays;

public class Palindrome {

    static boolean isSymmetrical(int[] array) {
        int j = array.length - 1;
        for (int i = 0; i < array.length; i++) {

            if (array[i] == array[j]) {
                j--;
            } else return false;
        }
        return true;
    }

    //TODO: make this generic version also work (similar to previous one, but should work with ANY type of object, not just int values)
    //after this, also uncomment the JUnit test for this method!

    static <T> boolean isSymmetrical_generic(T[] array) {
        int j = array.length - 1;
        for (int i = 0; i < array.length; i++) {

            if (array[i].equals(array[j])) {
                j--;
            } else return false;
        }
        return true;
    }


    static boolean isPalindrome(String text) {
        String cleanText = text.replaceAll(" ", "");
        String[] arrayOfLetters = cleanText.toLowerCase().split("");
        System.out.println(" " + arrayOfLetters);
        int j = cleanText.length() - 1;
        for (int i = 0; i < cleanText.length(); i++) {

            if (arrayOfLetters[i].equals(arrayOfLetters[j])) {
                j--;
            } else return false;
        }
        return true;
    }


    public static void main(String[] args) {

        testSym(new int[]{1, 2, 3, 4, 1});

        testSym(new int[]{1});
        testSym(new int[]{2, 2});
        testSym(new int[]{1, 2, 3, 2, 1});

//
        //TODO: uncomment after making generic version work
        /*
        testSym_generic(new String[]{"ab", "cd"});
        testSym_generic(new String[]{"ab", "cd", "cd", "ab"});
        testSym_generic(new String[]{"ab", "cd", "cd", "ef", "ab"});
        testSym_generic(new Boolean[]{true, false, true});
        */


        testPal("not a palindrome");
        testPal("abb");
        testPal("abcXa");

        testPal("a");
        testPal("abba");
        testPal("rotitor");
        testPal("Step on no pets");
        testPal("Ene purta patru pene");
        testPal("Ion a luat luni vinul tau la noi");
    }

    private static void testSym(int[] array) {
        System.out.println("array: " + Arrays.toString(array) + " - is symmetrical?: " + isSymmetrical(array));
    }

    /*
    private static void testSym_generic(Object[] array) {
        System.out.println("array: " + Arrays.toString(array) + " - is symmetrical?: " + isSymmetrical_generic(array));
    }
    */

    private static void testPal(String text) {
        System.out.println("'" + text + "' - is palindrome?: " + isPalindrome(text));
    }
}
