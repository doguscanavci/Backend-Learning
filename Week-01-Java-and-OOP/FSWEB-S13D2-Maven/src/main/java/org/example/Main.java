package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // 1. Görev: Palindrom Sayıyı Bulma
    public static boolean isPalindrome(int number) {
        int originalNumber = Math.abs(number);
        int temp = originalNumber;
        int reverseNumber = 0;

        while (temp > 0) {
            int lastDigit = temp % 10;
            reverseNumber = (reverseNumber * 10) + lastDigit;
            temp /= 10;
        }

        return originalNumber == reverseNumber;
    }

    // 2. Görev: Mükemmel Sayıları Bulma
    public static boolean isPerfectNumber(int number) {
        if (number < 0) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    // 3. Görev: Sayıları Kelimelere Dök
    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        String numberStr = String.valueOf(number);
        char[] digits = numberStr.toCharArray();

        StringBuilder result = new StringBuilder();

        for (char digit : digits) {
            switch (digit) {
                case '0': result.append("Zero "); break;
                case '1': result.append("One "); break;
                case '2': result.append("Two "); break;
                case '3': result.append("Three "); break;
                case '4': result.append("Four "); break;
                case '5': result.append("Five "); break;
                case '6': result.append("Six "); break;
                case '7': result.append("Seven "); break;
                case '8': result.append("Eight "); break;
                case '9': result.append("Nine "); break;
            }
        }

        return result.toString().trim();
    }
}



