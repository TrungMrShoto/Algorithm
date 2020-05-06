package algorithm.searching;

import algorithm.ErrorMessage;

/**
 * @author : Nguyen Trong TRUNG
 *
 * Strategy : Decrease-and-Conquer (decrease-by-factor)
 * Best case: O(1)
 * Avarage case : approx log2 n in O(log2 n)
 * Worst case : floor(log2 n) + 1 = ceil(log2(n+1)) in O(log2 n)
 */
public class BinarySearch implements SearchAlgorithm{
    /**
     * array must be sorted increasingly
     */
    @Override
    public int search(int[] inputArray,int key, boolean isRecursive) {
        if (isRecursive)
            return recursive(inputArray,key,0,inputArray.length-1);
        else
            return nonRecursive(inputArray,key);

    }

    private int nonRecursive(int[] inputArray, int key)
    {
        int left = 0;
        int right = inputArray.length-1;
        int middle;
        while(left<right)
        {
            middle = (left+right)/2;
            if (inputArray[middle]==key) return middle;
            else if (key<inputArray[middle])
                right = middle-1;
            else
                left = middle + 1;
        }
        return ErrorMessage.NOT_FOUND_POSITION;
    }

    private int recursive(int[] inputArray, int key, int left, int right)
    {
        if (left>=right) return ErrorMessage.NOT_FOUND_POSITION;
        else {
            int middle = (left+right)/2;
            if (inputArray[middle]==key)
                return middle;
            else if (key<inputArray[middle])
                return recursive(inputArray,key,left,middle-1);
            else
                return recursive(inputArray,key,middle + 1, right);
        }
    }
}
