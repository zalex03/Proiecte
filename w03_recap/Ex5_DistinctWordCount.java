package teme.w03_recap;

import java.util.Arrays;

class Ex5_DistinctWordCount {

    static String[] splitToWords(String text) {

        String[] fText = text.trim().split("\\s+");
        String[] arrText;
        if (text.trim().isEmpty()) {
            arrText = new String[]{};
        } else {
            arrText = Arrays.copyOf(fText, fText.length);
        }
        return arrText;
    }

    static boolean contains(String[] wordsArray, String word) {
        for (String wordInArray : wordsArray) {
            if (word.equals(wordInArray)) {
                return true;
            }
        }

        return false;
    }

    static int distinctWordCount(String phrase) {
        String lowerCasephrase = phrase.toLowerCase();
        String[] arrText = lowerCasephrase.trim().split("\\s+");
        int count = 0;
        if (phrase.trim().isEmpty()) {
            return 0;
        }

        for (int i = 0; i < arrText.length; i++) {
            count++;
            for (int j = i + 1; j < arrText.length; j++) {
                if (arrText[i].equals(arrText[j])) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    //some manual tests
    public static void main(String[] args) {
        testIt("");
        testIt("abc");
        testIt("aa bb");
        testIt("aa  bb");
        testIt("  ");
        testIt(" aa  bb");
        testIt(" aa  bb aa");
        testIt("aa Cc bb  AA cc  ");
    }

    //helper method for manual tests
    private static void testIt(String phrase) {
        System.out.println("distinctWordCount('" + phrase + "') = " + distinctWordCount(phrase));
    }
}
