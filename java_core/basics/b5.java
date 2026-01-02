// 6. Write a program to accept the number and display the largest factor other than the number

import java.util.*;
public class b5{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num =sc.nextInt();
        int res=1;
        for(int i=2;i<num;i++){
            if(num%i==0){
                res=i;
            }
        }
        System.out.println("the highest factor other than given number is "+res);
    }
}