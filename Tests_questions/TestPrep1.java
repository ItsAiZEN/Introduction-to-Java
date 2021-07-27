package Tests_questions;

public class TestPrep1 {
    public static void main(String[] args) {
//        System.out.println(oneFiveSeven(9));
        int[] a = {10, 16, 18, 40};
        int[] b = {0, 4, 6, 7, 11, 11};
        printClosest(a, b, 40);


    }


    public static int oneFiveSeven(int n) {
        return oneFiveSeven(n, 0);
    }

    public static int oneFiveSeven(int n, int sum) {
        if (n < 0)
            return Integer.MAX_VALUE;
        if (n == 0)
            return sum;

        return Math.min(oneFiveSeven(n - 1, sum + 1), Math.min(oneFiveSeven(n - 5, sum + 1), oneFiveSeven(n - 7, sum + 1)));
    }


    public static void printClosest(int[] a, int[] b, int x) {
        int sum;
        for (int i = 0, j = b.length - 1; i <= a.length - 1 && j >= 0; ) {
            if (i == a.length - 1 && j == 0) {
                System.out.println(a[i] + " and " + b[j]);
                return;
            } else if (i == a.length - 1 && Math.abs(a[i] + b[j - 1] - x) < Math.abs(a[i] + b[j] - x))
                j--;
            else if (i == a.length - 1 && Math.abs(a[i] + b[j - 1] - x) > Math.abs(a[i] + b[j] - x)) {
                System.out.println(a[i] + " and " + b[j]);
                return;
            } else if (j == 0 && Math.abs(a[i + 1] + b[j] - x) < Math.abs(a[i] + b[j] - x))
                i++;
            else if (j == 0 && Math.abs(a[i + 1] + b[j] - x) > Math.abs(a[i] + b[j] - x)) {
                System.out.println(a[i] + " and " + b[j]);
                return;
            } else {
                sum = a[i] + b[j];
                if (sum == x || Math.abs(a[i + 1] + b[j] - x) > Math.abs(sum - x) && Math.abs(a[i] + b[j - 1] - x) > Math.abs(sum - x)) {
                    System.out.println(a[i] + " and " + b[j]);
                    return;
                }
                if (Math.abs(a[i + 1] + b[j] - x) < Math.abs(a[i] + b[j - 1] - x))
                    i++;
                else
                    j--;
            }
        }
    }


}



