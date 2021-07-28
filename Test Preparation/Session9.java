package Tests_questions;

public class Session9 {

    public static void main(String[] args) {
        int[] a = {0, 1, 3, 10, 9, 10, 17, 17, 20};
        System.out.println(findMaxPrice(a, a.length - 1));
    }

    public static int strictlyIncreasing(int[] a) {
        int count = 1;
        int total = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] > a[i])
                count++;
            else {
                total += (count * count - 1) / 2;
                count = 1;
            }
        }
        return total;
    }

    public static int findMaxPrice(int[] prices, int n) {
        return (findMaxPrice(prices, n, 0, 1));
    }

    public static int findMaxPrice(int[] prices, int n, int count, int i) {
        if (n == 0)
            return count;
        if (n < 0 || i > prices.length - 1)
            return Integer.MIN_VALUE;
        return Math.max(findMaxPrice(prices, n, count, i + 1), findMaxPrice(prices, n - i, count + prices[i], 1));
    }


}