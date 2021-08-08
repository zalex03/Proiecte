package teme.w03_recap;

import java.util.Arrays;

class Ex9_InsertionSort {

    /**
     * Receives an array and sorts it in place, using Insertion sort algorithm
     */
    static void sort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int iNumberHold = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > iNumberHold) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = iNumberHold;
        }
    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {
        testSort(new int[]{});
        testSort(new int[]{1});
        testSort(new int[]{2, 1});
        testSort(new int[]{1, 2, 3});
        testSort(new int[]{1, 3, 2});
        testSort(new int[]{5, 2, 3, 1, 4});
        testSort(new int[]{6, 5, 4, 3, 2, 1});
    }

    //helper function for main
    private static void testSort(int[] arr) {
        String contentBeforeSort = Arrays.toString(arr);
        sort(arr);
        System.out.println("Sorting " + contentBeforeSort + " => " + Arrays.toString(arr));
    }
}
