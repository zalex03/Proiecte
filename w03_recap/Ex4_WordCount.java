package teme.w03_recap;

import java.util.Arrays;

class Ex4_WordCount {

    static int wordCount(String phrase) {
        //replace all => replaces all char with a new char, in this case all bigger spaces with just one space between words
        //trim() removes spaces at the begging and end of the String
        String newPhrase = phrase.trim().replaceAll(" +", " ");
        System.out.println(newPhrase);
        //splits the String according to the regex, also transform in arr
        String[] countWords = phrase.trim().split("\\s+");
        System.out.println(Arrays.toString(countWords));
        if (newPhrase.isEmpty()) {
            return 0;
        }
        return countWords.length;
    }

    //some manual tests
    public static void main(String[] args) {
        testIt("");
        testIt("abc");
        testIt("aa   bb");
        testIt("aa  bb");
        testIt("  ");
        testIt(" aa  bb");
        testIt("aa bb  cc  ");
    }

    //helper method for manual tests
    private static void testIt(String phrase) {
        System.out.println("wordCount('" + phrase + "') = " + wordCount(phrase));
    }
}
