package Atlassian;

import java.util.Arrays;

public class Find_City_With_Smallest_Threshold_Distance {
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INT = (int) 1e9 + 7;
        int[][] cost = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            Arrays.fill(cost[i], INT);
            cost[i][i] = 0;
        }

        for(int i = 0 ; i < edges.length ; i++) {
            int vertex = edges[i][0];
            int edge = edges[i][1];
            int weight = edges[i][2];

            cost[vertex][edge] = weight;
            cost[edge][vertex] = weight;
        }

        for(int via = 0 ; via < n ; via++) {
            for(int from = 0 ; from < n ; from++) {
                for(int to = 0 ; to < n ; to++) {
                    cost[from][to] = Math.min(cost[from][to], cost[from][via] + cost[via][to]);
                }
            }
        }

        int resultCity = -1;
        int maxCount = n;

        for(int i = 0 ; i < n ; i++) {
            int currCount = 0;
            for(int j = 0 ; j < n ; j++) {
                int dist = cost[i][j];
                if(dist <= distanceThreshold) currCount++;
            }

            if(currCount <= maxCount) {
                resultCity = i;
                maxCount = currCount;
            }
        }

        return resultCity;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0,1,3}, {1,2,1}, {1,3,4}, {2,3,1}};
        int distanceThreshold = 4;
        int result = findTheCity(n, edges, distanceThreshold);
        System.out.println(result);
    }
}
