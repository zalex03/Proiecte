package teme.w03_recap;

import java.util.Arrays;

class Ex7_MatrixIterator {

    static int sumAll(int[][] matrix) {
        int sum = 0;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[0].length; row++) {
                sum += matrix[col][row];
            }
        }
        return sum;
    }

    static int sumDiag1(int[][] matrix) {
        int diagSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            diagSum += matrix[i][i];
        }
        return diagSum;
    }

    static int[] elementsDiag2(int[][] matrix) {
        int[] secondArray = new int[matrix.length];
        for (int i = matrix.length - 1; i >= 0; ) {

            for (int j = 0; j < matrix.length; j++) {
                secondArray[j] = matrix[j][i--];

            }

        }
        return secondArray;
    }

    static int sumPerimeter(int[][] matrix) {
        int sumPer = 0;
        if (matrix.length == 0) {
            return sumPer;
        } else if (matrix.length == 1) {
            return sumPer = matrix[0][0];
        }

        int sumLeft = 0;
        int sumUp = 0;
        int sumDown = 0;
        int sumRight = 0;

        int repetedNum = matrix[0][0] +
                matrix[0][matrix.length - 1] +
                matrix[matrix.length - 1][0] +
                matrix[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++) {
            sumUp += matrix[0][i];
            sumLeft += matrix[i][0];
            sumRight += matrix[i][matrix.length - 1];
            sumDown += matrix[matrix.length - 1][i];

        }

        return sumPer = sumDown + sumLeft + sumRight + sumUp - repetedNum;
    }


    //Helper function, jus for displaying the matrix
    private static void display(int[][] matrix) {
        String s = "";
        for (int[] row : matrix) {
            for (int elem : row) {
                s += elem + " ";
            }
            s += "\n";
        }
        System.out.println("\nThe matrix:\n" + s);
    }

    /**
     * Some manual tests:
     */
    public static void main(String[] args) {
        printInfo(new int[][]{});

        printInfo(new int[][]{
                {1}});

        printInfo(new int[][]{
                {1, 2},
                {3, 4}});

        printInfo(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}});

        printInfo(new int[][]{
                {1, 1, 1, 1},
                {1, 2, 3, 1},
                {1, 4, 5, 1},
                {1, 1, 1, 1}});

        printInfo(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}});
    }

    private static void printInfo(int[][] m) {
        display(m);
        System.out.println("sumAll: " + sumAll(m));
        System.out.println("sumDiag1: " + sumDiag1(m));
        System.out.println("elementsDiag2: " + Arrays.toString(elementsDiag2(m)));
        System.out.println("sumPerimeter: " + sumPerimeter(m));
    }
}
