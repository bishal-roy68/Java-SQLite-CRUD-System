package org.example;

public class Student {
    private int ID;
    private String firstName;
    private String lastName;
    private String major;
    private double gpa;

    public Student(int ID, String firstName, String lastName, String major, double gpa) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.gpa = gpa;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", major='" + major + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
