package teme.w03_recap;

class Ex6_ValidParentheses {

    static boolean isValid(String expression) {
        char openP = '(';
        char closedP = ')';
        int count = 0;
        char[] arrExpression = expression.toCharArray();
        if (indexNumber(expression) == 0)
            if (expression.isEmpty()) {
                return true;
            }
        //checking to see if they are in even number
        for (int i = 0; i < arrExpression.length; i++) {

            if (openP == arrExpression[i]) {
                count++;

            } else if (closedP == arrExpression[i]) {
                count--;

            }
        }
        if (count == 0 && indexNumber(expression) == 0) {
            return true;
        }

        return false;
    }

    public static int indexNumber(String parenthesis) {
        /*if (parenthesis.isEmpty()) {
            return;
        }*/
        char openP = '(';
        char closedP = ')';
        int j = 0;
        int y = 0;
        int isIndexNumberSmaller = 0;
        char[] arrPar = parenthesis.toCharArray();
        //find out how many positives in total
        int length1 = 0;
        int length2 = 0;
        //finding the length for the open paretheses arr
        for (int value : arrPar) {
            if (openP == value) {
                length1++;
            }
        }
        //finding the length for the closed paretheses arr
        for (int value : arrPar) {
            if (closedP == value) {
                length2++;
            }
        }
        //creating 2 new arr to store the index numbers
        int[] indexOpen = new int[length1];
        int[] indexClosed = new int[length2];
        //finding the index numbers
        for (int i = 0; i < parenthesis.length(); i++) {
            if (arrPar[i] == openP) {
                indexOpen[j] = i;
                j++;
            }
        }

        for (int i = 0; i < parenthesis.length(); i++) {
            if (arrPar[i] == closedP) {
                indexClosed[y] = i;
                y++;
            }
        }

        //checking to see if the index numbers of ( are smaller then the index numbers of the )
        for (int i = 0; i < length1 && i < length2; i++) {
            if (indexOpen[i] > indexClosed[i]) {
                isIndexNumberSmaller = 1;
                break;
            } else {
                isIndexNumberSmaller = 0;

            }

        }

        return isIndexNumberSmaller;
    }

    /**
     * Some manual tests:
     */
    public static void main(String[] args) {
        testIt("");
        testIt("Abc 123");
        testIt("()");
        testIt("ab ()");
        testIt("x*(y+z), (2+3)");
        testIt("(1+(2+3))-((4))");
        testIt("(.()..((?))..)..");

        testIt("(..");
        testIt(")( abc ()");
        testIt("() )( ()");
    }

    private static void testIt(String s) {
        System.out.println();
        System.out.println("'" + s + "' - is valid? : " + isValid(s));
    }
}
