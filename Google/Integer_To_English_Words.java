package Google;

import java.util.*;

public class Integer_To_English_Words {
    public static HashMap<Integer, String> ones = new HashMap<>();
    public static HashMap<Integer, String> tens = new HashMap<>();
    public static HashMap<Integer, String> tensSpecial = new HashMap<>();
    public static String[] levelMap = {"", "Thousand", "Million", "Billion"};
    public static String numberToWords(int num) {
        // mapping ones words
        ones.put(0, "");
        ones.put(1, "One");
        ones.put(2, "Two");
        ones.put(3, "Three");
        ones.put(4, "Four");
        ones.put(5, "Five");
        ones.put(6, "Six");
        ones.put(7, "Seven");
        ones.put(8, "Eight");
        ones.put(9, "Nine");

        // mapping tens words
        tens.put(0, "");
        tens.put(1, "");
        tens.put(2, "Twenty");
        tens.put(3, "Thirty");
        tens.put(4, "Forty");
        tens.put(5, "Fifty");
        tens.put(6, "Sixty");
        tens.put(7, "Seventy");
        tens.put(8, "Eighty");
        tens.put(9, "Ninety");

        // mapping special tens words (10, 11, 12, etc..)
        tensSpecial.put(0, "Ten");
        tensSpecial.put(1, "Eleven");
        tensSpecial.put(2, "Twelve");
        tensSpecial.put(3, "Thirteen");
        tensSpecial.put(4, "Fourteen");
        tensSpecial.put(5, "Fifteen");
        tensSpecial.put(6, "Sixteen");
        tensSpecial.put(7, "Seventeen");
        tensSpecial.put(8, "Eighteen");
        tensSpecial.put(9, "Nineteen");

        if(num == 0) return "Zero";

        int temp = num;
        int[] number = new int[3];
        int count = 0;
        String result = "";
        int level = 0;

        while(temp > 0) {
            number[count] = temp % 10;
            temp /= 10;
            count++;
            if(count == 3) {
                result = getWordings(number, level) + " " + result;
                Arrays.fill(number, 0);
                level++;
                count = 0;
            }
        }

        if(number[0] + number[1] + number[2] > 0) result = getWordings(number, level) + " " + result;
        return result.trim().replaceAll("\\s+", " ");
    }

    public static String getWordings(int[] number, int level) {
        String result = "";
        if(number[2] > 0) result = ones.get(number[2]) + " Hundred";
        if(number[1] != 1) {
            result = result + " " + tens.get(number[1]) + " " + ones.get(number[0]);
        } else {
            result = result + " " + tensSpecial.get(number[0]);
        }

        result = result.trim().replaceAll("\\s+", " ");
        if(result.length() > 0) result = result + " " + levelMap[level];
        return result;
    }

    public static void main(String[] args) {
        int num = 1000000;
        String result = numberToWords(num);
        System.out.println(result);
    }
}

/*
    appending : billion, million, thousand:-
    Example: 1
    12345 => (12) (345)
    12 => (2 1 0) => Twelve + " " + thousand
    345  => (5 4 3) => Three hundred forty five
    Result : Twelve thousand three hundred forty five.
    ----------------------------------------------------------
    Example: 2
    1234567 => (1) (234) (567)
    1   => (1 0 0) => One + " " + million
    234 => (4 3 2) => Two hundred thirty four + " " + thousand
    567 => (7 6 5) => Five hundred sixty seven
    Result : One million two hundred thirty four thousand five hundred sixty seven.
*/