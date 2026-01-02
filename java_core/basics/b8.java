
import java.util.Scanner;

//9. Write a program to create a function that takes a set of integers and returns the largest of integers.

public class b8{
    static int findMax(int[] arr){
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int max = findMax(arr); //as the method is declared as static no need to create object just call it by name or classname.method_name
        System.out.println("the largest number of the array is :"+max);
    }
}