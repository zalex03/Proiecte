package teme.w04_oop1.ex0_time;

public class Time {

    //--- FIELDS ---//
    //a static field
    public static int createInstancesCounter;

    //some normal (instance) fields
    private final int hours;
    private final int minutes;
    private final int seconds;


    //--- CONSTRUCTORS ---//
    //1st constructor - receives 3 params, initializes all 3 fields (after some validations)
    public Time(int hours, int minutes, int seconds) {
        Time.createInstancesCounter += 1;
        this.hours = hours >= 0 ? hours : 0;
        this.minutes = minutes >= 0 ? minutes : 0;
        this.seconds = seconds >= 0 ? seconds : 0;
    }

    //2nd constructor, without any params - initializes the 3 fields to some fixed values
    public Time() {
        this(23, 59, 59);
    }


    //--- GETTER METHODS ---//
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }


    //--- OTHER METHODS ---//
    public int secondsSinceMidnight() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    public int secondsSince(Time other) {
        return this.secondsSinceMidnight() - other.secondsSinceMidnight();
    }

    public boolean isAfter(Time other) {
        return this.secondsSince(other) > 0;
    }

    //the 'special' toString method (has a dedicated name)
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }
}


//--- older intermediary versions ---//
//a)
/*
class Time {

    int hours;
    int minutes;
    int seconds;

    String description() {
        return hours + ":" + minutes + ":" + seconds;
    }
}
*/

//b)
/*
class Time {
    int hours;
    int minutes;
    int seconds;

    //b.i) constructor before adding validations
//    Time(int hours, int minutes, int seconds) {
//        this.hours = hours;
//        this.minutes = minutes;
//        this.seconds = seconds;
//    }

    Time(int hours, int minutes, int seconds) {
        this.hours = hours < 0 ? 0 : hours;
        this.minutes = minutes < 0 ? 0 : minutes;
        this.seconds = seconds < 0 ? 0 : seconds;
    }

    String description() {
        return hours + ":" + minutes + ":" + seconds;
    }
}
*/
