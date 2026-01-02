//32. Write a program to accept some numbers from the user until 'O' and display the sum of +ve numbers.
import java.util.Scanner;

public class PositiveSum{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sum = 0;

        System.out.println("Enter numbers (Enter O to stop):");

        while (true) {
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("O")) {
                break;
            }

            try {
                int num = Integer.parseInt(input);
                if (num > 0) {
                    sum += num;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input ignored");
            }
        }

        System.out.println("Sum of positive numbers = " + sum);
        sc.close();
    }
}