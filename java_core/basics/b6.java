
import java.util.Scanner;

//7. Write a program to accept the number and display the number in reverse order.

public class b6{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int num=sc.nextInt();
        //int temp=num;
        int rem;
        int run=0;
        while(num>0){
            rem=num%10;
            run=run*10+rem;
            num=num/10;
        }
        System.out.println("reverse of the entered number is "+run);
    }
}