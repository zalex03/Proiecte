package teme.w09_exceptions_files;

import java.io.File;
import java.util.Date;

public class Ex6_FileInfo {
    //with absolute pat
    public static void GetINfo() {
        File find = new File("C:\\Users\\pc\\IdeaProjects\\teme_alex_zaharia\\clasa\\README.md");
        System.out.println("Does the file exist " + find.exists());
        System.out.println("Name: " + find.getName());
        System.out.println("Absolute path: " + find.getAbsolutePath());
        System.out.println("Size: " + find.length());
        System.out.println("Last modified: " + new Date(find.lastModified()));
        System.out.println("Is a file: " + find.isFile());
        System.out.println("Is a folder " + find.isDirectory());
        System.out.println("Is it writable " + find.canWrite());
    }

    public static void GetInfo() {
        File find = new File("./clasa/README.md");
        System.out.println("Does the file exist " + find.exists());
        System.out.println("Name: " + find.getName());
        System.out.println("Absolute path: " + find.getAbsolutePath());
        System.out.println("Size: " + find.length());
        System.out.println("Last modified: " + new Date(find.lastModified()));
        System.out.println("Is a file: " + find.isFile());
        System.out.println("Is a folder " + find.isDirectory());
        System.out.println("Is it writable " + find.canWrite());
    }

    public static void GetInfoSimpler() {
        File find = new File("././README.md");
        System.out.println("Does the file exist " + find.exists());
        System.out.println("Name: " + find.getName());
        System.out.println("Absolute path: " + find.getAbsolutePath());
        System.out.println("Size: " + find.length());
        System.out.println("Last modified: " + new Date(find.lastModified()));
        System.out.println("Is a file: " + find.isFile());
        System.out.println("Is a folder " + find.isDirectory());
        System.out.println("Is it writable " + find.canWrite());
    }

    public static void main(String[] args) {
        System.out.println("Absolute path");
        GetINfo();

        System.out.println("Relativ path");
        GetInfo();

        System.out.println("Relativ path but simpler");
        GetInfoSimpler();

    }
}
