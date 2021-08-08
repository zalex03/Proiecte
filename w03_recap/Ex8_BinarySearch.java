package teme.w03_recap;

import java.util.Arrays;

class Ex8_BinarySearch {

    //--- a) FOR ITERATIVE VERSION ---//

    /**
     * Iterative version.
     * Searches for value x in whole given array, returns true if found
     */
    static boolean contains(int x, int[] array) {
        Arrays.sort(array);
        int start = 0;
        int stop = array.length - 1;
        int mid = 0;
        if (array.length == 0) {
            return false;
        }
        while (start <= stop) {
            mid = (start + stop) / 2;
            if (array[mid] < x) {
                start = mid + 1;
            } else if (array[mid] > x) {
                stop = mid - 1;
            } else if (array[mid] == x) {
                System.out.println(mid);
                return true;
            }
        }

        return false;
    }


    //--- b) FOR RECURSIVE VERSION ---//

    /**
     * Recursive version.
     * Searches for value x in given array, but only in specified range (between beginIdx and endIdx, inclusive)
     * May call itself as needed (but with other params - different begin/end idx values)
     */
    private static boolean containsRec(int x, int[] array, int beginIdx, int endIdx) {
        boolean isPresent = false;
        int mid = (beginIdx + endIdx) / 2;
        if (array.length == 0) {
            return false;
        }
        if (beginIdx > endIdx) {
            return false;
        } else if (array[mid] < x) {
            beginIdx = mid + 1;
        } else if (array[mid] > x) {
            endIdx = mid - 1;
        }
        if (array[mid] == x) {

            return true;
        }
        return containsRec(x, array, beginIdx, endIdx);
    }

    /**
     * Just a helper function for the recursive version, for easier calling by clients/tests
     * (without needing to specify begin/end idx values)
     */
    static boolean containsRecStart(int x, int[] array) {
        return containsRec(x, array, 0, array.length - 1);
    }

    public static int indexOfNumber(int x, int array[]) {
        Arrays.sort(array);
        int start = 0;
        int stop = array.length - 1;
        int mid = 0;
        if (array.length == 0) {
            return -1;
        }
        while (start <= stop) {
            mid = (start + stop) / 2;
            if (array[mid] < x) {
                start = mid + 1;
            } else if (array[mid] > x) {
                stop = mid - 1;
            } else if (array[mid] == x) {
                System.out.println(mid);
                return mid;
            }
        }
        return -1;
    }


    //--- FOR MANUAL TESTS ---//
    public static void main(String[] args) {
        System.out.println("\nITERATIVE - TRUE cases:");
        testContains(2, new int[]{2, 3, 4});
        testContains(2, new int[]{2, 3, 4});
        testContains(3, new int[]{2, 3, 4});
        testContains(4, new int[]{2, 3, 4});
        testContains(3, new int[]{1, 2, 3, 4, 5});
        System.out.println("\nITERATIVE - FALSE cases:");
        testContains(1, new int[]{});
        testContains(1, new int[]{2});
        testContains(1, new int[]{2, 3});
        testContains(7, new int[]{1, 2, 3, 4, 5});
        testContains(2, new int[]{1, 3, 5});

        System.out.println("\nRECURSIVE - TRUE cases:");
        testContainsRec(2, new int[]{2, 3, 4});
        testContainsRec(3, new int[]{2, 3, 4});
        testContainsRec(4, new int[]{2, 3, 4});
        testContainsRec(3, new int[]{1, 2, 3, 4, 5});
        System.out.println("\nRECURSIVE - FALSE cases:");
        testContainsRec(1, new int[]{});
        testContainsRec(1, new int[]{2});
        testContainsRec(1, new int[]{2, 3});
        testContainsRec(7, new int[]{1, 2, 3, 4, 5});
        testContainsRec(2, new int[]{1, 3, 5});

        System.out.println("\n Index Numbers");
        testIndexNumber(2, new int[]{0, 1, 2, 3, 3,});
        testIndexNumber(1, new int[]{1, 2, 3, 4, 5,});
        testIndexNumber(1, new int[]{});
        testIndexNumber(1, new int[]{2});
        testIndexNumber(1, new int[]{2, 3});
        testIndexNumber(7, new int[]{1, 2, 3, 4, 5});

    }


    private static void testContains(int x, int[] array) {
        System.out.println(Arrays.toString(array) + " contains " + x + " ? : " + contains(x, array));
    }

    private static void testContainsRec(int x, int[] array) {
        System.out.println("recursive version: " + Arrays.toString(array) + " contains " + x + " ? : " + containsRecStart(x, array));
    }

    private static void testIndexNumber(int x, int[] array) {
        System.out.println(Arrays.toString(array) + " the index number of " + x + " ? : " + indexOfNumber(x, array));
    }
}
