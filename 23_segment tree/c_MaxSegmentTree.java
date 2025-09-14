public class c_MaxSegmentTree {
    static int[] tree;

    // Initialize tree array
    public static void init(int n) {
        tree = new int[4 * n];
    }

    // Build segment tree
    public static int buildMaxTree(int[] arr, int i, int si, int sj) {
        if (si == sj) {
            tree[i] = arr[si];
            return tree[i];
        }
        int mid = (si + sj) / 2;
        int left = buildMaxTree(arr, 2 * i + 1, si, mid);
        int right = buildMaxTree(arr, 2 * i + 2, mid + 1, sj);
        tree[i] = Math.max(left, right);
        return tree[i];
    }

    // Query maximum in range
    public static int queryMax(int i, int si, int sj, int qi, int qj) {
        // No overlap
        if (qj < si || qi > sj) {
            return Integer.MIN_VALUE;
        }
        // Complete overlap
        if (qi <= si && sj <= qj) {
            return tree[i];
        }
        // Partial overlap
        int mid = (si + sj) / 2;
        int left = queryMax(2 * i + 1, si, mid, qi, qj);
        int right = queryMax(2 * i + 2, mid + 1, sj, qi, qj);
        return Math.max(left, right);
    }

    // Update value at index
    public static void updateMax(int i, int si, int sj, int idx, int newVal) {
        if (idx < si || idx > sj) {
            return;
        }
        if (si == sj) {
            tree[i] = newVal;
            return;
        }
        int mid = (si + sj) / 2;
        updateMax(2 * i + 1, si, mid, idx, newVal);
        updateMax(2 * i + 2, mid + 1, sj, idx, newVal);
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 7, 9, 11};
        int n = arr.length;
        init(n);
        buildMaxTree(arr, 0, 0, n - 1);

        System.out.println("Max in range (1,4): " + queryMax(0, 0, n - 1, 1, 4)); // expected 9
        updateMax(0, 0, n - 1, 3, 15); // update arr[3] = 15
        System.out.println("Max in range (1,4) after update: " + queryMax(0, 0, n - 1, 1, 4)); // expected 15
    }
}
