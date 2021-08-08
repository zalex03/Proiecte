package teme.w03_recap;

import java.util.Arrays;

class Ex1_ArrayOperations {

    static int[] append(int[] array, int elem) {

        //copy old array to a new array, leaving one extra position (will contain null)
        int[] newArr = Arrays.copyOf(array, array.length + 1);

        //instead of the last null in new array, set the new element
        newArr[newArr.length - 1] = elem;

        //return new array
        return newArr;
    }

    static int[] removeLast(int[] array) {
        //version1: with manual array copy:
        /*
        if (array.length < 1) {
            return array;
        }
        int[] rezArr = new int[array.length - 1];
        for (int i = 0; i < rezArr.length; i++) {
            rezArr[i] = array[i];
        }
        return rezArr;
        */

        //version2: with Arrays.copyOf
        if (array.length == 0) {
            return array;
        }
        return Arrays.copyOf(array, array.length - 1);
    }

    static int[] concat(int[] array1, int[] array2) {

        //version1: using utility methods to copy parts of arrays
        /*
        int newSize = array1.length + array2.length;
        int[] newArr = new int[newSize];
        System.arraycopy(array1, 0, newArr, 0, array1.length);
        System.arraycopy(array2, 0, newArr, array1.length, array2.length);
        return newArr;
        */

        //version2: using manual copy from 1st array, then 2nd
        int[] addArray = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            addArray[i] = array1[i];
        }
        for (int j = 0; j < array2.length; j++) {
            addArray[array1.length + j] = array2[j];
        }
        return addArray;
    }

    static boolean contains(int[] array, int elem) {
        //with for loop
        /*
        for (int i = 0; i < array.length; i++) {
            if (elem == array[i]) {
                return true;
            }
        }
        return false;
        */

        //with for-each
        for (int value : array) {
            if (value == elem) {
                return true;
            }
        }
        return false;
    }

    static int indexOf(int[] array, int elem) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    static int lastIndexOf(int[] array, int elem) {
        //similar to previous one, the only difference is that
        //index varies in the other direction (i: n-1..0, instead of 0..n-1)
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    static int[] filterPositives(int[] array) {

        //Version1: with 2 full iterations over the array
        // - 1st - to find out how many positives in total
        // - 2nd - to actually build the resulting array
        //They do repeat some code between them.

        /*
        if (array.length < 1) {
            return array;
        }

        //1) find out how many positives in total
        int rez = 0;
        for (int value : array) {
            if (value >= 0) {
                rez++;
            }
        }

        //b) allocate new array of right size, and copy positives to it
        int[] pozArray = new int[rez];
        int i = 0;
        for (int value : array) {
            if (value >= 0) {
                pozArray[i] = value;
                i++;
            }
        }
        return pozArray;
    */

        //Version2: with a single iteration:
        // - we copy elements directly in a bigger array
        // - and truncate that one at the end, as needed

        int[] pozArray = new int[array.length]; //max length we could need for results array = length of initial array

        int i = 0; //must use a new separate index for the new array (this one 'moves' slower than index of original array, as we don't copy negative numbers to it)
        for (int elem : array) {
            if (elem >= 0) {
                pozArray[i] = elem;
                i++;
            }
        }

        //The last value of i, after finishing the loop, also tells us how many positives we actually found,
        //so we know what part of the new array to keep at the end.
        return Arrays.copyOf(pozArray, i);
    }


    //some manual tests
    public static void main(String[] args) {
        System.out.println(Arrays.toString(append(new int[]{1, 2, 3}, 4)));
        System.out.println(Arrays.toString(removeLast(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(concat(new int[]{1, 2, 3}, new int[]{4, 5, 6})));

        System.out.println(contains(new int[]{1, 2, 3}, 7));
        System.out.println(contains(new int[]{1, 2, 3}, 2));

        System.out.println(indexOf(new int[]{10, 20, 30, 20}, 20));
        System.out.println(indexOf(new int[]{10, 20, 30, 20}, 70));

        System.out.println(lastIndexOf(new int[]{10, 20, 30, 20}, 20));
        System.out.println(lastIndexOf(new int[]{10, 20, 30, 20}, 70));

        System.out.println(Arrays.toString(filterPositives(new int[]{10, -20, 30, -40, 50})));
    }
}
