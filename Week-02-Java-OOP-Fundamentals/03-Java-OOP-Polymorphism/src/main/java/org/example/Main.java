package org.example;

import org.example.arge.*;
import org.example.company.*;

public class Main {
    public static void main(String[] args) {
        // Pacific Car Company testi
        Car car = new Car(8, "Base car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Car mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        Car ford = new Ford(6, "Ford Falcon");
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        Car holden = new Holden(6, "Holden Commodore");
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());

        // Car R&D Company testi
        CarSkeleton gasCar = new GasPoweredCar("Toyota", "Gas Car", 15.5, 4);
        gasCar.startEngine();
        gasCar.drive();

        CarSkeleton electricCar = new ElectricCar("Tesla", "Electric Car", 400.0, 100);
        electricCar.startEngine();
        electricCar.drive();

        CarSkeleton hybridCar = new HybridCar("Prius", "Hybrid Car", 20.0, 50, 4);
        hybridCar.startEngine();
        hybridCar.drive();
    }
}