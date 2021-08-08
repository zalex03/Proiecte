package teme.w04_oop1.ex0_time;

import java.util.Arrays;

/**
 * This is the main class for this exercise, which contains a main() method
 * and is used to test the separate Time class
 */
public class TimeApp {

    //some manual tests of Time class
    public static void main(String[] args) {

        System.out.println("instances count before t1 creation : " + Time.createInstancesCounter);

        Time t1 = new Time(10, 5, 30);
        System.out.println("instances count after t1 creation : " + Time.createInstancesCounter);

        Time t2 = new Time(-3, -24, -59);
        System.out.println("instances count after t2 creation : " + Time.createInstancesCounter);

        System.out.println("\nt1 == t2 ?: " + (t1 == t2)); //=> false
        System.out.println("t1: " + t1.toString());
        System.out.println("t2: " + t2.toString());

        //creating a new instance using the constructor without params
        Time t3 = new Time();
        Time t4 = new Time(1, 10, 30);
        System.out.println("instances count after t3,t4 creation : " + Time.createInstancesCounter);

        System.out.println("\nt3 : " + t3.toString());
        System.out.println("t3.getHours(): " + t3.getHours()); //accessing the object fields for reading is allowed
        //t3.hours = 4; //but accessing them for update/write is not allowed, after making them final

        System.out.println("\nt4: " + t4.toString());

        System.out.println("\nt3 description with static method: " + TimeUtils.descriptionOf(t3));
        System.out.println("t4 description with static method: " + TimeUtils.descriptionOf(t4));

        System.out.println("\nt1.secondsSinceMidnight(): " + t1.secondsSinceMidnight());
        System.out.println("t4.secondsSinceMidnight(): " + t4.secondsSinceMidnight());
        System.out.println("t4.secondsSince(t1): " + t4.secondsSince(t1));
        System.out.println("t1.secondsSince(t4): " + t1.secondsSince(t4));

        System.out.println("\nIs t1 after t4 ?: " + t1.isAfter(t4));
        System.out.println("Is t4 after t1 ?: " + t4.isAfter(t1));

        Time[] times = new Time[]{t1, t2, t3, t4, new Time(12, 30, 0)};
        System.out.println("\nThe array of times: " + Arrays.toString(times));
        System.out.println("The latest time is : " + TimeUtils.findLatest(times));
    }
}