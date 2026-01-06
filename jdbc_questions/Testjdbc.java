import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Testjdbc {
    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=sales_db;encrypt=false";
        String user = "sa";
        String password = "Sonu@123";

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("sales_db Database Connected Successfully");

            System.out.print("Enter product id: ");
            int prod_id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new product name: ");
            String prod_name = sc.nextLine();

            String sql = "UPDATE products SET prod_name = ? WHERE prod_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,prod_name);
            ps.setInt(2, prod_id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(rows + " record updated successfully");
            } else {
                System.out.println("No record found with given product id");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
