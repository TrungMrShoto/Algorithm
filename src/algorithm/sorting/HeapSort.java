package algorithm.sorting;

import algorithm.generalFuntion.GeneralFunction;
import org.jetbrains.annotations.NotNull;

/**
 * @author : Nguyen Trong TRUNG
 */
public class HeapSort implements SortingAlgorithm{
    @Override
    public void sort(int[] inputArray) {
        heapSort(inputArray);
    }

    private void heapSort(int @NotNull [] inputArray){
        int length = inputArray.length;
        //Step 1: heap construction
        int position = length/2-1;
        while(position>=0)
        {
            reHeapDown(inputArray, position,length-1);
            position--;
        }
        //Step 2 : maximum deletions
        int last = length-1;
        while(last>0)
        {
            GeneralFunction.swap(inputArray,0,last);
            last--;
            reHeapDown(inputArray,0,last-1);
        }
    }

    private void reHeapDown(int[] inputArray, int position, int lastPosition) {
        int leftChildPosition = position*2+1;
        int rightChildPosition = position*2+2;
        int child;
        //the left child of position exists
        if (leftChildPosition<=lastPosition)
        {
            //choose larger child to compare with data in position
            if (rightChildPosition<=lastPosition &&
                    inputArray[rightChildPosition]>inputArray[leftChildPosition])
                child = rightChildPosition;
            else
                child = leftChildPosition;
            if (inputArray[child]>inputArray[position])
            {
                GeneralFunction.swap(inputArray,child,position);
                reHeapDown(inputArray,child,lastPosition);
            }
        }

    }
}
