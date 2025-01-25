package Atlassian;


public class Count_Collision_On_A_Road {
    public static int countCollisions(String directions) {
        int n = directions.length();
        int left = 0;
        int right = n - 1;
        
        while(left < n && directions.charAt(left) == 'L') left++;
        while(right >= 0 && directions.charAt(right) == 'R') right--;
        

        int result = 0;
        for(int i = left; i <= right; i++) {
                if(directions.charAt(i) != 'S') {
                    result++;
                }
        }
        return result;
    }
    public static void main(String[] args) {
        String direction = "SRRLRLRSRLRSSRRLSLRLLRSLSLLSSRRLSRSLSLRRS";
        int result = countCollisions(direction);
        System.out.println(result);
    }
}