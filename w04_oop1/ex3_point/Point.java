package teme.w04_oop1.ex3_point;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distanceTo(Point other) {
        double dist = sqrt(pow((this.x - other.x), 2) + pow((this.y - other.y), 2));
        return dist;
    }

    static double distanceMethod(Point one, Point two) {
        double dist = sqrt(pow((one.x - two.x), 2) + pow((one.y - two.y), 2));
        return dist;
    }

    static boolean canFormTriangle(Point p1, Point p2, Point p3) {
        double side1 = distanceMethod(p1, p2);
        double side2 = distanceMethod(p1, p3);
        double side3 = distanceMethod(p2, p3);
        return (side1 + side2 > side3)
                && (side1 + side3 > side2)
                && (side2 + side3 > side1);
    }

    static boolean canFormRightAngledTriangle(Point p1, Point p2, Point p3) {
        double side1 = distanceMethod(p1, p2);
        double side2 = distanceMethod(p1, p3);
        double side3 = distanceMethod(p2, p3);
        return canFormTriangle(p1, p2, p3) && (pythagoras(side1, side2, side3) || pythagoras(side1, side3, side2) || pythagoras(side2, side3, side1));
    }

    private static boolean pythagoras(double shortSide1, double shortSide2, double longSide) {
        return shortSide1 * shortSide1 + shortSide2 * shortSide2 == longSide * longSide;
    }

    void move(double deltaX, double deltaY) {
        x = x + deltaX;
        y = y + deltaY;

    }

    public String toString() {
        return "" + x + " " + y;
    }


}
