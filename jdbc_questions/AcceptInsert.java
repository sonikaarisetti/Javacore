import java.sql.*;
import java.util.Scanner;

public class AcceptInsert{
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=sales_db;encrypt=false";
        String user = "sa";
        String password = "Sonu@123";

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected Successfully");

            System.out.print("Enter Product ID: ");
            int prodId = sc.nextInt();

            String priceQuery = "SELECT price FROM products WHERE prod_id = ?";
            PreparedStatement ps1 = con.prepareStatement(priceQuery);
            ps1.setInt(1, prodId);

            ResultSet rs = ps1.executeQuery();

            if (!rs.next()) {
                System.out.println("Invalid Product ID");
                return;
            }

            double price = rs.getDouble("price");

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();

            double amount = price * qty;

            String insertQuery="INSERT INTO sales (prod_id, trans_date, qty, amount) VALUES (?, GETDATE(), ?, ?)";

            PreparedStatement ps2 = con.prepareStatement(insertQuery);
            ps2.setInt(1, prodId);
            ps2.setInt(2, qty);
            ps2.setDouble(3, amount);

            int rows = ps2.executeUpdate();

            if (rows > 0) {
                System.out.println("Sale transaction recorded successfully");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

