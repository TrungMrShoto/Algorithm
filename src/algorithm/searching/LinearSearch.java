package algorithm.searching;

import org.jetbrains.annotations.NotNull;

/**
 * @author : Nguyen Trong TRUNG
 *
 * Strategy : Brute-Force
 * Basic operation: comparision
 *
 * n is the number of elements in input array,
 * Best case : O(1)
 * Avarage case : p(n+1)/2 + n(1-p) (p is the probability of a successful search
 * Worst case : O(n)
 */
public class LinearSearch implements SearchAlgorithm{

    @Override
    public int search(int[] inputArray,int key, boolean isRecursive) {
        if (isRecursive)
            return recursive(inputArray,key,0);
        else
            return nonRecursive(inputArray,key);

}

    private int nonRecursive(int @NotNull [] inputArray, int key)
    {
        int i = 0;
        while(i<inputArray.length && inputArray[i]!= key)
            i=i+1;
        if (i<inputArray.length)
            return i;
        else
            return -1;
    }

    private int recursive(int @NotNull [] inputArray, int key, int position)
    {
        if(position>=inputArray.length) return -1;
        if (inputArray[position]==key) return position;
        return recursive(inputArray,key,position+1);
    }
}
