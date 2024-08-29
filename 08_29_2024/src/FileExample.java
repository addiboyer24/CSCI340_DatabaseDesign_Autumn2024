import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileExample {
    public static void main(String[] args) throws FileNotFoundException {
        List<Student> myStudents = getStudents();
        for(Student myStudent: myStudents){
            System.out.println(myStudent);
        }
    }

    public static List<Student> getStudents() throws FileNotFoundException{
        File studentFile = new File("./08_29_2024/src/Student.txt");
        Scanner myScanner = new Scanner(studentFile);
        myScanner.nextLine(); // Skip data member names.
        ArrayList<Student> myStudents = new ArrayList<Student>();

        // Read students from file until there are no more.
        while(myScanner.hasNextLine()){
            String myLine = myScanner.nextLine().replaceAll("\n","");
            String[] tokens = myLine.split(",");
            int id = Integer.parseInt(tokens[0]);
            String name = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String email = tokens[3];
            Student myStudent = new Student(id, name, age, email);
            myStudents.add(myStudent);
        }
        return myStudents;
    }
}
