package Tests_questions;

public class TestPrep7 {
    public static void main(String[] args) {
        int[] a = {4, 2, 3, 1};
        System.out.println(isSum(a, 0));
        System.out.println(isSum(a, 8));
        System.out.println(isSum(a, 9));
        System.out.println(isSum(a, 6));
        System.out.println(isSum(a, 1));
        System.out.println(isSum(a, 12));
    }


    public static boolean isSum(int[] a, int num) {
        return isSum(a, num, 0, 0);
    }


    public static boolean isSum(int[] a, int num, int i, int count) {
        if (num == 0 && count < 3)
            return true;
        if (count == 3 || num < 0 || i > a.length - 1)
            return false;
        return (isSum(a, num, i + 1, 0) || isSum(a, num - a[i], i + 1, count + 1));
    }

//    public int findMinDiff(String x, String y) {
//        int foundX = 0;
//        int foundY = 0;
//        int count = 0;
//        RestaurantListTwo ptr = _head;
//        while (ptr != null) {
//            if (ptr.getFood.equals(x))
//                foundX = count;
//            if (ptr.getFood.equals(y))
//                foundY = count;
//            ptr = ptr.getNext;
//            count++;
//        }
//        if (Math.abs(foundX - foundY) != 0)
//            return Math.abs(foundX - foundY);
//        return Integer.MAX_VALUE;
//    }


}
