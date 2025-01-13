package Walmart;

public class Rotate_Function {
    public static int rotateFunction(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int maxResult = 0;
        int prevResult = 0;
        for(int i = 0; i < arr.length; i++) {
            prevResult += (i * arr[i]);
        }

        maxResult = prevResult;
        int lastIdx = arr.length - 1;
        int lastElem = arr[lastIdx];
        while (lastIdx > 0) {
            int tempResult = prevResult + sum;
            tempResult -= (lastElem * arr.length);
            maxResult = Math.max(maxResult, tempResult);
            prevResult = tempResult;
            lastElem = arr[--lastIdx];
        }
        return maxResult;
    }
    public static void main(String[] args) {
        int[] nums = {100};
        int result = rotateFunction(nums);
        System.out.println(result);
    }
}
