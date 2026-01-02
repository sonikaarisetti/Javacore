
import java.util.Scanner;

//8. Write a program to create an array of 5 elements and store values into it by taking them from the keyboard
//  and display them in reverse order.

public class b7{
    void reverse(int[] arr,int n){
        int left=0, right=n-1;
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        System.out.print("the reversed array is : ");
        for(int i=0;i<n;i++){
            System.out.printf("%d ",arr[i]);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<5;i++){
            arr[i]=sc.nextInt();
        }
        b7 obj = new b7();//object creation to call method of the same class
        obj.reverse(arr,5);
    }
}