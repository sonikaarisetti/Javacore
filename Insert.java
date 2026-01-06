// 3. Accept details of new product and insert a row

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert{
    public static void main(String[] args){

        String url="jdbc:sqlserver://localhost:1433;databaseName=sales_db;encrypt=false";
        String user="sa";
        String password="Sonu@123";
        Scanner sc = new Scanner(System.in);

        try {
            Connection con=DriverManager.getConnection(url, user, password);
            System.out.println("sales_db Database Connected Successfully");

            System.out.println("enter new product name: ");
            String prod_name=sc.nextLine();

            System.out.println("enter priceof the product: ");
            double price=sc.nextDouble();

            System.out.println("enter quantity: ");
            int qoh=sc.nextInt();
            sc.nextLine();

            System.out.println("enter remarks: ");
            String remarks=sc.nextLine();

            System.out.println("enter category code: ");
            String cat_code=sc.nextLine();

            String query="INSERT INTO products(prod_name,price,qoh,remarks,cat_code) VALUES(?,?,?,?,?)";
            
            PreparedStatement ps= con.prepareStatement(query);

            ps.setString(1,prod_name);
            ps.setDouble(2, price);
            ps.setInt(3,qoh);
            ps.setString(4,remarks);
            ps.setString(5,cat_code);

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