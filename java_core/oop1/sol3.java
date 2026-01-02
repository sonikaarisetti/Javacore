//14. Create a class called Counter that stores a number and provides methods to increment, decrement and return the count. 
// Provide the constructor without parameters that sets the values to zero and another constructor with parameters takes the 
// values and starts from there.

class Counter{
    int count;

    Counter(){
        this.count=0;
    }
    Counter(int val){
        this.count=val;
    }

    void increment(){
        count++;
    }
    void decrement(){
        count--;
    }
    int getCount(){
        return count;
    }
}

public class sol3{
    public static void main(String[] args) {
        Counter c1=new Counter();
        c1.increment();
        c1.increment();
        c1.decrement();
        System.out.println(c1.getCount());

        Counter c2=new Counter(10);
        c2.decrement();
        c2.decrement();
        c2.increment();
        System.out.println(c2.getCount());
    }
}