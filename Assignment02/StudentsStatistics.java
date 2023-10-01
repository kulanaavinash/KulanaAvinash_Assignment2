import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/**
 * This is a program to compute statistics of students marks in an assignment.
 *
 * @author (Kulana Avinash Welihena Vithanage)
 * @version (version 1.0 28/09/2023)
 */
public class StudentsStatistics
{
    public static void main(String[] args) {
        String csvFile = "prog5001_students_grade_2022.csv";
        String line;
        String delimiter = ",";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                String lastName = data[0];
                String firstName = data[1];
                String studentID = data[2];
                int a1 = Integer.parseInt(data[3]);
                int a2 = Integer.parseInt(data[4]);
                int a3 = Integer.parseInt(data[5]);
                Student student = new Student(lastName, firstName, studentID, a1, a2, a3);
                students.add(student);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor for objects of class StudentsStatistics
     */
    public StudentsStatistics()
    {
        // initialise instance variables

    }

   
}
