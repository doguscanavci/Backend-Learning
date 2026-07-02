package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(convertDecimalToBinary(13));
    }

    public static boolean checkForPalindrome(String input) {
        // Sadece harfleri al, küçük harfe çevir
        String cleaned = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Stack ile palindrom kontrolü
        Deque<Character> stack = new ArrayDeque<>();

        // Tüm karakterleri stack'e ekle
        for (char c : cleaned.toCharArray()) {
            stack.push(c);
        }

        // Stack'ten çıkararak orijinalle karşılaştır
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return cleaned.equals(reversed.toString());
    }

    public static String convertDecimalToBinary(int number) {
        if (number == 0) return "0";

        // Stack kullanarak binary çevirimi
        Deque<Integer> stack = new ArrayDeque<>();

        while (number > 0) {
            stack.push(number % 2);
            number /= 2;
        }

        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }
}