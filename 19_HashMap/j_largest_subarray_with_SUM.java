import java.util.*;

public class j_largest_subarray_with_SUM {
    public static void zeroSum() {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10 };

        // prefix sum
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxLen = i + 1;
            }

            // Case 2: If this sum was seen before
            if (map.containsKey(sum)) {

                // So, elements between that index+1 to i have zero sum
                int prevIndex = map.get(sum);
                int length = i - prevIndex;
                if (length > maxLen) {
                    maxLen = length;
                }
            } else {
                // First time we are seeing this sum, store index
                map.put(sum, i);
            }
        }

        System.out.println("Largest subarray with 0 sum length: " + maxLen);
    }

    public static void kSum(int k) {
    int arr[] = { 15, -2, 2, -8, 1, 7, 10 };

    HashMap<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int count = 0;

    for (int i = 0; i < arr.length; i++) {
        sum += arr[i];

        
        if (sum == k) {
            count++;
        }

        // Case 2: Check if sum - k exists
        if (map.containsKey(sum - k)) {
            count += map.get(sum - k);
        }

        // Update frequency of current sum
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    System.out.println("Total subarrays with sum " + k + " = " + count);
}


    public static void main(String[] args) {
        zeroSum();
        kSum(3);

    }
}
