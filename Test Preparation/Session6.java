package Tests_questions;

public class Session6 {


    public static void main(String[] args) {
//        int[][] mat = {{4, 5, 6, 7, 1}, {3, 5, 1, 7, 4}, {4, 5, 6, 5, 8}, {3, 4, 7, 7, 9}, {6, 2, 2, 7, 6}};
//        int[][] mat1 = {{1, 55, 66}, {33, 11, 88}, {99, 101, 1000}};
//        System.out.println(maxSumKnight(mat));
        int [] a= {-2,3,5,7,12};
        System.out.println(sum3(a,17));

    }

    public static int maxSumKnight(int[][] mat) {
        int a = maxSumKnight(mat, 0, 0, mat[0][0]);
        if (a < -1)
            return -1;
        return a;
    }

    public static int maxSumKnight(int[][] mat, int i, int j, int prev) {
        int best = Integer.MIN_VALUE;
        int temp;
        if (i == mat.length - 1 && j == mat[0].length - 1)
            return mat[i][j];
        if (i >= 0 && i <= mat.length - 1 && j >= 0 && j <= mat[0].length - 1 && Math.abs(prev - mat[i][j]) < 2 && mat[i][j] != 0) {
            temp = mat[i][j];
            mat[i][j] = 0;
            best = Math.max(best, temp + maxSumKnight(mat, i - 2, j + 1, temp));
            best = Math.max(best, temp + maxSumKnight(mat, i - 1, j + 2, temp));
            best = Math.max(best, temp + maxSumKnight(mat, i + 1, j + 2, temp));
            best = Math.max(best, temp + maxSumKnight(mat, i + 2, j + 1, temp));
            best = Math.max(best, temp + maxSumKnight(mat, i + 2, j - 1, temp));
            best = Math.max(best, temp + maxSumKnight(mat, i + 1, j - 2, temp));
            best = Math.max(best, temp + maxSumKnight(mat, i - 1, j - 2, temp));
            best = Math.max(best, temp + maxSumKnight(mat, i - 2, j - 1, temp));
            mat[i][j] = temp;
            return best;
        }
        return Integer.MIN_VALUE;
    }
    public static boolean sum2(int[] a, int sum) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            if (a[i] + a[j] == sum)
                return true;
            else if (a[i] + a[j] < sum)
                i++;
            else
                j--;
        }
        return false;
    }

    public static boolean sum22(int[] a, int sum, int prev) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            if (a[i] + a[j] == sum && a[i] != prev && a[j] != prev)
                return true;
            else if (a[i] + a[j] < sum)
                i++;
            else
                j--;
        }
        return false;
    }

    public static boolean sum3(int[] a, int num) {
        for (int i = 0; i < a.length; i++) {
            if (sum22(a, num - a[i], a[i]))
                return true;
        }
        return false;
    }

//    public static int minimalPositive(Range[] rangeA) {
//
//
//    }

}
