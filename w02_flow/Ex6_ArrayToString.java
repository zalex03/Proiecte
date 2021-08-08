package teme.w02_flow;

class Ex6_ArrayToString {

    static String arrayToString(double[] array) {
        String numbersFromArray = "";
        String twoDecimals = "";
        String comma = "";
        for (int i = 0; i < array.length; i++) {
            twoDecimals = String.format("%.2f", array[i]);
            System.out.println(twoDecimals);
            numbersFromArray += twoDecimals;
            if (i < array.length - 1) {
                comma = ", ";
                numbersFromArray += comma;
                //used this statemant in order to get rid of the last comma
            }


        }
        return "[" + numbersFromArray + "]";
    }

    public static void main(String[] args) {
        System.out.println(arrayToString(new double[]{}));
        System.out.println(arrayToString(new double[]{1.1, 2.345, 3.0}));
    }
}
