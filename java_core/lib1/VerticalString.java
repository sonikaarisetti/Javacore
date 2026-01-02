//20. Write a program to accept a string from the user and display it vertically. use nextLine() to read a string from the user.

import java.util.Scanner;

class VerticalString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Accept string from user
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Display each character vertically
        System.out.println("\nString displayed vertically:");
        for (int i = 0; i < input.length(); i++) {
            System.out.println(input.charAt(i));
        }

        sc.close();
    }
}