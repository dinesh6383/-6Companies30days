package Atlassian;

import java.util.*;

class ThroneInheritance {
    String king;
    ArrayList<String> childrens;
    HashMap<String, ArrayList<String>> genMap;
    HashSet<String> graveYard;
    public ThroneInheritance(String kingName) {
        king = kingName;
        childrens = new ArrayList<>();
        genMap = new HashMap<>();
        graveYard = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        if(parentName.equals(king)) {
            genMap.put(childName, new ArrayList<>());
            childrens.add(childName);
        } else {
            if(!genMap.containsKey(parentName)) genMap.put(parentName, new ArrayList<>());
            genMap.get(parentName).add(childName);
        }
    }

    public void death(String name) {
        graveYard.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> genOrder = new ArrayList<>();
        if(!graveYard.contains(king)) genOrder.add(king);
        
        for(String child : childrens) {
            getGenerationOrder(child, genMap, genOrder);
        }

        return genOrder;
    }

    public void getGenerationOrder(String curr, HashMap<String, ArrayList<String>> map, List<String> order) {
        if(!graveYard.contains(curr)) order.add(curr);
        if(map.containsKey(curr)) {
            for(String child : map.get(curr)) {
                getGenerationOrder(child, map, order);
            }
        }
    }
}

public class Throne_Inheritance {
    public static void main(String[] args) {
        ThroneInheritance t = new ThroneInheritance("king");
        t.birth("king", "andy");
        t.birth("king", "bob");
        t.birth("king", "catherine");
        t.birth("andy", "mathew");
        t.birth("bob", "alex");
        t.birth("bob", "asha");
        System.out.println(t.getInheritanceOrder());
        t.death("bob");
        System.out.println(t.getInheritanceOrder());
    }
}