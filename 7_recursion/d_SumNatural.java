// ===================== Sum of Natural Numbers =====================
public class d_SumNatural {
    public static int sumOfnNum(int n) {
        if (n == 1)
            return 1;
        return n + sumOfnNum(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumOfnNum(3));
    }
}
