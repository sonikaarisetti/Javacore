import java.io.File;
import java.util.Scanner;

public class ListFiles {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String path = sc.nextLine();

        File file = new File(path);

        if (file.exists() && file.isDirectory()) {

            File[] files = file.listFiles();

            System.out.println("Files in the directory:");

            for (File f : files) {
                System.out.println(f.getName());
            }

        } else {
            System.out.println("Invalid directory path");
        }
    }
}