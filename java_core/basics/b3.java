import java.util.*;

public class b3{
    public static void main(String args[]){
        Wage.printWageCalculator();
        Table.printTable();
    }
}
class Table{
    static void printTable(){
        for(int i=1;i<=10;i++){
            System.out.printf("15 * %d = %d\n",i,15*i);
        }
    }
}
class Wage{
    static void printWageCalculator(){
        Scanner sc = new Scanner(System.in);
        System.out.println("which day enter from 1 to 7: ");
        int day = sc.nextInt();
        System.out.println("number of hours worked: ");
        int hrs = sc.nextInt();

        int wage= switch(day){
            case 1,2,3 -> 200;
            case 4,5 -> 400;
            case 6 -> 600;
            case 7 -> 800;
            default -> 0;
        };

        double total = wage * hrs;
        if(total>2000){
            total+=total*0.1;
        }
        System.out.printf("total wage is : %.2f",total);

        sc.close();
    }
}