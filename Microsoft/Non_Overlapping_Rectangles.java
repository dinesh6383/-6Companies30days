import java.util.*;

class Solution {
    int[][] rects;
    int total = 0;
    Random rand = new Random();
    ArrayList<Integer> pointsSum = new ArrayList<>();

    public Solution(int[][] rects) {
        this.rects = rects;
        for(int[] rec : rects) {
            int x1 = rec[0], y1 = rec[1];
            int x2 = rec[2], y2 = rec[3];

            total += ((x2 - x1 + 1) * (y2 - y1 + 1));
            pointsSum.add(total);
        }
    }

    public int[] pick() {
        int targetPoint = rand.nextInt(total);
        int targetPositionInRectangles = binarySearch(targetPoint);

        int[] targetRectangle = rects[targetPositionInRectangles];
        int x1 = targetRectangle[0], y1 = targetRectangle[1];
        int x2 = targetRectangle[2], y2 = targetRectangle[3];

        int randomX = rand.nextInt(x2 - x1 + 1);
        int randomY = rand.nextInt(y2 - y1 + 1);

        return new int[] {randomX + x1, randomY + y1};
    }

    public int binarySearch(int target) {
        int low = 0, high = rects.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(pointsSum.get(mid) <= target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}

public class Non_Overlapping_Rectangles {
    public static void main(String[] args) {
        int[][] rectangles = {{-2, -2, 1, 1}, {2, 2, 4, 6}};
        Solution obj = new Solution(rectangles);
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
        System.out.println(Arrays.toString(obj.pick()));
    }
}
