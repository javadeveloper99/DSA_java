public class b_MinSegmentTree {
    static int[] tree;

    // Initialize tree array
    public static void init(int n) {
        tree = new int[4 * n];
    }

    // Build segment tree
    public static int buildMinTree(int[] arr, int i, int si, int sj) {
        if (si == sj) {
            tree[i] = arr[si];
            return tree[i];
        }
        int mid = (si + sj) / 2;
        int left = buildMinTree(arr, 2 * i + 1, si, mid);
        int right = buildMinTree(arr, 2 * i + 2, mid + 1, sj);
        tree[i] = Math.min(left, right);
        return tree[i];
    }

    // Query minimum in range
    public static int queryMin(int i, int si, int sj, int qi, int qj) {
        // No overlap
        if (qj < si || qi > sj) {
            return Integer.MAX_VALUE;
        }
        // Complete overlap
        if (qi <= si && sj <= qj) {
            return tree[i];
        }
        // Partial overlap
        int mid = (si + sj) / 2;
        int left = queryMin(2 * i + 1, si, mid, qi, qj);
        int right = queryMin(2 * i + 2, mid + 1, sj, qi, qj);
        return Math.min(left, right);
    }

    // Update value at index
    public static void updateMin(int i, int si, int sj, int idx, int newVal) {
        if (idx < si || idx > sj) {
            return;
        }
        if (si == sj) {
            tree[i] = newVal;
            return;
        }
        int mid = (si + sj) / 2;
        updateMin(2 * i + 1, si, mid, idx, newVal);
        updateMin(2 * i + 2, mid + 1, sj, idx, newVal);
        tree[i] = Math.min(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 7, 9, 11 };
        int n = arr.length;
        init(n);
        buildMinTree(arr, 0, 0, n - 1);

        System.out.println("Min in range (1,4): " + queryMin(0, 0, n - 1, 1, 4)); // expected 2
        updateMin(0, 0, n - 1, 2, 0); // update arr[2] = 0
        System.out.println("Min in range (1,4) after update: " + queryMin(0, 0, n - 1, 1, 4)); // expected 0
    }
}
