package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Student getStudentInfo() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter firstname, lastname, major, gpa");
        String text = keyboard.nextLine();
        String[] split = text.split(",");
        String firstName = split[0].trim();
        String lastName = split[1].trim();
        String major = split[2].trim();
        double gpa = Double.parseDouble(split[3]);
        return new Student(0, firstName, lastName, major, gpa);
    }

    public static Faculty getFacultyInfo() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter firstname, lastname, department, email");
        String text = keyboard.nextLine();
        String[] split = text.split(",");
        String firstName = split[0].trim();
        String lastName = split[1].trim();
        String department = split[2].trim();
        String email = split[3].trim();
        return new Faculty(0, firstName, lastName, department, email);
    }

    public static Course getCourseInfo() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter Department, Number, Title, Credits, FacultyID, CourseName");
        String text = keyboard.nextLine();
        String[] split = text.split(",");

        String department = split[0].trim();
        int number = Integer.parseInt(split[1].trim());
        String title = split[2].trim();
        int credits = Integer.parseInt(split[3].trim());
        int facultyId = Integer.parseInt(split[4].trim());
        String courseName = split[5].trim();

        return new Course(0, department, number, title, credits, facultyId, courseName);
    }


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;

        while (choice != 11) {
            System.out.println();
            System.out.println("==== MAIN MENU ====");
            System.out.println("1 - Add Student");
            System.out.println("2 - View Students");
            System.out.println("3 - Update Student");
            System.out.println("4 - Delete Student (not implemented)");
            System.out.println("5 - Add Faculty");
            System.out.println("6 - View Faculty");
            System.out.println("7 - Update Faculty");
            System.out.println("8 - Add Course");
            System.out.println("9 - View Courses");
            System.out.println("10 - Update Course");
            System.out.println("11 - Quit");
            System.out.print("Enter choice: ");

            choice = Integer.parseInt(keyboard.nextLine());

            if (choice == 1) {
                CollegeDB.addStudent(getStudentInfo());
            } else if (choice == 2) {
                ArrayList<Student> students = CollegeDB.getStudents();
                for (Student student : students) {
                    System.out.println(student);
                }
            } else if (choice == 3) {
                System.out.print("Enter student ID to update: ");
                int id = Integer.parseInt(keyboard.nextLine());
                ArrayList<Student> students = CollegeDB.getStudent(id);
                if (students.isEmpty()) {
                    System.out.println("ID not found!");
                } else {
                    Student s = getStudentInfo();
                    s.setID(id);
                    CollegeDB.updateStudent(s);
                }
            } else if (choice == 5) {
                CollegeDB.addFaculty(getFacultyInfo());
            } else if (choice == 6) {
                ArrayList<Faculty> facultyList = CollegeDB.getFaculty();
                for (Faculty f : facultyList) {
                    System.out.println(f);
                }
            } else if (choice == 7) {
                System.out.print("Enter faculty ID to update: ");
                int id = Integer.parseInt(keyboard.nextLine());
                ArrayList<Faculty> list = CollegeDB.getFaculty();
                Faculty found = null;
                for (Faculty f : list) {
                    if (f.getId() == id) {
                        found = f;
                        break;
                    }
                }
                if (found == null) {
                    System.out.println("ID not found!");
                } else {
                    Faculty updated = getFacultyInfo();
                    updated.setId(id);
                    CollegeDB.updateFaculty(updated);
                }
            } else if (choice == 8) {
                CollegeDB.addCourse(getCourseInfo());
            } else if (choice == 9) {
                ArrayList<Course> courses = CollegeDB.getCourses();
                for (Course c : courses) {
                    System.out.println(c);
                }
            } else if (choice == 10) {
                System.out.print("Enter course ID to update: ");
                int id = Integer.parseInt(keyboard.nextLine());
                ArrayList<Course> courses = CollegeDB.getCourses();
                Course found = null;
                for (Course c : courses) {
                    if (c.getId() == id) {
                        found = c;
                        break;
                    }
                }
                if (found == null) {
                    System.out.println("ID not found!");
                } else {
                    Course updated = getCourseInfo();
                    updated.setId(id);
                    CollegeDB.updateCourse(updated);
                }
            } else if (choice == 11) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid option!");
            }
        }
    }
}
