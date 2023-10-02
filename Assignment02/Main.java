import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.File;

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

    // Implement Getters and setters for student attributes
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
}
class StudentsStatistics
{
    // Method to initialize student data from a list of strings
    List<Student> initializeData(List<String> data){
        List<Student> studentList = new ArrayList<>();
		String unitName = "";
		return studentList;
    }
    
}

public class Main
{
    public static void main(String[] args) {
       
    }

}
