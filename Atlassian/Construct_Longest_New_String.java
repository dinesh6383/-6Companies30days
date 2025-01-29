package Atlassian;

public class Construct_Longest_New_String {
    public static int longestString(int x, int y, int z) {
        int ans = Math.min(x,y);
         ans+=ans+1+z;
         if(x==y){
             ans-=1;
         }
         return ans*2; 
     }

     public static void main(String[] args) {
        int x = 2, y = 5, z = 1;
        int result = longestString(x, y, z);
        System.out.println(result);
     }
}
