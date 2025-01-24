package Atlassian;
import java.util.Stack;

class Pair {
    char dir;
    boolean isHit;

    public Pair(char c, boolean temp) {
        dir = c;
        isHit = temp;
    }
}

public class Count_Collision_On_A_Road {
    public static int countCollisions(String directions) {
        int result = 0;
        int right = directions.charAt(0) == 'R' ? 1 :0;
        Stack<Pair> st = new Stack<>();
        st.add(new Pair(directions.charAt(0), false));

        for(int i = 1; i < directions.length(); i++) {
            char c = directions.charAt(i);
            char top = st.peek().dir;
            boolean hit = st.peek().isHit;

            if(top == 'R' && c == 'L') {
                st.add(new Pair(c, true));
                result += 1;
                result += right;
                right = 0;
            } else if(top == 'R' && c == 'S') {
                st.add(new Pair(c, false));
                result += right;
                right = 0;
            } else if(top == 'S' && c == 'L') {
                st.add(new Pair(c, true));
                result += 1;
                right = 0;
            } else if(top == 'L' && c == 'L') {
                if(hit) {
                    result += 1;
                    st.add(new Pair(c, true));
                } else {
                    st.add(new Pair(c, false));
                }
                right = 0;
            } else {
                if(c == 'R') right++;
                else right = 0;
                st.add(new Pair(c, false));
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