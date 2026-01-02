//21. Write a program to accept a string that contains marks separated by commas and display total.

import java.util.Scanner;

public class TotalMarks{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        // Accept string input
        System.out.print("Enter marks separated by commas: ");
        String input = sc.nextLine();

        // Split the string by comma
        String[] marksArray = input.split(",");

        int total = 0;

        // Convert each mark to int and sum
        for (String mark : marksArray) {
            total += Integer.parseInt(mark.trim()); // trim removes spaces
        }

        // Display total
        System.out.println("Total Marks = " + total);

        sc.close();
    }
}