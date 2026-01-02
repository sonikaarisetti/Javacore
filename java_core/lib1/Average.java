//19. Write a program to create an array of 10 elements, fill it with random no's and display array elements which 
// are greater than average of array.


import java.util.Random;

public class Average {
    public static void main(String[] args) {

        int[] arr = new int[10];
        Random r = new Random();

        int sum = 0;

        // Fill array with random numbers (1 to 100)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100) + 1;
            sum += arr[i];
        }

        // Calculate average
        double average = (double) sum / arr.length;

        // Display array elements
        System.out.println("Array elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n\nAverage = " + average);

        // Display elements greater than average
        System.out.println("\nElements greater than average:");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > average) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}