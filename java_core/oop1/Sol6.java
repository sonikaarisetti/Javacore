//17. Create classes to store details for two different types of Products,
//    a) ImportedProducts which have import duty.
//    b) DiscountedProducts which have a discount rate.
// All products have name and base_price.Create required Constructors and following methods: print(), getNetPrice(), setPrice(),
//  setImportDuty(), setDiscountRate() also experiment with upcasting and downcasting.


abstract class Product {

    protected String name;
    protected double base_price;

    Product(String name, double base_price) {
        this.name = name;
        this.base_price = base_price;
    }

    void setPrice(double price) {
        this.base_price = price;
    }

    void print() {
        System.out.println("Product Name : " + name);
        System.out.println("Base Price   : " + base_price);
    }

    abstract double getNetPrice();
}

class ImportedProduct extends Product {

    private double importDuty; // percentage

    ImportedProduct(String name, double base_price, double importDuty) {
        super(name, base_price);
        this.importDuty = importDuty;
    }

    void setImportDuty(double duty) {
        this.importDuty = duty;
    }

    double getNetPrice() {
        return base_price + (base_price * importDuty / 100);
    }
}

class DiscountedProduct extends Product {

    private double discountRate; // percentage

    DiscountedProduct(String name, double base_price, double discountRate) {
        super(name, base_price);
        this.discountRate = discountRate;
    }

    void setDiscountRate(double rate) {
        this.discountRate = rate;
    }

    double getNetPrice() {
        return base_price - (base_price * discountRate / 100);
    }
}

public class Sol6{
    public static void main(String[] args) {

        // 🔼 Upcasting
        Product p1 = new ImportedProduct("Laptop", 50000, 10);
        Product p2 = new DiscountedProduct("Mobile", 20000, 5);

        p1.print();
        System.out.println("Net Price : " + p1.getNetPrice());
        System.out.println();

        p2.print();
        System.out.println("Net Price : " + p2.getNetPrice());
        System.out.println();

        // 🔽 Downcasting
        if (p1 instanceof ImportedProduct) {
            ImportedProduct ip = (ImportedProduct) p1;
            ip.setImportDuty(15);
            System.out.println("After changing duty:");
            System.out.println("Net Price : " + ip.getNetPrice());
        }
    }
}