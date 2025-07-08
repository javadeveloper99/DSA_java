//distinct -> unique

import java.util.*;

public class f_count_distinct_elements {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };

        // Using HashSet instead of LinkedHashSet if order doesn't matter.
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        System.out.println(set.size());
    }
}
