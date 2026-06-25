package org.example.model;

public class Store {
    public static void listProducts(ProductForSale[] products) {
        for (ProductForSale product : products) {
            product.showDetails();
        }
    }

    public static void main(String[] args) {
        ProductForSale[] products = new ProductForSale[3];
        products[0] = new Chocolate("Snack", 15.5, "Dark Chocolate");
        products[1] = new Coke("Drink", 10.0, "Classic Coke");
        products[2] = new Bread("Bakery", 5.0, "Whole Wheat Bread");

        listProducts(products);
    }
}