import java.util.*;

public class e_ropes {

    public static int NRopes(int ropes[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int rope : ropes) {
            pq.add(rope);
        }

        int totCost = 0;

        while (pq.size() > 1) {
            int first = pq.remove();
            int second = pq.remove();

            int cost = first + second;
            totCost += cost;

            pq.add(cost);

        }

        return totCost;

    }

    public static void main(String[] args) {
        int ropes[] = { 4, 3, 2, 6 };

        int totCost = NRopes(ropes);

        System.out.println("Total minimum cost for CONNECTING  Ropes is : " + totCost);

    }
}
