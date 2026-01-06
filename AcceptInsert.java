// 3. Accept details of new product and insert a row

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AcceptInsert{
    public static void main(String[] args){

        String url="jdbc:sqlserver://localhost:1433;databaseName=sales_db;encrypt=false";
        String user="sa";
        String password="Sonu@123";
        Scanner sc = new Scanner(System.in);

        try {
            Connection con=DriverManager.getConnection(url, user, password);
            System.out.println("sales_db Database Connected Successfully");

            System.out.println("enter new product id: ");
            int prod_id=sc.nextInt();

            String pricequery="SELECT price FROM products WHERE prod_id=?";
            PreparedStatement ps1=con.prepareStatement(pricequery);
            ps1.setInt(1, prod_id);

            ResultSet rs=ps1.executeQuery();

            while(!rs.next()){
                System.out.println("Invalid product id");
                return;
            }

            double price=rs.getDouble("price");

            System.out.println("enter quantity: ");
            int qty=sc.nextInt();
            
            double amount=price*qty;
            ps1.close();
            String query="INSERT INTO sales(prod_id,trans_date,qty,amount) VALUES(?,GETDATE(),?,?)";
            
            PreparedStatement ps= con.prepareStatement(query);

            ps.setInt(1,prod_id);
            ps.setInt(2,qty);
            ps.setDouble(3,amount);

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