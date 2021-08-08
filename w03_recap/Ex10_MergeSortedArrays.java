package teme.w03_recap;

import java.util.Arrays;

class Ex10_MergeSortedArrays {

    static int[] merge(int[] arr1, int[] arr2) {
        int iNumberHold;
        int[] mergedArray = new int[arr1.length + arr2.length];
        for (int j = 0; j < arr2.length; j++) {
            for (int i = 0; i < arr1.length; i++) {
                iNumberHold = arr1[i];
                if (arr1[i] > arr2[j]) {
                    arr1[i] = arr2[j]; //
                    arr2[j] = iNumberHold;
                }
                for (int z = 1; z < arr2.length; z++) {
                    int zNumberHold = arr2[z];
                    int x = z - 1;
                    while (x >= 0 && arr2[x] > zNumberHold) {
                        arr2[x + 1] = arr2[x];
                        x = x - 1;
                    }
                    arr2[x + 1] = zNumberHold;
                }

            }
        }
        System.arraycopy(arr1, 0, mergedArray, 0, arr1.length);
        System.arraycopy(arr2, 0, mergedArray, arr1.length, arr2.length);
        return mergedArray;
    }


    /**
     * Some manual tests:
     */
    public static void main(String[] args) {
        testMerge(new int[]{}, new int[]{});

        testMerge(new int[]{}, new int[]{1});
        testMerge(new int[]{1}, new int[]{});

        testMerge(new int[]{1, 2}, new int[]{});
        testMerge(new int[]{}, new int[]{1, 2});

        testMerge(new int[]{1}, new int[]{2});
        testMerge(new int[]{2}, new int[]{1});

        testMerge(new int[]{3}, new int[]{1, 2});
        testMerge(new int[]{1, 2, 4}, new int[]{3});

        testMerge(new int[]{1, 3, 5}, new int[]{2, 4});
        testMerge(new int[]{1, 3, 5}, new int[]{0, 2, 4, 6});

        testMerge(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }

    private static void testMerge(int[] arr1, int[] arr2) {
        System.out.println("merging: " + Arrays.toString(arr1) + " + " + Arrays.toString(arr2) +
                " => " + Arrays.toString(merge(arr1, arr2)));
    }
}
