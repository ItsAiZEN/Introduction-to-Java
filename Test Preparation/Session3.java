package Tests_questions;

public class Session3 {

    public static void main(String[] args) {
//        System.out.println(ways(0,0));
        int[] a = {7, 8, 1, 2, 3, 4, 5, 6};
        System.out.println(findSum(a, 10));
    }

    public static int ways(int k, int n) {
        if (k == 0 && n == 0)
            return 1;
        if (k == 0 && n != 0)
            return 0;
        return ways(k - 1, n - 1) + ways(k - 1, n + 1);
    }

    public static boolean findSum(int[] a, int sum) {
        int devi = findDevi(a);
        int i = 0;
        int j = a.length-1;
        while(i<j) {
            if(getNum(a,devi,i)+getNum(a,devi,j) == sum)
                return true;
            else if (getNum(a,devi,i)+getNum(a,devi,j) < sum)
                i++;
            else
                j--;
        }
        return false;
    }


    private static int findDevi(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1])
                return i+1;
        }
        return 0;
    }

    private static int getNum(int []a, int devi, int i){
        if(i+ devi < a.length)
            return a[i+devi];
        else
            return a[devi + i - a.length];
    }

}
