//16. Create a subclass called FactoryEmployee, for all factory employees we need to store bus_no, emp_boards.
//Create a super class related to this subclass.

class Employee{
    public int emp_id;
    public String emp_name;
    public double salary;

    Employee(int id,String name,double salary){
        this.emp_id=id;
        this.emp_name=name;
        this.salary=salary;
    }

    void display(){
        System.out.println("employee id: "+emp_id);
        System.out.println("employee name: "+emp_name);
        System.out.println("employee salary: "+salary);
    }
}

class FactoryEmployee extends Employee{
    private int bus_no;
    private String emp_boards;
    FactoryEmployee(int id,String name,double salary,int bus_no,String emp_boards){
        super(id,name,salary);
        this.bus_no=bus_no;
        this.emp_boards=emp_boards;   
    }

    void display(){
        super.display();
        System.out.println("employee bus_no: "+bus_no);
        System.out.println("empployee boards: "+emp_boards);
    }

}

public class Sol5{
    public static void main(String[] args) {
           FactoryEmployee fe=new FactoryEmployee(1,"sonika",25000,12,"Car Shed");
           fe.display();
    }
}