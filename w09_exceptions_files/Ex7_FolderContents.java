package teme.w09_exceptions_files;

import java.io.File;


public class Ex7_FolderContents {
    public static void GetINfo() {
        long sum = 0;
        File file = new File("C:\\Users\\pc\\IdeaProjects\\teme_alex_zaharia\\clasa");
        File[] holdFilesAndFolders = file.listFiles();
        for (File search : holdFilesAndFolders
        ) {
            sum = sum + search.length();
            System.out.println("The name of the file is " + search.getName() + " and its size is " + search.length());
            System.out.println("The total size is: " + sum);
        }
    }

    public static void main(String[] args) {

        GetINfo();
    }
}
