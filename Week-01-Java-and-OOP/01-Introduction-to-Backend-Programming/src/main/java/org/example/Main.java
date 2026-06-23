package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // 1. Görev: Havlayan Köpeğimiz
    public static boolean shouldWakeUp(boolean isBarking, int clock) {
        if (clock < 0 || clock > 23) {
            return false;
        }
        if (!isBarking) {
            return false;
        }
        if (clock >= 20 || clock < 8) {
            return true;
        }
        return false;
    }

    // 2. Görev: Yaş Tespiti
    public static boolean hasTeen(int firstAge, int secondAge, int thirdAge) {
        if ((firstAge >= 13 && firstAge <= 19) ||
                (secondAge >= 13 && secondAge <= 19) ||
                (thirdAge >= 13 && thirdAge <= 19)) {
            return true;
        }
        return false;
    }

    // 3. Görev: Oyuncu Kedi
    public static boolean isCatPlaying(boolean isSummer, int temp) {
        int limit = isSummer ? 45 : 35;
        if (temp >= 25 && temp <= limit) {
            return true;
        }
        return false;
    }

    // 4. Görev: Alan Hesaplama - Dikdörtgen
    public static double area(double width, double height) {
        if (width < 0 || height < 0) {
            return -1;
        }
        return width * height;
    }

    // 5. Görev: Alan Hesaplama - Daire
    public static double area(double radius) {
        if (radius < 0) {
            return -1;
        }
        return radius * radius * Math.PI;
    }
}