package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n0 - Çıkış");
            System.out.println("1 - Eleman Ekle");
            System.out.println("2 - Eleman Çıkar");
            System.out.print("Seçiminiz: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Eklenmesini istediğiniz elemanları giriniz: ");
                String input = scanner.nextLine();
                addItems(input);
                printSorted();
            } else if (choice == 2) {
                System.out.print("Çıkarılmasını istediğiniz elemanları giriniz: ");
                String input = scanner.nextLine();
                removeItems(input);
                printSorted();
            }
        }
        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            if (!checkItemIsInList(trimmed)) {
                groceryList.add(trimmed);
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            groceryList.remove(trimmed);
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }
}