//13. Introduce multiple constructors in Product class.

class Products{
    int prod_id;
    String prod_name;
    double price;
    int quantity_on_hand=0;//initially 0 stock

    Products(){
        quantity_on_hand=0;
    }

    Products(int id,String name,double price){
        this.prod_id=id; //assigning values
        this.prod_name=name;
        this.price=price;
    }

    Products(int id,String name,double price,int quant){
        this.prod_id=id; //assigning values
        this.prod_name=name;
        this.price=price;
        this.quantity_on_hand=quant;
    }

    double getNetPrice(){
        return price+price*(0.12);
    }

    void purchase(){
        quantity_on_hand++;
    }

    void sell(){
        if(quantity_on_hand>0){
            quantity_on_hand--;
        }
        else{
            System.out.println("no stock available");
        }
    }

    void display() {
        System.out.println("ID: " + prod_id);
        System.out.println("Name: " + prod_name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity_on_hand);
    }
}
public class sol2{
    public static void main(String[] args){
        Products p1=new Products();
        Products p2=new Products(123,"Mobile",35000);
        Products p3=new Products(234,"lappy",150000,4);
        p2.purchase();
        p2.purchase();

        p3.sell();
        p2.display();
        System.out.println("price of "+p2.prod_name+" is "+p2.getNetPrice());

        p3.display();
        System.out.println("price of "+p3.prod_name+" is "+p3.getNetPrice());
    }
}