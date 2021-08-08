package teme.w02_flow;

import java.util.Arrays;

class Ex9_ReverseArray {

    static void reverse(String[] arr) {
        int i = 0;
        int j = arr.length;
        swapPositions(arr, i, j);
        //calling the method swapPosition
    }


    static String[] reversedCopy(String[] arr) {
        String[] reversedArr = new String[arr.length];
        int lastIndex = arr.length;
        for (int i = 0; i < arr.length; i++) {
            reversedArr[lastIndex - 1] = arr[i];
            lastIndex--;
        }
        return reversedArr;
    }


    //helper method - swaps the elements at 2 given indices, in an array
    static void swapPositions(String[] arr, int i, int j) {
        String storeNumber = "";
        j = arr.length;
        for (i = 0; i < arr.length / 2; i++) {
            storeNumber = arr[i];
            arr[i] = arr[j - i - 1];
            arr[j - i - 1] = storeNumber;
        }
    }

    public static void main(String[] args) {
        String[] arr = {"aa", "bb", "cc", "dd", "ee"};
        System.out.println("initial:  " + Arrays.toString(arr));

        System.out.println("a reversed copy: " + Arrays.toString(reversedCopy(arr)));

        System.out.println("initial after making the copy (should be unchanged): " + Arrays.toString(arr));

        reverse(arr);
        System.out.println("initial after reverse(): " + Arrays.toString(arr));
    }
}
