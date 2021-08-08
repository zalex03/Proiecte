package teme.w01_intro;

class Ex10_ComparingShapes {

    static final double PI = 3.141592; //approximate value of PI constant from math, can be used in your computation

    //--- CIRCLE ---//
    static double computeCircleArea(double radius) {
        double areaCircle = PI * radius * radius;
        return areaCircle;
    }

    static double computeCircleLength(double radius) {
        double lenghtCircle = 2 * PI * radius;
        return lenghtCircle;
    }

    //--- SQUARE ---//
    static double computeSquareArea(double side) {
        double areaSquare = side * side;
        return areaSquare;
    }

    static double computeSquarePerimeter(double side) {
        double perimeterSquare = side * 4;
        return perimeterSquare;
    }

    //--- COMPARE SHAPES ---//

    /**
     * Computes and compares the AREAS of 2 different shapes
     *
     * @param radius radius of the circle shape
     * @param side   side of the square shape
     * @return "square" if the square shape has the bigger area, or "circle" otherwise
     */
    static String whichHasGreaterArea(double radius, double side) {
        double circleArea;
        circleArea = computeCircleArea(radius);
        double squareArea;
        squareArea = computeSquareArea(side);
        return circleArea > squareArea ? "circle" : "square";
    }

    /**
     * Computes and compares the PERIMETERS of 2 different shapes
     *
     * @param radius radius of the circle shape
     * @param side   side of the square shape
     * @return "square" if the square shape has the bigger perimeter, or "circle" otherwis
     */
    static String whichHasGreaterPerimeter(double radius, double side) {
        double circlePerimeter;
        circlePerimeter = computeCircleLength(radius);
        double squarePerimeter;
        squarePerimeter = computeSquarePerimeter(side);
        return circlePerimeter > squarePerimeter ? "circle" : "square";
    }

    //--- MAIN, just for manual tests ---//
    public static void main(String[] args) {
        System.out.println("Area of circle with r=5: " + computeCircleArea(5));
        System.out.println("Length of circle with r=5: " + computeCircleLength(5));

        System.out.println("Area of square with side=8: " + computeSquareArea(8));
        System.out.println("Perimeter of square with side=8: " + computeSquarePerimeter(8));

        System.out.println("circle(r=5) vs square(l=8) - has greater AREA: '" + whichHasGreaterArea(5, 8) + "'");
        System.out.println("circle(r=5) vs square(l=8) - has greater PERIMETER: '" + whichHasGreaterPerimeter(5, 8) + "'");
    }
}
