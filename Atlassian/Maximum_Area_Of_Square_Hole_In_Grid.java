package Atlassian;

import java.util.*;

public class Maximum_Area_Of_Square_Hole_In_Grid {
    public static int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int width = getMaxSize(hBars);
        int height = getMaxSize(vBars);
        
        return (int) Math.pow(Math.min(width, height), 2);
    }
    
    public static int getMaxSize(int[] arr) {
        int result = 2, count = 2;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i - 1] + 1 == arr[i]) count += 1;
            else count = 2;

            result = Math.max(count, result);
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 3;
        int m = 2;
        int[] hBars = {3,2,4};
        int[] vBars = {3,2};
        int result = maximizeSquareHoleArea(n, m, hBars, vBars);
        System.out.println(result);
    }
}

