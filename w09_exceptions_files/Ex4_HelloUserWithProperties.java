package teme.w09_exceptions_files;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class Ex4_HelloUserWithProperties {


    String name = "empty";


    private void WritePropFile() throws IOException {
        if (HasName() == true) {
            Name();
            Properties p = new Properties();
            p.setProperty("name", name);
            p.setProperty("time", Time());
            try (OutputStream out = new FileOutputStream("user.properties")) {
                p.store(out, "some comments here");
            }
        } else {
            readProperties();
            /*Properties p = new Properties();
                OutputStream out = new FileOutputStream("user.properties");
                p.setProperty("time", Time());

                    p.store(out, "some comments here");
                    out.close();*/
        }
    }


    private Boolean HasName() throws IOException {
        Properties prop = new Properties();
        try (InputStream in = new FileInputStream("user.properties")) {
            prop.load(in);
        }
        return prop.get("name") == null ? true : false;
    }


    private void readProperties() throws IOException {
        Properties prop = new Properties();
        InputStream in = new FileInputStream("user.properties");
        prop.load(in);
        System.out.println("Hello " + prop.get("name") + " nice to see you again! (last visit time: " + prop.get("time"));
        in.close();
    }


    private String Time() {
        DateFormat clockFormat = new SimpleDateFormat("HH:mm:ss");
        Date clockObj = new Date();
        String time = clockFormat.format(clockObj);
        return time;
    }

    private void Name() {
        System.out.println("Greeting fallow human,can i have your name?");
        Scanner insertName = new Scanner(System.in);
        name = insertName.nextLine();
    }

    public static void main(String[] args) throws IOException {
        new Ex4_HelloUserWithProperties().WritePropFile();

    }
}
