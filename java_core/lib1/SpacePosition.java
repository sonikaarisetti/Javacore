
import java.util.Scanner;

//22. Write a program to accept a string and display the position of space for all spaces.

public class SpacePosition{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String line=sc.nextLine();

        for(int i=0;i<line.length();i++){
            if(line.charAt(i)==' '){
                System.out.println(i);
            }
        }
    }
}