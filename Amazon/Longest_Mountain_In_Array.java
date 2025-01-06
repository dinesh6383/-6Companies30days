package Amazon;
public class Longest_Mountain_In_Array {
    // Time complexity : O(n) | Space complexity : O(n)
    public static int longestMountain(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // calculating left incresing range
        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i - 1]) left[i] = left[i - 1] + 1;
        }

        // calculating right incresing range
        for(int i = n - 2; i >=0; i--) {
            if(arr[i] > arr[i + 1]) right[i] = right[i + 1] + 1;
        }

        int largestMountain = 0;
        for(int i = 1; i < n - 1; i++) {
            if(left[i] != 0 && right[i] != 0) {
                largestMountain = Math.max(largestMountain, left[i] + right[i] + 1);
            }
        }
        return largestMountain;
    }

    // Time complexity : O(n) | Space complexity : O(1)
    public static int largestMountainSpaceOptimised(int[] arr) {
        int largestMountain = 0;
        int n = arr.length;
        int up = 0;
        int down = 0;

        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i - 1]) {
                if(down > 0) up = 0;
                up++;
                down = 0;
            } else if(arr[i] < arr[i - 1]) {
                if(up > 0) {
                    down++;
                    largestMountain = Math.max(largestMountain, up + down + 1);
                }
            } else {
                up = 0;
                down = 0;
            }
        }

        return largestMountain;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,4,7,3,2,5};
        int result1 = longestMountain(arr);
        int result2 = largestMountainSpaceOptimised(arr);
        System.out.println(result1);
        System.out.println(result2);
    }
}
