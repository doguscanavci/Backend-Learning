package org.example.model;

public class Bread extends ProductForSale {
    private String grainType;

    public Bread(String type, double price, String description) {
        super(type, price, description);
        this.grainType = "Wheat";
    }

    public Bread(String type, double price, String description, String grainType) {
        super(type, price, description);
        this.grainType = grainType;
    }

    public String getGrainType() { return grainType; }

    @Override
    public void showDetails() {
        System.out.println("Bread - Type: " + getType() + ", Price: " + getPrice() +
                ", Description: " + getDescription() + ", Grain: " + grainType);
    }
}