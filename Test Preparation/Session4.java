package Tests_questions;

public class Session4 {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 6, 7};
//        System.out.println(isPythagorean(arr));
        int[][] arr1 = {{1, 5, 7}, {3, 2, 9}, {1, 2, 3}};
        int[] arr2 = {7, 2, 3};
        System.out.println(covers(arr1, arr2, 2));
    }


    public static boolean isPythagorean(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = arr[i] * arr[i];
        int i, j;
        for (int k = 2; k < arr.length; k++) {
            i = 0;
            j = k - 1;
            while (i < j) {
                if (arr[i] + arr[j] == arr[k])
                    return true;
                else if (arr[i] + arr[j] < arr[k])
                    i++;
                else
                    j--;
            }
        }
        return false;
    }


    public static boolean covers(int[][] mat, int[] arr, int k) {
        return covers(mat, arr, k, 0);
    }

    public static boolean covers(int[][] mat, int[] arr, int k, int i) {
        if (i >= mat.length)
            return false;
        if (allZero(arr))
            return true;
        int[] temp = new int[mat[0].length];
        copy(temp, arr);
        if (k > 0) {
            xZero(arr, mat[i]);
            covers(mat, arr, k - 1, i + 1);
        }
        return covers(mat, temp, k, i + 1);
    }

    private static boolean allZero(int[] x) {
        for (int i = 0; i < x.length; i++)
            if (x[i] != 0)
                return false;
        return true;
    }

    private static void copy(int[] dest, int[] src) {
        for (int i = 0; i < dest.length; i++)
            dest[i] = src[i];
    }

    private static void xZero(int[] dest, int[] src) {
        for (int i = 0; i < dest.length; i++)
            for (int j = 0; j < src.length; j++)
                if (src[i] == dest[j])
                    dest[j] = 0;
    }


}


