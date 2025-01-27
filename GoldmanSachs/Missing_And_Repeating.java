package GoldmanSachs;

import java.util.Arrays;

public class Missing_And_Repeating {
    public static int[] findTwoElement(int[] arr) {
        int n = arr.length;
        int repeatingElement = -1;

        for(int i = 0; i < n; i++) {
            int curr = Math.abs(arr[i]);
            int index = curr - 1;

            if(index >= n) continue;
            if(arr[index] < 0) repeatingElement = Math.abs(arr[i]);
            if(arr[index] > 0) arr[index] *= -1;
        }

        int missingElement = n;
        for(int i = 0; i < n; i++) {
            if(arr[i] > 0) {
                missingElement = i + 1;
                break;
            }
        }

        return new int[] {repeatingElement, missingElement};
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,4,8,6,4,5};
        int[] result = findTwoElement(arr);
        System.out.println(Arrays.toString(result));
    }
}
