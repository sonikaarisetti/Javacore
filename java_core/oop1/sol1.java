//12. Create a class(Product) to store details of a product and provide required methods with the details prod_id, prod_name, price,quantity_on_hand
// Methods are:  init(prod_id,prod_name, price)
//                  getNetPrice() (returns the price after adding 12% tax)
//                  purchase()
//                 sell()
class Product{
    int prod_id;
    String prod_name;
    double price;
    int quantity_on_hand=0;//initially 0 stock

    void init(int id,String name,double price){
        this.prod_id=id; //assigning values
        this.prod_name=name;
        this.price=price;
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
}
public class sol1{
    public static void main(String[] args){
        Product p=new Product();
        p.init(123,"book",500);
        p.purchase();
        p.purchase();

        p.sell();
        System.out.println(p.getNetPrice());

    }
}