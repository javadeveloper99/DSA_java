import java.util.*;

public class h_find_itinerary {
    public static String getStart(HashMap<String, String> map) {
        HashMap<String, String> revMap = new HashMap<>();

        for (String key : map.keySet()) {
            revMap.put(map.get(key), key);
        }
        for (String key : map.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }

        return null;

    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("Mumbai", "Banglore");
        map.put("Pune", "Delhi");
        map.put("Banglore", "Pune");
        map.put("Delhi", "Beed");

        String start = getStart(map);
        System.out.print(start);
        for (String key : map.keySet()) {
            System.out.print(" --> " + map.get(start));
            start = map.get(start);
        }

        System.out.println();

        /*
         * // Find all destinations
         * HashSet<String> destinations = new HashSet<>(map.values());
         * 
         * // Find starting city (source not in destinations)
         * String start = "";
         * for (String city : map.keySet()) {
         * if (!destinations.contains(city)) {
         * start = city;
         * break;
         * }
         * }
         * 
         * // Print itinerary
         * System.out.print(start);
         * while (map.containsKey(start)) {
         * String next = map.get(start);
         * System.out.print(" -> " + next);
         * start = next;
         * }
         * System.out.println(" -> END");
         */

    }
}
