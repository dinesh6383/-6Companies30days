public class Cirle_Rectange_Overlapping {
    public static void main(String[] args) {
        int radius = 1, xCenter = 1, yCenter = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1;
        boolean result = checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2);
        System.out.println(result);
    }

    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int near_x = Math.max(x1, Math.min(x2, xCenter));
        int near_y = Math.max(y1, Math.min(y2, yCenter));

        int distance = (int) Math.sqrt(Math.pow((xCenter - near_x), 2) + Math.pow((yCenter - near_y), 2));
        if(distance > radius) return false;
        return true;
    }
}
