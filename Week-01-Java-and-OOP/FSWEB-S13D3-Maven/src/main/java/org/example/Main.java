package org.example;

public class Main {
    public static void main(String[] args) {
        // Person testi
        Person person = new Person("John", "Doe", 20);
        System.out.println("Firstname: " + person.getFirstName());
        System.out.println("LastName: " + person.getLastName());
        System.out.println("Age: " + person.getAge());
        System.out.println("isTeen: " + person.isTeen()); // false (20 yaş)

        // Wall testi
        Wall wall = new Wall(5, 4);
        System.out.println("area= " + wall.getArea());    // 20.0
        wall.setHeight(-1.5);
        System.out.println("width= " + wall.getWidth());  // 5.0
        System.out.println("height= " + wall.getHeight()); // 0.0
        System.out.println("area= " + wall.getArea());    // 0.0
    }
}