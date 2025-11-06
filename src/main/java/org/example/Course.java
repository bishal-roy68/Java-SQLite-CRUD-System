package org.example;

public class Course {
    private int id;
    private String department;
    private int number;
    private String title;
    private int credits;
    private int facultyId;
    private String courseName;

    public Course(int id, String department, int number, String title, int credits, int facultyId, String courseName) {
        this.id = id;
        this.department = department;
        this.number = number;
        this.title = title;
        this.credits = credits;
        this.facultyId = facultyId;
        this.courseName = courseName;
    }

    public int getId() { return id; }
    public String getDepartment() { return department; }
    public int getNumber() { return number; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public int getFacultyId() { return facultyId; }
    public String getCourseName() { return courseName; }

    public void setId(int id) { this.id = id; }
    public void setDepartment(String department) { this.department = department; }
    public void setNumber(int number) { this.number = number; }
    public void setTitle(String title) { this.title = title; }
    public void setCredits(int credits) { this.credits = credits; }
    public void setFacultyId(int facultyId) { this.facultyId = facultyId; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    @Override
    public String toString() {
        return id + ": " + department + " " + number + " - " + title +
                " (" + credits + " credits, Faculty ID: " + facultyId + ", Course: " + courseName + ")";
    }
}
