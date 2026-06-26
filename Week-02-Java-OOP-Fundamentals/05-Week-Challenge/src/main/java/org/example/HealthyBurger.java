package org.example.models;

public class HealthyBurger extends Hamburger {
    private String healthyExtra1Name;
    private double healthyExtra1Price;
    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String name, double price, String breadRollType) {
        super(name, "Tofu", price, breadRollType);
    }

    public void addHealthyAddition1(String name, double price) {
        this.healthyExtra1Name = name;
        this.healthyExtra1Price = price;
    }

    public void addHealthyAddition2(String name, double price) {
        this.healthyExtra2Name = name;
        this.healthyExtra2Price = price;
    }

    @Override
    public double itemizeHamburger() {
        System.out.println("Name: " + getName());
        System.out.println("Meat: " + getMeat());
        System.out.println("BreadRollType: " + getBreadRollType());

        double total = getPrice();

        if (getAddition1Name() != null) {
            System.out.println("Addition1: " + getAddition1Name());
            total += getAddition1Price();
        }
        if (getAddition2Name() != null) {
            System.out.println("Addition2: " + getAddition2Name());
            total += getAddition2Price();
        }
        if (healthyExtra1Name != null) {
            System.out.println("HealthyAddition1: " + healthyExtra1Name);
            total += healthyExtra1Price;
        }
        if (healthyExtra2Name != null) {
            System.out.println("HealthyAddition2: " + healthyExtra2Name);
            total += healthyExtra2Price;
        }

        setPrice(total);
        System.out.println("Price: " + total);
        return total;
    }
}