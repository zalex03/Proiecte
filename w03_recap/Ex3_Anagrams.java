package teme.w03_recap;

import java.util.Arrays;

class Ex3_Anagrams {

    static boolean anagrams(String s1, String s2) {
        //convert String to char array and making every word lower case
        char[] s1Char = s1.toLowerCase().toCharArray();
        char[] s2Char = s2.toLowerCase().toCharArray();
        //sort in alphabetical order
        Arrays.sort(s1Char);
        Arrays.sort(s2Char);
        if (Arrays.equals(s1Char, s2Char)) {
            return true;
        }
        return false;
    }

    /**
     * Some manual tests:
     */
    public static void main(String[] args) {
        checkAnagrams("", "");
        checkAnagrams("A", "a");
        checkAnagrams("binary", "brainy");
        checkAnagrams("Listen", "Silent");
        checkAnagrams("anagram", "nagaram");

        checkAnagrams("ab", "ac");
        checkAnagrams("Aa", "a");
        checkAnagrams("anagram", "angrm");
    }

    private static void checkAnagrams(String s1, String s2) {
        System.out.println("'" + s1 + "' and '" + s2 + "' are anagrams? : " + anagrams(s1, s2));
    }
}
