import java.util.HashMap;
import java.util.Set;

public class a_hashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 150);// put - O(1)
        hm.put("Chnia", 149);
        hm.put("USA", 50);

        /*
         * System.out.println(hm);
         * // get O(1);
         * int population = hm.get("India");
         * System.out.println(population);
         * 
         * System.out.println(hm.get("Indo"));
         * 
         * // ContainsKey - O(1)
         * 
         * System.out.println(hm.containsKey("India"));
         * 
         * // remove - O(1)
         * 
         * System.out.println(hm.remove("India"));
         * 
         * System.out.println(hm);
         * 
         * // size-O(1)
         * System.out.println(hm.size());
         * 
         * // is empty
         * 
         * System.out.println(hm.isEmpty());// checking is empty
         * 
         * // clear
         * hm.clear();// earase all data in hashMap
         * 
         * System.out.println(hm);
         */
        // iteration on hashmap
        Set<String> keys = hm.keySet();
        for (String k : keys) {
            System.out.println("Key=" + k + "," + "Value=" + hm.get(k));
        }

    }
}
