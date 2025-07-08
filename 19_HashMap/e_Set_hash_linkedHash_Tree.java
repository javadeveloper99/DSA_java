
import java.util.*;

public class e_Set_hash_linkedHash_Tree {

    public static void hash_lhs() {
        HashSet<Integer> hs = new HashSet<>();

        hs.add(12);
        hs.add(122);
        hs.add(121);
        hs.add(1);

        Iterator<Integer> it = hs.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void linked_hash_lhs() {
        // doubly ordered LL
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();

        lhs.add(1);
        lhs.add(12);
        lhs.add(122);
        lhs.add(121);

        Iterator<Integer> it = lhs.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void tree_set() {
        // ordered asending order
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(1);
        ts.add(12);
        ts.add(122);
        ts.add(121);

        Iterator<Integer> it = ts.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        hash_lhs();
        linked_hash_lhs();
        tree_set();
    }
}
