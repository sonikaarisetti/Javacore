// 15. Create a class Student that stores the details like admin_no, stu_name, course_joined and fees_paid.
// —> Courses are: JAVA, PYTHON.
// —> The total fees for java is 10k and for python is 7.5k.
// —> Provide a constructor to take required details.The default course is JAVA.
// —> Provide the following methods: getTotalFee(), getDue(), getFeePaid(), payment(amount).

class Student {

    // Data members
    private int admin_no;
    private String stu_name;
    private String course_joined;
    private double fees_paid;

    // Constants for course fees
    private static final double JAVA_FEE = 10000;
    private static final double PYTHON_FEE = 7500;

    // Constructor with default course = JAVA
    Student(int admin_no, String stu_name) {
        this.admin_no = admin_no;
        this.stu_name = stu_name;
        this.course_joined = "JAVA";
        this.fees_paid = 0;
    }

    // Constructor with specified course
    Student(int admin_no, String stu_name, String course_joined) {
        this.admin_no = admin_no;
        this.stu_name = stu_name;
        this.course_joined = course_joined.toUpperCase();
        this.fees_paid = 0;
    }

    // Returns total fee based on course
    double getTotalFee() {
        if (course_joined.equals("JAVA"))
            return JAVA_FEE;
        else if (course_joined.equals("PYTHON"))
            return PYTHON_FEE;
        else
            return 0;
    }

    // Returns fees paid
    double getFeePaid() {
        return fees_paid;
    }

    // Returns due amount
    double getDue() {
        return getTotalFee() - fees_paid;
    }

    // Method to make payment
    void payment(double amount) {
        fees_paid += amount;
    }
}

public class sol4 {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Sonika", "Python");

        s1.payment(3000);

        System.out.println("Total Fee: " + s1.getTotalFee());
        System.out.println("Paid: " + s1.getFeePaid());
        System.out.println("Due: " + s1.getDue());
    }
}

// public class sol4 {
//     public static void main(String[] args) {

//         // Reading inputs from command line arguments
//         int adminNo = Integer.parseInt(args[0]);
//         String name = args[1];
//         String course = args[2];
//         double amount = Double.parseDouble(args[3]);

//         // Creating Student object
//         Student s1 = new Student(adminNo, name, course);

//         // Making payment
//         s1.payment(amount);

//         // Displaying details
//         System.out.println("Total Fee : " + s1.getTotalFee());
//         System.out.println("Fee Paid  : " + s1.getFeePaid());
//         System.out.println("Fee Due   : " + s1.getDue());
//     }
// }

