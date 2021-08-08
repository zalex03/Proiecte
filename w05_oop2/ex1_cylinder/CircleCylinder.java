package teme.w05_oop2.ex1_cylinder;

class CircleCylinder {

    public static void main(String[] args) {
        //TODO: some manual tests, you may uncomment/run this after you created the required classes/interfaces

        /*
        Circle base = new Circle(0.1, 0.2, 2.5);
        System.out.println("base: " + base);
        System.out.println("base area: " + base.area() + ", length: " + base.length());

        //with inheritance:
        CylinderH ch = new CylinderH(0.1, 0.2, 2.5, 3.5);
        System.out.println("\nch: " + ch);
        System.out.println("ch: base: " + ch.getBase());
        System.out.println("ch: base area: " + ch.getBase().area());
        System.out.println("ch: total area: " + ch.area() + ", volume: " + ch.volume());
        System.out.println("ch length?: " + ch.length());

        //with composition:
        CylinderC cc = new CylinderC(0.1, 0.2, 2.5, 3.5);
        System.out.println("\ncc: " + cc);
        System.out.println("cc: base: " + cc.getBase());
        System.out.println("cc: base area: " + cc.getBase().area());
        System.out.println("cc: total area: " + cc.area() + ", volume: " + cc.volume());
        //System.out.println("cc length?: " + cc.length()); //=> will result in compile error
        */
    }
}

//TODO: you may create the classes (Circle, etc) directly here (but must not be 'public') our in other files under this package, your choice

class Circle {
    double centerX;
    double centerY;
    double radius;

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getRadius() {
        return radius;
    }

    public Circle(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;


    }

    @Override
    public String toString() {
        return "Circle{" +
                "centerX=" + centerX +
                ", centerY=" + centerY +
                ", radius=" + radius +
                '}';
    }

    double area() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    double length() {
        return 2 * Math.PI * getRadius();
    }


}

class CylinderH extends Circle implements Cylinder {
    double height;


    Circle base = new Circle(getCenterX(), getCenterY(), getRadius());

    public double getHeight() {
        return height;
    }

    CylinderH(double centerX, double centerY, double radius, double height) {
        super(centerX, centerY, radius);
        this.height = height;

    }

    CylinderH(Circle circle, double height) {
        super(circle.getCenterX(), circle.getCenterY(), circle.getRadius());
        this.height = height;
    }

    public double volume() {
        return super.area() * getHeight();
    }

    public Circle getBase() {
        return base;
    }

    @Override
    public double area() {
        return 2 * super.area() + 2 * Math.PI * getRadius() * getHeight();
    }

    @Override
    public String toString() {
        return "CylinderH{" +
                "height=" + height +
                ", base=" + base +
                '}';
    }


}

//
class CylinderC implements Cylinder {
    Circle temp = new Circle(2, 1, 1);
    Circle base = new Circle(temp.centerX, temp.centerY, temp.radius);
    double height;

    CylinderC(double centerX, double centerY, double radius, double height) {
        base.centerX = centerX;
        base.centerY = centerY;
        base.radius = radius;
        this.height = height;
    }

    CylinderC(Circle circle, double height) {
        base.centerX = circle.centerX;
        base.centerY = circle.centerY;
        base.radius = circle.radius;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public Circle getBase() {
        return base;
    }

    public double volume() {
        return base.area() * getHeight();
    }

    public double area() {
        return 2 * base.area() + 2 * Math.PI * base.getRadius() * getHeight();
    }


    @Override
    public String toString() {
        return "CylinderC{" +
                "temp=" + temp +
                ", base=" + base +
                ", height=" + height +
                '}';
    }
}

interface Cylinder {
    double volume();

    double area();

    Circle getBase();

    double getHeight();
}