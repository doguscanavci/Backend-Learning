package org.example.model;

public class Chocolate extends ProductForSale {
    private String brand;

    public Chocolate(String type, double price, String description) {
        super(type, price, description);
        this.brand = "Generic";
    }

    public Chocolate(String type, double price, String description, String brand) {
        super(type, price, description);
        this.brand = brand;
    }

    public String getBrand() { return brand; }

    @Override
    public void showDetails() {
        System.out.println("Chocolate - Type: " + getType() + ", Price: " + getPrice() +
                ", Description: " + getDescription() + ", Brand: " + brand);
    }
}