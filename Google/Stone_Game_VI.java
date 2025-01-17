package Google;

import java.util.*;

class Pair {
    int first;
    int second;

    public Pair(int val1, int val2) {
        first = val1;
        second = val2;
    }
}

public class Stone_Game_VI {
    public static int stoneGameVI(int[] aliceValues, int[] bobValues) {
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i = 0; i < aliceValues.length; i++) {
            arr.add(new Pair(aliceValues[i], bobValues[i]));
        }

        Collections.sort(arr, (a,b) -> b.first + b.second - a.first - a.second);

        int result = 0;
        for(int i = 0; i < arr.size(); i++) {
            if(i % 2 == 0) result += arr.get(i).first;
            else result -= arr.get(i).second;
        }

        if(result > 0) return 1;
        else if(result < 0) return -1;
        else return 0;
    }
    public static void main(String[] args) {
        int[] aliceValues = {1,2};
        int[] bobValues = {3,1};
        int result = stoneGameVI(aliceValues, bobValues);
        System.out.println(result);
    }
}