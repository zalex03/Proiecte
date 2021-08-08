package teme.w02_flow;

import java.util.Arrays;

class Ex7_FilterArray {

    static int[] onlyOdd(int[] array) {
        int index = 0;
        int[] copy = new int[array.length];
        //worst case scenario the size of the new array will be identical with int array
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                copy[index++] += array[i];

            } else {
            }
        }
        int[] oddNumbers = Arrays.copyOf(copy, index); //used index to trim the length;
        return oddNumbers;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        onlyOdd(new int[]{1, 2, 3, 4, 5})));
    }
}
