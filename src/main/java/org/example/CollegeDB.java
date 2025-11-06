package org.example;

import java.sql.*;
import java.util.ArrayList;

public class CollegeDB {
    private static Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:sqlite:college.db";
        return DriverManager.getConnection(dbUrl);
    }

    public static void updateStudent(Student student) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Student SET FirstName = ?, LastName = ?, Major = ?, GPA = ? WHERE ID = ?");
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getMajor());
            preparedStatement.setDouble(4, student.getGpa());
            preparedStatement.setInt(5, student.getID());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public static ArrayList<Student> getStudent(int id) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Student WHERE ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String major = rs.getString("Major");
                double gpa = rs.getDouble("GPA");
                students.add(new Student(id, firstName, lastName, major, gpa));
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return students;
    }

    public static ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Student");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String major = rs.getString("Major");
                double gpa = rs.getDouble("GPA");
                students.add(new Student(id, firstName, lastName, major, gpa));
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return students;
    }

    public static void addStudent(Student student) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Student (FirstName, LastName, Major, GPA) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getMajor());
            preparedStatement.setDouble(4, student.getGpa());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public static void addFaculty(Faculty faculty) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO Faculty (FirstName, LastName, Department, Email) VALUES (?, ?, ?, ?)");
            ps.setString(1, faculty.getFirstName());
            ps.setString(2, faculty.getLastName());
            ps.setString(3, faculty.getDepartment());
            ps.setString(4, faculty.getEmail());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public static ArrayList<Faculty> getFaculty() {
        ArrayList<Faculty> facultyList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Faculty");
            while (rs.next()) {
                Faculty faculty = new Faculty(
                        rs.getInt("FacultyID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Department"),
                        rs.getString("Email")
                );
                facultyList.add(faculty);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return facultyList;
    }

    public static void updateFaculty(Faculty faculty) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE Faculty SET FirstName=?, LastName=?, Department=?, Email=? WHERE FacultyID=?");
            ps.setString(1, faculty.getFirstName());
            ps.setString(2, faculty.getLastName());
            ps.setString(3, faculty.getDepartment());
            ps.setString(4, faculty.getEmail());
            ps.setInt(5, faculty.getId());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public static void addCourse(Course course) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO Course (Department, Number, Title, Credits, FacultyID, CourseName) VALUES (?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, course.getDepartment());
            ps.setInt(2, course.getNumber());
            ps.setString(3, course.getTitle());
            ps.setInt(4, course.getCredits());
            ps.setInt(5, course.getFacultyId());
            ps.setString(6, course.getCourseName());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public static ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Course");
            while (rs.next()) {
                Course course = new Course(
                        rs.getInt("ID"),
                        rs.getString("Department"),
                        rs.getInt("Number"),
                        rs.getString("Title"),
                        rs.getInt("Credits"),
                        rs.getInt("FacultyID"),
                        rs.getString("CourseName")
                );
                courses.add(course);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return courses;
    }

    public static void updateCourse(Course course) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE Course SET Department=?, Number=?, Title=?, Credits=?, FacultyID=?, CourseName=? WHERE ID=?"
            );
            ps.setString(1, course.getDepartment());
            ps.setInt(2, course.getNumber());
            ps.setString(3, course.getTitle());
            ps.setInt(4, course.getCredits());
            ps.setInt(5, course.getFacultyId());
            ps.setString(6, course.getCourseName());
            ps.setInt(7, course.getId());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}

