package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    //GÖREV 1
    public static boolean isPalindrome(int number) {
        // Negatif işareti yok sayıyoruz
        int originalNumber = Math.abs(number);
        int temp = originalNumber;
        int reverseNumber = 0;

        // Sayıyı tersten inşa etme döngüsü
        while (temp > 0) {
            int lastDigit = temp % 10;
            reverseNumber = (reverseNumber * 10) + lastDigit;
            temp /= 10;
        }

        return originalNumber == reverseNumber;
    }

    //GÖREV 2
    public static boolean isPerfectNumber(int number) {
        if (number < 0) {
            return false;
        }

        int sum = 0;
        // Kendisi hariç bölenlerini topluyoruz
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    //GÖREV 3
    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        // Sayıyı karakter dizisine çeviriyoruz (Örn: "123" -> ['1', '2', '3'])
        String numberStr = String.valueOf(number);
        char[] digits = numberStr.toCharArray();

        // Kelimeleri birleştirmek için StringBuilder kullanıyoruz
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

        // .trim() metodu en sondaki fazlalık boşluğu temizler
        return result.toString().trim();
    }
}



