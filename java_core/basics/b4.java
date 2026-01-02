public class b4{
    public static void main(String args[]){
        if(args.length == 0){
            System.out.println("no arguments passed");
            return;
        }
        int total=0;
        for(String s : args){
            total += Integer.parseInt(s);
        }
        double avg=(double) total/args.length;

        System.out.printf("average is : %.2f",avg);
    }
}