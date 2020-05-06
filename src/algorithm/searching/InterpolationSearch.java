package algorithm.searching;

import algorithm.ErrorMessage;
import org.jetbrains.annotations.NotNull;

/**
 * @author : Nguyen Trong TRUNG
 *
 * Strategy : Decrease-and-Conquer (Variable-size-decrease)
 * Worst case : O(log log n)
 */
public class InterpolationSearch implements SearchAlgorithm{
    /**
     * array must be sorted increasingly
     */
    @Override
    public int search(int[] inputArray,int key,boolean isRecursive) {
        if(isRecursive)
            return recursive(inputArray,0,inputArray.length-1,key);
        else
            return nonRecursive(inputArray,key);
    }

    private int nonRecursive(int @NotNull [] array, int key){
        int low = 0;
        int high= array.length-1;
        int pos;
        while(array[low]!=array[high] && key >= array[low]&&key<=array[high]){
            pos = low + ((key-array[low])*(high-low)/(array[high]-array[low]));
            if(array[pos]<key)
                low = pos+1;
            else if (key<array[pos])
                high=pos-1;
            else
                return pos;
        }

        if (key==array[low])
            return low;
        else
            return ErrorMessage.NOT_FOUND_POSITION;
    }

    private int recursive(int @NotNull [] array, int low, int high, int key){
        if (array[low]!=array[high] && key >= array[low]&&key<=array[high]) {
            int pos = low + ((key - array[low]) * (high - low) / (array[high] - array[low]));
            if (array[pos] < key)
                return recursive(array, pos + 1, high, key);
            else if (key < array[pos])
                return recursive(array, low, pos - 1, key);
            else
                return pos;
        }
        else{
            if (key==array[low])
                return low;
            else
                return ErrorMessage.NOT_FOUND_POSITION;
        }
    }
}
