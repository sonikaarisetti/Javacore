//11. Write a program to consider command line arguments num, length as inputs (where length is optional) if you won't get that use default number as length.

public class b10{
    public static void main(String[] args) {
        int num;
        int len=5;//default
        if(args.length<1){
            System.out.println("enter at least 1 argument!!!");
            return;
        }
        else if(args.length==1){
            num=Integer.parseInt(args[0]);
        }
        else{
            num=Integer.parseInt(args[0]);
            len=Integer.parseInt(args[1]); 
        }
        System.out.println("number is "+num+" and length is "+len);
    }
}