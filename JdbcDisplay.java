import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JdbcDisplay{
    public static void main(String[] args){

        String url="jdbc:sqlserver://localhost:1433;databaseName=sales_db;encrypt=false";
        String user="sa";
        String password="Sonu@123";

        try {
            Connection con=DriverManager.getConnection(url, user, password);
            System.out.println("sales_db Database Connected Successfully");

            String query="SELECT c.cat_desc,AVG(p.price) AS avg_price FROM categories c JOIN products p ON c.cat_code=p.cat_code GROUP BY c.cat_desc";
            
            Statement stmt=con.createStatement();

            ResultSet rs=stmt.executeQuery(query);

            while(rs.next()){
                String catDesc=rs.getString("cat_desc");
                double avgPrice=rs.getDouble("avg_price");
                System.out.println(catDesc+" "+avgPrice);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}