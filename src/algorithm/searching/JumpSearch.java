package algorithm.searching;

import algorithm.ErrorMessage;
import algorithm.sorting.MergeSort;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

/**
 * @author : Nguyen Trong TRUNG
 *
 * JumpSearch or Block Search
 * Strategy : Decrease-and-Conquer (Variable-size-decrease)
 * Worst case : O(sqrt(n))
 */
public class JumpSearch implements SearchAlgorithm{
    /**
     * array must be sorted increasingly
     */
    @Override
    public int search(int[] inputArray, int key, boolean isRecursive) {
        if(isRecursive) {
            return recursive(inputArray, key);
        } else {
            return nonRecursive(inputArray,key);
        }
    }

    private int recursive(int[] inputArray, int key) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    private int nonRecursive(int @NotNull [] array, int key){
        int N = array.length;
        int step = (int)Math.floor(Math.sqrt(N));

        int prev = 0;
        while(array[Math.min(step,N)-1]<key)
        {
            prev=step;
            step += (int)Math.floor(Math.sqrt(N));
            if(prev>=N)
                return ErrorMessage.NOT_FOUND_POSITION;
        }
        while (array[prev] < key)
        {
            prev++;
            if (prev == Math.min(step, N))
                return ErrorMessage.NOT_FOUND_POSITION;
        }

        if (array[prev] == key)
            return prev;

        return -1;
    }
}
