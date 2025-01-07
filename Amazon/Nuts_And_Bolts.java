package Amazon;

import java.util.ArrayList;
import java.util.Arrays;

public class Nuts_And_Bolts {
    // Time complexity : O(nlogn) | Space complexity : O(logn)
    public static void merge(char[] arr, int s, int m, int e) {
        ArrayList<Character> temp = new ArrayList<>();

        int p1 = s, p2 = m + 1;
        while(p1 <= m && p2 <= e) {
            int n1 = arr[p1] - 0;
            int n2 = arr[p2] - 0;

            if(n1 < n2) {
                temp.add(arr[p1]);
                p1++;
            } else {
                temp.add(arr[p2]);
                p2++;
            }
        }  

        while(p1 <= m) {
            temp.add(arr[p1]);
            p1++;
        }

        while(p2 <= e) {
            temp.add(arr[p2]);
            p2++;
        }

        int tempIdx = 0;
        for(int i = s; i <= e; i++) {
            arr[i] = temp.get(tempIdx);
            tempIdx++;
        }
    }

    public static void mergeSort(char[] arr, int s, int e) {
        if(s >= e) return;

        int m = (s + e) / 2;
        mergeSort(arr, s, m);
        mergeSort(arr, m + 1, e);
        merge(arr, s, m, e);
    }
    public static void main(String[] args) {
        int n = 5;
        char[] nuts = {'@', '%', '$', '#', '^'};
        char[] bolts = {'%', '@', '#', '$', '^'};

        mergeSort(nuts, 0, n - 1);
        mergeSort(bolts, 0, n - 1);

        System.out.println(Arrays.toString(nuts)); // [#, $, %, @, ^]
        System.out.println(Arrays.toString(bolts)); // [#, $, %, @, ^]
    }
}