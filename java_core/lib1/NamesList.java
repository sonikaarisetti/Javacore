//25. Write a program to accept names until the END is given and display all the names separated by '-'.

import java.util.Scanner;

class NamesList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String names = ""; // Using String instead of StringBuilder

        System.out.println("Enter names one by one (type END to stop):");

        while (true) {
            String name = sc.nextLine();

            if (name.equalsIgnoreCase("END")) {
                break;
            }

            if (!names.equals("")) {
                names += "-"; // Add hyphen if it's not the first name
            }
            names += name;
        }

        System.out.println("Names: " + names);

        sc.close();
    }
}