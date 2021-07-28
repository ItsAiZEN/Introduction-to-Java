package Tests_questions;

public class Session1 {


    public static int cntTrueReg(boolean[][] mat) {
        return cntTrueReg(mat, 0, 0, 0);
    }

    private static int cntTrueReg(boolean[][] mat, int i, int j, int count) {
        if (j < mat.length - 1)
            count += cntTrueReg(mat, i, j + 1, count);
        else if (i < mat.length - 1)
            cntTrueReg(mat, i + 1, 0, count);
        if (mat[i][j]) {
            cleanArea(mat, i, j);
            count++;
        }
        return count;
    }

    private static void cleanArea(boolean[][] mat, int i, int j) {
        if (i > mat.length || i < 0 || j > mat.length || j < 0 || !mat[i][j])
            return;
        if (mat[i][j]) {
            mat[i][j] = false;
            cleanArea(mat, i + 1, j);
            cleanArea(mat, i - 1, j);
            cleanArea(mat, i, j + 1);
            cleanArea(mat, i, j - 1);
        }
    }




}
