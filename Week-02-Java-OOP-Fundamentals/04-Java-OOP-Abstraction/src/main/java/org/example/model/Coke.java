package org.example.model;

public class Coke extends ProductForSale {
    private double volume;

    public Coke(String type, double price, String description) {
        super(type, price, description);
        this.volume = 0.33;
    }

    public Coke(String type, double price, String description, double volume) {
        super(type, price, description);
        this.volume = volume;
    }

    public double getVolume() { return volume; }

    @Override
    public void showDetails() {
        System.out.println("Coke - Type: " + getType() + ", Price: " + getPrice() +
                ", Description: " + getDescription() + ", Volume: " + volume + "L");
    }
}