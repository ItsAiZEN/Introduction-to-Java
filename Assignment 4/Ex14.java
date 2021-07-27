package Maman14;

/**
 * @author Nir Eizenman
 * @version 4/1/2021
 */
public class Ex14 {

    /**
     * This method will check in an array with number that repeat twice each, which number does not repeat twice.
     * Due to the fact that with every loop we only check half of the size of the array that we checked in the previous loop,
     * the time complexity is O(log2n) (or simplified: O(log n)), the space complexity is O(1) because it only sets a set finite amount of variables with no relation to n.
     *
     * @param a the array
     * @return the number that is not repeated twice
     */
    public static int findSingle(int[] a) {
        int first = 0;
        int last = a.length - 1;
        int mid = (first + last) / 2; // calculate the middle index of the array
        while (last - first > 2) { // keep looping until the array is no longer a size larger than 3
            if ((a[mid - 1] != a[mid]) && (a[mid] != a[mid + 1])) // if both sized of the middle are not equals to it the number is the middle one
                return a[mid];
            if (((last - first + 1) / 2) % 2 == 1) { // go this way if each size of the array is odd sized when split (the middle is not included)
                if (a[mid] == a[mid + 1]) // go this way if the number to the right of the middle equals to the middle
                    last = mid - 1;
                else
                    first = mid + 1;
            } else if (((last - first + 1) / 2) % 2 == 0) { // go this way if each size of the array is even sized when split (the middle is not included)
                if (a[mid] == a[mid + 1]) // go this way of the number to the right of the middle equals to the middle
                    first = mid;
                else
                    last = mid;
            }
            mid = (first + last) / 2; // recalculate the middle index of the array with each loop
        }
        if (last - first == 0) // if the array is the size of 1, return the number in the array
            return a[first];
        if (a[mid] == a[mid + 1]) // if we got here the array is the size of three, therefore check if the number is in the left of the array
            return a[mid - 1];
        else return a[mid + 1]; // the number is in the right of the array
    }

    /**
     * This method check the size of the smallest sub-array that exceeds a given number, if such a sub-array does not exist
     * returns -1
     * Due to the fact the within every loop the algorithm goes through one slot of the array it will go through a max of n iterations.
     * Within each iteration the algorithm will try to shorten the sub-array found (if found), in the worse possible option
     * it will be from n size to the size of 2 and by then we are going through n twice, plus once at the start therefore the time complexity is O(n),
     * the space complexity is O(1) because it only sets a set finite amount of variables with no relation to n.
     *
     * @param arr the array given
     * @param x   the sum we are looking to exceed
     * @return the size of the smallest sub-array that exceeds a given number
     */
    public static int smallestSubSum(int arr[], int x) {
        int currentSize = 0;
        int currentSum = 0;
        int bestSize = arr.length;
        int arraySum = 0;
        for (int k = 0; k < arr.length; k++) // calculate the sum of the total array
            arraySum += arr[k];
        if (arraySum <= x) // if the total sum of the array is smaller than the sum the algorithm looks for, return -1
            return -1;
        for (int i = 0; i < arr.length; i++) { // a loop that goes through the given array
            if (arr[i] > x) // if the current slot if bigger than the sum that the algorithm is looking for return size 1
                return 1;
            currentSum += arr[i]; // add to the sum of the calculated sub-array the current slot
            currentSize++; // increase the calculated size of the sub-array by 1
            if (bestSize < arr.length) { // if we found a sub-array already keep looking only through that amount of slots
                currentSum -= arr[i - currentSize + 1]; // remove the slot that is now outside the sub-array
                currentSize--;
            }
            for (int j = currentSize - 1; currentSum > x; j--) { // if the sub-array the algorithm looks at is larger than the sum it looks for go into this loop
                currentSum -= arr[i - j]; // try to remove slots from the sub-array and check if it will still be larger the the given sum
                currentSize--;
                bestSize = Math.min(currentSize, bestSize); // set the smallest sub-array size as the best size
                if ((currentSum - arr[i - j + 1]) <= x) // check if we need to break the loop if the sub-array is already too small for an other decrease in size
                    break;
            }
        }
        return bestSize; // return the smallest size found
    }


