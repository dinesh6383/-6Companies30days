package Atlassian;


public class Minimum_Non_Zero_Product_Array_Elements {
    public static int minNonZeroProduct(int p) {
        long N = (long) Math.pow(10, 9) + 7;
        long max = (long) Math.pow(2, p) - 1;
        long result = helper(max - 1, (max - 1)/2);
        result = ((result % N) * (max % N)) % N;
        return (int) result;
    }

    public static long helper(long num, long p) {
        if(p == 0) return 1l;

        long N = (long) Math.pow(10, 9) + 7;
        long temp = helper(num, p/2);
        temp = temp % N;
        if(p % 2 == 0) return (temp * temp) % N;
        else return (((temp * temp) % N) * (num % N)) % N;
    }

    public static void main(String[] args) {
        int p = 3;
        int result = minNonZeroProduct(p);
        System.out.println(result);
    }
}