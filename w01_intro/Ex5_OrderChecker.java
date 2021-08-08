package teme.w01_intro;

class Ex5_OrderChecker {

    static boolean numbersAreSortedAscending3(int n1, int n2, int n3) {

        return (n1 < n2) && (n2 < n3) ? true : false;
    }

    static boolean numbersAreSortedDescending3(int n1, int n2, int n3) {
        //todo: write your code here!
        return n1 > n2 && n2 > n3 ? true : false;
    }

    static boolean numbersAreSortedDescending9(int n1, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        //Question: can you somehow reuse the logic of numbersAreSortedDescending3() here? (by calling it as needed..). If yes, does it make your solution simpler/nicer?..
        //todo: write your code here!
        return numbersAreSortedDescending3(n1, n2, n3) && numbersAreSortedDescending3(n3, n4, n5) && numbersAreSortedDescending3(n5, n6, n7) && numbersAreSortedDescending3(n7, n8, n9)
                ? true : false;
    }

    //manual tests
    public static void main(String[] args) {
        System.out.println(numbersAreSortedAscending3(1, 2, 3));
        System.out.println(numbersAreSortedAscending3(1, 3, 2));

        System.out.println(numbersAreSortedDescending3(3, 2, 1));
        System.out.println(numbersAreSortedDescending3(3, 1, 2));

        System.out.println(numbersAreSortedDescending9(9, 8, 7, 6, 5, 4, 3, 2, 1));
        System.out.println(numbersAreSortedDescending9(9, 8, 7, 6, 0, 4, 3, 2, 1));
    }
}
