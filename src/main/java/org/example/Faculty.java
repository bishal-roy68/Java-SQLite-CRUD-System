package org.example;

public class Faculty {
    private int id;
    private String firstName;
    private String lastName;
    private String department;
    private String email;

    public Faculty(int id, String firstName, String lastName, String department, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.email = email;
    }

    public Faculty() {}

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return id + ": " + firstName + " " + lastName + " | " + department + " | " + email;
    }
}
