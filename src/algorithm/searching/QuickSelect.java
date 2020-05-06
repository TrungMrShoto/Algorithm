package algorithm.searching;

import algorithm.ErrorMessage;
import algorithm.generalFuntion.GeneralFunction;

import java.util.Arrays;

/**
 * @author : Nguyen Trong TRUNG
 *
 * Stategy : Decrease-and-Conquer (Variable-Size-Decrease)
 * Worst case : n(n-1)/2 in O(n^2)
 */
public class QuickSelect{
    public int searchKthSmallestValue(int[] array,int k) {
        if (k<=0 || k>array.length)
            return ErrorMessage.WRONG_POSITION;
        int[] tempArray = Arrays.copyOf(array,array.length);
        return quickSelect(tempArray, 0,tempArray.length-1,k);
    }

    /**
     * Find the kth smallest element in array
     */
    private int quickSelect(int[] array, int left, int right, int k){
        int position = lomutoPartition(array);
        int[] temp;
        if (position==k-1)
            return array[position];
        else if (position>left+k-1)
        {
            temp = Arrays.copyOfRange(array,left,position);
            return quickSelect(temp,left,position-1,k);
        }

        else{
            temp = Arrays.copyOfRange(array,position+1,right+1);
            return quickSelect(temp,position+1,right,k - 1 - position);
        }
    }

    private int lomutoPartition(int[] array) {
        int pivot = array[0];
        int position = 0;
        for (int i = 1; i < array.length; i++)
            if (array[i] < pivot) {
                position++;
                GeneralFunction.swap(array, position, i);
            }
        GeneralFunction.swap(array, 0, position);
        return position;
    }
}
