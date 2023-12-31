import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.InputMismatchException;

/**
 * This is a program to compute statistics of students marks in an assignment.
 *
 * @author (Kulana Avinash Welihena Vithanage)
 * @version (version 1.0 28/09/2023)
 */

// Define the Student class to store student information
class Student
{
    private String firstName;
    private String lastName;
    private String unitName;
    private String studentId;
    private double a1;
    private double a2;
    private double a3;

    //Implement Getters and setters for student attributes
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getA1() {
        return a1;

    }

    public void setA1(double a1) {
        this.a1 = a1;
    }

    public double getA2() {
        return a2;

    }

    public void setA2(double a2) {
        this.a2 = a2;
    }

    public double getA3() {
        return a3;

    }

    public void setA3(double a3) {
        this.a3 = a3;
    }

    // Calculate and return the total marks for the student
    public double calculateTotalMarks() {
        return a1 + a2 + a3;
    }
}

class StudentsStatistics
{
    // Method to calculate and display total marks for each student
    void calculateTotalMarks(List<Student> students) {
        for (Student student : students) {
            System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Student Id: " + student.getStudentId());
            System.out.println("A1: " + student.getA1());
            System.out.println("A2: " + student.getA2());
            System.out.println("A3: " + student.getA3());
            double total = student.calculateTotalMarks();
            System.out.println("Total Mark: " + total);
            System.out.println();
        }

    }
    // Method to initialize student data from a list of strings
    List<Student> initializeData(List<String> data){
        List<Student> studentList = new ArrayList<>();
        String unitName = "";
        //Data Processing Loop
        for (int i = 0; i < data.size(); i++) {
            //Handling Unit Name
            if (i == 0) {
                unitName = data.get(0);
                
            } 
            //Student data processing
            else if (i >= 2) {
                String[] values = data.get(i).split(",");
                //checking for comments
                if (!values[0].startsWith("#")) {
                    //Creating and populating bstudent objects.
                    Student student = new Student();
                    student.setFirstName(values[0]);
                    student.setLastName(values[1]);
                    student.setUnitName(unitName);
                    student.setStudentId(values[2]);

                    if (values.length > 3 && !values[3].isEmpty()) {
                        student.setA1(Double.parseDouble(values[3].trim()));
                    } else {
                        student.setA1(0);
                    }

                    if (values.length > 4 && !values[4].isEmpty()) {
                        student.setA2(Double.parseDouble(values[4].trim()));
                    } else {
                        student.setA2(0);
                    }

                    if (values.length > 5 && !values[5].isEmpty()) {
                        student.setA3(Double.parseDouble(values[5].trim()));
                    } else {
                        student.setA3(0);
                    }

                    studentList.add(student);
                }
            }
        }
        return studentList;

    }
    // Method to display student data read from a file
    void readFromFile(List<Student> students) {
        for (Student student : students) {
            String unitName = students.get(0).getUnitName();
            System.out.println("Unit Name: " + unitName);
            System.out.println();
            System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Student Id: " + student.getStudentId());
            System.out.println("A1: " + student.getA1());
            System.out.println("A2: " + student.getA2());
            System.out.println("A3: " + student.getA3());
            System.out.println();
        }
    }
    // Method to list students with total marks below a threshold
    void listStudentsBelowThreshold(double threshold, List<Student> students) {
        int count = 0;

        for (Student student : students) {
            double totalMarks = student.calculateTotalMarks();
            if (totalMarks < threshold) {
                count++;
                System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
            }
        }

        if (count == 0) {
            System.out.println("No students scored below the threshold.");
        }
    }

    // Method to show the top 5 students with the highest marks and lowest marks
    void showStudentsWithLowestAndHighestMarks(List<Student> students) {
        students.sort((s1, s2) -> {
                    double total1 = s1.calculateTotalMarks();
                    double total2 = s2.calculateTotalMarks();
                    return Double.compare(total1, total2);
            });

        System.out.println("-----------Top 5 Highest Mark Students--------------");
        System.out.println("-----------***************************--------------");

        System.out.println();
        int n = students.size();
        for (int i = n - 1; i >= Math.max(n - 5, 0); i--) {
            Student student = students.get(i);
            double totalMarks = student.calculateTotalMarks();
            System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Total Mark: " + totalMarks);
            System.out.println();
        }
        System.out.println("-----------Top 5 Lowest Mark Students---------------");
        System.out.println("-----------***************************--------------");
        System.out.println();
        for (int i = 0; i < Math.min(5, n); i++) {
            Student student = students.get(i);
            double totalMarks = student.calculateTotalMarks();
            System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Total Mark: " + totalMarks);
            System.out.println();
        }
    }
}
public class Main
{
    public static void main(String[] args) {
        System.out.println("##----System For Compute Statistic of Students----##");
        System.out.println("##************************************************##");
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPlease enter the file name:");
        String fileName = sc.next();
        StudentsStatistics obj = new StudentsStatistics();

        List<String> values = new ArrayList<>();
        String row;
        try {
            File csvFile = new File("" + fileName);
            FileReader fileReader = new FileReader(csvFile);
            BufferedReader br = new BufferedReader(fileReader);

            while ((row = br.readLine()) != null) {
                values.add(row);
            }
            //calling menu method and take two parameters as values and obj
            menu(values, obj);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

    }
    // Method to display the main menu 
    static void menu(List<String> values, StudentsStatistics obj) {
        Scanner sc = new Scanner(System.in);

        List<Student> studentsList = new ArrayList<>();
        studentsList = obj.initializeData(values);
        if (!studentsList.isEmpty()) {
            System.out.println("\nThis file contains the marks of " + studentsList.get(0).getUnitName());
        }
        System.out.println("\nYou can choose an option from the menu below:");
        try {
            int option = 0;
            while (option != 5) {
                System.out.println(
                    "\n----------------------Welcome to the Student marks management System-------------------------");
                System.out.println("-------------------------***************************------------------------------------");

                System.out.println("\n1. Read students data");
                System.out.println("2. Calculate the total marks for each student");
                System.out.println("3. List the students with total marks less than a certain threshold");
                System.out.println("4. Show five students with the highest and lowest marks");
                System.out.println("5. Exit the program");
                System.out.print("\nPlease enter your choice (1-5): ");

                option = sc.nextInt();
                switch (option) {
                    case 1:
                        obj.readFromFile(studentsList);
                        continue;
                    case 2:
                        obj.calculateTotalMarks(studentsList);
                        continue;
                    case 3:
                        System.out.print("Enter the threshold value: ");
                        double threshold = sc.nextDouble();
                        obj.listStudentsBelowThreshold(threshold, studentsList);
                        continue;
                    case 4:
                        obj.showStudentsWithLowestAndHighestMarks(studentsList);
                        continue;
                    case 5:
                        System.out.println("Exit the program.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option entered.");

                }
            }
            //Input Validation Handling
        } catch (InputMismatchException e) {
            System.out.println("Invalid option entered.");
            System.out.println("Please select an option from the menu and enter a number from 1 to 5.");
            menu(values, obj);
        }
    }
}

