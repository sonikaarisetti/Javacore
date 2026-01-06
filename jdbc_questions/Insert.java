import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert{
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=sales_db;encrypt=false";
        String user = "sa";
        String password = "Sonu@123";

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected");

            System.out.print("Enter product name: ");
            String name = sc.nextLine();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            System.out.print("Enter quantity on hand: ");
            int qoh = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter remarks: ");
            String remarks = sc.nextLine();

            System.out.print("Enter category code: ");
            String catCode = sc.nextLine();

            String sql ="INSERT INTO products (prod_name,price,qoh,remarks,cat_code) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setDouble(2,price);
            ps.setInt(3,qoh);
            ps.setString(4,remarks);
            ps.setString(5,catCode);

            ps.executeUpdate();
            System.out.println("Product inserted successfully");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

