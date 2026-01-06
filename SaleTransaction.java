// 3. Accept details of new product and insert a row

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SaleTransaction{
    public static void main(String[] args){

        String url="jdbc:sqlserver://localhost:1433;databaseName=sales_db;encrypt=false";
        String user="sa";
        String password="Sonu@123";
        Scanner sc = new Scanner(System.in);

        Connection con=null;

        try {
            con=DriverManager.getConnection(url, user, password);
            System.out.println("sales_db Database Connected Successfully");

            con.setAutoCommit(false);
            System.out.println("enter new product id: ");
            int prod_id1=sc.nextInt();

            // String pricequery="SELECT price FROM products WHERE prod_id=?";
            // PreparedStatement ps1=con.prepareStatement(pricequery);
            // ps1.setInt(1, prod_id);

            // ResultSet rs=ps1.executeQuery();

            // while(!rs.next()){
            //     System.out.println("Invalid product id");
            //     return;
            // }

            // double price=rs.getDouble("price");

            System.out.println("enter quantity: ");
            int qty1=sc.nextInt();
            
            // double amount=price*qty;

            String query="INSERT INTO sales(prod_id,trans_date,qty,amount) VALUES(?,GETDATE(),?,?*(SELECT price FROM products WHERE prod_id=?))";
            
            PreparedStatement ps= con.prepareStatement(query);

            ps.setInt(1,prod_id1);
            ps.setInt(2,qty1);
            ps.setInt(3,qty1);
            ps.setInt(4,prod_id1);

            int row=ps.executeUpdate();

            if(row>0){
                System.out.println(row+" updated successfully");
            }else{
                System.out.println("no record found");
            }

            ps.close();

            System.out.println("enter product 2 ID: ");
            int prod2=sc.nextInt();
            System.out.println("enter quantity: ");
            int qty2=sc.nextInt();

            String query1="INSERT INTO sales(prod_id,trans_date,qty,amount) VALUES(?,GETDATE(),?,?*(SELECT price FROM products WHERE prod_id=?))";
            
            PreparedStatement ps1= con.prepareStatement(query1);

            ps1.setInt(1,prod2);
            ps1.setInt(2,qty2);
            ps1.setInt(3,qty2);
            ps1.setInt(4,prod2);

            int rows=ps1.executeUpdate();

            if(rows>0){
                System.out.println(row+" updated successfully");
            }else{
                System.out.println("no record found");
            }

            ps1.close();

            con.commit();
            System.out.println("Transaction committed successfullt");

        } catch (Exception e) {
            try{
                if(con != null){
                    con.rollback();
                    System.out.println("transaction rolled back");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        finally{
            try {
                if(con!=null){
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}