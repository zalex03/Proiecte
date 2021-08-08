package teme.w03_recap;

import java.util.Arrays;

class Ex11_MergeSort {

    static int[] sort(int[] array) {
        // if array contains at least one element
        if (array.length <= 1) {
            return array;
        }
        int midpoint = array.length / 2;
        //creating a left and right array
        int[] left = new int[midpoint];
        int[] right;
        //if even or odd length
        if (array.length % 2 == 0) {
            right = new int[midpoint];
        } else {
            right = new int[midpoint + 1];
        }
        //populate the left and right array
        for (int i = 0; i < midpoint; i++) {
            left[i] = array[i];
        }
        for (int j = 0; j < right.length; j++) {
            // populate with element from the middle
            right[j] = array[midpoint + j];
        }

        // creating a result array
        int[] result = new int[array.length];
        // recursive part
        left = sort(left);
        right = sort(right);
        result = merge(left, right);

        return result;
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftPointer, rightPointer, resultPointer;
        leftPointer = resultPointer = rightPointer = 0;
        //while there are elements in one of the two arrays, merge them;
        while (leftPointer < left.length || rightPointer < right.length) {
            //checking to see if both arrays have element
            if (leftPointer < left.length && rightPointer < right.length) {
                //checking for the bigger value
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            }
            //checking for element only in the left array
            else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        testSort(new int[]{});
        testSort(new int[]{1});
        testSort(new int[]{1, 2});
        testSort(new int[]{2, 1});
        testSort(new int[]{1, 3, 2});
        testSort(new int[]{1, 3, 2, 4});
        testSort(new int[]{3, 4, 1, 2});
        testSort(new int[]{4, 3, 2, 1});
        testSort(new int[]{5, 3, 4, 1, 2, 6});
        testSort(new int[]{2, 1, 3, 1, 3, 2});
    }

    private static void testSort(int[] arr) {
        System.out.println("Sorting " + Arrays.toString(arr) + " => " + Arrays.toString(sort(arr)));
    }
}
