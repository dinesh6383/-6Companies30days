import java.util.*;

public class Shopping_Offers {
    public static HashMap<List<Integer>, Integer> cache = new HashMap<>();
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs)  {
        // There is a possibilty of needs to re-occur.
        if(cache.containsKey(needs)) return cache.get(needs);

        int lowestPrice = 0;

        // calculating the non-offer price for all needs.
        for(int i = 0; i < needs.size(); i++) {
            lowestPrice += (needs.get(i) * price.get(i));
        }

        // Iterate over all the offers for current needs.
        for(int i = 0; i < special.size(); i++) {
            boolean isValidOffer = isValid(special.get(i), needs);

            // If it is a valid offer reduce the needs accordingly.
            if(isValidOffer) {
                for(int j = 0; j < needs.size(); j++) {
                    int reduce = needs.get(j) - special.get(i).get(j);
                    needs.set(j, reduce);
                }

                int tempPrice = special.get(i).get(price.size()) + shoppingOffers(price, special, needs);
                lowestPrice = Math.min(lowestPrice, tempPrice);

                // Backtracking the reduce needs back to same for next recursion.
                for(int j = 0; j < needs.size(); j++) {
                    int add = needs.get(j) + special.get(i).get(j);
                    needs.set(j, add);
                }
            }
        }

        // adding the lowest price to cache.
        cache.put(needs, lowestPrice);
        return lowestPrice;
    }

    public static boolean isValid(List<Integer> offer, List<Integer> needs) {
        for(int i = 0; i < needs.size(); i++) {
            if(offer.get(i) > needs.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>();
        price.add(9);
        price.add(9);

        List<List<Integer>> special = new ArrayList<>();
        special.add(new ArrayList<>());

        special.get(0).add(1);
        special.get(0).add(1);
        special.get(0).add(1);

        List<Integer> needs = new ArrayList<>();
        needs.add(2);
        needs.add(2);

        int result = shoppingOffers(price, special, needs);
        System.out.println(result);
    }
    
}
