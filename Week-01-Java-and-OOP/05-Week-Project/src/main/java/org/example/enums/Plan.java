package org.example.enums;

public enum Plan {
    BASIC("Basic Plan", 100),
    PREMIUM("Premium Plan", 250),
    GOLD("Gold Plan", 500);

    private String name;
    private Integer price;  // double → Integer

    Plan(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName()    { return name; }
    public Integer getPrice()  { return price; }
}