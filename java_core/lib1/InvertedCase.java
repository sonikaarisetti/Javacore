
import java.util.Scanner;

//23. Write a program to take a String and invert the case of characters.
public class InvertedCase{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str=sc.nextLine();

        String inverted="";

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            if(Character.isUpperCase(ch)){
                inverted+=Character.toLowerCase(ch);
            }
            else if (Character.isLowerCase(ch)) {
                inverted += Character.toUpperCase(ch);
            }
            else {
                inverted += ch; // non-alphabetic characters remain same
            }
        }
        System.out.println("inverted string is : "+ inverted);
    }
}