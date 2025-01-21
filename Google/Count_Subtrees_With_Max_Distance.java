package Google;

import java.util.*;

public class Count_Subtrees_With_Max_Distance {
    public static int[] countSubgraphsEachDiameter(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for(int[] temp : edges) {
            int u = temp[0];
            int v = temp[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] result = new int[n - 1];
        int subsets = 1 << n;
        for(int i = 1; i < subsets; i++) {
            HashSet<Integer> sets = new HashSet<>();
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0) sets.add(j + 1);
            }

            if(isConnected(sets, graph)) {
                int maxDistance = getMaxDistance(sets, graph);
                if(maxDistance > 0 && maxDistance < n) result[maxDistance - 1]++;
            }
        }
        return result;
    }

    public static boolean isConnected(HashSet<Integer> set, ArrayList<ArrayList<Integer>> graph) {
        HashSet<Integer> currSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int start = set.iterator().next();
        queue.add(start);

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            currSet.add(curr);

            for(int i = 0; i < graph.get(curr).size(); i++) {
                int nbr = graph.get(curr).get(i);
                if(!currSet.contains(nbr) && set.contains(nbr)) {
                    queue.add(nbr);
                }
            }
        }

        return set.equals(currSet);
    }

    public static int getMaxDistance(HashSet<Integer> set, ArrayList<ArrayList<Integer>> graph) {
        int maxDistance = 0;
        for(int temp : set) {
            maxDistance = Math.max(maxDistance, bfs(temp, set, graph));
        }
        return maxDistance;
    }

    public static int bfs(int from, HashSet<Integer> set, ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        queue.add(from);
        map.put(from, 0);

        int maxDistance = 0;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            int cDistance = map.get(curr);
            maxDistance = Math.max(maxDistance, cDistance);

            for(int i = 0; i < graph.get(curr).size(); i++) {
                int nbr = graph.get(curr).get(i);
                if(set.contains(nbr) && !map.containsKey(nbr)) {
                    map.put(nbr, cDistance + 1);
                    queue.add(nbr);
                }
            }
        }
        return maxDistance;
    }
    public static void main(String[] args) {
        int n = 2;
        int[][] edges = {{1,2}};
        int[] result = countSubgraphsEachDiameter(n, edges);
        System.out.println(Arrays.toString(result));
    }
}
