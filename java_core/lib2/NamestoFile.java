import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NamestoFile{
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        // trying like try-with-resource
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("names.txt",true))){//true will allow to append data if file not exist file is created

            System.out.println("Enter names (type END to stop):");

            while(true){
                String name=sc.nextLine();
                
                if(name.equalsIgnoreCase("END")){
                    break;
                }

                bw.write(name);
                bw.newLine();
            }

            System.out.println("Names written to names.txt successfully");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        sc.close();
    }
}