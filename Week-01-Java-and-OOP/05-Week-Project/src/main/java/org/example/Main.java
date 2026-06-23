package org.example;

import org.example.enums.Plan;

public class Main {
    public static void main(String[] args) {
        run(); // Görev 3: main'den başka metod çağırımı
    }

    public static void run() {
        // Healthplan objesi
        Healthplan healthplan = new Healthplan(1, "Basic Health", Plan.BASIC);
        System.out.println(healthplan);

        // Employee objesi
        Employee employee = new Employee(1, "John Doe", "john@example.com", "1234", new String[3]);
        employee.addHealthPlan(0, "Basic Health"); // boş → eklendi
        employee.addHealthPlan(0, "Premium");      // dolu → mesaj
        employee.addHealthPlan(5, "Gold");         // yok → mesaj
        System.out.println(employee);

        // Company objesi
        Company company = new Company(1, "Workintech", 50000.0, new String[3]);
        company.addEmployee(0, "Ali Veli");  // boş → eklendi
        company.addEmployee(0, "Ayşe Kaya"); // dolu → mesaj
        company.setGiro(-1000);              // negatif → 0 yapılır
        System.out.println("Giro: " + company.getGiro()); // 0.0
        System.out.println(company);
    }
}