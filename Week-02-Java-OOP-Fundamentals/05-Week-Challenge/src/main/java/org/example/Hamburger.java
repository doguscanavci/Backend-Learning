package org.example.models;

public class Hamburger {
    private String name;
    private String meat;
    private double price;
    private String breadRollType;

    private String addition1Name;
    private double addition1Price;
    private String addition2Name;
    private double addition2Price;
    private String addition3Name;
    private double addition3Price;
    private String addition4Name;
    private double addition4Price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
    }

    public String getName()          { return name; }
    public String getMeat()          { return meat; }
    public Double getPrice()         { return price; }
    public String getBreadRollType() { return breadRollType; }

    public void addHamburgerAddition1(String name, double price) {
        this.addition1Name = name;
        this.addition1Price = price;
    }

    public void addHamburgerAddition2(String name, double price) {
        this.addition2Name = name;
        this.addition2Price = price;
    }

    public void addHamburgerAddition3(String name, double price) {
        this.addition3Name = name;
        this.addition3Price = price;
    }

    public void addHamburgerAddition4(String name, double price) {
        this.addition4Name = name;
        this.addition4Price = price;
    }

    public double itemizeHamburger() {
        System.out.println("Name: " + name);
        System.out.println("Meat: " + meat);
        System.out.println("BreadRollType: " + breadRollType);

        double total = price;

        if (addition1Name != null) {
            System.out.println("Addition1: " + addition1Name);
            total += addition1Price;
        }
        if (addition2Name != null) {
            System.out.println("Addition2: " + addition2Name);
            total += addition2Price;
        }
        if (addition3Name != null) {
            System.out.println("Addition3: " + addition3Name);
            total += addition3Price;
        }
        if (addition4Name != null) {
            System.out.println("Addition4: " + addition4Name);
            total += addition4Price;
        }

        this.price = total; // price güncelleniyor!
        System.out.println("Price: " + total);
        return total;
    }

    // alt sınıfların erişebilmesi için protected getter
    protected String getAddition1Name()    { return addition1Name; }
    protected double getAddition1Price()   { return addition1Price; }
    protected String getAddition2Name()    { return addition2Name; }
    protected double getAddition2Price()   { return addition2Price; }
    protected String getAddition3Name()    { return addition3Name; }
    protected double getAddition3Price()   { return addition3Price; }
    protected String getAddition4Name()    { return addition4Name; }
    protected double getAddition4Price()   { return addition4Price; }
    protected void setPrice(double price)  { this.price = price; }
}