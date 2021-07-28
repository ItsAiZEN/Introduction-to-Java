package Tests_questions;

public class Session12 {

    public static void main(String[] args) {
        char[][] arr1 = {{'t', 'z', 'x', 'c', 'd'},
                {'s', 'h', 'a', 'z', 'x'},
                {'h', 'w', 'l', 'o', 'm'},
                {'o', 'r', 'n', 't', 'n'},
                {'a', 'b', 'r', 'i', 'n'}};
        String word = "shalom";
        findWord(arr1, word);
    }

    public static void findWord(char[][] arr, String word) {
        int[][] newArr = new int[arr.length][arr[0].length];
        findWord1(arr, word, newArr, 0, 0);
    }


    public static void findWord1(char[][] arr, String word, int[][] newArr, int i, int j) {
        if (j < arr[i].length) {
            findWord(arr, word, newArr, 0, i, j);
            findWord1(arr, word, newArr, i, j + 1);
        } else if (i < arr.length - 1)
            findWord1(arr, word, newArr, i + 1, 0);
    }

    public static void findWord(char[][] arr, String word, int[][] newArr, int charInd, int i, int j) {
        char temp;
        if (i < 0 || j < 0 || i > arr.length - 1 || j > arr[i].length - 1 || arr[i][j] == 'W')
            return;
        if (charInd == word.length()) {
            printArr(newArr);
            return;
        }
        if (arr[i][j] == word.charAt(charInd)) {
            newArr[i][j] = charInd + 1;
            temp = arr[i][j];
            arr[i][j] = 'W';
            findWord(arr, word, newArr, charInd + 1, i + 1, j);
            findWord(arr, word, newArr, charInd + 1, i - 1, j);
            findWord(arr, word, newArr, charInd + 1, i, j + 1);
            findWord(arr, word, newArr, charInd + 1, i, j - 1);
            arr[i][j] = temp;
            newArr[i][j] = 0;
        }
    }

    private static void printArr(int[][] newArr) {
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr[i].length; j++)
                System.out.print(newArr[i][j] + " ");
            System.out.println();
        }
    }
}
