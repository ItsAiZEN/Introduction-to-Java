package Tests_questions;

public class Session10 {
    public static void main(String[] args) {
//        int[] a1 = {1, 12, 15, 26, 38};
//        int[] a2 = {12, 13, 18, 30, 45};
//        int[] a3 = {1, 2, 60};
//        int[] a4 = {7, 22, 35};
//        System.out.println(getMedian(a3, a4));
        B b1 = new B();
        A d3 = new D();
        A b2 = new C();
        C c1 = new C();
        System.out.println(((C)b2).equals(c1));
    }

    public static int getMedian(int[] a, int[] b) {
        int i, j, first = 0, second = 0;
        for (i = 0, j = 0; i + j < a.length; ) {
            if (i == a.length - 1)
                return ((a[a.length - 1] + b[0]) / 2);
            if (i == b.length - 1)
                return ((b[b.length - 1] + a[0]) / 2);
            if (a[i] <= b[j]) {
                first = a[i];
                i++;
            } else {
                first = b[j];
                j++;
            }
        }
        if (a[i] <= b[j])
            second = a[i];
        else
            second = b[j];
        return (first + second) / 2;
    }


}
