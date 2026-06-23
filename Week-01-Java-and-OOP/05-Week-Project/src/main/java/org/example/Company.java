package org.example;

public class Company {
    private int id;
    private String name;
    private Double giro;  // double → Double
    private String[] developerNames;

    public Company(int id, String name, double giro, String[] developerNames) {
        this.id = id;
        this.name = name;
        this.giro = giro < 0 ? 0 : giro;
        this.developerNames = developerNames;
    }

    public int getId()                  { return id; }
    public String getName()             { return name; }
    public Double getGiro()             { return giro; }
    public String[] getDeveloperNames() { return developerNames; }

    public void setId(int id)           { this.id = id; }
    public void setName(String name)    { this.name = name; }
    public void setGiro(double giro)    { this.giro = giro < 0 ? 0 : giro; }
    public void setDeveloperNames(String[] developerNames) { this.developerNames = developerNames; }

    public void addEmployee(int index, String name) {
        if (index < 0 || index >= developerNames.length) {
            System.out.println("Index " + index + " does not exist.");
            return;
        }
        if (developerNames[index] != null) {
            System.out.println("Index " + index + " is already taken: " + developerNames[index]);
            return;
        }
        developerNames[index] = name;
        System.out.println(name + " added to index " + index);
    }

    @Override
    public String toString() {
        return "Company{id=" + id + ", name=" + name + ", giro=" + giro + "}";
    }
}