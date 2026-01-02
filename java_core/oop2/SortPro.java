//28. Design classes that need to sort a collection of Product objects either by product name or by price.
import java.util.*;

class Product {
    private String name;
    private double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
}

// Comparator to sort by name
class SortByName implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().compareTo(p2.getName());
    }
}

// Comparator to sort by price
class SortByPrice implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}

// Main class (ONLY public class)
public class SortPro {
    public static void main(String[] args) {

        ArrayList<Product> list = new ArrayList<>();

        list.add(new Product("Laptop", 55000));
        list.add(new Product("Mouse", 500));
        list.add(new Product("Keyboard", 1500));
        list.add(new Product("Monitor", 12000));

        System.out.println("Original List:");
        System.out.println(list);

        Collections.sort(list, new SortByName());
        System.out.println(list);

        Collections.sort(list, new SortByPrice());
        System.out.println(list);
    }
}