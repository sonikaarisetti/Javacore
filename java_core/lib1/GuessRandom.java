//18. Write a program to guess the random number in three attempts. The range is (1 to 25).
import java.util.*;

public class GuessRandom{
    public static void main(String[] args){
        Random r= new Random();
        Scanner sc=new Scanner(System.in);

        int random=r.nextInt(25)+1;

        int guess;
        boolean guessedCorrect=false;

        System.out.println("Guess the number between 1 and 25");
        System.out.println("You have 3 attempts.");

        for (int i = 1; i <= 3; i++) {
            System.out.print("Attempt " + i + ": ");
            guess = sc.nextInt();

            if(guess==random){
                System.out.println("you guessed correctly");
                guessedCorrect=true;
                break;
            }
            else{
                System.out.println("wrong guess");
            }
        }

        if(!guessedCorrect){
            System.out.println("Sorry! the correct number was "+random);
        }
    }
}