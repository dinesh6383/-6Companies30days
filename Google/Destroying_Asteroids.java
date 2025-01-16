package Google;

import java.util.Arrays;

public class Destroying_Asteroids {
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long planet = mass;
        for(int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if(asteroid > planet) return false;
            planet = planet + asteroid;
        }
        return true;
    }
    public static void main(String[] args) {
        int mass = 10;
        int[] asteroids = {3,9,19,5,21};
        boolean result = asteroidsDestroyed(mass, asteroids);
        System.out.println(result);
    }
}
