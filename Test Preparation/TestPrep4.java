package Tests_questions;

public class TestPrep4 {

    public static void main(String[] args) {
        int[][] drm = {{2, 0, 1, 2, 3}, {2, 3, 5, 5, 4}, {8, -1, 6, 8, 7}, {3, 4, 7, 2, 4}, {2, 4, 3, 1, 2}};
        System.out.println(prince(drm, 0, 0));
    }


    public static int prince(int[][] drm, int i, int j) {
        int temp, road = drm.length * drm[0].length;
        if (drm[i][j] == -1)
            return 1;
        temp = drm[i][j];
        if (i < drm.length - 1 && checkValid(drm[i][j], drm[i + 1][j])) {
            drm[i][j] = -10;
            road = Math.min(road, 1 + prince(drm, i + 1, j));
            drm[i][j] = temp;
        }
        if (j < drm[0].length - 1 && checkValid(drm[i][j], drm[i][j + 1])) {
            drm[i][j] = -10;
            road = Math.min(road, 1 + prince(drm, i, j + 1));
            drm[i][j] = temp;
        }
        if (i > 0 && checkValid(drm[i][j], drm[i - 1][j])) {
            drm[i][j] = -10;
            road = Math.min(road, 1 + prince(drm, i - 1, j));
            drm[i][j] = temp;
        }
        if (j > 0 && checkValid(drm[i][j], drm[i][j - 1])) {
            drm[i][j] = -10;
            road = Math.min(road, 1 + prince(drm, i, j - 1));
            drm[i][j] = temp;
        }
        if (road < drm.length * drm[0].length)
            return road;
        return -1;
    }

    private static boolean checkValid(int current, int next) {
        if (Math.abs(current - next) < 2) return true;
        if (current - next == 2) return true;
        if (next == -1) return true;
        return false;
    }

}