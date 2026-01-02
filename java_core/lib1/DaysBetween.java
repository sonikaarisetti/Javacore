import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

//26. Write a program to accept starting_date and ending_date in DD-MM-YYYY format and display no of days between those two dates.

public class DaysBetween{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter start date(DD-MM-YYYY): ");
        String startstr=sc.nextLine();
        System.out.println("enter end date: ");
        String endstr=sc.nextLine();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate startdate = LocalDate.parse(startstr,dtf);
        LocalDate enddate = LocalDate.parse(endstr,dtf);

        long daysBetween = ChronoUnit.DAYS.between(startdate, enddate);

        System.out.println("Number of days between: " + daysBetween);

        sc.close();
 
    }
}