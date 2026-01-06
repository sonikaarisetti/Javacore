import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Testjdbc{
    public static void main(String[] args){

        String url="jdbc:sqlserver://localhost:1433;databaseName=sales_db;encrypt=false";
        String user="sa";
        String password="Sonu@123";
        Scanner sc = new Scanner(System.in);

        try {
            Connection con=DriverManager.getConnection(url, user, password);
            System.out.println("sales_db Database Connected Successfully");
            System.out.println("enter product id: ");
            int prod_id=sc.nextInt();
            sc.nextLine();

            System.out.println("enter new product name: ");
            String prod_name=sc.nextLine();

            String query="update products set prod_name=? where prod_id=?";

            PreparedStatement ps= con.prepareStatement(query);

            ps.setString(1,prod_name);
            ps.setInt(2, prod_id);

            int row=ps.executeUpdate();

            if(row>0){
                System.out.println(row+" updated successfully");
            }else{
                System.out.println("no record found");
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}