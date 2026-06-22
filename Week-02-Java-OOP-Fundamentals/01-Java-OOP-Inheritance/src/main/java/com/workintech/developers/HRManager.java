package com.workintech.developers;

public class HRManager extends Employee {
    private JuniorDeveloper[] juniorDevelopers;
    private MidDeveloper[] midDevelopers;
    private SeniorDeveloper[] seniorDevelopers;

    public HRManager(int id, String name, double salary) {
        super(id, name, salary);
        this.juniorDevelopers = new JuniorDeveloper[10];
        this.midDevelopers = new MidDeveloper[10];
        this.seniorDevelopers = new SeniorDeveloper[10];
    }

    @Override
    public void work() {
        setSalary(getSalary() + 4000);
        System.out.println("HR Manager starts to working. New salary: " + getSalary());
    }

    public void addEmployee(int index, JuniorDeveloper developer) {
        if (index < 0 || index >= juniorDevelopers.length) {
            System.out.println("Index " + index + " does not exist.");
            return;
        }
        if (juniorDevelopers[index] != null) {
            System.out.println("Index " + index + " is already taken.");
            return;
        }
        juniorDevelopers[index] = developer;
        System.out.println("Junior Developer added: " + developer.getName());
    }

    public void addEmployee(int index, MidDeveloper developer) {
        if (index < 0 || index >= midDevelopers.length) {
            System.out.println("Index " + index + " does not exist.");
            return;
        }
        if (midDevelopers[index] != null) {
            System.out.println("Index " + index + " is already taken.");
            return;
        }
        midDevelopers[index] = developer;
        System.out.println("Mid Developer added: " + developer.getName());
    }

    public void addEmployee(int index, SeniorDeveloper developer) {
        if (index < 0 || index >= seniorDevelopers.length) {
            System.out.println("Index " + index + " does not exist.");
            return;
        }
        if (seniorDevelopers[index] != null) {
            System.out.println("Index " + index + " is already taken.");
            return;
        }
        seniorDevelopers[index] = developer;
        System.out.println("Senior Developer added: " + developer.getName());
    }
}