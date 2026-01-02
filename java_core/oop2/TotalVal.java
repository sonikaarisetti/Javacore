//29. Accept five strings which contain numbers and display the total for those numbers. Make your program fault tolerant.
import java.util.Scanner;

public class TotalVal{
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int total=0;

        System.out.println("Enter 5 numbers:");

        for(int i=1;i<=5;i++){
            //we can do directly like this or we can store in an array can access them
            String s=sc.nextLine();

            try {
                int num = Integer.parseInt(s);
                total+=num;
            }
            catch(NumberFormatException e){
                System.out.println("Invalid number ignored: " + s);
            }
        }

        System.out.println("Total = "+total);
        sc.close();
    }
}