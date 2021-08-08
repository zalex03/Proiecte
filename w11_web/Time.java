package teme.w11_web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static spark.Spark.get;

public class Time {

    /*** Example of using the Spark framework.
     * More info: http://sparkjava.com/documentation
     */
    private static String Time(){
        DateFormat clockFormat = new SimpleDateFormat("HH:mm:ss dd-M-yyyy");
        Date clockObj = new Date();
        String time = clockFormat.format(clockObj);
        return time;
    }

        public static void main(String[] args) {

            get("/time", (req, res) -> "The current time is: "+ Time() );
            get("/bye", (req, res) -> "Bye, World...");

            System.out.println("Server started, see: http://localhost:4567/time , http://localhost:4567/bye");
        }
    }
