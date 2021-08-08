package teme.w04_oop1.ex0_time;

public class TimeUtils {

    public static String descriptionOf(Time t) {
        String amPmSuffix = t.getHours() < 12 ? " AM" : " PM";

        int reducedHours = t.getHours() < 12 ?
                t.getHours() :
                (t.getHours() - 12);

        return reducedHours + ":" + t.getMinutes() + ":" + t.getSeconds() + amPmSuffix;
    }

    public static Time findLatest(Time[] times) {
        if (times.length == 0) {
            return null;
        }

        Time latestTime = times[0];
        for (Time time : times) {
            if (time.isAfter(latestTime)) {
                latestTime = time;
            }
        }
        return latestTime;
    }
}
