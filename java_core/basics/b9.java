//10. Write a program to create a function that takes multiple numbers and displays common factors.
class CommonFactors{
    void findCommonFactors(int... nums){
        int smallest=nums[0];
        for(int num : nums){
            if(num<smallest){
                smallest=num;
            }
        }
        for(int i=1;i<=smallest;i++){
            boolean isCommon=true;
            for(int num:nums){
                if(num%i!=0){
                    isCommon=false;
                    break;
                }
            }
            if(isCommon){
                System.out.println(i);
            }
        }
    }
}


public class b9{
    public static void main(String[] args) {
        CommonFactors obj=new CommonFactors();
        obj.findCommonFactors(10,20,30);
    }
}