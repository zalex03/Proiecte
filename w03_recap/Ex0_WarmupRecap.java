package teme.w03_recap;

import java.util.Arrays;

class Ex0_WarmupRecap {

    static String ends(String text) {
        if (text.length() <= 2) {
            return text;
        }

        //version 1: working as string, using charAt() and length() methods
        /*
        char a = text.charAt(0);
        char b = text.charAt(text.length() - 1);
        return "" + a + b; //will also convert a,b to string before appending to previous string ("")
        */

        //version 2: converting the string to an array of char first (with toCharArray)
        char[] arr = text.toCharArray();
        String a = String.valueOf(arr[0]);
        String b = String.valueOf(arr[arr.length - 1]);
        return a + b;
    }

    static String middle(String text) {
        int len = text.length();
        if (text.length() <= 2) {
            return text;
        }
        if (len % 2 != 0) {
            int mid = (len - 1) / 2;
            String a = String.valueOf(text.charAt(mid));
            return a;
        } else {
            int mid1 = (len - 1) / 2;
            int mid2 = mid1 + 1;
            String a = String.valueOf(text.charAt(mid1));
            String b = String.valueOf(text.charAt(mid2));
            return a + b;
        }
    }

    static String onlyUpper(String text) {
        String listUpper = "";

        //Version 1 - with regular for loop (ok, a little longer)
        /*
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                listUpper += c;
            }
        }
        */

        //Version 2 - with simplified for-each loop (requires converting text to array of char first):
        for (char c : text.toCharArray()) {
            //if (Character.isUpperCase(c)) //alternative: check using a predefined function
            if (c >= 'A' && c <= 'Z') { //manual check
                listUpper += c;
            }
        }

        //Version 3 - with while loop (the longest)
        /*
        int i = 0;
        while (i < text.length()) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                listUpper += c;
            }
            i++;
        }
        */

        return listUpper;
    }


    static boolean contains(String text, char letter) {
        //Version 1: with regular for loop:
        /*
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == letter) {
                return true;
            }
        }
        */

        //Version 2: with for-each loop, after converting to array (shorter)
        for (char c : text.toCharArray()) {
            if (c == letter) {
                return true;
            }
        }
        return false;
    }


    static int count(String text, char letter) {

        //Version 1: with for loop
        /*
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == letter) {
                count++;
            }
        }
        return count;
        */

        //Version 2: with for-each loop
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == letter) {
                count++;
            }
        }
        return count;
    }


    static int countVowels(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) { //use the helper function here, for shorter/clearer code!
                count += 1;
            }
        }
        return count;
    }

    /**
     * A helper function, checks if a char is one of the vowels. Works ok with upper/lower case.
     *
     * @param c character to check
     * @return true if char is a vowel, false otherwise
     */
    private static boolean isVowel(char c) {

        //Version 1 - a little longer, but efficient at runtime
        char cl = Character.toLowerCase(c);
        return cl == 'a' || cl == 'e' || cl == 'i' || cl == 'o' || cl == 'u';

        //Two other versions: shorter, but a little slower than previous one
        //return "aeiou".contains(String.valueOf(c).toLowerCase());
        //return "aeiou".indexOf(Character.toLowerCase(c)) != -1;
    }


    static boolean isSorted(String text) {
        //note that we go from 0 just up to len-2! (so i+1 will not go outside the array!)
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) > text.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    static String sorted(String text) {
        char[] x = text.toCharArray(); //convert String to a char array
        Arrays.sort(x);                //sort the array
        return String.valueOf(x);      //convert back array to String
    }


    //some manual tests
    public static void main(String[] args) {
        System.out.println(ends(""));
        System.out.println(ends("a"));
        System.out.println(ends("ab"));
        System.out.println(ends("abcd"));

        System.out.println(middle(""));
        System.out.println(middle("a"));
        System.out.println(middle("ab"));
        System.out.println(middle("abc"));
        System.out.println(middle("abcd"));
        System.out.println(middle("abcde"));

        System.out.println(onlyUpper("A Fost OdaTa.."));

        System.out.println("\ncountVowels('Run, Forest, run!') = " + countVowels("Run, Forest, run!"));
        System.out.println("countVowels('I will..') = " + countVowels("I will.."));

        System.out.println("\nisSorted(\"abccd\"): " + isSorted("abccd"));
        System.out.println("isSorted(\"abec\"): " + isSorted("abec"));

        System.out.println("\nsorted(\"ba\"): " + sorted("ba"));
        System.out.println("\nsorted(\"badc\"): " + sorted("badc"));
    }
}
