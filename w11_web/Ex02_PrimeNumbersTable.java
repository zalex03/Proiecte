package teme.w11_web;

import spark.Request;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;


public class Ex02_PrimeNumbersTable {
    static List<Long> holdPrimeNumbers = new ArrayList<>();
    static boolean checkAllNumbers = false;
    public StringBuilder table = new StringBuilder();

    public static void main(String[] args) {


        get("/primeNumbers", (req, res) -> WebSite(req));
        post("/primeNumbers", (req, res) -> handlePostRequestFromForm(req));
        System.out.println("http://localhost:4567/primeNumbers \n");

    }

    //basic website
    private static String WebSite(Request numbers) {
        long startTime = System.currentTimeMillis();
        long smallNumber = 1;
        long highNumber = 1000;
        new Ex02_PrimeNumbersTable().PrimeNumbers(smallNumber, highNumber);
        long endTime = System.currentTimeMillis();
        String timeTook = String.valueOf(endTime - startTime);
        return  //the headline
                "<body bgcolor=\"#E6E6FA\">" +
                        "<h1 style=\"text-align:center;background-color:#DDDDDD; \">" +
                        "<b>Prime Numbers" +
                        "</h1>" +
                        //The top
                        "<form method='post'>\n" +
                        "  Low number:<br>\n" +
                        "  <input type=\"number\" name='lowNumber' value=\"1\"><br>\n" +
                        "  High number:<br>\n" +
                        "  <input type=\"number\" name='highNumber' value=\"1000\"><br><br>\n" +
                        " <input type='submit' value='Submit'><hr>" +
                        "</form>" +
                        // The middle
                        "<h3 style=\"text-align:center;\" > Found : " + holdPrimeNumbers.size() + "</h3><br>" +
                        "<h3 style=\"text-align:center;\"> Time :" + timeTook + " </h3><hr>" +
                        //bottom
                        "<table style=\"width:100% ; border: 1px solid black;\"> " +
                        new Ex02_PrimeNumbersTable().PrintTable() +
                        "</table>";
    }

    static String handlePostRequestFromForm(Request req) {
        long startTime = System.currentTimeMillis();
        long highNumber = Integer.parseInt(req.queryParams("highNumber"));
        long lowNumber = Integer.parseInt(req.queryParams("lowNumber"));
        holdPrimeNumbers.clear();
        new Ex02_PrimeNumbersTable().PrimeNumbers(lowNumber, highNumber);
        long endTime = System.currentTimeMillis();
        String timeTook = String.valueOf(endTime - startTime);
        return  //the headline
                "<body bgcolor=\"#E6E6FA\">" +
                        "<h1 style=\"text-align:center;background-color:#DDDDDD; \">" +
                        "<b>Prime Numbers" +
                        "</h1>" +
                        //The top
                        "<form method='post'>\n" +
                        "  Low number:<br>\n" +
                        "  <input type=\"number\" name='lowNumber' value=\"1\"><br>\n" +
                        "  High number:<br>\n" +
                        "  <input type=\"number\" name='highNumber' value=\"1000\"><br><br>\n" +
                        " <input type='submit' value='Submit'><hr>" +
                        "</form>" +
                        // The middle
                        "<h3 style=\"text-align:center;\" > Found : " + holdPrimeNumbers.size() + "</h3><br>" +
                        "<h3 style=\"text-align:center;\"> Time :" + timeTook + "</h3><hr>" +
                        //bottom
                        "<table style=\"width:100% ; border: 1px solid black;\"> " +
                        new Ex02_PrimeNumbersTable().PrintTable() +
                        "</table>";
    }


    //print out table
    private String PrintTable() {
        int count = 0;
        String openTd = "<td style = \" border: 1px solid black;  padding: 10px; text-align:center;\">";
        String closedTd = "</td> ";
        String openTr = "<tr>";
        String closedTr = "</tr>";
        table.append(openTr);
        for (int i = 0; i < holdPrimeNumbers.size(); i++) {
            table.append(openTd).append(holdPrimeNumbers.get(i)).append(closedTd);
            count++;
            if (count == 20) {
                table.append(closedTr);
                table.append(openTr);
                count = 0;
            }
        }
        return table.toString();
    }


    //find prime numbers
    private void PrimeNumbers(long x, long y) {

        for (long i = x; i <= y; i++) {

            if (i == 0 || i == 1) {
                continue;
            } else if (i == 2) {
                holdPrimeNumbers.add(i);
            }

            for (long j = 2; j < i; j++) {
                if (i == 3) {
                    holdPrimeNumbers.add(i);
                } else if (i % j == 0) {
                    checkAllNumbers = false;
                    break;
                } else {
                    checkAllNumbers = true;
                }
            }
            if (checkAllNumbers) {
                holdPrimeNumbers.add(i);
            }
        }


    }

}
