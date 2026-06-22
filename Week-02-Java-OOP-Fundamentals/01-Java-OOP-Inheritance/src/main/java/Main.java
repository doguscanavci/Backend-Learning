package com.workintech;

import com.workintech.cylinder.Circle;
import com.workintech.cylinder.Cylinder;
import com.workintech.pool.Cuboid;
import com.workintech.pool.Rectangle;
import com.workintech.developers.*;

public class Main {
    public static void main(String[] args) {
        // Silindir testi
        Circle circle = new Circle(3.75);
        System.out.println("circle.radius= " + circle.getRadius());
        System.out.println("circle.area= " + circle.getArea());

        Cylinder cylinder = new Cylinder(5.55, 7.25);
        System.out.println("cylinder.radius= " + cylinder.getRadius());
        System.out.println("cylinder.height= " + cylinder.getHeight());
        System.out.println("cylinder.area= " + cylinder.getArea());
        System.out.println("cylinder.volume= " + cylinder.getVolume());

        // Havuz testi
        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println("rectangle.width= " + rectangle.getWidth());
        System.out.println("rectangle.length= " + rectangle.getLength());
        System.out.println("rectangle.area= " + rectangle.getArea());

        Cuboid cuboid = new Cuboid(5, 10, 5);
        System.out.println("cuboid.width= " + cuboid.getWidth());
        System.out.println("cuboid.length= " + cuboid.getLength());
        System.out.println("cuboid.area= " + cuboid.getArea());
        System.out.println("cuboid.height= " + cuboid.getHeight());
        System.out.println("cuboid.volume= " + cuboid.getVolume());

        // Developer testi
        HRManager hr = new HRManager(1, "Ali", 10000);
        JuniorDeveloper junior = new JuniorDeveloper(2, "Ayşe", 5000);
        MidDeveloper mid = new MidDeveloper(3, "Mehmet", 7000);
        SeniorDeveloper senior = new SeniorDeveloper(4, "Fatma", 9000);

        hr.work();
        junior.work();
        mid.work();
        senior.work();

        hr.addEmployee(0, junior);
        hr.addEmployee(0, junior); // dolu → uyarı
        hr.addEmployee(0, mid);
        hr.addEmployee(0, senior);
    }
}