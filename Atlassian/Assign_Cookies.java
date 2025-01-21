package Atlassian;

import java.util.Arrays;

public class Assign_Cookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int content = 0;
        int i = 0, j = 0;
        while(i < g.length && j < s.length) {
            int child = g[i];
            int cookie = s[j];

            if(cookie >= child) {
                content++;
                i++;
                j++;
            }
 
            if(cookie < child) {
                j++;
            }
        }
        return content;
    }
    public static void main(String[] args) {
        int[] g = {1,1};
        int[] s = {1,2,3};
        int result = findContentChildren(g, s);
        System.out.println(result);
    }
}
