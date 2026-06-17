package org.example;

public class Wall {
    private double width; // 'private' kullanmak OOP prensiplerine daha uygundur
    private double height;

    public Wall(double width, double height) {
        // Constructor içinde setter'ları çağırarak negatif kontrolü yapıyoruz
        setWidth(width);
        setHeight(height);
    }

    public double getWidth() { return width; }
    public double getHeight() { return height; }

    public void setWidth(Double width) {
        this.width = (width < 0) ? 0.0 : width;
    }

    public void setHeight(double height) {
        this.height = (height < 0) ? 0.0 : height;
    }

    public double getArea() {
        return this.width * this.height;
    }
}