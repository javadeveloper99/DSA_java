import java.util.*;

public class c_majority_number {

    public static void main(String[] args) {
        int num1[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };

        int num2[] = { 1, 2 };
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < num1.length; i++) {
            map.put(num1[i],map.getOrDefault(num1[i], 0)+1);
        }

        
        for (Integer key : map.keySet()) {
            if (map.get(key) >= num1.length / 3) {
                System.out.println(key);
            }
        }

    }
}
