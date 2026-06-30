package org.example;

import org.example.entity.StringSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> words = StringSet.findUniqueWords();
        System.out.println("Toplam: " + words.size());
        for (String word : words) {
            System.out.println(word);
        }
    }
}