    /**
     * This method calculates the amount of solutions to an equation between 3 variables (0<x<11) and a given sum.
     *
     * @param num the sum we need to calculate the number of solutions to
     * @return returns the number of solutions of 3 variables between 1 to 10 to the given sum, if there are no solutions
     * it will return 0.
     */
    public static int solutions(int num) {
        if (num > 30 || num < 3) // if the num is out of the restrictions return 0
            return 0;
        return solutions(num, 1, 1, 1, 0); // call to the recursive method
    }

    /**
     * This method calculates the amount of solutions to an equation with 3 variables that equals to a given number,
     * the method will also print all the solutions.
     *
     * @param num   the sum to reach in the equation
     * @param x1    the first variable of the equation
     * @param x2    the second variable of the equation
     * @param x3    the third variable of the equation
     * @param count the amount of solutions
     * @return the amount of solutions to the equations when each variable is bigger than 0.
     */
    private static int solutions(int num, int x1, int x2, int x3, int count) {
        if ((x1 < num - 1) && (x2 < num - 1) && (x3 < num - 1)) { // if the sum of the 3 variable is too small go here
            if (x3 < num - 2 && x3 < 10) // if the third variable is too small call the function again and increase the variable by 1
                count += solutions(num, x1, x2, x3 + 1, count);
            else if (x2 < num - 2 && x2 < 10) // if the second variable is too small call the function again and increase the variable by 1
                count += solutions(num, x1, x2 + 1, 1, count);
            else if (x1 < num - 2 && x1 < 10)// if the first variable is too small call the function again and increase the variable by 1
                count += solutions(num, x1 + 1, 1, 1, count);
        }
        if (((x1 + x2 + x3) == num) && (x1 < num - 1) && (x2 < num - 1) && (x3 < num - 1)) { // if the equation is equal in both sides, print to solution and increase the solutions count
            System.out.println(x3 + " + " + x2 + " + " + x1 + " = " + num);
            count++;
        }
        return count; // return the amount of solutions
    }

    /**
     * This method searches through a boolean array for separated groups of "true"s and returns the amount it finds
     *
     * @param mat the boolean array to search through
     * @return the amount of separated groups inside the array
     */
    public static int cntTrueReg(boolean[][] mat) {

        return cntTrueReg(mat, 0, 0, 0); // call the recursive function in the top left of the array and count of 0
    }

    /**
     * This method searches through a boolean array for separated groups of "true"s and returns the amount it finds
     *
     * @param mat        the boolean array to search through
     * @param i          the index of the rows
     * @param j          the index of the columns
     * @param totalCount the amount of separated groups found
     * @return the amount of separated groups inside the array
     */
    private static int cntTrueReg(boolean[][] mat, int i, int j, int totalCount) {

        if (j < mat[i].length - 1)
            totalCount += cntTrueReg(mat, i, j + 1, totalCount); // go through the columns of the array
        else if (i < mat.length - 1)
            totalCount += cntTrueReg(mat, i + 1, 0, totalCount); // go through the rows of the array

        if (mat[i][j]) { // check if the current slot in the array is "true"
            removeGroup(mat, i, j); // "remove" (turn all the connected "true"s into "false"s) the found group from the array
            totalCount++; // increase the count of found groups by 1
        }
        return totalCount; // return the amount of found groups
    }

    /**
     * This methods searches for connected groups of "true"s and turns them into "false"s
     *
     * @param mat the boolean array to search through
     * @param i   i the index of the rows
     * @param j   j the index of the columns
     */
    private static void removeGroup(boolean[][] mat, int i, int j) {
        mat[i][j] = false; // turn the current slot in the array into "false"
        if (i > 0 && mat[i - 1][j]) // try to go down
            removeGroup(mat, i - 1, j);
        if (i < mat.length - 1 && mat[i + 1][j]) // try to go up
            removeGroup(mat, i + 1, j);
        if (j > 0 && mat[i][j - 1]) // try to go left
            removeGroup(mat, i, j - 1);
        if (j < mat[i].length - 1 && mat[i][j + 1]) // try to go right
            removeGroup(mat, i, j + 1);
    }
}