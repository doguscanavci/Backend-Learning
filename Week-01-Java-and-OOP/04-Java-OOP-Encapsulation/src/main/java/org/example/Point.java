package org.example;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public double distance() {
        return distance(0, 0);
    }

    public double distance(Point p) {
        return distance(p.getX(), p.getY());
    }

    public double distance(int a, int b) {
        return Math.sqrt((a - x) * (a - x) + (b - y) * (b - y));
    }
}