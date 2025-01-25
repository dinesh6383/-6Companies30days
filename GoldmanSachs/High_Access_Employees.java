package GoldmanSachs;

import java.util.*;

public class High_Access_Employees {
    public static List<String> findHighAccessEmployees(List<List<String>> access_times) {
        List<String> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(List<String> temp : access_times) {
            String key = temp.get(0);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(temp.get(1));
        }

        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
            int maxEntries = 0;
            if(map.get(key).size() > 1) {
                int n = map.get(key).size();
                int i = 0, j = 1;
                int entries = 0;

                while(i < j && j < n) {
                    int start = Integer.parseInt(map.get(key).get(i));
                    int end = Integer.parseInt(map.get(key).get(j));
                    int diff = end - start;

                    if(diff >= 100) {
                        entries += (j - i);
                        maxEntries = Math.max(entries, maxEntries);
                        entries = 0;
                        i++;
                        j = i + 1;
                    } else j++;
                }

                entries += (j - i);
                maxEntries = Math.max(entries, maxEntries);
                if(maxEntries >= 3) result.add(key);
            }
        }

        return result;
    }   
    public static void main(String[] args) {
        List<List<String>> access_times = new ArrayList<>();

        List<String> temp2 = new ArrayList<>();
        temp2.add("c");
        temp2.add("0808");

        List<String> temp3 = new ArrayList<>();
        temp3.add("c");
        temp3.add("0829");

        List<String> temp4 = new ArrayList<>();
        temp4.add("e");
        temp4.add("0215");

        List<String> temp5 = new ArrayList<>();
        temp5.add("d");
        temp5.add("0510");

        List<String> temp6 = new ArrayList<>();
        temp6.add("d");
        temp6.add("0517");

        List<String> temp7 = new ArrayList<>();
        temp7.add("d");
        temp7.add("0530");

        List<String> temp8 = new ArrayList<>();
        temp8.add("d");
        temp8.add("0617");

        access_times.add(temp2);
        access_times.add(temp3);
        access_times.add(temp4);
        access_times.add(temp5);
        access_times.add(temp6);
        access_times.add(temp7);
        access_times.add(temp8);

        List<String> result = findHighAccessEmployees(access_times);
        System.out.println(result);
    }
}

/*
    d : ["0002", "1508", "1444", "1410"] => sort => ["0002", "1410", "1444", "1508"]
    c : ["0808", "0829", "0809"]
    e : ["0215"]
    ----------------------

    a : ["0549", "0532", "0621"] => ["0532", "0549", "0621"]
    b : ["0457", "0540"]

    ----------------------
    [["akuhmu","0454"],["aywtqh","0523"],["akuhmu","0518"],["ihhkc","0439"],["ihhkc","0508"],["akuhmu","0529"],["aywtqh","0530"],["aywtqh","0419"]]
    aywtqh : [0523, 0530, 0419] => [0419, 0523, 0530]

    -------------------------

    a : [0510,0517,0530,0617]

    -------------------------
    a : [1841, 1859, 1941]
*/