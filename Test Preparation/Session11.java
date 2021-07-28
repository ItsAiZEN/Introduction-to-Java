package Tests_questions;

public class Session11 {

    public static void main(String[] args) {
        int[] arr = {-8, -7, -5, -3, -2, 5, 8};
        int[] arr1 = {-8, -7, -5, -3, -2, 7, 8};
        int[] arr2 = {-8, -7, -5, -3, -2, -1, 1};
        int[] arr3 = {-8, -7, 15, 23, 32, 37, 38};
        System.out.println(splitTo3(arr));
        System.out.println(splitTo3(arr1));
        System.out.println(splitTo3(arr2));
        System.out.println(splitTo3(arr3));

    }

    public static boolean splitTo3(int[] arr) {
        int i = 0, j = arr.length - 1, sum = 0, leftSum = arr[i], rightSum = 0;
        char change = 'a';
        for (int k = 0; k < arr.length; k++)
            sum += arr[k];
        while (i < j) {
            if (leftSum < 0 && rightSum > 0 && sum - leftSum - rightSum == 0)
                return true;
            if (change == 'i')
                leftSum += arr[i];
            else
                rightSum += arr[j];
            if (sum - leftSum - rightSum < 0) {
                i++;
                change = 'i';
            } else {
                j--;
                change = 'j';
            }
        }
        return false;
    }
}
