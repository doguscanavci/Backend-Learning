package org.example;

public class Employee {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private String[] healthPlans;  // healthplans → healthPlans

    public Employee(int id, String fullName, String email, String password, String[] healthPlans) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.healthPlans = healthPlans;
    }

    public int getId()               { return id; }
    public String getFullName()      { return fullName; }
    public String getEmail()         { return email; }
    public String getPassword()      { return password; }
    public String[] getHealthPlans() { return healthPlans; }  // getter eklendi

    public void setId(int id)                       { this.id = id; }
    public void setFullName(String fullName)         { this.fullName = fullName; }
    public void setEmail(String email)               { this.email = email; }
    public void setPassword(String password)         { this.password = password; }
    public void setHealthPlans(String[] healthPlans) { this.healthPlans = healthPlans; }

    public void addHealthPlan(int index, String name) {
        if (index < 0 || index >= healthPlans.length) {
            System.out.println("Index " + index + " does not exist.");
            return;
        }
        if (healthPlans[index] != null) {
            System.out.println("Index " + index + " is already taken: " + healthPlans[index]);
            return;
        }
        healthPlans[index] = name;
        System.out.println(name + " added to index " + index);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", fullName=" + fullName + ", email=" + email + "}";
    }
}