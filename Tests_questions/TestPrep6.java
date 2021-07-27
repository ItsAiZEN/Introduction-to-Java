package Tests_questions;

public class TestPrep6 {

    public static void main(String[] args) {
//        int[] a = {2, 5, 10, 20, 50};
//        System.out.println(makeSum(a, 40, 4));
        int[] a1 = {10, 4, 2, 5, 6, 3, 8, 1, 5, 9};
        minimumSubK(a1, 2);
    }

    public static int makeSum(int[] lengths, int k, int num) {
        return makeSum(lengths, k, num, 0);
    }


    public static int makeSum(int[] lengths, int k, int num, int i) {
        if (k == 0 && num >= 0)
            return 1;
        if (k < 0 || i > lengths.length - 1 || num < 0)
            return 0;
        return makeSum(lengths, k - lengths[i], num - 1, i) + makeSum(lengths, k, num, i + 1);
    }


    public static void minimumSubK(int[] arr, int k) {
        int best = 0;
        int curr = 0;
        int firstInd = 0;
        int lastInd = arr.length - 1;
        for (int i = 0; i < k; i++)
            curr += arr[i];
        best = curr;
        for (int i = 1, j = k; j < arr.length; i++, j++) {
            curr = curr - arr[i - 1] + arr[j];
            if (best > curr) {
                best = curr;
                firstInd = i;
                lastInd = j;
            }
        }
        System.out.print("Minimum sum sub-array is (" + firstInd + "," + lastInd + ")");
    }
}