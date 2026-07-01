package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
        employees.add(null);

        System.out.println("Duplicates: " + findDuplicates(employees));
        System.out.println("Uniques: " + findUniques(employees));
        System.out.println("Remove duplicates: " + removeDuplicates(employees));
    }

    // Tekrar eden employeeları döndür (null atla)
    public static List<Employee> findDuplicates(List<Employee> list) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Employee> duplicates = new LinkedList<>();
        boolean[] added = new boolean[list.size()];

        for (int i = 0; i < list.size(); i++) {
            Employee emp = list.get(i);
            if (emp == null) continue;
            countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
        }

        Set<Integer> seenDuplicates = new HashSet<>();
        for (Employee emp : list) {
            if (emp == null) continue;
            if (countMap.get(emp.getId()) > 1 && !seenDuplicates.contains(emp.getId())) {
                duplicates.add(emp);
                seenDuplicates.add(emp.getId());
            }
        }

        return duplicates;
    }

    // Her id'den bir tane tut (Map<id, Employee>)
    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee emp : list) {
            if (emp == null) continue;
            if (!map.containsKey(emp.getId())) {
                map.put(emp.getId(), emp);
            }
        }
        return map;
    }

    // Sadece tek geçen kayıtları döndür
    public static List<Employee> removeDuplicates(List<Employee> list) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (Employee emp : list) {
            if (emp == null) continue;
            countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
        }

        List<Employee> result = new LinkedList<>();
        for (Employee emp : list) {
            if (emp == null) continue;
            if (countMap.get(emp.getId()) == 1) {
                result.add(emp);
            }
        }
        return result;
    }
}